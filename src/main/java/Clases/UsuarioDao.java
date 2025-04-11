/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Adrian
 */
public class UsuarioDao {
      public boolean registrarUsuario(String usuario, String contraseña, String tipo, String nombre, String ciudad, String productos) {
        String sql = "INSERT INTO usuarios (usuario, contraseña, tipo, nombre, ciudad, productos) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBS.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario);
            stmt.setString(2, contraseña);
            stmt.setString(3, tipo);
            stmt.setString(4, nombre);
            stmt.setString(5, ciudad);
            stmt.setString(6, productos);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al registrar usuario: " + e.getMessage());
            e.printStackTrace(); // Para depuración en consola
            return false;
        }
    }

    
  public String validarLogin(String usuario, String contraseña) {
    String sql = "SELECT productos FROM usuarios WHERE usuario = ? AND contraseña = ?";
    try (Connection conn = ConexionBS.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, usuario);
        stmt.setString(2, contraseña);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            String productos = rs.getString("productos");
            System.out.println("Productos encontrados: " + productos);
            return productos;
        }
        System.out.println("Usuario no encontrado");
        return null;
    } catch (SQLException e) {
        System.err.println("Error al validar login: " + e.getMessage());
        e.printStackTrace();
        return null;
    }
}
}

