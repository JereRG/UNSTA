package com.jererg.sistemadeaprendizaje.repositories;

import com.jererg.sistemadeaprendizaje.models.Curso;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CursoRepository extends MongoRepository<Curso, String> {
}
