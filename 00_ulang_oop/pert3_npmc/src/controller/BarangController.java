/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
    
    public void search(){
        if(!frame.getInSearch().getText().trim().isEmpty()){
            imBarang.getCariKode(frame.getInSearch().getText());
            isiTableKode();;
        }else{
            isiTableKode();
        }
    }
}

