package modelo;
import java.sql.Connection;
import config.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class EmpleadoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    public Empleado validar(String user,String dni){
        Empleado em = new Empleado();
        String sql = "SELECT * FROM empleado WHERE User = ? AND Dni = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1,user);
            ps.setString(2,dni);
            rs = ps.executeQuery();
            while(rs.next()){ //Importante utilizar todos los nombres correctos de las columnas de la base de datos
                em.setUser(rs.getString("User"));
                em.setId(rs.getInt("IdEmpleado"));
                em.setDni(rs.getString("Dni"));
                em.setNom(rs.getString("Nombres"));
            }
        }catch (Exception e){ 
            System.out.println("!!!! \n"+ e.getMessage());
        }
        return em;
    } 
}
