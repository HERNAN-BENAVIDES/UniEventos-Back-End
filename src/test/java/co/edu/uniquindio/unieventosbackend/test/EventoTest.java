package co.edu.uniquindio.unieventosbackend.test;

import co.edu.uniquindio.unieventosbackend.exceptions.EventoException;
import co.edu.uniquindio.unieventosbackend.exceptions.EventoNotFoundException;
import co.edu.uniquindio.unieventosbackend.model.documents.Direccion;
import co.edu.uniquindio.unieventosbackend.model.documents.Evento;
import co.edu.uniquindio.unieventosbackend.services.EventoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class EventoTest {

     @Autowired
     private EventoService eventoService;

     /**
      * Prueba para crear un evento
      * Se espera que el evento sea creado correctamente
      * y que no sea nulo
      */
     @Test
     public void testCrearEvento() throws EventoException {
          Evento evento = Evento.builder()
                  .nombre("Evento de prueba")
                  .descripcion("Evento de prueba")
                  .poster("https://www.google.com")
                  .imgLocalidades("https://www.google.com")
                  .fecha(new Date())
                  .direccion(Direccion.builder()
                          .departamento("Quindio")
                          .ciudad("Armenia")
                          .barrio("Barrio")
                          .calle("Calle")
                          .numResidencia("123")
                          .build())
                  .listaLocalidades(new ArrayList<>())
                  .build();

          Evento e = eventoService.crearEvento(evento);

          assertNotNull(e);

     }

     /**
      * Prueba para eliminar un evento por su id
      * Se espera que el evento sea eliminado correctamente
      * y que no sea nulo
      */
     @Test
     public void testEliminarEventoById() throws EventoException, EventoNotFoundException {
          Evento evento = Evento.builder()
                  .nombre("Evento de prueba")
                  .descripcion("Evento de prueba")
                  .poster("https://www.google.com")
                  .imgLocalidades("https://www.google.com")
                  .fecha(new Date())
                  .direccion(Direccion.builder()
                          .departamento("Quindio")
                          .ciudad("Armenia")
                          .barrio("Barrio")
                          .calle("Calle")
                          .numResidencia("123")
                          .build())
                  .listaLocalidades(new ArrayList<>())
                  .build();

          Evento e = eventoService.crearEvento(evento);

          assertNotNull(e);

          Evento eliminado = eventoService.eliminarEvento(e.getId());

          assertNotNull(eliminado);
     }

     /**
      * Prueba para eliminar un evento
      * Se espera que el evento sea eliminado correctamente
      * y que no sea nulo
      */
     @Test
     public void testEliminarEvento() throws EventoException {
          Evento evento = Evento.builder()
                  .nombre("Evento de prueba")
                  .descripcion("Evento de prueba")
                  .poster("https://www.google.com")
                  .imgLocalidades("https://www.google.com")
                  .fecha(new Date())
                  .direccion(Direccion.builder()
                          .departamento("Quindio")
                          .ciudad("Armenia")
                          .barrio("Barrio")
                          .calle("Calle")
                          .numResidencia("123")
                          .build())
                  .listaLocalidades(new ArrayList<>())
                  .build();

          Evento e = eventoService.crearEvento(evento);

          assertNotNull(e);

          Evento eliminado = eventoService.eliminarEvento(e);

          assertNotNull(eliminado);
     }

     /**
      * Prueba para desactivar un evento
      * Se espera que el evento sea desactivado correctamente
      * y que no sea nulo
      */
     @Test
     public void testDesactivarEvento() throws EventoException, EventoNotFoundException {
          Evento evento = Evento.builder()
                  .nombre("Evento de prueba")
                  .descripcion("Evento de prueba")
                  .poster("https://www.google.com")
                  .imgLocalidades("https://www.google.com")
                  .fecha(new Date())
                  .direccion(Direccion.builder()
                          .departamento("Quindio")
                          .ciudad("Armenia")
                          .barrio("Barrio")
                          .calle("Calle")
                          .numResidencia("123")
                          .build())
                  .listaLocalidades(new ArrayList<>())
                  .build();

          Evento e = eventoService.crearEvento(evento);

          assertNotNull(e);

          Evento desactivado = eventoService.desactivarEvento(e.getId());

          assertNotNull(desactivado);
     }

     /**
      * Prueba para activar un evento
      * Se espera que el evento sea activado correctamente
      * y que no sea nulo
      */
     @Test
     public void testActivarEvento() throws EventoException, EventoNotFoundException {
          Evento evento = Evento.builder()
                  .nombre("Evento de prueba")
                  .descripcion("Evento de prueba")
                  .poster("https://www.google.com")
                  .imgLocalidades("https://www.google.com")
                  .fecha(new Date())
                  .direccion(Direccion.builder()
                          .departamento("Quindio")
                          .ciudad("Armenia")
                          .barrio("Barrio")
                          .calle("Calle")
                          .numResidencia("123")
                          .build())
                  .listaLocalidades(new ArrayList<>())
                  .build();

          Evento e = eventoService.crearEvento(evento);

          assertNotNull(e);

          Evento desactivado = eventoService.desactivarEvento(e.getId());

          assertNotNull(desactivado);

          Evento activado = eventoService.activarEvento(e.getId());

          assertNotNull(activado);
     }

     /**
      * Prueba para actualizar un evento
      * Se espera que el evento sea actualizado correctamente
      * y que no sea nulo
      */
     @Test
     public void testActualizarEvento() throws EventoException, EventoNotFoundException {
          Evento evento = Evento.builder()
                  .nombre("Evento de prueba")
                  .descripcion("Evento de prueba")
                  .poster("https://www.google.com")
                  .imgLocalidades("https://www.google.com")
                  .fecha(new Date())
                  .direccion(Direccion.builder()
                          .departamento("Quindio")
                          .ciudad("Armenia")
                          .barrio("Barrio")
                          .calle("Calle")
                          .numResidencia("123")
                          .build())
                  .listaLocalidades(new ArrayList<>())
                  .build();

          Evento e = eventoService.crearEvento(evento);

          assertNotNull(e);

          Evento actualizado = eventoService.actualizarEvento(e.getId(), e);

          assertNotNull(actualizado);
     }

     /**
      * Prueba para obtener la lista de eventos
      * Se espera que los eventos sean obtenidos correctamente
      * y que no sea nulo
      */
     @Test
     public void testObtenerEventos() {
          //assertEquals(4, eventoService.obtenerEventos().size());
     }

     /**
      * Prueba para obtener la lista de eventos por nombre
      * Se espera que los eventos sean obtenidos correctamente
      * y que no sea nulo
      */
     @Test
     public void testObtenerEventosPorNombre() {
//          assertEquals(1, eventoService.obtenerEventosPorNombre("Evento de prueba").size());
     }

     /**
      * Prueba para obtener la lista de eventos por fecha
      * Se espera que los eventos sean obtenidos correctamente
      * y que no sea nulo
      */
     @Test
     public void testObtenerEventosPorFecha() throws EventoException {
          Evento evento = Evento.builder()
                  .nombre("Evento de prueba")
                  .descripcion("Evento de prueba")
                  .poster("https://www.google.com")
                  .imgLocalidades("https://www.google.com")
                  .fecha(new Date( 2024, 11, 10))
                  .direccion(Direccion.builder()
                          .departamento("Quindio")
                          .ciudad("Armenia")
                          .barrio("Barrio")
                          .calle("Calle")
                          .numResidencia("123")
                          .build())
                  .listaLocalidades(new ArrayList<>())
                  .build();

          eventoService.crearEvento(evento);

        //  assertEquals(1, eventoService.obtenerEventosPorFecha(new Date(2024, 11,10)).size());
     }

     /**
      * Prueba para obtener la lista de eventos disponibles
      * Se espera que los eventos sean obtenidos correctamente
      * y que no sea nulo
      */
     @Test
     public void testObtenerEventosDisponiblesByFechaYNombre() throws EventoException {

          Evento evento = Evento.builder()
                  .nombre("Evento de prueba")
                  .descripcion("Evento de prueba")
                  .poster("https://www.google.com")
                  .imgLocalidades("https://www.google.com")
                  .fecha(new Date(2024, 11, 10))
                  .direccion(Direccion.builder()
                          .departamento("Quindio")
                          .ciudad("Armenia")
                          .barrio("Barrio")
                          .calle("Calle")
                          .numResidencia("123")
                          .build())
                  .listaLocalidades(new ArrayList<>())
                  .build();

          eventoService.crearEvento(evento);

         //  assertEquals(1, eventoService.obtenerEventosPorFechaYNombre(
            //       new Date(2024, 11, 10), "Evento de prueba").size());
       }


     /**
      * Prueba para obtener la lista de eventos por nombre y fecha
      * Se espera que los eventos sean obtenidos correctamente
      */
     @Test
     public void testObtenerEventosPorNombreYFecha() throws EventoException {
          Evento evento = Evento.builder()
                  .nombre("Evento de prueba")
                  .descripcion("Evento de prueba")
                  .poster("https://www.google.com")
                  .imgLocalidades("https://www.google.com")
                  .fecha(new Date(2024, 11, 10))
                  .direccion(Direccion.builder()
                          .departamento("Quindio")
                          .ciudad("Armenia")
                          .barrio("Barrio")
                          .calle("Calle")
                          .numResidencia("123")
                          .build())
                  .listaLocalidades(new ArrayList<>())
                  .build();

          eventoService.crearEvento(evento);

         // assertEquals(1, eventoService.obtenerEventosPorNombreYFecha("Evento de prueba", new Date(2024, 11, 10)).size());
     }

     /**
      * Prueba para obtener la lista de eventos por ciudad
      * Se espera que los eventos sean obtenidos correctamente
      */
     @Test
     public void testObtenerEventosPorCiudad() throws EventoException {
          Evento evento = Evento.builder()
                  .nombre("Evento de prueba")
                  .descripcion("Evento de prueba")
                  .poster("https://www.google.com")
                  .imgLocalidades("https://www.google.com")
                  .fecha(new Date(2024, 11, 10))
                  .direccion(Direccion.builder()
                          .departamento("Quindio")
                          .ciudad("Armenia")
                          .barrio("Barrio")
                          .calle("Calle")
                          .numResidencia("123")
                          .build())
                  .listaLocalidades(new ArrayList<>())
                  .build();

          eventoService.crearEvento(evento);

          Evento evento2 = Evento.builder()
                  .nombre("Evento de prueba 2")
                  .descripcion("Evento de prueba 2")
                  .poster("https://www.google.com")
                  .imgLocalidades("https://www.google.com")
                  .fecha(new Date(2024, 11, 10))
                  .direccion(Direccion.builder()
                          .departamento("Quindio")
                          .ciudad("Armenia")
                          .barrio("Barrio")
                          .calle("Calle")
                          .numResidencia("123")
                          .build())
                  .listaLocalidades(new ArrayList<>())
                  .build();

          eventoService.crearEvento(evento2);

         // assertEquals(2, eventoService.obtenerEventosPorCiudad(new Pageable(), "Armenia").size());
     }
}
