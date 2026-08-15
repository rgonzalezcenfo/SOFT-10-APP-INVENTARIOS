package Estructuras;

/**
 * Entrada de la cola de prioridad que utiliza el algoritmo de Dijkstra.
 *
 * Empareja el nombre de una ubicacion con la distancia acumulada conocida
 * hasta ella, de modo que la cola de prioridad pueda extraer siempre la
 * ubicacion mas cercana pendiente de explorar.
 */
public class Vertice {

    // Atributos
    // Nombre de la ubicacion; coincide con la llave de la lista de adyacencia.
    private final String nombre;
    // Distancia acumulada desde el origen al momento de encolar el vertice.
    private final int distancia;

    // Métodos
    // Constructor
    public Vertice(String nombre, int distancia) {
        this.nombre = nombre;
        this.distancia = distancia;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getDistancia() {
        return distancia;
    }
}