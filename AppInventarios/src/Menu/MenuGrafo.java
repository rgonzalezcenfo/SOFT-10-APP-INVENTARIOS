package Menu;

import Entidades.Tienda;
import Excepciones.ExcepcionDeNegocio;
import LogicaDeNegocio.AdministradorGrafo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MenuGrafo {

    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void iniciarMenu(Tienda tienda) throws IOException {
        boolean ejecutando = true;
        while (ejecutando) {
            System.out.println("\n========== GESTION DEL GRAFO ==========");
            System.out.println("1- Agregar ubicacion");
            System.out.println("2- Agregar conexion");
            System.out.println("3- Salir");
            System.out.println("---------------------------------------");
            System.out.print("Seleccione una opcion: ");
            String opcion = in.readLine();
            switch (opcion) {
                case "1":
                    agregarUbicacion(tienda);
                    break;
                case "2":
                    agregarConexion(tienda);
                    break;
                case "3":
                    ejecutando = false;
                    break;
                default:
                    System.out.println("La opcion seleccionada no es valida.");
                    break;
            }
        }
    }

    private static void agregarUbicacion(Tienda tienda) throws IOException {

        System.out.println("\n========== AGREGAR UBICACION ==========");
        System.out.print("Ingrese el nombre de la ubicacion: ");
        String ubicacion = in.readLine();
        try {

            AdministradorGrafo.agregarVertice(tienda.getGrafo(), ubicacion);
            System.out.println(
                    "La ubicacion fue agregada correctamente."
            );
        } catch (ExcepcionDeNegocio e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void agregarConexion(Tienda tienda) throws IOException {

        System.out.println("\n========== AGREGAR CONEXION ==========");
        System.out.print("Ingrese la ubicacion de origen: ");
        String origen = in.readLine();
        System.out.print("Ingrese la ubicacion de destino: ");
        String destino = in.readLine();
        System.out.print("Ingrese la distancia: ");
        String entradaDistancia = in.readLine();

        try {

            int distancia = Integer.parseInt(entradaDistancia.trim());

            AdministradorGrafo.agregarArista(tienda.getGrafo(), origen, destino, distancia);
            System.out.println("La conexion fue agregada correctamente.");
        } catch (NumberFormatException e) {
            System.out.println("Error: La distancia debe ser un numero entero.");
        } catch (ExcepcionDeNegocio e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}