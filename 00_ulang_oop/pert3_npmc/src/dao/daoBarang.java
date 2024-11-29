/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import koneksi.koneksi;
import model.barang_model;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.barang_view;
public class daoBarang implements implementBarang{
    barang_view frame;
    
    final String selectData = "SELECT * FROM barang";
    final String insertData = "INSERT INTO barang (kode, nama, harga, stock) VALUES (?, ?, ?, ?)";
    final String queryCheck = "SELECT * FROM barang WHERE kode = ?";
    final String searchQuery = "SELECT * FROM barang WHERE kode LIKE ?";
    
    Connection con;
    public daoBarang(){
        con = koneksi.connection();
    }
    
    
    @Override
    public void insert(barang_model b){
        PreparedStatement statment = null;
        PreparedStatement p = null;
        
        try{
            p = con.prepareStatement(queryCheck);
            p.setString(1, b.getKode());
            ResultSet re = p.executeQuery();
            if(re.next()){
                JOptionPane.showMessageDialog(null, "Kode Barang Sudah ada!!!", "WARNING!!", JOptionPane.WARNING_MESSAGE);
            }else{
                PreparedStatement ps = con.prepareStatement(insertData, statment.RETURN_GENERATED_KEYS);
                statment = con.prepareStatement(insertData);
                statment.setString(1, b.getKode());
                statment.setString(2, b.getNama());
                statment.setInt(3, b.getHarga());
                statment.setInt(4, b.getStock());
                statment.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                while(rs.next()){
                    b.setKode(rs.getString(1));
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                statment.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }  
    }
    
    @Override
    public List<barang_model> getAll(){
        List<barang_model> lb = null;
        try{
            lb = new ArrayList<barang_model>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(selectData);
            while(rs.next()){
                barang_model b = new barang_model();
                b.setKode(rs.getString("kode"));
                b.setNama(rs.getString("nama"));
                b.setHarga(rs.getInt("harga"));
                b.setStock(rs.getInt("stock"));
                lb.add(b);
            }
        }catch(SQLException e){
            Logger.getLogger(daoBarang.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return lb;
    }
    
    @Override
    public List<barang_model> getCariKode(String kode){
        List<barang_model> lb = null;
        try{
            lb = new ArrayList<barang_model>();
            PreparedStatement st = con.prepareStatement(searchQuery);
            st.setString(1, "%" + kode + "%");
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                barang_model b = new barang_model();
                b.setKode(rs.getString("kode"));
                b.setNama(rs.getString("nama"));
                b.setHarga(rs.getInt("harga"));
                b.setStock(rs.getInt("stock"));
                lb.add(b);
            }
        }catch(SQLException e){
            Logger.getLogger(daoBarang.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return lb;
    }
    
//    private void tb_cariActionPerformed(java.awt.event.ActionEvent evt) {                                        
//        try {
//            String sql = "Select * from tb_barang where nama_barang LIKE '"+cari+"%'";
//            java.sql.PreparedStatement pst = con.prepareStatement(sql);
//            ResultSet rs = pst.executeQuery(sql);
//            while (rs.next()){
//                no.setText(rs.getString(1));
//                nama_barang.setText(rs.getString(2));
//                id_barang.setText(rs.getString(3));
//                desk_barang.setText(rs.getString(4));
//                JOptionPane.showMessageDialog(null,"Data : "
//                + cari.getText() + " ditemukan, Apakah Anda Ingin Mengedit atau Menghapus?");
//            }
//        } catch (SQLException e){
//            System.out.println(e.getMessage());
//            }
//        cari.requestFocus();
//    }
}

