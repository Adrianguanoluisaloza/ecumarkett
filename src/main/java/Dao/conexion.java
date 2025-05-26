/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;

/**
 *
 * @author Adrian
 */
public class conexion {
    
    
    // esta solo debe desactivarse y importar en xammpp el sql inventario2 son las mismas credenciales
    
/*
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
    
    
    //no necesita el sql ya que esta en la nube solo sacarla de 
    //los comentarios para activar sin xampp y usa las mismas contrase 
   // que en la imagen de credenciales que esta en la base de datos profe
    
*/
   private static Connection con = null;


    private static final String URL = "jdbc:mysql://b2fyxxnnwq3jd6bcmoon-mysql.services.clever-cloud.com:3306/b2fyxxnnwq3jd6bcmoon?useSSL=false&serverTimezone=UTC";
    private static final String USER = "u2qkvyt5gmlaoylr";
    private static final String PASS = "inGRkmpBdbW7qYuRRdBV";

     public static Connection conectar() {
        if (con == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(URL, USER, PASS);
                System.out.println("Conectado a la base de datos en la nube correctamente.");
               mantenerConexionViva(); 
            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, " Error de conexión: " + e.getMessage());
            }
        } else {
            System.out.println(" Reutilizando conexión existente.");
        }
        return con;
        
        
        
    }
private static void mantenerConexionViva() {
        Timer timer= new Timer(true);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    if (con != null && !con.isClosed()) {
                        Statement stmt = con.createStatement();
                        stmt.executeQuery("SELECT 1");
                        stmt.close();
                        System.out.println(" Ping enviado para mantener la conexión activa.");
                    }
                } catch (SQLException e) {
                    System.out.println("️ Error de ping: " + e.getMessage());
                }
            }
        }, 0, 240000);
    }
}
   /* 
 // conexion multiple que hace explotar la base de datos
    
    Connection con;

    // 🔄 Datos de conexión a la base en la nube
    String url = "jdbc:mysql://b2fyxxnnwq3jd6bcmoon-mysql.services.clever-cloud.com:3306/Ecumarket=false&serverTimezone=UTC";
    String user = "u2qkvyt5gmlaoylr";
    String pass = "inGRkmpBdbW7qYuRRdBV";  // 👈 Reemplaza esto por tu contraseña real

    public Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("✅ Conectado a la base de datos en la nube correctamente.");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error de conexión: " + e.getMessage());
        }
        return con;
    }
}*/
    

  
 
 /*

   
     private static Connection con = null;
    private static final String URL = "jdbc:mysql://sql10.freesqldatabase.com:3306/sql10779437?useSSL=false&serverTimezone=UTC";
    private static final String USER = "sql10779437";
    private static final String PASS = "ZMwAAPfV5Q";
    
  

    public static Connection conectar() {
        if (con == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(URL, USER, PASS);
                System.out.println("✅ Conectado a la base de datos en la nube correctamente.");
                mantenerConexionViva(); // 🔄 Inicia ping
            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, "❌ Error de conexión: " + e.getMessage());
            }
        } else {
            System.out.println("🔁 Reutilizando conexión existente.");
        }
        return con;
    }

    private static void mantenerConexionViva() {
        Timer timer= new Timer(true);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    if (con != null && !con.isClosed()) {
                        Statement stmt = con.createStatement();
                        stmt.executeQuery("SELECT 1");
                        stmt.close();
                        System.out.println("📶 Ping enviado para mantener la conexión activa.");
                    }
                } catch (SQLException e) {
                    System.out.println("⚠️ Error de ping: " + e.getMessage());
                }
            }
        }, 0, 240000);
    }
}
    
    */

    
    
    





