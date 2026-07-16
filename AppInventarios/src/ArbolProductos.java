public class ArbolProductos {

    //Atributos
    private Producto raiz;

    //Constructor
    public ArbolProductos() {
        this.raiz = null;
    }

    //estaVacio
    public boolean estaVacio() {
        return raiz == null;
    }

    //inserta un producto ubicandolo por nombre, la llave es unica
    public void insertar(Producto nuevo) {
        //si el arbol esta vacio el nuevo producto queda como raiz
        if (estaVacio()) {
            raiz = nuevo;
            return;
        }

        //recorremos el arbol buscando el lugar correcto
        Producto actual = raiz;
        while (actual != null) {
            int comparacion = nuevo.getNombre().compareTo(actual.getNombre());

            //si el nombre ya existe no se inserta
            if (comparacion == 0) {
                System.out.println("Ya existe un producto con ese nombre");
                return;
            }

            //si el nombre es menor va hacia la izquierda
            if (comparacion < 0) {
                if (actual.getIzquierda() == null) {
                    actual.setIzquierda(nuevo);
                    return;
                }
                actual = actual.getIzquierda();
            } else {
                //si el nombre es mayor va hacia la derecha
                if (actual.getDerecha() == null) {
                    actual.setDerecha(nuevo);
                    return;
                }
                actual = actual.getDerecha();
            }
        }
    }

    //busca un producto por nombre y retorna su nodo, o null si no esta
    public Producto buscar(String nombre) {
        Producto actual = raiz;
        while (actual != null) {
            int comparacion = nombre.compareTo(actual.getNombre());

            //si el nombre es igual encontramos el producto
            if (comparacion == 0) {
                return actual;
            }

            //si el nombre es menor seguimos por la izquierda
            if (comparacion < 0) {
                actual = actual.getIzquierda();
            } else {
                //si el nombre es mayor seguimos por la derecha
                actual = actual.getDerecha();
            }
        }
        //si llegamos a null no existe
        return null;
    }

    //muestra el inventario ordenado alfabeticamente recorriendo en inorden
    public void recorridoInorden() {
        if (estaVacio()) {
            System.out.println("El arbol esta vacio.");
            return;
        }
        inorden(raiz);
    }

    //metodo auxiliar recursivo: izquierda, nodo, derecha
    private void inorden(Producto actual) {
        if (actual == null) {
            return;
        }
        inorden(actual.getIzquierda());
        System.out.println(actual);
        inorden(actual.getDerecha());
    }

}
