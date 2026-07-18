package LogicaDeNegocio;

import Entidades.Usuario;
import Estructuras.ArbolProductos;
import Excepciones.CarritoVacio;
import Excepciones.ProductoNoExiste;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AdministradorClientes {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static Usuario crearUsuarioCLI(ArbolProductos inventario) throws IOException {

        String nombreCompleto;
        String identificacion;
        int prioridad;

        do {
            System.out.print("Ingrese el nombre completo del usuario: ");
            nombreCompleto = br.readLine().trim();

            if (nombreCompleto.isEmpty()) {
                System.out.println("Error: El nombre no puede estar vacío.");
            }

        } while (nombreCompleto.isEmpty());

        do {
            System.out.print("Ingrese la identificación: ");
            identificacion = br.readLine().trim();

            if (identificacion.isEmpty()) {
                System.out.println("Error: La identificación no puede estar vacía.");
            }

        } while (identificacion.isEmpty());

        while (true) {

            System.out.print("Ingrese la prioridad (1-3): ");

            try {
                prioridad = Integer.parseInt(br.readLine().trim());

                if (prioridad >= 1 && prioridad <= 3) {
                    break;
                }

                System.out.println("Error: La prioridad debe ser un número entre 1 y 3.");

            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número entero.");
            }
        }
        Usuario usuario = new Usuario(nombreCompleto, identificacion, prioridad);
        llenarCarrito(usuario,inventario);
        usuario.getCarritoUsuario().mostrar();
        return usuario;
    }
    private static void llenarCarrito(Usuario usuario,  ArbolProductos inventario) throws IOException {
        String continuar = "";
        while (!continuar.equalsIgnoreCase("N")) {
            try {
                AdministradorItemCarrito.agregarProductoAlCarrito(inventario, usuario);
            } catch (CarritoVacio | ProductoNoExiste | IOException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Desea agregar otro producto al carrito? (Y/N)");
            continuar = br.readLine().trim();

        }
    }
}
