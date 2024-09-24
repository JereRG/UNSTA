package com.jererg.plataformabienestar.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "instructores")
public class Instructor {

    @Id
    private String id;
    private String nombre;
    private String especialidad;
    private List<String> disponibilidad;

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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<String> getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(List<String> disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}
