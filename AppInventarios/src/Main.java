import Entidades.Tienda;
import Menu.Menu;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Tienda nuevaTienda = new Tienda();
        Menu.iniciarMenu(nuevaTienda);
    }
}
