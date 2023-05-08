package com.example.demo.Models.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.demo.Models.Entity.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Long>
{
    @Query("SELECT u FROM Usuario u WHERE u.email = ?1")
    Usuario findByEmail(String email);
}
