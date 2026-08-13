package Entidades;

import Estructuras.CarritoUsuario;

public class Usuario {

    // Atributos
    private String nombreCompleto;
    private String identifiacion;
    private CarritoUsuario carritoUsuario;
    private int prioridad;
    private String ubicacion;

    // Constructor
    public Usuario(String nombreCompleto, String identifiacion, int prioridad, String ubicacion) {
        this.nombreCompleto = nombreCompleto;
        this.identifiacion = identifiacion;
        this.prioridad = prioridad;
        this.ubicacion = ubicacion;
        this.carritoUsuario = new CarritoUsuario();
    }

    // Getters y Setters
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    public String getIdentifiacion() {
        return identifiacion;
    }
    public int getPrioridad() {
        return prioridad;
    }
    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public CarritoUsuario getCarritoUsuario() {
        return carritoUsuario;
    }
    // Métodos
    public void agregarProductoAlCarrito(ItemCarrito itemCarrito) {
        carritoUsuario.insertarAlInicio(itemCarrito);
    }
    @Override
    public String toString() {
        return "Nombre completo: " + this.nombreCompleto + "\n" +
                "Identificacion: " + this.identifiacion + "\n" +
                "Prioridad: " + this.prioridad + "\n" +
                "Ubicacion: " + this.ubicacion + "\n";
    }
}