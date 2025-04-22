/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Adrian
 */

public class DaoUsuario {
   
    public boolean registrarUsuario(String usuario,String correo, String contraseña, String nombrecompleto, int telefono, String ciudad) {
        String sql = "INSERT INTO usuarios (usuario, correo, contraseña, nombrecompleto, telefono, ciudad) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario);
            stmt.setString(2, correo);
            stmt.setString(3, contraseña);
            stmt.setString(4, nombrecompleto);
            stmt.setInt(5, telefono);
            stmt.setString(6, ciudad);
              return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al registrar usuario: " + e.getMessage());
            e.printStackTrace(); // Para depuración en consola
            return false;
        }
    
    }


    public String validarLogin(String correo, String contraseña) {
    String sql = "SELECT * FROM usuarios WHERE correo = ? AND contraseña = ?";
    
    try (Connection conn = ConexionBS.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, correo.trim());
        stmt.setString(2, contraseña.trim());

        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                String nombreCompleto = rs.getString("nombrecompleto");
                System.out.println("✅ Login exitoso. Usuario: " + nombreCompleto);
                return nombreCompleto;
            } else {
                System.out.println("❌ Correo o contraseña incorrectos");
                return null;
            }
        }

    } catch (SQLException e) {
        System.err.println("❗ Error al validar login: " + e.getMessage());
        e.printStackTrace();
        return null;
    }
}
}