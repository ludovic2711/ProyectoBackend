package com.example.demo.Models.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Models.Entity.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado , Long> {
    
}
