package com.jererg.plataformabienestar;

import com.jererg.plataformabienestar.models.Miembro;
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
public class MiembroControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCrearMiembro() throws Exception {
        Miembro miembro = new Miembro();
        miembro.setNombre("Juan");
        miembro.setApellido("Perez");
        miembro.setEmail("juan.perez@example.com");

        mockMvc.perform(post("/api/miembros")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(miembro)))
                .andExpect(status().isCreated());
    }
}
