package co.edu.uniquindio.unieventosbackend.repositories;

import co.edu.uniquindio.unieventosbackend.model.documents.Evento;
import co.edu.uniquindio.unieventosbackend.model.enums.TipoEvento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.Optional;

public interface EventoRepository extends MongoRepository<Evento, String> {

     Optional<Page<Evento>> findByIsActivoTrue(Pageable pageable);;

     // Búsquedas individuales
     @Query("{ 'nombre': { $regex: ?0, $options: 'i' } }")
     Page<Evento> findByNombreContaining(Pageable pageable, String nombre);

     @Query("{ 'direccion.ciudad': ?0 }")
     Page<Evento> findByDireccionCiudad(Pageable pageable, String ciudad);

     @Query("{ 'tipoEvento': ?0 }")
     Page<Evento> findByTipoEvento(Pageable pageable, TipoEvento tipoEvento);

     @Query("{ 'fecha': { $gte: ?0 } }")
     Page<Evento> findByFechaGreaterThanEqual(Pageable pageable, Date fecha);

     // Combinaciones
     @Query("{ 'nombre': { $regex: ?0, $options: 'i' }, 'direccion.ciudad': ?1 }")
     Page<Evento> findByNombreContainingAndDireccionCiudad(Pageable pageable, String nombre, String ciudad);

     @Query("{ 'nombre': { $regex: ?0, $options: 'i' }, 'tipoEvento': ?1 }")
     Page<Evento> findByNombreContainingAndTipoEvento(Pageable pageable, String nombre, TipoEvento tipoEvento);

     @Query("{ 'nombre': { $regex: ?0, $options: 'i' }, 'fecha': { $gte: ?1 } }")
     Page<Evento> findByNombreContainingAndFechaGreaterThanEqual(Pageable pageable, String nombre, Date fecha);

     @Query("{ 'direccion.ciudad': ?0, 'tipoEvento': ?1 }")
     Page<Evento> findByDireccionCiudadAndTipoEvento(Pageable pageable, String ciudad, TipoEvento tipoEvento);

     @Query("{ 'direccion.ciudad': ?0, 'fecha': { $gte: ?1 } }")
     Page<Evento> findByDireccionCiudadAndFechaGreaterThanEqual(Pageable pageable, String ciudad, Date fecha);

     @Query("{ 'tipoEvento': ?0, 'fecha': { $gte: ?1 } }")
     Page<Evento> findByTipoEventoAndFechaGreaterThanEqual(Pageable pageable, TipoEvento tipoEvento, Date fecha);

     @Query("{ 'nombre': { $regex: ?0, $options: 'i' }, 'direccion.ciudad': ?1, 'tipoEvento': ?2 }")
     Page<Evento> findByNombreContainingAndDireccionCiudadAndTipoEvento(Pageable pageable, String nombre, String ciudad, TipoEvento tipoEvento);

     @Query("{ 'nombre': { $regex: ?0, $options: 'i' }, 'direccion.ciudad': ?1, 'fecha': { $gte: ?2 } }")
     Page<Evento> findByNombreContainingAndDireccionCiudadAndFechaGreaterThanEqual(Pageable pageable, String nombre, String ciudad, Date fecha);

     @Query("{ 'nombre': { $regex: ?0, $options: 'i' }, 'tipoEvento': ?1, 'fecha': { $gte: ?2 } }")
     Page<Evento> findByNombreContainingAndTipoEventoAndFechaGreaterThanEqual(Pageable pageable, String nombre, TipoEvento tipoEvento, Date fecha);

     @Query("{ 'direccion.ciudad': ?0, 'tipoEvento': ?1, 'fecha': { $gte: ?2 } }")
     Page<Evento> findByDireccionCiudadAndTipoEventoAndFechaGreaterThanEqual(Pageable pageable, String ciudad, TipoEvento tipoEvento, Date fecha);

     @Query("{ 'nombre': { $regex: ?0, $options: 'i' }, 'direccion.ciudad': ?1, 'tipoEvento': ?2, 'fecha': { $gte: ?3 } }")
     Page<Evento> findByNombreContainingAndDireccionCiudadAndTipoEventoAndFechaGreaterThanEqual(Pageable pageable, String nombre, String ciudad, TipoEvento tipoEvento, Date fecha);
}
