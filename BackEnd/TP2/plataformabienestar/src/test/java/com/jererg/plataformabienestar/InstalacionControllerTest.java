package com.jererg.plataformabienestar;

import com.jererg.plataformabienestar.models.Instalacion;
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
public class InstalacionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCrearInstalacion() throws Exception {
        Instalacion instalacion = new Instalacion();
        instalacion.setNombre("Gimnasio");
        instalacion.setTipo("Sala de Ejercicio");
        instalacion.setCapacidad(50);

        mockMvc.perform(post("/api/instalaciones")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(instalacion)))
                .andExpect(status().isCreated());
    }
}
