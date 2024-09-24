package com.jererg.plataformabienestar.controllers;

import com.jererg.plataformabienestar.services.ProgresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProgresoController {

    @Autowired
    private ProgresoService progresoService;

    @GetMapping("/progreso")
    public String mostrarProgreso(Model model) {
        model.addAttribute("progreso", progresoService.obtenerProgreso());
        return "progreso";
    }
}
