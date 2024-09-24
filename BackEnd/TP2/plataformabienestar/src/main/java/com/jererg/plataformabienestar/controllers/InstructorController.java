package com.jererg.plataformabienestar.controllers;

import com.jererg.plataformabienestar.models.Instructor;
import com.jererg.plataformabienestar.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructores")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @GetMapping
    public List<Instructor> listarInstructores() {
        return instructorService.listarTodos();
    }

    @PostMapping
    public Instructor crearInstructor(@RequestBody Instructor instructor) {
        return instructorService.guardar(instructor);
    }

    @GetMapping("/{id}")
    public Instructor obtenerInstructor(@PathVariable String id) {
        return instructorService.obtenerPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarInstructor(@PathVariable String id) {
        instructorService.eliminar(id);
    }
}
