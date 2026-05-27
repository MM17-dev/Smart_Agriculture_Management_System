/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package smart_agriculture_management_system;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

public class ReportGenerator {

    public void showReport(int farmerId) {
        try {

            // 1. Create DB Connection (inside same class ✅)
            String url = "jdbc:mysql://localhost:3306/agriculture_system";
            String username = "root";
            String password = ""; // ✅ put your password

            Connection con = DriverManager.getConnection(url, username, password);

            // 2. Compile report
            JasperReport jr = JasperCompileManager.compileReport(
                getClass().getResourceAsStream("/reports/Agriculture_Farmer.jrxml")
            );

            // 3. Parameters
            HashMap<String, Object> params = new HashMap<>();
            params.put("farmer_id", farmerId);

            // 4. Fill report
            JasperPrint jp = JasperFillManager.fillReport(jr, params, con);

            // 5. Show report
            JasperViewer.viewReport(jp, false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void showFarmerCropsReport(int farmerId) {
    try {

        String url = "jdbc:mysql://localhost:3306/agriculture_system";
        String username = "root";
        String password = "";

        Connection con = DriverManager.getConnection(url, username, password);

        JasperReport jr = JasperCompileManager.compileReport(
            getClass().getResourceAsStream("/reports/farmer_crops.jrxml")
        );

        HashMap<String, Object> params = new HashMap<>();
        params.put("farmer_id", farmerId);

        JasperPrint jp = JasperFillManager.fillReport(jr, params, con);

        JasperViewer.viewReport(jp, false);

    } catch (Exception e) {
        e.printStackTrace();
    }
}
}

