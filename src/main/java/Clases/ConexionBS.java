package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBS {
    
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

    // Solo para probar que conecta correctamente
    public static void main(String[] args) {
        conectar();
    }
}
