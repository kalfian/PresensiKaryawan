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
public class JabatanModel {
    private int id,created_by;
    private String nama;
    
    //id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    //nama
    public String getNamaJabatan() {
        return nama;
    }

    public void setNamaJabatan(String nama) {
        this.nama = nama;
    }
    
       //nama
    public int getCreatedBy() {
        return created_by;
    }

    public void setCreatedBy(int created_by) {
        this.created_by = created_by;
    }
}
