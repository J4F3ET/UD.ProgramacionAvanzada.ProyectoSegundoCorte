package modelo;
import java.sql.Connection;
import config.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class EmpleadoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r; //Respuesta
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
    //operaciones CRUD
    public List Listar(){
        String sql="select * from empleado;";
        List<Empleado>lista=new ArrayList<>();
        try{
            con = cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Empleado em = new Empleado();
                em.setId(rs.getInt(1));
                em.setDni(rs.getString(2));
                em.setNom(rs.getString(3));
                em.setTel(rs.getString(4));
                em.setEstado(rs.getString(5));
                em.setUser(rs.getString(6));
                lista.add(em);
            } 
        }catch(Exception e){        
        }
        return lista;
    }
    public int agregar(Empleado em){
        String sql ="insert into empleado (Dni, Nombres, Telefono, Estado, User)values(?,?,?,?,?)";
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, em.getDni());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getTel());
            ps.setString(4, em.getEstado());
            ps.setString(5, em.getUser());           
            ps.executeUpdate();
        }catch(Exception e){

        }
        return r;   
    }
    public Empleado listarId(int id){
        Empleado emp=new Empleado();
        String sql="select * from empleado where idEmpleado="+id;
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);  
            rs=ps.executeQuery();
            while(rs.next()){              
                emp.setDni(rs.getString(2));
                emp.setNom(rs.getString(3));
                emp.setTel(rs.getString(4));
                emp.setEstado(rs.getString(5));
                emp.setUser(rs.getString(6));
            }
            }catch(Exception e){           
        }
        return emp; 
    }
    public int actualizar(Empleado em){
        String sql ="update empleado set Dni=?, Nombres=?, Telefono=?, Estado=?, User=? where IdEmpleado=?";
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, em.getDni());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getTel());
            ps.setString(4, em.getEstado());
            ps.setString(5, em.getUser());  
            ps.setInt(6,em.getId());
            ps.executeUpdate();
        }catch(Exception e){
            
        }
        return r;         
    }
    public void delete(int id){
        String sql="delete from empleado where idEmpleado="+id;
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            
        }        
    }    
}
