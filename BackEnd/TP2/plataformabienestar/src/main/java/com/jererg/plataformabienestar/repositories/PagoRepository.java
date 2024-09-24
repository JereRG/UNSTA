package com.jererg.plataformabienestar.repositories;

import com.jererg.plataformabienestar.models.Pago;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PagoRepository extends MongoRepository<Pago, String> {
}
