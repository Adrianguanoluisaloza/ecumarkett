/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Modelo.DetalleFactura;
import Modelo.Factura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adrian
 */
public class DaoFactura {
    public int registrarFactura(Factura factura) {
        String sql = "INSERT INTO factura (cliente, fecha_venta, metodo_pago, subtotal, iva, total, usuario_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = ConexionBS.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, factura.getCliente());
            stmt.setDate(2, factura.getFechaVenta());
            stmt.setString(3, factura.getMetodoPago());
            stmt.setDouble(4, factura.getSubtotal());
            stmt.setDouble(5, factura.getIva());
            stmt.setDouble(6, factura.getTotal());
            stmt.setInt(7, factura.getUsuarioId());
            int filas = stmt.executeUpdate();
            if (filas > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(1); // ID generado
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al registrar factura: " + e.getMessage());
            e.printStackTrace();
        }
        return -1; // Error
    }
    
    public boolean agregarDetalleFactura(int idFactura, int idProducto, int cantidad, double precio) {
        // Crear un nuevo objeto DetalleFactura con los parámetros dados
        DetalleFactura detalle = new DetalleFactura(idFactura, idProducto, cantidad, precio);
        
        // Preparar la consulta SQL
        String sql = "INSERT INTO detalle_factura (id_factura, id_producto, cantidad, precio, subtotal) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection con = ConexionBS.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            // Establecer los valores en la consulta SQL
            stmt.setInt(1, idFactura);      // Establecer id_factura
            stmt.setInt(2, idProducto);     // Establecer id_producto
            stmt.setInt(3, cantidad);       // Establecer cantidad
            stmt.setDouble(4, precio);      // Establecer precio
            stmt.setDouble(5, cantidad * precio); // Establecer subtotal
            
            // Ejecutar la actualización
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al agregar detalle de factura: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    // Obtener factura por ID
    public Factura obtenerFacturaPorId(int idFactura) {
        String sql = "SELECT * FROM factura WHERE id = ?";
        try (Connection con = ConexionBS.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setInt(1, idFactura);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Factura factura = new Factura();
                    factura.setId(rs.getInt("id"));
                    factura.setCliente(rs.getString("cliente"));
                    factura.setFechaVenta(rs.getDate("fecha_venta"));
                    factura.setMetodoPago(rs.getString("metodo_pago"));
                    factura.setSubtotal(rs.getDouble("subtotal"));
                    factura.setIva(rs.getDouble("iva"));
                    factura.setTotal(rs.getDouble("total"));
                    factura.setUsuarioId(rs.getInt("usuario_id"));
                    return factura;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener factura: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    
    // Obtener todas las facturas
    public List<Factura> obtenerFacturas() {
        List<Factura> facturas = new ArrayList<>();
        String sql = "SELECT * FROM factura ORDER BY fecha_venta DESC";
        
        try (Connection con = ConexionBS.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Factura factura = new Factura();
                factura.setId(rs.getInt("id"));
                factura.setCliente(rs.getString("cliente"));
                factura.setFechaVenta(rs.getDate("fecha_venta"));
                factura.setMetodoPago(rs.getString("metodo_pago"));
                factura.setSubtotal(rs.getDouble("subtotal"));
                factura.setIva(rs.getDouble("iva"));
                factura.setTotal(rs.getDouble("total"));
                factura.setUsuarioId(rs.getInt("usuario_id"));
                facturas.add(factura);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener facturas: " + e.getMessage());
            e.printStackTrace();
        }
        return facturas;
    }
}