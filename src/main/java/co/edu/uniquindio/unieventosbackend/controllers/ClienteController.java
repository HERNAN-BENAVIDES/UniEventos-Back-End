package co.edu.uniquindio.unieventosbackend.controllers;

import co.edu.uniquindio.unieventosbackend.dto.cliente.ClienteRegistroDto;
import co.edu.uniquindio.unieventosbackend.dto.respuesta.RespuestaDto;
import co.edu.uniquindio.unieventosbackend.dto.cuenta.LoginDTO;
import co.edu.uniquindio.unieventosbackend.exceptions.UsuarioExistenteException;
import co.edu.uniquindio.unieventosbackend.model.documents.Cliente;
import co.edu.uniquindio.unieventosbackend.model.documents.Usuario;
import co.edu.uniquindio.unieventosbackend.repositories.ClienteRepository;
import co.edu.uniquindio.unieventosbackend.services.ClienteService;
import co.edu.uniquindio.unieventosbackend.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

     @Autowired
     private UsuarioService usuarioService;

     @Autowired
     private ClienteService clienteService;

     @PostMapping("/crear")
     public ResponseEntity<RespuestaDto> crearUsuario(@Validated @RequestBody ClienteRegistroDto clienteRegistroDto) throws UsuarioExistenteException {
          Cliente cliente = clienteService.crearUsuario(new Cliente(clienteRegistroDto));
          return ResponseEntity.ok(new RespuestaDto("Cliente creado \n" + cliente.toString(), false));
     }

     @GetMapping("/cuenta")
     public ResponseEntity<RespuestaDto> prueba() {
          return ResponseEntity.ok(new RespuestaDto("Prueba", false));
     }

//------------------------------------ MÉTODOS AGREGADOS -----------------------------------

     // 1. Endpoint de login
     @PostMapping("/login")
     public ResponseEntity<?> login(@RequestBody LoginDTO loginDto) {
          try {
               // Autenticación del usuario
               Usuario usuario = usuarioService.autenticarUsuario(loginDto.username(), loginDto.password());

               // Obtener cliente asociado al usuario
               Cliente cliente = clienteService.getClienteByIdUser(usuario.getId());

               // Retornar información del cliente (incluyendo el carrito)
               return ResponseEntity.ok(cliente);
          } catch (NoSuchElementException e) {
               return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario o cliente no encontrado");
          }
     }

     // 2. Agregar Producto al Carrito
     @PostMapping("/{clienteId}/carrito")
     public ResponseEntity<Cliente> agregarProductoCarrito(
             @PathVariable String clienteId,
             @RequestParam String eventoId,
             @RequestParam String localidadId,
             @RequestParam int cantidad) {

          try {
               // Llama al servicio para agregar el producto al carrito
               Cliente clienteActualizado = clienteService.agregarProductoCarrito(clienteId, eventoId, localidadId, cantidad);
               return ResponseEntity.ok(clienteActualizado);
          } catch (NoSuchElementException e) {
               return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
          } catch (IllegalArgumentException e) {
               return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
          } catch (Exception e) {
               return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
          }
     }

     // 3. Ver Historial de Compras
     @GetMapping("/{clienteId}/compras")
     public ResponseEntity<?> obtenerHistorialCompras(@PathVariable String clienteId) {
          try {
               List<String> historialCompras = clienteService.obtenerHistorialCompras(clienteId);
               return ResponseEntity.ok(historialCompras);
          } catch (NoSuchElementException e) {
               return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
          }
     }

     // 4. Pagar Carrito
     @PostMapping("/{clienteId}/carrito/pagar")
     public ResponseEntity<?> pagarCarrito(@PathVariable String clienteId) {
          try {
                    String resultado = clienteService.pagarCarrito(clienteId);
               return ResponseEntity.ok(resultado);
          } catch (NoSuchElementException e) {
               return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
          }
     }

     // 5. Editar Datos del Cliente
     @PutMapping("/{clienteId}")
     public ResponseEntity<?> editarDatosCliente(@PathVariable String clienteId, @RequestBody Cliente datosActualizados) {
          try {
               Cliente clienteActualizado = clienteService.editarDatos(clienteId, datosActualizados);
               return ResponseEntity.ok(clienteActualizado);
          } catch (NoSuchElementException e) {
               return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
          }
     }

     // 6. Borrar Producto del Carrito
     @DeleteMapping("/{clienteId}/carrito/eliminar")
     public ResponseEntity<?> borrarProductoCarrito(@PathVariable String clienteId, @RequestParam String productoId) {
          try {
               Cliente cliente = clienteService.borrarProductoCarrito(clienteId, productoId);
               return ResponseEntity.ok(cliente.getCarrito());
          } catch (NoSuchElementException e) {
               return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
          }
     }

     // 7. Deshabilitar Cuenta
     @PostMapping("/{clienteId}/deshabilitar")
     public ResponseEntity<?> deshabilitarCuenta(@PathVariable String clienteId) {
          try {
               Cliente cliente = clienteService.deshabilitarCuenta(clienteId);
               return ResponseEntity.ok("Cuenta deshabilitada");
          } catch (NoSuchElementException e) {
               return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
          }
     }

}
