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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import nilai.koneksi.koneksi;
import nilai.view.nilaiView;
import nilai.model.nilaiModel;
public class daoNilai implements implementNilai {
    nilaiView frame;
    ResultSet res = null;
    PreparedStatement st = null;
    Connection con;
    final String insert = "INSERT INTO nilai (nis, kodemapel, semester, nilai, keterangan) VALUES (?,?,?,?,?)";
    final String update = "UPDATE nilai SET kodemapel=? , semester=?, nilai=?, keterangan=? where nis=?";
    final String delete = "DELETE FROM nilai WHERE nis=?";
    final String select = "SELECT siswa.nis, siswa.nama, mapel.mapel, nilai.semester, nilai.nilai, nilai.keterangan FROM siswa, mapel, nilai WHERE siswa.nis = nilai.nis and mapel.kode = nilai.kodemapel";
    final String searchNis = "SELECT siswa.nis, siswa.nama, mapel.mapel, nilai.semester,nilai.nilai, nilai.keterangan FROM siswa, mapel, nilai WHERE siswa.nis = nilai.nis and mapel.kode = nilai.kodemapel and nilai.nis like?";
    final String searchNama = "SELECT siswa.nis, siswa.nama, mapel.mapel, nilai.semester,nilai.nilai, nilai.keterangan FROM siswa, mapel, nilai WHERE siswa.nis = nilai.nis and mapel.kode = nilai.kodemapel and siswa.nama like?";
    final String searchNilai = "SELECT siswa.nis, siswa.nama, mapel.mapel, nilai.semester,nilai.nilai, nilai.keterangan FROM siswa, mapel, nilai WHERE siswa.nis = nilai.nis and mapel.kode = nilai.kodemapel and nilai.nilai like?";
    final String mapell = "SELECT kode, kelompok FROM mapel WHERE mapel=?";
    final String comboMapel = "SELECT mapel FROM mapel";
    final String nama = "SELECT nama FROM siswa WHERE nis=?";
    final String tampilAllField = "SELECT nilai.nis, siswa.nama, nilai.semester, mapel.mapel, nilai.kodemapel, nilai.nilai, nilai.keterangan FROM siswa, mapel, nilai WHERE nilai.nis = siswa.nis and nilai.kodemapel = mapel.kode and nilai.nis like ?";
    public daoNilai(){
        con = koneksi.connection();
    }

    @Override
    public void insert(nilaiModel b) {
        PreparedStatement statement = null;
        try{
            st = con.prepareStatement(insert, st.RETURN_GENERATED_KEYS);
            st.setString(1, b.getNis());
            st.setString(2, b.getKodemapel());
            st.setString(3, b.getSemester());
            st.setString(4, b.getNilai());
            st.setString(5, b.getKeterangan());
            st.executeUpdate();
            res = st.getGeneratedKeys();
            while(res.next()){
                b.setNis(res.getString("1"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                st.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(nilaiModel b) {
        try{
            st = con.prepareStatement(update);
            st.setString(1, b.getKodemapel());
            st.setString(2, b.getSemester());
            st.setString(3, b.getNilai());
            st.setString(4, b.getKeterangan());
            st.setString(5, b.getNis());
            st.executeUpdate();  
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                st.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
       try{
            st = con.prepareStatement(delete);
            st.setInt(1, id);
            st.executeUpdate();
        }catch(SQLException ex) {
            ex.printStackTrace();
        }finally{
            try{
                st.close();
            }catch(SQLException e){
                e.printStackTrace();
            } 
        }
    }
    
    @Override
    public List<nilaiModel>mapelField(String mapel){
        List<nilaiModel> lb = null;
        try{ 
            lb = new ArrayList<nilaiModel>();
            st = con.prepareStatement(mapell);
            st.setString(1, mapel);
            res = st.executeQuery();
            nilaiModel b = new nilaiModel();
            if(res.next()){       
                b.setKodemapel(res.getString("kode"));
                b.setKelompok(res.getString("kelompok"));
                lb.add(b);  
            }
        }catch(SQLException e){
            Logger.getLogger(daoNilai.class.getName()).log(Level.SEVERE, null, e);
        }
        return lb;
    }
 
    @Override
    public List<nilaiModel>comboBoxMapel(){
        List<nilaiModel> lb = null;
        try{ 
            lb = new ArrayList<nilaiModel>();
            Statement stt = con.createStatement();
            res = stt.executeQuery(comboMapel);
            while(res.next()){
                nilaiModel b = new nilaiModel();
                b.setMapel(res.getString("mapel"));
                lb.add(b);
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return lb;
    }
    
    @Override
    public List<nilaiModel>getNamaa(String nis){
        List<nilaiModel> lb = null;
        try{ 
            lb = new ArrayList<nilaiModel>();
            st = con.prepareStatement(nama);
            st.setString(1, nis);
            res = st.executeQuery();
            nilaiModel b = new nilaiModel();
            if(res.next()){       
                b.setNama(res.getString("nama"));
                lb.add(b);  
            }else{
                b.setNama("");
                lb.add(b);
            }
        }catch(SQLException e){
            Logger.getLogger(daoNilai.class.getName()).log(Level.SEVERE, null, e);
        }
        return lb;
    }
    
    @Override
    public List<nilaiModel> getAll() {
      List<nilaiModel> lb = null;
      try{
          lb = new ArrayList<nilaiModel>();
          Statement stt = con.createStatement();
          res = stt.executeQuery(select);
          while(res.next()){
              nilaiModel b = new nilaiModel();
              b.setNis(res.getString("nis"));
              b.setNama(res.getString("nama"));
              b.setMapel(res.getString("mapel"));
              b.setSemester(res.getString("semester"));
              b.setNilai(res.getString("nilai"));
              b.setKeterangan(res.getString("keterangan"));
              lb.add(b);
            }
        }catch(SQLException e){
            Logger.getLogger(daoNilai.class.getName()).log(Level.SEVERE, null, e);
        }
      return lb;
    }

    @Override
    public List<nilaiModel> getSearchNis(String nis) {
        List<nilaiModel> lb = null;
        try{    
            lb = new ArrayList<nilaiModel>();
            st = con.prepareStatement(searchNis);
            st.setString(1, "%" + nis + "%");  
            res = st.executeQuery();   
            while(res.next()){
                nilaiModel b = new nilaiModel();
                b.setNis(res.getString("nis"));
                b.setNama(res.getString("nama"));
                b.setMapel(res.getString("mapel"));
                b.setSemester(res.getString("semester"));
                b.setNilai(res.getString("nilai"));
                b.setKeterangan(res.getString("keterangan"));
                lb.add(b);
            }
        }catch(SQLException e){
            Logger.getLogger(daoNilai.class.getName()).log(Level.SEVERE, null, e);
        }
        return lb;
    }
    @Override
    public List<nilaiModel> getSearchNama(String nama) {
        List<nilaiModel> lb = null;
        try{    
            lb = new ArrayList<nilaiModel>();
            st = con.prepareStatement(searchNis);
            st.setString(1, "%" + nama + "%");  
            res = st.executeQuery();
            while(res.next()){
                nilaiModel b = new nilaiModel();
                b.setNis(res.getString("nis"));
                b.setNama(res.getString("nama"));
                b.setMapel(res.getString("mapel"));
                b.setSemester(res.getString("semester"));
                b.setNilai(res.getString("nilai"));
                b.setKeterangan(res.getString("keterangan"));
                lb.add(b);
            }
        }catch(SQLException e){
            Logger.getLogger(daoNilai.class.getName()).log(Level.SEVERE, null, e);
        }
        return lb;
    }
    @Override
    public List<nilaiModel> getSearchNilai(String nilai) {
        List<nilaiModel> lb = null;
        try{    
            lb = new ArrayList<nilaiModel>();
            st = con.prepareStatement(searchNis);
            st.setString(1, "%" + nilai + "%");  
            res = st.executeQuery();
            while(res.next()){
                nilaiModel b = new nilaiModel();
                b.setNis(res.getString("nis"));
                b.setNama(res.getString("nama"));
                b.setMapel(res.getString("mapel"));
                b.setSemester(res.getString("semester"));
                b.setNilai(res.getString("nilai"));
                b.setKeterangan(res.getString("keterangan"));
                lb.add(b);
            }
        }catch(SQLException e){
            Logger.getLogger(daoNilai.class.getName()).log(Level.SEVERE, null, e);
        }
        return lb;
    }
    @Override
    public List<nilaiModel> getData(String nis) {
        List<nilaiModel> lb = null;
        try{
            lb = new ArrayList<nilaiModel>();
            st = con.prepareStatement(tampilAllField);
            st.setString(1, nis);
            res = st.executeQuery();
            nilaiModel b = new nilaiModel();  
            if (res.next()) {
                b.setNis(res.getString("nis"));
                b.setNama(res.getString("nama"));
                b.setMapel(res.getString("mapel"));
                b.setSemester(res.getString("semester"));
                b.setNilai(res.getString("nilai"));
                b.setKeterangan(res.getString("keterangan"));
                lb.add(b);
            }else{
//                b.setMapel("");
//                b.setSemester("");
//                b.setNilai("");
//                b.setKeterangan("");
//                lb.add(b);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(daoNilai.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb;
    }
    
}
