/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Timestamp;

/**
 *
 * @author Adrian
 */
public class Producto {
    private int id;
    private String usuario_id;
    private String usuario_nombre;
    private String nombre;
    private int cantidad;
    private Double precio;
    private Double total;
    private Timestamp fechaRegistro; // 👈 Nuevo campo

    public Producto(int id, String usuario_id, String usuario_nombre, String nombre, int cantidad, Double precio, Double total, Timestamp fechaRegistro) {
        this.id = id;
        this.usuario_id = usuario_id;
        this.usuario_nombre = usuario_nombre;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
        this.fechaRegistro = fechaRegistro;
    }
    public Producto() {}

    public void setId(int id) {
        this.id = id;
    }

    public void setUsuario_id(String usuario_id) {
        this.usuario_id = usuario_id;
    }

    public void setUsuario_nombre(String usuario_nombre) {
        this.usuario_nombre = usuario_nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getId() {
        return id;
    }

    public String getUsuario_id() {
        return usuario_id;
    }

    public String getUsuario_nombre() {
        return usuario_nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public Double getTotal() {
        return total;
    }

    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

}
   