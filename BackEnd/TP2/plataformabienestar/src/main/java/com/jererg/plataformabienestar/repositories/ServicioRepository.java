package com.jererg.plataformabienestar.repositories;

import com.jererg.plataformabienestar.models.Servicio;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServicioRepository extends MongoRepository<Servicio, String> {
}
