/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ecumarket;


import javax.swing.*;

/**
 *
 * @author Adrian
 */
public class Ecumarket {

    public static void main(String[] args) {
       try{
           UIManager.setLookAndFeel("javax.swing.plaf.nibus.NibusLookAndFeel");
           
       }catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e){
           e.printStackTrace();
       }
        SwingUtilities.invokeLater(() -> {
        new PantallaPrincipal().setVisible(true); 
    });
    }
}

    

