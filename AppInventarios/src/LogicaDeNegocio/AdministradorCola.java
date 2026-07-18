package LogicaDeNegocio;

import Entidades.Usuario;
import Estructuras.ColaUsuarios;
import Excepciones.CarritoVacio;
import Excepciones.ColaVacia;

public class AdministradorCola {

    public static void atenderCliente(ColaUsuarios colaUsuarios){
        Usuario usuarioAtender;
        try{
            usuarioAtender = colaUsuarios.eliminarUsuario();
            usuarioAtender.getCarritoUsuario().reporteCostos();
        }catch (ColaVacia | CarritoVacio e){
            System.out.println(e.getMessage());
            return;
        }
    }
}
