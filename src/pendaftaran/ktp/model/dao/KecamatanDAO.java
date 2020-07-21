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
import java.util.prefs.Preferences;
import pendaftaran.ktp.config.Config;
import pendaftaran.ktp.config.Constant;
import pendaftaran.ktp.model.*;

/**
 *
 * @author neet
 */
public class KecamatanDAO implements ImplementKecamatan{
    Config db = new Config();
    public static ArrayList<String> idKecamatan = new ArrayList<String>();
    
    @Override
    public ArrayList<String> getKecamatan() {
         ArrayList<String> kecamatan=new ArrayList<String>();   
         try (Connection conn = db.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM kecamatan");
            ResultSet rs = ps.executeQuery();
            int a = 0;
            while (rs.next()) { 
                kecamatan.add(rs.getString("kecamatan"));
                idKecamatan.add(rs.getString("id"));
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
