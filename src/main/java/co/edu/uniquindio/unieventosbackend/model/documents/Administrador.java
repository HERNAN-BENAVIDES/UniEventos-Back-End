package co.edu.uniquindio.unieventosbackend.model.documents;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@SuppressWarnings("ALL")
public class Administrador {
    private String cedula;
    private String nombre;
    private String apellido;
    private String telefono;
    private Usuario usuario;

    @Builder

    public Administrador(String cedula, String nombre, String apellido, String telefono, Usuario usuario) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.usuario = usuario;
    }
}
