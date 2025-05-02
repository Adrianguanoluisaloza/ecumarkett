/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Adrian
 */
public class ConexionBS {
   
     private static final String URL = "jdbc:mysql://localhost:3306/ecumarkett"; // Cambia el nombre de la base de datos si es necesario
    private static final String USUARIO = "root"; // Tu usuario de MySQL
    private static final String PASSWORD = "";    // Tu contraseña de MySQL si tienes

    // Método estático para obtener una conexión a la base de datos

    public static Connection getConnection() throws SQLException {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // Registramos el driver
            con = DriverManager.getConnection(URL, USUARIO, PASSWORD);  // Conexión a la base de datos
            System.out.println("✅ Conexión exitosa a la base de datos");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos:\n" + e.getMessage());
        }
        return con;  // Retorna la conexión
    }

    public static Connection conectar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}


    /*
      private static final String URL = "jdbc:mysql://localhost:3306/ecumarket";
    private static final String USUARIO = "root";  // Cambia si tu usuario es distinto
    private static final String CONTRASEÑA = "";   // Y pon tu contraseña si tienes

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

    Solo para probar que conecta correctamente
    
    }
}
    */
    
    
    
    
    
    
    
   
   