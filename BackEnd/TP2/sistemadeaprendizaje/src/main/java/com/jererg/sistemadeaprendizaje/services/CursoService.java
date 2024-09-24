package com.jererg.sistemadeaprendizaje.services;

import com.jererg.sistemadeaprendizaje.models.Curso;
import com.jererg.sistemadeaprendizaje.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> listarTodos() {
        return cursoRepository.findAll();
    }

    public Curso crearCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Curso obtenerPorId(String id) {
        return cursoRepository.findById(id).orElse(null);
    }

    public void eliminar(String id) {
        cursoRepository.deleteById(id);
    }
}
