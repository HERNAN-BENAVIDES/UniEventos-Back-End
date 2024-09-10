package co.edu.uniquindio.unieventosbackend.model.documents;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Builder
@Data
public class Evento {
    private String nombre;
    private String descripcion;
    private String poster;
    private String imgLocalidades;
    private Date fecha;
    private Direccion direccion;
    private List<Localidad> listaLocalidades;

    public Evento(String nombre, String descripcion, String poster, String imgLocalidades, Date fecha, Direccion direccion, List<Localidad> listaLocalidades) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.poster = poster;
        this.imgLocalidades = imgLocalidades;
        this.fecha = fecha;
        this.direccion = direccion;
        this.listaLocalidades = listaLocalidades;
    }
}
