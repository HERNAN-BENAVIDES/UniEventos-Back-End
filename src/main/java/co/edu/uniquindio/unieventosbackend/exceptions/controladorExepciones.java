package co.edu.uniquindio.unieventosbackend.exceptions;

import co.edu.uniquindio.unieventosbackend.dto.respuesta.RespuestaDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class controladorExepciones {

     @ExceptionHandler(MethodArgumentNotValidException.class)
     public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
          return ResponseEntity.badRequest().body("Validación fallida: " + ex.getBindingResult().getAllErrors());
     }



     @ExceptionHandler(UsuarioExistenteException.class)
     public ResponseEntity<RespuestaDto> usuarioExistente(UsuarioExistenteException e) {
          return ResponseEntity.badRequest().body(new RespuestaDto(e.getMessage(), true));
     }


}
