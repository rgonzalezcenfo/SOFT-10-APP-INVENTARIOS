package Entidades;

import Estructuras.ArbolProductos;
import Estructuras.ColaUsuarios;
import Estructuras.Grafo;
import LogicaDeNegocio.AdministradorGrafo;

/**
 * Agrupa todas las estructuras de datos del sistema y actua como punto de
 * acceso unico para el menu y las clases de logica de negocio.
 *
 * Reune el inventario (arbol binario de busqueda), la cola de clientes
 * ordenada por prioridad, el grafo de ubicaciones y la ubicacion propia de
 * la tienda, que es el destino de todas las rutas de entrega.
 */
public class Tienda {

    // Atributos
    private ArbolProductos innventario;
    private ColaUsuarios colaUsuarios;
    private Grafo grafo;
    // Vertice del grafo que representa a la tienda; destino de las entregas.
    private String ubicacion;

    // Constructor
    // Deja el sistema listo para operar: inventario vacio, grafo con el mapa
    // basico ya cargado y cola de clientes enlazada a ese mismo grafo.
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