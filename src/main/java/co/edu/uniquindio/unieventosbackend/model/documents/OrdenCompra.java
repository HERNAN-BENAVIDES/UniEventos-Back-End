package co.edu.uniquindio.unieventosbackend.model.documents;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Document(collection = "ordenesCompra")
@SuppressWarnings("ALL")
public class OrdenCompra {
    @Id
    private String id;
    private String codigo;
    private String idUsuario;
    private Double total;
    private Date fecha;
    private Pago pago;
    private String idCupon;
    private List<Item> listaItems;

    @Builder
    public OrdenCompra(String codigo, String idUsuario, String idCupon, List<Item> listaItems) {
        this.codigo = codigo;
        this.idUsuario = idUsuario;
        this.total = 0.0;
        this.fecha = new Date();
        this.pago = new Pago();
        this.idCupon = idCupon;
        this.listaItems = listaItems;
    }
}
