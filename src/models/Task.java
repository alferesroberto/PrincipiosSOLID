package models;

// --- S: Single Responsibility Principle ---
public class Task {
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