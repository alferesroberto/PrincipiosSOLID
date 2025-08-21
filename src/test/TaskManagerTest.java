package test;

import models.Project;
import models.Task;
import models.User;
import org.junit.Test;
import services.TaskManager;

import java.util.List;
import static org.junit.Assert.*;

public class TaskManagerTest {

    @Test
    public void debeAgregarTareaCorrectamente() {
        TaskManager manager = new TaskManager();
        Task tarea = new Task("Tarea 1", "Descripción");

        manager.agregarTarea(tarea);
        List<Task> tareas = manager.obtenerTareas();

        assertEquals(1, tareas.size());
        assertEquals("Tarea 1", tareas.get(0).getTitulo());
    }

    @Test
    public void debeAsignarTareaAUsuario() {
        TaskManager manager = new TaskManager();
        Task tarea = new Task("Tarea 2", "Descripción");
        User user = new User("Roberto");

        manager.asignarTareaAUsuario(tarea, user);
        assertTrue(user.getTareasAsignadas().contains(tarea));
    }

    @Test
    public void debeAsignarTareaAProyecto() {
        TaskManager manager = new TaskManager();
        Task tarea = new Task("Tarea 3", "Descripción");
        Project proyecto = new Project("Proyecto 1");

        manager.asignarTareaAProyecto(tarea, proyecto);
        assertTrue(proyecto.getTareas().contains(tarea));
    }
}
