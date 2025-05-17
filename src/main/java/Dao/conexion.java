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

   /*   Connection con;
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
*/
    
    
 // conexion multiple que hace explotar la base de datos
    
  /*  Connection con;

    // 🔄 Datos de conexión a la base en la nube
    String url = "jdbc:mysql://sql10.freesqldatabase.com:3306/sql10779437?useSSL=false&serverTimezone=UTC";
    String user = "sql10779437";
    String pass = "ZMwAAPfV5Q";  // 👈 Reemplaza esto por tu contraseña real

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
    

  // 🔁 Instancia única
 
 

    // 🔁 Instancia única
     private static Connection con = null;
    private static final String URL = "jdbc:mysql://sql10.freesqldatabase.com:3306/sql10779437?useSSL=false&serverTimezone=UTC";
    private static final String USER = "sql10779437";
    private static final String PASS = "ZMwAAPfV5Q";
    private static final Timer timer = new Timer(true);
    private static final long PING_INTERVAL = 240_000; // 4 minutos
    private static final long REFRESCO_INTERVAL = 60_000; // 1 min

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
        }, 0, 1000);
    }

    // 🧠 Esto lo puedes usar para refrescar cualquier tabla cada X tiempo
    public static void agregarRefresco(Runnable tareaRefresco) {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                tareaRefresco.run();
            }
        }, 0, 5000);
    }
}
    
    
    
    





