/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pert2_10121480;

/**
 *
 * @author ferdi
 */
import java.sql.*;
public class koneksi {
    static Connection con;
    
    public static Connection connection(){
        try{
            System.out.println("Connecting...");
            String url = "jdbc:mysql://localhost/sewa_ruang_10121480";
            String user = "root";
            String pw = "";
            
            con = DriverManager.getConnection(url, user, pw);
            System.out.println("Connected");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return con;
    }
//    psvm ---?> TAB
    public static void main(String[] args) {
        connection();
    }
}
