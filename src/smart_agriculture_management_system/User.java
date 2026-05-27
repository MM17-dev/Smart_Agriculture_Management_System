/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package smart_agriculture_management_system;

/**
 *
 * @author HP 850 G5
 */
public class User {

    private String fullName;
    private String nic;
    private String dob;
    private String address;
    private String email;
    private String role;
    private String phoneNo;
    private String userName;
    private String password;

    // ================= FULL NAME =================
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {

        if (fullName == null || fullName.trim().length() < 3) {
            throw new IllegalArgumentException("Full name must contain at least 3 characters.");
        }

        this.fullName = fullName;
    }

    // ================= NIC =================
    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {

        if (nic == null || !(nic.matches("\\d{9}[Vv]") || nic.matches("\\d{12}"))) {
            throw new IllegalArgumentException("Invalid NIC number.");
        }

        this.nic = nic;
    }

    // ================= DOB =================
    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {

        if (dob == null || dob.isEmpty()) {
            throw new IllegalArgumentException("DOB cannot be empty.");
        }

        this.dob = dob;
    }

    // ================= ADDRESS =================
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {

        if (address == null || address.trim().length() < 5) {
            throw new IllegalArgumentException("Address is too short.");
        }

        this.address = address;
    }

    // ================= EMAIL =================
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        if (email == null || !email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("Invalid email address.");
        }

        this.email = email;
    }

    // ================= ROLE =================
    public String getRole() {
        return role;
    }

    public void setRole(String role) {

        if (!(role.equalsIgnoreCase("Farmer") ||
              role.equalsIgnoreCase("Buyer") ||
              role.equalsIgnoreCase("Officer"))) {

            throw new IllegalArgumentException("Role must be Farmer, Buyer, or Officer.");
        }

        this.role = role;
    }

    // ================= PHONE NUMBER =================
    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {

        if (phoneNo == null || !phoneNo.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone number must contain 10 digits.");
        }

        this.phoneNo = phoneNo;
    }

    // ================= USERNAME =================
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {

        if (userName == null || userName.length() < 4) {
            throw new IllegalArgumentException("Username must contain at least 4 characters.");
        }

        this.userName = userName;
    }

    // ================= PASSWORD =================
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        if (password == null || password.length() <= 5) {
            throw new IllegalArgumentException("Password must be more than 5 characters.");
        }

        this.password = password;
    }
}
