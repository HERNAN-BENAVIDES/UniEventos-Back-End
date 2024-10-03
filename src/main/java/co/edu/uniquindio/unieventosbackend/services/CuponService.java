package co.edu.uniquindio.unieventosbackend.services;

import co.edu.uniquindio.unieventosbackend.exceptions.CuponExistenteException;
import co.edu.uniquindio.unieventosbackend.model.documents.Cupon;
import co.edu.uniquindio.unieventosbackend.repositories.CuponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CuponService {

     @Autowired
     private CuponRepository cuponRepository;

     public  Cupon crearCupon(Cupon cupon) throws CuponExistenteException {
          Optional<Cupon> cuponOptional = cuponRepository.findByCodigo(cupon.getCodigo());
          if (cuponOptional.isPresent()) {
               throw new CuponExistenteException("El cupón con el código " + cupon.getCodigo() + " ya existe");
          }
          return cuponRepository.save(cupon);

     }
}
