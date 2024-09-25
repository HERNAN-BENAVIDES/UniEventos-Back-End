package co.edu.uniquindio.unieventosbackend.model.documents;

import co.edu.uniquindio.unieventosbackend.model.enums.EstadoOrden;
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
    private EstadoOrden estadoOrden;
    private Cupon cupon;
    private List<Item> listaItems;

    @Builder
    public OrdenCompra(String codigo, String idUsuario, Cupon cupon, List<Item> listaItems) {
        this.codigo = codigo;
        this.idUsuario = idUsuario;
        this.total = calcularTotal();
        this.fecha = new Date();
        this.estadoOrden = EstadoOrden.PENDIENTE;
        this.cupon = cupon;
        this.listaItems = listaItems;
    }

    private Double calcularTotal() {
            this.total = 0.0;
            for (Item item : listaItems) {
               this.total += item.getSubtotal();
            }

            if (this.cupon != null) {
                this.total = this.total - (this.total * this.cupon.getPorcentajeDescuento() / 100);
            }

            return this.total;
    }
}
