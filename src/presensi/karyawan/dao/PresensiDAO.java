/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presensi.karyawan.dao;

import com.googlecode.javacv.cpp.opencv_contrib;
import static com.googlecode.javacv.cpp.opencv_contrib.createEigenFaceRecognizer;
import com.googlecode.javacv.cpp.opencv_core;
import static com.googlecode.javacv.cpp.opencv_core.IPL_DEPTH_8U;
import static com.googlecode.javacv.cpp.opencv_highgui.cvLoadImage;
import static com.googlecode.javacv.cpp.opencv_imgproc.CV_BGR2GRAY;
import static com.googlecode.javacv.cpp.opencv_imgproc.cvCvtColor;
import java.io.File;
import java.io.FilenameFilter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import presensi.karyawan.config.Config;
import presensi.karyawan.model.PresensiModel;

/**
 *
 * @author neet
 */
public class PresensiDAO implements ImplementPresensi{
    Config db = new Config();
    private List<PresensiModel> list;
    public static ArrayList<String> idPresensi = new ArrayList<String>();
    
    @Override
    public Boolean insert(PresensiModel pmo) {
        try (Connection conn = db.getConnection()) {
            //insert presensi
            PreparedStatement ps = conn.prepareStatement("INSERT INTO r_absensi VALUES(?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, null);
            ps.setInt(2, pmo.getUserId());
            ps.setString(3, pmo.getFotoMasuk());
            ps.setString(4, pmo.getFotoPulang());
            ps.setString(5, pmo.getTanggal());
            ps.setString(6, pmo.getJamMasuk());
            ps.setString(7, pmo.getJamKeluar());
            ps.setString(8, pmo.getKeterangan());
            
            if( ps.executeUpdate() == 1){
//                JOptionPane.showMessageDialog(null, "Anda berhasil presensi !");
                return true;
            }
            
        }catch (SQLException ex) {
            Logger.getLogger(KaryawanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public String recognizer(String dirName,String person) {
        String trainingDir = "src/presensi/assets/datasets";
        System.out.println("test" + "src/presensi/assets/presensi/"+dirName+"/"+person);
        opencv_core.IplImage testImage = cvLoadImage("src/presensi/assets/presensi/"+dirName+"/"+person);

        File root = new File(trainingDir);
        FilenameFilter pngFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".jpg");
            }
        };

        File[] imageFiles = root.listFiles(pngFilter);
        opencv_core.MatVector images = new opencv_core.MatVector(imageFiles.length);

        int[] labels = new int[imageFiles.length];
        int counter = 0;
        int label;

        opencv_core.IplImage img;
        opencv_core.IplImage grayImg;

        for (File image : imageFiles) {
            img = cvLoadImage(image.getAbsolutePath());

            label = Integer.parseInt(image.getName().split("\\-")[0]);
            grayImg = opencv_core.IplImage.create(252, 252, IPL_DEPTH_8U, 1);
            cvCvtColor(img, grayImg, CV_BGR2GRAY);

            images.put(counter, grayImg);
            labels[counter] = label;

            counter++;
        }

        opencv_core.IplImage greyTestImage = opencv_core.IplImage.create(testImage.width(), testImage.height(), IPL_DEPTH_8U, 1);

        //FaceRecognizer faceRecognizer = createFisherFaceRecognizer();
        opencv_contrib.FaceRecognizer faceRecognizer = createEigenFaceRecognizer();
        // FaceRecognizer faceRecognizer = createLBPHFaceRecognizer()

        faceRecognizer.train(images, labels);
        int n[] = new int[1];
        double p[] = new double[1];

        cvCvtColor(testImage, greyTestImage, CV_BGR2GRAY);
        faceRecognizer.predict(greyTestImage,n,p);
        
        int predictedLabel = n[0];
        double confidence = p[0];
        
        String res = "";
        if(confidence < 6000 && predictedLabel != 1){
            res = "valid|"+predictedLabel+"|"+confidence;
//            System.out.println("Predicted label: " + predictedLabel+" | conf: "+ confidence);
        }
        else if (confidence >= 7000 && confidence <= 9000 && predictedLabel != 1){
            res = "possible|"+predictedLabel+"|"+confidence;
//            System.out.println("perlu cek manual: " + predictedLabel+" | conf: "+ confidence);
        }
        else{
            res = "invalid|"+predictedLabel+"|"+confidence;
//            System.out.println("wajah sama sekali tidak dikenal"+" | conf: "+ confidence);
        }
        
        return res;
    }
    
}
