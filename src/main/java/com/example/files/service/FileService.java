package com.example.files.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.files.entity.FileEntity;
import com.example.files.repository.FileRepository;

@Service
public class FileService {

    private final FileRepository fileRepository;

    @Autowired
    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public FileEntity createFile(FileEntity file) {
        return fileRepository.save(file);
    }

    public List<FileEntity> getAllFiles() {
        return fileRepository.findAll();
    }

    public Optional<FileEntity> getFileById(Long id) {
        return fileRepository.findById(id);
    }

    public FileEntity updateFile(Long id, FileEntity updatedFile) {
        updatedFile.setId(id);
        return fileRepository.save(updatedFile);
    }

    public void deleteFile(Long id) {
        fileRepository.deleteById(id);
    }
}
