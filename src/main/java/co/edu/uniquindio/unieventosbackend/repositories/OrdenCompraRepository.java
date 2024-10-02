package co.edu.uniquindio.unieventosbackend.repositories;

import co.edu.uniquindio.unieventosbackend.model.documents.OrdenCompra;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrdenCompraRepository extends MongoRepository <OrdenCompra, String> {

    // Método para encontrar todas las órdenes de compra de un usuario específico
    List<OrdenCompra> findByIdUsuario(String idUsuario);

}
