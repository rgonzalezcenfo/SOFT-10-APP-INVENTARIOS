package LogicaDeNegocio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Entidades.ItemCarrito;
import Entidades.Producto;
import Entidades.Usuario;
import Estructuras.ArbolProductos;
import Excepciones.*;
import Menu.MenuBusquedaProducto;

public class AdministradorItemCarrito {

    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void agregarProductoAlCarrito(ArbolProductos inventario, Usuario usuario) throws IOException {
        int cantidad = 0;
        Producto producto = null;

        producto = MenuBusquedaProducto.seleccionarProducto(inventario);

        if(producto == null){
            return;
        }

        System.out.println("Ingrese la cantidad de unidades que desea agregar.");

        while(true){
            try{
                cantidad = Integer.parseInt(in.readLine().trim());

                if(cantidad <= 0){
                    System.out.println("La cantidad debe ser mayor que cero.");
                    continue;
                }

                if(cantidad > producto.getCantidad()){
                    System.out.println("La cantidad ingresada excede la cantidad disponible de este producto");
                    System.out.println("Cantidad disponible: " + producto.getCantidad());
                    continue;
                }

                break;

            }catch(NumberFormatException e){
                System.out.println("Debe ingresar un numero valido");
            }
        }

        usuario.agregarProductoAlCarrito(new ItemCarrito(cantidad, producto));
        producto.setCantidad(producto.getCantidad() - cantidad);

        System.out.println("Producto agregado exitosamente");
    }

    public static void modificarItemDelCarrito(Usuario usuario) throws IOException {
        String nombreProducto = "";
        ItemCarrito productoSeleccionado = null;
        int nuevaCantidad;

        System.out.println("========= Modificar item del carrito ==========");

        try{
            usuario.getCarritoUsuario().mostrar();
        }catch(CarritoVacio e){
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("Ingrese el nombre del producto a modificar");

        while(true){
            nombreProducto = in.readLine().trim();

            if(nombreProducto.isEmpty()){
                System.out.println("El nombre del producto no puede estar vacio");
            }else{
                break;
            }
        }

        try{
            productoSeleccionado = usuario.getCarritoUsuario().buscarProducto(nombreProducto);
        }catch(ProductoNoExiste | CarritoVacio e){
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("Cantidad actual: " + productoSeleccionado.getCantidad() + "\nTotal: " + productoSeleccionado.getTotal() + "\nIngrese la nueva cantidad.");

        while(true){
            try{
                nuevaCantidad = Integer.parseInt(in.readLine().trim());

                if(nuevaCantidad <= 0){
                    System.out.println("La cantidad debe ser mayor que cero.");
                    continue;
                }

                int diferencia = nuevaCantidad - productoSeleccionado.getCantidad();

                if(diferencia > 0 && diferencia > productoSeleccionado.getProducto().getCantidad()){
                    System.out.println("La cantidad solicitada excede la cantidad disponible en inventario.");
                    System.out.println("Cantidad disponible: " + productoSeleccionado.getProducto().getCantidad());
                    continue;
                }

                if(diferencia > 0){
                    productoSeleccionado.getProducto().setCantidad(productoSeleccionado.getProducto().getCantidad() - diferencia);
                }else if(diferencia < 0){
                    productoSeleccionado.getProducto().setCantidad(productoSeleccionado.getProducto().getCantidad() - diferencia);
                }

                productoSeleccionado.setCantidad(nuevaCantidad);

                break;

            }catch(NumberFormatException e){
                System.out.println("La cantidad ingresada es invalida");
            }
        }

        System.out.println("Producto modificado exitosamente.");
    }
}