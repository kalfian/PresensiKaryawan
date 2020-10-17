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
import static presensi.karyawan.dao.AgamaDAO.idAgama;
import presensi.karyawan.model.LoginModel;

/**
 *
 * @author Teknis SM
 */
public class LoginDAO implements ImplementLogin{
    Config db = new Config();
    @Override
    public boolean checkCreds(LoginModel lm) {
        ArrayList<String> user=new ArrayList<String>();   
        String u = lm.getUsername();
        String p = lm.getPassword();
        Boolean res = false;
        try (Connection conn = db.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM r_login WHERE email = ? AND password = ? LIMIT 1");
            ps.setString(1, u);
            ps.setString(2, p);
            ResultSet rs = ps.executeQuery();
            System.out.println("u"+u);
            System.out.println("p"+p);

            if (rs.next()) {
                user.add(rs.getString("id"));
                user.add(rs.getString("email"));
                user.add(rs.getString("password"));
                lm.setUsername(rs.getString("email"));
                lm.setId(rs.getInt("id"));
                return true;
            }
            else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
