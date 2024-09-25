package co.edu.uniquindio.unieventosbackend.repositories;

import co.edu.uniquindio.unieventosbackend.model.documents.Evento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

public interface EventoRepository extends MongoRepository<Evento, String> {
     Evento save(Evento evento);

     List<Evento> findByFechaGreaterThanEqual(Date fecha);

     List<Evento> findByNombreContaining(String nombre);

     List<Evento> findByFechaGreaterThanEqualAndNombreContaining(Date fecha, String nombre);

     List<Evento> findByNombreContainingAndFechaGreaterThanEqual(String nombre, Date fecha);

     List<Evento> findByDireccionCiudad(String ciudad);
     ;
}
