package com.jererg.sistemadeaprendizaje.controllers;

import com.jererg.sistemadeaprendizaje.models.Instructor;
import com.jererg.sistemadeaprendizaje.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/instructores")
public class InstructorController {
    
    @Autowired
    private InstructorService instructorService;

    @GetMapping
    public String listarInstructores(Model model) {
        List<Instructor> instructores = instructorService.listarTodos();
        model.addAttribute("instructores", instructores);
        return "instructores"; // Crear plantilla 'instructores.html'
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("instructor", new Instructor());
        return "crear_instructor"; // Crear plantilla 'crear_instructor.html'
    }

    @PostMapping
    public String guardarInstructor(@ModelAttribute Instructor instructor) {
        instructorService.guardar(instructor);
        return "redirect:/instructores";
    }

    @GetMapping("/{id}")
    public String verInstructor(@PathVariable String id, Model model) {
        Instructor instructor = instructorService.obtenerPorId(id);
        model.addAttribute("instructor", instructor);
        return "ver_instructor"; // Crear plantilla 'ver_instructor.html'
    }

    @PostMapping("/{id}/eliminar")
    public String eliminarInstructor(@PathVariable String id) {
        instructorService.eliminar(id);
        return "redirect:/instructores";
    }
}
