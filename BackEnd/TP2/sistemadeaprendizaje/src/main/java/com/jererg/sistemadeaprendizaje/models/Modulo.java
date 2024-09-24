package com.jererg.sistemadeaprendizaje.models;

import java.util.List;

public class Modulo {
    private String id;
    private String nombre;
    private List<Leccion> lecciones;

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public List<Leccion> getLecciones() { return lecciones; }
    public void setLecciones(List<Leccion> lecciones) { this.lecciones = lecciones; }
}
