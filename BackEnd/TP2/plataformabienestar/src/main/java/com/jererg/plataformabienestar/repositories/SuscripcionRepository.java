package com.jererg.plataformabienestar.repositories;

import com.jererg.plataformabienestar.models.Suscripcion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SuscripcionRepository extends MongoRepository<Suscripcion, String> {
}
