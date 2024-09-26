package co.edu.uniquindio.unieventosbackend.dto.evento;

import co.edu.uniquindio.unieventosbackend.model.documents.Localidad;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record LocalidadDTO(
        @NotBlank
        String nombre,
        @NotBlank
        String descripcion,
        @NotBlank
        int capacidadMaxima,
        @NotBlank
        Double precio
     ) {
     public LocalidadDTO(Localidad localidad) {
          this(localidad.getNombre(), localidad.getDescripcion(), localidad.getCapacidadMaxima(), localidad.getPrecio());
     }

     public static List<LocalidadDTO> convertirLista(List<Localidad> listaLocalidades) {
          return listaLocalidades.stream().map(LocalidadDTO::new).toList();
     }
}

