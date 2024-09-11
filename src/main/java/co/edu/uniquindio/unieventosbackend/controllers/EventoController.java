package co.edu.uniquindio.unieventosbackend.controllers;

import co.edu.uniquindio.unieventosbackend.dto.evento.CrearEventoDTO;
import co.edu.uniquindio.unieventosbackend.model.documents.Evento;
import co.edu.uniquindio.unieventosbackend.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/unieventos/eventos")
public class EventoController {

     @Autowired
     private EventoService eventoService;

     @PostMapping("/crear")
     public ResponseEntity<?> crearEvento(@Validated @RequestBody CrearEventoDTO evento) {
          return ResponseEntity.ok(eventoService.crearEvento(new Evento(evento)));
     }

}
