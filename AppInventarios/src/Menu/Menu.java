package Menu;

import Entidades.Producto;
import Entidades.Tienda;
import Entidades.Usuario;
import Estructuras.ArbolProductos;
import Excepciones.ArticuloYaExiste;
import Excepciones.InventarioVacio;
import LogicaDeNegocio.AdministradorArbolInventario;
import LogicaDeNegocio.AdministradorClientes;
import LogicaDeNegocio.AdministradorCola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

import static LogicaDeNegocio.AdministradorArbolInventario.eliminarProducto;

public class Menu {
    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void iniciarMenu(Tienda tienda) throws IOException {
        System.out.println("--- Lista de Productos ---");
        boolean ejecutando = true;
        while (ejecutando) {
            System.out.println("\nSelecciona una opción:");
            System.out.println("1- Agregar un producto");
            System.out.println("2- Mostrar la lista");
            System.out.println("3- Modificar un producto");
            System.out.println("4- Eliminar un producto");
            System.out.println("5- Ver reporte de productos");
            System.out.println("6- Nuevo usuario");
            System.out.println("7- Atender cliente");
            System.out.println("8- Salir");
            System.out.println("-------------------------------");

            String opcion = in.readLine();
            switch(opcion) {
                case "1":
                    AdministradorArbolInventario.agregarProducto(tienda.getInnventario());
                    break;

                case "2":
                    try {
                        tienda.getInnventario().recorridoInorden();
                    }catch(InventarioVacio e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case "3":
                    AdministradorArbolInventario.modificarProducto(tienda.getInnventario());
                    break;

                case "4":
                    eliminarProducto(tienda.getInnventario());
                    break;
                case "5":
                    try {
                        tienda.getInnventario().reporteInventario();
                    }catch (InventarioVacio e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "6":
                    Usuario usuarioNuevo = AdministradorClientes.crearUsuarioCLI(tienda.getInnventario());
                    if(usuarioNuevo == null) {
                        System.out.println("El usuario no pudo ser vacio ");
                    }else {
                        tienda.getColaUsuarios().agregarUsuario(usuarioNuevo);
                    }
                    break;
                case "7":
                    AdministradorCola.atenderCliente(tienda.getColaUsuarios());
                    break;

                case "8":
                    ejecutando = false;
                    break;
            }
        }
    }



}
