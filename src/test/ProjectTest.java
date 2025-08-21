package test;

import models.Project;
import models.Task;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class ProjectTest {

    @Test
    public void debeAgregarTareaAlProyecto() {
        Project proyecto = new Project("Proyecto Test");
        Task tarea = new Task("Tarea 1", "Descripción");

        proyecto.agregarTarea(tarea);
        List<Task> tareas = proyecto.getTareas();

        assertEquals(1, tareas.size());
        assertEquals("Tarea 1", tareas.get(0).getTitulo());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void listaDeTareasDebeSerInmutable() {
        Project proyecto = new Project("Proyecto Test");
        proyecto.getTareas().add(new Task("Hack", "No permitido"));
    }
}
