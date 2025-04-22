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
        }
        return -1; // Error
    }


 public boolean agregarDetalleFactura(String producto, int cantidad, double precio) {
        // Crear un nuevo objeto DetalleFactura con los parámetros dados
        DetalleFactura detalle = new DetalleFactura(producto, cantidad, precio);
        
        // Preparar la consulta SQL
        String sql = "INSERT INTO detalle_factura (id_factura, id_producto, cantidad, precio, subtotal) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection con = ConexionBS.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            // Asumiendo que 'id_factura' y 'id_producto' son valores que se pueden obtener de otro lado
            // Si 'producto' es el nombre o descripción, necesitarás consultar su id antes de insertarlo
            int idFactura = obtenerIdFactura();  // Este es un ejemplo de cómo podrías obtener el idFactura
            int idProducto = obtenerIdProducto(producto); // Suponiendo que tienes un método para obtener el id del producto
            
            // Establecer los valores en la consulta SQL
            stmt.setInt(1, idFactura);       // Establecer id_factura
            stmt.setInt(2, idProducto);      // Establecer id_producto
            stmt.setInt(3, cantidad);        // Establecer cantidad
            stmt.setDouble(4, precio);       // Establecer precio
            stmt.setDouble(5, cantidad * precio); // Establecer subtotal

            // Ejecutar la actualización
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al agregar detalle de factura: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // Método para obtener el ID de la factura (esto puede depender de tu lógica de negocio)
    private int obtenerIdFactura() {
        // Este es solo un ejemplo, deberías implementar la lógica para obtener el ID de la factura
        return 1; // Retornar un valor de ejemplo
    }

    // Método para obtener el ID de un producto dado el nombre del producto
    private int obtenerIdProducto(String producto) {
        // Este es solo un ejemplo, deberías implementar la lógica para obtener el ID del producto a partir del nombre
        return 1; // Retornar un valor de ejemplo
    }


}