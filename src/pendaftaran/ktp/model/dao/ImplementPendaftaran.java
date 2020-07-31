/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendaftaran.ktp.model.dao;
import pendaftaran.ktp.model.*;
import java.util.List;
/**
 *
 * @author neet
 */
public interface ImplementPendaftaran {
     public void insert(PendaftaranModel pm);
     public List<PendaftaranModel> getAllPendaftaran();
     public List<PendaftaranModel> getByKode(int kode);
     public List<PendaftaranModel> filterPendaftaran(String kec, String kel,String kewarganegaraan, String status,String cari);
     public void update(int kode,PendaftaranModel pm);
     public void delete(int kode);
     public void print(int kode);
}
