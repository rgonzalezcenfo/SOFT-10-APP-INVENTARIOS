package Excepciones;

/**
 * Se lanza al intentar agregar un usuario nulo a la cola de atencion.
 */
public class UsuarioVacio extends RuntimeException {
    public UsuarioVacio(String message) {
        super(message);
    }
}
