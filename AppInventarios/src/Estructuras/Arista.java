package Estructuras;

/**
 * Representa una conexion entre dos ubicaciones dentro del grafo.
 *
 * Como el grafo es no dirigido, cada conexion se almacena como dos aristas
 * con el mismo peso, una en la lista de adyacencia de cada ubicacion.
 */
public class Arista {

    // Atributos
    // Ubicacion a la que lleva esta conexion.
    private final String destino;
    // Distancia entre las dos ubicaciones; es un valor estatico.
    private final int peso;

    // Métodos
    // Constructor
    public Arista(String destino, int peso) {
        this.destino = destino;
        this.peso = peso;
    }

    // Getters
    public String getDestino() {
        return destino;
    }

    public int getPeso() {
        return peso;
    }
}