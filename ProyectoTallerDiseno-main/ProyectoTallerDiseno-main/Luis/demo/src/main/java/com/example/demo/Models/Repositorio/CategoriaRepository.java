package com.example.demo.Models.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Models.Entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria , Long> {
    
}
