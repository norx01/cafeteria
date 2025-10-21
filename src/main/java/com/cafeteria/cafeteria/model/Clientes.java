package com.cafeteria.cafeteria.model;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes")
public class Clientes
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_clientes;
    private String nombre;
    private String cedula;
    private String correo;
    private Integer edad;
    private String clasificacion;

    public Long getId_clientes() {
        return id_clientes;
    }

    public void setId_clientes(Long id_clientes) {
        this.id_clientes = id_clientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }
}
