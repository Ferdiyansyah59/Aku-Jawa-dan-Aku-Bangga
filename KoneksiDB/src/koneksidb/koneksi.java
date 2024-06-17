/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksidb;

/**
 *
 * @author ferdiyansyah
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class koneksi {
    public static Connection con;
    public static Statement stm;
    public static void main(String[] args) {
        try{
            String url = "jdbc:mysql://localhost:3306/mahasiswas";
            String user = "root";
            String pw = "";
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,user,pw);
            stm = con.createStatement();
            System.out.println("Koneksi Berhasil");
        }catch(Exception e){
            System.err.println("Koneksi Gagal" + e.getMessage());
        }
    }
}
