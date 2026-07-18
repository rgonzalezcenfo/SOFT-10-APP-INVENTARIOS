package Estructuras;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import Entidades.Usuario;
import Excepciones.UsuarioVacio;
import Excepciones.ColaVacia;

import java.util.concurrent.CompletionService;

public class ColaUsuarios {
    private List<Usuario> colaClientes;

    public ColaUsuarios (){
        colaClientes = new ArrayList<>();
    }
    public void agregarUsuario(Usuario usuario){
        if(usuario == null) throw new UsuarioVacio("El usuario no puede estar vacio");
        colaClientes.add(usuario);
        colaClientes.sort(Comparator.comparingInt(Usuario::getPrioridad));
    }
    public Usuario eliminarUsuario(){
        if (colaClientes.isEmpty()) throw new ColaVacia("No hay elementos en la cola");
        return colaClientes.removeFirst();
    }
    public Usuario verFrente(){
        if (colaClientes.isEmpty()) throw new ColaVacia("No hay elementos en la cola");
        System.out.println(colaClientes.getFirst().toString());
        return colaClientes.getFirst();
    }

}
