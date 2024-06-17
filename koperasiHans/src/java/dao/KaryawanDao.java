package dao;

import connection.koneksi;
import model.Karyawan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class KaryawanDao {
    private final Connection Koneksi;
    private PreparedStatement ps;
    private ResultSet  rs;
    private SimpleDateFormat sdf  = new SimpleDateFormat("dd-MM-yyyy");
    
    public KaryawanDao(){
        Koneksi = koneksi.Connection();
    }
    
    public ArrayList<Karyawan> getAllKaryawan(){
        ArrayList<Karyawan> listKaryawan = new ArrayList<>();
        try{
            String querySelect = "SELECT * FROM karyawan ORDER BY nik";
            ps = Koneksi.prepareStatement(querySelect);
            rs = ps.executeQuery();
            while(rs.next()){
                Karyawan karyawan = new Karyawan();
                karyawan.setNik(rs.getString("nik"));
                karyawan.setNama(rs.getString("nama"));
                if ((rs.getString("gender")).equals("L")) {
                    karyawan.setGender("Laki-Laki");
                }else{
                    karyawan.setGender("Perempuan");
                }
                karyawan.setTmpLahir(rs.getString("tmplahir"));
                String tanggal = sdf.format(rs.getDate("tgllahir"));
                karyawan.setTglLahir(tanggal);
                
                karyawan.setAlamat(rs.getString("alamat"));
                karyawan.setTelepon(rs.getString("telepon"));
                listKaryawan.add(karyawan);
            }
        }
        catch(SQLException e){
            System.out.println("Error : " + e);
        }
        return listKaryawan;
    }
    
    public static void main(String[] args) {
        KaryawanDao kardao = new KaryawanDao();
        System.out.println(kardao.getAllKaryawan());
    }
}
