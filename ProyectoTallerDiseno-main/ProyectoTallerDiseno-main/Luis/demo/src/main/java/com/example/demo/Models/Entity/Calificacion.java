package com.example.demo.Models.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "calficaciones")
public class Calificacion {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_califi;


    // ID_USUARIO_ACALIFICAR (EL QUE ES CALIFICADO)
    @NotNull (message = "Debe contener un valor")
    private Float id_empleado_acali;

    //CALIFICACION CUALITATIVA
    @NotEmpty (message = "Descripción inválido o vacío")
    @Size(min = 4, max = 30)
    private String descrip_califi;


    //CALIFICACION CUANTITATIVA
    @NotNull
    private Float cuanti_califi;

    @ManyToOne
    @JoinColumn
    private Empleado empleado_quecali;

    public Long getId_califi() {
        return id_califi;
    }

    public void setId_califi(Long id_califi) {
        this.id_califi = id_califi;
    }

    public Float getId_empleado_acali() {
        return id_empleado_acali;
    }

    public void setId_empleado_acali(Float id_empleado_acali) {
        this.id_empleado_acali = id_empleado_acali;
    }

    public String getDescrip_califi() {
        return descrip_califi;
    }

    public void setDescrip_califi(String descrip_califi) {
        this.descrip_califi = descrip_califi;
    }

    public Float getCuanti_califi() {
        return cuanti_califi;
    }

    public void setCuanti_califi(Float cuanti_califi) {
        this.cuanti_califi = cuanti_califi;
    }

    public Empleado getEmpleado_quecali() {
        return empleado_quecali;
    }

    public void setEmpleado_quecali(Empleado empleado_quecali) {
        this.empleado_quecali = empleado_quecali;
    }
}
