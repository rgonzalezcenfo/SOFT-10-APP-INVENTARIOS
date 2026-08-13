package LogicaDeNegocio;

import Estructuras.Grafo;
import Excepciones.ExcepcionDeNegocio;

import java.util.List;
import java.util.Map;

public class AdministradorGrafo {

    // Inicializa el mapa básico con el que comienza la aplicación.
    public static void inicializarGrafo(Grafo grafo) {

        validarGrafo(grafo);

        // Vértices
        grafo.agregarVertice("Tienda");
        grafo.agregarVertice("Heredia");
        grafo.agregarVertice("San Jose");
        grafo.agregarVertice("Alajuela");
        grafo.agregarVertice("Cartago");

        // Aristas
        grafo.agregarArista("Tienda", "Alajuela", 8);
        grafo.agregarArista("Tienda", "Cartago", 18);
        grafo.agregarArista("Alajuela", "Heredia", 10);
        grafo.agregarArista("Heredia", "San Jose", 15);
        grafo.agregarArista("San Jose", "Cartago", 12);
        grafo.agregarArista("Alajuela", "San Jose", 20);
    }

    // Ejecuta Dijkstra y reconstruye el camino más corto
    // entre la ubicación de origen y el destino.
    public static List<String> buscarCamino(Grafo grafo, String origen, String destino, Map<String, Integer> distancias, Map<String, String> predecesores) {
        validarGrafo(grafo);
        validarUbicacion(origen, "origen");
        validarUbicacion(destino, "destino");
        if (distancias == null) {
            throw new ExcepcionDeNegocio("El mapa de distancias no puede ser nulo.");
        }

        if (predecesores == null) {
            throw new ExcepcionDeNegocio("El mapa de predecesores no puede ser nulo.");
        }

        grafo.algoritmoDijkstra(origen.trim(), distancias, predecesores);
        return grafo.reconstruirCamino(origen.trim(), destino.trim(), predecesores);
    }
    // Obtiene la distancia calculada por Dijkstra
    // entre el origen y el destino.
    public static int obtenerDistancia(Map<String, Integer> distancias, String destino) {
        if (distancias == null) {
            throw new ExcepcionDeNegocio("El mapa de distancias no puede ser nulo.");
        }

        validarUbicacion(destino, "destino");
        return distancias.getOrDefault(destino.trim(), Integer.MAX_VALUE);
    }
    // Agrega una nueva ubicación al grafo.
    public static void agregarVertice(Grafo grafo, String ubicacion) {
        validarGrafo(grafo);
        validarUbicacion(ubicacion, "ubicacion");
        grafo.agregarVertice(ubicacion.trim());
    }
    // Agrega una conexión entre dos ubicaciones.
    public static void agregarArista(Grafo grafo, String origen, String destino, int distancia) {
        validarGrafo(grafo);
        validarUbicacion(origen, "origen");
        validarUbicacion(destino, "destino");
        if (origen.trim().equalsIgnoreCase(destino.trim())) {
            throw new ExcepcionDeNegocio("El origen y el destino de una arista deben ser diferentes.");
        }

        if (distancia <= 0) {
            throw new ExcepcionDeNegocio("La distancia debe ser mayor que cero.");
        }

        grafo.agregarArista(origen.trim(), destino.trim(), distancia
        );
    }
    // Valida que exista una instancia del grafo.
    private static void validarGrafo(Grafo grafo) {
        if (grafo == null) {
            throw new ExcepcionDeNegocio("El grafo no puede ser nulo.");
        }
    }
    // Valida que una ubicación tenga contenido.
    private static void validarUbicacion(String ubicacion, String nombreCampo) {
        if (ubicacion == null || ubicacion.trim().isEmpty()) {
            throw new ExcepcionDeNegocio("La " + nombreCampo + " no puede estar vacía.");
        }
    }
}