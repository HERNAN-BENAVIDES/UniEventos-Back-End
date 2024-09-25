package co.edu.uniquindio.unieventosbackend.controllers;

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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping("/unieventos/eventos")
public class EventoController {

     @Autowired
     private EventoService eventoService;


     @PostMapping("/crear")
     public ResponseEntity<?> crearEvento(@Valid @RequestBody CrearEventoDTO evento) {
          return ResponseEntity.ok(eventoService.crearEvento(new Evento(evento)));
     }

     @GetMapping("/eventos-disponibles")
     public ResponseEntity<Page<EventoListarDTO>> obtenerEventosDisponibles(@PageableDefault(size =5) Pageable pageable) {
          return ResponseEntity.ok(eventoService.obtenerEventosDisponibles(pageable).map(EventoListarDTO::new));
     }

     @GetMapping("/eventos-disponibles/{id}")
     public ResponseEntity<?> obtenerEventoDisponible(@PathVariable String id) {
          Optional<Evento> evento = Optional.ofNullable(eventoService.findById(id));
          if (evento.isEmpty()) {
               return ResponseEntity.notFound().build();
          }
          return ResponseEntity.ok(evento);
     }

     @DeleteMapping("/eliminar/{id}")
     @Transactional
     public ResponseEntity<?> eliminarEvento(@PathVariable String id){
          Evento evento = eventoService.eliminarEvento(id);
          if(evento.getIsActivo()){
               return ResponseEntity.badRequest().build();
          }
          return ResponseEntity.ok().build();
     }
}
