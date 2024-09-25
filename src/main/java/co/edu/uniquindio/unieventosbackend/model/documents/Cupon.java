package co.edu.uniquindio.unieventosbackend.model.documents;

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
    private Double porcentajeDescuento;
    private Date fechaVencimiento;
    private int cantidadRedenciones;
    private int redencionesActuales;
    private Double montoMinimoCompra;

    @Builder
    public Cupon(String codigo, String nombre, Double porcentajeDescuento, Date fechaVencimiento,
                 int cantidadRedenciones, int redencionesActuales, Double montoMinimoCompra) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.porcentajeDescuento = porcentajeDescuento;
        this.fechaVencimiento = fechaVencimiento;
        this.cantidadRedenciones = cantidadRedenciones;
        this.redencionesActuales = redencionesActuales;
        this.montoMinimoCompra = montoMinimoCompra;
    }
}
