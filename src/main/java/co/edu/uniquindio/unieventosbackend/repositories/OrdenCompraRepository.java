package co.edu.uniquindio.unieventosbackend.repositories;

import co.edu.uniquindio.unieventosbackend.model.documents.OrdenCompra;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdenCompraRepository extends MongoRepository<OrdenCompra, String> {

     @Query("{ 'evento.id': ?0 }")
     List<OrdenCompra> findByEventoId(String id);
}
