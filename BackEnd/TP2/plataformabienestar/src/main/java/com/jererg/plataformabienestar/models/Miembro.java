package com.jererg.plataformabienestar.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "miembros")
public class Miembro {

    @Id
    private String id;
    private String nombre;
    private String apellido;
    private String email;
    private List<String> progreso;

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getProgreso() {
        return progreso;
    }

    public void setProgreso(List<String> progreso) {
        this.progreso = progreso;
    }
}
