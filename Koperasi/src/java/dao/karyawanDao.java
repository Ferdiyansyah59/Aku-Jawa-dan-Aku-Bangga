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
import model.karyawan;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
public class karyawanDao {
    private final Connection con;
    private PreparedStatement PreStmt;
    private ResultSet res;
    //Format Tanggal
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    

    public karyawanDao(){
        con = koneksi.getKoneksi();
    }
    
//    Methode untuk mengambil data pada tabel dan disimpan ke dalam ArrayList
    public ArrayList<karyawan>getAllKaryawan(){
        ArrayList<karyawan>listKaryawan = new ArrayList();
        try{
            String sqlAllKaryawan = "SELECT*FROM karyawan ORDER BY nik ";
            PreStmt = con.prepareStatement(sqlAllKaryawan);
            res = PreStmt.executeQuery();
            while(res.next()){
                karyawan kar = new karyawan();   //buat objek karyawan
                kar.setNik(res.getString("nik"));
                kar.setNama(res.getString("nama"));            
                if(res.getString("gender") != null){
                    if((res.getString("gender")).equals("L"))
                    kar.setGender("Laki-Laki");
                    else kar.setGender("Perempuan");
                }else{
                    kar.setGender("");
                }
                if(res.getString("tmplahir") != null){
                    kar.setTmpLahir(res.getString("tmplahir"));
                }else{
                    kar.setTmpLahir("");    
                }
                if(res.getDate("tgllahir") != null){
//                    String tanggal = sdf.format(res.getDate("tgllahir"));
//                    kar.setTglLahir(tanggal);
                      kar.setTglLahir(sdf.format(res.getDate("tgllahir")));
                }else{
                    kar.setTglLahir("");
                }
                
                if(res.getString("alamat") != null){
                    kar.setAlamat(res.getString("alamat"));
                }else{
                    kar.setAlamat("");
                }
                
                if(res.getString("telepon") != null){
                    kar.setTelepon(res.getString("telepon"));
                }else{
                    kar.setTelepon("");
                }
                
                listKaryawan.add(kar); //Menambah objek karyawan ke Array List
            }
        }catch(SQLException e){
            System.out.println("Ada Kesalahan " + e);
        }
        return listKaryawan; //mengirim kembali berupa seluruh data karyawan yang sudah dianmbil
    }
    
    public void simpanData(karyawan kar, String page){
        String sqlSimpan = null;
        if(page.equals("edit")){
            sqlSimpan = "UPDATE karyawan SET nama=?, gender=?, tmplahir=?, tgllahir=?, alamat=?, telepon=? WHERE nik=?";
        }else if(page.equals("tambah")){
            sqlSimpan = "INSERT INTO karyawan (nama, gender, tmplahir, tgllahir, alamat, telepon, nik) VALUES (?,?,?,?,?,?,?)";
        }
        try{
            PreStmt = con.prepareStatement(sqlSimpan);
            PreStmt.setString(1, kar.getNama());
            if(kar.getGender().equals(""))PreStmt.setString(2, null);
            else PreStmt.setString(2, kar.getGender());
            PreStmt.setString(3, kar.getTmpLahir());
            if(kar.getTglLahir().equals("")) PreStmt.setString(4, null);
            else PreStmt.setString(4, kar.getTglLahir());
            PreStmt.setString(5, kar.getAlamat());
            PreStmt.setString(6, kar.getTelepon());
            PreStmt.setString(7, kar.getNik());
            
            PreStmt.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public karyawan getRecordByNik(String nik){
        karyawan kar = new karyawan();
        String sqlSearch = "SELECT*FROM karyawan WHERE nik=?";
        try{
            PreStmt = con.prepareStatement(sqlSearch);
            PreStmt.setString(1, nik);
            res = PreStmt.executeQuery();
            if(res.next()){
                kar.setNik(res.getString("nik"));
                kar.setNama(res.getString("nama"));
                kar.setGender(res.getString("gender"));
                kar.setTmpLahir(res.getString("tmplahir"));
                kar.setTglLahir(res.getString("tgllahir"));
                kar.setAlamat(res.getString("alamat"));
                kar.setTelepon(res.getString("telepon"));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return kar;
    }
    
    public void hapusData(String nik){
        String query = "DELETE FROM karyawan WHERE nik=?";
        try{
            PreStmt = con.prepareStatement(query);
            PreStmt.setString(1, nik);
            PreStmt.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public static void main(String[] args) {
        karyawanDao kardo = new karyawanDao();
        System.out.println(kardo.getAllKaryawan());
    }
}
