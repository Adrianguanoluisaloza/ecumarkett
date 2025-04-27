/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Modelo.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Adrian
 */
public class DaoCategoria {
     // Método para registrar categorías
    public boolean guardar(Categoria objeto) {
        boolean respuesta = false;
        
        try (Connection cn = ConexionBS.getConnection()) {  
            String sql = "INSERT INTO tb_categoria (descripcion, estado) VALUES (?, ?)";
            PreparedStatement consulta = cn.prepareStatement(sql);
            
            consulta.setString(1, objeto.getDescripcion());
            consulta.setInt(2, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            
        } catch (SQLException e) {  
            System.out.println("❌ Error al guardar categoría: " + e.getMessage());
        }
        
        return respuesta;
    }
    
   // Método para verificar si ya existe una categoría
    public boolean existeCategoria(String categoria) {
        boolean respuesta = false;
        String sql = "SELECT idCategoria FROM tb_categoria WHERE descripcion = ?";
        
        try (Connection cn = ConexionBS.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setString(1, categoria);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                respuesta = true; // Existe la categoría
            }
            
        } catch (SQLException e) {
            System.out.println("❌ Error al consultar categoría: " + e.getMessage());
        }

        return respuesta;
    }
    
        // Nuevo método: Guardar categoría solo si no existe
    public boolean guardarCategoriaSiNoExiste(Categoria objeto) {
        if (existeCategoria(objeto.getDescripcion())) {
            System.out.println("⚠️ La categoría '" + objeto.getDescripcion() + "' ya existe en la base de datos.");
            return false;
        } else {
            return guardar(objeto);
        }
    }

    
}
    
