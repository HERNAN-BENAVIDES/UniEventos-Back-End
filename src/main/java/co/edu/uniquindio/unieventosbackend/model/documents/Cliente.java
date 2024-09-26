package co.edu.uniquindio.unieventosbackend.model.documents;

import co.edu.uniquindio.unieventosbackend.dto.cliente.ClienteRegistroDto;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@SuppressWarnings("ALL")
@Document(collection = "clientes")
public class Cliente {
    @Id
    private String id;
    private String cedula;
    private String nombre;
    private String apellido;
    private String telefono;
    private Usuario usuario;
    private Carrito carrito;
    private List<String> idOrdenesCompra;

    @Builder
    public Cliente(String cedula, String nombre, String apellido, String telefono, Usuario usuario) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.usuario = usuario;
        this.carrito = new Carrito();
        this.idOrdenesCompra = new ArrayList<>();
    }

    public Cliente(ClienteRegistroDto clienteRegistroDto) {
            this.cedula = clienteRegistroDto.cedula();
            this.nombre = clienteRegistroDto.nombre();
            this.apellido = clienteRegistroDto.apellido();
            this.telefono = clienteRegistroDto.telefono();
            this.usuario = new Usuario(clienteRegistroDto.usuario());
            this.carrito = new Carrito();
            this.idOrdenesCompra = new ArrayList<>();
    }
}
