package Excepciones;

/**
 * Se lanza al intentar recorrer o reportar el inventario cuando el arbol de
 * productos no tiene ningun elemento.
 */
public class InventarioVacio extends ExcepcionDeNegocio {
    public InventarioVacio(String message) {
        super(message);
    }
}
