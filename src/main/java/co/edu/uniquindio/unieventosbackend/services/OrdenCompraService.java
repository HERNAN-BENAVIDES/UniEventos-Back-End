package co.edu.uniquindio.unieventosbackend.services;

import co.edu.uniquindio.unieventosbackend.model.documents.OrdenCompra;
import co.edu.uniquindio.unieventosbackend.repositories.OrdenCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenCompraService {

     @Autowired
     private OrdenCompraRepository ordenCompraRepository;

     public List<OrdenCompra> obtenerOrdenesByIdEvento(String id) {
          return ordenCompraRepository.findByEventoId(id);
     }

     public List<OrdenCompra> obtenerOrdenes() {
          return ordenCompraRepository.findAll();
     }
}
