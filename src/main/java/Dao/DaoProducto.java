/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Dao.ConexionBS;
import Modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class DaoProducto {
  public boolean insertarProducto(Producto producto) {
        String sql = "INSERT INTO productos (usuario_id, nombre, Usuario_nombre,  cantidad, precio, total, fecha_registro) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection con = ConexionBS.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, producto.getUsuario_id());
            ps.setString(2, producto.getUsuario_nombre());
            ps.setString(3, producto.getNombre());
            ps.setInt(4, producto.getCantidad());
            ps.setDouble(5, producto.getPrecio());
            ps.setDouble(6, producto.getTotal());
            ps.setTimestamp(7, producto.getFechaRegistro());
            
            int resultado = ps.executeUpdate();
            return resultado > 0;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar producto: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarProducto(Producto producto) {
        String sql = "UPDATE productos SET usuario_id = ?,Usuario_nombre = ?,nombre = ?, cantidad = ?, precio = ?, total = ?, fecha_registro = ? WHERE id = ?";
        
        try (Connection con = ConexionBS.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, producto.getUsuario_id());
            ps.setString(2, producto.getUsuario_nombre());
            ps.setString(3, producto.getNombre());
            ps.setInt(4, producto.getCantidad());
            ps.setDouble(5, producto.getPrecio());
            ps.setDouble(5, producto.getTotal());
            ps.setTimestamp(7, producto.getFechaRegistro());
            ps.setInt(8, producto.getId());
            
            int resultado = ps.executeUpdate();
            return resultado > 0;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar producto: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarProducto(int id) {
        String sql = "DELETE FROM productos WHERE id = ?";
        
        try (Connection con = ConexionBS.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            
            int resultado = ps.executeUpdate();
            return resultado > 0;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar producto: " + e.getMessage());
            return false;
        }
    }

    public List<Producto> consultarProductos() {
        List<Producto> listaProductos = new ArrayList<>();
        String sql = "SELECT * FROM productos";
        
        try (Connection con = ConexionBS.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId(rs.getInt("id"));
                producto.setUsuario_id(rs.getString("usuario_id"));
                producto.setUsuario_nombre(rs.getString("usuario_nombre"));
                producto.setNombre(rs.getString("nombre"));
                producto.setCantidad(rs.getInt("cantidad"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setTotal(rs.getDouble("total"));
                producto.setFechaRegistro(rs.getTimestamp("fecha_registro"));
                listaProductos.add(producto);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar productos: " + e.getMessage());
        }
        
        return listaProductos;
    }

    public Producto obtenerProductoPorId(int id) {
        String sql = "SELECT * FROM productos WHERE id = ?";
        
        try (Connection con = ConexionBS.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Producto producto = new Producto();
                    producto.setId(rs.getInt("id"));
                    producto.setUsuario_id(rs.getString("usuario_id"));
                    producto.setUsuario_nombre(rs.getString("usuario_nombre"));
                    producto.setNombre(rs.getString("nombre"));
                    producto.setCantidad(rs.getInt("cantidad"));
                    producto.setPrecio(rs.getDouble("precio"));
                    producto.setTotal(rs.getDouble("total"));
                    producto.setFechaRegistro(rs.getTimestamp("fecha_registro"));
                    return producto;
                }
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener producto: " + e.getMessage());
        }
        
        return null;
    }

public List<Producto> listarProductos() {
    List<Producto> lista = new ArrayList<>();
    String sql = "SELECT * FROM productos"; // Asegúrate de que tu tabla se llame así

    try (Connection con = ConexionBS.getConnection();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            Producto p = new Producto();
            p.setId(rs.getInt("id"));
            p.setUsuario_id(rs.getString("usuario_id"));
             p.setUsuario_nombre(rs.getString("usuario_nombre"));
            p.setNombre(rs.getString("nombre"));
            p.setCantidad(rs.getInt("cantidad"));
            p.setPrecio(rs.getDouble("precio"));
            p.setFechaRegistro(rs.getTimestamp("fecha_registro"));
            p.setTotal(p.getCantidad() * p.getPrecio()); // O puedes calcularlo automáticamente con setCantidad/setPrecio
            lista.add(p);
        }

    } catch (SQLException e) {
        System.out.println("Error al listar productos: " + e.toString());
    }

    return lista;
}

public void mostrarProductosEnTabla(JTable tabla) {
    DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
    modelo.setRowCount(0); // Limpiar tabla

    DaoProducto dao = new DaoProducto();
    List<Producto> productos = dao.listarProductos();

    for (Producto p : productos) {
        Object[] fila = {
            p.getId(),
            p.getUsuario_id(),
            p.getUsuario_nombre(),
            p.getNombre(),
            p.getCantidad(),
            p.getPrecio(),
            p.getTotal(),
            p.getFechaRegistro()
        };
        modelo.addRow(fila);
    }
}}