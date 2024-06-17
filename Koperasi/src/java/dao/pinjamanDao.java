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
import model.pinjaman;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
public class pinjamanDao {
    private final Connection con;
    private PreparedStatement stm;
    private ResultSet res;
    //Format Tanggal
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    private String getData = "select pinjaman.nopinjaman, anggota.noanggota, anggota.nama, pinjaman.tglpinjaman, pinjaman.pokokpinjaman, pinjaman.bungapinjaman, pinjaman.lamapinjaman, pinjaman.angsuranpokok, pinjaman.angsuranbunga, karyawan.nama FROM pinjaman, anggota, karyawan WHERE pinjaman.noanggota = anggota.noanggota and pinjaman.accpetugas = karyawan.nik;";
    private String postData = "INSERT INTO pinjaman (nopinjaman, noanggota, tglpinjaman, pokokpinjaman, bungapinjaman, lamapinjaman, angsuranpokok, angsuranbunga, accpetugas) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private String putData = "UPDATE pinjaman SET noanggota=?, tglpinjaman=?, pokokpinjaman=?, bungapinjaman=?, lamapinjaman=?, angsuranpokok=?, angsuranbunga=?, accpetugas=? WHERE nopinjaman=?";
    private String deleteData = "DELETE FROM pinjaman WHERE nopinjaman=?";
    private String getno = "SELECT pinjaman.*, anggota.nama FROM pinjaman, anggota WHERE nopinjaman=? and pinjaman.noanggota = anggota.noanggota";
    
    public pinjamanDao(){
        con = koneksi.getKoneksi();
    }
    
    public ArrayList<pinjaman>getAllPinjaman(){
        ArrayList<pinjaman>listPinjaman = new ArrayList();
        try{
            stm = con.prepareStatement(getData);
            res = stm.executeQuery();
            while(res.next()){
                pinjaman pin = new pinjaman();
                pin.setNopinjaman(res.getString("nopinjaman"));
                pin.setNoanggota(res.getString("noanggota"));
                pin.setNamaAnggota(res.getString("anggota.nama")); 
                pin.setTglpinjaman(sdf.format(res.getDate("tglpinjaman")));
                pin.setPokokpinjaman(res.getString("pokokpinjaman"));
                pin.setBungapinjaman(res.getString("bungapinjaman"));
                pin.setLamapinjaman(res.getString("lamapinjaman"));
                pin.setAngsuranpokok(res.getString("angsuranpokok"));
                pin.setAngsuranbunga(res.getString("angsuranbunga"));
                pin.setAccpetugas(res.getString("karyawan.nama"));
                listPinjaman.add(pin);
            }   
        }catch(SQLException e){
            System.out.println("Ada Kesalahan di getAll: " + e);
        }
        return listPinjaman; //mengirim kembali berupa seluruh data karyawan yang sudah dianmbil
    }
    
    public pinjaman getRecordbyNo(String nopinjaman){
        pinjaman pin = new pinjaman();
        try{
            stm = con.prepareStatement(getno);
            stm.setString(1, nopinjaman);
            res = stm.executeQuery();
            if(res.next()){
                pin.setNopinjaman(res.getString("nopinjaman"));
                pin.setNoanggota(res.getString("noanggota"));
                pin.setTglpinjaman(res.getString("tglpinjaman"));
                pin.setPokokpinjaman(res.getString("pokokpinjaman"));
                pin.setBungapinjaman(res.getString("bungapinjaman"));
                pin.setLamapinjaman(res.getString("lamapinjaman"));
                pin.setAngsuranpokok(res.getString("angsuranpokok"));
                pin.setAngsuranbunga(res.getString("angsuranbunga"));
                pin.setAccpetugas(res.getString("accpetugas"));
                pin.setNamaAnggota(res.getString("anggota.nama"));
            }
        }catch(SQLException e){
            System.out.println("Ada Kesalahan di Record No: " + e);
        }
        return pin;
    }
    
    public void simpanData(pinjaman pin){
        try{
            stm = con.prepareStatement(postData);
            stm.setString(1, pin.getNopinjaman());
            stm.setString(2, pin.getNoanggota());
            stm.setString(3, pin.getTglpinjaman());
            stm.setString(4, pin.getPokokpinjaman());
            stm.setString(5, pin.getBungapinjaman());
            stm.setString(6, pin.getLamapinjaman());
            stm.setString(7, pin.getAngsuranpokok());
            stm.setString(8, pin.getAngsuranbunga());
            stm.setString(9, pin.getAccpetugas());
            stm.executeUpdate();
            
        }catch(SQLException e){
            System.out.println("Ada Kesalahan di simpan data: " + e);
        }
    }
    
    public void editData(pinjaman pin){
        try{
            stm = con.prepareStatement(putData);
            stm.setString(1, pin.getNoanggota());
            stm.setString(2, pin.getTglpinjaman());
            stm.setString(3, pin.getPokokpinjaman());
            stm.setString(4, pin.getBungapinjaman());
            stm.setString(5, pin.getLamapinjaman());
            stm.setString(6, pin.getAngsuranpokok());
            stm.setString(7, pin.getAngsuranbunga());
            stm.setString(8, pin.getAccpetugas());
            stm.setString(9, pin.getNopinjaman());
            stm.executeUpdate();
        }catch(SQLException e){
            System.out.println("Ada kesalahan di edit Data " + e);
        }
    }
    
    public void hapusData(String nopinjaman){
        try{
            stm = con.prepareStatement(deleteData);
            stm.setString(1, nopinjaman);
            stm.executeUpdate();
        }catch(SQLException e){
            System.out.println("Terjadi kesalahan di hapus "+e);
        }
    }
    
    public static void main(String[] args) {
        pinjamanDao pinjam = new pinjamanDao();
        System.out.println(pinjam.getAllPinjaman());
        pinjaman pin = new pinjaman();
    }
}
