package com.jererg.plataformabienestar;

import com.jererg.plataformabienestar.models.Instructor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class InstructorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCrearInstructor() throws Exception {
        Instructor instructor = new Instructor();
        instructor.setNombre("Ana");
        instructor.setEspecialidad("Yoga");

        mockMvc.perform(post("/api/instructores")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(instructor)))
                .andExpect(status().isCreated());
    }
}
