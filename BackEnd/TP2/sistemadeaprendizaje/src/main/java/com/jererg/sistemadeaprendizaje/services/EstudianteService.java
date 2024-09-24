package com.jererg.sistemadeaprendizaje.services;

import com.jererg.sistemadeaprendizaje.models.Estudiante;
import com.jererg.sistemadeaprendizaje.repositories.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    public List<Estudiante> listarTodos() {
        return estudianteRepository.findAll();
    }

    public Estudiante crearEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    public Estudiante obtenerPorId(String id) {
        return estudianteRepository.findById(id).orElse(null);
    }

    public void eliminar(String id) {
        estudianteRepository.deleteById(id);
    }
}
