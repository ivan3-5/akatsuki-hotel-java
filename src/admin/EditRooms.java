/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ivan Adcan
 */
public class EditRooms extends javax.swing.JFrame {
    
    int selectRoom;
    String Img1 = null, Img2 = null, Img3 = null;
    
    /**
     * Creates new form Login
     */
    public EditRooms() {
        initComponents();
        tableDataLoad();
        loadRoomsData();
    }
    
    public void tableDataLoad() {
        String SUrl, SUser, SPass;
            SUrl = "jdbc:MySQL://localhost:3306/akatsukihotel_user_database";
            SUser = "root";
            SPass = "";

        try {
            DefaultTableModel dt = (DefaultTableModel) userDetails.getModel();
            Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
            dt.setRowCount(0);
            Statement st = con.createStatement();
            String query = "SELECT * FROM rooms";
            
            ResultSet rs = st.executeQuery(query);
                
            while (rs.next()) {
                Vector v = new Vector();
                
                v.add(rs.getString(1)); 
                v.add(rs.getString(2)); 
                v.add(rs.getString(3)); 
                v.add(rs.getString(4)); 
                v.add(rs.getString(5)); 
                v.add(rs.getString(6)); 
                v.add(rs.getString(7));
                
                dt.addRow(v);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(), "Something wrong with getting the user database.", "Error", JOptionPane.ERROR_MESSAGE);
            System.err.println("Error: Something wrong with getting the user database.");
            System.err.println("Error Message: " + e.getMessage());
        }
    }
    
    public void loadRoomsData() {
        String SUrl, SUser, SPass;
            SUrl = "jdbc:MySQL://localhost:3306/akatsukihotel_user_database";
            SUser = "root";
            SPass = "";
        
        try (Connection con = DriverManager.getConnection(SUrl, SUser, SPass)) {
            Statement st = con.createStatement();
            String query = "SELECT * FROM rooms ORDER BY id";
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
                String roomtypes = rs.getString("RoomType");
                roomSelection.addItem(roomtypes);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    public void selectedRoom() {
        String SUrl, SUser, SPass;
            SUrl = "jdbc:MySQL://localhost:3306/akatsukihotel_user_database";
            SUser = "root";
            SPass = "";
        
        try (Connection con = DriverManager.getConnection(SUrl, SUser, SPass)) {
            Statement st = con.createStatement();
            String query = "SELECT * FROM rooms WHERE id = " + selectRoom;
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
                String roomtypename, goodfor, goodfor1, goodfor2, Price1, Price2;
                    roomtypename = rs.getString("RoomType");
                    goodfor = rs.getString("GoodFor");
                    goodfor1 = rs.getString("GoodFor1");
                    goodfor2 = rs.getString("GoodFor2");
                    Price1 = rs.getString("Price1");
                    Price2 = rs.getString("Price2");
                roomName.setText(roomtypename);
                goodFor.setText(goodfor);
                goodFor1.setText(goodfor1);
                goodFor2.setText(goodfor2);
                price1.setText(Price1);
                price2.setText(Price2);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    public void uploadData() {
        String SUrl, SUser, SPass;
            SUrl = "jdbc:MySQL://localhost:3306/akatsukihotel_user_database";
            SUser = "root";
            SPass = "";
            
        String roomname, goodfor, goodfor1, goodfor2, Price1, Price2;
            roomname = roomName.getText();
            goodfor = goodFor.getText();
            goodfor1 = goodFor1.getText();
            goodfor2 = goodFor2.getText();
            Price1 = price1.getText();
            Price2 = price2.getText();
            
        try (Connection con = DriverManager.getConnection(SUrl, SUser, SPass)) {
            InputStream isImg1, isImg2, isImg3;
                isImg1 = new FileInputStream(new File(Img1));
                isImg2 = new FileInputStream(new File(Img2));
                isImg3 = new FileInputStream(new File(Img3));
            String query = "UPDATE rooms "
                    + "SET RoomType = ?, GoodFor = ?, GoodFor1 = ?, GoodFor2 = ?, Price1 = ?, Price2 = ?, Img1 = ?, Img2 = ?, Img3 = ? "
                    + "WHERE id = " + selectRoom;
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, roomname);
            pst.setString(2, goodfor);
            pst.setString(3, goodfor1);
            pst.setString(4, goodfor2);
            pst.setString(5, Price1);
            pst.setString(6, Price2);
            pst.setBlob(7, isImg1);
            pst.setBlob(8, isImg2);
            pst.setBlob(9, isImg3);
            pst.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
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
        toppanel = new javax.swing.JPanel();
        textQuote = new javax.swing.JLabel();
        textWelcom = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        gallery1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        img3Upload = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        userDetails = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        image3 = new javax.swing.JButton();
        roomSelection = new javax.swing.JComboBox();
        goback = new javax.swing.JButton();
        goodFor = new javax.swing.JTextField();
        roomName = new javax.swing.JTextField();
        goodFor2 = new javax.swing.JTextField();
        goodFor1 = new javax.swing.JTextField();
        price2 = new javax.swing.JTextField();
        price1 = new javax.swing.JTextField();
        updatedata = new javax.swing.JButton();
        image1 = new javax.swing.JButton();
        image2 = new javax.swing.JButton();
        updatedata5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        img1Upload = new javax.swing.JLabel();
        img2Upload = new javax.swing.JLabel();
        img1Upload1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Akatsuki Hotel Inc.");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        panelWrapper.setBackground(new java.awt.Color(255, 255, 255));
        panelWrapper.setMinimumSize(new java.awt.Dimension(1300, 870));
        panelWrapper.setPreferredSize(new java.awt.Dimension(1900, 980));

        toppanel.setBackground(new java.awt.Color(28, 42, 57));

        textQuote.setFont(new java.awt.Font("Freestyle Script", 0, 30)); // NOI18N
        textQuote.setForeground(new java.awt.Color(255, 255, 255));
        textQuote.setText("Your home away from home");

        textWelcom.setFont(new java.awt.Font("Baskerville Old Face", 1, 36)); // NOI18N
        textWelcom.setForeground(new java.awt.Color(255, 255, 255));
        textWelcom.setText("Akatsuki Hotel Inc.");

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logoMini.png"))); // NOI18N

        gallery1.setBackground(new java.awt.Color(255, 255, 255));
        gallery1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        gallery1.setForeground(new java.awt.Color(255, 255, 255));
        gallery1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/profile.png"))); // NOI18N
        gallery1.setText("Administrator");
        gallery1.setBorderPainted(false);
        gallery1.setContentAreaFilled(false);
        gallery1.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        gallery1.setPreferredSize(new java.awt.Dimension(80, 80));
        gallery1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                gallery1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                gallery1FocusLost(evt);
            }
        });
        gallery1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                gallery1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                gallery1MouseExited(evt);
            }
        });
        gallery1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gallery1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout toppanelLayout = new javax.swing.GroupLayout(toppanel);
        toppanel.setLayout(toppanelLayout);
        toppanelLayout.setHorizontalGroup(
            toppanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toppanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(toppanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textWelcom)
                    .addGroup(toppanelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(textQuote)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(gallery1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        toppanelLayout.setVerticalGroup(
            toppanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toppanelLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(toppanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(toppanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(gallery1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(toppanelLayout.createSequentialGroup()
                        .addComponent(textWelcom)
                        .addGap(4, 4, 4)
                        .addComponent(textQuote))))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        img3Upload.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        img3Upload.setText("Upload");
        jPanel1.add(img3Upload, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 720, 350, 40));

        userDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Room Type", "Good For", "Good For 1", "Good For 2", "Price 1", "Price 2"
            }
        ));
        userDetails.setToolTipText("");
        jScrollPane2.setViewportView(userDetails);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 120, 1130, 710));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, -10, 10, 900));

        image3.setBackground(new java.awt.Color(255, 255, 255));
        image3.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        image3.setText("Upload Image 3");
        image3.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        image3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                image3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                image3MouseExited(evt);
            }
        });
        image3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                image3ActionPerformed(evt);
            }
        });
        jPanel1.add(image3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 720, 220, 40));

        roomSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomSelectionActionPerformed(evt);
            }
        });
        jPanel1.add(roomSelection, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 230, 60));

        goback.setBackground(new java.awt.Color(255, 255, 255));
        goback.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        goback.setForeground(new java.awt.Color(230, 192, 104));
        goback.setText("Go Back");
        goback.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        goback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                gobackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                gobackMouseExited(evt);
            }
        });
        goback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gobackActionPerformed(evt);
            }
        });
        jPanel1.add(goback, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 160, 40));

        goodFor.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        goodFor.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Good For", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 10))); // NOI18N
        jPanel1.add(goodFor, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 410, 50));

        roomName.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        roomName.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Room Type Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 10))); // NOI18N
        jPanel1.add(roomName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 410, 50));

        goodFor2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        goodFor2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Good For 2", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 10))); // NOI18N
        jPanel1.add(goodFor2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 410, 50));

        goodFor1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        goodFor1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Good For 1", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 10))); // NOI18N
        jPanel1.add(goodFor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 410, 50));

        price2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        price2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Price 2", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 10))); // NOI18N
        price2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                price2KeyTyped(evt);
            }
        });
        jPanel1.add(price2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, 410, 50));

        price1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        price1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Price 1", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 10))); // NOI18N
        price1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                price1KeyTyped(evt);
            }
        });
        jPanel1.add(price1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 410, 50));

        updatedata.setBackground(new java.awt.Color(255, 255, 255));
        updatedata.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        updatedata.setForeground(new java.awt.Color(230, 192, 104));
        updatedata.setText("Update Data");
        updatedata.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        updatedata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updatedataMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updatedataMouseExited(evt);
            }
        });
        updatedata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatedataActionPerformed(evt);
            }
        });
        jPanel1.add(updatedata, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 780, 160, 50));

        image1.setBackground(new java.awt.Color(255, 255, 255));
        image1.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        image1.setText("Upload Image 1");
        image1.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        image1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                image1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                image1MouseExited(evt);
            }
        });
        image1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                image1ActionPerformed(evt);
            }
        });
        jPanel1.add(image1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 620, 220, 40));

        image2.setBackground(new java.awt.Color(255, 255, 255));
        image2.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        image2.setText("Upload Image 2");
        image2.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        image2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                image2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                image2MouseExited(evt);
            }
        });
        image2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                image2ActionPerformed(evt);
            }
        });
        jPanel1.add(image2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 670, 220, 40));

        updatedata5.setBackground(new java.awt.Color(255, 255, 255));
        updatedata5.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        updatedata5.setText("Update Data");
        updatedata5.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        updatedata5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updatedata5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updatedata5MouseExited(evt);
            }
        });
        updatedata5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatedata5ActionPerformed(evt);
            }
        });
        jPanel1.add(updatedata5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 620, -1, 40));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel2.setText("Room Details");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 70, -1, -1));

        img1Upload.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        img1Upload.setText("Upload");
        jPanel1.add(img1Upload, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 620, 350, 40));

        img2Upload.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        img2Upload.setText("Upload");
        jPanel1.add(img2Upload, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 670, 350, 40));

        img1Upload1.setFont(new java.awt.Font("Century Gothic", 2, 18)); // NOI18N
        img1Upload1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        img1Upload1.setText("Preffered Image Size (380 x 380)");
        jPanel1.add(img1Upload1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 570, 580, 40));

        javax.swing.GroupLayout panelWrapperLayout = new javax.swing.GroupLayout(panelWrapper);
        panelWrapper.setLayout(panelWrapperLayout);
        panelWrapperLayout.setHorizontalGroup(
            panelWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toppanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1900, Short.MAX_VALUE)
        );
        panelWrapperLayout.setVerticalGroup(
            panelWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelWrapperLayout.createSequentialGroup()
                .addComponent(toppanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 874, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelWrapper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelWrapper, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gallery1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_gallery1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_gallery1FocusGained

    private void gallery1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_gallery1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_gallery1FocusLost

    private void gallery1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gallery1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_gallery1MouseEntered

    private void gallery1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gallery1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_gallery1MouseExited

    private void gallery1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gallery1ActionPerformed
        
    }//GEN-LAST:event_gallery1ActionPerformed

    private void image3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_image3MouseEntered
       
    }//GEN-LAST:event_image3MouseEntered

    private void image3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_image3MouseExited
        
    }//GEN-LAST:event_image3MouseExited

    private void image3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_image3ActionPerformed
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("*PNG", "png");
        fc.setFileFilter(fnef);
        fc.setAcceptAllFileFilterUsed(false);
        int load = fc.showOpenDialog(null);
        File f = fc.getSelectedFile();
        String path = f.getAbsolutePath();
        
        if (load == fc.APPROVE_OPTION) {
            Img3 = path;
            System.out.println(Img3);
            img3Upload.setText("Uploaded!");
        }
    }//GEN-LAST:event_image3ActionPerformed

    private void roomSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomSelectionActionPerformed
        selectRoom = roomSelection.getSelectedIndex() + 1;
        System.out.println("Room Selected: Room " + selectRoom);
        selectedRoom();
    }//GEN-LAST:event_roomSelectionActionPerformed

    private void gobackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gobackMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_gobackMouseEntered

    private void gobackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gobackMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_gobackMouseExited

    private void gobackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gobackActionPerformed
        Admin a = new Admin();
        a.setVisible(true);
        a.pack();
        a.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_gobackActionPerformed

    private void updatedataMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatedataMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_updatedataMouseEntered

    private void updatedataMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatedataMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_updatedataMouseExited

    private void updatedataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatedataActionPerformed
        System.out.println("Upload Data Selected!");
        
        if (Img1 == null || Img2 == null || Img3 == null || "".equals(roomName.getText()) || "".equals(goodFor.getText()) || "".equals(goodFor1.getText()) || "".equals(goodFor2.getText()) || "".equals(price1.getText()) || "".equals(price2.getText()) ) {
            JOptionPane.showMessageDialog(new JFrame(), "Please fill all the text fields and add all images!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            uploadData();
            tableDataLoad();
            roomSelection.removeAllItems();
            loadRoomsData();
            Img1 = null;
            Img2 = null;
            Img3 = null;
            img1Upload.setText("Upload");
            img2Upload.setText("Upload");
            img3Upload.setText("Upload");
        }
        
    }//GEN-LAST:event_updatedataActionPerformed

    private void image1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_image1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_image1MouseEntered

    private void image1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_image1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_image1MouseExited

    private void image1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_image1ActionPerformed
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("*PNG", "png");
        fc.setFileFilter(fnef);
        fc.setAcceptAllFileFilterUsed(false);
        int load = fc.showOpenDialog(null);
        File f = fc.getSelectedFile();
        String path = f.getAbsolutePath();
        
        if (load == fc.APPROVE_OPTION) {
            Img1 = path;
            System.out.println(Img1);
            img1Upload.setText("Uploaded!");
        }
    }//GEN-LAST:event_image1ActionPerformed

    private void image2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_image2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_image2MouseEntered

    private void image2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_image2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_image2MouseExited

    private void image2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_image2ActionPerformed
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("*PNG", "png");
        fc.addChoosableFileFilter(fnef);
        fc.setAcceptAllFileFilterUsed(false);
        int load = fc.showOpenDialog(null);
        File f = fc.getSelectedFile();
        String path = f.getAbsolutePath();
        
        
        if (load == fc.APPROVE_OPTION) {
            Img2 = path;
            System.out.println(Img2);
            img2Upload.setText("Uploaded!");
        }
    }//GEN-LAST:event_image2ActionPerformed

    private void updatedata5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatedata5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_updatedata5MouseEntered

    private void updatedata5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatedata5MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_updatedata5MouseExited

    private void updatedata5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatedata5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updatedata5ActionPerformed

    private void price1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_price1KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_price1KeyTyped

    private void price2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_price2KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_price2KeyTyped

    /**
     * @param args the command line arguments
     */

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton gallery1;
    public javax.swing.JButton goback;
    private javax.swing.JTextField goodFor;
    private javax.swing.JTextField goodFor1;
    private javax.swing.JTextField goodFor2;
    public javax.swing.JButton image1;
    public javax.swing.JButton image2;
    public javax.swing.JButton image3;
    private javax.swing.JLabel img1Upload;
    private javax.swing.JLabel img1Upload1;
    private javax.swing.JLabel img2Upload;
    private javax.swing.JLabel img3Upload;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel panelWrapper;
    private javax.swing.JTextField price1;
    private javax.swing.JTextField price2;
    private javax.swing.JTextField roomName;
    private javax.swing.JComboBox roomSelection;
    private javax.swing.JLabel textQuote;
    private javax.swing.JLabel textWelcom;
    private javax.swing.JPanel toppanel;
    public javax.swing.JButton updatedata;
    public javax.swing.JButton updatedata5;
    private javax.swing.JTable userDetails;
    // End of variables declaration//GEN-END:variables
}
