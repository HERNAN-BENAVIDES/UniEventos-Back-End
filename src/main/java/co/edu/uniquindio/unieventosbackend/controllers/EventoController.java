package co.edu.uniquindio.unieventosbackend.controllers;

import co.edu.uniquindio.unieventosbackend.dto.evento.CrearEventoDTO;
import co.edu.uniquindio.unieventosbackend.model.documents.Evento;
import co.edu.uniquindio.unieventosbackend.services.EventoService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/unieventos/eventos")
public class EventoController {

     @Autowired
     private EventoService eventoService;

     @PostMapping("/crear")
     public ResponseEntity<?> crearEvento(@Validated @RequestBody CrearEventoDTO evento) {
          return ResponseEntity.ok(eventoService.crearEvento(new Evento(evento)));
     }

     @GetMapping("/eventos-disponibles")
     public ResponseEntity<?> obtenerEventosDisponibles() {
          return ResponseEntity.ok(eventoService.obtenerEventosDisponibles());
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
          Evento evento = (Evento) eventoService.eliminarEvento(id);
          if(evento == null){
               return ResponseEntity.badRequest().build();
          }
          return ResponseEntity.ok().build();
     }
}
