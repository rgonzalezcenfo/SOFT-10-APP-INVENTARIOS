package Excepciones;

/**
 * Se lanza al intentar atender o consultar al siguiente cliente cuando la
 * cola de atencion no tiene clientes pendientes.
 */
public class ColaVacia extends RuntimeException {
    public ColaVacia(String message) {
        super(message);
    }
}
