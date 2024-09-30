package com.example.files.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.files.entity.Directory;

public interface DirectoryRepository extends JpaRepository<Directory, Long> {

    List<Directory> findByParentId(Long parentId);


}

