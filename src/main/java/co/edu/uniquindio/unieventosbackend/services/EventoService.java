package co.edu.uniquindio.unieventosbackend.services;

import co.edu.uniquindio.unieventosbackend.model.documents.Evento;
import co.edu.uniquindio.unieventosbackend.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoService {

     @Autowired
     private EventoRepository eventoRepository;

     public Object crearEvento(Evento evento) {
          return eventoRepository.save(evento);
     }
}
