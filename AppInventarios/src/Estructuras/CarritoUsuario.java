package Estructuras;

import Entidades.ItemCarrito;
import Excepciones.CarritoVacio;
import Excepciones.ProductoNoExiste;

public class CarritoUsuario {

    //Atributos
    private ItemCarrito primero;

    //Constructor
    public CarritoUsuario() {
        this.primero = null;
    }


    //estaVacia
    private boolean estaVacia() {
        return primero == null;
    }

    public void insertarAlInicio(ItemCarrito nuevo) {
        nuevo.setSiguiente(primero);
        primero = nuevo;
    }
    public void insertarAlFinal(ItemCarrito nuevo) {
        //si la lista esta vacia el nuevo nodo queda de primero
        if (primero == null) {
            primero = nuevo;
            return;
        }
        //recorremos hasta el ultimo nodo
        ItemCarrito actual = primero;
        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        actual.setSiguiente(nuevo);
    }
    //busca un producto por nombre y retorna su nodo, o null si no esta
    public ItemCarrito buscarProducto(String nombre) {
        ItemCarrito actual = primero;
        if(estaVacia()) throw new CarritoVacio("No hay productos en el carrito");
        while (actual != null) {
            if (actual.getProducto().getNombre().equals(nombre)) {
                return actual;
            }
            actual = actual.getSiguiente();
        }
        throw new ProductoNoExiste("No se encontro un producto con ese nombre");
    }

    //Pendientes por implementar:
    // - eliminar
    public ItemCarrito eliminar(String nombre){
        if (estaVacia()) {
            throw new CarritoVacio("No hay productos en el carrito");
        }

        if(primero.getProducto().getNombre().equals(nombre)){
            ItemCarrito aux = primero;
            primero = primero.getSiguiente();
            return aux;
        }

        ItemCarrito temp = primero;
        ItemCarrito anterior = temp;
        while (temp != null && !temp.getProducto().getNombre().equals(nombre)) {
            anterior = temp;
            temp = temp.getSiguiente();
        }
        if (temp == null) {
            throw new ProductoNoExiste("No se econtro un producto con este nombre");
        }
        anterior.setSiguiente(temp.getSiguiente());
        return temp;
    }

    //mostrar
    public void mostrar(){
        ItemCarrito temp = primero;
        if (estaVacia()) throw new CarritoVacio("No hay productos en el carrito");

        while (temp != null) {
            System.out.println(
                   "Producto:"+temp.getProducto().getNombre()+"\n"+
                   "Cantidad: "+temp.getCantidad()
            );
            temp = temp.getSiguiente();
        }
    }

    // - reporte de costos
    public void reporteCostos(){
        ItemCarrito temp = primero;
        if (estaVacia()) throw new CarritoVacio("No hay productos en el carrito");

        double total = 0;

        while (temp != null) {
            System.out.println("\n" + temp.getCantidad() + "x " + temp.getProducto().getNombre() + "| Precio unitario: " + temp.getProducto().getPrecio());
            total += temp.getTotal();
            temp = temp.getSiguiente();
        }
        System.out.println("--- Total: " + total + " ---");
    }

}
