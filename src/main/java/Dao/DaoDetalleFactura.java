/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Dao.ConexionBS;
import Modelo.DetalleFactura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adrian
 */
public class DaoDetalleFactura {
    
public boolean agregarDetallesFactura(int idFactura, List<DetalleFactura> listaDetalles) {
        String sql = "INSERT INTO detalle_factura (id_factura, id_producto, cantidad, precio, subtotal) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = ConexionBS.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            
            // Iterar sobre todos los detalles
            for (DetalleFactura detalle : listaDetalles) {
                // Establecer valores para cada detalle
                stmt.setInt(1, idFactura);
                stmt.setInt(2, detalle.getIdProducto()); // Asumimos que DetalleFactura tiene el idProducto
                stmt.setInt(3, detalle.getCantidad());
                stmt.setDouble(4, detalle.getPrecio());
                stmt.setDouble(5, detalle.getSubtotal());

                // Ejecutar la inserción para cada detalle
                stmt.addBatch();
            }

            // Ejecutar todas las inserciones como un batch
            int[] result = stmt.executeBatch();
            return result.length == listaDetalles.size();
        } catch (SQLException e) {
            System.err.println("Error al agregar detalles a la factura: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }


public List<DetalleFactura> obtenerDetalles(int idFactura) {
        List<DetalleFactura> detalles = new ArrayList<>();
        String sql = "SELECT * FROM detalle_factura WHERE id_factura = ?";
        
        try (Connection con = ConexionBS.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setInt(1, idFactura);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int idProducto = rs.getInt("id_producto");
                    int cantidad = rs.getInt("cantidad");
                    double precio = rs.getDouble("precio");
                    double subtotal = rs.getDouble("subtotal");

                    DetalleFactura detalle = new DetalleFactura(idFactura, idProducto, cantidad, precio);
                    detalles.add(detalle);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener los detalles de la factura: " + e.getMessage());
            e.printStackTrace();
        }
        return detalles;
    }
public boolean eliminarDetalle(int idFactura, int idProducto) {
        String sql = "DELETE FROM detalle_factura WHERE id_factura = ? AND id_producto = ?";

        try (Connection con = ConexionBS.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setInt(1, idFactura);
            stmt.setInt(2, idProducto);
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar detalle de la factura: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public void agregarDetalle(DetalleFactura detalle) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}