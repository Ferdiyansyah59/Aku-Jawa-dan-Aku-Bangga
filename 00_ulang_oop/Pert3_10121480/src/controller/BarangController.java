/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author ferdi
 */
import dao.*;
import model.*;
import view.barang_view;
import java.util.List;
import javax.swing.JOptionPane;
public class BarangController {
    barang_view frame;
    implementBarang imBarang;
    List<barang_model> lb;
    
    public void reset(){
        frame.getInKode().setText("");
        frame.getInNama().setText("");
        frame.getInHarga().setText("");
        frame.getInStock().setText("");
    }
    
    public BarangController(barang_view frame){
        this.frame = frame;
        imBarang = new daoBarang();
        lb = imBarang.getAll();
    }
    
    public void isiTable(){
        lb = imBarang.getAll();
        tableModelBarang tmb = new tableModelBarang(lb);
        frame.getTbBarang().setModel(tmb);
    }
    
    public void insert(){
        barang_model b = new barang_model();
        b.setKode(frame.getInKode().getText());
        b.setNama(frame.getInNama().getText());
        b.setHarga(Integer.parseInt(frame.getInHarga().getText()));
        b.setStock(Integer.parseInt(frame.getInStock().getText()));
        
        imBarang.insert(b);
    }
    
    public void isiTableKode(){
        lb = imBarang.getCariKode(frame.getInSearch().getText());
        tableModelBarang tmb = new tableModelBarang(lb);
        frame.getTbSearch().setModel(tmb);
    }
    
    public void isiTableAmbil(){
        lb = imBarang.getCariKode(frame.getInKodeAmbil().getText());
        tableModelBarang tmb = new tableModelBarang(lb);
        frame.getTbAmbil().setModel(tmb);
    }
    
    public void search(){
        if(!frame.getInSearch().getText().trim().isEmpty()){
            imBarang.getCariKode(frame.getInSearch().getText());
            isiTableKode();;
        }else{
            isiTableKode();
        }
    }
    
    public void ambil(){
        barang_model b = new barang_model();
        if(!frame.getInKodeAmbil().getText().trim().isEmpty()){
            List<String> st = imBarang.getAmbil(frame.getInKodeAmbil().getText());
            frame.setInNamaAmbil(st.get(0));
            frame.setInAmbil(Integer.valueOf(st.get(1)));
            isiTableAmbil();
        }
    }
    
    
    public void ambilBarang(){
        barang_model b = new barang_model();
        b.setKode(frame.getInKodeAmbil().getText());
        b.setStock(Integer.parseInt(frame.getInAmbil().getText()));
        
        imBarang.ambilBarang(b);
        isiTableAmbil();
    }
    
    public void isiTableUpdate(){
        lb = imBarang.getAll();
        tableModelBarang tmb = new tableModelBarang(lb);
        frame.getTbUpdate().setModel(tmb);
    }
    
    public void isiField(int row){
        frame.getKdBarangU().setText(lb.get(row).getKode());
        frame.getNmBarangU().setText(lb.get(row).getNama());
        frame.getHgBarangU().setText(lb.get(row).getHarga().toString());
        frame.getStockU().setText(lb.get(row).getStock().toString());
    }
    
    
    
    public void updateData(){
        barang_model b = new barang_model();
        b.setNama(frame.getNmBarangU().getText());
        b.setHarga(Integer.parseInt(frame.getHgBarangU().getText()));
        b.setStock(Integer.parseInt(frame.getStockU().getText()));
        b.setKode(frame.getKdBarangU().getText());
        
        imBarang.updateData(b);
    }
    
    
    public void hapusData(int row){
        barang_model b = new barang_model();
//        b.setKode();
        imBarang.delete(lb.get(row).getKode());
    }
    
    public void isiTableDelete(){
        lb = imBarang.getAll();
        tableModelBarang tmb = new tableModelBarang(lb);
        frame.getTbHapus().setModel(tmb);
    }
}
