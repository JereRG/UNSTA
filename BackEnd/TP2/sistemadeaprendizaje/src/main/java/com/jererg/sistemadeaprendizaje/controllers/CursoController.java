package com.jererg.sistemadeaprendizaje.controllers;

import com.jererg.sistemadeaprendizaje.models.Curso;
import com.jererg.sistemadeaprendizaje.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public String listarCursos(Model model) {
        List<Curso> cursos = cursoService.listarTodos();
        model.addAttribute("cursos", cursos);
        return "index"; // Asegúrate de tener una plantilla 'index.html' en templates
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("curso", new Curso());
        return "crear_curso"; // Crear plantilla 'crear_curso.html'
    }

    @PostMapping
    public String crearCurso(@ModelAttribute Curso curso) {
        cursoService.crearCurso(curso);
        return "redirect:/cursos";
    }

    @GetMapping("/{id}")
    public String verCurso(@PathVariable String id, Model model) {
        Curso curso = cursoService.obtenerPorId(id);
        model.addAttribute("curso", curso);
        return "ver_curso"; // Crear plantilla 'ver_curso.html'
    }

    @PostMapping("/{id}/eliminar")
    public String eliminarCurso(@PathVariable String id) {
        cursoService.eliminar(id);
        return "redirect:/cursos";
    }
}
