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
public class PresensiModel {
    int id,user_id;
    String foto_masuk,foto_pulang,tanggal,jam_masuk,jam_keluar,keterangan;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getUserId() {
        return user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }
    
    public String getFotoMasuk() {
        return foto_masuk;
    }

    public void setFotoMasuk(String foto_masuk) {
        this.foto_masuk = foto_masuk;
    }
    
    public String getFotoPulang() {
        return foto_pulang;
    }

    public void setFotoPulang(String foto_pulang) {
        this.foto_pulang = foto_pulang;
    }
    
    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
    
    public String getJamMasuk() {
        return jam_masuk;
    }

    public void setJamMasuk(String jam_masuk) {
        this.jam_masuk = jam_masuk;
    }
    
    public String getJamKeluar() {
        return jam_keluar;
    }

    public void setJamKeluar(String jam_keluar) {
        this.jam_keluar = jam_keluar;
    }
    
    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
