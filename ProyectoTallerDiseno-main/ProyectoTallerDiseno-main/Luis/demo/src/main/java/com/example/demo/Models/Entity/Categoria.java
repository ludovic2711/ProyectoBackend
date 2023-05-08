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
@Table(name = "categorias")
public class Categoria {
    
//ID
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id_cargo;

//NOMBRE DEL CATEGORIA
@NotEmpty (message = "Nombre de la categoria inválido o vacío")
@Size(min = 4, max = 30)
private String nombre_categoria;

@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
private Set<Premio> categoria;

public Long getId_cargo() {
    return id_cargo;
}

public void setId_cargo(Long id_cargo) {
    this.id_cargo = id_cargo;
}

public String getNombre_categoria() {
    return nombre_categoria;
}

public void setNombre_categoria(String nombre_categoria) {
    this.nombre_categoria = nombre_categoria;
}

public Set<Premio> getCategoria() {
    return categoria;
}

public void setCategoria(Set<Premio> categoria) {
    this.categoria = categoria;
}

}
