/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AkatsukiHotel;

import admin.Admin;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import loggedin.Home;

/**
 *
 * @author Ivan Adcan
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }
    
    public void emailCheck() {                        
        try {
            System.out.println("Creating 'emailCheck.txt'...");
            File file = new File("emailCheck.txt");
                            
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());       
            } else {
                System.out.println("File already exists.");
            }
            
            System.out.println("Creating 'old.txt'...");
            File file1 = new File("old.txt");
            
            if (file1.createNewFile()) {
                System.out.println("File created: " + file1.getName());
            } else {
                System.out.println("File already exists.");
            }
            
            System.out.println("Creating 'room.txt'...");
            File file2 = new File("room.txt");
            
            if (file2.createNewFile()) {
                System.out.println("File created: " + file2.getName());
            } else {
                System.out.println("File already exists.");
            }
            
            System.out.println("Files created.");
        } catch (Exception e) {
            System.err.println("Error: Failed to create/read/write file.");
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    public void userCheck() {
        String Email, password;
            Email = this.email.getText();
            password = this.pw.getText();
        String SUrl, SUser, SPass, query, passwordDB = null, adminCheck = null;
            SUrl = "jdbc:MySQL://localhost:3306/akatsukihotel_user_database";
            SUser = "root";
            SPass = "";
        
        System.out.println("Login button clicked!");
        
        try (Connection con = DriverManager.getConnection(SUrl, SUser, SPass)) {
            Statement stMaxAllowedPacket = con.createStatement();
            String queryMaxAllowedPacket = "SET GLOBAL max_allowed_packet = 1000000000";
            stMaxAllowedPacket.execute(queryMaxAllowedPacket);
            try {
                Statement st, stIDCheck;
                    st = con.createStatement();
                    stIDCheck = con.createStatement();
                int userAcc = 0;
                int adminAcc = 0;

                if ("".equals(Email)) {
                    JOptionPane.showMessageDialog(new JFrame(), "Username, Email, or Phone Number is required!", "Error", JOptionPane.ERROR_MESSAGE);
                } else if ("".equals(password)) {
                    JOptionPane.showMessageDialog(new JFrame(), "Password is required!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    query = "SELECT * FROM user WHERE email = '" + Email + "' OR username = '" + Email +  "' OR phone = '" + Email + "'";
                    ResultSet rs; 
                        rs = st.executeQuery(query);
                    while (rs.next()) {
                        passwordDB = rs.getString("password");
                        adminCheck = rs.getString("id");
                            if ("1".equals(adminCheck)) {
                                adminAcc = 1;
                            } else {
                                userAcc = 1;
                            }
                    } if (adminAcc != 0 && password.equals(passwordDB)) {
                        Admin a = new Admin();
                        a.setVisible(true);
                        a.pack();
                        a.setLocationRelativeTo(null);
                        this.dispose();
                    } else if (userAcc != 0 && password.equals(passwordDB)) {  
                        emailCheck();
                        
                        ResultSet rsID = stIDCheck.executeQuery(query);
                        rsID.next();
                        String stringID = rsID.getString("id");
                        String oldUser = rsID.getString("old");
                        
                        System.out.println("User ID: " + stringID);
                        System.out.println("Old User: " + oldUser);
                        
                        try (FileWriter fw = new FileWriter("emailCheck.txt")) {
                            fw.write(stringID);
                        } catch (Exception e) {
                            System.err.println("Error: " + e.getMessage());
                        }
                        
                        try (FileWriter fw = new FileWriter("old.txt")) {
                            fw.write(oldUser);
                        } catch (Exception e) {
                            System.err.println("Error: " + e.getMessage());
                        }
                        
                        Home h = new Home();
                        h.setVisible(true);
                        h.pack();
                        h.setLocationRelativeTo(null);
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(new JFrame(), "Incorrect email or password", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }catch (SQLException | HeadlessException e){
                JOptionPane.showMessageDialog(new JFrame(), "Something wrong with the code of the program.", "Error", JOptionPane.ERROR_MESSAGE);
                System.err.println("Error: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    } 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelWrapper = new javax.swing.JPanel();
        panelLeft = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        panelRight = new javax.swing.JPanel();
        text1 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        pw = new javax.swing.JPasswordField();
        login = new javax.swing.JButton();
        text4 = new javax.swing.JLabel();
        signup = new javax.swing.JButton();
        forgotpw = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelWrapper.setBackground(new java.awt.Color(230, 192, 104));
        panelWrapper.setMinimumSize(new java.awt.Dimension(800, 500));
        panelWrapper.setPreferredSize(new java.awt.Dimension(800, 500));
        panelWrapper.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelLeft.setBackground(new java.awt.Color(28, 42, 57));
        panelLeft.setMinimumSize(new java.awt.Dimension(400, 500));
        panelLeft.setPreferredSize(new java.awt.Dimension(400, 500));
        panelLeft.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N
        panelLeft.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 113, 240, 235));

        panelWrapper.add(panelLeft, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 387, 474));
        panelLeft.getAccessibleContext().setAccessibleName("panelRight");

        panelRight.setBackground(new java.awt.Color(255, 255, 255));
        panelRight.setMinimumSize(new java.awt.Dimension(400, 500));
        panelRight.setPreferredSize(new java.awt.Dimension(400, 500));
        panelRight.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        text1.setBackground(new java.awt.Color(0, 0, 0));
        text1.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        text1.setForeground(new java.awt.Color(28, 42, 57));
        text1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        text1.setText("Login");
        panelRight.add(text1, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 30, -1, -1));

        email.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        email.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Email, Username or Phone Number", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 13))); // NOI18N
        email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailFocusGained(evt);
            }
        });
        panelRight.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 122, 389, 50));

        pw.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        pw.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 13))); // NOI18N
        panelRight.add(pw, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 188, 389, 50));

        login.setBackground(new java.awt.Color(28, 42, 57));
        login.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        login.setForeground(new java.awt.Color(255, 255, 255));
        login.setText("Login");
        login.setBorder(null);
        login.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        login.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        login.setSelected(true);
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        panelRight.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 256, 98, 37));

        text4.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        text4.setText("No account? Create one.");
        panelRight.add(text4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 417, -1, -1));

        signup.setBackground(new java.awt.Color(0, 0, 0));
        signup.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        signup.setForeground(new java.awt.Color(0, 104, 104));
        signup.setText("Sign Up");
        signup.setContentAreaFilled(false);
        signup.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        signup.setFocusable(false);
        signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupActionPerformed(evt);
            }
        });
        panelRight.add(signup, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 406, 97, 37));

        forgotpw.setBackground(new java.awt.Color(255, 255, 255));
        forgotpw.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        forgotpw.setText("Forgot Password?");
        forgotpw.setBorder(null);
        forgotpw.setBorderPainted(false);
        forgotpw.setContentAreaFilled(false);
        forgotpw.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        forgotpw.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        forgotpw.setFocusable(false);
        forgotpw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forgotpwActionPerformed(evt);
            }
        });
        panelRight.add(forgotpw, new org.netbeans.lib.awtextra.AbsoluteConstraints(274, 266, 127, -1));

        panelWrapper.add(panelRight, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 13, 422, 474));
        panelRight.getAccessibleContext().setAccessibleName("panelRight");

        getContentPane().add(panelWrapper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 833, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void forgotpwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forgotpwActionPerformed
        ForgotPW forgotpw = new ForgotPW();
        forgotpw.setVisible(true);
        forgotpw.pack();
        forgotpw.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_forgotpwActionPerformed

    private void signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupActionPerformed
        SignUp signup = new SignUp();
        signup.setVisible(true);
        signup.pack();
        signup.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_signupActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        userCheck();
    }//GEN-LAST:event_loginActionPerformed

    private void emailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_emailFocusGained

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField email;
    private javax.swing.JButton forgotpw;
    private javax.swing.JButton login;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel panelLeft;
    private javax.swing.JPanel panelRight;
    private javax.swing.JPanel panelWrapper;
    private javax.swing.JPasswordField pw;
    public javax.swing.JButton signup;
    private javax.swing.JLabel text1;
    private javax.swing.JLabel text4;
    // End of variables declaration//GEN-END:variables
}
