package com.jererg.plataformabienestar.services;

import com.jererg.plataformabienestar.models.Servicio;
import com.jererg.plataformabienestar.repositories.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    public List<Servicio> listarTodos() {
        return servicioRepository.findAll();
    }

    public Servicio guardar(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    public Servicio obtenerPorId(String id) {
        return servicioRepository.findById(id).orElse(null);
    }

    public void eliminar(String id) {
        servicioRepository.deleteById(id);
    }
}
