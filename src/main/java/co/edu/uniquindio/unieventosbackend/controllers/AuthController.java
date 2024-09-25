package co.edu.uniquindio.unieventosbackend.controllers;

import co.edu.uniquindio.unieventosbackend.config.security.JwtUtil;
import co.edu.uniquindio.unieventosbackend.dto.usuario.UsuarioAutenticacionDto;
import co.edu.uniquindio.unieventosbackend.dto.jwt.JWTDto;
import co.edu.uniquindio.unieventosbackend.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

     private final AuthenticationManager authenticationManager;
     private final CustomUserDetailsService userDetailsService;
     private final JwtUtil jwtUtil;

     @Autowired
     public AuthController(AuthenticationManager authenticationManager,
                           CustomUserDetailsService userDetailsService,
                           JwtUtil jwtUtil) {
          this.authenticationManager = authenticationManager;
          this.userDetailsService = userDetailsService;
          this.jwtUtil = jwtUtil;
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
                       .body("Ocurrió un error inesperado. Intenta más tarde.");
          }
     }
}
