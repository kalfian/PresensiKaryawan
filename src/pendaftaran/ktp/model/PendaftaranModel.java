/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendaftaran.ktp.model;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author kalfian
 */
public class PendaftaranModel {
    private int id;
    private int idKelurahan;
    private String kelurahan;
    private String kecamatan;
    private int idAgama;
    private static String agama;
    private String kodePendaftaran;
    private String nama;
    private static String tempatLahir;
    private static String tanggalLahir;
    private static String statusPerkawinan;
    private String nomorKK;
    private static String pekerjaan;
    private static String alamat;
    private static String kewarganegaraan;
    private static String image;
    
    /*public PendaftaranModel(int id, int idKelurahan, int idAgama, String kodePendaftaran, String nama, String nomorKK,String tempatLahir, String tanggalLahir, String statusPerkawinan, String pekerjaan, String alamat, String kewarganegaraan) {
        this.id = id;
        this.idKelurahan = idKelurahan;
        this.idAgama = idAgama;
        this.kodePendaftaran = kodePendaftaran;
        this.nomorKK = nomorKK;
        this.nama = nama;
        this.tempatLahir = tempatLahir;
        this.tanggalLahir = tanggalLahir;
        this.statusPerkawinan = statusPerkawinan;
        this.pekerjaan = pekerjaan;
        this.alamat = alamat;
        this.kewarganegaraan = kewarganegaraan;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdKelurahan() {
        return idKelurahan;
    }

    public void setIdKelurahan(int idKelurahan) {
        this.idKelurahan = idKelurahan;
    }
    
    public String getKelurahan() {
        return kelurahan;
    }

    public void setKelurahan(String kelurahan) {
        this.kelurahan = kelurahan;
    }
    
    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public int getIdAgama() {
        return idAgama;
    }

    public void setIdAgama(int idAgama) {
        this.idAgama = idAgama;
    }
    
    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getKodePendaftaran() {
        return kodePendaftaran;
    }

    public void setKodePendaftaran(String kodePendaftaran) {
        this.kodePendaftaran = kodePendaftaran;
    }
    
    public String getNomorKK() {
        return nomorKK;
    }

    public void setNomorKK(String nomorKK) {
        this.nomorKK = nomorKK;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getStatusPerkawinan() {
        return statusPerkawinan;
    }

    public void setStatusPerkawinan(String statusPerkawinan) {
        this.statusPerkawinan = statusPerkawinan;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKewarganegaraan() {
        return kewarganegaraan;
    }

    public void setKewarganegaraan(String kewarganegaraan) {
        this.kewarganegaraan = kewarganegaraan;
    }
    
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
}
