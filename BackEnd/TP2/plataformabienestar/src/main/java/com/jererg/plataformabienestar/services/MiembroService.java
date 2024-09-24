package com.jererg.plataformabienestar.services;

import com.jererg.plataformabienestar.models.Miembro;
import com.jererg.plataformabienestar.repositories.MiembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MiembroService {

    @Autowired
    private MiembroRepository miembroRepository;

    public List<Miembro> listarTodos() {
        return miembroRepository.findAll();
    }

    public Miembro guardar(Miembro miembro) {
        return miembroRepository.save(miembro);
    }

    public Miembro obtenerPorId(String id) {
        return miembroRepository.findById(id).orElse(null);
    }

    public void eliminar(String id) {
        miembroRepository.deleteById(id);
    }

    public void actualizarMiembro(Miembro miembro) {
        Miembro existente = miembroRepository.findById(miembro.getId()).orElse(null);
        if (existente != null) {
            existente.setNombre(miembro.getNombre());
            existente.setApellido(miembro.getApellido());
            existente.setEmail(miembro.getEmail());
            miembroRepository.save(existente);
        }
    }
}
