/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nilai.dao;

/**
 *
 * @author ferdiyansyah
 */
import nilai.model.*;
import java.util.List;
public interface implementNilai{
    public void insert(nilaiModel b);
    
    public void update(nilaiModel b);
    
    public void delete(int id);
    
    public List<nilaiModel>mapelField(String mapel);
    
    public List<nilaiModel>comboBoxMapel();
    
    public List<nilaiModel>getNamaa(String nis);
    
    public List<nilaiModel>getAll();
    
    public List<nilaiModel>getSearchNis(String nis);
    
    public List<nilaiModel>getSearchNama(String nama);
    
    public List<nilaiModel>getSearchNilai(String nilai);
    
    public List<nilaiModel> getData(String nis);

}