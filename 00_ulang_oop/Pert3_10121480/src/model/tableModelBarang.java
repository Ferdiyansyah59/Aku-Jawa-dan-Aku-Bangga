/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ferdi
 */
import java.util.List;
import javax.swing.table.AbstractTableModel;
public class tableModelBarang extends AbstractTableModel {
    List<barang_model> lb;
    
    public tableModelBarang(List<barang_model> lb){
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
                return "Kode";
            case 1:
                return "Nama Barang";
            case 2: 
                return "Harga Barang";
            case 3: 
                return "Stock Barang";
            default:
                return null;
        }
    }
    
    
    @Override
    public Object getValueAt(int row, int column){
        switch(column){
            case 0: 
                return lb.get(row).getKode();
            case 1: 
                return lb.get(row).getNama();
            case 2: 
                return lb.get(row).getHarga();
            case 3: 
                return lb.get(row).getStock();
            default: 
                return null;
            
        }
    }
    
}
