package com.jererg.plataformabienestar.controllers;

import com.jererg.plataformabienestar.models.Miembro;
import com.jererg.plataformabienestar.services.MiembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/miembros")
public class MiembroController {

    @Autowired
    private MiembroService miembroService;

    @GetMapping
    public List<Miembro> listarMiembros() {
        return miembroService.listarTodos();
    }

    @PostMapping
    public Miembro crearMiembro(@RequestBody Miembro miembro) {
        return miembroService.guardar(miembro);
    }

    @GetMapping("/{id}")
    public Miembro obtenerMiembro(@PathVariable String id) {
        return miembroService.obtenerPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarMiembro(@PathVariable String id) {
        miembroService.eliminar(id);
    }

    @PostMapping("/miembro/perfil")
    public String actualizarPerfil(@ModelAttribute Miembro miembro) {
        miembroService.actualizarMiembro(miembro);
        return "redirect:/perfil"; // Redirecciona a la vista del perfil
    }
}
