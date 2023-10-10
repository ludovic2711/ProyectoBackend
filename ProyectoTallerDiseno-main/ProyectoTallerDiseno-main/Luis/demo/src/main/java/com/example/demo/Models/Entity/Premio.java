package com.example.demo.Models.Entity;

import java.util.Date;

// import java.sql.Date; //ESTO DE PRONTO PUEDE AFECTAR

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
// import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.apache.tomcat.jni.User;
import org.springframework.format.annotation.DateTimeFormat;
// import org.springframework.lang.NonNull;

@Entity
@Table(name = "premios")

public class Premio {

    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_prem;


    // FECHA DE NACIMIENTO
    @Column(name = "fec_entrega_prem") // @Column para definir el nombre de la columna.
    @Temporal(TemporalType.DATE) // Para determinar si el atributo almacena Hora, fecha o fecha y hora (.Date
                                 // .Time .Timestamp)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "Fecha invalida") // ESTO SE PUSO CON FUTURE
    
    private Date fec_entrega_prem;

    // PROVEEDOR
    @ManyToOne
    @JoinColumn
    private Proveedor proveedor;

    // CATEGORIA
    @ManyToOne
    @JoinColumn
    private Categoria categoria;

     // ID_EMPLEADO_A_ENTREGAR
    @ManyToOne
    @JoinColumn
    private Usuario usuario;

    public Long getId_prem() {
        return id_prem;
    }

    public void setId_prem(Long id_prem) {
        this.id_prem = id_prem;
    }

    public Date getFec_entrega_prem() {
        return fec_entrega_prem;
    }

    public void setFec_entrega_prem(Date fec_entrega_prem) {
        this.fec_entrega_prem = fec_entrega_prem;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }


    
}
