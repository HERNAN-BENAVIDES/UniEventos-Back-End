package co.edu.uniquindio.unieventosbackend.services;

import co.edu.uniquindio.unieventosbackend.exceptions.ClienteNotFound;
import co.edu.uniquindio.unieventosbackend.exceptions.UsuarioExistenteException;
import co.edu.uniquindio.unieventosbackend.model.documents.Cliente;
import co.edu.uniquindio.unieventosbackend.model.documents.Usuario;
import co.edu.uniquindio.unieventosbackend.repositories.ClienteRepository;
import co.edu.uniquindio.unieventosbackend.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.oauth2.resourceserver.OpaqueTokenDsl;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

     @Autowired
     private ClienteRepository clienteRepository;

     @Autowired
     private UsuarioService usuarioService;



     public Cliente crearUsuario(Cliente cliente) throws UsuarioExistenteException {
          Usuario usuario = cliente.getUsuario();
          Boolean user = usuarioService.findByUsuario(usuario);
          if (user) {
               throw new UsuarioExistenteException("El usuario ya existe");
          }
          usuarioService.saveUsuario(usuario);
          return clienteRepository.save(cliente);
     }

     public Cliente getClienteByIdUser(String username) throws ClienteNotFound {
          Optional<Cliente> cliente = clienteRepository.findByIdUser(username);
          if (cliente.isPresent()){
               return cliente.get();
          }
          throw new ClienteNotFound("Cliente no encontrado");
     }
}
