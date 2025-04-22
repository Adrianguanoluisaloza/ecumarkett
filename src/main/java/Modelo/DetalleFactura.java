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
      private String producto;
      
      
    public DetalleFactura(int idFactura, int idProducto, int cantidad, double precio) {
        this.idFactura = idFactura;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = cantidad * precio; // Calcula el subtotal del producto
    }
  public DetalleFactura(String producto, int cantidad, double precio) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        // Calcula el subtotal automáticamente al crear el objeto
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getProducto() {
        return producto;
    }
    
    
    // Getters y Setters
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
        this.subtotal = cantidad * precio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
        this.subtotal = cantidad * precio;
    }

    public double getSubtotal() {
        return subtotal;
    }
}