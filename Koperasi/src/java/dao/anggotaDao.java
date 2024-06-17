/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author ferdiyansyah
 */
import connection.koneksi;
import model.anggota;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
public class anggotaDao {
    private final Connection con;
    private PreparedStatement stm;
    private ResultSet res;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    
    final String getAnggota = "SELECT*FROM anggota ORDER BY noanggota";
    final String postAnggota = "INSERT INTO anggota (noanggota, nama, gender, tmplahir, tgllahir, alamat, telepon) VALUES (?, ?, ?,?, ?, ?, ?)";
    final String putAnggota = "UPDATE anggota SET nama=? , gender=? , tmplahir=?, tgllahir=?, alamat=?, telepon=? WHERE noanggota=?";
    final String deleteAnggota = "DELETE FROM anggota WHERE noanggota=?";
    final String getNoanggota = "SELECT*FROM anggota WHERE noanggota=?";
    
    public anggotaDao(){
        con = koneksi.getKoneksi();         
    }
    
    public ArrayList<anggota>getAllAnggota(){
        ArrayList<anggota>listAnggota = new ArrayList();
        try{
            stm = con.prepareStatement(getAnggota);
            res = stm.executeQuery();
            while(res.next()){
                anggota awa = new anggota();
                awa.setNoanggota(res.getString("noanggota"));
                awa.setNama(res.getString("nama"));
                if(res.getString("gender") != null){
                    if((res.getString("gender")).equals("L"))
                    awa.setGender("Laki-Laki");
                    else awa.setGender("Perempuan");
                }else{
                    awa.setGender("");
                }
                if(res.getString("tmplahir") != null){
                    awa.setTmplahir(res.getString("tmplahir"));
                }else{
                    awa.setTmplahir("");    
                }
                if(res.getDate("tgllahir") != null){
                      awa.setTgllahir(sdf.format(res.getDate("tgllahir")));
                }else{
                    awa.setTgllahir("");
                }
                
                if(res.getString("alamat") != null){
                    awa.setAlamat(res.getString("alamat"));
                }else{
                    awa.setAlamat("");
                }
                
                if(res.getString("telepon") != null){
                    awa.setTelepon(res.getString("telepon"));
                }else{
                    awa.setTelepon("");
                }
                listAnggota.add(awa);
            }
        }catch(SQLException e){
            System.err.println(e);
        }
        return listAnggota;
    }
    
    public anggota getRecordByNo(String noanggota){
        anggota awa = new anggota();
        try{
            stm = con.prepareStatement(getNoanggota);
            stm.setString(1, noanggota);
            res = stm.executeQuery();
            if(res.next()){
                awa.setNoanggota(res.getString("noanggota"));
                awa.setNama(res.getString("nama"));
                awa.setGender(res.getString("gender"));
                awa.setTmplahir(res.getString("tmplahir"));
                awa.setTgllahir(res.getString("tgllahir"));
                awa.setAlamat(res.getString("alamat"));
                awa.setTelepon(res.getString("telepon"));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return awa;
    }
    
    public void simpanData(anggota agg){
        try{
            stm = con.prepareStatement(postAnggota);
            stm.setString(1, agg.getNoanggota());
            stm.setString(2, agg.getNama());
            if(agg.getGender().equals(""))stm.setString(3, null);
            else stm.setString(3, agg.getGender());
            stm.setString(4, agg.getTmplahir());
            if(agg.getTgllahir().equals("")) stm.setString(5, null);
            else stm.setString(5, agg.getTgllahir());
            stm.setString(6, agg.getAlamat());
            stm.setString(7, agg.getTelepon());
            
            
            stm.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void editData(anggota agg){
        try{
            stm = con.prepareStatement(putAnggota);
            stm.setString(1, agg.getNama());
            if(agg.getGender().equals(""))stm.setString(2, null);
            else stm.setString(2, agg.getGender());
            stm.setString(3, agg.getTmplahir());
            if(agg.getTgllahir().equals("")) stm.setString(4, null);
            else stm.setString(4, agg.getTgllahir());
            stm.setString(5, agg.getAlamat());
            stm.setString(6, agg.getTelepon());
            stm.setString(7, agg.getNoanggota());
            
            stm.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void hapusData(String noanggota){
        try{
            stm = con.prepareStatement(deleteAnggota);
            stm.setString(1, noanggota);
            stm.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public static void main(String[] args) {
        anggotaDao agdo = new anggotaDao();
        System.out.println(agdo.getAllAnggota());
        
    }
    
}
