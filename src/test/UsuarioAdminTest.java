package test;

import models.Task;
import models.UsuarioAdmin;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class UsuarioAdminTest {

    @Test
    public void adminDebeCompletarTodasLasTareas() {
        UsuarioAdmin admin = new UsuarioAdmin("Admin");
        Task t1 = new Task("Tarea 1", "Desc 1");
        Task t2 = new Task("Tarea 2", "Desc 2");

        List<Task> lista = Arrays.asList(t1, t2);
        admin.completarTodas(lista);

        assertTrue(t1.estaCompletada());
        assertTrue(t2.estaCompletada());
    }
}
