package modelo;

public class Venta {
    int id;
    int item;
    int idcliente;
    int idempleado;
    int idproducto;
    int precio;
    int cantidad;
    double subtotal;
    double monta;
    String Numserie;
    String DescripcionP;
    String Fecha;
    String Estado;

    public Venta() {
    }

    public Venta(int id, int item, int idcliente, int idempleado, int idproducto, int precio, int cantidad, double subtotal, double monta, String Numserie, String DescripcionP, String Fecha, String Estado) {
        this.id = id;
        this.item = item;
        this.idcliente = idcliente;
        this.idempleado = idempleado;
        this.idproducto = idproducto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.monta = monta;
        this.Numserie = Numserie;
        this.DescripcionP = DescripcionP;
        this.Fecha = Fecha;
        this.Estado = Estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getMonta() {
        return monta;
    }

    public void setMonta(double monta) {
        this.monta = monta;
    }

    public String getNumserie() {
        return Numserie;
    }

    public void setNumserie(String Numserie) {
        this.Numserie = Numserie;
    }

    public String getDescripcionP() {
        return DescripcionP;
    }

    public void setDescripcionP(String DescripcionP) {
        this.DescripcionP = DescripcionP;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
}
