package Dao;

import Modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DaoProducto {
public boolean insertarProducto(Producto p) {
        String sql = "INSERT INTO productos (usuario_id, nombre, usuario_nombre, cantidad, precio, total, fecha_registro) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = ConexionBS.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getUsuario_id());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getUsuario_nombre());
            ps.setInt(4, p.getCantidad());
            ps.setDouble(5, p.getPrecio());
            ps.setDouble(6, p.getTotal());
            ps.setTimestamp(7, p.getFechaRegistro());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar producto: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarProducto(Producto producto) {
        String sql = "UPDATE productos SET usuario_id = ?, usuario_nombre = ?, nombre = ?, cantidad = ?, precio = ?, total = ?, fecha_registro = ? WHERE id = ?";

        try (Connection con = ConexionBS.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, producto.getUsuario_id());
            ps.setString(2, producto.getUsuario_nombre());
            ps.setString(3, producto.getNombre());
            ps.setInt(4, producto.getCantidad());
            ps.setDouble(5, producto.getPrecio());
            ps.setDouble(6, producto.getTotal());
            ps.setTimestamp(7, producto.getFechaRegistro());
            ps.setInt(8, producto.getId());

            return ps.executeUpdate() > 0;

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
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar producto: " + e.getMessage());
            return false;
        }
    }

    public List<Producto> consultarProductos() {
        List<Producto> listaProductos = new ArrayList<>();
        // Modificada la consulta para obtener datos correctamente
        String sql = "SELECT p.id, p.usuario_id, p.usuario_nombre, p.nombre, p.cantidad, p.precio, p.total, p.fecha_registro " +
                     "FROM productos p";

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
            e.printStackTrace();
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
            e.printStackTrace();
        }

        return null;
    }
 
}