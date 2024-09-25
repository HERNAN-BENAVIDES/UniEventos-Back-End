package co.edu.uniquindio.unieventosbackend.model.documents;

import co.edu.uniquindio.unieventosbackend.dto.usuario.UsuarioRegistroDto;
import co.edu.uniquindio.unieventosbackend.model.enums.EstadoCuenta;
import co.edu.uniquindio.unieventosbackend.model.enums.Rol;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
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
    private String username;
    private String password;
    private Rol rol;
    private EstadoCuenta estadoCuenta;

    @Builder
    public Usuario(String correo, String contrasenia) {
        this.username = correo;
        this.password = contrasenia;
        this.rol = Rol.CLIENTE;
        this.estadoCuenta = EstadoCuenta.ACTIVA;
    }

    public Usuario(UsuarioRegistroDto usuario) {
            this.username = usuario.username();
            this.password = usuario.password();
            this.rol = Rol.CLIENTE;
            this.estadoCuenta = EstadoCuenta.ACTIVA;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + rol));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
