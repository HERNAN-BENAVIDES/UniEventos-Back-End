package co.edu.uniquindio.unieventosbackend.repositories;

import co.edu.uniquindio.unieventosbackend.model.documents.Pago;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoRepository extends MongoRepository<Pago, String> {

}
