/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nilai.model;

/**
 *
 * @author ferdiyansyah
 */
import java.util.List;
import javax.swing.table.AbstractTableModel;
public class tableModelNilai extends AbstractTableModel {
    List<nilaiModel> lb;
    
    public tableModelNilai(List<nilaiModel> lb){
        this.lb = lb;
    }
    @Override
    public int getColumnCount(){
        return 6;
    }
    @Override
    public int getRowCount(){
        return lb.size();
    }
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "NIS";
            case 1:
                return "Nama";
            case 2:
                return "Mata Pelajaran";
            case 3:
                return "Semester";
            case 4:
                return "Nilai";
            case 5:
                return "Keterangan";
            default:
                return null;
        }
    }
    @Override
    public Object getValueAt(int row, int column){
        switch(column){
            case 0:
                return lb.get(row).getNis();
            case 1:
                return lb.get(row).getNama();
            case 2:
                return lb.get(row).getMapel();
            case 3:
                return lb.get(row).getSemester();
            case 4:
                return lb.get(row).getNilai();
            case 5:
                return lb.get(row).getKeterangan();
            default:
                return null;
        }
    }
}
