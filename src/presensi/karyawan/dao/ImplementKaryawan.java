/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presensi.karyawan.dao;

import java.util.List;
import presensi.karyawan.model.KaryawanModel;

/**
 *
 * @author neet
 */
public interface ImplementKaryawan {
    public void insert(KaryawanModel km);
    public List<KaryawanModel> getAllKaryawan();
    public List<KaryawanModel> getKaryawanById(int id);
}
