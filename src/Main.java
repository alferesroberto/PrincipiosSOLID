import models.Project;
import models.Task;
import models.User;
import printers.TaskPrinter;
import services.TaskManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// --- Interfaz de Usuario (Consola) ---
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager gestor = new TaskManager();
        List<User> usuarios = new ArrayList<>();
        List<Project> proyectos = new ArrayList<>();
        TaskPrinter printer = new TaskPrinter();

        while (true) {
            System.out.println("\n--- SISTEMA DE GESTIÓN DE TAREAS ---");
            System.out.println("1. Crear Tarea");
            System.out.println("2. Crear Usuario");
            System.out.println("3. Crear Proyecto");
            System.out.println("4. Asignar Tarea a Usuario");
            System.out.println("5. Asignar Tarea a Proyecto");
            System.out.println("6. Ver Tareas");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Descripción: ");
                    String descripcion = scanner.nextLine();
                    gestor.agregarTarea(new Task(titulo, descripcion));
                    break;
                case 2:
                    System.out.print("Nombre del usuario: ");
                    usuarios.add(new User(scanner.nextLine()));
                    break;
                case 3:
                    System.out.print("Nombre del proyecto: ");
                    proyectos.add(new Project(scanner.nextLine()));
                    break;
                case 4:
                    System.out.print("Índice de tarea: ");
                    int idxT = scanner.nextInt();
                    System.out.print("Índice de usuario: ");
                    int idxU = scanner.nextInt();
                    gestor.asignarTareaAUsuario(gestor.obtenerTareas().get(idxT), usuarios.get(idxU));
                    break;
                case 5:
                    System.out.print("Índice de tarea: ");
                    int idxT2 = scanner.nextInt();
                    System.out.print("Índice de proyecto: ");
                    int idxP = scanner.nextInt();
                    gestor.asignarTareaAProyecto(gestor.obtenerTareas().get(idxT2), proyectos.get(idxP));
                    break;
                case 6:
                    printer.imprimirTareas(gestor.obtenerTareas());
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }
}