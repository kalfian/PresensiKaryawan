/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presensi.karyawan.model;

/**
 *
 * @author Teknis SM
 */
public class LoginModel {
    private int id,user_id,role_id;
    private String username,password;
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    
    public int getRoleId(){
        return role_id;
    }
    public void setRoleId(int role_id){
        this.role_id = role_id;
    }
    
    
    public int getUserId(){
        return user_id;
    }
    public void setUserId(int user_id){
        this.user_id = user_id;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
