package com.jererg.sistemadeaprendizaje.repositories;

import com.jererg.sistemadeaprendizaje.models.Estudiante;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EstudianteRepository extends MongoRepository<Estudiante, String> {
}
