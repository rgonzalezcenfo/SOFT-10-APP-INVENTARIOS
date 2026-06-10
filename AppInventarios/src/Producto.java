import java.time.LocalDate;
import java.util.ArrayList;

public class Producto {

    //Atributos
    private String nombre;
    private double precio;
    private String categoria;
    private LocalDate fechaVencimiento;
    private int cantidad;
    private ArrayList<String> listaImagenes;

    //Constructores

    public Producto(String nombre, double precio, String categoria, LocalDate fechaVencimiento, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.fechaVencimiento = fechaVencimiento;
        this.cantidad = cantidad;
        this.listaImagenes = new ArrayList<>();
    }

    public Producto(String nombre, double precio, String categoria, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.fechaVencimiento = null;
        this.cantidad = cantidad;
        this.listaImagenes = new ArrayList<>();
    }

    //getters


    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public double getPrecioTotal(){
        return precio*cantidad;
    }

    public String getCategoria() {
        return categoria;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public ArrayList<String> getListaImagenes() {
        return listaImagenes;
    }

    //setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setListaImagenes(ArrayList<String> listaImagenes) {
        this.listaImagenes = listaImagenes;
    }

    //administracion de imagenes
    public void agregarImagen(String rutaImagen){
        listaImagenes.addLast(rutaImagen);
    }

    //equals
    public boolean equals(Producto producto){
        return this.nombre.equals(producto.nombre);
    }

    //toString
    public String toString(){
        String cadena = "\nProducto: " + nombre +
                        "\nPrecio: " + precio +
                        "\nCategoria: " + categoria;

        if (fechaVencimiento != null) cadena = cadena + "\nFecha de Vencimiento: " + fechaVencimiento.getDayOfMonth() + "/" + fechaVencimiento.getMonthValue() + "/" + fechaVencimiento.getYear();

        return cadena;
    }
}
