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
    private java.sql.Date fechaVenta;
    private String metodoPago;
    private double subtotal;
    private double iva;
    private double total;
    private int usuarioId;
    private List<DetalleFactura> listaDetalles;

    public Factura() {
       
    }
    
    
     public Factura(int id, String cliente, Date fechaVenta, String metodoPago, double subtotal, double iva, double total, int usuarioId) {
        this.id = id;
        this.cliente = cliente;
        this.fechaVenta = fechaVenta;
        this.metodoPago = metodoPago;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
        this.usuarioId = usuarioId; 
        listaDetalles = new ArrayList<>();
    }
    
    public List<DetalleFactura> getListaDetalles() {
        return listaDetalles;
    }

    public void agregarDetalle(DetalleFactura detalle) {
        listaDetalles.add(detalle); 
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

   

    
    public int getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public String getMetodoPago() {
        return metodoPago;
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

    public int getUsuarioId() {
        return usuarioId;
    }
}