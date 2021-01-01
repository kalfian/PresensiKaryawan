/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presensi.karyawan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javax.swing.JOptionPane;
import presensi.karyawan.AddDatasets;
import presensi.karyawan.config.Config;
import presensi.karyawan.config.Constant;
import presensi.karyawan.model.KaryawanModel;
import presensi.karyawan.model.LoginModel;

/**
 *
 * @author neet
 */
public class KaryawanDAO implements ImplementKaryawan{
    Config db = new Config();
    Preferences pref = Preferences.userNodeForPackage(presensi.karyawan.dao.KaryawanDAO.class);
    private List<KaryawanModel> list;
    public static ArrayList<String> idKaryawan = new ArrayList<String>();
    
    public void insert(KaryawanModel km) {
        try (Connection conn = db.getConnection()) {
            //insert user
            PreparedStatement ps = conn.prepareStatement("INSERT INTO m_user VALUES(?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            System.out.println("jk" + km.getJk());
            ps.setString(1, null);
            ps.setString(2, km.getNama());
            ps.setString(3, km.getAlamat());
            ps.setInt(4, km.getJk());
            ps.setInt(5, km.getStatus());
            ps.setInt(6, km.getJabatan());
            ps.setInt(7, km.getId());
            
            ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys();
            int lastId = 0;
            if (rs.next()) 
               lastId = rs.getInt(1);
            
            //insert creds
            
            PreparedStatement pss = conn.prepareStatement("INSERT INTO r_login VALUES(?,?,?,md5(?),?)");
            pss.setString(1, null);
            pss.setInt(2, lastId);
            pss.setString(3, km.getEmail());
            pss.setString(4, km.getPassword());
            pss.setInt(5, 2);
            System.out.println("x " + km.getPassword());
            
            if(pss.executeUpdate() == 1){
                JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan!");
                AddDatasets ad =  new AddDatasets();
                ad.userId = lastId;
                ad.username = km.getEmail();
                ad.setVisible(true);
            }
            
        }catch (SQLException ex) {
            Logger.getLogger(KaryawanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
     }

    @Override
    public List<KaryawanModel> getAllKaryawan() {
        list = new ArrayList<KaryawanModel>();
        ArrayList<String> karyawan=new ArrayList<String>();   
        idKaryawan.clear();
        try (Connection conn = db.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT r_login.email, m_user.*, m_jabatan.nama_jabatan FROM r_login "
                    + "JOIN m_user ON m_user.id = r_login.user_id "
                    + "JOIN m_jabatan ON m_jabatan.id = m_user.jabatan_id");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idKaryawan.add(rs.getString("id"));
                KaryawanModel pm = new KaryawanModel();
//                pm.setId(rs.getInt(1));
                pm.setNama(rs.getString("nama"));
                pm.setJabatanString(rs.getString("nama_jabatan"));
                pm.setEmail(rs.getString("email"));
                int status = rs.getInt("status");
                String txtStatus = "";
                if(status == 1) 
                    txtStatus = "Aktif";
                else
                    txtStatus = "Non-Aktif";
                pm.setStatusString(txtStatus);
                list.add(pm);
            }
            
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(KaryawanDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<KaryawanModel> getKaryawanById(int id) {
        list = new ArrayList<KaryawanModel>();
        ArrayList<String> karyawan=new ArrayList<String>();   
//        idKaryawan.clear();
        try (Connection conn = db.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * from m_user JOIN r_login on r_login.user_id = m_user.id where m_user.id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KaryawanModel pm = new KaryawanModel();
                pm.setNama(rs.getString("nama"));
                pm.setEmail(rs.getString("email"));
                pm.setAlamat(rs.getString("alamat"));
                pm.setJk(rs.getInt("jenis_kelamin"));
                pm.setJabatan(rs.getInt("jabatan_id"));
                int status = rs.getInt("status");
                pm.setStatus(status);
                list.add(pm);
            }
            
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(JabatanDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    @Override
    public void update(int id, KaryawanModel km) {
        try (Connection conn = db.getConnection()) {
            //update user
            String sql = "UPDATE m_user SET nama = ?, alamat = ?, jenis_kelamin = ?, status = ?, jabatan_id = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            System.out.println("jkne "+km.getJk());
            ps.setString(1, km.getNama());
            ps.setString(2, km.getAlamat());
            ps.setInt(3, km.getJk());
            ps.setInt(4, km.getStatus());
            ps.setInt(5, km.getJabatan());
            ps.setInt(6, id);
            ps.executeUpdate();
            //update creds
            String stPass = "";
            if(!km.getPassword().equals("")) {
                stPass = ", password = ? ";
            }
            String sql2 = "UPDATE r_login SET email = ?"+stPass+" WHERE user_id = ?";
            PreparedStatement pss = conn.prepareStatement(sql2);
            pss.setString(1, km.getEmail());
            if(!km.getPassword().equals("")) {
                pss.setString(2, km.getPassword());
                pss.setInt(3, id);
            }
            else{
                pss.setInt(2, id);
            }
            if(pss.executeUpdate() == 1){
                JOptionPane.showMessageDialog(null, "Data Berhasil diubah!");
            }
        }catch (SQLException ex) {
            Logger.getLogger(KaryawanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void delete(int id) {
        try (Connection conn = db.getConnection()) {
            PreparedStatement pss = conn.prepareStatement("DELETE FROM r_login WHERE user_id = ? ");
            pss.setInt(1, id);
            pss.executeUpdate();
                    
            PreparedStatement ps = conn.prepareStatement("DELETE FROM m_user WHERE id = ? ");
            ps.setInt(1, id);

            if(ps.executeUpdate() == 1){
                JOptionPane.showMessageDialog(null, "Data Berhasil dihapus!");
            }
        }catch (SQLException ex) {
            Logger.getLogger(KaryawanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<KaryawanModel> filterKaryawan(String cari) {
        list = new ArrayList<KaryawanModel>();
        Map<String, Object> params = new HashMap<>();
        String filterQ = "";
        try (Connection conn = db.getConnection()) {
            if(!cari.equals("")){
                String castStatus = "";
                if (cari.toLowerCase().contains("aktif")) {
                    if(cari.toLowerCase() == "aktif") {
                        castStatus = " OR m_user.status = 1 ";
                    } else { 
                        castStatus = " OR m_user.status = 0 ";
                    }
                }
                filterQ = " where m_user.nama LIKE  ? "
                        + "OR m_user.alamat LIKE  ? "
                        + "OR r_login.email LIKE  ? "
                        + "OR m_jabatan.nama_jabatan LIKE  ? "
                        + castStatus
                        + "ESCAPE '!'";
            }
            
            String q = "SELECT r_login.email, m_user.*, m_jabatan.nama_jabatan FROM r_login "
                    + "JOIN m_user ON m_user.id = r_login.user_id "
                    + "JOIN m_jabatan ON m_jabatan.id = m_user.jabatan_id"+filterQ;
            PreparedStatement ps = conn.prepareStatement(q);
            if(!cari.equals("")){
                ps.setString(1, "%" + cari + "%");
                ps.setString(2, "%" + cari + "%");
                ps.setString(3, "%" + cari + "%");
                ps.setString(4, "%" + cari + "%");
            }
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) { 
                KaryawanModel pm = new KaryawanModel();
                idKaryawan.add(rs.getString("id"));
                pm.setNama(rs.getString("nama"));
                pm.setJabatanString(rs.getString("nama_jabatan"));
                pm.setEmail(rs.getString("email"));
                int status = rs.getInt("status");
                String txtStatus = "";
                if(status == 1) 
                    txtStatus = "Aktif";
                else
                    txtStatus = "Non-Aktif";
                pm.setStatusString(txtStatus);
                list.add(pm);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(KaryawanDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
