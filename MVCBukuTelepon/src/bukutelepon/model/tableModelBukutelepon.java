/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bukutelepon.model;

/**
 *
 * @author ferdiyansyah
 */
import java.util.List;
import javax.swing.table.AbstractTableModel;
public class tableModelBukutelepon extends AbstractTableModel {
    List<bukutelepon_model> lb;
    
    public tableModelBukutelepon(List<bukutelepon_model> lb){
        this.lb = lb;
    }
    
    @Override
    public int getColumnCount(){
        return 4;
    }
    @Override
    public int getRowCount(){
        return lb.size();
    }
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "ID";
            case 1:
                return "Nope";
            case 2:
                return "Nama";
            case 3:
                return "Alamat";
            default:
                return null;
        }
    }
    @Override
    public Object getValueAt(int row, int column){
        switch(column){
            case 0:
                return lb.get(row).getId();
            case 1:
                return lb.get(row).getNope();
            case 2:
                return lb.get(row).getNama();
            case 3:
                return lb.get(row).getAlamat();
            default:
                return null;
        }
    }
}
