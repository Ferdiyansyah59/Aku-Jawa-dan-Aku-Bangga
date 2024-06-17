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
import model.login;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class loginDao {
    private final Connection con;
    private PreparedStatement stm;
    private ResultSet res;
    
    private String query = "SELECT user.*, karyawan.nama FROM user, karyawan WHERE userid=? and user.nik = karyawan.nik";
    private String getUser = "SELECT user.*, karyawan.nama FROM user, karyawan WHERE userid and user.nik = karyawan.nik";
    private String postUser = "INSERT INTO user(userid, password, nik, level, aktif) VALUES (?, ?, ?, ?, ?)";
    
    public loginDao(){
        con = koneksi.getKoneksi();
    } 
    
    public ArrayList<login>getDataUser(){
        ArrayList<login>listLogin = new ArrayList();
        try{
            stm = con.prepareStatement(getUser);
            res = stm.executeQuery();
            while(res.next()){
                login log = new login();
                log.setUserid(res.getString("userid"));
                log.setPassword(res.getString("password"));
                log.setNik(res.getString("nik"));
                log.setLevel(res.getString("level"));
                log.setAktif(res.getString("aktif"));
                log.setNamakaryawan(res.getString("nama"));
                listLogin.add(log);
            }
        }catch(SQLException e){
            System.err.println("Ada error di getUser " + e);
        }
        return listLogin;
    }
    
    public login getLogin(String userid){
        login log = new login();
        try{
            stm = con.prepareStatement(query);
            stm.setString(1, userid);
            res = stm.executeQuery();
            if(res.next()){
                log.setUserid(res.getString("userid"));
                log.setPassword(res.getString("password"));
                log.setNik(res.getString("nik"));
                log.setLevel(res.getString("level"));
                log.setAktif(res.getString("aktif"));
                log.setNamakaryawan(res.getString("nama"));
            }else{
                System.out.println("Gaada");
            }
        }catch(SQLException e){
            System.err.println("Ada kesalahan di getLogin "+e);
        }
        return log;
    }
    
    public void simpanData(login log){
        try{
            stm = con.prepareStatement(postUser);
            stm.setString(1, log.getUserid());
            stm.setString(2, log.getPassword());
            stm.setString(3, log.getNik());
            stm.setString(4, log.getLevel());
            stm.setString(5, log.getAktif());
            stm.executeUpdate();
        }catch(SQLException e){
            System.err.println("Terjadi kesalahan di simpan Data "+e);
        }
    }
    
    public static void main(String[] args) {
        loginDao logdo = new loginDao();  
    }
}
