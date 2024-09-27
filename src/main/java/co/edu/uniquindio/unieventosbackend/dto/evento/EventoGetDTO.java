package co.edu.uniquindio.unieventosbackend.dto.evento;


import co.edu.uniquindio.unieventosbackend.dto.direccion.CrearDireccionDTO;
import co.edu.uniquindio.unieventosbackend.model.documents.Evento;
import co.edu.uniquindio.unieventosbackend.model.enums.TipoEvento;

import java.util.List;

public record EventoGetDTO(
            String id,
            String nombre,
            String descripcion,
            TipoEvento tipoEvento,
            String poster,
            String imgLocalidades,
            String fecha,
            CrearDireccionDTO direccion,
            List<LocalidadDTO> listaLocalidades
) {
     public EventoGetDTO(Evento evento) {
          this(evento.getId(), evento.getNombre(), evento.getDescripcion(),evento.getTipoEvento(), evento.getPoster(), evento.getImgLocalidades(),
                  evento.getFecha().toString(), new CrearDireccionDTO(evento.getDireccion()), LocalidadDTO.convertirLista(evento.getListaLocalidades()));
     }
}
