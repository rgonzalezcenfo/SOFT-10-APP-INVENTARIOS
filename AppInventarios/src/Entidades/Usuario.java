package Entidades;

import Estructuras.CarritoUsuario;

/**
 * Representa a un cliente de la tienda.
 *
 * Cada usuario tiene su propio carrito de compras (lista enlazada) y una
 * ubicacion, que es el vertice del grafo desde el cual se calcula la ruta
 * de entrega hacia la tienda. La prioridad determina su posicion dentro de
 * la ColaUsuarios: a mayor valor, mas pronto es atendido.
 */
public class Usuario {

    // Atributos
    private String nombreCompleto;
    private String identifiacion;
    private CarritoUsuario carritoUsuario;
    // Valor de 1 a 3 que ordena al cliente dentro de la cola de atencion.
    private int prioridad;
    // Nombre del vertice del grafo donde se entrega el pedido.
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
    // Inserta el item al inicio del carrito, que es una lista enlazada
    // simple.
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