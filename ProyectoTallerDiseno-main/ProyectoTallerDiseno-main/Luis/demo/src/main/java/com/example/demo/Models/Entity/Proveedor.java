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
@Table(name = "proveedores")

public class Proveedor {

    //ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_prov;

    //NOMBRE DEL CARGO
    @NotEmpty (message = "Nombre del proveedor inválido o vacío")
    @Size(min = 4, max = 30)
    private String nombre_prov;
    

    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL)
    private Set<Premio> proveedor;


    public Long getId_prov() {
        return id_prov;
    }


    public void setId_prov(Long id_prov) {
        this.id_prov = id_prov;
    }


    public String getNombre_prov() {
        return nombre_prov;
    }


    public void setNombre_prov(String nombre_prov) {
        this.nombre_prov = nombre_prov;
    }


    public Set<Premio> getProveedor() {
        return proveedor;
    }


    public void setProveedor(Set<Premio> proveedor) {
        this.proveedor = proveedor;
    }


}
