package co.edu.uniquindio.unieventosbackend.model.documents;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
@Builder
@SuppressWarnings("ALL")
public class Cupon {
    private String id;
    private String codigo;
    private String nombre;
    private Double porcentajeDescuento;
    private Date fechaVencimiento;

    public Cupon(String id, String codigo, String nombre, Double porcentajeDescuento, Date fechaVencimiento) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.porcentajeDescuento = porcentajeDescuento;
        this.fechaVencimiento = fechaVencimiento;
    }
}
