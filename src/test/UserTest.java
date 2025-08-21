package test;

import models.Task;
import models.User;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void usuarioDebeTenerNombreCorrecto() {
        User user = new User("Roberto");
        assertEquals("Roberto", user.getNombre());
    }

    @Test
    public void usuarioDebeAsignarseTareas() {
        User user = new User("Roberto");
        Task tarea = new Task("Tarea Test", "Descripción");
        user.asignarTarea(tarea);
        assertTrue(user.getTareasAsignadas().contains(tarea));
    }
}
