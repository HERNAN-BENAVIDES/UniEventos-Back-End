package co.edu.uniquindio.unieventosbackend.controllers;

import co.edu.uniquindio.unieventosbackend.dto.evento.EventoGetDTO;
import co.edu.uniquindio.unieventosbackend.dto.evento.EventoListarDTO;
import co.edu.uniquindio.unieventosbackend.dto.evento.CrearEventoDTO;
import co.edu.uniquindio.unieventosbackend.dto.evento.FiltroEventosDTO;
import co.edu.uniquindio.unieventosbackend.exceptions.EventoException;
import co.edu.uniquindio.unieventosbackend.exceptions.EventoNotFoundException;
import co.edu.uniquindio.unieventosbackend.exceptions.FormatoFechaNoValido;
import co.edu.uniquindio.unieventosbackend.model.documents.Evento;
import co.edu.uniquindio.unieventosbackend.model.enums.TipoEvento;
import co.edu.uniquindio.unieventosbackend.services.EventoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;


@RestController
@RequestMapping("/uni-eventos")
public class EventoController {

     @Autowired
     private EventoService eventoService;


     @GetMapping("/eventos")
     public ResponseEntity<Page<EventoListarDTO>> obtenerEventosDisponibles(@PageableDefault(size =5) Pageable pageable, @RequestBody FiltroEventosDTO filtro) throws EventoNotFoundException, FormatoFechaNoValido {
          Page<Evento> eventos = eventoService.obtenerEventosDisponibles(pageable, filtro);
          Page<EventoListarDTO> eventosDTO = eventos.map(EventoListarDTO::new);
          return ResponseEntity.ok(eventosDTO);     }



     @GetMapping("/eventos/{id}")
     public ResponseEntity<?> obtenerEventoDisponible(@PathVariable String id) throws EventoNotFoundException {
          Optional<Evento> evento = Optional.ofNullable(eventoService.findById(id));
          if (evento.isEmpty()) {
               return ResponseEntity.notFound().build();
          }
          return ResponseEntity.ok(new EventoGetDTO(evento.get()));
     }



     @PostMapping("/eventos/crear")
     @PreAuthorize("hasRole('ADMINISTRADOR')")
     public ResponseEntity<?> crearEvento(@Valid @RequestBody CrearEventoDTO evento) throws EventoException {
          return ResponseEntity.ok(eventoService.crearEvento(new Evento(evento)));
     }

     @DeleteMapping("/eliminar/{id}")
     @PreAuthorize("hasRole('ADMINISTRADOR')")
     public ResponseEntity<?> eliminarEvento(@PathVariable String id) throws EventoNotFoundException {
          Evento evento = eventoService.eliminarEvento(id);
          if(evento.getIsActivo()){
               return ResponseEntity.badRequest().build();
          }
          return ResponseEntity.ok().build();
     }

     @PostMapping("/eventos/actualizar/{id}")
     @PreAuthorize("hasRole('ADMINISTRADOR')")
     public ResponseEntity<?> actualizarEvento(@PathVariable String id, @Valid @RequestBody CrearEventoDTO evento) throws EventoException, EventoNotFoundException {
          return ResponseEntity.ok(eventoService.actualizarEvento(id, new Evento(evento)));
     }

}
