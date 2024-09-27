package co.edu.uniquindio.unieventosbackend.model.documents;

import co.edu.uniquindio.unieventosbackend.dto.direccion.CrearDireccionDTO;
import co.edu.uniquindio.unieventosbackend.dto.evento.CrearEventoDTO;
import co.edu.uniquindio.unieventosbackend.dto.localidad.CrearLocalidadDTO;
import co.edu.uniquindio.unieventosbackend.model.enums.TipoEvento;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Data
@Document(collection = "eventos")
@SuppressWarnings("ALL")
public class Evento {
    @Id
     private String id;
    private String nombre;
    private String descripcion;
    private TipoEvento tipoEvento;
    private String poster;
    private String imgLocalidades;
    private Date fecha;
    private Direccion direccion;
    private List<Localidad> listaLocalidades;
    private Boolean isActivo;

    @Builder
    public Evento(String nombre, String descripcion, String poster, String imgLocalidades, Date fecha, Direccion direccion, List<Localidad> listaLocalidades) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.poster = poster;
        this.imgLocalidades = imgLocalidades;
        this.fecha = fecha;
        this.direccion = direccion;
        this.listaLocalidades = listaLocalidades;
        this.isActivo = true;
    }

    public Evento(CrearEventoDTO evento) {
            this.nombre = evento.nombre();
            this.descripcion = evento.descripcion();
            this.poster = evento.poster();
            this.imgLocalidades = evento.imgLocalidades();
            this.fecha = evento.fecha();
            this.direccion = new Direccion(evento.direccion());
            this.listaLocalidades = casteoLocalidades(evento.listaLocalidades());
            this.isActivo = true;
    }

    private List<Localidad> casteoLocalidades(List<CrearLocalidadDTO> localidadesDTOS) {
            return localidadesDTOS.stream().map(Localidad::new).toList();
    }

     public void desactivar() {
         this.isActivo = false;
     }


}
