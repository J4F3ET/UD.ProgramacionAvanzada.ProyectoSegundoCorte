package config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexion {
    Connection con = null;
    String url = "jdbc:mysql://localhost:3306/bd_ventas?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String user = "root";
    String pass = "20211578079";
    String Driver = "com.mysql.cj.jdbc.Driver";
    public Connection Conexion() throws ClassNotFoundException, SQLException{
        try{
            Class.forName(Driver);
            con = DriverManager.getConnection(url, user, pass);  
            if(con!=null){
                System.out.println("Conexion exitosa");
            }
        }catch(Exception e){
        }
        return con;
    }
}
