package com.jererg.sistemadeaprendizaje.controllers;

import com.jererg.sistemadeaprendizaje.models.Estudiante;
import com.jererg.sistemadeaprendizaje.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping
    public String listarEstudiantes(Model model) {
        List<Estudiante> estudiantes = estudianteService.listarTodos();
        model.addAttribute("estudiantes", estudiantes);
        return "index"; // Asegúrate de tener una plantilla 'index.html'
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        return "crear_estudiante"; // Crear plantilla 'crear_estudiante.html'
    }

    @PostMapping
    public String crearEstudiante(@ModelAttribute Estudiante estudiante) {
        estudianteService.crearEstudiante(estudiante);
        return "redirect:/estudiantes";
    }

    @GetMapping("/{id}")
    public String verEstudiante(@PathVariable String id, Model model) {
        Estudiante estudiante = estudianteService.obtenerPorId(id);
        model.addAttribute("estudiante", estudiante);
        return "ver_estudiante"; // Crear plantilla 'ver_estudiante.html'
    }

    @PostMapping("/{id}/eliminar")
    public String eliminarEstudiante(@PathVariable String id) {
        estudianteService.eliminar(id);
        return "redirect:/estudiantes";
    }
}
