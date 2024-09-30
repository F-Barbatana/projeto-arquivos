package com.example.files.controller;

import org.springframework.web.bind.annotation.*;
import com.example.files.entity.Directory;
import com.example.files.exception.ResourceNotFoundException;
import com.example.files.repository.DirectoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.files.entity.FileEntity;
import com.example.files.repository.FileRepository;

import java.util.List;

@RestController
@RequestMapping("/api/file")
@CrossOrigin(origins = "http://localhost:3000")
public class FileController {

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private DirectoryRepository directoryRepository;

    public FileController(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @GetMapping
    public List<FileEntity> listFiles(@RequestParam Long directoryId) {
        return fileRepository.findByDirectoryId(directoryId);
    }

    @PostMapping
    public FileEntity createFile(String fileName, Long directoryId) {

        if (directoryRepository.findById(directoryId) == null) {
            throw new IllegalArgumentException("O ID do arquivo não pode ser nulo");
        }

        Directory directory = directoryRepository.findById(directoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Directory not found"));
    
                
                FileEntity file = new FileEntity();
        file.setName(fileName);
        file.setDirectory(directory);
    
        return fileRepository.save(file);
    }

    @DeleteMapping("/{id}")
    public void deleteFile(@PathVariable Long id) {
        fileRepository.deleteById(id);
    }
}