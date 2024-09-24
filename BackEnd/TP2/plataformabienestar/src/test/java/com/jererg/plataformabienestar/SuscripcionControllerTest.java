package com.jererg.plataformabienestar;

import com.jererg.plataformabienestar.models.Suscripcion;
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
public class SuscripcionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCrearSuscripcion() throws Exception {
        Suscripcion suscripcion = new Suscripcion();
        suscripcion.setMiembroId("123");
        suscripcion.setTipo("Mensual");
        suscripcion.setEstado("Activa");

        mockMvc.perform(post("/api/suscripciones")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(suscripcion)))
                .andExpect(status().isCreated());
    }
}
