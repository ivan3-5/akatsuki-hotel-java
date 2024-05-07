/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AkatsukiHotel;

/**
 *
 * @author Ivan Adcan
 */
public class ForgotPW extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public ForgotPW() {
        initComponents();
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
        text2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        sendcode = new javax.swing.JButton();
        text3 = new javax.swing.JLabel();
        login = new javax.swing.JButton();
        changepw = new javax.swing.JButton();
        text4 = new javax.swing.JLabel();
        code = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Forgot Password");
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
        text1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        text1.setForeground(new java.awt.Color(28, 42, 57));
        text1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        text1.setText("Forgot Password");
        panelRight.add(text1, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 31, -1, -1));

        text2.setText("Enter Email, Username or Phone Number:");
        panelRight.add(text2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 88, -1, -1));
        panelRight.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 111, 288, 37));

        sendcode.setBackground(new java.awt.Color(28, 42, 57));
        sendcode.setForeground(new java.awt.Color(255, 255, 255));
        sendcode.setText("Send Code");
        sendcode.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        sendcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendcodeActionPerformed(evt);
            }
        });
        panelRight.add(sendcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, 111, -1, 37));

        text3.setText("Enter New Password:");
        panelRight.add(text3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 155, -1, -1));

        login.setBackground(new java.awt.Color(0, 0, 0));
        login.setForeground(new java.awt.Color(0, 104, 104));
        login.setText("Back to Login");
        login.setContentAreaFilled(false);
        login.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        panelRight.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 401, -1, 39));

        changepw.setBackground(new java.awt.Color(0, 104, 104));
        changepw.setForeground(new java.awt.Color(255, 255, 255));
        changepw.setText("Change Password");
        changepw.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        changepw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changepwActionPerformed(evt);
            }
        });
        panelRight.add(changepw, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 233, -1, 37));

        text4.setText("Code:");
        panelRight.add(text4, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, 155, -1, -1));
        panelRight.add(code, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, 178, 95, 37));
        panelRight.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 178, 288, 37));

        panelWrapper.add(panelRight, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 13, 422, 474));
        panelRight.getAccessibleContext().setAccessibleName("panelRight");

        getContentPane().add(panelWrapper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 833, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendcodeActionPerformed

    }//GEN-LAST:event_sendcodeActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        Login login = new Login();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_loginActionPerformed

    private void changepwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changepwActionPerformed
        PWChanged pwchanged = new PWChanged();
        pwchanged.setVisible(true);
        pwchanged.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_changepwActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton changepw;
    private javax.swing.JTextField code;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    public javax.swing.JButton login;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel panelLeft;
    private javax.swing.JPanel panelRight;
    private javax.swing.JPanel panelWrapper;
    public javax.swing.JButton sendcode;
    private javax.swing.JLabel text1;
    private javax.swing.JLabel text2;
    private javax.swing.JLabel text3;
    private javax.swing.JLabel text4;
    // End of variables declaration//GEN-END:variables
}
