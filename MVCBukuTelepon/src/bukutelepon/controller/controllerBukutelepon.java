    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bukutelepon.controller;

/**
 *
 * @author ferdiyansyah
 */
import bukutelepon.dao.daoBukuTelepon;
import bukutelepon.dao.implementBukutelepon;
import bukutelepon.model.bukutelepon_model;
import bukutelepon.model.tableModelBukutelepon;
import bukutelepon.view.bukutelepon_view;
import java.util.List;
import javax.swing.JOptionPane;
public class controllerBukutelepon {
    bukutelepon_view frame;
    implementBukutelepon implBukuTelepon;
    List<bukutelepon_model> lb;
    
    public controllerBukutelepon(bukutelepon_view frame){
        this.frame = frame;
        implBukuTelepon = new daoBukuTelepon(); 
        lb = implBukuTelepon.getAll();
    }
    //mengosongkan field
    public void reset(){
        frame.getInId().setText("");
        frame.getInNope().setText("");
        frame.getInNama().setText("");
        frame.getInAlamat().setText("");
    }
    //Menampilkan data ke dalam tabel
    public void isiTable(){
        lb = implBukuTelepon.getAll();
        tableModelBukutelepon tmb = new tableModelBukutelepon(lb);
        frame.getTbTelepon().setModel(tmb);
    }
    //Menampilkan data yang dipilih dari tabel
    public void isiField(int row){
        frame.getInId().setText(lb.get(row).getId().toString());
        frame.getInNope().setText(lb.get(row).getNope());
        frame.getInNama().setText(lb.get(row).getNama());
        frame.getInAlamat().setText(lb.get(row).getAlamat());
    }
    //Insert data berdasarkan inputan user 
    public void insert(){
        bukutelepon_model b = new bukutelepon_model();
        b.setNope(frame.getInNope().getText());
        b.setNama(frame.getInNama().getText());
        b.setAlamat(frame.getInAlamat().getText());
        
        implBukuTelepon.insert(b);
    }
    //update data berdasarkan inputan user
    public void update(){
        bukutelepon_model b = new bukutelepon_model();
        b.setNope(frame.getInNope().getText());
        b.setNama(frame.getInNama().getText());
        b.setAlamat(frame.getInAlamat().getText());
        b.setId(Integer.parseInt(frame.getInId().getText()));
        
        implBukuTelepon.update(b);
    }
    //menghapus data yang dipilih
    public void delete(){
        if(!frame.getInId().getText().trim().isEmpty()){
            int id = Integer.parseInt(frame.getInId().getText());
            implBukuTelepon.delete(id);
        }else{
            JOptionPane.showMessageDialog(frame, "Pilih data yang akan dihapus");
        }
    }
    public void isiTableCariNama(){
        lb = implBukuTelepon.getCariNama(frame.getSearch().getText());
        tableModelBukutelepon tmb = new tableModelBukutelepon(lb);
        frame.getTbTelepon().setModel(tmb);
    }
    public void cariNama(){
        if(!frame.getSearch().getText().trim().isEmpty()){
            implBukuTelepon.getCariNama(frame.getSearch().getText());
            isiTableCariNama();
        }else{
            isiTableCariNama();
        }
    }
}
