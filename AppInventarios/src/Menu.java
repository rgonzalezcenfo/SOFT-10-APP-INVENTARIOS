import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {

    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static ListaProductos listaProductos = new ListaProductos();


    public static void iniciarMenu() throws IOException {
        System.out.println("--- Lista de Productos ---");
        boolean ejecutando = true;
        while (ejecutando) {
            System.out.println("\nSelecciona una opción:");
            System.out.println("1- Agregar un Producto");
            System.out.println("2- Mostrar la lista");
            System.out.println("3- Modificar un Producto");
            System.out.println("4- Eliminar un Producto");
            System.out.println("5- Salir");

            String opcion = in.readLine();
            switch(opcion) {
                case "1":
                    agregarProducto();
                    break;

                case "2":
                    listaProductos.mostrar();
                    break;

                case "3":
                    modificarProducto();
                    break;

                case "4":
                    eliminarProducto();
                    break;

                case "5":
                    ejecutando = false;
                    break;
            }
        }
    }

    private static void agregarProducto(){

    }

    private static void modificarProducto(){

    }

    private static void eliminarProducto(){

    }
}
