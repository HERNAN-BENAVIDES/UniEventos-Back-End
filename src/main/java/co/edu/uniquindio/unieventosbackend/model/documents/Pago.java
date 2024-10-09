package co.edu.uniquindio.unieventosbackend.model.documents;

import co.edu.uniquindio.unieventosbackend.model.enums.EstadoPago;
import co.edu.uniquindio.unieventosbackend.model.enums.MetodoPago;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@NoArgsConstructor
@SuppressWarnings("ALL")
public class Pago {
    @Id
    private String id;
    private Date fecha;
    private EstadoPago estado;
    private Double monto;
    private MetodoPago metodoPago;

    @Builder
    public Pago(Double monto, MetodoPago metodoPago) {
        this.fecha = new Date();
        this.estado = EstadoPago.PENDIENTE;
        this.monto = monto;
        this.metodoPago = metodoPago;
    }
}
