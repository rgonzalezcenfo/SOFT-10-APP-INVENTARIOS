package Excepciones;

/**
 * Se lanza al intentar consultar, modificar o facturar un carrito de compras
 * que no contiene ningun producto.
 */
public class CarritoVacio extends RuntimeException {
    public CarritoVacio(String message) {
        super(message);
    }
}
