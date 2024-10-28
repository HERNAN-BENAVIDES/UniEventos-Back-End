package co.edu.uniquindio.unieventosbackend.services;

import co.edu.uniquindio.unieventosbackend.model.documents.Evento;
import co.edu.uniquindio.unieventosbackend.model.documents.Item;
import co.edu.uniquindio.unieventosbackend.model.documents.OrdenCompra;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;


import java.util.HashMap;
import java.util.Map;

/**
 * Servicio para generar reportes en PDF para UniEventos.
 */
@Service
public class ReporteService {

     @Autowired
     private EventoService eventoService;

     @Autowired
     private OrdenCompraService ordenCompraService;

     // Configuración de fuente para el PDF
     private static final Font FUENTE_TITULO = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
     private static final Font FUENTE_CUERPO = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);

     /**
      * Genera un reporte de ventas en formato PDF.
      *
      * @return ByteArrayOutputStream con los datos del PDF.
      * @throws DocumentException Si ocurre un error en la creación del documento PDF.
      * @throws IOException       Si ocurre un error de entrada/salida al generar el PDF.
      */

     public ByteArrayOutputStream generarReporteVenta() throws DocumentException, IOException {
          Document documento = new Document(PageSize.A4);
          ByteArrayOutputStream salida = new ByteArrayOutputStream();
          PdfWriter.getInstance(documento, salida);

          documento.open();
          documento.add(new Paragraph("Reporte de Ventas", FUENTE_TITULO));

          List<Evento> eventos = eventoService.obtenerEventosProximos();
          for (Evento evento : eventos) {
               agregarSeccionReporteEvento(documento, evento);
          }

          documento.close();
          return salida;
     }

     /**
      * Agrega una sección en el documento PDF para un evento específico, incluyendo estadísticas de ventas.
      *
      * @param documento El documento PDF.
      * @param evento    El evento para el cual se genera el reporte.
      * @throws DocumentException Si hay un error en la estructura del documento.
      */

     private void agregarSeccionReporteEvento(Document documento, Evento evento) throws DocumentException {
          documento.add(new Paragraph("Evento: " + evento.getNombre(), FUENTE_CUERPO));
          documento.add(new Paragraph("Ubicación: " + evento.getDireccion(), FUENTE_CUERPO));

          // Tabla para las estadísticas de ventas del evento
          PdfPTable tabla = new PdfPTable(3);
          tabla.setWidthPercentage(100);
          tabla.setSpacingBefore(10f);

          PdfPCell celda = new PdfPCell(new Phrase("Localidad", FUENTE_CUERPO));
          celda.setHorizontalAlignment(Element.ALIGN_CENTER);
          tabla.addCell(celda);

          celda = new PdfPCell(new Phrase("Boletos Vendidos", FUENTE_CUERPO));
          celda.setHorizontalAlignment(Element.ALIGN_CENTER);
          tabla.addCell(celda);

          celda = new PdfPCell(new Phrase("Ingresos", FUENTE_CUERPO));
          celda.setHorizontalAlignment(Element.ALIGN_CENTER);
          tabla.addCell(celda);

          Map<String, LocalidadEstadistica> estadisticasPorLocalidad = new HashMap<>();

          // Obtener todas las órdenes asociadas al evento
          List<OrdenCompra> ordenes = ordenCompraService.obtenerOrdenesByIdEvento(evento.getId());
          for (OrdenCompra orden : ordenes) {
               for (Item item : orden.getListaItems()) {
                    String nombreLocalidad = item.getLocalidad().getNombre();
                    int unidadesVendidas = item.getUnidades();
                    double precioUnidad = item.getLocalidad().getPrecio();

                    // Actualizar o crear estadísticas por localidad
                    estadisticasPorLocalidad
                            .computeIfAbsent(nombreLocalidad, k -> new LocalidadEstadistica())
                            .acumularEstadistica(unidadesVendidas, precioUnidad);
               }
          }

          // Agregar filas a la tabla con los datos acumulados
          for (Map.Entry<String, LocalidadEstadistica> entry : estadisticasPorLocalidad.entrySet()) {
               String nombreLocalidad = entry.getKey();
               LocalidadEstadistica estadistica = entry.getValue();

               tabla.addCell(nombreLocalidad);
               tabla.addCell(String.valueOf(estadistica.getBoletosVendidos()));
               tabla.addCell("$" + estadistica.getIngresosGenerados());
          }

          documento.add(tabla);
     }

     /**
      * Clase auxiliar para acumular estadísticas por localidad.
      */

     @Getter
     private static class LocalidadEstadistica {
          private int boletosVendidos;
          private double ingresosGenerados;

          public void acumularEstadistica(int cantidad, double precio) {
               this.boletosVendidos += cantidad;
               this.ingresosGenerados += cantidad * precio;
          }

     }
}
