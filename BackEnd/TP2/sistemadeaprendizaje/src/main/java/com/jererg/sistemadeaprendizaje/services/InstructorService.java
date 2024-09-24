package com.jererg.sistemadeaprendizaje.services;

import com.jererg.sistemadeaprendizaje.models.Instructor;
import com.jererg.sistemadeaprendizaje.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    public List<Instructor> listarTodos() {
        return instructorRepository.findAll();
    }

    public Instructor guardar(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    public Instructor obtenerPorId(String id) {
        return instructorRepository.findById(id).orElse(null);
    }

    public void eliminar(String id) {
        instructorRepository.deleteById(id);
    }
}
