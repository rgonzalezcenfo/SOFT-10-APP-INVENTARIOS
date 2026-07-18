package Estructuras;

import Entidades.Producto;
import Excepciones.ArticuloYaExiste;
import Excepciones.InventarioVacio;

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
                throw new ArticuloYaExiste("El articulo con el nombre: "+nuevo.getNombre()+" ya existe en el inventario");
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
            throw new InventarioVacio("El inventario se encuentra vacio");
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
    public void eliminar(Producto productoEliminar){

    }
    private Producto encontrarSucesor(Producto producto){
        Producto padreSucesor = producto;
        Producto sucesor = producto;
        Producto nodoActual = producto.getDerecha();
        while (nodoActual != null){
            padreSucesor = sucesor;
            sucesor = nodoActual;
            nodoActual =  nodoActual.getIzquierda();
        }
        if(sucesor != producto.getDerecha()){
            padreSucesor.setIzquierda(sucesor.getDerecha());
            sucesor.setDerecha(producto.getDerecha());
        }
        return sucesor;
    }
    public void reporteInventario(){
        System.out.println("==========Reporte de inventario==========");
        recorridoInorden();
        double totalInventario = calcularTotalInventario();
        System.out.println("El total en el inventario es: "+totalInventario);
    }
    private double calcularTotalInventario() {
        if (estaVacio()) {
            throw new InventarioVacio("El inventario se encuentra vacio");
        }

        return calcularTotal(raiz);
    }

    private double calcularTotal(Producto actual) {
        if (actual == null) {
            return 0;
        }

        return calcularTotal(actual.getIzquierda())
                + actual.getPrecioTotal()
                + calcularTotal(actual.getDerecha());
    }



}
