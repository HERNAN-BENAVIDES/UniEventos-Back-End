package co.edu.uniquindio.unieventosbackend.services;

import co.edu.uniquindio.unieventosbackend.exceptions.UsuarioExistenteException;
import co.edu.uniquindio.unieventosbackend.model.documents.Cliente;
import co.edu.uniquindio.unieventosbackend.model.documents.Usuario;
import co.edu.uniquindio.unieventosbackend.repositories.ClienteRepository;
import co.edu.uniquindio.unieventosbackend.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

     @Autowired
     private ClienteRepository clienteRepository;

     @Autowired
     private UsuarioService usuarioService;
     @Autowired
     private UsuarioRepository usuarioRepository;


     public Cliente crearUsuario(Cliente cliente) throws UsuarioExistenteException {
          Usuario usuario = cliente.getUsuario();
          Boolean user = usuarioService.findByUsuario(usuario);
          if (user) {
               System.out.println("El usuario ya existe");
               throw new UsuarioExistenteException("El usuario ya existe");
          }
          usuarioRepository.save(usuario);
          return clienteRepository.save(cliente);
     }
}
