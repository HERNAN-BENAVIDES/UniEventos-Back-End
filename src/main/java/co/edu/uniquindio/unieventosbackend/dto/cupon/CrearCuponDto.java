package co.edu.uniquindio.unieventosbackend.dto.cupon;

import co.edu.uniquindio.unieventosbackend.model.enums.EstadoCupon;
import co.edu.uniquindio.unieventosbackend.model.enums.TipoCupon;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public record CrearCuponDto(
        @NotBlank
        String codigo,
        @NotBlank
        String nombre,
        @NotBlank
        String descripcion,
        @Positive
        Double descuento,
        @NotNull
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        Date fechaInicio,
        @NotNull
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        Date fechaFin,
        @Positive
        Double montoMinimoCompra,
        @NotNull
        EstadoCupon estado,
        @NotNull
        TipoCupon tipo
) {
}
