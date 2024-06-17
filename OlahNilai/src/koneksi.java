/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ferdiyansyah
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class koneksi {
    private static Connection con = null;
    
    public static Connection getConnection(){
        if(con != null)
            return con;
        else{
            String dbUrl = "jdbc:mysql://localhost:3306/sekolah?user=root&password=";
            try{
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection(dbUrl);
            }catch(ClassNotFoundException | SQLException e){
                
            }
        }
        return con;
    }
}
