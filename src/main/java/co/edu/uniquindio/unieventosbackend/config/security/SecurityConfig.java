package co.edu.uniquindio.unieventosbackend.config.security;

import co.edu.uniquindio.unieventosbackend.services.CustomUserDetailsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

     private final JwtRequestFilter jwtRequestFilter;
     private final CustomUserDetailsService userDetailsService;

     @Autowired
     public SecurityConfig(@Lazy JwtRequestFilter jwtRequestFilter, CustomUserDetailsService userDetailsService) {
          this.jwtRequestFilter = jwtRequestFilter;
          this.userDetailsService = userDetailsService;
     }

     @Bean
     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
          http
                  .csrf(AbstractHttpConfigurer::disable)
                  .cors(AbstractHttpConfigurer::disable)
                  .authorizeHttpRequests(auth -> auth
                          .requestMatchers("/uni-eventos/auth/login").permitAll() // Permitir acceso al login
                          .requestMatchers("/uni-eventos/auth/logout").authenticated() // Solo usuarios autenticados pueden cerrar sesión
                          .requestMatchers("/uni-eventos/auth/register").permitAll() // Permitir acceso al registro
                          .requestMatchers("/uni-eventos/eventos/crear").hasRole("ADMINISTRADOR")
                          .requestMatchers("/uni-eventos/eventos/eliminar").hasRole("ADMINISTRADOR")
                          .requestMatchers("/uni-eventos/cupones/crear").hasRole("ADMINISTRADOR")
                          .requestMatchers("/cliente/cuenta/**").authenticated()
                          .anyRequest().permitAll()
                  )
                  .exceptionHandling(ex -> ex
                          .accessDeniedHandler((request, response, accessDeniedException) -> {
                               response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                               response.setContentType("application/json"); // Establecer el tipo de contenido a JSON

                               // Crear un objeto de respuesta
                               Map<String, String> errorResponse = new HashMap<>();
                               errorResponse.put("message", "Acceso denegado: No tienes permiso para realizar esta acción.");

                               // Convertir el objeto a JSON y escribirlo en la respuesta
                               ObjectMapper objectMapper = new ObjectMapper();
                               response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
                               response.getWriter().flush();
                          })
                  )
                  .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

          http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

          return http.build();
     }

     @Bean
     public PasswordEncoder passwordEncoder() {
          return new BCryptPasswordEncoder();
     }

     @Bean
     public AuthenticationManager authManager(HttpSecurity http) throws Exception {
          AuthenticationManagerBuilder authenticationManagerBuilder =
                  http.getSharedObject(AuthenticationManagerBuilder.class);
          authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
          return authenticationManagerBuilder.build();
     }
}
