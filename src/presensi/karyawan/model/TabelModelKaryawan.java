/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presensi.karyawan.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author neet
 */
public class TabelModelKaryawan extends AbstractTableModel{
    private static final long serialVersionUID = 1L;

    List<KaryawanModel> list ;
    public TabelModelKaryawan(List<KaryawanModel> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
         return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 : return list.get(rowIndex).getNama();
            case 1 : return list.get(rowIndex).getJabatanString();
            case 2 : return list.get(rowIndex).getEmail();
            case 3 : return list.get(rowIndex).getStatusString();
                default:return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0 : return "Nama";
            case 1 : return "Jabatan";
            case 2 : return "Email";
            case 3 : return "Status";
            default:return null;
        }
    }
}
