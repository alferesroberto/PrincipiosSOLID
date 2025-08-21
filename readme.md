# Sistema de Gestión de Tareas - Proyecto Java

Este proyecto implementa un sistema de gestión de tareas en Java, aplicando los principios **SOLID** para garantizar una arquitectura limpia, mantenible y escalable. Incluye pruebas unitarias con **JUnit 4.13**.

---

## Estructura del Proyecto

src/
├─ main/java/com/gestiontareas/
│ ├─ models/ # Clases que representan entidades (Task, Project, User, UsuarioAdmin)
│ ├─ services/ # Lógica de negocio (TaskManager)
│ ├─ interfaces/ # Contratos (ITareaManager, IAsignacionUsuario, IAsignacionProyecto, TaskPrinter)
│ ├─ printers/ # Implementaciones de impresión (ConsoleTaskPrinter, DetailedTaskPrinter)
│ └─ Main.java # Punto de entrada del programa
│
└─ test/java/com/gestiontareas/
├─ models/ # Pruebas unitarias de entidades
└─ services/ # Pruebas unitarias de servicios


---

## Principios SOLID Aplicados

1. **S - Single Responsibility Principle**  
   Cada clase tiene una única responsabilidad.

2. **O - Open/Closed Principle**  
   El sistema es abierto a extensión pero cerrado a modificación (ej. TaskPrinter con distintas implementaciones).

3. **L - Liskov Substitution Principle**  
   Las clases hijas pueden sustituir a sus padres sin romper el comportamiento (UsuarioAdmin extiende User).

4. **I - Interface Segregation Principle**  
   Interfaces pequeñas y específicas para no obligar a implementar métodos innecesarios.

5. **D - Dependency Inversion Principle**  
   Las clases dependen de abstracciones, no de implementaciones concretas (TaskManager implementa interfaces).

---

## Requisitos Previos

- **JDK 8 o superior**
- **JUnit 4.13** y **Hamcrest 1.3** agregados al classpath (`lib/`)

---

## Compilación y Ejecución

### Compilar el proyecto
```bash
javac -cp ".;lib/junit-4.13.jar;lib/hamcrest-core-1.3.jar" -d bin src/main/java/com/gestiontareas/**/*.java

Ejecutar el programa
java -cp "bin" com.gestiontareas.Main

Ejecución de Pruebas Unitarias
Compilar las pruebas
javac -cp ".;bin;lib/junit-4.13.jar;lib/hamcrest-core-1.3.jar" -d bin src/test/java/com/gestiontareas/**/*.java

Ejecutar las pruebas
