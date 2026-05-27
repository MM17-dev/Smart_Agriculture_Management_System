/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package smart_agriculture_management_system;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;

/**
 *
 * @author HP 850 G5
 */
public class DatabaseHelper {

        String url = "jdbc:mysql://localhost:3306/agriculture_system?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "";

    private Connection connection;

    // Constructor
    public DatabaseHelper() {
        connect();
    }

    //  Connect to DB
    private void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(url, user, password);

            System.out.println("Database Connected Successfully!");
        } catch (Exception e) {
            System.out.println("Database Connection FAILED!");
            e.printStackTrace();
            connection = null;
        }
    }

    //  Get Connection 
    public Connection getConnection() {
        return connection;
    }

    // Close Connection
    public void closeConnection() {
        try {
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ============================================================
    // 🔹 USER METHODS
    // ============================================================

    // Insert User
    public boolean insertUser(String name, String username, String password, String role,
                              String phone, String email, String address, String DOB, String NIC) {

        String query = "INSERT INTO User_Details (name, username, password, role, phone, email, address, date_of_birth, nic) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, name);
            ps.setString(2, username);
            ps.setString(3, password);
            ps.setString(4, role);
            ps.setString(5, phone);
            ps.setString(6, email);
            ps.setString(7, address);
            ps.setString(8, DOB);
            ps.setString(9, NIC);

            boolean result = ps.executeUpdate() > 0;

            ps.close();

            return result;

        } catch (SQLException e) {

            System.out.println("SQL Error : " + e.getMessage());

            e.printStackTrace();

            return false;
        }
    }
    
    /////////////// UserName Updtae  ///////////////////
    public boolean updateUserName(int userId, String newName) {
        try {
            String sql = "UPDATE user_details SET username = ? WHERE person_id = ?";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, newName);
            ps.setInt(2, userId);

            int rows = ps.executeUpdate();

            ps.close();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /////////////// Password update  ///////////////////
    public boolean updatePassword(int userId, String newPassword) {
        try {
            String sql = "UPDATE user_details SET password = ? WHERE person_id = ?";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, newPassword);
            ps.setInt(2, userId);

            int rows = ps.executeUpdate();

            ps.close();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    
    // Update USer
    public boolean updateUser(int personId, String name, String username,
                          String password, String role,
                          String phone, String email, String address, String DOB, String nic) {

        String query = "UPDATE User_Details SET name=?, username=?, password=?, role=?, phone=?, email=?, address=?, date_of_birth=?, nic=? WHERE person_id=?";

        try {
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, name);
            ps.setString(2, username);
            ps.setString(3, password);
            ps.setString(4, role);
            ps.setString(5, phone);
            ps.setString(6, email);
            ps.setString(7, address);
            ps.setString(8, DOB);
            ps.setString(9, nic);
            ps.setInt(10, personId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Deleteb User
    public boolean deleteUser(int personId) {

        String query = "DELETE FROM User_Details WHERE person_id=?";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, personId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // get id from username and password
    public int getUserId(String username, String password) {

        String query = "SELECT person_id FROM User_Details WHERE username=? AND password=?";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("person_id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1; // if not found
    }

    // Login Check
    public boolean loginUser(String username) {
        String query = "SELECT * FROM User_Details WHERE username = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // getting usr role
    public String getUserRoleById(int personId) {

        String query = "SELECT role FROM User_Details WHERE person_id=?";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, personId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("role");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // if not found
    }

    // ============================================================
    // 🔹 CROP METHODS
    // ============================================================

    public boolean addCrop(String cropName, String description) {
        String query = "INSERT INTO crop (crop_name, description) VALUES (?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, cropName);
            ps.setString(2, description);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ResultSet getAllCrops() {
        String query = "SELECT * FROM crop";
        try {
            Statement stmt = connection.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // ============================================================
    // 🔹 FARMER CROP METHODS
    // ============================================================

    public boolean assignCropToFarmer(int farmerId, int cropId, int seasonId,
                                     String landName, Date plantingDate) {
        String query = "INSERT INTO farmer_crop (farmer_id, crop_id, season_id, land_name, planting_date) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, farmerId);
            ps.setInt(2, cropId);
            ps.setInt(3, seasonId);
            ps.setString(4, landName);
            ps.setDate(5, plantingDate);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ============================================================
    // 🔹 HARVEST METHODS
    // ============================================================

    public boolean addHarvest(int farmerCropId, Date harvestDate,
                              double quantity, double remainingQuantity) {
        String query = "INSERT INTO harvest (farmer_crop_id, harvest_date, quantity, remaining_quantity) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, farmerCropId);
            ps.setDate(2, harvestDate);
            ps.setDouble(3, quantity);
            ps.setDouble(4, remainingQuantity);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ============================================================
    // 🔹 ORDER METHODS
    // ============================================================

    public boolean placeOrder(int buyerId, int harvestId, Date orderDate,
                              double quantity, String status) {
        String query = "INSERT INTO orders (buyer_id, harvest_id, order_date, quantity, status) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, buyerId);
            ps.setInt(2, harvestId);
            ps.setDate(3, orderDate);
            ps.setDouble(4, quantity);
            ps.setString(5, status);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    ///////////////////////////////////////////////// Vailable harveust crops/////////////////////////////////////
    public ResultSet getAvailableCrops(String cropName) {
        ResultSet rs = null;
        try {
            String query = "SELECT h.harvest_id, c.crop_name, p.name AS farmer_name, " +
                           "h.remaining_quantity, h.harvest_date " +
                           "FROM harvest h " +
                           "JOIN farmer_crop fc ON h.farmer_crop_id = fc.farmer_crop_id " +
                           "JOIN crop c ON fc.crop_id = c.crop_id " +
                           "JOIN user_details p ON fc.farmer_id = p.person_id " +
                           "WHERE h.remaining_quantity > 0";

            PreparedStatement ps;

            if (cropName != null && !cropName.isEmpty()) {
                query += " AND c.crop_name = ?";
                ps = connection.prepareStatement(query);
                ps.setString(1, cropName);
            } else {
                ps = connection.prepareStatement(query);
            }

            rs = ps.executeQuery();
            System.out.println("loadTable called");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    public ResultSet getCropNames() {
        ResultSet rs = null;
        try {
            String query = "SELECT crop_name FROM crop";
            
            PreparedStatement ps = connection.prepareStatement(query);
            rs = ps.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    public ResultSet getSeasonNames() {
        ResultSet rs = null;
        try {
            String query = "SELECT season_name FROM season";
            
            PreparedStatement ps = connection.prepareStatement(query);
            rs = ps.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public boolean placeOrder(int buyerId, int harvestId, double qty) {
        try {
            String query = "INSERT INTO orders (buyer_id, harvest_id, order_date, quantity, status) " +
                           "VALUES (?, ?, NOW(), ?, ?)";

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, buyerId);
            ps.setInt(2, harvestId);
            ps.setDouble(3, qty);
            ps.setString(4, "Pending");

            int rows = ps.executeUpdate();

            ps.close();

            return rows > 0; // true if insert successful

        } catch (Exception e) {
            e.printStackTrace();
            return false; // failed
        }
    }
    
    public boolean updateHarvestQty(int harvestId, double newQty) {
        try {
            String sql = "UPDATE harvest SET remaining_quantity = ? WHERE harvest_id = ?";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setDouble(1, newQty);
            ps.setInt(2, harvestId);

            int rows = ps.executeUpdate();

            ps.close();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public ResultSet getMyOrders(int buyerId) {
        ResultSet rs = null;

        try {
            String query = "SELECT o.order_id, c.crop_name, p.name AS farmer_name, " +
                           "o.quantity, o.order_date, o.status " +
                           "FROM orders o " +
                           "JOIN harvest h ON o.harvest_id = h.harvest_id " +
                           "JOIN farmer_crop fc ON h.farmer_crop_id = fc.farmer_crop_id " +
                           "JOIN crop c ON fc.crop_id = c.crop_id " +
                           "JOIN user_details p ON fc.farmer_id = p.person_id " +
                           "WHERE o.buyer_id = ?";

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, buyerId);

            rs = ps.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rs;
    }
    public boolean confirmedOrder(int orderId) {

        try {

            String query = "UPDATE orders SET status = ? WHERE order_id = ?";

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, "Confirmed");
            ps.setInt(2, orderId);

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean cancelOrder(int orderId) {
        try {

            String query = "SELECT harvest_id, quantity FROM orders WHERE order_id = ? AND status = ?";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, orderId);
            ps.setString(2, "Pending");

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int harvestId = rs.getInt("harvest_id");
                double orderQty = rs.getDouble("quantity");

                String q2 = "SELECT remaining_quantity FROM harvest WHERE harvest_id = ?";
                PreparedStatement ps2 = connection.prepareStatement(q2);
                ps2.setInt(1, harvestId);

                ResultSet rs2 = ps2.executeQuery();

                if (rs2.next()) {
                    double currentQty = rs2.getDouble("remaining_quantity");
                    double newQty = currentQty + orderQty;

                    updateHarvestQty(harvestId, newQty);

                    String q3 = "UPDATE orders SET status = ? WHERE order_id = ?";
                    PreparedStatement ps3 = connection.prepareStatement(q3);

                    ps3.setString(1, "Cancelled");
                    ps3.setInt(2, orderId);
                    ps3.executeUpdate();

                    System.out.println("Cancelled + quantity restored");
                    return true;
                }
            }

            System.out.println("Order cannot be cancelled");
            return false;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    /// ===========================================================================================================///
                                                ///  For Buyer Lable///
    /// ===========================================================================================================///
    public int getTotalOrders(int buyerId) {
        int count = 0;
        try {
            String sql = "SELECT COUNT(*) FROM orders WHERE buyer_id = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, buyerId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }

            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(count);
        return count;
        
    }

    public int getPendingOrders(int buyerId) {
        int count = 0;
        try {
            String sql = "SELECT COUNT(*) FROM orders WHERE buyer_id = ? AND status = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, buyerId);
            ps.setString(2, "Pending");

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }

            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(count);
        return count;
    }

    public int getCancelledOrders(int buyerId) {
        int count = 0;
        try {
            String sql = "SELECT COUNT(*) FROM orders WHERE buyer_id = ? AND status = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, buyerId);
            ps.setString(2, "Cancelled");

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }

            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(count);
        return count;
    }
    
    public int getConfirmedOrders(int buyerId) {
        int count = 0;
        try {
            String sql = "SELECT COUNT(*) FROM orders WHERE buyer_id = ? AND status = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, buyerId);
            ps.setString(2, "Confirmed");

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }

            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(count);
        return count;
    }
    /// ===========================================================================================================///
    /// ===========================================================================================================///
   
   
    public ResultSet getMyCrops(int buyerId) {
        ResultSet rs = null;

        try {
            String query =  "SELECT fc.farmer_crop_id, c.crop_name, s.season_name, " +
                            "fc.land_name, fc.planting_date, fc.expected_harvest_date, fc.status " +
                            "FROM farmer_crop fc " +
                            "JOIN crop c ON fc.crop_id = c.crop_id " +
                            "JOIN season s ON fc.season_id = s.season_id " +
                            "WHERE fc.farmer_id = ?";


            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, buyerId);

            rs = ps.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rs;
    }   
  
    
    public boolean insertFarmerCrop(int farmerId, String cropName, String seasonName,
                                   String landName, String plantingDate,
                                   String expectedHarvestDate, String status) {
        try {
            
        String query = "INSERT INTO farmer_crop (farmer_id, crop_id, season_id, land_name, planting_date, expected_harvest_date, status) " +
                       "VALUES (?, " +
                       "(SELECT crop_id FROM crop WHERE crop_name = ?), " +
                       "(SELECT season_id FROM season WHERE season_name = ?), ?, ?, ?, ?)";


        

            PreparedStatement ps = connection.prepareStatement(query);

                ps.setInt(1, farmerId);
                ps.setString(2, cropName);
                ps.setString(3, seasonName);
                ps.setString(4, landName);
                ps.setString(5, plantingDate);
                ps.setString(6, expectedHarvestDate);
                ps.setString(7, status);

            boolean result = ps.executeUpdate() > 0;

            ps.close();

            return result;

        } catch (SQLException e) {

            System.out.println("SQL Error : " + e.getMessage());
            e.printStackTrace();

            return false;
        }
    }
    
    public boolean insertHarvest(int farmerCropId, String harvestDate,
                              double quantity, double remainingQuantity) {
        
        try {
        String query = "INSERT INTO harvest " +
                       "(farmer_crop_id, harvest_date, quantity, remaining_quantity) " +
                       "VALUES (?, ?, ?, ?)";

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, farmerCropId);
            ps.setString(2, harvestDate);    
            ps.setDouble(3, quantity);
            ps.setDouble(4, remainingQuantity);

            boolean result = ps.executeUpdate() > 0;

            ps.close();

            return result;

        } catch (SQLException e) {

            System.out.println("SQL Error: " + e.getMessage());
            e.printStackTrace();

            return false;
        }
    }
    
    public boolean updateCropStatus(int farmerCropId, String status) {

        try {
        String query = "UPDATE farmer_crop SET status = ? WHERE farmer_crop_id = ?";
  
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, status);
            ps.setInt(2, farmerCropId);

            boolean result = ps.executeUpdate() > 0;

            ps.close();

            return result;

        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
    }
    
    public ResultSet getMyOrder(int farmerid) {
        ResultSet rs = null;

        try {
                String query = "SELECT o.order_id, u.name AS buyer_name, h.harvest_id, " +
                   "c.crop_name, o.quantity, o.order_date, o.status " +
                   "FROM orders o " +
                   "JOIN user_details u ON o.buyer_id = u.person_id " +
                   "JOIN harvest h ON o.harvest_id = h.harvest_id " +
                   "JOIN farmer_crop fc ON h.farmer_crop_id = fc.farmer_crop_id " +
                   "JOIN crop c ON fc.crop_id = c.crop_id " +
                   "WHERE fc.farmer_id = ?";


            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, farmerid);

            rs = ps.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rs;
    }
    /// ===========================================================================================================///
                                                ///  For Buyer Lable///
    /// ===========================================================================================================///
    public int getTotalFOrders(int farmerid) {
        int count = 0;
        try {
            String query = "SELECT COUNT(*) AS total_orders " +
                           "FROM orders o " +
                           "JOIN harvest h ON o.harvest_id = h.harvest_id " +
                           "JOIN farmer_crop fc ON h.farmer_crop_id = fc.farmer_crop_id " +
                           "WHERE fc.farmer_id = ?";

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, farmerid);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }

            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(count);
        return count;
        
    }

    public int getPendingFOrders(int farmerid) {
        int count = 0;
        try {
            String query = "SELECT COUNT(*) AS total_orders " +
                           "FROM orders o " +
                           "JOIN harvest h ON o.harvest_id = h.harvest_id " +
                           "JOIN farmer_crop fc ON h.farmer_crop_id = fc.farmer_crop_id " +
                           "WHERE fc.farmer_id = ? AND o.status = ?";
            
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, farmerid);
            ps.setString(2, "Pending");

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }

            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(count);
        return count;
    }
    
    public int getTotcrops(int farmerid) {
        int count = 0;
        try {
            String query = "SELECT COUNT(*) AS total_crops FROM farmer_crop WHERE farmer_id = ?";

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, farmerid);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }

            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(count);
        return count;
    }
    
    public int getTotHarvets(int farmerid) {
        int count = 0;
        try {

            String query = "SELECT SUM(h.quantity) AS total_harvest " +
                           "FROM harvest h " +
                           "JOIN farmer_crop fc ON h.farmer_crop_id = fc.farmer_crop_id " +
                           "WHERE fc.farmer_id = ?";


            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, farmerid);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }

            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(count);
        return count;
    }
   


}

