package com.jererg.plataformabienestar.repositories;

import com.jererg.plataformabienestar.models.Instalacion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InstalacionRepository extends MongoRepository<Instalacion, String> {
}
