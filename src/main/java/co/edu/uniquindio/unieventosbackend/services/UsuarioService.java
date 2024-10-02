package co.edu.uniquindio.unieventosbackend.services;

import co.edu.uniquindio.unieventosbackend.exceptions.UsuarioNotFoundException;
import co.edu.uniquindio.unieventosbackend.model.documents.Usuario;
import co.edu.uniquindio.unieventosbackend.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.ByteBuffer;

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

     public Usuario findById(String idUsuario) throws UsuarioNotFoundException {
          Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
          if (usuario != null) {
               return usuario;
          }
          throw new UsuarioNotFoundException("Usuario no encontrado");
     }
}
