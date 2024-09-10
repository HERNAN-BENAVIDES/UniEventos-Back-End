package co.edu.uniquindio.unieventosbackend.model.documents;

import co.edu.uniquindio.unieventosbackend.model.enums.MetodoPago;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "pagos")
@SuppressWarnings("ALL")
public class Pago {
    @Id
    private ObjectId idPago;
    private String idOrdenCompra;
    private MetodoPago metodoPago;

    @Builder
    public Pago(String idOrdenCompra,MetodoPago metodoPago) {
        this.idOrdenCompra = idOrdenCompra;
        this.metodoPago = metodoPago;
    }
}
