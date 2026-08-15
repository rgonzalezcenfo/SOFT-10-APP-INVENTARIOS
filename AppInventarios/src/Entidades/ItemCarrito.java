package Entidades;

/**
 * Representa una linea del carrito de compras: un producto junto con la
 * cantidad de unidades que el cliente lleva de el.
 *
 * La clase cumple ademas el papel de nodo de la lista enlazada simple
 * CarritoUsuario, a traves del atributo siguiente.
 */
public class ItemCarrito {
    private int cantidad;
    private Producto producto;
    // Subtotal de la linea; se recalcula cada vez que cambia la cantidad.
    private double total;
    // Referencia que convierte al item en nodo de la lista enlazada.
    private ItemCarrito siguiente;

    public ItemCarrito(int cantidad, Producto producto){
        this.cantidad = cantidad;
        this.producto = producto;
        this.total = producto.getPrecio()*cantidad;

    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        calcularTotal();
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public double getTotal() {
        return total;
    }
    // Mantiene el subtotal sincronizado con la cantidad y el precio actual.
    private void calcularTotal(){
        this.total = this.cantidad*this.producto.getPrecio();
    }
    public ItemCarrito getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(ItemCarrito siguiente) {
        this.siguiente = siguiente;
    }

}
