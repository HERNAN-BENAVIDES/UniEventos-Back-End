package co.edu.uniquindio.unieventosbackend.repositories;

import co.edu.uniquindio.unieventosbackend.model.documents.Evento;
import co.edu.uniquindio.unieventosbackend.model.enums.TipoEvento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface EventoRepository extends MongoRepository<Evento, String> {

     Optional<Page<Evento>> findByIsActivoTrue(Pageable pageable);

     // Búsquedas individuales
     @Query("{ 'nombre': { $regex: ?0, $options: 'i' } }")
     Page<Evento> findByNombreContaining(Pageable pageable, String nombre);

     @Query("{ 'direccion.ciudad': ?0 }")
     Page<Evento> findByDireccionCiudad(Pageable pageable, String ciudad);

     @Query("{ 'tipoEvento': ?0 }")
     Page<Evento> findByTipoEvento(Pageable pageable, TipoEvento tipoEvento);

     @Query("{ 'fecha' : { $gte: ?1, $lte: ?2 } }")
     Page<Evento> findByFechaGreaterThanEqualAndFechaBetween(Pageable pageable, String fecha, Date inicioDelDia, Date finDelDia);

     // Combinaciones
     @Query("{ 'nombre': { $regex: ?0, $options: 'i' }, 'direccion.ciudad': ?1 }")
     Page<Evento> findByNombreContainingAndDireccionCiudad(Pageable pageable, String nombre, String ciudad);

     @Query("{ 'nombre': { $regex: ?0, $options: 'i' }, 'tipoEvento': ?1 }")
     Page<Evento> findByNombreContainingAndTipoEvento(Pageable pageable, String nombre, TipoEvento tipoEvento);

     @Query("{ 'nombre': { $regex: ?0, $options: 'i' }, 'fecha': { $gte: ?2, $lte: ?3 } }")
     Page<Evento> findByNombreContainingAndFechaBetween(Pageable pageable, String nombre, String fecha, Date inicioDelDia, Date finDelDia);

     @Query("{ 'direccion.ciudad': ?0, 'tipoEvento': ?1 }")
     Page<Evento> findByDireccionCiudadAndTipoEvento(Pageable pageable, String ciudad, TipoEvento tipoEvento);

     @Query("{ 'direccion.ciudad': ?0, 'fecha': { $gte: ?2, $lte: ?3 } }")
     Page<Evento> findByDireccionCiudadAndFechaBetween(Pageable pageable, String ciudad, String fecha, Date inicioDelDia, Date finDelDia);

     @Query("{ 'tipoEvento': ?0, 'fecha': { $gte: ?2, $Ite: ?3 } }")
     Page<Evento> findByTipoEventoAndFechaBetween(Pageable pageable, TipoEvento tipoEvento, String fecha, Date inicioDelDia, Date finDelDia);

     @Query("{ 'nombre': { $regex: ?0, $options: 'i' }, 'direccion.ciudad': ?1, 'tipoEvento': ?2 }")
     Page<Evento> findByNombreContainingAndDireccionCiudadAndTipoEvento(Pageable pageable, String nombre, String ciudad, TipoEvento tipoEvento);

     @Query("{ 'nombre': { $regex: ?0, $options: 'i' }, 'direccion.ciudad': ?1, 'fecha': { $gte: ?3, $lte: ?4 } }")
     Page<Evento> findByNombreContainingAndDireccionCiudadAndFechaBetween(Pageable pageable, String nombre, String ciudad, String fecha,Date inicioDelDia, Date finDelDia);

     @Query("{ 'nombre': { $regex: ?0, $options: 'i' }, 'tipoEvento': ?1, 'fecha': { $gte: ?3, $lte: ?4 } }")
     Page<Evento> findByNombreContainingAndTipoEventoAndFechaBetween(Pageable pageable, String nombre, TipoEvento tipoEvento, String fecha, Date inicioDelDia, Date finDelDia);

     @Query("{ 'direccion.ciudad': ?0, 'tipoEvento': ?1, 'fecha': { $gte: ?3, $lte: ?4 } }")
     Page<Evento> findByDireccionCiudadAndTipoEventoAndFechaBetween(Pageable pageable, String ciudad, TipoEvento tipoEvento, String fecha, Date inicioDelDia, Date finDelDia);

     @Query("{ 'nombre': { $regex: ?0, $options: 'i' }, 'direccion.ciudad': ?1, 'tipoEvento': ?2, 'fecha': { $gte: ?4, $lte: ?5 } }")
     Page<Evento> findByNombreContainingAndDireccionCiudadAndTipoEventoAndFechaBetween(Pageable pageable, String nombre, String ciudad, TipoEvento tipoEvento, String fecha, Date inicioDelDia, Date finDelDia);

     @Query("{ 'fecha': { $gte: ?0, $lte: ?1 } }")
     List<Evento> findByFechaBetween(Date inicio, Date fin);
}
