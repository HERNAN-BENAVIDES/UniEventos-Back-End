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
    private ObjectId id;
    private String codigo;
    private String nombre;
    private Double porcentajeDescuento;
    private Date fechaVencimiento;

    @Builder
    public Cupon(String codigo, String nombre, Double porcentajeDescuento, Date fechaVencimiento) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.porcentajeDescuento = porcentajeDescuento;
        this.fechaVencimiento = fechaVencimiento;
    }
}
