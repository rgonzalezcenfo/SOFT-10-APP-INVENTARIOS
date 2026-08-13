package Estructuras;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import Entidades.Usuario;
import Excepciones.UsuarioVacio;
import Excepciones.ColaVacia;

public class ColaUsuarios {

    // Atributos
    private List<Usuario> colaClientes;
    private Grafo grafo;

    // Constructor
    public ColaUsuarios(Grafo grafo) {
        this.colaClientes = new ArrayList<>();
        this.grafo = grafo;
    }

    // Métodos

    public void agregarUsuario(Usuario usuario) {
        if (usuario == null) {
            throw new UsuarioVacio("El usuario no puede estar vacio");
        }
        grafo.agregarVertice(usuario.getUbicacion());
        colaClientes.add(usuario);
        colaClientes.sort(Comparator.comparingInt(Usuario::getPrioridad).reversed());
    }

    public Usuario eliminarUsuario() {

        if (colaClientes.isEmpty()) {
            throw new ColaVacia("No hay clientes en la cola");
        }

        return colaClientes.removeFirst();
    }

    public Usuario verFrente() {
        if (colaClientes.isEmpty()) {
            throw new ColaVacia("No hay clientes en la cola");
        }

        return colaClientes.getFirst();
    }
}