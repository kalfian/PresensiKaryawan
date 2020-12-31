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
import presensi.karyawan.model.WeekendModel;

/**
 *
 * @author neet
 */
public class WeekendDAO implements ImplementWeekend{
    Config db = new Config();
    private List<WeekendModel> list;
    public static ArrayList<String> idWeekend = new ArrayList<String>();
    
    @Override
    public void insert(WeekendModel wm) {
         try (Connection conn = db.getConnection()) {
            //insert user
            PreparedStatement ps = conn.prepareStatement("INSERT INTO m_hari_libur VALUES(?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, null);
            ps.setString(2, wm.getTanggalLibur());
            ps.setString(3, wm.getKet());
            ps.setInt(4, wm.getCreatedBy());
            
            if(ps.executeUpdate() == 1){
                JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan!");
            }
            
        }catch (SQLException ex) {
            Logger.getLogger(WeekendDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(int id, WeekendModel wm) {
         try (Connection conn = db.getConnection()) {
            System.out.println(id);
            //update weekend
            String sql = "UPDATE m_hari_libur SET tanggal_libur = ?, keterangan = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, wm.getTanggalLibur());
            ps.setString(2, wm.getKet());
            ps.setInt(3, id);
            if(ps.executeUpdate() == 1){
                JOptionPane.showMessageDialog(null, "Data Berhasil diubah!");
            }
        }catch (SQLException ex) {
            Logger.getLogger(WeekendDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
       try (Connection conn = db.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM m_hari_libur WHERE id = ? ");
            ps.setInt(1, id);

            if(ps.executeUpdate() == 1){
                JOptionPane.showMessageDialog(null, "Data Berhasil dihapus!");
            }
        }catch (SQLException ex) {
            Logger.getLogger(JabatanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<WeekendModel> getAllWeekend() {
        list = new ArrayList<WeekendModel>();
        ArrayList<String> karyawan=new ArrayList<String>();   
        idWeekend.clear();
        try (Connection conn = db.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM m_hari_libur");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idWeekend.add(rs.getString("id"));
                WeekendModel wm = new WeekendModel();
                wm.setTanggalLibur(rs.getString("tanggal_libur"));
                wm.setKet(rs.getString("keterangan"));
                list.add(wm);
            }

            return list;
        } catch (SQLException ex) {
            Logger.getLogger(WeekendDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<WeekendModel> getWeekendById(int id) {
        list = new ArrayList<WeekendModel>();
        ArrayList<String> karyawan=new ArrayList<String>();   
        try (Connection conn = db.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * from m_hari_libur where id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                WeekendModel wm = new WeekendModel();
                wm.setTanggalLibur(rs.getString("tanggal_libur"));
                wm.setKet(rs.getString("keterangan"));
                list.add(wm);
            }
            
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(WeekendDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<WeekendModel> filterWeekend(String cari) {
        list = new ArrayList<WeekendModel>();
        Map<String, Object> params = new HashMap<>();
        String filterQ = "";
        try (Connection conn = db.getConnection()) {
            if(!cari.equals("")){
                filterQ = " where keterangan LIKE ? " 
                        + "OR tanggal_libur LIKE ? "
                        + "ESCAPE '!'";
            }
            
            String q = "SELECT * FROM m_hari_libur"+filterQ;
            PreparedStatement ps = conn.prepareStatement(q);
            if(!cari.equals("")){
                ps.setString(1, "%" + cari + "%");
                ps.setString(2, "%" + cari + "%");
            }
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) { 
                WeekendModel wm = new WeekendModel();
                idWeekend.add(rs.getString("id"));
                wm.setTanggalLibur(rs.getString("tanggal_libur"));
                wm.setKet(rs.getString("keterangan"));
              
                list.add(wm);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(WeekendDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
