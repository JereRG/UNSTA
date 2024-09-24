package com.jererg.plataformabienestar.services;

import com.jererg.plataformabienestar.models.Pago;
import com.jererg.plataformabienestar.repositories.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    public List<Pago> listarTodos() {
        return pagoRepository.findAll();
    }

    public Pago guardar(Pago pago) {
        return pagoRepository.save(pago);
    }

    public Pago obtenerPorId(String id) {
        return pagoRepository.findById(id).orElse(null);
    }

    public void eliminar(String id) {
        pagoRepository.deleteById(id);
    }
}
