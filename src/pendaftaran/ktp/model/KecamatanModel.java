/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendaftaran.ktp.model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author kalfian
 */
public class KecamatanModel<A> {
    private int id;
    private String kecamatan;

    /*public KecamatanModel(int id, String kecamatan) {
        this.id = id;
        this.kecamatan = kecamatan;
    }*/
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

}
