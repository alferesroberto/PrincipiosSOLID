package models;

import java.util.List;

// --- L: Liskov Substitution Principle ---
public class UsuarioAdmin extends User {
    public UsuarioAdmin(String nombre) {
        super(nombre);
    }

    public void completarTodas(List<Task> tareas) {
        for (Task t : tareas) {
            t.marcarComoCompletada();
        }
    }
}