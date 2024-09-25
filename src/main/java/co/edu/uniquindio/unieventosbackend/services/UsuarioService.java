package co.edu.uniquindio.unieventosbackend.services;

import co.edu.uniquindio.unieventosbackend.model.documents.Usuario;
import co.edu.uniquindio.unieventosbackend.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

     @Autowired
     private UsuarioRepository usuarioRepository;


     public Usuario crearUsuario() {
          return null;
     }

     public Boolean findByUsuario(Usuario usuario) {
          return usuarioRepository.findByUsername(usuario.getUsername()) != null;
     }
}
