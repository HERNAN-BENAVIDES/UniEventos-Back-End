package co.edu.uniquindio.unieventosbackend.model.documents;

import co.edu.uniquindio.unieventosbackend.dto.direccion.CrearDireccionDTO;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@SuppressWarnings("ALL")
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

    public Direccion(CrearDireccionDTO direccion) {
            this.departamento = direccion.departamento();
            this.ciudad = direccion.ciudad();
            this.barrio = direccion.barrio();
            this.calle = direccion.calle();
            this.numResidencia = direccion.numResidencia();
    }
}
