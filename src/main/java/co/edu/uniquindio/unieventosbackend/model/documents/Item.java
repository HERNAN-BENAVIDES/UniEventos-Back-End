package co.edu.uniquindio.unieventosbackend.model.documents;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@SuppressWarnings("ALL")
public class Item {
    @Id
    private String id;
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
