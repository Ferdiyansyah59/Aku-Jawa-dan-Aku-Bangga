/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nilai.controller;

/**
 *
 * @author ferdiyansyah
 */
import nilai.dao.daoNilai;
import nilai.dao.implementNilai;
import nilai.model.nilaiModel;
import nilai.model.tableModelNilai;
import nilai.view.nilaiView;
import java.util.List;
import javax.swing.JOptionPane;
public class nilaiController {
    nilaiView frame;
    implementNilai impNilai;
    List<nilaiModel> lb;
    
    public nilaiController(nilaiView frame){
        this.frame = frame;
        impNilai = new daoNilai();
        lb = impNilai.getAll();
    }
    public void isiTable(){
        lb = impNilai.getAll();
        tableModelNilai tmb = new tableModelNilai(lb);
        frame.getTbNilai().setModel(tmb);
    }
    public void isiField(int row){
        lb = impNilai.getAll();
        frame.getInNis().setText(lb.get(row).getNis());
        frame.getInNama().setText(lb.get(row).getNama());
        frame.getInMapel().setSelectedItem(lb.get(row).getMapel());
        frame.getInSemester().setSelectedItem(lb.get(row).getSemester());
        frame.getInNilai().setText(lb.get(row).getNilai());
        frame.getInKet().setText(lb.get(row).getKeterangan());
    }
    public void insert(){
        nilaiModel b = new nilaiModel();
        b.setNis(frame.getInNis().getText());
        b.setKodemapel(frame.getInKode().getText());
        b.setSemester(frame.getInSemester().getSelectedItem().toString());
        b.setNilai(frame.getInNilai().getText());
        b.setKeterangan(frame.getInKet().getText());
        
        impNilai.insert(b);
    }
    public void update(){
        nilaiModel b = new nilaiModel();
        b.setNis(frame.getInNis().getText());
        b.setKodemapel(frame.getInKode().getText());
        b.setSemester((String) frame.getInSemester().getSelectedItem());
        b.setNilai(frame.getInNilai().getText());
        b.setKeterangan(frame.getInKet().getText());
        
        impNilai.update(b);
    }
    public void delete(){
        if(!frame.getInNis().getText().trim().isEmpty()){
            int pilih = JOptionPane.showConfirmDialog(null, "Data Nilai milik " + frame.getInNis().getText() + 
                     " Akan dihapus?", "HAPUS MAPEL!",JOptionPane.YES_NO_OPTION);
            if(pilih == JOptionPane.YES_OPTION){
                int nis = Integer.parseInt(frame.getInNis().getText());
                impNilai.delete(nis);
            }
        }else{
            JOptionPane.showMessageDialog(frame, "Pilih data yang akan dihapus");
        }
    }
    public void reset(){
        frame.getInNis().setText("");
        frame.getInMapel().setSelectedIndex(0);
        frame.getInSemester().setSelectedIndex(0);
        frame.getInNilai().setText("");
        frame.getInKet().setText("");
        frame.getInNama().setText("");
        frame.getInKode().setText("");
        frame.getInKel().setText("");
    }
    public void search(){
        if(frame.getRbNis().isSelected()){
            String nis = frame.getInNis().getText();
            impNilai.getSearchNis(nis);    
        }else if(frame.getRbNama().isSelected()){
            String nama = frame.getInNama().getText();
            impNilai.getSearchNama(nama);
        }else if(frame.getRbNilai().isSelected()){
            String nilai = frame.getInNilai().getText();
            impNilai.getSearchNis(nilai);
        }else{
            isiTable();
        }   
        isiTable();
    }
    public void mapelChange(){
        String mapel = frame.getInMapel().getSelectedItem().toString();
        lb = impNilai.mapelField(mapel);
        frame.getInKode().setText(lb.get(0).getKodemapel());
        frame.getInKel().setText(lb.get(0).getKelompok());
    }
    public void comboMapel(){
        lb = impNilai.comboBoxMapel();
        Object[] ob = new Object[10];
        for(Object data:lb){
            frame.getInMapel().addItem(data);
        }
    }
    public void tampilNama(){
        String nis = frame.getInNis().getText();
        lb = impNilai.getNamaa(nis);
        frame.getInNama().setText(lb.get(0).getNama());
    }
    public void tampilField(){
        try{
            String nis = frame.getInNis().getText();
            lb = impNilai.getData(nis);
            frame.getInNis().setText(lb.get(0).getNis());
            frame.getInNama().setText(lb.get(0).getNama());
            frame.getInMapel().setSelectedItem(lb.get(0).getMapel());
            frame.getInSemester().setSelectedItem(lb.get(0).getSemester());
            frame.getInNilai().setText(lb.get(0).getNilai());
            frame.getInKet().setText(lb.get(0).getKeterangan());
        }catch(Exception e){
            System.err.println("Error "+ e);
        }
    }
}
