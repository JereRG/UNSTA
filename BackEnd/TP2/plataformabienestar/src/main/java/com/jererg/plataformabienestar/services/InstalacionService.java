package com.jererg.plataformabienestar.services;

import com.jererg.plataformabienestar.models.Instalacion;
import com.jererg.plataformabienestar.repositories.InstalacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstalacionService {

    @Autowired
    private InstalacionRepository instalacionRepository;

    public List<Instalacion> listarTodos() {
        return instalacionRepository.findAll();
    }

    public Instalacion guardar(Instalacion instalacion) {
        return instalacionRepository.save(instalacion);
    }

    public Instalacion obtenerPorId(String id) {
        return instalacionRepository.findById(id).orElse(null);
    }

    public void eliminar(String id) {
        instalacionRepository.deleteById(id);
    }
}
