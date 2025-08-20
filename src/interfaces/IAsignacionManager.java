package interfaces;

import models.Project;
import models.Task;
import models.User;

public interface IAsignacionManager {
    void asignarTareaAUsuario(Task tarea, User usuario);
    void asignarTareaAProyecto(Task tarea, Project proyecto);
}
