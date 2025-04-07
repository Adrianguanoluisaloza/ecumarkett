/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ecumarket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Adrian
 */
public class UsuarioDAO {
 // Método para agregar un nuevo usuario
   public static boolean registrarUsuario(Usuario usuario) {
    String sql = "INSERT INTO usuarios (idUsuario, usuario, contraseña, nombre, tipo_usuario) VALUES (?, ?, ?, ?, ?)";
    try (Connection con = ConexionDB.getConexion();
         PreparedStatement stmt = con.prepareStatement(sql)) {

        // Usamos setInt para el campo idUsuario porque es un tipo de dato entero (int)
        stmt.setInt(1, usuario.getIdUsuario());
        
        // Usamos setString para los otros campos, ya que son de tipo String
        stmt.setString(2, usuario.getUsuario());
        stmt.setString(3, usuario.getContrasena()); // Cambio de 'contraseÃ±a' a 'contraseña'
        stmt.setString(4, usuario.getNombre());
        stmt.setString(5, usuario.getTipoUsuario()); // "cliente" o "vendedor"

        int filasInsertadas = stmt.executeUpdate();
        return filasInsertadas > 0;

    } catch (SQLException e) {
        System.out.println("Error al registrar usuario: " + e.getMessage());
        return false;
    }
}



    // Método para verificar el login de un usuario
    public static Usuario verificarLogin(String usuario, String contraseña) {
    String sql = "SELECT * FROM usuarios WHERE usuario = ? AND contraseña = ?";
    try (Connection con = ConexionDB.getConexion();
         PreparedStatement stmt = con.prepareStatement(sql)) {

        stmt.setString(1, usuario);
        stmt.setString(2, contraseña);

        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                // Ahora obtienes el idUsuario y correo también
                int idUsuario = rs.getInt("idUsuario");
                String nombre = rs.getString("nombre");
                String correo = rs.getString("correo");
                String tipoUsuario = rs.getString("tipo_usuario");

                // Ahora puedes usar el constructor que toma todos estos parámetros
                return new Usuario(idUsuario, nombre, correo, contraseña, tipoUsuario);
            }
        }

    } catch (SQLException e) {
        System.out.println("Error al verificar login: " + e.getMessage());
    }
    return null; // Si no se encuentra el usuario
}


    // Método para obtener un usuario por su ID
   public static Usuario obtenerUsuarioPorID(int id) {
    String sql = "SELECT * FROM usuarios WHERE idUsuario = ?";
    try (Connection con = ConexionDB.getConexion();
         PreparedStatement stmt = con.prepareStatement(sql)) {

        stmt.setInt(1, id);

        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                // Obtener todos los campos necesarios
                int idUsuario = rs.getInt("idUsuario");
                String usuario = rs.getString("usuario");
                String contraseña = rs.getString("contraseña");
                String nombre = rs.getString("nombre");
                String correo = rs.getString("correo");
                String tipoUsuario = rs.getString("tipo_usuario");

                // Crear y devolver el usuario con todos los datos
                return new Usuario(idUsuario, nombre, correo, contraseña, tipoUsuario);
            }
        }

    } catch (SQLException e) {
        System.out.println("Error al obtener usuario por ID: " + e.getMessage());
    }
    return null;
}


    // Método para actualizar datos de un usuario
    public static boolean actualizarUsuario(Usuario usuario) {
    String sql = "UPDATE usuarios SET nombre = ?, tipo_usuario = ?, correo = ? WHERE usuario = ?";
    try (Connection con = ConexionDB.getConexion();
         PreparedStatement stmt = con.prepareStatement(sql)) {

        // Aquí debes asegurarte de que todos los campos sean pasados correctamente
        stmt.setString(1, usuario.getNombre());
        stmt.setString(2, usuario.getTipoUsuario());
        stmt.setString(3, usuario.getCorreo()); // Agregar correo para la actualización
        stmt.setString(4, usuario.getCorreo()); // Usamos el correo para buscar el usuario

        int filasActualizadas = stmt.executeUpdate();
        return filasActualizadas > 0;

    } catch (SQLException e) {
        System.out.println("Error al actualizar usuario: " + e.getMessage());
        return false;
    }
}


    // Método para eliminar un usuario
    public static boolean eliminarUsuario(String usuario) {
        String sql = "DELETE FROM usuarios WHERE usuario = ?";
        try (Connection con = ConexionDB.getConexion();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, usuario);
            int filasEliminadas = stmt.executeUpdate();
            return filasEliminadas > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario: " + e.getMessage());
            return false;
        }
    }
}