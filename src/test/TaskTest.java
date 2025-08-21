package test;

import models.Task;
import org.junit.Test;
import static org.junit.Assert.*;

public class TaskTest {

    @Test
    public void tareaDebeIniciarNoCompletada() {
        Task tarea = new Task("Prueba", "Descripción");
        assertFalse(tarea.estaCompletada());
    }

    @Test
    public void tareaDebeMarcarseComoCompletada() {
        Task tarea = new Task("Prueba", "Descripción");
        tarea.marcarComoCompletada();
        assertTrue(tarea.estaCompletada());
    }

    @Test
    public void toStringDebeMostrarEstadoCorrecto() {
        Task tarea = new Task("Prueba", "Descripción");
        assertTrue(tarea.toString().contains("[ ]"));
        tarea.marcarComoCompletada();
        assertTrue(tarea.toString().contains("[X]"));
    }
}
