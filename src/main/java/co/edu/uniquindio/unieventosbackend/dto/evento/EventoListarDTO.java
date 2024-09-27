package co.edu.uniquindio.unieventosbackend.dto.evento;

import co.edu.uniquindio.unieventosbackend.model.documents.Evento;
import co.edu.uniquindio.unieventosbackend.model.enums.TipoEvento;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public record EventoListarDTO(
        String id,
        String nombre,
        String descripcion,
        TipoEvento tipoEvento,
        String poster,
        String imgLocalidades,
        String fecha, // Aquí mantenemos el formato de fecha como String
        String direccion
) {
     public EventoListarDTO(Evento evento) {
          this(evento.getId(), evento.getNombre(), evento.getDescripcion(), evento.getTipoEvento(), evento.getPoster(), evento.getImgLocalidades(),
                  formatFecha(evento.getFecha()), evento.getDireccion().getCiudad());
     }

     private static LocalDate getFecha(Date fecha) {
          // Convertir Date a LocalDate
          return fecha.toInstant()
                  .atZone(ZoneId.systemDefault())
                  .toLocalDate();
     }

     private static String formatFecha(Date fecha) {
          LocalDate localDate = getFecha(fecha); // Convertimos a LocalDate
          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); // Formato deseado
          return localDate.format(formatter); // Formateamos la fecha a String
     }
}
