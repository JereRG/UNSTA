package com.jererg.plataformabienestar.controllers;

import com.jererg.plataformabienestar.models.Suscripcion;
import com.jererg.plataformabienestar.services.SuscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suscripciones")
public class SuscripcionController {

    @Autowired
    private SuscripcionService suscripcionService;

    @GetMapping
    public List<Suscripcion> listarSuscripciones() {
        return suscripcionService.listarTodos();
    }

    @PostMapping
    public Suscripcion crearSuscripcion(@RequestBody Suscripcion suscripcion) {
        return suscripcionService.guardar(suscripcion);
    }

    @GetMapping("/{id}")
    public Suscripcion obtenerSuscripcion(@PathVariable String id) {
        return suscripcionService.obtenerPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarSuscripcion(@PathVariable String id) {
        suscripcionService.eliminar(id);
    }

    @PostMapping("/suscripcion")
    public String actualizarSuscripcion(@ModelAttribute Suscripcion suscripcion) {
        suscripcionService.actualizarSuscripcion(suscripcion);
        return "redirect:/suscripciones";
    }
}
