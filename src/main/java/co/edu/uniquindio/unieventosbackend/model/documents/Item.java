package co.edu.uniquindio.unieventosbackend.model.documents;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@SuppressWarnings("ALL")
public class Item {
    private String idEvento;
    private Localidad localidad;
    private Integer unidades;
    private Double subtotal;

    @Builder
    public Item(String idEvento, Localidad localidad, Integer unidades) {
        this.idEvento = idEvento;
        this.localidad = localidad;
        this.unidades = unidades;
        this.subtotal = localidad.getPrecio() * unidades;
    }
}
