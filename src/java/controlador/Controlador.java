package controlador;
import config.GenerarSerie;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;
import modelo.ClienteDAO;
import modelo.Empleado;
import modelo.EmpleadoDAO;
import modelo.Producto;
import modelo.ProductoDAO;
import modelo.Venta;
import modelo.VentaDAO;
public class Controlador extends HttpServlet {
    Empleado em = new Empleado();
    EmpleadoDAO edao=new EmpleadoDAO();
    Cliente c = new Cliente();
    ClienteDAO cdao=new ClienteDAO();
    Producto p = new Producto();
    ProductoDAO pdao = new ProductoDAO();
    int ide;
    int idc;
    int idp;
    Venta v = new Venta();
    VentaDAO vdao = new VentaDAO();
    List<Venta>lista =new ArrayList<>();
    int item;
    int cod;
    int precio;
    int cant;
    double subtotal;
    double totalPagar;
    String descripcion;
    String numeroserie;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String accion = request.getParameter("accion");
            String menu = request.getParameter("menu");
            if(menu.equals("Principal")){
                request.getRequestDispatcher("Principal.jsp").forward(request, response);
            }           
            if(menu.equals("Empleado")){
                switch(accion){
                    case "Listar":
                        List lista=edao.Listar();
                        request.setAttribute("empleados", lista);
                        break;
                    case "Agregar":
                        String dni=request.getParameter("txtDni");
                        String nom=request.getParameter("txtNombres");
                        String tel=request.getParameter("txtTelefono");
                        String est=request.getParameter("txtEstado");
                        String user=request.getParameter("txtUsuario");
                        em.setDni(dni);
                        em.setNom(nom);
                        em.setTel(tel);
                        em.setEstado(est);
                        em.setUser(user);
                        edao.agregar(em);
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                        break;
                    case "Editar":
                        ide=Integer.parseInt(request.getParameter("id"));
                        Empleado e= edao.listarId(ide);
                        request.setAttribute("empleado", e);
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                        break;
                    case "Actualizar":
                        String dni1=request.getParameter("txtDni");
                        String nom1=request.getParameter("txtNombres");
                        String tel1=request.getParameter("txtTelefono");
                        String est1=request.getParameter("txtEstado");
                        String user1=request.getParameter("txtUsuario");
                        em.setDni(dni1);
                        em.setNom(nom1);
                        em.setTel(tel1);
                        em.setEstado(est1);
                        em.setUser(user1);
                        em.setId(ide);
                        edao.actualizar(em);
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                        break;
                    case "Delete":
                        ide=Integer.parseInt(request.getParameter("id"));
                        edao.delete(ide);
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                        break;                      
                    default:
                        throw new AssertionError();
                }
                request.getRequestDispatcher("Empleado.jsp").forward(request, response);
            }
            if(menu.equals("Cliente")){
                switch(accion){
                    case "Listar":
                        break;
                    case "Agregar":
                        break;
                    case "Editar":
                        break;
                    case "Delete":
                        break;                      
                    default:
                        throw new AssertionError();
                    }
                request.getRequestDispatcher("Clientes.jsp").forward(request, response);
            }
            if(menu.equals("Producto")){
                switch(accion){
                    case "Listar":
                        break;
                    case "Agregar":
                        break;
                    case "Editar":
                        break;
                    case "Delete":
                        break;                      
                    default:
                        throw new AssertionError();
                    }              
                request.getRequestDispatcher("Producto.jsp").forward(request, response);                
            }            
            if(menu.equals("RegistrarVenta")){
                    v = new Venta();
                    switch(accion){
                    case "BuscarCliente":
                        String dni = request.getParameter("codigocliente");
                        c.setDni(dni);
                        c.setNom(dni);
                        c = cdao.buscar(dni);                   
                        request.setAttribute("c", c);
                        break;         
                    case "BuscarProducto":
                        int id = Integer.parseInt(request.getParameter("codigoproducto"));
                        p = pdao.listarId(id);
                        request.setAttribute("c", c);
                        request.setAttribute("totalpagar", totalPagar);
                        request.setAttribute("producto", p);
                        request.setAttribute("lista", lista);
                        break;
                    case "Agregar":
                        request.setAttribute("nserie", numeroserie);
                        request.setAttribute("c", c);
                        totalPagar = 0.0;
                        item = item + 1;
                        cod=p.getId();
                        descripcion=request.getParameter("nombreproducto");
                        precio = Integer.parseInt(request.getParameter("precio"));
                        cant = Integer.parseInt(request.getParameter("cant"));
                        subtotal = precio * cant;
                        v = new Venta();
                        v.setItem(item);
                        v.setIdproducto(cod);
                        v.setDescripcionP(descripcion);
                        v.setPrecio(precio);
                        v.setCantidad(cant);
                        v.setSubtotal(subtotal);
                        lista.add(v);
                        for(int i = 0; i< lista.size();i++){
                            totalPagar = totalPagar +lista.get(i).getSubtotal();
                        }
                        request.setAttribute("totalpagar", totalPagar);
                        request.setAttribute("lista", lista);
                        break;   
                    case "GenerarVenta":
                        //ACTUALIZAR STOCK
                        for(int i = 0;i<lista.size(); i++){
                            Producto pr = new Producto();
                            int cantidad = lista.get(i).getCantidad();
                            int idproducto = lista.get(i).getIdproducto();
                            ProductoDAO aO = new ProductoDAO();
                            pr=aO.buscar(idproducto);
                            int sac=pr.getStock()-cantidad;
                            aO.actualizarstock(idproducto, sac);   
                        }
                        //GUARDAR VENTA
                        v.setIdcliente(c.getId());
                        v.setIdempleado(13);
                        v.setNumserie(numeroserie);
                        v.setFecha("2019-06-14");
                        v.setMonta(totalPagar);
                        v.setEstado("1");
                        vdao.guardarVenta(v);  
                        System.out.println("FLAG II");
                        //Guardar Detalle ventas
                        int idv = Integer.parseInt(vdao.IdVentas());
                        for(int i = 0;i < lista.size();i++){
                            v = new Venta();
                            v.setId(idv);
                            v.setIdproducto(lista.get(i).getIdproducto());
                            v.setCantidad(lista.get(i).getCantidad());
                            v.setPrecio(lista.get(i).getPrecio());
                            vdao.guardarDetalleventas(v);
                        }
                        System.out.println("FLAG III");
                        break;
                    default:
                        numeroserie = vdao.GenerarSerie();
                        if(numeroserie ==null){
                            numeroserie = "00000001";
                            request.setAttribute("nserie", numeroserie);   
                        }else{
                            int incrementar = Integer.parseInt(numeroserie);
                            GenerarSerie gs = new GenerarSerie();
                            numeroserie=gs.NumeroSerie(incrementar);
                            request.setAttribute("nserie", numeroserie);
                        }
                        request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
                    }
                request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
            }            
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
