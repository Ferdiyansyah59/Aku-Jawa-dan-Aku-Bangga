/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bukutelepon.dao;

/**
 *
 * @author ferdiyansyah
 */
import bukutelepon.model.*;
import java.util.List;
public interface implementBukutelepon {
    public void insert(bukutelepon_model b);
    
    public void update(bukutelepon_model b);
    
    public void delete(int id);
    
    public List<bukutelepon_model> getAll();
    
    public List<bukutelepon_model> getCariNama(String nama);
}
