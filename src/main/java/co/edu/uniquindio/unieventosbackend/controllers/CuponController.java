package co.edu.uniquindio.unieventosbackend.controllers;

import co.edu.uniquindio.unieventosbackend.dto.cupon.CrearCuponDto;
import co.edu.uniquindio.unieventosbackend.exceptions.CuponExistenteException;
import co.edu.uniquindio.unieventosbackend.model.documents.Cupon;
import co.edu.uniquindio.unieventosbackend.services.CuponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/uni-eventos/cupones")
public class CuponController {

     @Autowired
     private CuponService cuponService;

     @PostMapping("/crear")
     @PreAuthorize("hasRole('ADMINISTRADOR')")
     public ResponseEntity<?> crearCupon(@RequestBody @Validated CrearCuponDto cupon) throws CuponExistenteException {
          return ResponseEntity.ok(cuponService.crearCupon(new Cupon(cupon)));
     }


}
