package Excepciones;

public class ProductoNoExiste extends RuntimeException {
    public ProductoNoExiste(String message) {
        super(message);
    }
}
