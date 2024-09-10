package co.edu.uniquindio.unieventosbackend.model.documents;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class Direccion {
    private String departamento;
    private String ciudad;
    private String barrio;
    private String calle;
    private String numResidencia;

    public Direccion(String departamento, String ciudad, String barrio, String calle, String numResidencia) {
        this.departamento = departamento;
        this.ciudad = ciudad;
        this.barrio = barrio;
        this.calle = calle;
        this.numResidencia = numResidencia;
    }
}
