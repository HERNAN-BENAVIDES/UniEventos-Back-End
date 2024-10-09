package co.edu.uniquindio.unieventosbackend.controllers;

import co.edu.uniquindio.unieventosbackend.dto.cliente.ClienteRegistroDto;
import co.edu.uniquindio.unieventosbackend.dto.respuesta.RespuestaDto;
import co.edu.uniquindio.unieventosbackend.exceptions.UsuarioExistenteException;
import co.edu.uniquindio.unieventosbackend.model.documents.Cliente;
import co.edu.uniquindio.unieventosbackend.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/uni-eventos/cliente")
public class ClienteController {

     @Autowired
     private ClienteService clienteService;

     @PostMapping("/crear")
     public ResponseEntity<RespuestaDto> crearUsuario(@Validated @RequestBody ClienteRegistroDto clienteRegistroDto) throws UsuarioExistenteException {
          Cliente cliente = clienteService.crearUsuario(new Cliente(clienteRegistroDto));
          return ResponseEntity.ok(new RespuestaDto("Cliente creado \n" + cliente.toString(), false));
     }

     @GetMapping("/cuenta")
     public ResponseEntity<RespuestaDto> prueba() {
          return ResponseEntity.ok(new RespuestaDto("Prueba", false));
     }
}
