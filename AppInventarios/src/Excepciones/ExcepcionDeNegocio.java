package Excepciones;

/**
 * Excepcion base de todas las reglas de negocio del sistema.
 *
 * Al ser una excepcion no verificada, permite que las validaciones se
 * propaguen desde las clases de logica hasta el menu, que es la unica capa
 * que las traduce en mensajes para el usuario.
 */
public class ExcepcionDeNegocio extends RuntimeException {
    public ExcepcionDeNegocio(String message) {
        super(message);
    }
}
