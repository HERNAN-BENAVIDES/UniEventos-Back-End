package co.edu.uniquindio.unieventosbackend.services;

import co.edu.uniquindio.unieventosbackend.model.documents.Evento;
import co.edu.uniquindio.unieventosbackend.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EventoService {

     @Autowired
     private EventoRepository eventoRepository;

     public Evento crearEvento(Evento evento) {
          return eventoRepository.save(evento);
     }

     public Page<Evento> obtenerEventosDisponibles(Pageable pageable) {
          return eventoRepository.findAll(pageable);
     }

     public Evento findById(String id) {
          return eventoRepository.findById(id).orElse(null);
     }

     public Evento eliminarEvento(String id) {
          Optional<Evento> evento = eventoRepository.findById(id);
          if (evento.isPresent()){
               evento.get().desactivar();
               eventoRepository.save(evento.get());
               return evento.get();
          }
          return  null;
     }

     public Evento eliminarEvento(Evento evento) {
          evento.desactivar();
          return eventoRepository.save(evento);
     }

     public Evento actualizarEvento(Evento evento) {
          return eventoRepository.save(evento);
     }

     public Evento desactivarEvento(String id) {
          Optional<Evento> evento = eventoRepository.findById(id);
          if (evento.isPresent()){
               evento.get().desactivar();
               eventoRepository.save(evento.get());
               return evento.get();
          }
          return  null;
     }

     public Evento activarEvento(String id) {
          Optional<Evento> evento = eventoRepository.findById(id);
          if (evento.isPresent()){
               evento.get().setIsActivo(true);
               eventoRepository.save(evento.get());
               return evento.get();
          }
          return  null;
     }

     public List<Evento> obtenerEventos() {
          return eventoRepository.findAll();
     }

     public List<Evento> obtenerEventosPorNombre(String nombre) {
          return eventoRepository.findByNombreContaining(nombre);
     }

     public List<Evento> obtenerEventosPorFecha(Date fecha) {
          return eventoRepository.findByFechaGreaterThanEqual(fecha);
     }
     public List<Evento> obtenerEventosPorFechaYNombre(Date fecha, String nombre) {
          return eventoRepository.findByFechaGreaterThanEqualAndNombreContaining(fecha, nombre);
     }

     public List<Evento> obtenerEventosPorNombreYFecha(String nombre, Date fecha) {
          return eventoRepository.findByNombreContainingAndFechaGreaterThanEqual(nombre, fecha);
     }

     public List<Evento> obtenerEventosPorCiudad(String ciudad) {
          return eventoRepository.findByDireccionCiudad(ciudad);
     }

}
