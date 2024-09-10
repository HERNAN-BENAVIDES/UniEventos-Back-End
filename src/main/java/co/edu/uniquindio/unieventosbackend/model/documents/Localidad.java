package co.edu.uniquindio.unieventosbackend.model.documents;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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
}
