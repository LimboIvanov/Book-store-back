package com.onlinebookstore.bookstoreback2.controller;

import com.onlinebookstore.bookstoreback2.service.ImageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@AllArgsConstructor
@RequestMapping("/api/images")
@Slf4j
public class ImageController {

    private ImageService imageService;

    @GetMapping("/{imageName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String imageName) {
        try {
            byte[] imageBytes = imageService.getImageBytes(imageName);
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG) // Adjust content type based on your image type
                    .body(imageBytes);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
