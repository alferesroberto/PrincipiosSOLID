package models;

import java.util.ArrayList;
import java.util.List;

// --- S: Single Responsibility Principle ---
public class Project {
    private String nombre;
    private List<Task> tareas = new ArrayList<>();

    public Project(String nombre) {
        this.nombre = nombre;
    }

    public void agregarTarea(Task tarea) {
        tareas.add(tarea);
    }

    public List<Task> getTareas() {
        return tareas;
    }

    public String getNombre() {
        return nombre;
    }
}