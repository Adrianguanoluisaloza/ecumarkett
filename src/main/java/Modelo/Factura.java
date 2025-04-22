/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adrian
 */
public class Factura {
      private int id;
    private String cliente;
    private Date fechaVenta;
    private String metodoPago;
    private double subtotal;
    private double iva;
    private double total;
    private int usuarioId;
    
    public Factura() {
    }
    
    public Factura(String cliente, Date fechaVenta, String metodoPago, double subtotal, double iva, double total, int usuarioId) {
        this.cliente = cliente;
        this.fechaVenta = fechaVenta;
        this.metodoPago = metodoPago;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
        this.usuarioId = usuarioId;
    }
    
    // Getters y setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getCliente() {
        return cliente;
    }
    
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    
    public Date getFechaVenta() {
        return fechaVenta;
    }
    
    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
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
    
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
    public double getIva() {
        return iva;
    }
    
    public void setIva(double iva) {
        this.iva = iva;
    }
    
    public double getTotal() {
        return total;
    }
    
    public void setTotal(double total) {
        this.total = total;
    }
    
    public int getUsuarioId() {
        return usuarioId;
    }
    
    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
}