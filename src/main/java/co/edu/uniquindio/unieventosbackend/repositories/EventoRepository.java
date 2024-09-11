package co.edu.uniquindio.unieventosbackend.repositories;

import co.edu.uniquindio.unieventosbackend.model.documents.Evento;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Date;
import java.util.List;

public interface EventoRepository extends MongoRepository<Evento, ObjectId> {
     Evento save(Evento evento);

     List<Evento> findByFechaGreaterThanEqual(Date fecha);

}
