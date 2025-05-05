/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Formularios;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

/**
 *
 * @author Adrian
 */
public class Utilidades {
    public static void mostrarToast(JFrame parent, String mensaje) {
        JWindow toast = new JWindow(parent);
        JPanel panel = new JPanel();
        panel.setBackground(new Color(30, 30, 30));
        panel.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 2));
        JLabel label = new JLabel(mensaje);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Segoe UI", Font.BOLD, 14));
        label.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        panel.add(label);
        toast.add(panel);
        toast.pack();
        int x = parent.getX() + parent.getWidth() - toast.getWidth() - 20;
        int y = parent.getY() + 20;
        toast.setLocation(x, y);
        toast.setAlwaysOnTop(true);
        toast.setVisible(true);
        new javax.swing.Timer(3000, e -> toast.dispose()).start();
    }
}

