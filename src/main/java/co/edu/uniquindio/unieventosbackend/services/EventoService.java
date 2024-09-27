package co.edu.uniquindio.unieventosbackend.services;

import co.edu.uniquindio.unieventosbackend.dto.evento.FiltroEventosDTO;
import co.edu.uniquindio.unieventosbackend.exceptions.EventoException;
import co.edu.uniquindio.unieventosbackend.exceptions.EventoNotFoundException;
import co.edu.uniquindio.unieventosbackend.model.documents.Evento;
import co.edu.uniquindio.unieventosbackend.model.enums.TipoEvento;
import co.edu.uniquindio.unieventosbackend.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EventoService {

     @Autowired
     private EventoRepository eventoRepository;

     public Evento crearEvento(Evento evento) throws EventoException {
          if (evento == null) {
               throw new EventoException("El evento no puede ser nulo");
          }
          return eventoRepository.save(evento);
     }

     public Page<Evento> obtenerEventosDisponibles(Pageable pageable, FiltroEventosDTO filtro) throws EventoNotFoundException {

          if (filtro.nombre() != null && filtro.ciudad() != null && filtro.tipoEvento() != null && filtro.fecha() != null) {
               return obtenerEventosPorNombreCiudadTipoYFecha(
                       pageable,
                       filtro.nombre(),
                       filtro.ciudad(),
                       TipoEvento.valueOf(filtro.tipoEvento()),
                       new Date(filtro.fecha())
               );
          } else if (filtro.nombre() != null && filtro.ciudad() != null && filtro.tipoEvento() != null) {
               return obtenerEventosPorNombreCiudadYTipo(
                       pageable,
                       filtro.nombre(),
                       filtro.ciudad(),
                       TipoEvento.valueOf(filtro.tipoEvento())
               );
          } else if (filtro.nombre() != null && filtro.ciudad() != null && filtro.fecha() != null) {
               return obtenerEventosPorNombreCiudadYFecha(
                       pageable,
                       filtro.nombre(),
                       filtro.ciudad(),
                       new Date(filtro.fecha())
               );
          } else if (filtro.nombre() != null && filtro.tipoEvento() != null && filtro.fecha() != null) {
               return obtenerEventosPorNombreTipoYFecha(
                       pageable,
                       filtro.nombre(),
                       TipoEvento.valueOf(filtro.tipoEvento()),
                       new Date(filtro.fecha())
               );
          } else if (filtro.ciudad() != null && filtro.tipoEvento() != null && filtro.fecha() != null) {
               return obtenerEventosPorCiudadTipoYFecha(
                       pageable,
                       filtro.ciudad(),
                       TipoEvento.valueOf(filtro.tipoEvento()),
                       new Date(filtro.fecha())
               );
          } else if (filtro.nombre() != null && filtro.ciudad() != null) {
               return obtenerEventosPorNombreYCiudad(
                       pageable,
                       filtro.nombre(),
                       filtro.ciudad()
               );
          } else if (filtro.nombre() != null && filtro.tipoEvento() != null) {
               return obtenerEventosPorNombreYTipo(
                       pageable,
                       filtro.nombre(),
                       TipoEvento.valueOf(filtro.tipoEvento())
               );
          } else if (filtro.nombre() != null && filtro.fecha() != null) {
               return obtenerEventosPorNombreYFecha(
                       pageable,
                       new Date(filtro.fecha()),
                       filtro.nombre()
               );
          } else if (filtro.ciudad() != null && filtro.tipoEvento() != null) {
               return obtenerEventosPorCiudadYTipo(
                       pageable,
                       filtro.ciudad(),
                       TipoEvento.valueOf(filtro.tipoEvento())
               );
          } else if(filtro.ciudad() != null && filtro.fecha() != null) {
               return obtenerEventosPorCiudadYFecha(
                       pageable,
                       filtro.ciudad(),
                       new Date(filtro.fecha())
               );
          } else if (filtro.tipoEvento() != null && filtro.fecha() != null) {
               return obtenerEventosPorTipoYFecha(
                       pageable,
                       TipoEvento.valueOf(filtro.tipoEvento()),
                       new Date(filtro.fecha())
               );
          } else if (filtro.nombre() != null) {
               return obtenerEventosPorNombre(pageable, filtro.nombre());
          } else if (filtro.ciudad() != null) {
               return obtenerEventosPorCiudad(pageable, filtro.ciudad());
          } else if (filtro.tipoEvento() != null) {
               return obtenerEventosPorTipo(pageable, TipoEvento.valueOf(filtro.tipoEvento()));
          } else if (filtro.fecha() != null) {
               return obtenerEventosPorFecha(pageable, new Date(filtro.fecha()));
          }

          // Si no se proporcionan filtros
          return obtenerEventosDisponiblesActivos(pageable); // Por defecto, se muestran todos los eventos activos
     }

     public Page<Evento> obtenerEventosDisponiblesActivos(Pageable pageable) throws EventoNotFoundException {
          return eventoRepository.findByIsActivoTrue(pageable)
                  .orElseThrow(() -> new EventoNotFoundException("No se encontraron eventos"));
     }


     public Evento findById(String id) throws EventoNotFoundException {
          return eventoRepository.findById(id)
                  .orElseThrow(() -> new EventoNotFoundException("Evento no encontrado con ID: " + id));
     }

     public Evento eliminarEvento(String id) throws EventoNotFoundException {
          Evento evento = findById(id);
          evento.desactivar();
          return eventoRepository.save(evento);
     }

     public Evento eliminarEvento(Evento evento) throws EventoException {
          if (evento == null) {
               throw new EventoException("El evento no puede ser nulo");
          }
          evento.desactivar();
          return eventoRepository.save(evento);
     }

     public Evento actualizarEvento(String id, Evento evento) throws EventoException, EventoNotFoundException {
          if (evento == null) {
               throw new EventoException("El evento no puede ser nulo");
          }
          Evento eventoAntiguo = findById(id);

          eventoAntiguo.setNombre(evento.getNombre());
          eventoAntiguo.setDescripcion(evento.getDescripcion());
          eventoAntiguo.setPoster(evento.getPoster());
          eventoAntiguo.setImgLocalidades(evento.getImgLocalidades());
          eventoAntiguo.setFecha(evento.getFecha());
          eventoAntiguo.setDireccion(evento.getDireccion());
          eventoAntiguo.setListaLocalidades(evento.getListaLocalidades());

          return eventoRepository.save(eventoAntiguo);
     }

     public Evento desactivarEvento(String id) throws EventoNotFoundException {
          Evento evento = findById(id);
          evento.desactivar();
          return eventoRepository.save(evento);
     }

     public Evento activarEvento(String id) throws EventoNotFoundException {
          Evento evento = findById(id);
          evento.setIsActivo(true);
          return eventoRepository.save(evento);
     }

     public Page<Evento> obtenerEventosPorNombre(Pageable pageable, String nombre) throws EventoNotFoundException {
          Page<Evento> eventos = eventoRepository.findByNombreContaining(pageable, nombre);
          if (eventos.isEmpty()) {
               throw new EventoNotFoundException("No se encontraron eventos con el nombre: " + nombre);
          }
          return eventos;
     }

     public Page<Evento> obtenerEventosPorFecha(Pageable pageable, Date fecha) throws EventoNotFoundException {
          Page<Evento> eventos = eventoRepository.findByFechaGreaterThanEqual(pageable, fecha);
          if (eventos.isEmpty()) {
               throw new EventoNotFoundException("No se encontraron eventos a partir de la fecha: " + fecha);
          }
          return eventos;
     }


     public Page<Evento> obtenerEventosPorCiudad(Pageable pageable, String ciudad) throws EventoNotFoundException {
          Page<Evento> eventos = eventoRepository.findByDireccionCiudad(pageable, ciudad);
          if (eventos.isEmpty()) {
               throw new EventoNotFoundException("No se encontraron eventos en la ciudad: " + ciudad);
          }
          return eventos;
     }

     public Page<Evento> obtenerEventosPorTipo(Pageable pageable, TipoEvento tipoEvento) throws EventoNotFoundException {
          Page<Evento> eventos = eventoRepository.findByTipoEvento(pageable, tipoEvento);
          if (eventos.isEmpty()) {
               throw new EventoNotFoundException("No se encontraron eventos del tipo: " + tipoEvento);
          }
          return eventos;
     }


     // Métodos adicionales para las combinaciones de filtros

     public Page<Evento> obtenerEventosPorNombreYFecha(Pageable pageable, Date fecha, String nombre) throws EventoNotFoundException {
          Page<Evento> eventos = eventoRepository.findByNombreContainingAndFechaGreaterThanEqual(pageable, nombre, fecha);
          if (eventos.isEmpty()) {
               throw new EventoNotFoundException("No se encontraron eventos con el nombre: " + nombre + " a partir de la fecha: " + fecha);
          }
          return eventos;
     }

     public Page<Evento> obtenerEventosPorNombreYCiudad(Pageable pageable, String nombre, String ciudad) throws EventoNotFoundException {
          Page<Evento> eventos = eventoRepository.findByNombreContainingAndDireccionCiudad(pageable, nombre, ciudad);
          if (eventos.isEmpty()) {
               throw new EventoNotFoundException("No se encontraron eventos con el nombre: " + nombre + " en la ciudad: " + ciudad);
          }
          return eventos;
     }

     public Page<Evento> obtenerEventosPorNombreYTipo(Pageable pageable, String nombre, TipoEvento tipoEvento) throws EventoNotFoundException {
          Page<Evento> eventos = eventoRepository.findByNombreContainingAndTipoEvento(pageable, nombre, tipoEvento);
          if (eventos.isEmpty()) {
               throw new EventoNotFoundException("No se encontraron eventos con el nombre: " + nombre + " del tipo: " + tipoEvento);
          }
          return eventos;
     }

     public Page<Evento> obtenerEventosPorCiudadYTipo(Pageable pageable, String ciudad, TipoEvento tipoEvento) throws EventoNotFoundException {
          Page<Evento> eventos = eventoRepository.findByDireccionCiudadAndTipoEvento(pageable, ciudad, tipoEvento);
          if (eventos.isEmpty()) {
               throw new EventoNotFoundException("No se encontraron eventos en la ciudad: " + ciudad + " del tipo: " + tipoEvento);
          }
          return eventos;
     }

     public Page<Evento> obtenerEventosPorCiudadYFecha(Pageable pageable, String ciudad, Date fecha) throws EventoNotFoundException {
          Page<Evento> eventos = eventoRepository.findByDireccionCiudadAndFechaGreaterThanEqual(pageable, ciudad, fecha);
          if (eventos.isEmpty()) {
               throw new EventoNotFoundException("No se encontraron eventos en la ciudad: " + ciudad + " a partir de la fecha: " + fecha);
          }
          return eventos;
     }

     public Page<Evento> obtenerEventosPorTipoYFecha(Pageable pageable, TipoEvento tipoEvento, Date fecha) throws EventoNotFoundException {
          Page<Evento> eventos = eventoRepository.findByTipoEventoAndFechaGreaterThanEqual(pageable, tipoEvento, fecha);
          if (eventos.isEmpty()) {
               throw new EventoNotFoundException("No se encontraron eventos del tipo: " + tipoEvento + " a partir de la fecha: " + fecha);
          }
          return eventos;
     }

     public Page<Evento> obtenerEventosPorNombreCiudadYTipo(Pageable pageable, String nombre, String ciudad, TipoEvento tipoEvento) throws EventoNotFoundException {
          Page<Evento> eventos = eventoRepository.findByNombreContainingAndDireccionCiudadAndTipoEvento(pageable, nombre, ciudad, tipoEvento);
          if (eventos.isEmpty()) {
               throw new EventoNotFoundException("No se encontraron eventos con el nombre: " + nombre + " en la ciudad: " + ciudad + " del tipo: " + tipoEvento);
          }
          return eventos;
     }

     public Page<Evento> obtenerEventosPorNombreCiudadYFecha(Pageable pageable, String nombre, String ciudad, Date fecha) throws EventoNotFoundException {
          Page<Evento> eventos = eventoRepository.findByNombreContainingAndDireccionCiudadAndFechaGreaterThanEqual(pageable, nombre, ciudad, fecha);
          if (eventos.isEmpty()) {
               throw new EventoNotFoundException("No se encontraron eventos con el nombre: " + nombre + " en la ciudad: " + ciudad + " a partir de la fecha: " + fecha);
          }
          return eventos;
     }

     public Page<Evento> obtenerEventosPorNombreTipoYFecha(Pageable pageable, String nombre, TipoEvento tipoEvento, Date fecha) throws EventoNotFoundException {
          Page<Evento> eventos = eventoRepository.findByNombreContainingAndTipoEventoAndFechaGreaterThanEqual(pageable, nombre, tipoEvento, fecha);
          if (eventos.isEmpty()) {
               throw new EventoNotFoundException("No se encontraron eventos con el nombre: " + nombre + " del tipo: " + tipoEvento + " a partir de la fecha: " + fecha);
          }
          return eventos;
     }

     public Page<Evento> obtenerEventosPorCiudadTipoYFecha(Pageable pageable, String ciudad, TipoEvento tipoEvento, Date fecha) throws EventoNotFoundException {
          Page<Evento> eventos = eventoRepository.findByDireccionCiudadAndTipoEventoAndFechaGreaterThanEqual(pageable, ciudad, tipoEvento, fecha);
          if (eventos.isEmpty()) {
               throw new EventoNotFoundException("No se encontraron eventos en la ciudad: " + ciudad + " del tipo: " + tipoEvento + " a partir de la fecha: " + fecha);
          }
          return eventos;
     }

     public Page<Evento> obtenerEventosPorNombreCiudadTipoYFecha(Pageable pageable, String nombre, String ciudad, TipoEvento tipoEvento, Date fecha) throws EventoNotFoundException {
          Page<Evento> eventos = eventoRepository.findByNombreContainingAndDireccionCiudadAndTipoEventoAndFechaGreaterThanEqual(pageable, nombre, ciudad, tipoEvento, fecha);
          if (eventos.isEmpty()) {
               throw new EventoNotFoundException("No se encontraron eventos con el nombre: " + nombre + " en la ciudad: " + ciudad + " del tipo: " + tipoEvento + " a partir de la fecha: " + fecha);
          }
          return eventos;
     }

}
