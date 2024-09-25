package co.edu.uniquindio.unieventosbackend.repositories;

import co.edu.uniquindio.unieventosbackend.model.documents.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String> {
}
