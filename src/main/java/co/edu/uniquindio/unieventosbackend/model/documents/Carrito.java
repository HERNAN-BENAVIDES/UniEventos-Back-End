package co.edu.uniquindio.unieventosbackend.model.documents;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@SuppressWarnings("ALL")
public class Carrito {
    private Double total;
    private Date fechaCreacion;
    private List<Item> listaItems;

    @Builder
    public Carrito(String id, Double total, Date fechaCreacion, List<Item> listaItems) {
        this.total = total;
        this.fechaCreacion = fechaCreacion;
        this.listaItems = listaItems;
    }
}
