import java.util.*;

public class pruebasAutomaticas {

    private int pruebasRealizadas = 0;
    private int pruebasExitosas = 0;
    private int pruebasFallidas = 0;

    public static void main(String[] args) {
        pruebasAutomaticas tester = new pruebasAutomaticas();

        tester.probarTask();
        tester.probarUser();
        tester.probarProject();
        tester.probarTaskManager();
        tester.probarUsuarioAdmin();

        tester.mostrarResumen();
    }

    private void probarOperacion(String descripcion, boolean resultado, boolean esperado) {
        pruebasRealizadas++;
        if (resultado == esperado) {
            pruebasExitosas++;
            System.out.println("✓ " + descripcion + " - ÉXITO");
        } else {
            pruebasFallidas++;
            System.out.println("✗ " + descripcion + " - FALLO");
            System.out.println("  Resultado: " + resultado + " (Esperado: " + esperado + ")");
        }
    }

    private void probarTask() {
        Task tarea = new Task("Tarea 1", "Descripción de prueba");
        probarOperacion("Tarea no completada por defecto", !tarea.estaCompletada(), true);
        tarea.marcarComoCompletada();
        probarOperacion("Tarea marcada como completada", tarea.estaCompletada(), true);
    }

    private void probarUser() {
        User user = new User("Carlos");
        Task tarea = new Task("Tarea X", "Desc");
        user.asignarTarea(tarea);
        probarOperacion("Tarea asignada a usuario", user.getTareasAsignadas().contains(tarea), true);
    }

    private void probarProject() {
        Project proyecto = new Project("Proyecto A");
        Task tarea = new Task("Tarea Y", "Prueba");
        proyecto.agregarTarea(tarea);
        probarOperacion("Tarea agregada a proyecto", proyecto.getTareas().contains(tarea), true);
    }

    private void probarTaskManager() {
        TaskManager manager = new TaskManager();
        Task tarea = new Task("Tarea Z", "Prueba Manager");
        User user = new User("Lucía");
        Project proyecto = new Project("Proy1");

        manager.agregarTarea(tarea);
        manager.asignarTareaAUsuario(tarea, user);
        manager.asignarTareaAProyecto(tarea, proyecto);

        boolean enLista = manager.obtenerTareas().contains(tarea);
        boolean enUsuario = user.getTareasAsignadas().contains(tarea);
        boolean enProyecto = proyecto.getTareas().contains(tarea);

        probarOperacion("Tarea agregada al sistema", enLista, true);
        probarOperacion("Tarea asignada al usuario desde Manager", enUsuario, true);
        probarOperacion("Tarea asignada al proyecto desde Manager", enProyecto, true);
    }

    private void probarUsuarioAdmin() {
        UsuarioAdmin admin = new UsuarioAdmin("Admin");
        Task t1 = new Task("T1", "");
        Task t2 = new Task("T2", "");
        List<Task> tareas = Arrays.asList(t1, t2);
        admin.completarTodas(tareas);
        boolean todasCompletadas = tareas.stream().allMatch(Task::estaCompletada);
        probarOperacion("Admin completa todas las tareas", todasCompletadas, true);
    }

    private void mostrarResumen() {
        System.out.println("\nResumen de pruebas:");
        System.out.println("Pruebas realizadas: " + pruebasRealizadas);
        System.out.println("Pruebas exitosas: " + pruebasExitosas);
        System.out.println("Pruebas fallidas: " + pruebasFallidas);
        double porcentaje = (double) pruebasExitosas / pruebasRealizadas * 100;
        System.out.printf("Porcentaje de éxito: %.2f%%\n", porcentaje);
    }
}
