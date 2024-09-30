package com.example.files.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Directory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonIgnore 
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Directory parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Directory> subdirectories;

    @OneToMany(mappedBy = "directory", cascade = CascadeType.ALL)
    private List<FileEntity> files;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Directory getParent() {
        return parent;
    }

    public void setParent(Directory parent) {
        this.parent = parent;
    }

    public List<Directory> getSubdirectories() {
        return subdirectories;
    }

    public void setSubdirectories(List<Directory> subdirectories) {
        this.subdirectories = subdirectories;
    }

    public List<FileEntity> getFiles() {
        return files;
    }

    public void setFiles(List<FileEntity> files) {
        this.files = files;
    }

    
}
