package Entidades;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Representa un articulo del inventario de la tienda.
 *
 * Ademas de sus datos propios, la clase cumple el papel de nodo del arbol
 * binario de busqueda ArbolProductos: los atributos izquierda y derecha
 * son las referencias a los subarboles, y el nombre es la llave por la que
 * se ordenan e identifican los productos de forma unica.
 */
public class Producto {

    //Atributos
    private String nombre;
    private double precio;
    private String categoria;
    // Solo se usa en productos perecederos; en el resto queda en null.
    private LocalDate fechaVencimiento;
    private int cantidad;
    private ArrayList<String> listaImagenes;
    // Referencias que convierten al producto en nodo del arbol.
    private Producto izquierda;
    private Producto derecha;

    //Constructores

    public Producto(String nombre, double precio, String categoria, LocalDate fechaVencimiento, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.fechaVencimiento = fechaVencimiento;
        this.cantidad = cantidad;
        this.listaImagenes = new ArrayList<>();
        this.izquierda = null;
        this.derecha = null;
    }

    public Producto(String nombre, double precio, String categoria, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.fechaVencimiento = null;
        this.cantidad = cantidad;
        this.listaImagenes = new ArrayList<>();
        this.izquierda = null;
        this.derecha = null;
    }

    //getters


    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    // Valor acumulado de todas las unidades disponibles del producto.
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


    public Producto getIzquierda() {
        return izquierda;
    }

    public Producto getDerecha() {
        return derecha;
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
    
    public void setIzquierda(Producto izquierda) {
        this.izquierda = izquierda;
    }

    public void setDerecha(Producto derecha) {
        this.derecha = derecha;
    }

    //administracion de imagenes
    public void agregarImagen(String rutaImagen){
        listaImagenes.addLast(rutaImagen);
    }

    //equals: dos productos son el mismo si comparten el nombre, que es la
    //llave unica del arbol
    public boolean equals(Producto producto){
        return this.nombre.equals(producto.nombre);
    }

    //toString
    public String toString(){
        String cadena = "\nNombre del producto: " + nombre +
                        "\nPrecio: " + precio +
                        "\nCategoria: " + categoria+
                        "\nCantidad disponible: "+cantidad;

        if (fechaVencimiento != null) cadena = cadena + "\nFecha de Vencimiento: " + fechaVencimiento.getDayOfMonth() + "/" + fechaVencimiento.getMonthValue() + "/" + fechaVencimiento.getYear();

        return cadena;
    }
}
