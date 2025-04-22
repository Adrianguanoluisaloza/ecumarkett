/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Adrian
 */
public class DetalleFactura {
  private int idFactura;
    private int idProducto;
    private int cantidad;
    private double precio;
    private double subtotal;
    private String nombreProducto; // Para mostrar en reportes/UI
    
    public DetalleFactura() {
    }
    
    public DetalleFactura(int idFactura, int idProducto, int cantidad, double precio) {
        this.idFactura = idFactura;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = cantidad * precio;
    }
    
    // Sobrecarga para la versión que usa el nombre de producto en lugar del ID
    public DetalleFactura(String nombreProducto, int cantidad, double precio) {
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = cantidad * precio;
    }
    
    // Getters y setters
    public int getIdFactura() {
        return idFactura;
    }
    
    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }
    
    public int getIdProducto() {
        return idProducto;
    }
    
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    
    public int getCantidad() {
        return cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        this.subtotal = this.cantidad * this.precio;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public void setPrecio(double precio) {
        this.precio = precio;
        this.subtotal = this.cantidad * this.precio;
    }
    
    public double getSubtotal() {
        return subtotal;
    }
    
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
    public String getNombreProducto() {
        return nombreProducto;
    }
    
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
}
