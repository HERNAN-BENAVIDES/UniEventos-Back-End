package co.edu.uniquindio.unieventosbackend.model.documents;

import co.edu.uniquindio.unieventosbackend.model.enums.EstadoCuenta;
import co.edu.uniquindio.unieventosbackend.model.enums.Rol;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Data
@Document(collection = "usuarios")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SuppressWarnings("ALL")
public class Usuario {
    @Id
    private ObjectId id;
    @EqualsAndHashCode.Include
    private String correo;
    private String contrasenia;
    private Rol rol;
    private EstadoCuenta estadoCuenta;

    @Builder
    public Usuario(String correo, String contrasenia, Rol rol, EstadoCuenta estadoCuenta) {
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.rol = rol;
        this.estadoCuenta = estadoCuenta;
    }
}
