package interfaces;

import models.Task;
import models.User;

import java.util.List;

// --- I: Interface Segregation Principle ---
public interface ITareaManager {
    void agregarTarea(Task tarea);
    List<Task> obtenerTareas();

    void asignarTareaAUsuario(Task tarea, User user);
}