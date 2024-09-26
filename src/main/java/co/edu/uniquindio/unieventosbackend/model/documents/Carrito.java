package co.edu.uniquindio.unieventosbackend.model.documents;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@SuppressWarnings("ALL")
public class Carrito {
    private Double total;
    private List<Item> listaItems;

    @Builder
    public Carrito() {
        this.total = 0.0;
        this.listaItems = new ArrayList<>();
    }

    public Double calcularTotal() {
        this.total = 0.0;
        for (Item item : listaItems) {
            this.total += item.getSubtotal();
        }
        return this.total;
    }
}
