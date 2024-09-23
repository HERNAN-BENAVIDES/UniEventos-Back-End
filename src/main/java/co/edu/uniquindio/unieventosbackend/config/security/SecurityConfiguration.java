//package co.edu.uniquindio.unieventosbackend.config.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration {
//
//     @Autowired
//     private SecurityFilter securityFilter;
//
//     @Autowired
//     private UserDetailsService userDetailsService;
//
//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//          http
//                  .csrf(csrf -> csrf.disable())
//                  .sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                  .authorizeHttpRequests(authorize -> authorize
//                          .requestMatchers("/unieventos/login").permitAll()  // Permitir acceso sin autenticación al endpoint de login
//                          .anyRequest().authenticated()           // Requerir autenticación para cualquier otro endpoint
//                  )
//                  .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);
//          return http.build();
//     }
//
//     @Bean
//     public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
//          return configuration.getAuthenticationManager();
//     }
//
//     @Bean
//     public PasswordEncoder passwordEncoder() {
//          return new BCryptPasswordEncoder();
//     }
//}