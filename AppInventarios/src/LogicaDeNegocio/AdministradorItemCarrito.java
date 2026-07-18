package LogicaDeNegocio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Entidades.ItemCarrito;
import Entidades.Producto;
import Entidades.Usuario;
import Estructuras.ArbolProductos;
import Estructuras.CarritoUsuario;
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
                cantidad = Integer.parseInt(
                        in.readLine().trim()
                );
            }catch (NumberFormatException e){
                System.out.println("Debe ingresar un numero valido");
            }
            if(cantidad> producto.getCantidad()){
                System.out.println("La cantidad ingresada excede la cantiad disponible de este producto\n Cantiad disponible: "+producto.getCantidad());
            }else{
                break;
            }
        }
        usuario.agregarProductoAlCarrito(new ItemCarrito(cantidad,producto));
        producto.setCantidad(producto.getCantidad()-cantidad);
        System.out.println("Producto agregado exitosamente");
    }
    public static void modificarItemDelCarrito(Usuario usuario) throws IOException {
        String nombreProducto = "";
        ItemCarrito productoSeleccionado = null;
        int nuevaCantidad;
        System.out.println("========= Modificar item del carrito ==========");
        try{
            usuario.getCarritoUsuario().mostrar();
        }catch (CarritoVacio e){
            System.out.println(e.getMessage());
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
            productoSeleccionado =  usuario.getCarritoUsuario().buscarProducto(nombreProducto);
        }catch (ProductoNoExiste|CarritoVacio e){
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Cantidad actual: "+productoSeleccionado.getCantidad()+"\n Total: "+productoSeleccionado.getTotal()+"\n Ingrese la nueva cantidad.");
        while(true){
            try{
                nuevaCantidad = Integer.parseInt(
                  in.readLine().trim()
                );
                break;
            }catch (NumberFormatException e){
                System.out.println("La cantidad ingresada es invalida");
            }
        }
        productoSeleccionado.setCantidad(nuevaCantidad);
    }

}
