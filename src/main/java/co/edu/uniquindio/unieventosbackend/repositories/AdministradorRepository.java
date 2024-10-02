package co.edu.uniquindio.unieventosbackend.repositories;

import co.edu.uniquindio.unieventosbackend.model.documents.Administrador;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AdministradorRepository extends MongoRepository<Administrador, String> {
     @Query("{ 'usuario.username' : ?0 }")
     Optional<Administrador> findByIdUser(String username);
}
