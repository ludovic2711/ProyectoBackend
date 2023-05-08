package com.example.demo.Models.Entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;

// import java.sql.Date; //esto se supone que es  para la fecha, lo tengo que investigar

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
// import org.springframework.lang.NonNull;

@Entity
@Table(name = "empleados")
public class Empleado {

    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    // NOMBRE
    @NotEmpty(message = "Nombre invalido")
    @Size(min = 4, max = 30)
    private String nombre;

    // FECHA DE NACIMIENTO
    @Column(name = "fec_nac") // @Column para definir el nombre de la columna.
    @Temporal(TemporalType.DATE) // Para determinar si el atributo almacena Hora, fecha o fecha y hora (.Date
                                 // .Time .Timestamp)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future(message = "Fecha invalida") // ESTO SE PUSO CON FUTURE
    private Date fec_nac;

    // CARGO
    @ManyToOne
    @JoinColumn
    private Cargo cargo;

    //PARA PREMIO
    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL)
    private Set<Premio> empleado;

    //PARA CALIFICACION
    @OneToMany(mappedBy = "empleado_quecali", cascade = CascadeType.ALL)
    private Set<Calificacion> empleado_quecali;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFec_nac() {
        return fec_nac;
    }

    public void setFec_nac(Date fec_nac) {
        this.fec_nac = fec_nac;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Set<Premio> getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Set<Premio> empleado) {
        this.empleado = empleado;
    }

    public Set<Calificacion> getEmpleado_quecali() {
        return empleado_quecali;
    }

    public void setEmpleado_quecali(Set<Calificacion> empleado_quecali) {
        this.empleado_quecali = empleado_quecali;
    }

    

}
