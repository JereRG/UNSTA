package com.jererg.plataformabienestar.controllers;

import com.jererg.plataformabienestar.models.Instalacion;
import com.jererg.plataformabienestar.services.InstalacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instalaciones")
public class InstalacionController {

    @Autowired
    private InstalacionService instalacionService;

    @GetMapping
    public List<Instalacion> listarInstalaciones() {
        return instalacionService.listarTodos();
    }

    @PostMapping
    public Instalacion crearInstalacion(@RequestBody Instalacion instalacion) {
        return instalacionService.guardar(instalacion);
    }

    @GetMapping("/{id}")
    public Instalacion obtenerInstalacion(@PathVariable String id) {
        return instalacionService.obtenerPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarInstalacion(@PathVariable String id) {
        instalacionService.eliminar(id);
    }

}
