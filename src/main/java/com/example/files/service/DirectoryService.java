package com.example.files.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.files.entity.Directory;
import com.example.files.repository.DirectoryRepository;

import java.util.List;


@Service
public class DirectoryService {

    private final DirectoryRepository directoryRepository;

    @Autowired
    public DirectoryService(DirectoryRepository directoryRepository) {
        this.directoryRepository = directoryRepository;
    }

    public Directory createDirectory(Directory directory) {
        return directoryRepository.save(directory);
    }

    public List<Directory> getAllDirectories() {
        return directoryRepository.findAll();
    }

    public java.util.Optional<Directory> getDirectoryById(Long id) {
        return directoryRepository.findById(id);
    }

    public Directory updateDirectory(Long id, Directory updatedDirectory) {
        updatedDirectory.setId(id);
        return directoryRepository.save(updatedDirectory);
    }

    public void deleteDirectory(Long id) {
        directoryRepository.deleteById(id);
    }
}