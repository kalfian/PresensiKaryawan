/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presensi.karyawan.model;

/**
 *
 * @author neet
 */
public class KaryawanModel {
    private int id,jk,status,jabatan;
    private String nama,alamat,email,password;
    
//    id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
//    jk
    public int getJk() {
        return jk;
    }

    public void setJk(int jk) {
        this.jk = jk;
    }
//    status
    public int getStatus() {
        return status;
    }
    
    public void setStatus(int status) {
        this.status = status;
    }
    
//    nama
    public String getNama() {
        return nama;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
//   alamat
    public String getAlamat() {
        return alamat;
    }
    
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
//    email
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
//    password
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
//    jabatan
    public int getJabatan() {
        return jabatan;
    }
    
    public void setJabatan(int jabatan) {
        this.jabatan = jabatan;
    }
}
