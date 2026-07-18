package Excepciones;

public class UsuarioVacio extends RuntimeException {
    public UsuarioVacio(String message) {
        super(message);
    }
}
