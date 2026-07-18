package Entidades;

import Estructuras.ArbolProductos;
import Estructuras.ColaUsuarios;

public class Tienda {
    private ArbolProductos innventario;
    private ColaUsuarios colaUsuarios;

    public Tienda(){
        this.innventario = new ArbolProductos();
        this.colaUsuarios = new ColaUsuarios();
    }

    public ArbolProductos getInnventario() {
        return innventario;
    }

    public ColaUsuarios getColaUsuarios() {
        return colaUsuarios;
    }
}
