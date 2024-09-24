package com.jererg.plataformabienestar.controllers;

import com.jererg.plataformabienestar.models.Pago;
import com.jererg.plataformabienestar.services.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @GetMapping
    public List<Pago> listarPagos() {
        return pagoService.listarTodos();
    }

    @PostMapping
    public Pago crearPago(@RequestBody Pago pago) {
        return pagoService.guardar(pago);
    }

    @GetMapping("/{id}")
    public Pago obtenerPago(@PathVariable String id) {
        return pagoService.obtenerPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarPago(@PathVariable String id) {
        pagoService.eliminar(id);
    }
}
