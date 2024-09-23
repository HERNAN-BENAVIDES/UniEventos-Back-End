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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@NoArgsConstructor
@Data
@Document(collection = "usuarios")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SuppressWarnings("ALL")
public class Usuario implements UserDetails {
    @Id
    private String id;
    @EqualsAndHashCode.Include
    private String correoElectronico;
    private String contrasenia;
    private Rol rol;
    private EstadoCuenta estadoCuenta;

    @Builder
    public Usuario(String correo, String contrasenia, Rol rol, EstadoCuenta estadoCuenta) {
        this.correoElectronico = correo;
        this.contrasenia = contrasenia;
        this.rol = rol;
        this.estadoCuenta = estadoCuenta;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return this.contrasenia;
    }

    @Override
    public String getUsername() {
        return this.correoElectronico;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
