package com.onlinebookstore.bookstoreback2.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImageService {

    private static final String IMAGE_DIRECTORY = "C:/Users/konta/IdeaProjects/book-store-back2/src/main/java/com/onlinebookstore/bookstoreback2/image/";

    public byte[] getImageBytes(String imageName) throws IOException {
        Path imagePath = Paths.get(IMAGE_DIRECTORY + imageName);
        return Files.readAllBytes(imagePath);
    }
}