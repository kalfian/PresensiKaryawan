/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presensi.karyawan.dao;

import presensi.karyawan.model.PresensiModel;

/**
 *
 * @author neet
 */
public interface ImplementPresensi {
    public Boolean insert(PresensiModel pmo);
    public String recognizer(String formattedDate, String person);
}
