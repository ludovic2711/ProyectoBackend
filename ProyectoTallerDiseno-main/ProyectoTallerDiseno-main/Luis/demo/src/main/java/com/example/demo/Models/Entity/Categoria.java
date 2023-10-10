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
private Long id_categoria;

//NOMBRE DEL CATEGORIA
@NotEmpty (message = "Nombre de la categoria inválido o vacío")
@Size(min = 4, max = 30)
private String nombre_categoria;

// @NotEmpty (message = "Descipcion de la categoria inválido o vacío")
// @Size(min = 4, max = 30)
// private String descripcion_categoria;

// @NotEmpty (message = "Descipcion de la categoria inválido o vacío")
// @Size(min = 4, max = 30)
// private String proveedores_categoria;


@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
private Set<Premio> categoria;

public Long getId_categoria() {
    return id_categoria;
}

// public String getDescripcion_categoria() {
//     return descripcion_categoria;
// }

// public void setDescripcion_categoria(String descripcion_categoria) {
//     this.descripcion_categoria = descripcion_categoria;
// }

// public String getProveedores_categoria() {
//     return proveedores_categoria;
// }

// public void setProveedores_categoria(String proveedores_categoria) {
//     this.proveedores_categoria = proveedores_categoria;
// }

public void setId_categoria(Long id_categoria) {
    this.id_categoria = id_categoria;
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
