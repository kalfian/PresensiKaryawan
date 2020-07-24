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
import pendaftaran.ktp.model.AgamaModel;

/**
 *
 * @author neet
 */
public class AgamaDAO implements ImplementAgama{
    Config db = new Config();
    public static ArrayList<String> idAgama = new ArrayList<String>();

    @Override
    public ArrayList<String> getAgama() {
         ArrayList<String> agama=new ArrayList<String>();   
         try (Connection conn = db.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM agama");
            ResultSet rs = ps.executeQuery();
            
            int a = 0;
            while (rs.next()) { 
                agama.add(rs.getString("agama"));
                idAgama.add(rs.getString("id"));
                a++;
            }
            
            ps.close();
            rs.close();
            return agama;
        } catch (SQLException ex) {
            Logger.getLogger(KecamatanDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
