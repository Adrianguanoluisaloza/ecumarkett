/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import com.mycompany.ecumarket.GestionProductos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author tadeo
 */
public class Control_frmGestionProducto implements ActionListener {
    
    GestionProductos frm_rp;

    public Control_frmGestionProducto(GestionProductos frm_rp) {
        this.frm_rp = frm_rp;
        this.frm_rp.btnguardar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==frm_rp){
       System.out.print("OK,funciona");
           
           
           
       } 
    }
    
}
