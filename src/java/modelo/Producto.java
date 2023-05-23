package modelo;
public class Producto {
    int id;
    int precio;
    int stock;
    String nom;
    String estado;

    public Producto() {
    }

    public Producto(int id, int precio, int stock, String nom, String estado) {
        this.id = id;
        this.precio = precio;
        this.stock = stock;
        this.nom = nom;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
