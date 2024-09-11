package co.edu.uniquindio.unieventosbackend.model.documents;

import co.edu.uniquindio.unieventosbackend.dto.localidad.CrearLocalidadDTO;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@SuppressWarnings("ALL")
public class Localidad {
    private String nombre;
    private String descripcion;
    private Integer capacidadMaxima;

    @Builder
    public Localidad(String nombre, String descripcion, Integer capacidadMaxima) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.capacidadMaxima = capacidadMaxima;
    }

    public Localidad(CrearLocalidadDTO localidadDTO) {
            this.nombre = localidadDTO.nombre();
            this.descripcion = localidadDTO.descripcion();
            this.capacidadMaxima = localidadDTO.capacidadMaxima();
    }
}
