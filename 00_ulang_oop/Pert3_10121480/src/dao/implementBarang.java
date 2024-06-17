/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author ferdi
 */
import model.*;
import java.util.List;
public interface implementBarang {
    public void insert(barang_model b);
    
    public List<barang_model> getAll();
    
    public List<barang_model> getCariKode(String kode);
    
    public List<String> getAmbil(String kode);
    
    public void ambilBarang(barang_model b);
    
    public void updateData(barang_model b);
    public void delete(String kode);
}
