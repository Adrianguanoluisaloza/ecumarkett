/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Adrian
 */
public class ReporteFacturaSalida {
    // MÉTODO PÚBLICO para usar desde cualquier botón
    public void generarReporteSalida(String numSalida) {
        try {
            // Ruta al archivo JRXML (pon la correcta según tu proyecto)
            String jrxmlPath = "src/reportes/Pedidos.jrxml";

            // Compilar el diseño
            JasperReport reporte = JasperCompileManager.compileReport(jrxmlPath);

            // Conexión a la base de datos (ajusta tu URL, user y pass)
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/inventario2", "root", "");

            // Parámetros para el reporte
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("numSalida", numSalida);

            // Llenar el reporte
            JasperPrint print = JasperFillManager.fillReport(reporte, parametros, conn);

            // Mostrar el visor
            JasperViewer.viewReport(print, false);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error generando el reporte: " + e.getMessage());
        }
    }
}