package co.edu.uniquindio.unieventosbackend.services;

import co.edu.uniquindio.unieventosbackend.model.documents.Usuario;
import co.edu.uniquindio.unieventosbackend.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UsuarioService {

     @Autowired
     private UsuarioRepository usuarioRepository;

     @Autowired
     private PasswordEncoder passwordEncoder;


     public Usuario saveUsuario(Usuario usuario) {
          usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
          return usuarioRepository.save(usuario);
     }

     public Boolean findByUsuario(Usuario usuario) {
          return usuarioRepository.findByUsername(usuario.getUsername()) != null;
     }


     //----------------------------- METODOS AGREGADOS -------------------------------------

     // Método para autenticar un usuario
     public Usuario autenticarUsuario(String username, String password) {
          // Busca al usuario por su nombre de usuario
          Usuario usuario = usuarioRepository.findByUsername(username);

          // Verifica si el usuario fue encontrado
          if (usuario == null) {
               throw new NoSuchElementException("Usuario no encontrado");
          }

          // Verifica si la contraseña es correcta
          if (!usuario.getPassword().equals(password)) {
               throw new IllegalArgumentException("Contraseña incorrecta");
          }

          // Si el usuario existe y la contraseña es correcta, lo retorna
          return usuario;
     }

}
