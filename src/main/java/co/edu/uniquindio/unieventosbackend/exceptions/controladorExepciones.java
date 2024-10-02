package co.edu.uniquindio.unieventosbackend.exceptions;

import co.edu.uniquindio.unieventosbackend.dto.respuesta.RespuestaDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;

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

     @ExceptionHandler(AccessDeniedException.class)
     public ResponseEntity<RespuestaDto> handleAccessDeniedException(AccessDeniedException ex) {
          return ResponseEntity.status(HttpStatus.FORBIDDEN)
                  .body(new RespuestaDto("No tienes permiso para realizar esta acción.", true));
     }

     @ExceptionHandler(EventoException.class)
     public ResponseEntity<RespuestaDto> eventoException(EventoException e) {
          return ResponseEntity.badRequest().body(new RespuestaDto(e.getMessage(), true));
     }

     @ExceptionHandler(EventoNotFoundException.class)
     public ResponseEntity<RespuestaDto> eventoNotFoundException(EventoNotFoundException e) {
          return ResponseEntity.badRequest().body(new RespuestaDto(e.getMessage(), true));
     }

     @ExceptionHandler(FormatoFechaNoValido.class)
     public ResponseEntity<RespuestaDto> formatoFechaNoValido(FormatoFechaNoValido e) {
          return ResponseEntity.badRequest().body(new RespuestaDto(e.getMessage(), true));
     }

     @ExceptionHandler(ClienteNotFound.class)
     public ResponseEntity<RespuestaDto> clienteNotFound(ClienteNotFound e) {
          return ResponseEntity.badRequest().body(new RespuestaDto(e.getMessage(), true));
     }

     @ExceptionHandler(AdministradorNotFound.class)
     public ResponseEntity<RespuestaDto> administradorNotFound(AdministradorNotFound e) {
          return ResponseEntity.badRequest().body(new RespuestaDto(e.getMessage(), true));
     }

}
