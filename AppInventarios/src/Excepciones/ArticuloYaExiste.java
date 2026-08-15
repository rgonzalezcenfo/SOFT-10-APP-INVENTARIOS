package Excepciones;

/**
 * Se lanza al intentar insertar en el inventario un producto cuyo nombre
 * ya esta registrado.
 *
 * El nombre es la llave unica del arbol binario de busqueda, por lo que no
 * se admiten duplicados.
 */
public class ArticuloYaExiste extends ExcepcionDeNegocio {
    public ArticuloYaExiste(String message) {
        super(message);
    }
}
