package Entidades;

public class ItemCarrito {
    private int cantidad;
    private Producto producto;
    private double total;
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
