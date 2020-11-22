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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import presensi.karyawan.config.Config;

/**
 *
 * @author neet
 */
public class JabatanDAO implements ImplementJabatan {
    Config db = new Config();
    public static ArrayList<String> idJabatan = new ArrayList<String>();

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

}