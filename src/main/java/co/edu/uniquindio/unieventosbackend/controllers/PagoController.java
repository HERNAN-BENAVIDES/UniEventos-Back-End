package co.edu.uniquindio.unieventosbackend.controllers;

import co.edu.uniquindio.unieventosbackend.dto.respuesta.RespuestaDto;
import co.edu.uniquindio.unieventosbackend.services.PagoService;
import com.mercadopago.exceptions.MPException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/uni-eventos/pagos")
public class PagoController {

     @Autowired
     private PagoService pagoService;

     @PostMapping
    public ResponseEntity<?> realizarPago() throws MPException {
          return ResponseEntity.ok(new RespuestaDto(pagoService.realizarPago(), false));
    }

}
