package co.edu.uniquindio.unieventosbackend.controllers;
import co.edu.uniquindio.unieventosbackend.services.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class ImagenController {

    @Autowired
    private CloudinaryService cloudinaryService;

    /**
     * Endpoint para cargar una imagen y obtener su URL pública.
     *
     * @param file Archivo de imagen.
     * @return URL pública de la imagen.
     */
    @PostMapping("/upload-image")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            String imageUrl = cloudinaryService.uploadImage(file);
            return ResponseEntity.ok(imageUrl);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error al subir la imagen");
        }
    }
}

