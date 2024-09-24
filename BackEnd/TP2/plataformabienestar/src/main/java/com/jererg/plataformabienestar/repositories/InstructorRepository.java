package com.jererg.plataformabienestar.repositories;

import com.jererg.plataformabienestar.models.Instructor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InstructorRepository extends MongoRepository<Instructor, String> {
}
