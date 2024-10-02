package co.edu.uniquindio.unieventosbackend.services;

import co.edu.uniquindio.unieventosbackend.exceptions.UsuarioNotFoundException;
import co.edu.uniquindio.unieventosbackend.model.documents.Evento;
import co.edu.uniquindio.unieventosbackend.model.documents.Item;
import co.edu.uniquindio.unieventosbackend.model.documents.OrdenCompra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {

     @Autowired
     private EventoService eventoService;
     @Autowired
     private JavaMailSender emailSender;
     @Autowired
     private OrdenCompraService ordenCompraService;
     @Autowired
     private UsuarioService usuarioService;

     public void enviarCorreo(String destinario, Evento event) {
          SimpleMailMessage message = new SimpleMailMessage();
          message.setTo(destinario);
          message.setSubject("Recordatorio de Evento: " + event.getNombre());
          message.setText("El evento " + event.getNombre() + " está próximo a suceder el " + event.getFecha());
          emailSender.send(message);
     }


     public void enviarCorreoMasivo() throws UsuarioNotFoundException {

          List<Evento> eventos = eventoService.obtenerEventosProximos();

          for (Evento evento : eventos) {
               var id = evento.getId();

               for (OrdenCompra orden : ordenCompraService.obtenerOrdenes()) {
                    List<Item> items = orden.getListaItems();
                    for (Item item : items) {
                         if (item.getIdEvento().equals(id)) {
                              var idUsuario = orden.getIdUsuario();
                              var destinatario = usuarioService.findById(idUsuario).getUsername();
                              enviarCorreo(destinatario, evento);
                         }
                    }
               }
          }
     }

}
