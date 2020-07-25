/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendaftaran.ktp;

import java.awt.Component;
import java.awt.event.KeyEvent;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import pendaftaran.ktp.config.Config;
import pendaftaran.ktp.model.dao.*;
import pendaftaran.ktp.model.*;

/**
 *
 * @author kalfian
 */
public class PanelForm extends javax.swing.JPanel {

    /**
     * Creates new form PanelForm
     */
    Config db = new Config();
    private ArrayList<String> listKec,listAgama,listKelurahan;
    private final ImplementKecamatan implementKecamatan;
    private final ImplementAgama implementAgama;
    private final ImplementKelurahan implementKelurahan;
    private final ImplementPendaftaran implementPendaftaran;
    
    public PanelForm() {
        initComponents();
        implementKecamatan = new KecamatanDAO();
        implementAgama = new AgamaDAO();
        implementKelurahan = new KelurahanDAO();
        implementPendaftaran = new PendaftaranDAO();
        
        listKec = implementKecamatan.getKecamatan();
        listAgama = implementAgama.getAgama();
        listKelurahan = implementKelurahan.getKelurahan(1);
        
        selKecamatan.setModel(new DefaultComboBoxModel<String>(listKec.toArray(new String[0])));
        selAgama.setModel(new DefaultComboBoxModel<String>(listAgama.toArray(new String[0])));
        selKelurahan.setModel(new DefaultComboBoxModel<String>(listKelurahan.toArray(new String[0])));
        
        /*ArrayList<String> names=new ArrayList<String>();   
        names.add("woi");
        selKecamatan.setModel(new DefaultComboBoxModel<String>(names.toArray(new String[0])));*/
    }
    
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (!((c >= '0') && (c <= '9') ||
            (c == KeyEvent.VK_BACK_SPACE) ||
            (c == KeyEvent.VK_DELETE))) {
            getToolkit().beep();
            e.consume();
        }
    }
    
    public void clearAllInput(){
        for(Component control : jPanel2.getComponents())
        {
            if(control instanceof JTextField)
            {
                JTextField ctrl = (JTextField) control;
                ctrl.setText("");
            }
            else if (control instanceof JComboBox)
            {
                JComboBox ctr = (JComboBox) control;
                ctr.setSelectedIndex(0);
            }
        }
        
        for(Component control : jPanel3.getComponents())
        {
            if(control instanceof JTextField)
            {
                JTextField ctrl = (JTextField) control;
                ctrl.setText("");
            }
            else if (control instanceof JComboBox)
            {
                JComboBox ctr = (JComboBox) control;
                ctr.setSelectedIndex(0);
            }
        }
        buttonGroup1.clearSelection();
        buttonGroup2.clearSelection();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        rdKawin = new javax.swing.JRadioButton();
        rdBelum = new javax.swing.JRadioButton();
        rdCerai = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        selAgama = new javax.swing.JComboBox<String>();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTmpLahir = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtNomorKK = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        rdLaki = new javax.swing.JRadioButton();
        rdPerempuan = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        rdO = new javax.swing.JRadioButton();
        rdA = new javax.swing.JRadioButton();
        rdB = new javax.swing.JRadioButton();
        rdAB = new javax.swing.JRadioButton();
        txtTglLahir = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        selKecamatan = new javax.swing.JComboBox<String>();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAlamat = new javax.swing.JTextPane();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        selKelurahan = new javax.swing.JComboBox<String>();
        jLabel11 = new javax.swing.JLabel();
        rdWNI = new javax.swing.JRadioButton();
        rdWNA = new javax.swing.JRadioButton();
        btnCap = new javax.swing.JToggleButton();
        txtPekerjaan = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jToggleButton2 = new javax.swing.JToggleButton();
        btnSimpan = new javax.swing.JToggleButton();
        jLabel14 = new javax.swing.JLabel();
        txtRT = new javax.swing.JTextField();
        txtRW = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        buttonGroup1.add(rdKawin);
        rdKawin.setText("Kawin");

        buttonGroup1.add(rdBelum);
        rdBelum.setText("Belum Kawin");

        buttonGroup1.add(rdCerai);
        rdCerai.setText("Cerai");

        jLabel5.setText("Status Perkawinan");

        selAgama.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Agama");

        jLabel4.setText("Tanggal Lahir");

        jLabel2.setText("Tempat Lahir");

        jLabel3.setText("Nama");

        jLabel12.setText("Nomor KK");

        txtNomorKK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomorKKKeyTyped(evt);
            }
        });

        jLabel13.setText("Jenis Kelamin");

        buttonGroup3.add(rdLaki);
        rdLaki.setText("Laki - Laki");

        buttonGroup3.add(rdPerempuan);
        rdPerempuan.setText("Perempuan");

        jLabel16.setText("Golongan Darah");

        buttonGroup4.add(rdO);
        rdO.setText("O");

        buttonGroup4.add(rdA);
        rdA.setText("A");

        buttonGroup4.add(rdB);
        rdB.setText("B");

        buttonGroup4.add(rdAB);
        rdAB.setText("AB");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selAgama, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNama)
                    .addComponent(txtTmpLahir, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNomorKK, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rdLaki)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdPerempuan))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rdKawin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdBelum)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdCerai))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rdO)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdA)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdAB)))
                        .addGap(0, 450, Short.MAX_VALUE))
                    .addComponent(txtTglLahir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomorKK, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTmpLahir, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTglLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(selAgama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdKawin)
                    .addComponent(rdBelum)
                    .addComponent(rdCerai))
                .addGap(12, 12, 12)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdLaki)
                    .addComponent(rdPerempuan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdO)
                    .addComponent(rdA)
                    .addComponent(rdB)
                    .addComponent(rdAB))
                .addContainerGap(138, Short.MAX_VALUE))
        );

        add(jPanel2);

        selKecamatan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        selKecamatan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                selKecamatanItemStateChanged(evt);
            }
        });

        jLabel9.setText("Kecamatan");

        jScrollPane1.setViewportView(txtAlamat);

        jLabel8.setText("Alamat Rumah");

        jLabel10.setText("Kelurahan");

        selKelurahan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setText("Kewarganegaraan");

        buttonGroup2.add(rdWNI);
        rdWNI.setText("WNI");

        buttonGroup2.add(rdWNA);
        rdWNA.setText("WNA");

        btnCap.setBackground(new java.awt.Color(102, 204, 255));
        btnCap.setText("Ambil Foto");
        btnCap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapActionPerformed(evt);
            }
        });

        jLabel7.setText("Pekerjaan");

        jToggleButton2.setBackground(new java.awt.Color(255, 255, 255));
        jToggleButton2.setForeground(new java.awt.Color(102, 204, 255));
        jToggleButton2.setText("Batal");

        btnSimpan.setBackground(new java.awt.Color(51, 153, 255));
        btnSimpan.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        jLabel14.setText("RT");

        jLabel15.setText("RW");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(txtPekerjaan)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addComponent(selKecamatan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(selKelurahan, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtRT)
                    .addComponent(txtRW)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(rdWNI)
                                .addGap(18, 18, 18)
                                .addComponent(rdWNA))
                            .addComponent(btnCap, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPekerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRT, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRW, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selKecamatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selKelurahan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdWNI)
                    .addComponent(rdWNA))
                .addGap(33, 33, 33)
                .addComponent(btnCap)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        add(jPanel3);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapActionPerformed
        Snapshot sp = new Snapshot();
        sp.setVisible(true);
        sp.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }//GEN-LAST:event_btnCapActionPerformed

    private void selKecamatanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_selKecamatanItemStateChanged
        // TODO add your handling code here:
        int kecIdx = selKecamatan.getSelectedIndex();
        String idKec = new KecamatanDAO().idKecamatan.get(kecIdx);
        listKelurahan = implementKelurahan.getKelurahan(parseInt(idKec));
        selKelurahan.setModel(new DefaultComboBoxModel<String>(listKelurahan.toArray(new String[0])));
    }//GEN-LAST:event_selKecamatanItemStateChanged

    private void txtNomorKKKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomorKKKeyTyped
        // TODO add your handling code here:
        keyTyped(evt);
    }//GEN-LAST:event_txtNomorKKKeyTyped

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        SnapshotModel sm = new SnapshotModel();
        PendaftaranModel pm = new PendaftaranModel();
        pm.setNomorKK(txtNomorKK.getText());
        pm.setNama(txtNama.getText());
        pm.setTempatLahir(txtTmpLahir.getText());
        
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(txtTglLahir.getDate());
        pm.setTanggalLahir(date);
        
        String jk = "";
        if(rdLaki.isSelected()){
            jk = "Laki - Laki";
        }else{
            jk = "Perempuan";
        }
        pm.setJk(jk);
        
        String golDarah = "";
        if (rdA.isSelected()) {
            golDarah = "A";
        }else if(rdB.isSelected()){
            golDarah = "B";
        }else if(rdO.isSelected()){
            golDarah = "O";
        }else{
            golDarah = "AB";
        }
        pm.setGolDarah(golDarah);
        
        String idAgama = new AgamaDAO().idAgama.get(selAgama.getSelectedIndex());
        pm.setIdAgama(parseInt(idAgama));
        String statusKawin = "kawin";
        if(rdBelum.isSelected()){
            statusKawin = "belum kawin";
        }
        if(rdCerai.isSelected()){
            statusKawin = "cerai";
        }
        pm.setStatusPerkawinan(statusKawin);
        pm.setPekerjaan(txtPekerjaan.getText());
        pm.setAlamat(txtAlamat.getText());
        pm.setRT(txtRT.getText());
        pm.setRW(txtRW.getText());
        
        String idKelurahan = new KelurahanDAO().IdKelurahan.get(selKelurahan.getSelectedIndex());
        
        Random rand = new Random();
        int randomNum = rand.nextInt((9999 - 1000) + 1) + 100;
        pm.setKodePendaftaran(idKelurahan+""+randomNum);
        
        pm.setIdKelurahan(parseInt(idKelurahan));
        
        String WN = "WNI";
        if(rdWNA.isSelected()){
            WN = "WNA";
        }
        pm.setKewarganegaraan(WN);
        pm.setImage(sm.getImg());
        implementPendaftaran.insert(pm);
        clearAllInput();
    }//GEN-LAST:event_btnSimpanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnCap;
    private javax.swing.JToggleButton btnSimpan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JRadioButton rdA;
    private javax.swing.JRadioButton rdAB;
    private javax.swing.JRadioButton rdB;
    private javax.swing.JRadioButton rdBelum;
    private javax.swing.JRadioButton rdCerai;
    private javax.swing.JRadioButton rdKawin;
    private javax.swing.JRadioButton rdLaki;
    private javax.swing.JRadioButton rdO;
    private javax.swing.JRadioButton rdPerempuan;
    private javax.swing.JRadioButton rdWNA;
    private javax.swing.JRadioButton rdWNI;
    private javax.swing.JComboBox<String> selAgama;
    private javax.swing.JComboBox<String> selKecamatan;
    private javax.swing.JComboBox<String> selKelurahan;
    private javax.swing.JTextPane txtAlamat;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNomorKK;
    private javax.swing.JTextField txtPekerjaan;
    private javax.swing.JTextField txtRT;
    private javax.swing.JTextField txtRW;
    private com.toedter.calendar.JDateChooser txtTglLahir;
    private javax.swing.JTextField txtTmpLahir;
    // End of variables declaration//GEN-END:variables
}
