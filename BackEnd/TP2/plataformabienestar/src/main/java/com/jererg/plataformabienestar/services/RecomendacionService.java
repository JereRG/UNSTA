package com.jererg.plataformabienestar.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecomendacionService {

    public List<String> generarRecomendaciones() {
        // Lógica para generar recomendaciones personalizadas (ejemplo simple)
        return List.of("Recomendación 1: Meditación", "Recomendación 2: Yoga");
    }
}
