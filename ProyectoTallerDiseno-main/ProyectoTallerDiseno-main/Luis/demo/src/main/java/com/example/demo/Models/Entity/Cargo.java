package com.example.demo.Models.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name = "cargos")
public class Cargo {
    
//ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cargo;

//NOMBRE DEL CARGO
    @NotEmpty (message = "Nombre del cargo inválido o vacío")
    @Size(min = 4, max = 30)
    private String nombre_cargo;

    @OneToMany(mappedBy = "cargo", cascade = CascadeType.ALL)
    private Set<Empleado> cargo;

    public Long getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(Long id_cargo) {
        this.id_cargo = id_cargo;
    }

    public String getNombre_cargo() {
        return nombre_cargo;
    }

    public void setNombre_cargo(String nombre_cargo) {
        this.nombre_cargo = nombre_cargo;
    }

    public Set<Empleado> getCargo() {
        return cargo;
    }

    public void setCargo(Set<Empleado> cargo) {
        this.cargo = cargo;
    }
}
