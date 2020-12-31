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
import javax.swing.JOptionPane;
import presensi.karyawan.config.Config;
import presensi.karyawan.model.JabatanModel;

/**
 *
 * @author neet
 */
public class JabatanDAO implements ImplementJabatan {
    Config db = new Config();
    public static ArrayList<String> idJabatan = new ArrayList<String>();
    private List<JabatanModel> list;

    @Override
    public ArrayList<String> getJabatan() {
        ArrayList<String> jabatan=new ArrayList<String>();   
        idJabatan.clear();
         try (Connection conn = db.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM m_jabatan");
            ResultSet rs = ps.executeQuery();
            int a = 0;
            while (rs.next()) { 
                jabatan.add(rs.getString("nama_jabatan"));
                idJabatan.add(rs.getString("id"));
                a++;
            }
            
            ps.close();
            rs.close();
            return jabatan;
        } catch (SQLException ex) {
            Logger.getLogger(JabatanDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void insert(JabatanModel jm) {
        try (Connection conn = db.getConnection()) {
            //insert user
            PreparedStatement ps = conn.prepareStatement("INSERT INTO m_jabatan VALUES(?,?,?)",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, null);
            ps.setString(2, jm.getNamaJabatan());
            ps.setInt(3, jm.getCreatedBy());
          
            if(ps.executeUpdate() == 1){
                JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan!");
            }
            
        }catch (SQLException ex) {
            Logger.getLogger(JabatanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @Override
    public void update(int id, JabatanModel jm) {
        try (Connection conn = db.getConnection()) {
            //update user
            String sql = "UPDATE m_jabatan SET nama_jabatan = ?, create_by = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, jm.getNamaJabatan());
            ps.setInt(2, jm.getCreatedBy());
            ps.setInt(3, id);
            if(ps.executeUpdate() == 1){
                JOptionPane.showMessageDialog(null, "Data Berhasil diubah!");
            }
        }catch (SQLException ex) {
            Logger.getLogger(JabatanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<JabatanModel> getJabatanById(int id) {
        list = new ArrayList<JabatanModel>();
        
        try (Connection conn = db.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * from m_jabatan WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                JabatanModel jm = new JabatanModel();
                jm.setNamaJabatan(rs.getString("nama_jabatan"));
                jm.setCreatedBy(rs.getInt("create_by"));
                list.add(jm);
            }
            
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(JabatanDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void delete(int id) {
        try (Connection conn = db.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM m_jabatan WHERE id = ? ");
            ps.setInt(1, id);

            if(ps.executeUpdate() == 1){
                JOptionPane.showMessageDialog(null, "Data Berhasil dihapus!");
            }
        }catch (SQLException ex) {
            Logger.getLogger(JabatanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<JabatanModel> getAllJabatan() {
        list = new ArrayList<JabatanModel>();
        ArrayList<String> jabatan=new ArrayList<String>();   
        idJabatan.clear();
        try (Connection conn = db.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM m_jabatan");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idJabatan.add(rs.getString("id"));
                JabatanModel pm = new JabatanModel();
                pm.setNamaJabatan(rs.getString("nama_jabatan"));
                list.add(pm);
            }
            
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(JabatanDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<JabatanModel> filterjabatan(String cari) {
        list = new ArrayList<JabatanModel>();
        Map<String, Object> params = new HashMap<>();
        String filterQ = "";
        try (Connection conn = db.getConnection()) {
            if(!cari.equals("")){
                filterQ = " where nama_jabatan LIKE ? " + "ESCAPE '!'";
            }
            
            String q = "SELECT * FROM m_jabatan"+filterQ;
            PreparedStatement ps = conn.prepareStatement(q);
            if(!cari.equals("")){
                ps.setString(1, "%" + cari + "%");
            }
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) { 
                JabatanModel jm = new JabatanModel();
                idJabatan.add(rs.getString("id"));
                jm.setNamaJabatan(rs.getString("nama_jabatan"));
                jm.setCreatedBy(rs.getInt("create_by"));
              
                list.add(jm);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(JabatanDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}