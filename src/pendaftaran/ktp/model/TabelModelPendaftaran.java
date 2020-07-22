/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendaftaran.ktp.model;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author neet
 */
public class TabelModelPendaftaran extends AbstractTableModel{
    private static final long serialVersionUID = 1L;

    List<PendaftaranModel> list ;
    public TabelModelPendaftaran(List<PendaftaranModel> list) {
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
            case 0 : return list.get(rowIndex).getKodePendaftaran();
            case 1 : return list.get(rowIndex).getNama();
            case 2 : return list.get(rowIndex).getKelurahan();
            case 3 : return list.get(rowIndex).getKecamatan();
            case 4 : return list.get(rowIndex).getNomorKK();
                default:return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0 : return "Kode Pendaftaran";
            case 1 : return "Nama Pendaftar";
            case 2 : return "Kelurahan";
            case 3 : return "Kecamatan";
            case 4 : return "Nomor KK";
                default:return null;
        }
    }
}
