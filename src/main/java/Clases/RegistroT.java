/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author tadeo
 */
public class RegistroT {
    ConexionBS con=new ConexionBS();
    Connection cn=con.conectar();
    
   public void registrarbd(ProductoTadeo p){
   try{
   PreparedStatement ps=cn.prepareStatement("INSERT INTO productos(usuario,nombre,cantidad,precio,total)VALUES(?,?,?,?,?)");
   ps.setString(1, p.getUsuario());
            ps.setString(2, p.getNombre());
            ps.setInt(3, p.getCantidad());
            ps.setDouble(4, p.getPrecio());
            ps.setDouble(5, p.Total());
   
   }catch(Exception e){
       JOptionPane.showMessageDialog(null,"ERROR AL REGISTRAR DATOS"+e);
           
           }
   } 
            
}
