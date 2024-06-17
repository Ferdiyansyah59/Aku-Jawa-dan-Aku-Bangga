package connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.*;

public class koneksi {
    private static Connection connection = null;
    
    public static Connection Connection(){
        if (connection == null) {
            MysqlDataSource data = new MysqlDataSource();
            data.setDatabaseName("koperasi");
            data.setUser("root");
            data.setPassword("");
            try{
                connection = data.getConnection();
                System.out.println("Koneksi Sukses");
            }
            catch(SQLException ex){
                System.out.println("Koneksi Gagal" + ex);
            }
        }
        return connection;
    }
    
    public static void main(String[] args) {
        Connection();
    }
}