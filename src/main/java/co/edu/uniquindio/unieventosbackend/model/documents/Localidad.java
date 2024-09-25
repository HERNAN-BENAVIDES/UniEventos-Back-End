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
    private Integer cantidadOcupada;
    private Integer cantidadDisponible;
    private Double precio;

    @Builder
    public Localidad(String nombre, String descripcion, Integer capacidadMaxima, Double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.capacidadMaxima = capacidadMaxima;
        this.cantidadOcupada = 0;
        this.cantidadDisponible = capacidadMaxima - cantidadOcupada;
        this.precio = precio;
    }

    public Localidad(CrearLocalidadDTO localidadDTO) {
            this.nombre = localidadDTO.nombre();
            this.descripcion = localidadDTO.descripcion();
            this.capacidadMaxima = localidadDTO.capacidadMaxima();
            this.cantidadOcupada = 0;
            this.cantidadDisponible = capacidadMaxima - cantidadOcupada;
            this.precio = localidadDTO.precio();
    }
}
