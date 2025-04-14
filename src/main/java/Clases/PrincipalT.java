/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Clases;

import com.mycompany.ecumarket.GestionProductos;

/**
 *
 * @author tadeo
 */
public class PrincipalT {

  public static GestionProductos frm_rp;
  public static Control_frmGestionProducto c_frm_rp;
    public static void main(String[] args) {
      frm_rp=new GestionProductos();
      frm_rp.setVisible(true);
      frm_rp.setLocationRelativeTo(null);
      
      c_frm_rp=new Control_frmGestionProducto(frm_rp);
    }
    
}
