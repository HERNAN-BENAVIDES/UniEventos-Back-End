package co.edu.uniquindio.unieventosbackend.model.documents;

import co.edu.uniquindio.unieventosbackend.model.documents.interfaces.Persona;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Data
@SuppressWarnings("ALL")
@Document(collection = "administradores")
public class Administrador implements Persona {
    @Id
    private String id;
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
