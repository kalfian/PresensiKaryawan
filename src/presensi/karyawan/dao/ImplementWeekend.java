/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presensi.karyawan.dao;

import java.util.List;
import presensi.karyawan.model.WeekendModel;

/**
 *
 * @author neet
 */
public interface ImplementWeekend {
    public void insert(WeekendModel km);
    public void update(int id,WeekendModel pm);
    public void delete(int id);
    public List<WeekendModel> getAllWeekend();
    public List<WeekendModel> getWeekendById(int id);
}
