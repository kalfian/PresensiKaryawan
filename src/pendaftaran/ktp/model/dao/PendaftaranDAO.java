/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendaftaran.ktp.model.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import pendaftaran.ktp.config.Config;
import pendaftaran.ktp.model.PendaftaranModel;
import java.util.logging.Logger;
import java.util.logging.Level;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author neet
 */
public class PendaftaranDAO implements ImplementPendaftaran {
    Config db = new Config();
    private static String imgPrint = "";
    private List<PendaftaranModel> list;
    
    @Override
    public void insert(PendaftaranModel pm) {
        try (Connection conn = db.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO pendaftaran VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, null);
            ps.setInt(2, pm.getIdKelurahan());
            ps.setInt(3, pm.getIdAgama());
            ps.setString(4, pm.getKodePendaftaran());
            ps.setString(5, pm.getNomorKK());
            ps.setString(6, pm.getNama());
            ps.setString(7, pm.getTempatLahir());
            ps.setString(8, pm.getTanggalLahir());
            ps.setString(9, pm.getStatusPerkawinan());
            ps.setString(10, pm.getPekerjaan());
            ps.setString(11, pm.getAlamat());
            ps.setString(12, pm.getKewarganegaraan());
            ps.setString(13, pm.getImage());
            ps.setString(14, pm.getGolDarah());
            ps.setString(15, pm.getJk());
            ps.setString(16, pm.getRT());
            ps.setString(17, pm.getRW());
            
            if(ps.executeUpdate() == 1){
                JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan!");
            }
        }catch (SQLException ex) {
            Logger.getLogger(PendaftaranDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public List<PendaftaranModel> getAllPendaftaran() {
        list = new ArrayList<PendaftaranModel>();
        
        try (Connection conn = db.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT " +
                                                "pendaftaran.kode_pendaftaran," +
                                                "pendaftaran.nkk," +
                                                "pendaftaran.nama," +
                                                "pendaftaran.tempat_lahir," +
                                                "pendaftaran.tanggal_lahir," +
                                                "pendaftaran.status_perkawinan," +
                                                "pendaftaran.pekerjaan," +
                                                "kelurahan.kelurahan," +
                                                "kecamatan.kecamatan " +
                                                "FROM pendaftaran JOIN kelurahan ON id_kelurahan = kelurahan.id JOIN kecamatan ON kelurahan.kecamatan_id = kecamatan.id");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PendaftaranModel pm = new PendaftaranModel();
                pm.setId(rs.getInt(1));
                pm.setKodePendaftaran(rs.getString("kode_pendaftaran"));
                pm.setNama(rs.getString("nama"));
                pm.setKelurahan(rs.getString("kelurahan"));
                pm.setKecamatan(rs.getString("kecamatan"));
                pm.setNomorKK(rs.getString("nkk"));
                list.add(pm);
            }
            
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(PendaftaranDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<PendaftaranModel> getByKode(int kode) {
        list = new ArrayList<PendaftaranModel>();
        
        try (Connection conn = db.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT pendaftaran.*,"
                                                        + "agama.agama,"
                                                        + "kelurahan.kelurahan, "
                                                        + "kecamatan.kecamatan "
                                                        + "FROM pendaftaran "
                                                        + "JOIN agama ON agama.id = pendaftaran.id_agama "
                                                        + "JOIN kelurahan ON kelurahan.id = pendaftaran.id_kelurahan "
                                                        + "JOIN kecamatan ON kelurahan.kecamatan_id = kecamatan.id "
                                                        + "WHERE kode_pendaftaran=? LIMIT 1");
            ps.setString(1, Integer.toString(kode));
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                PendaftaranModel pm = new PendaftaranModel();
                pm.setNomorKKDetail(rs.getString("nkk"));
                pm.setNamaDetail(rs.getString("nama"));
                pm.setTempatLahir(rs.getString("tempat_lahir"));
                pm.setTanggalLahir(rs.getString("tanggal_lahir"));
                pm.setAgama(rs.getString("agama"));
                pm.setStatusPerkawinan(rs.getString("status_perkawinan"));
                pm.setPekerjaan(rs.getString("pekerjaan"));
                pm.setKecamatanDetail(rs.getString("kecamatan"));
                pm.setKelurahanDetail(rs.getString("kelurahan"));
                pm.setAlamat(rs.getString("alamat"));
                pm.setKewarganegaraan(rs.getString("kewarganegaraan"));
                pm.setImage(rs.getString("image"));
                imgPrint = rs.getString("image");
                pm.setGolDarah(rs.getString("golongan_darah"));
                pm.setJk(rs.getString("jk"));
                pm.setRT(rs.getString("rt"));
                pm.setRW(rs.getString("rw"));
            }
            
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(PendaftaranDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<PendaftaranModel> filterPendaftaran(String kec, String kel,String kewarganegaraan, String status,String cari) {
        list = new ArrayList<PendaftaranModel>();
        Map<String, Object> params = new HashMap<>();
        String namaQ = "";
        String filterQ = "";
        try (Connection conn = db.getConnection()) {
            
            if(!cari.equals("")){
                namaQ = "AND pendaftaran.nama LIKE  ? OR pendaftaran.nkk LIKE  ? OR pendaftaran.kode_pendaftaran LIKE  ? ESCAPE '!'";
            }

            params.put("kecamatan.id",kec);
            params.put("id_kelurahan",kel);
            params.put("kewarganegaraan",kewarganegaraan);
            params.put("status_perkawinan",status);
            

            int p = 1;
            for (String paramName : params.keySet()) {
                Object paramValue = params.get(paramName);
                if (paramValue != null) {
                    if(p == 1){
                        filterQ = " WHERE "+paramName+" = ?";
                    }
                    else{
                        filterQ += " AND " + paramName + "= ?";
                    }
                    p++;
                }
            }

            
            String q = "SELECT " +
                        "pendaftaran.kode_pendaftaran," +
                        "pendaftaran.nkk," +
                        "pendaftaran.nama," +
                        "pendaftaran.tempat_lahir," +
                        "pendaftaran.tanggal_lahir," +
                        "pendaftaran.status_perkawinan," +
                        "pendaftaran.pekerjaan," +
                        "kelurahan.kelurahan," +
                        "kecamatan.kecamatan " +
                        "FROM pendaftaran JOIN kelurahan ON id_kelurahan = kelurahan.id JOIN kecamatan ON kelurahan.kecamatan_id = kecamatan.id " +
                        ""+filterQ+namaQ+"";
            PreparedStatement ps = conn.prepareStatement(q);

            int paramNumber = 1;
            for (String paramName : params.keySet()) {
                Object paramValue = params.get(paramName);
                if (paramValue != null) {
                    ps.setString(paramNumber, paramValue.toString());
                    paramNumber++;
                }
            }

            if(!cari.equals("")){
                System.out.println("su terisi");
                ps.setString(paramNumber, "%" + cari + "%");
                ps.setString(paramNumber+1, "%" + cari + "%");
                ps.setString(paramNumber+2, "%" + cari + "%");
            }
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) { 
                PendaftaranModel pm = new PendaftaranModel();
                pm.setId(rs.getInt(1));
                pm.setKodePendaftaran(rs.getString("kode_pendaftaran"));
                pm.setNama(rs.getString("nama"));
                pm.setKelurahan(rs.getString("kelurahan"));
                pm.setKecamatan(rs.getString("kecamatan"));
                pm.setNomorKK(rs.getString("nkk"));
                list.add(pm);
            }
            
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(PendaftaranDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void delete(int kode) {
        try (Connection conn = db.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM pendaftaran WHERE kode_pendaftaran = ? ");
            ps.setInt(1, kode);
            System.out.println(kode);
            if(ps.executeUpdate() == 1){
                JOptionPane.showMessageDialog(null, "Data Berhasil dihapus!");
            }
        }catch (SQLException ex) {
            Logger.getLogger(PendaftaranDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(int kode, PendaftaranModel pm) {
        try (Connection conn = db.getConnection()) {
            String sqlImage = "";
            if(pm.getImage() != null){
                sqlImage = ",image = ?";
            }
            String sql = "UPDATE pendaftaran SET id_kelurahan = ?, id_agama = ?, nkk = ?,nama = ?, tempat_lahir = ?, tanggal_lahir = ?,status_perkawinan = ?,pekerjaan = ?, alamat = ?, kewarganegaraan = ?, golongan_darah= ?, jk = ?, rt = ?, rw = ?"+sqlImage+" WHERE kode_pendaftaran = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, pm.getIdKelurahan());
            ps.setInt(2, pm.getIdAgama());
            ps.setString(3, pm.getNomorKK());
            ps.setString(4, pm.getNama());
            ps.setString(5, pm.getTempatLahir());
            ps.setString(6, pm.getTanggalLahir());
            ps.setString(7, pm.getStatusPerkawinan());
            ps.setString(8, pm.getPekerjaan());
            ps.setString(9, pm.getAlamat());
            ps.setString(10, pm.getKewarganegaraan());
            ps.setString(11, pm.getGolDarah());
            ps.setString(12, pm.getJk());
            ps.setString(13, pm.getRT());
            ps.setString(14, pm.getRW());
            
            if(pm.getImage() != null){
                ps.setString(15, pm.getImage());
                ps.setInt(16, kode);
            }
            else{
                ps.setInt(15, kode);
            }
            
            if(ps.executeUpdate() == 1){
                JOptionPane.showMessageDialog(null, "Data Berhasil diubah!");
            }
        }catch (SQLException ex) {
            Logger.getLogger(PendaftaranDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void printByKode(int kode) {
         try (Connection conn = db.getConnection()) {
            JasperDesign jd=JRXmlLoader.load("./src/pendaftaran/ktp/reports/ktp_report.jrxml");
            HashMap param = new HashMap();
            PendaftaranModel pm = new PendaftaranModel();
            this.getByKode(kode);

            param.put("kode_pendaftaran",kode);
            param.put("image_link","./src/pendaftaran/ktp/img/capture/"+imgPrint);
            JasperReport jr=JasperCompileManager.compileReport(jd);
            JasperPrint jp=JasperFillManager.fillReport(jr, param,conn);
            JasperViewer jv =new JasperViewer(jp,false);
            jv.setVisible(true);
       }catch(Exception e){
             System.out.println(e.getMessage());
       }
    }

    @Override
    public void printAll() {
        try (Connection conn = db.getConnection()) {
//            String report = "./src/modul8/Tugas/TugasReport.jrxml";
            JasperReport JASP_REP = JasperCompileManager.compileReport("./src/pendaftaran/ktp/reports/all_ktp.jrxml");
            JasperPrint JASP_PRINT = JasperFillManager.fillReport(JASP_REP, null,conn);
            JasperViewer.viewReport(JASP_PRINT);
            
        }   catch (SQLException ex) {
            Logger.getLogger(PendaftaranDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(PendaftaranDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
