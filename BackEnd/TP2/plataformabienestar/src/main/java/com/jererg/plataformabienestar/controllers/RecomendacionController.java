package com.jererg.plataformabienestar.controllers;

import com.jererg.plataformabienestar.services.RecomendacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecomendacionController {

    @Autowired
    private RecomendacionService recomendacionService;

    @GetMapping("/recomendaciones")
    public String mostrarRecomendaciones(Model model) {
        model.addAttribute("recomendaciones", recomendacionService.generarRecomendaciones());
        return "recomendaciones";
    }
}
