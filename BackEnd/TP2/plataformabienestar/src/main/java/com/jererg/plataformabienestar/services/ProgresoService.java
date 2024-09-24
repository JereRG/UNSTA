package com.jererg.plataformabienestar.services;

import com.jererg.plataformabienestar.models.Miembro;
import com.jererg.plataformabienestar.repositories.MiembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgresoService {

    @Autowired
    private MiembroRepository miembroRepository;

    public List<String> obtenerProgreso() {
        // Lógica para obtener el progreso del miembro (ejemplo básico)
        Miembro miembro = miembroRepository.findById("1").orElse(null);
        return miembro != null ? miembro.getProgreso() : List.of();
    }
}
