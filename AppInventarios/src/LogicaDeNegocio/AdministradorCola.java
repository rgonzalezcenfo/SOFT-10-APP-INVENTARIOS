package LogicaDeNegocio;

import Entidades.Tienda;
import Entidades.Usuario;
import Estructuras.ColaUsuarios;
import Excepciones.CarritoVacio;
import Excepciones.ColaVacia;
import Excepciones.ExcepcionDeNegocio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdministradorCola {

    public static void atenderCliente(Tienda tienda) {

        ColaUsuarios colaUsuarios = tienda.getColaUsuarios();

        try {
            // Se consulta el cliente que está al frente
            // antes de eliminarlo de la cola.
            Usuario usuarioAtender = colaUsuarios.verFrente();

            Map<String, Integer> distancias = new HashMap<>();
            Map<String, String> predecesores = new HashMap<>();

            // Se busca el camino más corto desde la ubicación
            // del cliente hasta la ubicación de la tienda.
            List<String> camino = AdministradorGrafo.buscarCamino(tienda.getGrafo(), usuarioAtender.getUbicacion(), tienda.getUbicacion(), distancias, predecesores);

            int distancia = AdministradorGrafo.obtenerDistancia(distancias, tienda.getUbicacion());

            // Si no existe un camino entre el cliente y la tienda,
            // el cliente no puede ser atendido y permanece en la cola.
            if (camino.isEmpty() || distancia == Integer.MAX_VALUE) {
                System.out.println("No se puede atender al cliente porque su ubicacion no esta conectada con la tienda.");
                return;
            }

            // Solo se elimina de la cola después de comprobar
            // que existe una ruta válida hacia la tienda.
            usuarioAtender = colaUsuarios.eliminarUsuario();

            System.out.println("\n========== ENTREGA DEL PEDIDO ==========");
            System.out.println("Cliente:");
            System.out.println(usuarioAtender);
            System.out.println("Camino mas corto:");
            System.out.println(String.join(" <- ", camino));
            System.out.println("Distancia total: " + distancia);
            System.out.println("\n========== FACTURA ==========");
            usuarioAtender.getCarritoUsuario().reporteCostos();

        } catch (ColaVacia | CarritoVacio | ExcepcionDeNegocio e) {
            System.out.println(e.getMessage());
        }
    }
}