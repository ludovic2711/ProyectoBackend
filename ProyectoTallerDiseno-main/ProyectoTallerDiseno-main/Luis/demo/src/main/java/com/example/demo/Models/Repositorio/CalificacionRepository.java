package com.example.demo.Models.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Models.Entity.Calificacion;

public interface CalificacionRepository extends  JpaRepository<Calificacion , Long> {
    
}
