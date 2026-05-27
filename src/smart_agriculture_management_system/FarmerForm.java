/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package smart_agriculture_management_system;
import java.awt.CardLayout;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import java.sql.Connection;
import java.util.HashMap;

/**
 *
 * @author HP 850 G5
 */
public class FarmerForm extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FarmerForm.class.getName());
    /**
     * Creates new form FarmerForm
     */
    public FarmerForm() {
        initComponents();
        
        int farmerid = Session.getUserId();
        loadHomePageLable(farmerid);
        
        CardLayout cardLayout = new CardLayout();
        FRightPanel.setLayout(cardLayout);
        
        FRightPanel.add(FHome, "Home");
        FRightPanel.add(FMyCorps, "MyCorps");
        FRightPanel.add(FHarverstOrder, "HarverstOrder");
        FRightPanel.add(FOrder, "Order");
        FRightPanel.add(FReport, "Report");
        FRightPanel.add(FProfile, "Profile");
        
        CardLayout cl = (CardLayout) FRightPanel.getLayout();
        cl.show(FRightPanel, "Home");
        
        loadOrderReport();
        loadHarvestReport();
        loadMyOrders();
        loadCropComboBox();
        loadSeasonComboBox();
    }
    
    public void loadHomePageLable(int farmerid) {
        try{
            DatabaseHelper db = new DatabaseHelper();

            int totalcrops = db.getTotcrops(farmerid);
            int totalharvets = db.getTotHarvets(farmerid);
            int totalorder = db.getTotalFOrders(farmerid);
            int pendingorder = db.getPendingFOrders(farmerid);
            
            jLabel5.setText(String.valueOf(totalcrops));
            jLabel9.setText(String.valueOf(totalharvets));
            jLabel13.setText(String.valueOf(totalorder));
            jLabel1.setText(String.valueOf(pendingorder));
            
            System.out.println("method load");
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
    
    public void loadOrderReport() {
        try {
            int farmerId = Session.getUserId();

            DatabaseHelper db = new DatabaseHelper();
            ResultSet rs = db.getMyOrder(farmerId);

            DefaultTableModel model = (DefaultTableModel) jTableFOM.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                Object[] row = {
                    rs.getInt("order_id"),
                    rs.getString("buyer_name"),
                    rs.getInt("harvest_id"),
                    rs.getString("crop_name"),
                    rs.getDouble("quantity"),
                    rs.getTimestamp("order_date"),
                    rs.getString("status")
                };

                model.addRow(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void loadHarvestReport() {
        try {
            int farmerId = Session.getUserId();

            DatabaseHelper db = new DatabaseHelper();
            ResultSet rs = db.getMyCrops(farmerId);

            DefaultTableModel model = (DefaultTableModel) jTableFHarvestReport.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                Object[] row = {
                    rs.getInt("farmer_crop_id"),
                    rs.getString("crop_name"),
                    rs.getString("season_name"),
                    rs.getString("land_name"),
                    rs.getTimestamp("planting_date"),
                    rs.getTimestamp("expected_harvest_date"),
                    rs.getString("status")
                };

                model.addRow(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void loadMyOrders() {
        try {
            int farmerId = Session.getUserId();

            DatabaseHelper db = new DatabaseHelper();
            ResultSet rs = db.getMyCrops(farmerId);

            DefaultTableModel model = (DefaultTableModel) jTableFMyCorps.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                Object[] row = {
                    rs.getInt("farmer_crop_id"),
                    rs.getString("crop_name"),
                    rs.getString("season_name"),
                    rs.getString("land_name"),
                    rs.getTimestamp("planting_date"),
                    rs.getTimestamp("expected_harvest_date"),
                    rs.getString("status")
                };

                model.addRow(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void loadCropComboBox() {
        try {
            DatabaseHelper db = new DatabaseHelper();
            ResultSet rs = db.getCropNames();

            jComboBoxFMCCropName.removeAllItems();

            while (rs.next()) {
                jComboBoxFMCCropName.addItem(rs.getString("crop_name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void loadSeasonComboBox() {
        try {
            DatabaseHelper db = new DatabaseHelper();
            ResultSet rs = db.getSeasonNames();

            jComboBoxFMCSeasonName.removeAllItems();

            while (rs.next()) {
                jComboBoxFMCSeasonName.addItem(rs.getString("season_name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void clearFields() {

        jComboBoxFMCCropName.setSelectedIndex(0);
        jComboBoxFMCSeasonName.setSelectedIndex(0);
        jComboBoxFMCStatus.setSelectedIndex(0);

        jTextFieldFMCLandName.setText("");

        jDateChooserFMCPlantingDate.setDate(null);
        jDateChooserFMCEHDate.setDate(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        FLeftPanel = new javax.swing.JPanel();
        jButtonFLLogout = new javax.swing.JButton();
        jButtonFLHome = new javax.swing.JButton();
        jButtonFLMyCorps = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButtonFLHO = new javax.swing.JButton();
        jButtonFLReport = new javax.swing.JButton();
        jButtonFLProfile = new javax.swing.JButton();
        jButtonFLOM = new javax.swing.JButton();
        FRightPanel = new javax.swing.JPanel();
        FHome = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jPanel9 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        FMyCorps = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableFMyCorps = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jComboBoxFMCCropName = new javax.swing.JComboBox<>();
        jComboBoxFMCSeasonName = new javax.swing.JComboBox<>();
        jComboBoxFMCStatus = new javax.swing.JComboBox<>();
        jTextFieldFMCLandName = new javax.swing.JTextField();
        jDateChooserFMCPlantingDate = new com.toedter.calendar.JDateChooser();
        jDateChooserFMCEHDate = new com.toedter.calendar.JDateChooser();
        jButtonFMCCreate = new javax.swing.JButton();
        jButtonFMCClear = new javax.swing.JButton();
        FProfile = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jTextFieldBNewUserName = new javax.swing.JTextField();
        jTextFieldBNewPassword = new javax.swing.JTextField();
        jTextFieldBConfermPassword = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        FReport = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        FHarverstOrder = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableFHarvestReport = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jDateChooserFHRHdate = new com.toedter.calendar.JDateChooser();
        jTextFieldFHRQty = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        FOrder = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableFOM = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(300, 200));
        setMaximumSize(new java.awt.Dimension(980, 545));
        setMinimumSize(new java.awt.Dimension(980, 545));
        setPreferredSize(new java.awt.Dimension(980, 545));
        setResizable(false);
        setSize(new java.awt.Dimension(980, 545));

        jPanel1.setBackground(new java.awt.Color(30, 30, 30));

        FLeftPanel.setBackground(new java.awt.Color(30, 30, 30));
        FLeftPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonFLLogout.setBackground(new java.awt.Color(30, 30, 30));
        jButtonFLLogout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonFLLogout.setForeground(new java.awt.Color(255, 255, 255));
        jButtonFLLogout.setText("Log Out");
        jButtonFLLogout.setAlignmentY(0.0F);
        jButtonFLLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFLLogoutActionPerformed(evt);
            }
        });
        FLeftPanel.add(jButtonFLLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 250, 35));

        jButtonFLHome.setBackground(new java.awt.Color(30, 30, 30));
        jButtonFLHome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonFLHome.setForeground(new java.awt.Color(255, 255, 255));
        jButtonFLHome.setText("Home");
        jButtonFLHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFLHomeActionPerformed(evt);
            }
        });
        FLeftPanel.add(jButtonFLHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 91, 250, 35));

        jButtonFLMyCorps.setBackground(new java.awt.Color(30, 30, 30));
        jButtonFLMyCorps.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonFLMyCorps.setForeground(new java.awt.Color(255, 255, 255));
        jButtonFLMyCorps.setText("My Corps");
        jButtonFLMyCorps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFLMyCorpsActionPerformed(evt);
            }
        });
        FLeftPanel.add(jButtonFLMyCorps, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 250, 35));

        jPanel4.setBackground(new java.awt.Color(40, 40, 40));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );

        FLeftPanel.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 90));

        jButtonFLHO.setBackground(new java.awt.Color(30, 30, 30));
        jButtonFLHO.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonFLHO.setForeground(new java.awt.Color(255, 255, 255));
        jButtonFLHO.setText("Harvest Management");
        jButtonFLHO.setAlignmentY(0.0F);
        jButtonFLHO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFLHOActionPerformed(evt);
            }
        });
        FLeftPanel.add(jButtonFLHO, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 250, 35));

        jButtonFLReport.setBackground(new java.awt.Color(30, 30, 30));
        jButtonFLReport.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonFLReport.setForeground(new java.awt.Color(255, 255, 255));
        jButtonFLReport.setText("Reports");
        jButtonFLReport.setAlignmentY(0.0F);
        jButtonFLReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFLReportActionPerformed(evt);
            }
        });
        FLeftPanel.add(jButtonFLReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 250, 35));

        jButtonFLProfile.setBackground(new java.awt.Color(30, 30, 30));
        jButtonFLProfile.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonFLProfile.setForeground(new java.awt.Color(255, 255, 255));
        jButtonFLProfile.setText("Profile");
        jButtonFLProfile.setAlignmentY(0.0F);
        jButtonFLProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFLProfileActionPerformed(evt);
            }
        });
        FLeftPanel.add(jButtonFLProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 250, 35));

        jButtonFLOM.setBackground(new java.awt.Color(30, 30, 30));
        jButtonFLOM.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonFLOM.setForeground(new java.awt.Color(255, 255, 255));
        jButtonFLOM.setText("Order Management");
        jButtonFLOM.setAlignmentY(0.0F);
        jButtonFLOM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFLOMActionPerformed(evt);
            }
        });
        FLeftPanel.add(jButtonFLOM, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 250, 35));

        FRightPanel.setBackground(new java.awt.Color(40, 40, 40));
        FRightPanel.setMaximumSize(new java.awt.Dimension(966, 508));
        FRightPanel.setLayout(new java.awt.CardLayout());

        FHome.setBackground(new java.awt.Color(40, 40, 40));
        FHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(30, 30, 30));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("10");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 40, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smart_agriculture_management_system/wheat.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Pending Order");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 120, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText(":");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 20, -1));

        FHome.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 290, 60));

        jPanel6.setBackground(new java.awt.Color(30, 30, 30));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("10");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 40, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smart_agriculture_management_system/wheat.png"))); // NOI18N
        jLabel6.setText("jLabel2");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Total Corps");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 97, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText(":");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 20, -1));

        FHome.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 290, 60));

        jPanel7.setBackground(new java.awt.Color(30, 30, 30));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("10");
        jPanel7.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 40, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smart_agriculture_management_system/wheat.png"))); // NOI18N
        jLabel10.setText("jLabel2");
        jPanel7.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 40));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Total Harvest");
        jPanel7.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 97, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText(":");
        jPanel7.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 20, -1));

        FHome.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 290, 60));

        jPanel8.setBackground(new java.awt.Color(30, 30, 30));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("10");
        jPanel8.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 40, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smart_agriculture_management_system/wheat.png"))); // NOI18N
        jLabel14.setText("jLabel2");
        jPanel8.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 40));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Total Order");
        jPanel8.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 97, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText(":");
        jPanel8.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 20, -1));

        FHome.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 290, 60));

        jPanel2.setBackground(new java.awt.Color(60, 60, 60));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("About Us    :");

        jTextPane1.setBackground(new java.awt.Color(60, 60, 60));
        jTextPane1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextPane1.setForeground(new java.awt.Color(255, 255, 255));
        jTextPane1.setText("The Smart Agriculture Management System helps farmers manage crops, harvests, crop health, and buyer orders efficiently through a simple and modern digital platform. The system improves productivity and supports smart farming activities with an easy-to-use interface.");
        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel20)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        FHome.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 310, 440));

        jPanel9.setBackground(new java.awt.Color(40, 40, 40));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smart_agriculture_management_system/Clean-Farm-Agriculture-Logo-Template-PNG-Transparent (1) (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        FHome.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 290, 100));

        FRightPanel.add(FHome, "card2");

        FMyCorps.setBackground(new java.awt.Color(40, 40, 40));

        jScrollPane2.setBackground(new java.awt.Color(40, 40, 40));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel3.setBackground(new java.awt.Color(40, 40, 40));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("My Corps");

        jTableFMyCorps.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Crop Name", "Seoson Name", "Land Name", "Planting Date", "Expected Harvest Date", "Status"
            }
        ));
        jScrollPane3.setViewportView(jTableFMyCorps);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel11.setBackground(new java.awt.Color(60, 60, 60));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Season Name");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Crop Name  ");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Status");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Land Name");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Expected harvest Date");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Planting Date");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText(":");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText(":");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText(":");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText(":");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText(":");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText(":");

        jComboBoxFMCCropName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxFMCSeasonName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxFMCStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Growing", "Planted", "Harvested" }));

        jButtonFMCCreate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonFMCCreate.setText("Create");
        jButtonFMCCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFMCCreateActionPerformed(evt);
            }
        });

        jButtonFMCClear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonFMCClear.setText("Cancel");
        jButtonFMCClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFMCClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBoxFMCCropName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxFMCSeasonName, 0, 210, Short.MAX_VALUE)
                    .addComponent(jComboBoxFMCStatus, 0, 210, Short.MAX_VALUE)
                    .addComponent(jTextFieldFMCLandName)
                    .addComponent(jDateChooserFMCPlantingDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooserFMCEHDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonFMCClear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonFMCCreate)
                .addGap(65, 65, 65))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(jLabel27)
                            .addComponent(jComboBoxFMCCropName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel26)
                            .addComponent(jComboBoxFMCSeasonName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(jLabel28)
                            .addComponent(jTextFieldFMCLandName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(jLabel29)))
                    .addComponent(jDateChooserFMCPlantingDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel24)
                        .addComponent(jLabel30))
                    .addComponent(jDateChooserFMCEHDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel31)
                    .addComponent(jComboBoxFMCStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFMCCreate)
                    .addComponent(jButtonFMCClear))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(208, 208, 208))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jScrollPane2.setViewportView(jPanel3);

        javax.swing.GroupLayout FMyCorpsLayout = new javax.swing.GroupLayout(FMyCorps);
        FMyCorps.setLayout(FMyCorpsLayout);
        FMyCorpsLayout.setHorizontalGroup(
            FMyCorpsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FMyCorpsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        FMyCorpsLayout.setVerticalGroup(
            FMyCorpsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FMyCorpsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
                .addContainerGap())
        );

        FRightPanel.add(FMyCorps, "card2");

        FProfile.setBackground(new java.awt.Color(40, 40, 40));
        FProfile.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel15.setBackground(new java.awt.Color(40, 40, 40));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Profile");

        jPanel16.setBackground(new java.awt.Color(60, 60, 60));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Change User name ");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("New User Name       : ");

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Conferm Password  : ");

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("New Password          : ");

        jTextFieldBNewUserName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jTextFieldBNewPassword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jTextFieldBConfermPassword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Change Password");

        jButton8.setText("Change");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton12.setText("Change");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(447, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(85, 85, 85))
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldBNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldBConfermPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldBNewUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel37)
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jTextFieldBNewUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jButton8)
                .addGap(36, 36, 36)
                .addComponent(jLabel41)
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(jTextFieldBNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(jTextFieldBConfermPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton12)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel36)
                .addGap(35, 35, 35)
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(66, 66, 66))
        );

        FProfile.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        FRightPanel.add(FProfile, "card2");

        FReport.setBackground(new java.awt.Color(40, 40, 40));

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 29)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Report");

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Farmer Order Report  : ");

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton5.setText("Show");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FReportLayout = new javax.swing.GroupLayout(FReport);
        FReport.setLayout(FReportLayout);
        FReportLayout.setHorizontalGroup(
            FReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FReportLayout.createSequentialGroup()
                .addGroup(FReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FReportLayout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FReportLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(197, Short.MAX_VALUE))
        );
        FReportLayout.setVerticalGroup(
            FReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FReportLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel42)
                .addGap(121, 121, 121)
                .addGroup(FReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jButton5))
                .addContainerGap(360, Short.MAX_VALUE))
        );

        FRightPanel.add(FReport, "card7");

        FHarverstOrder.setBackground(new java.awt.Color(40, 40, 40));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Harvest Report");

        jTableFHarvestReport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Crop Name", "Seoson Name", "Land Name", "Planting Date", "Expected Harvest Date", "Status"
            }
        ));
        jScrollPane4.setViewportView(jTableFHarvestReport);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel13.setBackground(new java.awt.Color(60, 60, 60));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Quntity               :");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Harvest Date     :");

        jTextFieldFHRQty.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldFHRQty, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooserFHRHdate, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(278, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooserFHRHdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jTextFieldFHRQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Create");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("Refresh");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FHarverstOrderLayout = new javax.swing.GroupLayout(FHarverstOrder);
        FHarverstOrder.setLayout(FHarverstOrderLayout);
        FHarverstOrderLayout.setHorizontalGroup(
            FHarverstOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FHarverstOrderLayout.createSequentialGroup()
                .addGroup(FHarverstOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FHarverstOrderLayout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FHarverstOrderLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(FHarverstOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FHarverstOrderLayout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)))))
                .addContainerGap(69, Short.MAX_VALUE))
            .addGroup(FHarverstOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(FHarverstOrderLayout.createSequentialGroup()
                    .addGap(17, 17, 17)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(71, Short.MAX_VALUE)))
        );
        FHarverstOrderLayout.setVerticalGroup(
            FHarverstOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FHarverstOrderLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 265, Short.MAX_VALUE)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FHarverstOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(142, 142, 142))
            .addGroup(FHarverstOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(FHarverstOrderLayout.createSequentialGroup()
                    .addGap(69, 69, 69)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(297, Short.MAX_VALUE)))
        );

        FRightPanel.add(FHarverstOrder, "card6");

        FOrder.setBackground(new java.awt.Color(40, 40, 40));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Order Management");

        jTableFOM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Buyer Name", "Harvest Id", "Crop Name", "QTY", "Date", "Status"
            }
        ));
        jScrollPane5.setViewportView(jTableFOM);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 669, Short.MAX_VALUE)
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel14Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 339, Short.MAX_VALUE)
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel14Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setText("Confirmed");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton4.setText("Cancelled");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FOrderLayout = new javax.swing.GroupLayout(FOrder);
        FOrder.setLayout(FOrderLayout);
        FOrderLayout.setHorizontalGroup(
            FOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FOrderLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(30, 30, 30)
                .addComponent(jButton3)
                .addGap(259, 259, 259))
            .addGroup(FOrderLayout.createSequentialGroup()
                .addGroup(FOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FOrderLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FOrderLayout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        FOrderLayout.setVerticalGroup(
            FOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FOrderLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel35)
                .addGap(18, 18, 18)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(FOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton3))
                .addContainerGap(121, Short.MAX_VALUE))
        );

        FRightPanel.add(FOrder, "card7");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(FLeftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FRightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FLeftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(FRightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFLLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFLLogoutActionPerformed
    WelcomeForm login = new WelcomeForm();
    login.setVisible(true);

    this.dispose();    // TODO add your handling code here:
    }//GEN-LAST:event_jButtonFLLogoutActionPerformed

    private void jButtonFLHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFLHomeActionPerformed
        CardLayout cl = (CardLayout) FRightPanel.getLayout();
        cl.show(FRightPanel, "Home");       // TODO add your handling code here:
    }//GEN-LAST:event_jButtonFLHomeActionPerformed

    private void jButtonFLMyCorpsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFLMyCorpsActionPerformed
        CardLayout cl = (CardLayout) FRightPanel.getLayout();
        cl.show(FRightPanel, "MyCorps");        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonFLMyCorpsActionPerformed

    private void jButtonFLHOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFLHOActionPerformed
        CardLayout cl = (CardLayout) FRightPanel.getLayout();
        cl.show(FRightPanel, "HarverstOrder");     // TODO add your handling code here:
    }//GEN-LAST:event_jButtonFLHOActionPerformed

    private void jButtonFLReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFLReportActionPerformed
        CardLayout cl = (CardLayout) FRightPanel.getLayout();
        cl.show(FRightPanel, "Report");     // TODO add your handling code here:
    }//GEN-LAST:event_jButtonFLReportActionPerformed

    private void jButtonFLProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFLProfileActionPerformed
        CardLayout cl = (CardLayout) FRightPanel.getLayout();
        cl.show(FRightPanel, "Profile");         // TODO add your handling code here:
    }//GEN-LAST:event_jButtonFLProfileActionPerformed

    private void jButtonFMCCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFMCCreateActionPerformed
        int farmerId = Session.getUserId();
        
        String crop = jComboBoxFMCCropName.getSelectedItem().toString();
        String season = jComboBoxFMCSeasonName.getSelectedItem().toString();
        String land = jTextFieldFMCLandName.getText().trim();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String Pdate = sdf.format(jDateChooserFMCPlantingDate.getDate());   
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        String Hdate = sdf1.format(jDateChooserFMCEHDate.getDate());
        String role = jComboBoxFMCStatus.getSelectedItem().toString();
        
        DatabaseHelper db = new DatabaseHelper();
        boolean success = db.insertFarmerCrop(farmerId,crop,season,land,Pdate,Hdate,role);
        
        if (success) {
            JOptionPane.showMessageDialog(null, "Record insert successfully");
            loadMyOrders();
        } else {
            JOptionPane.showMessageDialog(null, "Insert failed");
        }
        
    }//GEN-LAST:event_jButtonFMCCreateActionPerformed

    private void jButtonFMCClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFMCClearActionPerformed
        clearFields();        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonFMCClearActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    loadHarvestReport(); 
    jTextFieldFHRQty.setText("");
    jDateChooserFHRHdate.setDate(null);

// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    int row = jTableFHarvestReport.getSelectedRow();

    if(row == -1){
        JOptionPane.showMessageDialog(this, "Select a row first");
        return;
    }
    
    String phoneText = jTextFieldFHRQty.getText().trim();

    if (phoneText.isEmpty()) {
        JOptionPane.showMessageDialog(this, "QTY is required.");
        return;
    }

    double qty = Double.parseDouble(jTextFieldFHRQty.getText());
    int id = Integer.parseInt(jTableFHarvestReport.getValueAt(row, 0).toString());
    String status = jTableFHarvestReport.getValueAt(row, 6).toString();
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
    String Hdate = sdf1.format(jDateChooserFHRHdate.getDate());   
    
        if (qty <= 0) {
            JOptionPane.showMessageDialog(null, "Quantity must be greater than 0");
            return;
        }

        if (status.equals("Harvested")) {
            JOptionPane.showMessageDialog(null, "Field already harvested");
            return;
        }
    DatabaseHelper db = new DatabaseHelper();
    boolean result = db.insertHarvest(id,Hdate,qty,qty);
    
    if(result){
        DatabaseHelper db1 = new DatabaseHelper();
        boolean success = db1.updateCropStatus(id,"Harvested"); 

        if(success){
            System.out.println("Status updated to Harvested ");
        } else {
            System.out.println("Update failed ");
        }
        JOptionPane.showMessageDialog(null, "Harvest inserted");
        System.out.println("Harvest inserted ");
    } else {
        System.out.println("Insert failed ");
        JOptionPane.showMessageDialog(null, "Harvest Insert failed ");
    }
    loadHarvestReport();
    // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonFLOMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFLOMActionPerformed
        CardLayout cl = (CardLayout) FRightPanel.getLayout();
        cl.show(FRightPanel, "Order");         // TODO add your handling code here:
    }//GEN-LAST:event_jButtonFLOMActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    try {
        int selectedRow = jTableFOM.getSelectedRow();
        String status = jTableFOM.getValueAt(selectedRow, 6).toString();

        if (!status.equals("Pending")) {
            JOptionPane.showMessageDialog(null, "Only pending orders can be cancelled");
            return;
        }

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please Select a Order");
            return;
        }

        
        int orderId = (int) jTableFOM.getValueAt(selectedRow, 0);
 
        DatabaseHelper db = new DatabaseHelper();
        boolean success = db.cancelOrder(orderId);
        
        if (success) {
            JOptionPane.showMessageDialog(null, "Order Cancelled");
            loadMyOrders();
        } else {
            JOptionPane.showMessageDialog(null, "Order Canceling failed");
        }
        loadOrderReport();
    } catch (Exception e) {
        e.printStackTrace();
    }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    try {
        int selectedRow = jTableFOM.getSelectedRow();
        String status = jTableFOM.getValueAt(selectedRow, 6).toString();

        if (!status.equals("Pending")) {
            JOptionPane.showMessageDialog(null, "Only pending orders can be confirmed");
            return;
        }

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please Select a Order");
            return;
        }

        
        int orderId = (int) jTableFOM.getValueAt(selectedRow, 0);
 
        DatabaseHelper db = new DatabaseHelper();
        boolean success = db.confirmedOrder(orderId);
        
        if (success) {
            JOptionPane.showMessageDialog(null, "Order Confermed");
            loadMyOrders();
        } else {
            JOptionPane.showMessageDialog(null, "Order Confermed failed");
        }
        loadOrderReport();
    } catch (Exception e) {
        e.printStackTrace();
    }         // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        try {
            int buyerId = Session.getUserId();
            if (jTextFieldBNewUserName.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Fill the field");
            }
            String name = jTextFieldBNewUserName.getText();

            DatabaseHelper db = new DatabaseHelper();
            boolean exists = db.loginUser(name);

            if (exists) {
                JOptionPane.showMessageDialog(this, "Username already exists!");
                return;
            }
            boolean success = db.updateUserName(buyerId,name);

            if (success) {
                JOptionPane.showMessageDialog(null, "Change UserName Succefully");
                loadMyOrders();
            } else {
                JOptionPane.showMessageDialog(null, "UserName Change failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        try {
            int buyerId = Session.getUserId();
            if (jTextFieldBNewPassword.getText().trim().isEmpty() || jTextFieldBConfermPassword.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Fill the field");
            }
            String newpass = jTextFieldBNewPassword.getText();
            String confermpass = jTextFieldBConfermPassword.getText();

            if (newpass != null && newpass.equals(confermpass)) {

                DatabaseHelper db = new DatabaseHelper();

                boolean success = db.updatePassword(buyerId,newpass);

                if (success) {
                    JOptionPane.showMessageDialog(null, "Change password Succefully");
                    loadMyOrders();
                } else {
                    JOptionPane.showMessageDialog(null, "password Change failed");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Passwords do not match");
                return ;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

    int farmerId = Session.getUserId(); // or get from logged user
    
    ReportGenerator rg = new ReportGenerator();
    rg.showReport(farmerId);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FarmerForm().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel FHarverstOrder;
    private javax.swing.JPanel FHome;
    private javax.swing.JPanel FLeftPanel;
    private javax.swing.JPanel FMyCorps;
    private javax.swing.JPanel FOrder;
    private javax.swing.JPanel FProfile;
    private javax.swing.JPanel FReport;
    private javax.swing.JPanel FRightPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButtonFLHO;
    private javax.swing.JButton jButtonFLHome;
    private javax.swing.JButton jButtonFLLogout;
    private javax.swing.JButton jButtonFLMyCorps;
    private javax.swing.JButton jButtonFLOM;
    private javax.swing.JButton jButtonFLProfile;
    private javax.swing.JButton jButtonFLReport;
    private javax.swing.JButton jButtonFMCClear;
    private javax.swing.JButton jButtonFMCCreate;
    private javax.swing.JComboBox<String> jComboBoxFMCCropName;
    private javax.swing.JComboBox<String> jComboBoxFMCSeasonName;
    private javax.swing.JComboBox<String> jComboBoxFMCStatus;
    private com.toedter.calendar.JDateChooser jDateChooserFHRHdate;
    private com.toedter.calendar.JDateChooser jDateChooserFMCEHDate;
    private com.toedter.calendar.JDateChooser jDateChooserFMCPlantingDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTableFHarvestReport;
    private javax.swing.JTable jTableFMyCorps;
    private javax.swing.JTable jTableFOM;
    private javax.swing.JTextField jTextFieldBConfermPassword;
    private javax.swing.JTextField jTextFieldBNewPassword;
    private javax.swing.JTextField jTextFieldBNewUserName;
    private javax.swing.JTextField jTextFieldFHRQty;
    private javax.swing.JTextField jTextFieldFMCLandName;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
