/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Personal
 */
public class Facturacion {
    private String Cliente;
    private String fechaVenta;
    private String producto;
    private int cantidad;
    private double precio;
    private String metodoPago;
    
     private double subtotal;
    private double iva;
    private double total;

    public Facturacion(String cliente, String fechaVenta, String producto, int cantidad, double precio, String metodoPago) {
        this.Cliente = cliente;
        this.fechaVenta = fechaVenta;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.metodoPago = metodoPago;

        calcularTotales();
    }
     private void calcularTotales() {
        this.subtotal = this.precio * this.cantidad;
        this.iva = this.subtotal * 0.12; 
        this.total = this.subtotal + this.iva;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String cliente) {
        this.Cliente = cliente;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        calcularTotales();
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
        calcularTotales();
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getIva() {
        return iva;
    }

    public double getTotal() {
        return total;
    }
}
