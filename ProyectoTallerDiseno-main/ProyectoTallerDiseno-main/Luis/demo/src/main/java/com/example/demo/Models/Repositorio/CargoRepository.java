package com.example.demo.Models.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Models.Entity.Cargo;

public interface CargoRepository extends JpaRepository<Cargo , Long> {
    
}
