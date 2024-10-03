package co.edu.uniquindio.unieventosbackend.model.documents;

import co.edu.uniquindio.unieventosbackend.dto.cupon.CrearCuponDto;
import co.edu.uniquindio.unieventosbackend.model.enums.EstadoCupon;
import co.edu.uniquindio.unieventosbackend.model.enums.TipoCupon;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@NoArgsConstructor
@Data
@SuppressWarnings("ALL")
@Document(collection = "cupones")
public class Cupon {
    @Id
    private String id;
    private String codigo;
    private String nombre;
    private String descripcion;
    private Double descuento;
    private Date fechaInicio;
    private Date fechaFin;
    private Double montoMinimoCompra;
    private EstadoCupon estado;
    private TipoCupon tipo;

    @Builder
    public Cupon(String codigo, String nombre, String descripcion,
                 Double descuento, Date fechaInicio, Date fechaFin, Double montoMinimoCompra,
                 EstadoCupon estado, TipoCupon tipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.descuento = descuento;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.montoMinimoCompra = montoMinimoCompra;
        this.estado = estado;
        this.tipo = tipo;
    }

    public Cupon(CrearCuponDto cupon) {
            this.codigo = cupon.codigo();
            this.nombre = cupon.nombre();
            this.descripcion = cupon.descripcion();
            this.descuento = cupon.descuento();
            this.fechaInicio = cupon.fechaInicio();
            this.fechaFin = cupon.fechaFin();
            this.montoMinimoCompra = cupon.montoMinimoCompra();
            this.estado = cupon.estado();
            this.tipo = cupon.tipo();
    }
}
