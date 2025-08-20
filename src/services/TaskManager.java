package services;

import interfaces.IAsignacionManager;
import interfaces.ITareaManager;
import models.Project;
import models.Task;
import models.User;

import java.util.ArrayList;
import java.util.List;

// --- D: Dependency Inversion Principle ---
public class TaskManager implements ITareaManager, IAsignacionManager {
    private List<Task> tareas = new ArrayList<>();

    @Override
    public void agregarTarea(Task tarea) {
        tareas.add(tarea);
    }

    @Override
    public List<Task> obtenerTareas() {
        return tareas;
    }

    @Override
    public void asignarTareaAUsuario(Task tarea, User usuario) {
        usuario.asignarTarea(tarea);
    }

    @Override
    public void asignarTareaAProyecto(Task tarea, Project proyecto) {
        proyecto.agregarTarea(tarea);
    }

}