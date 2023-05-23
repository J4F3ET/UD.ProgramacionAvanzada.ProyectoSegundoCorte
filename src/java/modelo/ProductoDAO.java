package modelo;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Producto buscar(int id){
        Producto p = new Producto();
        String sql="SELECT * FROM producto WHERE idproducto"+id;
        try{
            con = cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setPrecio(rs.getInt(3));
                p.setStock(rs.getInt(4));
                p.setEstado(rs.getString(5));
            }
                   
        }catch(Exception e){
            
        }
        return p;
    }
    public int actualizarstock(int id , int stock){
        String sql = "UPDATE producto SET Stock =? WHERE idproducto=?";
        try{
            con = cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1,stock);
            ps.setInt(2, id);
            ps.executeUpdate();           
        }catch(Exception e){
            System.err.println("Error al ejecutar la consulta: " + e.getMessage());
        }
        return r;
    }
   //CRUD
     public List Listar(){
        String sql="select * from producto;";
        List<Producto>lista=new ArrayList<>();
        try{
            con = cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Producto p = new Producto();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setPrecio(rs.getInt(3));
                p.setStock(rs.getInt(4));
                p.setEstado(rs.getString(5));
                lista.add(p);
            } 
        }catch(Exception e){        
        }
        return lista;
    }

    public int agregar(Producto p){
        String sql ="insert into producto (Nombres,Precio,Stock,Estado)values(?,?,?,?)";
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1,p.getNom());
            ps.setInt(2, p.getPrecio());
            ps.setInt(3, p.getStock());
            ps.setString(4,p.getEstado());
            ps.executeUpdate();
        }catch(Exception e){

        }
        return r;   
    }
    public Producto listarId(int id){
        Producto p = new Producto();
        String sql="select * from producto where IdProducto="+id;
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);  
            rs=ps.executeQuery();
            while(rs.next()){              
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setPrecio(rs.getInt(3));
                p.setStock(rs.getInt(4));
                p.setEstado(rs.getString(5));
            }
            }catch(Exception e){           
        }
        return p; 
    }
    public int actualizar(Producto p){
        String sql ="update producto set Nombres=?, Precio=?, Stock=?, Estado=? where IdProducto=?";
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, p.getNom());
            ps.setInt(2, p.getPrecio());
            ps.setInt(3, p.getStock());
            ps.setString(4, p.getEstado());  
            ps.executeUpdate();
        }catch(Exception e){
            
        }
        return r;         
    }
    public void delete(int id){
        String sql="delete from producto where idProducto="+id;
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            
        }        
    }  
}
