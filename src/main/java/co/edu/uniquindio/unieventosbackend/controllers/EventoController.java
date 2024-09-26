package co.edu.uniquindio.unieventosbackend.controllers;

import co.edu.uniquindio.unieventosbackend.dto.EventoGetDTO;
import co.edu.uniquindio.unieventosbackend.dto.EventoListarDTO;
import co.edu.uniquindio.unieventosbackend.dto.evento.CrearEventoDTO;
import co.edu.uniquindio.unieventosbackend.model.documents.Evento;
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
     public ResponseEntity<Page<EventoListarDTO>> obtenerEventosDisponibles(@PageableDefault(size =5) Pageable pageable) {
          return ResponseEntity.ok(eventoService.obtenerEventosDisponibles(pageable).map(EventoListarDTO::new));
     }

     @GetMapping("/eventos/{id}")
     public ResponseEntity<?> obtenerEventoDisponible(@PathVariable String id) {
          Optional<Evento> evento = Optional.ofNullable(eventoService.findById(id));
          if (evento.isEmpty()) {
               return ResponseEntity.notFound().build();
          }
          return ResponseEntity.ok(new EventoGetDTO(evento.get()));
     }



     @PostMapping("/eventos/crear")
     @PreAuthorize("hasRole('ADMINISTRADOR')")
     public ResponseEntity<?> crearEvento(@Valid @RequestBody CrearEventoDTO evento) {
          return ResponseEntity.ok(eventoService.crearEvento(new Evento(evento)));
     }

     @DeleteMapping("/eliminar/{id}")
     @PreAuthorize("hasRole('ADMINISTRADOR')")
     public ResponseEntity<?> eliminarEvento(@PathVariable String id){
          Evento evento = eventoService.eliminarEvento(id);
          if(evento.getIsActivo()){
               return ResponseEntity.badRequest().build();
          }
          return ResponseEntity.ok().build();
     }
}
