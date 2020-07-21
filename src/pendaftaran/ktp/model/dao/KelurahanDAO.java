/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendaftaran.ktp.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pendaftaran.ktp.config.Config;
import static pendaftaran.ktp.model.dao.KecamatanDAO.idKecamatan;

/**
 *
 * @author neet
 */
public class KelurahanDAO implements ImplementKelurahan{
    Config db = new Config();
    public static ArrayList<String> IdKelurahan = new ArrayList<String>();
            
    @Override
    public ArrayList<String> getKelurahan(int kecId) {
        ArrayList<String> kecamatan=new ArrayList<String>();   
         try (Connection conn = db.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM kelurahan WHERE kecamatan_id = ? ");
            ps.setInt(1, kecId);
            ResultSet rs = ps.executeQuery();
            int a = 0;
            while (rs.next()) { 
                kecamatan.add(rs.getString("kelurahan"));
                IdKelurahan.add(rs.getString("id"));
                a++;
            }
            
            ps.close();
            rs.close();
            return kecamatan;
        } catch (SQLException ex) {
            Logger.getLogger(KecamatanDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
