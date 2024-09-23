//package co.edu.uniquindio.unieventosbackend.config.security;
//
//import com.auth0.jwt.JWT;
//import co.edu.uniquindio.unieventosbackend.model.documents.Usuario;
//import com.auth0.jwt.exceptions.JWTCreationException;
//import com.auth0.jwt.exceptions.JWTVerificationException;
//import com.auth0.jwt.algorithms.Algorithm;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import java.time.Instant;
//import java.time.temporal.ChronoUnit;
//import java.util.Date;
//
//@Service
//public class TokenService {
//     @Value("${api.security.token.secret}")
//     private String secretKey;
//
//     public String generarToken(Usuario usuario) {
//          try {
//               Algorithm algorithm = Algorithm.HMAC256(secretKey);
//               Instant now = Instant.now();
//               Instant expiresAt = now.plus(2, ChronoUnit.HOURS);
//               return JWT.create()
//                       .withIssuer("UniEventos")
//                       .withSubject(usuario.getCorreoElectronico())
//                       .withClaim("id", usuario.getId())
//                       .withExpiresAt(Date.from(expiresAt))
//                       .sign(algorithm);
//          } catch (JWTCreationException exception) {
//               throw new RuntimeException("Error al generar el JWT", exception);
//          }
//     }
//
//     public String getSubjectFromToken(String token) {
//          try {
//               Algorithm algorithm = Algorithm.HMAC256(secretKey);
//               return JWT.require(algorithm)
//                       .withIssuer("UniEventos")
//                       .build()
//                       .verify(token)
//                       .getSubject();
//          } catch (JWTVerificationException exception) {
//               throw new RuntimeException("Token JWT inválido", exception);
//          }
//     }
//}