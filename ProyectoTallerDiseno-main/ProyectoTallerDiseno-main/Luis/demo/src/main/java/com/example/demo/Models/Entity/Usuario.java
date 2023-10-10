package com.example.demo.Models.Entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
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
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity // entidad que va a estar conectada a los datos
@Table(name = "usuarios") // Nombre de la tabla en la base de datos

public class Usuario {

    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;

    // EMAIL
    @Email
    private String email;

    // PASSWORD
    private String Password;

    // NOMBRE
    @NotEmpty(message = "Nombre invalido o vacío")
    @Size(min = 4, max = 30)
    private String Nombre;

    // APELLIDO
    @NotEmpty(message = "Apellido invalido o vacío")
    @Size(min = 4, max = 30)
    private String Apellido;

    // FECHA DE NACIMIENTO
    @Column(name = "fec_nac") // @Column para definir el nombre de la columna.
    @Temporal(TemporalType.DATE) // Para determinar si el atributo almacena Hora, fecha o fecha y hora (.Date
                                 // .Time .Timestamp)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    // @Future(message = "Fecha invalida") 
    // ESTO SE PUSO CON FUTURE
    private Date fec_nac;

    // PARA PREMIO
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Set<Premio> usuario;

    // PARA CALIFICACION
    @OneToMany(mappedBy = "usuario_quecali", cascade = CascadeType.ALL)
    private Set<Calificacion> user_quecali;

        // CARGO
        @ManyToOne
        @JoinColumn
        private Cargo cargo;



    public Cargo getCargo() {
            return cargo;
        }

        public void setCargo(Cargo cargo) {
            this.cargo = cargo;
        }

    //GETTER AND SETTER
    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public Date getFec_nac() {
        return fec_nac;
    }

    public void setFec_nac(Date fec_nac) {
        this.fec_nac = fec_nac;
    }

    public Set<Premio> getUsuario() {
        return usuario;
    }

    public void setUsuario(Set<Premio> usuario) {
        this.usuario = usuario;
    }

    public Set<Calificacion> getUser_quecali() {
        return user_quecali;
    }

    public void setUser_quecali(Set<Calificacion> user_quecali) {
        this.user_quecali = user_quecali;
    }

    // //PARA EMPLEADO
    // @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    // private Set<Empleado> user;


}
