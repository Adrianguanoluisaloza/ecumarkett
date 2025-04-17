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
       public boolean registrarUsuario(String correo, String contraseña, String nombrecompleto, int telefono, String ciudad) {
        String sql = "INSERT INTO usuarios (correo, contraseña, nombrecompleto, telefono, ciudad) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBS.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, correo);
            stmt.setString(2, contraseña);
            stmt.setString(3, nombrecompleto);
            stmt.setInt(4, telefono);
            stmt.setString(5, ciudad);
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al registrar usuario: " + e.getMessage());
            e.printStackTrace(); // Para depuración en consola
            return false;
        }
    
    }

    
public String validarLogin(String correo, String contraseña) {
    String sql = "SELECT * FROM usuarios WHERE correo = ? AND contraseña = ?";
    
    try (Connection conn = ConexionBS.conectar();
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

