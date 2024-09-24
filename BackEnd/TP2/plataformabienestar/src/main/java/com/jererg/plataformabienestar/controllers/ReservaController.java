package com.jererg.plataformabienestar.controllers;

import com.jererg.plataformabienestar.models.Reserva;
import com.jererg.plataformabienestar.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public List<Reserva> listarReservas() {
        return reservaService.listarTodos();
    }

    @PostMapping
    public Reserva crearReserva(@RequestBody Reserva reserva) {
        return reservaService.guardar(reserva);
    }

    @GetMapping("/{id}")
    public Reserva obtenerReserva(@PathVariable String id) {
        return reservaService.obtenerPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarReserva(@PathVariable String id) {
        reservaService.eliminar(id);
    }

    @PostMapping("/reservar")
    public String reservar(@RequestParam String servicioId, @RequestParam String fecha, @RequestParam String miembroId) {
        reservaService.crearReserva(servicioId, fecha, miembroId);
        return "redirect:/reservas"; // Redirecciona a la lista de reservas
    }
}
