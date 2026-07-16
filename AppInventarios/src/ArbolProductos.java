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

}
