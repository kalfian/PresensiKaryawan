/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendaftaran.ktp.model;

/**
 *
 * @author kalfian
 */
public class KelurahanModel {
    private int id;
    private int kecamatanId;
    private String kelurahan;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKecamatanId() {
        return kecamatanId;
    }

    public void setKecamatanId(int kecamatanId) {
        this.kecamatanId = kecamatanId;
    }

    public String getKelurahan() {
        return kelurahan;
    }

    public void setKelurahan(String kelurahan) {
        this.kelurahan = kelurahan;
    }

    public KelurahanModel(int id, int kecamatanId, String kelurahan) {
        this.id = id;
        this.kecamatanId = kecamatanId;
        this.kelurahan = kelurahan;
    }
}
