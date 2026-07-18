package Menu;

import Entidades.Producto;
import Estructuras.ArbolProductos;
import Excepciones.ProductoNoExiste;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MenuBusquedaProducto {
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static Producto seleccionarProducto(ArbolProductos inventario) throws IOException {
        int opcion;
        while (true) {

            System.out.println("\n=========================================");
            System.out.println("        SELECCIONAR PRODUCTO");
            System.out.println("=========================================");
            System.out.println("1. Buscar producto por nombre");
            System.out.println("2. Mostrar inventario y seleccionar");
            System.out.println("3. Cancelar");
            System.out.print("Seleccione una opción: ");
            while(true) {
               try{
                   opcion = Integer.parseInt(in.readLine());
                   break;
               }catch (NumberFormatException e){
                   System.out.println("Debe ingresar un numero valido");
               }
            }

            switch (opcion) {

                case 1:
                    return buscarProductoPorNombre(inventario);

                case 2:
                    return seleccionarDesdeInventario(inventario);

                case 3:
                    return null;

                default:
                    System.out.println("\nOpción inválida.");
            }
        }
    }
    private static Producto buscarProductoPorNombre(ArbolProductos inventario) throws IOException {

        System.out.print("\nIngrese el nombre del producto: ");
        String nombre = in.readLine().trim();
        Producto producto = inventario.buscar(nombre);
        if (producto == null) {
            throw new ProductoNoExiste("No se encuentra un producto en el invetario con ese nombre");
        }
        return producto;
    }
    private static Producto seleccionarDesdeInventario(ArbolProductos inventario) throws IOException {

        System.out.println("\n========== INVENTARIO ==========\n");

        inventario.recorridoInorden();

        System.out.print("\nIngrese el nombre del producto que desea seleccionar: ");

        String nombre = in.readLine().trim();

        Producto producto = inventario.buscar(nombre);

        if (producto == null) {
            throw new ProductoNoExiste("No se encuentra un producto en el invetario con ese nombre");
        }

        return producto;
    }
}
