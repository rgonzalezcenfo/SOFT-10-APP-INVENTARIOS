import Entidades.Tienda;
import Menu.Menu;

/**
 * Punto de entrada de la aplicacion de gestion de inventarios.
 *
 * La rutina se limita a construir la Tienda, que a su vez inicializa el
 * inventario (arbol binario de busqueda), la cola de clientes y el grafo
 * de ubicaciones con su mapa basico ya cargado, y a ceder el control al
 * menu principal.
 */
public class Main {

    public static void main(String[] args) {
        // La Tienda agrupa todas las estructuras de datos del programa.
        Tienda nuevaTienda = new Tienda();

        // El menu principal mantiene el ciclo de ejecucion hasta que el
        // usuario elige salir.
        Menu.iniciarMenu(nuevaTienda);
    }
}
