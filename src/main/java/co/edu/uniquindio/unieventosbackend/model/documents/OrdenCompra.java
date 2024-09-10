package co.edu.uniquindio.unieventosbackend.model.documents;

import co.edu.uniquindio.unieventosbackend.model.enums.EstadoOrden;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class OrdenCompra {
    private String id;
    private String codigo;
    private Double total;
    private Date fecha;
    private EstadoOrden estadoOrden;
    private Cupon cupon;
    private List<Item> listaItems;

    @Builder
    public OrdenCompra(String id, String codigo, Double total, Date fecha, EstadoOrden estadoOrden, Cupon cupon, List<Item> listaItems) {
        this.id = id;
        this.codigo = codigo;
        this.total = total;
        this.fecha = fecha;
        this.estadoOrden = estadoOrden;
        this.cupon = cupon;
        this.listaItems = listaItems;
    }
}
