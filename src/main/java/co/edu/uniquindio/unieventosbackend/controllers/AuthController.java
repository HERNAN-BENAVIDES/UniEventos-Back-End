package co.edu.uniquindio.unieventosbackend.controllers;

import co.edu.uniquindio.unieventosbackend.config.security.JwtUtil;
import co.edu.uniquindio.unieventosbackend.dto.cliente.ClienteRegistroDto;
import co.edu.uniquindio.unieventosbackend.dto.respuesta.RespuestaDto;
import co.edu.uniquindio.unieventosbackend.dto.usuario.UsuarioAutenticacionDto;
import co.edu.uniquindio.unieventosbackend.dto.jwt.JWTDto;
import co.edu.uniquindio.unieventosbackend.exceptions.UsuarioExistenteException;
import co.edu.uniquindio.unieventosbackend.model.documents.Cliente;
import co.edu.uniquindio.unieventosbackend.services.ClienteService;
import co.edu.uniquindio.unieventosbackend.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import co.edu.uniquindio.unieventosbackend.services.TokenService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/uni-eventos/auth")
public class AuthController {

     private final AuthenticationManager authenticationManager;
     private final CustomUserDetailsService userDetailsService;
     private final JwtUtil jwtUtil;
     private final TokenService tokenService;

     @Autowired
     private ClienteService clienteService;

     @Autowired
     public AuthController(AuthenticationManager authenticationManager,
                           CustomUserDetailsService userDetailsService,
                           JwtUtil jwtUtil, TokenService tokenService) {
          this.authenticationManager = authenticationManager;
          this.userDetailsService = userDetailsService;
          this.jwtUtil = jwtUtil;
          this.tokenService = tokenService;
     }

     @PostMapping("/login")
     public ResponseEntity<?> login(@RequestBody UsuarioAutenticacionDto request) {
          try {
               // Autenticación del usuario
               authenticationManager.authenticate(
                       new UsernamePasswordAuthenticationToken(request.username(), request.password())
               );

               // Generar el token
               final String jwt = jwtUtil.generateToken(userDetailsService.loadUserByUsername(request.username()));
               return ResponseEntity.ok(new JWTDto(jwt));
          } catch (BadCredentialsException e) {
               return ResponseEntity.status(HttpStatus.FORBIDDEN)
                       .body("Credenciales incorrectas. Por favor, verifica e intenta nuevamente.");
          } catch (Exception e) {
               return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                       .body("Ocurrió un error inesperado. Intenta más tarde.\n" + e.getMessage());
          }
     }

     @PostMapping("/logout")
     public ResponseEntity<RespuestaDto> logout(@RequestHeader("Authorization") String token) {
          String jwtToken = token.substring(7);
          tokenService.invalidateToken(jwtToken);
          return ResponseEntity.ok(new RespuestaDto("Sesión cerrada)", true));
     }

     @PostMapping("register")
     public ResponseEntity<?> register(@RequestBody ClienteRegistroDto request) throws UsuarioExistenteException {
          return ResponseEntity.ok(clienteService.crearUsuario(new Cliente(request)));
     }

}
