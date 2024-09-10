package co.edu.uniquindio.unieventosbackend.model.documents;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@SuppressWarnings("ALL")
public class Boleto {
    private Cliente cliente;
    private String qr;

    @Builder
    public Boleto(Cliente cliente, String qr) {
        this.cliente = cliente;
        this.qr = qr;
    }
}
