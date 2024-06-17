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
import bukutelepon.koneksi.koneksi;
import bukutelepon.model.bukutelepon_model;
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
import bukutelepon.view.bukutelepon_view;
public class daoBukuTelepon implements implementBukutelepon {
    bukutelepon_view frame;
    Connection connection;
    final String insert = "INSERT INTO buku (nope, nama, alamat) VALUES (?, ?, ?);";
    final String update = "UPDATE buku SET nope=?, nama=?, alamat=? where id=? ;";
    final String delete = "DELETE FROM buku WHERE id=? ;";
    final String select = "SELECT * FROM buku;";
    final String carinama = "SELECT * FROM buku WHERE nama LIKE ?";
    final String query = "SELECT * FROM buku WHERE nope=?";
    
    public daoBukuTelepon(){
        connection = koneksi.connection();
    }
    

    @Override
    public void insert(bukutelepon_model b) {
        PreparedStatement statement = null;
        PreparedStatement p = null;
        try{
            p = connection.prepareStatement(query);
            p.setString(1, b.getNope());
            ResultSet re = p.executeQuery();          
            if(re.next()){
                JOptionPane.showMessageDialog(null, "Nomor Telepon Sudah Terdaftar","WARNING!!", JOptionPane.WARNING_MESSAGE);
            }else{
                PreparedStatement ps = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
                statement = connection.prepareStatement(insert);
                statement.setString(1, b.getNope());
                statement.setString(2, b.getNama());
                statement.setString(3, b.getAlamat());
                statement.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                while(rs.next()){
                    b.setId(rs.getInt(1));
                }
            }        
        }catch(SQLException ex) {
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }      
    }

    @Override
    public void update(bukutelepon_model b) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            statement.setString(1, b.getNope());
            statement.setString(2, b.getNama());
            statement.setString(3, b.getAlamat());
            statement.setInt(4, b.getId());
            statement.executeUpdate();
        }catch(SQLException ex) {
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch(SQLException ex) {
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<bukutelepon_model> getAll() {
        List<bukutelepon_model> lb = null;
        try{    
            lb = new ArrayList<bukutelepon_model>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                bukutelepon_model b = new bukutelepon_model();
                b.setId(rs.getInt("id"));
                b.setNope(rs.getString("nope"));
                b.setNama(rs.getString("nama"));
                b.setAlamat(rs.getString("alamat"));
                lb.add(b);
            }
        }catch(SQLException e){
            Logger.getLogger(daoBukuTelepon.class.getName()).log(Level.SEVERE, null, e);
        }
        return lb;
    }

    @Override
    public List<bukutelepon_model> getCariNama(String nama) {
        List<bukutelepon_model> lb = null;
        try{    
            lb = new ArrayList<bukutelepon_model>();
            PreparedStatement st = connection.prepareStatement(carinama);
            st.setString(1, "%" + nama + "%");  
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                bukutelepon_model b = new bukutelepon_model();
                b.setId(rs.getInt("id"));
                b.setNope(rs.getString("nope"));
                b.setNama(rs.getString("nama"));
                b.setAlamat(rs.getString("alamat"));
                lb.add(b);
            }
        }catch(SQLException e){
            Logger.getLogger(daoBukuTelepon.class.getName()).log(Level.SEVERE, null, e);
        }
        return lb;
    }
    
}
