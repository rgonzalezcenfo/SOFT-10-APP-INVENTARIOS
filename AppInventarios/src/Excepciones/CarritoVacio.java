package Excepciones;

public class CarritoVacio extends RuntimeException {
    public CarritoVacio(String message) {
        super(message);
    }
}
