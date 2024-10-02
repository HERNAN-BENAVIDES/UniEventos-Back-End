package co.edu.uniquindio.unieventosbackend.services;

import co.edu.uniquindio.unieventosbackend.exceptions.AdministradorNotFound;
import co.edu.uniquindio.unieventosbackend.model.documents.Administrador;
import co.edu.uniquindio.unieventosbackend.repositories.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdministradorService {

     @Autowired
     private AdministradorRepository administradorRepository;

     public Administrador getAdministradorByIdUser(String username) throws AdministradorNotFound {
          Optional<Administrador> administrador = administradorRepository.findByIdUser(username);
          if (administrador.isPresent()){
               return administrador.get();
          }
          throw new AdministradorNotFound("Administrador no encontrado");
     }
}
