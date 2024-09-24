package com.jererg.sistemadeaprendizaje.models;

public class Progreso {
    private String cursoId;
    private String moduloId;
    private String leccionId;
    private double porcentajeCompletado;

    // Getters y Setters
    public String getCursoId() { return cursoId; }
    public void setCursoId(String cursoId) { this.cursoId = cursoId; }
    public String getModuloId() { return moduloId; }
    public void setModuloId(String moduloId) { this.moduloId = moduloId; }
    public String getLeccionId() { return leccionId; }
    public void setLeccionId(String leccionId) { this.leccionId = leccionId; }
    public double getPorcentajeCompletado() { return porcentajeCompletado; }
    public void setPorcentajeCompletado(double porcentajeCompletado) { this.porcentajeCompletado = porcentajeCompletado; }
}
