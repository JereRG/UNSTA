package com.jererg.plataformabienestar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.jererg.plataformabienestar.models.Servicio;
import com.jererg.plataformabienestar.services.ServicioService;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ServicioService servicioService;

    @GetMapping("/")
    public String index(Model model) {
    // Obtener lista de servicios
        List<Servicio> servicios = servicioService.listarTodos();
        System.out.println("Servicios encontrados: " + servicios); // Depuración

        // Pasar la lista de servicios al modelo
        model.addAttribute("servicios", servicios);
        
        return "index";
    }
}