package models;

import java.util.ArrayList;
import java.util.List;

// --- S: Single Responsibility Principle ---
public class User {
    private String nombre;
    private List<Task> tareasAsignadas = new ArrayList<>();

    public User(String nombre) {
        this.nombre = nombre;
    }

    public void asignarTarea(Task tarea) {
        tareasAsignadas.add(tarea);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Task> getTareasAsignadas() {
        return tareasAsignadas;
    }
}