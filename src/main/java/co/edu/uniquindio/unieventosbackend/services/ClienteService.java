package co.edu.uniquindio.unieventosbackend.services;

import co.edu.uniquindio.unieventosbackend.exceptions.UsuarioExistenteException;
import co.edu.uniquindio.unieventosbackend.model.documents.*;
import co.edu.uniquindio.unieventosbackend.repositories.ClienteRepository;
import co.edu.uniquindio.unieventosbackend.repositories.EventoRepository;
import co.edu.uniquindio.unieventosbackend.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ClienteService {

     @Autowired
     private ClienteRepository clienteRepository;

     @Autowired
     private UsuarioService usuarioService;

     @Autowired
     private EventoRepository eventoRepository;

     public Cliente crearUsuario(Cliente cliente) throws UsuarioExistenteException {
          Usuario usuario = cliente.getUsuario();
          Boolean user = usuarioService.findByUsuario(usuario);
          if (user) {
               throw new UsuarioExistenteException("El usuario ya existe");
          }
          usuarioService.saveUsuario(usuario);
          return clienteRepository.save(cliente);
     }

     //--------------------------------- METODOS -------------------------------------------

     public Cliente getClienteByIdUser(String usuarioId) {
          // Busca al cliente por el ID del usuario
          return clienteRepository.findByUsuarioId(usuarioId)
                  .orElseThrow(() -> new NoSuchElementException("Cliente no encontrado para el usuario: " + usuarioId));
     }

     public Cliente agregarProductoCarrito(String clienteId, String eventoId, String localidadId, int cantidad) {
          // Busca al cliente por ID
          Cliente cliente = clienteRepository.findById(clienteId)
                  .orElseThrow(() -> new NoSuchElementException("Cliente no encontrado"));

          // Busca el evento por ID
          Evento evento = eventoRepository.findById(eventoId)
                  .orElseThrow(() -> new NoSuchElementException("Evento no encontrado"));

          // Busca la localidad correspondiente dentro de las localidades del evento
          Localidad localidad = evento.getListaLocalidades().stream()
                  .filter(loc -> loc.getNombre().equals(localidadId)) // Cambiado a getNombre
                  .findFirst()
                  .orElseThrow(() -> new NoSuchElementException("Localidad no encontrada"));

          // Verifica que haya suficientes entradas disponibles en la localidad
          if (localidad.getCantidadDisponible() < cantidad) {
               throw new IllegalArgumentException("No hay suficientes entradas disponibles");
          }

          // Crea un nuevo Item para el carrito
          Item nuevoItem = Item.builder()
                  .idEvento(eventoId)
                  .localidad(localidad)
                  .unidades(cantidad)
                  .build();

          // Agrega el nuevo Item a la lista de items del carrito
          cliente.getCarrito().getListaItems().add(nuevoItem);

          // Actualiza la cantidad ocupada y disponible
          localidad.setCantidadOcupada(localidad.getCantidadOcupada() + cantidad);
          localidad.setCantidadDisponible(localidad.getCantidadDisponible() - cantidad);

          // Calcula el nuevo total del carrito
          cliente.getCarrito().calcularTotal();

          // Guarda el cliente actualizado en la base de datos
          clienteRepository.save(cliente);
          // Si deseas también guardar el evento con los cambios en localidad
          eventoRepository.save(evento);

          return cliente;
     }

}
