package modelo;
import config.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VentaDAO {
    Conexion cn = new Conexion();
    java.sql.Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public String GenerarSerie(){
        String numeroserie="";//Esto genera muchos problemas cuando la tabla de ventas esta vacia
        String sql="SELECT MAX(NumeroSerie)FROM ventas";
        try{
            con = cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                numeroserie=rs.getString(1);
            }
        }catch(Exception e){
             System.err.println("Error al ejecutar la consulta: " + e.getMessage());
        }
        return numeroserie;
    }
    public String IdVentas(){
        String idventas = "";
        String sql="SELECT MAX(IdVentas)FROM ventas";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                idventas = rs.getString(1);
            }
        }catch(Exception e){
             System.err.println("Error al ejecutar la consulta: " + e.getMessage());
        }
        return idventas;
    }
    public int guardarVenta(Venta ve){
        String sql="INSERT INTO ventas(IdCliente,IdEmpleado,NumeroSerie,FechaVentas,Monto,Estado) values(?,?,?,?,?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ve.getIdcliente());
            ps.setInt(2, ve.getIdempleado());
            ps.setString(3,ve.getNumserie());
            ps.setString(4,ve.getFecha());            
            ps.setDouble(5, ve.getMonta());
            ps.setString(6,ve.getEstado());             
            ps.executeUpdate();
        }catch(Exception e){
             System.err.println("Error al ejecutar la consulta: " + e.getMessage());
        }
        return r;
    }
    public int guardarDetalleventas(Venta venta){
        String sql="INSERT INTO detalle_ventas(IdVentas,IdProducto,Cantidad,PrecioVenta) values(?,?,?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql); 
            ps.setInt(1, venta.getId());
            ps.setInt(2, venta.getIdproducto());
            ps.setInt(3, venta.getCantidad());
            ps.setInt(4, venta.getPrecio());            
            ps.executeUpdate();         
        }catch(Exception e){
             System.err.println("Error al ejecutar la consulta: " + e.getMessage());
        }
        return r;
    }
}
