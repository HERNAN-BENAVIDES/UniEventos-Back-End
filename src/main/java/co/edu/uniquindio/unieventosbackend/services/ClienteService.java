package co.edu.uniquindio.unieventosbackend.services;

import co.edu.uniquindio.unieventosbackend.exceptions.UsuarioExistenteException;
import co.edu.uniquindio.unieventosbackend.model.documents.*;
import co.edu.uniquindio.unieventosbackend.model.enums.EstadoCuenta;
import co.edu.uniquindio.unieventosbackend.repositories.ClienteRepository;
import co.edu.uniquindio.unieventosbackend.repositories.EventoRepository;
import co.edu.uniquindio.unieventosbackend.repositories.OrdenCompraRepository;
import co.edu.uniquindio.unieventosbackend.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ClienteService {

     @Autowired
     private ClienteRepository clienteRepository;

     @Autowired
     private UsuarioService usuarioService;

     @Autowired
     private EventoRepository eventoRepository;

     @Autowired
     private OrdenCompraRepository ordenCompraRepository;

     @Autowired
     private UsuarioRepository usuarioRepository;

     ;
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

     public List<String> obtenerHistorialCompras(String clienteId) {
          // Busca al cliente por ID
          Cliente cliente = clienteRepository.findById(clienteId)
                  .orElseThrow(() -> new NoSuchElementException("Cliente no encontrado"));

          // Retorna el historial de compras (IDs de las órdenes)
          return cliente.getIdOrdenesCompra();
     }

     public String pagarCarrito(String clienteId) {
          // Busca al cliente por ID
          Cliente cliente = clienteRepository.findById(clienteId)
                  .orElseThrow(() -> new NoSuchElementException("Cliente no encontrado"));

          // Obtiene el carrito del cliente
          Carrito carrito = cliente.getCarrito();

          // Verifica que el carrito no esté vacío
          if (carrito.getListaItems().isEmpty()) {
               throw new IllegalArgumentException("El carrito está vacío");
          }

          // Crea un nuevo código para la orden (puedes usar una lógica más compleja si es necesario)
          String codigoOrden = "ORD-" + System.currentTimeMillis();

          // Crea la nueva orden de compra
          OrdenCompra ordenCompra = OrdenCompra.builder()
                  .codigo(codigoOrden)
                  .idUsuario(clienteId)
                  .listaItems(carrito.getListaItems())
                  .build();

          // Guarda la nueva orden de compra en la base de datos
          ordenCompraRepository.save(ordenCompra);

          // Actualiza el historial de compras del cliente
          cliente.getIdOrdenesCompra().add(ordenCompra.getId());
          clienteRepository.save(cliente);

          // Vacía el carrito del cliente
          carrito.getListaItems().clear();
          carrito.calcularTotal();

          return "Pago procesado correctamente. Código de orden: " + codigoOrden;
     }

     private String processPayment(Double total) {
          // Lógica de integración con la pasarela de pago (mock)
          return "TRANS123456"; // Retorno simulado de un ID de transacción
     }

     private String registrarOrdenCompra(Cliente cliente) {
          // Aquí se generaría la lógica para registrar la orden de compra y
          // actualizar la lista de idOrdenesCompra del cliente.
          String ordenCompraId = "ORDEN" + System.currentTimeMillis(); // Generación de ID simple
          cliente.getIdOrdenesCompra().add(ordenCompraId);
          // Se asume que también hay una entidad de Orden de Compra que se guardaría
          return ordenCompraId;
     }

     public Cliente editarDatos(String clienteId, Cliente datosActualizados) {
          // Busca al cliente por ID
          Cliente cliente = clienteRepository.findById(clienteId)
                  .orElseThrow(() -> new NoSuchElementException("Cliente no encontrado"));

          // Actualiza los datos del cliente
          if (datosActualizados.getCedula() != null) {
               cliente.setCedula(datosActualizados.getCedula());
          }
          if (datosActualizados.getNombre() != null) {
               cliente.setNombre(datosActualizados.getNombre());
          }
          if (datosActualizados.getApellido() != null) {
               cliente.setApellido(datosActualizados.getApellido());
          }
          if (datosActualizados.getTelefono() != null) {
               cliente.setTelefono(datosActualizados.getTelefono());
          }

          // Guarda el cliente actualizado en la base de datos
          return clienteRepository.save(cliente);
     }

     public Cliente borrarProductoCarrito(String clienteId, String productoId) {
          // Busca al cliente por ID
          Cliente cliente = clienteRepository.findById(clienteId)
                  .orElseThrow(() -> new NoSuchElementException("Cliente no encontrado"));

          // Busca el item a eliminar por ID
          Item itemABorrar = cliente.getCarrito().getListaItems().stream()
                  .filter(item -> item.getIdEvento().equals(productoId))
                  .findFirst()
                  .orElseThrow(() -> new NoSuchElementException("Producto no encontrado en el carrito"));

          // Actualiza la localidad correspondiente
          Localidad localidad = itemABorrar.getLocalidad();
          localidad.setCantidadOcupada(localidad.getCantidadOcupada() - itemABorrar.getUnidades());
          localidad.setCantidadDisponible(localidad.getCantidadDisponible() + itemABorrar.getUnidades());

          // Elimina el item del carrito
          cliente.getCarrito().getListaItems().remove(itemABorrar);

          // Calcula el nuevo total del carrito
          cliente.getCarrito().calcularTotal();

          // Guarda el cliente actualizado en la base de datos
          return clienteRepository.save(cliente);
     }


     public Cliente deshabilitarCuenta(String clienteId) {
          // Busca al cliente por ID
          Cliente cliente = clienteRepository.findById(clienteId)
                  .orElseThrow(() -> new NoSuchElementException("Cliente no encontrado"));

          // Deshabilitar la cuenta del usuario
          Usuario usuario = cliente.getUsuario(); // Obtiene el usuario asociado al cliente
          usuario.setEstadoCuenta(EstadoCuenta.INACTIVA); // Cambia el estado de la cuenta

          // Guarda el usuario actualizado en la base de datos
          usuarioRepository.save(usuario); // Asegúrate de tener un repositorio para Usuario

          return cliente; // Retorna el cliente, aunque puedes devolver un mensaje si lo prefieres
     }

}
