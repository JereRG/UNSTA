package com.jererg.sistemadeaprendizaje;

import com.jererg.sistemadeaprendizaje.models.Curso;
import com.jererg.sistemadeaprendizaje.repositories.CursoRepository;
import com.jererg.sistemadeaprendizaje.services.CursoService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CursoServiceTest {

    @Mock
    private CursoRepository cursoRepository;

    @InjectMocks
    private CursoService cursoService;

    @Test
    public void testListarTodos() {
        Curso curso1 = new Curso();
        curso1.setNombre("Curso 1");

        Curso curso2 = new Curso();
        curso2.setNombre("Curso 2");

        when(cursoRepository.findAll()).thenReturn(Arrays.asList(curso1, curso2));

        List<Curso> cursos = cursoService.listarTodos();
        assertEquals(2, cursos.size());
    }
}
