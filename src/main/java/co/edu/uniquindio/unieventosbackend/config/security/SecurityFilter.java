//package co.edu.uniquindio.unieventosbackend.config.security;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//import java.io.IOException;
//@Component
//public class SecurityFilter extends OncePerRequestFilter {
//
//     @Autowired
//     private TokenService tokenService;
//     @Autowired
//     private UserDetailsService userDetailsService;
//
//     @Override
//     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//          String token = request.getHeader("Authorization");
//          if (token != null && token.startsWith("Bearer ")) {
//               token = token.substring(7);
//               String username = tokenService.getSubjectFromToken(token);
//               if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//                    UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//                    if (userDetails != null) {
//                         UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                         SecurityContextHolder.getContext().setAuthentication(authentication);
//                    }
//               }
//          }
//          filterChain.doFilter(request, response);
//     }
//}