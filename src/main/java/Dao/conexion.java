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
public class conexion {
   
     Connection con;
    String bd="inventario2";
    String url="jdbc:mysql://localhost/"+bd;
    String user="root";
    String pass="";
    
    public Connection conectar(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showConfirmDialog(null, e);
        }
        return con;
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
    
    
    
    
    
    
    
   
   