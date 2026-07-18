package Entidades;

import Estructuras.CarritoUsuario;

public class Usuario {
    private String nombreCompleto;
    private String identifiacion;
    private CarritoUsuario carritoUsuario;
    private int prioridad;

    public Usuario(String nombreCompleto, String identifiacion, int prioridad ) {
        this.nombreCompleto = nombreCompleto;
        this.identifiacion = identifiacion;
        this.prioridad = prioridad;
        this.carritoUsuario = new CarritoUsuario();
    }

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
    public CarritoUsuario getCarritoUsuario(){
        return carritoUsuario;
    }
    public void agregarProductoAlCarrito(ItemCarrito itemCarrito){
        carritoUsuario.insertarAlInicio(itemCarrito);
    }
    @Override
    public String toString(){
        return  "Nombre completo: "+this.nombreCompleto+"\n"+
                "Identificaion: "+this.identifiacion+"\n"+
                "Prioridad: "+this.prioridad+"\n";
    }
}
