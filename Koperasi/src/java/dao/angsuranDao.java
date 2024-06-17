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
import model.angsuran;
import model.pinjaman;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
public class angsuranDao {
    private final Connection con;
    private PreparedStatement stm;
    private ResultSet res;
    //Format Tanggal
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    private String getData = "SELECT pinjaman.nopinjaman, angsuran.angsurke, anggota.noanggota, anggota.nama, angsuran.besarangsur, angsuran.sisapinjaman, karyawan.nama FROM angsuran, anggota,pinjaman, karyawan WHERE angsuran.nopinjaman = pinjaman.nopinjaman and angsuran.nokaryawan = karyawan.nik and anggota.noanggota = pinjaman.noanggota";
    private String postData = "INSERT INTO angsuran (nopinjaman, angsurke, tglangsur, besarangsur, sisapinjaman, nokaryawan) VALUES(?, ?, ?, ?, ?, ?)"; 
    private String putData = "UPDATE angsuran SET angsurke=?, tglangsur=?, besarangsur=?, sisapinjaman=?, nokaryawan=? WHERE nopinjaman=?"; 
    private String deleteData = "DELETE FROM angsuran WHERE nopinjaman=?";
    private String getNo = "SELECT*, anggota.noanggota, anggota.nama FROM angsuran WHERE nopinjaman=?";
    private String getPinjaman = "SELECT pinjaman.nopinjaman, pinjaman.noanggota, anggota.nama FROM pinjaman, anggota WHERE pinjaman.nopinjaman and pinjaman.noanggota = anggota.noanggota;";
    private String getAngka = "SELECT pinjaman.nopinjaman, pinjaman.angsuranpokok, pinjaman.angsuranbunga, pinjaman.noanggota, anggota.nama, pinjaman.pokokpinjaman, pinjaman.bungapinjaman, angsuran.angsurke, angsuran.besarangsur FROM pinjaman,anggota, angsuran WHERE pinjaman.nopinjaman=? and angsuran.nopinjaman=? and pinjaman.noanggota=anggota.noanggota;";
    public angsuranDao(){
        con = koneksi.getKoneksi();
    }
    public ArrayList<angsuran>getAllAngsuran(){
        ArrayList<angsuran>listAngsuran = new ArrayList();
        try{
            stm = con.prepareStatement(getData);
            res = stm.executeQuery();
            while(res.next()){
                angsuran awa = new angsuran();
                awa.setNopinjaman(res.getString("nopinjaman"));
                awa.setAngsuranke(res.getString("angsurke"));
                awa.setNoanggota(res.getString("noanggota"));
                awa.setNamaanggota(res.getString("anggota.nama"));
                awa.setBesarangsur(res.getString("besarangsur"));
                awa.setSisapinjaman(res.getString("sisapinjaman"));
                awa.setNamakaryawan(res.getString("karyawan.nama"));
                listAngsuran.add(awa);
            }
        }catch(SQLException e){
            System.err.println("Ada Kesalahan di getAll "+e);
        }
        return listAngsuran;
    }
    
    public angsuran getRecordByNo(String nopinjaman){
        angsuran awa = new angsuran();  
        try{
           stm = con.prepareStatement(getNo); 
           stm.setString(1, nopinjaman);
           res = stm.executeQuery();
           if(res.next()){
               awa.setNopinjaman(res.getString("nopinjaman"));
               awa.setAngsuranke(res.getString("angsurke"));
               awa.setTglangsur(res.getString("tglangsur"));
               awa.setBesarangsur(res.getString("besarangsur"));
               awa.setSisapinjaman(res.getString("sisapinjaman"));
               awa.setNokaryawan(res.getString("nokaryawan"));
               awa.setNoanggota(res.getString("noanggota"));
               awa.setNamaanggota(res.getString("nama"));
           }
        }catch(SQLException e){
            System.err.println("Ada kesalahan di getRecord "+e);
        }
        return awa;
    }
    
    public ArrayList<angsuran> getRupiah(String nopinjaman){
        ArrayList<angsuran>listRupi = new ArrayList();
        try{
            angsuran awa = new angsuran();
            stm = con.prepareStatement(getAngka);
            stm.setString(1, nopinjaman);
            stm.setString(2, nopinjaman);
            res = stm.executeQuery();
            while(res.next()){
                awa.setPokokpinjaman(res.getString("pokokpinjaman"));
                awa.setBungapinjaman(res.getString("bungapinjaman"));
                awa.setAngsuranke(res.getString("angsurke"));
                awa.setBesarangsur(res.getString("besarangsur"));
                awa.setNopinjaman(res.getString("nopinjaman"));
                awa.setNoanggota(res.getString("noanggota"));
                awa.setNamaanggota(res.getString("nama"));
                awa.setAngsuranpokok(res.getString("angsuranpokok"));
                awa.setAngsuranbunga(res.getString("angsuranbunga"));
                listRupi.add(awa);
            }
        }catch(SQLException e){
            System.err.println("Ada kesalahan di getRupiah: " + e);
        }
        return listRupi;
    }
    
    public ArrayList<pinjaman>getPinjaman(){
        ArrayList<pinjaman>listpinjaman = new ArrayList();
        try{
            stm = con.prepareStatement(getPinjaman);
            res = stm.executeQuery();
            if(res.next()){
                pinjaman pin = new pinjaman();
                pin.setNopinjaman(res.getString("nopinjaman"));
                pin.setNoanggota(res.getString("noanggota"));
                pin.setNamaAnggota(res.getString("nama"));
                listpinjaman.add(pin);
            }  
        }catch(SQLException e){
            System.err.println("Terjadi Kesalahan di getPinjaman "+e);
        }
        return listpinjaman;
    }
    
    public void simpanData(angsuran awa){
        try{
            stm = con.prepareStatement(postData);
            stm.setString(1, awa.getNopinjaman());
            stm.setString(2, awa.getAngsuranke());
            stm.setString(3, awa.getTglangsur());
            stm.setString(4, awa.getBesarangsur());
            stm.setString(5, awa.getSisapinjaman());
            stm.setString(6, awa.getNokaryawan());
            stm.executeUpdate();
        }catch(SQLException e){
            System.err.println("Terjadi kesalahan di simpanData "+e);
        }
    }
    
    public void editData(angsuran awa){
        try{
            stm = con.prepareStatement(putData);
            stm.setString(1, awa.getAngsuranke());
            stm.setString(2, awa.getTglangsur());
            stm.setString(3, awa.getBesarangsur());
            stm.setString(4, awa.getSisapinjaman());
            stm.setString(5, awa.getNokaryawan());
            stm.setString(6, awa.getNopinjaman());
            stm.executeUpdate();
        }catch(SQLException e){
            System.err.println("Terjadi kesalahan di editData "+e);
        }
    }
    
    public void hapusData(String nopinjaman){
        try{
            stm = con.prepareStatement(deleteData);
            stm.setString(1, nopinjaman);
            stm.executeUpdate();
        }catch(SQLException e){
            System.err.println("Terjadi Kesalahan di hapus "+e);
        }
    }
    
    public static void main(String[] args) {
        angsuranDao angdo = new angsuranDao();
        System.out.println(angdo.getRupiah("101010"));
        angsuran awa = new angsuran();
        
        awa.setNopinjaman("123456");
        awa.setAngsuranke("1");
        awa.setTglangsur("2020-12-12");
        awa.setBesarangsur("1000000");
        awa.setSisapinjaman("1000");
        awa.setNokaryawan("10101010");
        angdo.simpanData(awa);
        
    }
}
