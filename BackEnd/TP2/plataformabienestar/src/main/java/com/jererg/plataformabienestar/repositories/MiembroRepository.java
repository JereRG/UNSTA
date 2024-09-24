package com.jererg.plataformabienestar.repositories;

import com.jererg.plataformabienestar.models.Miembro;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MiembroRepository extends MongoRepository<Miembro, String> {
}
