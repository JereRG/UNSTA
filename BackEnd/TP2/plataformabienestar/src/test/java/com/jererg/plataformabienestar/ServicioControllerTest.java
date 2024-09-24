package com.jererg.plataformabienestar;

import com.jererg.plataformabienestar.models.Servicio;
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
public class ServicioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCrearServicio() throws Exception {
        Servicio servicio = new Servicio();
        servicio.setTipo("Meditación");
        servicio.setDuracion("60 minutos");
        servicio.setInstructorId("123");

        mockMvc.perform(post("/api/servicios")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(servicio)))
                .andExpect(status().isCreated());
    }
}
