package com.example.files.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.files.entity.FileEntity;

public interface FileRepository extends JpaRepository<FileEntity, Long> {

    List<FileEntity> findByDirectoryId(Long directoryId);
}