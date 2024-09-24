package com.jererg.sistemadeaprendizaje.repositories;

import com.jererg.sistemadeaprendizaje.models.Instructor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InstructorRepository extends MongoRepository<Instructor, String> {
}
