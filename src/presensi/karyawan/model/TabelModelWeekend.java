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
public class TabelModelWeekend extends AbstractTableModel{
    private static final long serialVersionUID = 1L;
    List<WeekendModel> list2 ;
    
    public TabelModelWeekend(List<WeekendModel> list) {
        this.list2 = list;
    }

    @Override
    public int getRowCount() {
        return list2.size();
    }

    @Override
    public int getColumnCount() {
         return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 : return list2.get(rowIndex).getTanggalLibur();
            case 1 : return list2.get(rowIndex).getKet();
                default:return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0 : return "Tanggal Libur";
            case 1: return "Keterangan";
            default:return null;
        }
    }
}
