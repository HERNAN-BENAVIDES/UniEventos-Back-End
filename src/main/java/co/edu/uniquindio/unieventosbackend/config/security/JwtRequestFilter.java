package co.edu.uniquindio.unieventosbackend.config.security;

import co.edu.uniquindio.unieventosbackend.services.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import io.jsonwebtoken.ExpiredJwtException;

import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

     private final UserDetailsService userDetailsService;
     private final JwtUtil jwtUtil;
     private TokenService tokenService;

     @Autowired
     public JwtRequestFilter(UserDetailsService userDetailsService, JwtUtil jwtUtil, TokenService tokenService) {
          this.userDetailsService = userDetailsService;
          this.jwtUtil = jwtUtil;
          this.tokenService = tokenService;
     }

     @Override
     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
             throws ServletException, IOException {

          final String authorizationHeader = request.getHeader("Authorization");

          String username = null;
          String jwt = null;

          if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
               jwt = authorizationHeader.substring(7);

               // Verificar si el token es inválido
               if (tokenService.isTokenInvalid(jwt)) {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    response.getWriter().write("Token inválido");
                    return;
               }

               try {
                    username = jwtUtil.extractUsername(jwt);
               } catch (ExpiredJwtException e) {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token expired");
                    return; // Termina el procesamiento si el token ha expirado
               }
          }

          if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
               UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

               if (jwtUtil.validateToken(jwt, userDetails)) {
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    usernamePasswordAuthenticationToken
                            .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
               }
          }
          chain.doFilter(request, response);
     }
}
