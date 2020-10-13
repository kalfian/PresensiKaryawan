/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presensi.karyawan.model;

/**
 *
 * @author kalfian
 */
public class UserModel {
    private int id;
    private String username;
    private String name;
    
    public UserModel(int id ,String username, String name ) {
        this.id = id;
        this.username = username;
        this.name = name;
    }
    
     public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String password) {
        this.name = name;
    }
}
