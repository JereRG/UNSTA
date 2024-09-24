package com.jererg.plataformabienestar.repositories;

import com.jererg.plataformabienestar.models.Reserva;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservaRepository extends MongoRepository<Reserva, String> {
}
