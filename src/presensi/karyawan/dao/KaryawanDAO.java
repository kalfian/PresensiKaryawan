/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presensi.karyawan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javax.swing.JOptionPane;
import presensi.karyawan.config.Config;
import presensi.karyawan.model.KaryawanModel;
import presensi.karyawan.model.LoginModel;

/**
 *
 * @author neet
 */
public class KaryawanDAO implements ImplementKaryawan{
     Config db = new Config();
     public void insert(KaryawanModel km) {

        try (Connection conn = db.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO m_user VALUES(?,?,?,?,?,?,?)");
            ps.setString(1, null);
            ps.setString(2, km.getNama());
            ps.setString(3, km.getAlamat());
            ps.setInt(4, km.getJk());
            ps.setInt(5, km.getStatus());
            ps.setInt(6, km.getJabatan());
            ps.setInt(7, km.getId());
         
            
            if(ps.executeUpdate() == 1){
                JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan!");
            }
        }catch (SQLException ex) {
            Logger.getLogger(KaryawanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
}
