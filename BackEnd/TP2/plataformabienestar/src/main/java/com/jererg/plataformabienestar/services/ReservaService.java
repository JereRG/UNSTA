package com.jererg.plataformabienestar.services;

import com.jererg.plataformabienestar.models.Reserva;
import com.jererg.plataformabienestar.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> listarTodos() {
        return reservaRepository.findAll();
    }

    public Reserva guardar(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public Reserva obtenerPorId(String id) {
        return reservaRepository.findById(id).orElse(null);
    }

    public void eliminar(String id) {
        reservaRepository.deleteById(id);
    }

    public void crearReserva(String servicioId, String fecha, String miembroId) {
        Reserva reserva = new Reserva();
        reserva.setServicioId(servicioId);
        reserva.setFecha(fecha);
        reserva.setMiembroId(miembroId);
        reserva.setEstado("Pendiente");
        reservaRepository.save(reserva);
    }
}
