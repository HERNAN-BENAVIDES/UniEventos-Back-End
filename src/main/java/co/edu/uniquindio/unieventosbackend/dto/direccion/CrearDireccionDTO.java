package co.edu.uniquindio.unieventosbackend.dto.direccion;

import co.edu.uniquindio.unieventosbackend.model.documents.Direccion;
import jakarta.validation.constraints.NotBlank;

public record CrearDireccionDTO(
        @NotBlank
        String departamento,
        @NotBlank
        String ciudad,
        @NotBlank
        String barrio,
        @NotBlank
        String calle,
        @NotBlank
        String numResidencia
) {
     public CrearDireccionDTO(Direccion direccion) {
          this(direccion.getDepartamento(), direccion.getCiudad(), direccion.getBarrio(), direccion.getCalle(), direccion.getNumResidencia());
     }
}
