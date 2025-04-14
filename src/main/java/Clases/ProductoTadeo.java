/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author tadeo
 */
public class ProductoTadeo {
    
    private String usuario;
    private String nombre;
    private int cantidad;
    private Double precio;
    private Double total;

    public ProductoTadeo(String usuario,String nombre, int cantidad, Double precio) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
   
    public Double Total(){
    Double total=cantidad*precio;
       return total; 
    }
    
    
    
}
