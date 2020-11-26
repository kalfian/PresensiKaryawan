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
public class WeekendModel {
     private int id,created_by;
    private String tgl,ket;
    
    //id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    //nama
    public int getCreatedBy() {
        return created_by;
    }

    public void setCreatedBy(int created_by) {
        this.created_by = created_by;
    }
    
    public String getTanggalLibur() {
        return tgl;
    }

    public void setTanggalLibur(String tgl) {
        this.tgl = tgl;
    }
    
    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }
}
