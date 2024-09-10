package co.edu.uniquindio.unieventosbackend.model.documents;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@SuppressWarnings("ALL")
public class Item {
    private String id;
    private Integer unidades;

    public Item(String id, Integer unidades) {
        this.id = id;
        this.unidades = unidades;
    }
}
