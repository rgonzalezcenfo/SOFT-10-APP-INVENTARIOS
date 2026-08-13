package Entidades;

import Estructuras.ArbolProductos;
import Estructuras.ColaUsuarios;
import Estructuras.Grafo;
import LogicaDeNegocio.AdministradorGrafo;

public class Tienda {

    // Atributos
    private ArbolProductos innventario;
    private ColaUsuarios colaUsuarios;
    private Grafo grafo;
    private String ubicacion;

    // Constructor
    public Tienda() {
        this.innventario = new ArbolProductos();
        this.grafo = new Grafo();
        this.ubicacion = "Tienda";
        AdministradorGrafo.inicializarGrafo(this.grafo);
        this.colaUsuarios = new ColaUsuarios(this.grafo);
    }

    // Getters
    public ArbolProductos getInnventario() {
        return innventario;
    }

    public ColaUsuarios getColaUsuarios() {
        return colaUsuarios;
    }

    public Grafo getGrafo() {
        return grafo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    // Setter
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}