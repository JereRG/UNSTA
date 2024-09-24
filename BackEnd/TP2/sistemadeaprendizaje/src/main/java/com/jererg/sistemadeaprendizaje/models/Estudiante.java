package com.jererg.sistemadeaprendizaje.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "estudiantes")
public class Estudiante {
    @Id
    private String id;
    private String nombre;
    private String email;
    private List<Progreso> progreso;

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public List<Progreso> getProgreso() { return progreso; }
    public void setProgreso(List<Progreso> progreso) { this.progreso = progreso; }
}
