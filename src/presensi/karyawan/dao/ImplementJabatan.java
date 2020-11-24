/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presensi.karyawan.dao;

import java.util.ArrayList;
import java.util.List;
import presensi.karyawan.model.JabatanModel;

/**
 *
 * @author neet
 */
public interface ImplementJabatan {
    public List<JabatanModel> getAllJabatan();
    public ArrayList<String> getJabatan();
    public void insert(JabatanModel jm);
    public void update(int id,JabatanModel pm);
    public List<JabatanModel> getJabatanById(int id);
    public void delete(int id);
}
