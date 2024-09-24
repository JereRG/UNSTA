package com.jererg.plataformabienestar;

import com.jererg.plataformabienestar.models.Pago;
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
public class PagoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCrearPago() throws Exception {
        Pago pago = new Pago();
        pago.setMiembroId("123");
        pago.setMonto(100.50);
        pago.setFecha("2024-09-15");
        pago.setMetodo("Tarjeta de Crédito");

        mockMvc.perform(post("/api/pagos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(pago)))
                .andExpect(status().isCreated());
    }
}
