/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasir;

/**
 *
 * @author ferdi
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class koneksi {
    
    private static Connection connection = null;
    public static Connection getConnection(){
        if(connection != null) return connection;
        else{
            String dbUrl = "jdbc:mysql://localhost:3306/kasir?user=root&password=";
            try{
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(dbUrl);
                System.out.println("Success Connect to Database");
            }catch(ClassNotFoundException | SQLException e){
                System.err.println("Eror Koneksi "+e);
            }
            return connection;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        getConnection();
    }
    
}
