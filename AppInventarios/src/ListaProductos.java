import java.time.LocalDate;

public class ListaProductos {

    //Atributos
    private Producto primero;

    //Constructor
    public ListaProductos() {
        this.primero = null;
    }


    //estaVacia
    private boolean estaVacia() {
        return primero == null;
    }

    public void insertarAlInicio(Producto nuevo) {
        nuevo.setSiguiente(primero);
        primero = nuevo;
    }
    public void insertarAlFinal(Producto nuevo) {
        //si la lista esta vacia el nuevo nodo queda de primero
        if (primero == null) {
            primero = nuevo;
            return;
        }
        //recorremos hasta el ultimo nodo
        Producto actual = primero;
        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        actual.setSiguiente(nuevo);
    }
    //busca un producto por nombre y retorna su nodo, o null si no esta
    public Producto buscarProducto(String nombre) {
        Producto actual = primero;
        while (actual != null) {
            if (actual.getNombre().equals(nombre)) {
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    //Pendientes por implementar:
    // - eliminar
    public Producto eliminar(String nombre){
        if (estaVacia()) {
            System.out.println("La lista está vacía.\n");
            return null;
        }

        if(primero.getNombre().equals(nombre)){
            Producto aux = primero;
            primero = primero.getSiguiente();
            return aux;
        }

        Producto temp = primero;
        Producto anterior = temp;
        while (temp != null && !temp.getNombre().equals(nombre)) {
            anterior = temp;
            temp = temp.getSiguiente();
        }
        if (temp == null) {
            System.out.println("No existe un producto con ese nombre");
            return null;
        }
        anterior.setSiguiente(temp.getSiguiente());
        return temp;
    }


    //mostrar
    public void mostrar(){
        Producto temp = primero;
        if (estaVacia()) System.out.println("La lista está vacía.\n");

        while (temp != null) {
            System.out.println(temp);
            temp = temp.getSiguiente();
        }
    }

    // - reporte de costos
    public void reporteCostos(){
        Producto temp = primero;
        if (estaVacia()) System.out.println("La lista está vacía.\n");

        double total = 0;

        while (temp != null) {
            System.out.println("\n" + temp.getCantidad() + "x " + temp.getNombre() + "| Precio unitario: " + temp.getPrecio() + "| Precio: " + temp.getPrecioTotal());
            total += temp.getPrecioTotal();
            temp = temp.getSiguiente();
        }
        System.out.println("--- Total: " + total + " ---");
    }

}
