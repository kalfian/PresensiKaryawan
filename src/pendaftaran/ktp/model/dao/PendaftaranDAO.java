/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendaftaran.ktp.model.dao;

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

/**
 *
 * @author neet
 */
public class PendaftaranDAO implements ImplementPendaftaran {
    Config db = new Config();
    private List<PendaftaranModel> list;
    
    @Override
    public void insert(PendaftaranModel pm) {
        try (Connection conn = db.getConnection()) {
            System.out.println(pm.getIdKelurahan());
            PreparedStatement ps = conn.prepareStatement("INSERT INTO pendaftaran VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
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
//                System.out.println("cok : "+pm.getNomorKK());
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
            
            if(cari != null){
                namaQ = "AND pendaftaran.nama LIKE  ? OR pendaftaran.nkk LIKE  ? OR pendaftaran.kode_pendaftaran LIKE  ? ESCAPE '!'";
            }

            params.put("kecamatan.id",kec);
            params.put("id_kelurahan",kel);
            params.put("kewarganegaraan",kewarganegaraan);
            params.put("status_perkawinan",status);
            
//            System.out.println(kewarganegaraan);
            int p = 1;
            for (String paramName : params.keySet()) {
                Object paramValue = params.get(paramName);
//                System.out.println("param : "+paramName);
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
//            System.out.println("query : "+filterQ);
//            System.out.println("query : "+namaQ);
            if(cari != null){
                System.out.println("last : "+paramNumber);
                ps.setString(paramNumber, "%" + cari + "%");
                ps.setString(paramNumber+1, "%" + cari + "%");
                ps.setString(paramNumber+2, "%" + cari + "%");
            }
//            System.out.println(ps);

            
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
}
