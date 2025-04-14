
package Clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tadeo
 */
public class ListProducto {
    ConexionBS conn=new ConexionBS();
    Connection cn = conn.conectar(); 

    
    public void MostrarTable(JTable tabla){
        DefaultTableModel modelo=new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Usuario_Id");
        modelo.addColumn("Nombre_Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");
        modelo.addColumn("Total");
        String consultasql="SELECT*FROM productos";
        Statement st;
        try {
            st=cn.createStatement();
            ResultSet rs=st.executeQuery(consultasql);
            while (rs.next()){
                Object[] lista = {rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getDouble(5),rs.getDouble(6)};

                modelo.addRow(lista);
            
            }
            tabla.setModel(modelo);
        
        } catch(Exception e){
            System.out.println("ERROR AL LISTAR LOS DATOS"+e);
        
        }
    }
}
