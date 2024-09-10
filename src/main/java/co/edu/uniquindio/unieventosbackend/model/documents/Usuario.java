package co.edu.uniquindio.unieventosbackend.model.documents;

import co.edu.uniquindio.unieventosbackend.model.enums.Rol;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Usuario {
    private String correo;
    private String contrasenia;
    private Rol rol;

    @Builder
    public Usuario(String correo, String contrasenia, Rol rol) {
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.rol = rol;
    }
}
