package com.jererg.plataformabienestar.controllers;

import com.jererg.plataformabienestar.models.Servicio;
import com.jererg.plataformabienestar.services.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicios")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    @GetMapping
    public List<Servicio> listarServicios() {
        return servicioService.listarTodos();
    }

    @PostMapping
    public Servicio crearServicio(@RequestBody Servicio servicio) {
        return servicioService.guardar(servicio);
    }

    @GetMapping("/{id}")
    public Servicio obtenerServicio(@PathVariable String id) {
        return servicioService.obtenerPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarServicio(@PathVariable String id) {
        servicioService.eliminar(id);
    }
}
