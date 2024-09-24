package com.jererg.plataformabienestar.services;

import com.jererg.plataformabienestar.models.Suscripcion;
import com.jererg.plataformabienestar.repositories.SuscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuscripcionService {

    @Autowired
    private SuscripcionRepository suscripcionRepository;

    public List<Suscripcion> listarTodos() {
        return suscripcionRepository.findAll();
    }

    public Suscripcion guardar(Suscripcion suscripcion) {
        return suscripcionRepository.save(suscripcion);
    }

    public Suscripcion obtenerPorId(String id) {
        return suscripcionRepository.findById(id).orElse(null);
    }

    public void eliminar(String id) {
        suscripcionRepository.deleteById(id);
    }

    public void actualizarSuscripcion(Suscripcion suscripcion) {
        Suscripcion existente = suscripcionRepository.findById(suscripcion.getId()).orElse(null);
        if (existente != null) {
            existente.setTipo(suscripcion.getTipo());
            existente.setEstado(suscripcion.getEstado());
            existente.setFechaInicio(suscripcion.getFechaInicio());
            existente.setFechaFin(suscripcion.getFechaFin());
            suscripcionRepository.save(existente);
        }
    }

}
