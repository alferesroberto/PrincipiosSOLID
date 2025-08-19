// Sistema de Gestión de Tareas aplicando los principios SOLID

import java.util.*;

// --- S: Single Responsibility Principle ---
class Task {
    private String titulo;
    private String descripcion;
    private boolean completada;

    public Task(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.completada = false;
    }

    public void marcarComoCompletada() {
        this.completada = true;
    }

    public boolean estaCompletada() {
        return completada;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "[" + (completada ? "X" : " ") + "] " + titulo + ": " + descripcion;
    }
}

// --- S: Single Responsibility Principle ---
class Project {
    private String nombre;
    private List<Task> tareas = new ArrayList<>();

    public Project(String nombre) {
        this.nombre = nombre;
    }

    public void agregarTarea(Task tarea) {
        tareas.add(tarea);
    }

    public List<Task> getTareas() {
        return tareas;
    }

    public String getNombre() {
        return nombre;
    }
}

// --- S: Single Responsibility Principle ---
class User {
    private String nombre;
    private List<Task> tareasAsignadas = new ArrayList<>();

    public User(String nombre) {
        this.nombre = nombre;
    }

    public void asignarTarea(Task tarea) {
        tareasAsignadas.add(tarea);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Task> getTareasAsignadas() {
        return tareasAsignadas;
    }
}

// --- I: Interface Segregation Principle ---
interface ITareaManager {
    void agregarTarea(Task tarea);
    List<Task> obtenerTareas();
}

interface IAsignacionManager {
    void asignarTareaAUsuario(Task tarea, User usuario);
    void asignarTareaAProyecto(Task tarea, Project proyecto);
}

// --- D: Dependency Inversion Principle ---
class TaskManager implements ITareaManager, IAsignacionManager {
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

// --- O: Open/Closed Principle (extensible sin modificar TaskManager) ---
class TaskPrinter {
    public void imprimirTareas(List<Task> tareas) {
        for (Task t : tareas) {
            System.out.println(t);
        }
    }
}

// --- L: Liskov Substitution Principle ---
class UsuarioAdmin extends User {
    public UsuarioAdmin(String nombre) {
        super(nombre);
    }

    public void completarTodas(List<Task> tareas) {
        for (Task t : tareas) {
            t.marcarComoCompletada();
        }
    }
}

