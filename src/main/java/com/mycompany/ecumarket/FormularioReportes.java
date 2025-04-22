/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.ecumarket;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.Date;
import com.toedter.calendar.JDateChooser;


/**
 * Formulario para la generación de reportes en EcuMarket
 * @author Adrian
 */
public class FormularioReportes {
    
    private JFrame frame;
    private JPanel panelPrincipal;
    private JButton btnReporteFactura;
    private JButton btnReporteProductos;
    private JButton btnReporteUsuarios;
    private JButton btnReporteVentas;
    private JButton btnReporteStockBajo;
    
    /**
     * Constructor del formulario de reportes
     */
    public FormularioReportes() {
        inicializarFormulario();
    }
    
    /**
     * Inicializa el formulario principal
     */
    private void inicializarFormulario() {
        frame = new JFrame("Sistema de Reportes - EcuMarket");
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        inicializarComponentes();
        
        frame.setVisible(true);
    }
    
 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void inicializarComponentes() {
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        
        // Panel con título
        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(53, 95, 155));
        panelTitulo.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        JLabel lblTitulo = new JLabel("SISTEMA DE GENERACIÓN DE REPORTES");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setForeground(Color.WHITE);
        panelTitulo.add(lblTitulo);
        
        // Panel con opciones de reportes
        JPanel panelOpciones = new JPanel();
        panelOpciones.setLayout(new GridLayout(5, 1, 10, 20));
        panelOpciones.setBorder(BorderFactory.createEmptyBorder(30, 100, 30, 100));
        
        btnReporteFactura = crearBotonReporte("Reporte de Factura Individual", "invoice.png");
        btnReporteProductos = crearBotonReporte("Reporte de Inventario de Productos", "products.png");
        btnReporteUsuarios = crearBotonReporte("Reporte de Usuarios Registrados", "users.png");
        btnReporteVentas = crearBotonReporte("Reporte de Ventas por Periodo", "sales.png");
        btnReporteStockBajo = crearBotonReporte("Reporte de Productos con Stock Bajo", "low-stock.png");
        
        panelOpciones.add(btnReporteFactura);
        panelOpciones.add(btnReporteProductos);
        panelOpciones.add(btnReporteUsuarios);
        panelOpciones.add(btnReporteVentas);
        panelOpciones.add(btnReporteStockBajo);
        
        // Agregar paneles al panel principal
        panelPrincipal.add(panelTitulo, BorderLayout.NORTH);
        panelPrincipal.add(panelOpciones, BorderLayout.CENTER);
        
        // Agregar listeners a los botones
        btnReporteFactura.addActionListener(e -> mostrarDialogoFactura());
        btnReporteProductos.addActionListener(e -> mostrarDialogoProductos());
        btnReporteUsuarios.addActionListener(e -> generarReporteUsuarios());
        btnReporteVentas.addActionListener(e -> mostrarDialogoVentas());
        btnReporteStockBajo.addActionListener(e -> mostrarDialogoStockBajo());
        
        // Establecer panel principal
        frame.setContentPane(panelPrincipal);
    }
    
    /**
     * Crea un botón para opciones de reportes con formato estándar
     * @param texto Texto a mostrar en el botón
     * @param iconoRuta Ruta del ícono para el botón
     * @return JButton configurado
     */
    private JButton crearBotonReporte(String texto, String iconoRuta) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Arial", Font.PLAIN, 16));
        boton.setFocusPainted(false);
        
        try {
            // Si tienes iconos disponibles, los puedes cargar así
            ImageIcon icono = new ImageIcon(getClass().getResource("/recursos/" + iconoRuta));
            Image img = icono.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
            boton.setIcon(new ImageIcon(img));
            boton.setIconTextGap(10);
        } catch (Exception e) {
            // Si no hay iconos, solo mostrar texto
        }
        
        return boton;
    }
    
    /**
     * Muestra diálogo para seleccionar una factura específica
     */
    private void mostrarDialogoFactura() {
        JDialog dialogo = new JDialog(frame, "Reporte de Factura Individual", true);
        dialogo.setSize(400, 200);
        dialogo.setLocationRelativeTo(frame);
        dialogo.setLayout(new BorderLayout());
        
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel lblFactura = new JLabel("ID de Factura:");
        JTextField txtFactura = new JTextField(10);
        JButton btnGenerar = new JButton("Generar Reporte");
        JButton btnCancelar = new JButton("Cancelar");
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 10);
        panel.add(lblFactura, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(txtFactura, gbc);
        
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBotones.add(btnCancelar);
        panelBotones.add(btnGenerar);
        
        dialogo.add(panel, BorderLayout.CENTER);
        dialogo.add(panelBotones, BorderLayout.SOUTH);
        
        btnCancelar.addActionListener(e -> dialogo.dispose());
        btnGenerar.addActionListener(e -> {
            try {
                int idFactura = Integer.parseInt(txtFactura.getText().trim());
                dialogo.dispose();
                generarReporteFactura(idFactura);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialogo, 
                    "Por favor, ingrese un número de factura válido.", 
                    "Error de entrada", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        dialogo.setVisible(true);
    }
    
    /**
     * Muestra diálogo para seleccionar opciones de reporte de productos
     */
    private void mostrarDialogoProductos() {
        JOptionPane.showMessageDialog(frame, 
            "Generando reporte de inventario de productos...", 
            "Reporte de Productos", 
            JOptionPane.INFORMATION_MESSAGE);
            
        generarReporteProductos();
    }
    
    /**
     * Muestra diálogo para seleccionar periodo de ventas
     */
    private void mostrarDialogoVentas() {
        JDialog dialogo = new JDialog(frame, "Reporte de Ventas por Periodo", true);
        dialogo.setSize(450, 220);
        dialogo.setLocationRelativeTo(frame);
        dialogo.setLayout(new BorderLayout());
        
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel lblFechaInicio = new JLabel("Fecha Inicio:");
        JLabel lblFechaFin = new JLabel("Fecha Fin:");
        
        // Usar JDateChooser de JCalendar
        JDateChooser dateInicio = new JDateChooser();
        JDateChooser dateFin = new JDateChooser();
        
        // Establecer fecha actual en ambos selectores
        dateInicio.setDate(new Date());
        dateFin.setDate(new Date());
        
        JButton btnGenerar = new JButton("Generar Reporte");
        JButton btnCancelar = new JButton("Cancelar");
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 10);
        panel.add(lblFechaInicio, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(dateInicio, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(lblFechaFin, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(dateFin, gbc);
        
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBotones.add(btnCancelar);
        panelBotones.add(btnGenerar);
        
        dialogo.add(panel, BorderLayout.CENTER);
        dialogo.add(panelBotones, BorderLayout.SOUTH);
        
        btnCancelar.addActionListener(e -> dialogo.dispose());
        btnGenerar.addActionListener(e -> {
            Date fechaInicio = dateInicio.getDate();
            Date fechaFin = dateFin.getDate();
            
            if (fechaInicio == null || fechaFin == null) {
                JOptionPane.showMessageDialog(dialogo, 
                    "Por favor, seleccione ambas fechas.", 
                    "Error de entrada", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (fechaInicio.after(fechaFin)) {
                JOptionPane.showMessageDialog(dialogo, 
                    "La fecha de inicio debe ser anterior a la fecha fin.", 
                    "Error de entrada", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            dialogo.dispose();
            generarReporteVentas(fechaInicio, fechaFin);
        });
        
        dialogo.setVisible(true);
    }
    
    /**
     * Muestra diálogo para seleccionar umbral de stock bajo
     */
    private void mostrarDialogoStockBajo() {
        JDialog dialogo = new JDialog(frame, "Reporte de Productos con Stock Bajo", true);
        dialogo.setSize(400, 200);
        dialogo.setLocationRelativeTo(frame);
        dialogo.setLayout(new BorderLayout());
        
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel lblUmbral = new JLabel("Umbral de Stock:");
        JSpinner spinnerUmbral = new JSpinner(new SpinnerNumberModel(10, 1, 1000, 1));
        JButton btnGenerar = new JButton("Generar Reporte");
        JButton btnCancelar = new JButton("Cancelar");
        
        JLabel lblExplicacion = new JLabel("<html>Se considerarán productos con stock bajo aquellos<br>con cantidad igual o menor al umbral especificado.</html>");
        lblExplicacion.setFont(new Font("Arial", Font.ITALIC, 12));
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 10);
        panel.add(lblUmbral, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(spinnerUmbral, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(15, 5, 5, 5);
        panel.add(lblExplicacion, gbc);
        
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBotones.add(btnCancelar);
        panelBotones.add(btnGenerar);
        
        dialogo.add(panel, BorderLayout.CENTER);
        dialogo.add(panelBotones, BorderLayout.SOUTH);
        
        btnCancelar.addActionListener(e -> dialogo.dispose());
        btnGenerar.addActionListener(e -> {
            int umbral = (Integer) spinnerUmbral.getValue();
            dialogo.dispose();
            generarReporteStockBajo(umbral);
        });
        
        dialogo.setVisible(true);
    }
   
    /**
     * Genera reporte de factura individual
     * @param idFactura ID de la factura
     */
    private void generarReporteFactura(int idFactura) {
        JOptionPane.showMessageDialog(frame, 
            "Generando reporte para la factura #" + idFactura, 
            "Generación de Reporte", 
            JOptionPane.INFORMATION_MESSAGE);
        
        // Aquí implementar la lógica para generar el PDF de factura
        // Por ejemplo usando iText, JasperReports u otra librería de reportes
    }
    
    /**
     * Genera reporte de productos
     */
    private void generarReporteProductos() {
        JOptionPane.showMessageDialog(frame, 
            "Generando reporte de inventario de productos...", 
            "Generación de Reporte", 
            JOptionPane.INFORMATION_MESSAGE);
            
        // Aquí implementar la lógica para generar el reporte de productos
    }
    
    /**
     * Genera reporte de usuarios
     */
    private void generarReporteUsuarios() {
        JOptionPane.showMessageDialog(frame, 
            "Generando reporte de usuarios registrados...", 
            "Generación de Reporte", 
            JOptionPane.INFORMATION_MESSAGE);
            
        // Aquí implementar la lógica para generar el reporte de usuarios
    }
    
    /**
     * Genera reporte de ventas por período
     * @param fechaInicio Fecha de inicio del período
     * @param fechaFin Fecha de fin del período
     */
    private void generarReporteVentas(Date fechaInicio, Date fechaFin) {
        JOptionPane.showMessageDialog(frame, 
            "Generando reporte de ventas para el período seleccionado...", 
            "Generación de Reporte", 
            JOptionPane.INFORMATION_MESSAGE);
            
        // Aquí implementar la lógica para generar el reporte de ventas
    }
    
    /**
     * Genera reporte de productos con stock bajo
     * @param umbral Umbral de stock para considerar como "bajo"
     */
    private void generarReporteStockBajo(int umbral) {
        JOptionPane.showMessageDialog(frame, 
            "Generando reporte de productos con stock menor o igual a " + umbral, 
            "Generación de Reporte", 
            JOptionPane.INFORMATION_MESSAGE);
            
        // Aquí implementar la lógica para generar el reporte de stock bajo
    
    }
    /**
     * Muestra el formulario
     */
    public void mostrar() {
        frame.setVisible(true);
    }
    
    /**
     * Punto de entrada para probar el formulario
     */
    public static void main(String[] args) {
        try {
            // Intentar usar look and feel del sistema
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        SwingUtilities.invokeLater(() -> {
            FormularioReportes formulario = new FormularioReportes();
            formulario.mostrar();
        });
    }
}
