public class NodoProducto {

    //Atributos
    private Producto producto;
    private NodoProducto siguiente;

    //Constructor
    public NodoProducto(Producto producto) {
        this.producto = producto;
        this.siguiente = null;
    }

    //getters

    public Producto getProducto() {
        return producto;
    }

    public NodoProducto getSiguiente() {
        return siguiente;
    }

    //setters

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setSiguiente(NodoProducto siguiente) {
        this.siguiente = siguiente;
    }
}
