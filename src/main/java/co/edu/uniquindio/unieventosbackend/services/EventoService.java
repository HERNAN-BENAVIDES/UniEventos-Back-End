package co.edu.uniquindio.unieventosbackend.services;

import co.edu.uniquindio.unieventosbackend.model.documents.Evento;
import co.edu.uniquindio.unieventosbackend.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class EventoService {

     @Autowired
     private EventoRepository eventoRepository;

     public Object crearEvento(Evento evento) {
          return eventoRepository.save(evento);
     }

     public Object obtenerEventosDisponibles() {
          return eventoRepository.findByFechaGreaterThanEqual(new Date());
     }

     public Evento findById(String id) {
          return eventoRepository.findById(id).orElse(null);
     }

     public Object eliminarEvento(String id) {
          Optional<Evento> evento = eventoRepository.findById(id);
          if (evento.isPresent()){
               evento.get().desactivar();
               eventoRepository.save(evento.get());
               return evento.get();
          }
          return  null;
     }
}
