/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presensi.karyawan.dao;

import java.util.ArrayList;
import presensi.karyawan.model.LoginModel;


/**
 *
 * @author Teknis SM
 */
public interface ImplementLogin{
    public boolean checkCreds(LoginModel lm);
}
