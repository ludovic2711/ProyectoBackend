package com.example.demo.Models.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Models.Entity.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long>{
    
}
