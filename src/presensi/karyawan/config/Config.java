/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presensi.karyawan.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author neet
 */
public class Config {
    private Connection conn;
    private Statement st;
    private ResultSet rs;
    String dbName = "presensi_ta";
    String user = "root";
    String pass = "";
    
    public Connection getConnection (){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e){
            System.err.println(e);  
        }
        try {
            conn= (Connection) 
            DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName+"?useLegacyDatetimeCode=false&serverTimezone=Asia/Jakarta",user,pass);
        } 
        catch (SQLException e) 
        {
             System.err.println(e);//afficher erreur
        }
        finally
        {
            return conn;
        }
   } 
}
