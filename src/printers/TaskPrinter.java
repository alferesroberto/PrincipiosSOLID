package printers;

import models.Task;

import java.util.List;

// --- O: Open/Closed Principle (extensible sin modificar TaskManager) ---
public class TaskPrinter {
    public void imprimirTareas(List<Task> tareas) {
        for (Task t : tareas) {
            System.out.println(t);
        }
    }
}