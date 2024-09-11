package co.edu.uniquindio.unieventosbackend.dto.evento;

import co.edu.uniquindio.unieventosbackend.dto.direccion.CrearDireccionDTO;
import co.edu.uniquindio.unieventosbackend.dto.localidad.CrearLocalidadDTO;
import co.edu.uniquindio.unieventosbackend.model.documents.Direccion;
import co.edu.uniquindio.unieventosbackend.model.documents.Localidad;

import java.util.Date;
import java.util.List;

public record CrearEventoDTO(
        String nombre,
        String descripcion,
        String poster,
        String imgLocalidades,
        Date fecha,
        CrearDireccionDTO direccion,
        List<CrearLocalidadDTO>listaLocalidades
) {
}
