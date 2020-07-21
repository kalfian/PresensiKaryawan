/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendaftaran.ktp.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    
    @Override
    public void insert(PendaftaranModel pm) {
        try (Connection conn = db.getConnection()) {
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
    
}
