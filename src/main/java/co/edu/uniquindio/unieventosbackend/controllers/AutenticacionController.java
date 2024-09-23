//package co.edu.uniquindio.unieventosbackend.controllers;
//
//import co.edu.uniquindio.unieventosbackend.config.security.TokenService;
//import co.edu.uniquindio.unieventosbackend.dto.jwt.JWTDto;
//import co.edu.uniquindio.unieventosbackend.dto.usuario.DatosAutenticacionUsuario;
//import co.edu.uniquindio.unieventosbackend.model.documents.Usuario;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/unieventos")
//public class AutenticacionController {
//
//     @Autowired
//     private AuthenticationManager manager;
//
//     @Autowired
//     private TokenService tokenService;
//
//     @PostMapping("/login")
//     public ResponseEntity<?> autenticarUsuario(@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario) {
//          try {
//               Authentication authToken = new UsernamePasswordAuthenticationToken(
//                       datosAutenticacionUsuario.email(),
//                       datosAutenticacionUsuario.password()
//               );
//
//               Authentication usuarioAutenticado = manager.authenticate(authToken);
//               var usuario = (Usuario) usuarioAutenticado.getPrincipal(); // Asegúrate de que esto sea correcto
//
//               String jwtToken = tokenService.generarToken(usuario);
//               return ResponseEntity.ok(new JWTDto(jwtToken));
//          } catch (BadCredentialsException e) {
//               return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
//          }
//     }
//}
//
//
//