package co.edu.uniquindio.unieventosbackend.model.documents;

import co.edu.uniquindio.unieventosbackend.model.enums.MetodoPago;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@SuppressWarnings("ALL")
public class Pago {
    private String idPago;
    private String idOrdenCompra;
    private MetodoPago metodoPago;

    @Builder
    public Pago(String idPago, String idOrdenCompra,MetodoPago metodoPago) {
        this.idPago = idPago;
        this.idOrdenCompra = idOrdenCompra;
        this.metodoPago = metodoPago;
    }
}
