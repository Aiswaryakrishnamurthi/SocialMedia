package com.example.demo.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public class StorageService {
    private final Path rootLocation = Paths.get("upload-dir");

    public String store(MultipartFile file) {
        try {
            String filename = file.getOriginalFilename();
            Path destinationFile = this.rootLocation.resolve(
                Paths.get(filename))
                .normalize().toAbsolutePath();
            Files.copy(file.getInputStream(), destinationFile, 
                StandardCopyOption.REPLACE_EXISTING);
            return filename;
        } catch (Exception e) {
            throw new StorageException("Failed to store file", e);
        }
    }
}

