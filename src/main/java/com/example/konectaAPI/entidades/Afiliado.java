package com.example.konectaAPI.entidades;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "afiliado")
public class Afiliado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name ="nombre", length = 20, nullable = false)
    private String nombre;
    @Column(name="apellido", length = 30, nullable = false)
    private String apellido;
    @Column(name="documento", length = 10, nullable = false)
    private String documento;
    @Column(name="correo",length = 40, nullable = false)
    private String correo;
    @Column(name="departamento", nullable = false)
    private Integer departmento;
    @Column(name = "ciudad", nullable = false)
    private Integer ciudad;
    @Column(name = "telefono", length = 30, nullable = false)
    private String telefono;
    @Column(name = "fechaNacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    public Afiliado() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getDepartmento() {
        return departmento;
    }

    public void setDepartmento(Integer departmento) {
        this.departmento = departmento;
    }

    public Integer getCiudad() {
        return ciudad;
    }

    public void setCiudad(Integer ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Afiliado(Integer id, String nombre, String apellido, String documento, String correo, Integer departmento, Integer ciudad, String telefono, LocalDate fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.correo = correo;
        this.departmento = departmento;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;

    }
}
