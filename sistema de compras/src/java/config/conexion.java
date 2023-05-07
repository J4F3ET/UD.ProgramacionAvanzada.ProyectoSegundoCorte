package config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexion {
    Connection con;
    String url = "jdbc:mysql://localhost:3306/de_ventas";
    String user = "root";
    String pass = "12345678";
    public Connection Conexion() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(url, user, pass);  
        return con;
    }
}
