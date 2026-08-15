package Excepciones;

/**
 * Se lanza cuando no se encuentra ningun producto que corresponda al nombre
 * indicado, ya sea en el inventario o dentro del carrito de un cliente.
 */
public class ProductoNoExiste extends RuntimeException {
    public ProductoNoExiste(String message) {
        super(message);
    }
}
