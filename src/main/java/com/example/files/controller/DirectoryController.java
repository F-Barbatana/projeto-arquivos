package com.example.files.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.Optional;

import com.example.files.entity.Directory;
import com.example.files.repository.DirectoryRepository;

import java.util.List;

@RestController
@RequestMapping("/api/directories")
@CrossOrigin(origins = "http://localhost:3000")
public class DirectoryController {

    private final DirectoryRepository directoryRepository;

    public DirectoryController(DirectoryRepository directoryRepository) {
        this.directoryRepository = directoryRepository;
    }

    @GetMapping
    public List<Directory> listDirectories(@RequestParam(required = false) Long parentId) {
        if (parentId != null) {
            return directoryRepository.findByParentId(parentId);
        } else {
            return directoryRepository.findAll();
        }
    }

    @PostMapping
    public ResponseEntity<Directory> createDirectory(@RequestBody Directory directory) {
        if (directory.getParent() != null && directory.getParent().getId() != null) {
            Optional<Directory> parentDir = directoryRepository.findById(directory.getParent().getId());
            parentDir.ifPresent(directory::setParent);
        }
        Directory savedDirectory = directoryRepository.save(directory);
        return ResponseEntity.ok(savedDirectory);
    }

    @DeleteMapping("/{id}")
    public void deleteDirectory(@PathVariable Long id) {
        directoryRepository.deleteById(id);
    }
}