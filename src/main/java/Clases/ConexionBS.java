/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Adrian
 */
public class ConexionBS {

    static Connection conectar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   public class ConexionDB {
   private static final String URL = "jdbc:mysql://localhost:3306/ecumarket";
    private static final String USUARIO = "root";  // Cambia si tienes otro usuario en MySQL
    private static final String CONTRASEÑA = ""; 
 public static Connection conectar() {
        try {
            Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
            System.out.println("✅ Conexión exitosa a la base de datos");
            return conn;
        } catch (SQLException e) {
            System.out.println("❌ Error de conexión: " + e.getMessage());
            return null;
        }
    }

    // Método para probar la conexión
    public static void main(String[] args) {
        ConexionDB.conectar();
    }
   }
}


