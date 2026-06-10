public class ListaProductos {

    //Atributos
    private NodoProducto primero;

    //Constructor
    public ListaProductos() {
        this.primero = null;
    }

    //inserta un producto al inicio de la lista
    public void insertarAlInicio(Producto producto) {
        NodoProducto nuevo = new NodoProducto(producto);
        nuevo.setSiguiente(primero);
        primero = nuevo;
    }

    //inserta un producto al final de la lista
    public void insertarAlFinal(Producto producto) {
        NodoProducto nuevo = new NodoProducto(producto);

        //si la lista esta vacia el nuevo nodo queda de primero
        if (primero == null) {
            primero = nuevo;
            return;
        }

        //recorremos hasta el ultimo nodo
        NodoProducto actual = primero;
        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        actual.setSiguiente(nuevo);
    }

    //busca un producto por nombre y retorna su nodo, o null si no esta
    public NodoProducto buscarProducto(String nombre) {
        NodoProducto actual = primero;
        while (actual != null) {
            if (actual.getProducto().getNombre().equals(nombre)) {
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    //Pendientes por implementar:
    // - eliminar
    // - modificar
    // - reporte de costos
}
