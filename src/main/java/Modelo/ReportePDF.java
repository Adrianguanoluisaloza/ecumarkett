/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author Adrian
 */
public class ReportePDF {
    public static void generarReporte(String rutaJasper, Map<String, Object> parametros, String rutaSalidaPDF) {
        Connection conexion = null;
        try {
            // Ajusta estos valores a tu base de datos
            String url = "jdbc:mysql://localhost:3306/inventario2";
            String usuario = "root";
            String clave = "";

            conexion = DriverManager.getConnection(url, usuario, clave);

            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile(rutaJasper);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros, conexion);
            JasperExportManager.exportReportToPdfFile(jasperPrint, rutaSalidaPDF);

            System.out.println("✅ Reporte generado correctamente.");
        } catch (SQLException | JRException e) {
            System.err.println("❌ Error generando reporte: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                System.err.println("⚠️ Error al cerrar conexión: " + e.getMessage());
            }
        }
    }
}
