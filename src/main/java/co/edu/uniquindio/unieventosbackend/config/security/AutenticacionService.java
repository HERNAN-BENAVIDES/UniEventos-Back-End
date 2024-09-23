//package co.edu.uniquindio.unieventosbackend.config.security;

//import co.edu.uniquindio.unieventosbackend.model.documents.Usuario;
//import co.edu.uniquindio.unieventosbackend.repositories.UsuarioRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Collection;
//import java.util.List;
//
//@Service
//public class AutenticacionService implements UserDetailsService {
//
//     @Autowired
//     private UsuarioRepository usuarioRepository;
//
//     @Override
//     public UserDetails loadUserByUsername(String correoElectronico) throws UsernameNotFoundException {
//          Usuario usuario = usuarioRepository.findByCorreoElectronico(correoElectronico)
//                  .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + correoElectronico));
//
//          return new User(
//                  usuario.getCorreoElectronico(),
//                  usuario.getContrasenia(), // Usa el hash aquí para que la contraseña no sea visible
//                  getAuthorities(usuario)
//          );
//     }
//
//     private Collection<? extends GrantedAuthority> getAuthorities(Usuario usuario) {
//          return List.of(new SimpleGrantedAuthority(usuario.getRol().name()));
//     }
//}
