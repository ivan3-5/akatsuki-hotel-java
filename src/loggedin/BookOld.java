/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loggedin;

import java.awt.Color;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Ivan Adcan
 */
public class BookOld extends javax.swing.JFrame {
    
    String roomChosen;
    String getPrice1;
    String getPrice2;
    String dateToday;
    String roomPriceSelected = null;
    String roomSchedule;
    String profileID;

    /**
     * Creates new form Login
     */
    public BookOld() {
        setUndecorated(true);
        initComponents();
        loadRoomDetails();
        todayDate();
        readData();
    }
    
    public String readData() {
        try {
            List<String> lines = Files.readAllLines(Paths.get("emailCheck.txt"));
            for (String line : lines) {
                System.out.println(line);
                profileID = line;
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
        return profileID;
    }
    
    public void bgGoldfgWhite() {
        Color gold;
        gold = new Color(230,192,104);
        setBackground(gold);
        setForeground(new Color(255,255,255));
    }
    
    public void bgWhitefgGold() {
        Color gold;
        gold = new Color(230,192,104);
        setBackground(new Color(255,255,255));
        setForeground(gold);
    }
    
    public void todayDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        dateToday = sdf.format(todayCalendar.getDate());
        today.setText(dateToday);
        System.out.println("Date Today: " + dateToday);
    }
    
    public String roomCheck() {
        try {
            List<String> lines = Files.readAllLines(Paths.get("room.txt"));
            for (String line : lines) {
                System.out.println(line);
                roomChosen = line;
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
        return roomChosen;
    }
    
    public void loadRoomDetails() {
        roomCheck();
        String SUrl, SUser, SPass;
            SUrl = "jdbc:MySQL://localhost:3306/akatsukihotel_user_database";
            SUser = "root";
            SPass = "";
        
        try (Connection con = DriverManager.getConnection(SUrl, SUser, SPass)) {
            Statement st = con.createStatement();
            String query = "SELECT * FROM rooms WHERE id = " + roomChosen;
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
                String roomtype, goodfor, goodfor1, goodfor2, Price1, Price2;
                    roomtype = rs.getString("RoomType");
                    goodfor = rs.getString("GoodFor");
                    goodfor1 = rs.getString("GoodFor1");
                    goodfor2 = rs.getString("GoodFor2");
                    Price1 = rs.getString("Price1");
                    Price2 = rs.getString("Price2");
                roomType.setText(roomtype);
                goodFor.setText(goodfor);
                goodFor1.setText("Good for " + goodfor1);
                goodFor2.setText("Good for " + goodfor2);
                price1.setText("P " + Price1);
                price2.setText("P " + Price2);
                getPrice1 = Price1;
                getPrice2 = Price2;
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    public void bookNow() {
        String SUrl, SUser, SPass;
            SUrl = "jdbc:MySQL://localhost:3306/akatsukihotel_user_database";
            SUser = "root";
            SPass = "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        roomSchedule = sdf.format(schedule.getDate());
        String roomtype;
            roomtype = roomType.getText();
        System.out.println(roomtype);
        try (Connection con = DriverManager.getConnection(SUrl, SUser, SPass)) {
            String query = "SELECT COUNT(*) FROM dateschedules WHERE Room" + roomChosen + " = '" + roomSchedule + "'";
            Statement st = con.createStatement();
            ResultSet rsCount = st.executeQuery(query);
            rsCount.next();
            int scheduled = rsCount.getInt(1);
            rsCount.close();
            System.out.println("Total: " + scheduled);
            int selected = 0;
            if (scheduled == 0) {
                if (priceSelect1.isSelected()) {
                    roomPriceSelected = getPrice1;
                    selected = 1;
                } else if (priceSelect2.isSelected()) {
                    roomPriceSelected = getPrice2;
                    selected = 1;
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Please select room price!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
                System.out.println("Selected: " + selected);
                System.out.println("Price: " + roomPriceSelected);
                
                if (1 == selected) {
                    String querySetSchedule = "INSERT INTO dateschedules (Room" + roomChosen + ", RoomNo) "
                            + "VALUES ('" + roomSchedule + "', '" + roomChosen + "')";
                    System.out.println(querySetSchedule);
                    st.execute(querySetSchedule);
                    System.out.println(profileID);
                    
                    String querySetUser = "INSERT INTO u" + profileID + " (RoomNo, DateBooked, RoomType, Price, RoomSchedule) "
                            + "VALUES ('" + roomChosen + "', '" + dateToday + "', '" + roomtype + "', '" + roomPriceSelected + "', '" + roomSchedule + "')";
                    System.out.println(querySetUser);
                    st.execute(querySetUser);
                    
                    JOptionPane.showMessageDialog(new JFrame(), "Successfully booked a hotel!", "Book", JOptionPane.INFORMATION_MESSAGE);
                    
                    this.dispose();
                }
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "This room is already scheduled on this date!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
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

        todayCalendar = new com.toedter.calendar.JCalendar();
        priceSelect = new javax.swing.ButtonGroup();
        panelWrapper1 = new javax.swing.JPanel();
        panelWrapper = new javax.swing.JPanel();
        textWelcom1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        roomType = new javax.swing.JLabel();
        goodFor = new javax.swing.JLabel();
        price1 = new javax.swing.JLabel();
        goodFor1 = new javax.swing.JLabel();
        goodFor2 = new javax.swing.JLabel();
        price2 = new javax.swing.JLabel();
        close = new javax.swing.JButton();
        schedule = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        today = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        priceSelect1 = new javax.swing.JRadioButton();
        priceSelect2 = new javax.swing.JRadioButton();
        booknow = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Akatsuki Hotel Inc.");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        panelWrapper1.setBackground(new java.awt.Color(230, 192, 104));
        panelWrapper1.setPreferredSize(new java.awt.Dimension(1900, 980));

        panelWrapper.setBackground(new java.awt.Color(255, 255, 255));
        panelWrapper.setPreferredSize(new java.awt.Dimension(1900, 980));

        textWelcom1.setFont(new java.awt.Font("Baskerville Old Face", 1, 67)); // NOI18N
        textWelcom1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textWelcom1.setText("Book");

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Room Type");

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Price");

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Good for");

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText(":");

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText(":");

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText(":");

        roomType.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        roomType.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        roomType.setText("null");

        goodFor.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        goodFor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        goodFor.setText("null");

        price1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        price1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        price1.setText("null");

        goodFor1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        goodFor1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        goodFor1.setText("Good for ");

        goodFor2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        goodFor2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        goodFor2.setText("Good for ");

        price2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        price2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        price2.setText("null");

        close.setBackground(new java.awt.Color(255, 255, 255));
        close.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        close.setForeground(new java.awt.Color(0, 104, 104));
        close.setText("X");
        close.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        close.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                closeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                closeFocusLost(evt);
            }
        });
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });

        schedule.setDate(new java.util.Date(1704038400000L));
        schedule.setDateFormatString("dd-MM-yyyy");
        schedule.setFocusCycleRoot(true);
        schedule.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Schedule");

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText(":");

        today.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        today.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        today.setText("null");

        jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText(":");

        jLabel17.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Date Today");

        priceSelect1.setBackground(new java.awt.Color(255, 255, 255));
        priceSelect.add(priceSelect1);
        priceSelect1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        priceSelect1.setText("Select");
        priceSelect1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceSelect1ActionPerformed(evt);
            }
        });

        priceSelect2.setBackground(new java.awt.Color(255, 255, 255));
        priceSelect.add(priceSelect2);
        priceSelect2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        priceSelect2.setText("Select");

        booknow.setBackground(new java.awt.Color(255, 255, 255));
        booknow.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        booknow.setForeground(new java.awt.Color(230, 192, 104));
        booknow.setText("Book Now");
        booknow.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        booknow.setFocusable(false);
        booknow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                booknowMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                booknowMouseExited(evt);
            }
        });
        booknow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                booknowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelWrapperLayout = new javax.swing.GroupLayout(panelWrapper);
        panelWrapper.setLayout(panelWrapperLayout);
        panelWrapperLayout.setHorizontalGroup(
            panelWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelWrapperLayout.createSequentialGroup()
                .addGroup(panelWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelWrapperLayout.createSequentialGroup()
                        .addGap(490, 490, 490)
                        .addComponent(close))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelWrapperLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(booknow, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelWrapperLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textWelcom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelWrapperLayout.createSequentialGroup()
                        .addGroup(panelWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelWrapperLayout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12)
                                .addGap(12, 12, 12)
                                .addComponent(roomType, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelWrapperLayout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13)
                                .addGap(12, 12, 12)
                                .addComponent(goodFor, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelWrapperLayout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16)
                                .addGap(12, 12, 12)
                                .addComponent(today, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelWrapperLayout.createSequentialGroup()
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel14)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(schedule, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelWrapperLayout.createSequentialGroup()
                                    .addGroup(panelWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(goodFor2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(goodFor1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelWrapperLayout.createSequentialGroup()
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel15)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panelWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(price1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(price2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panelWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(priceSelect1)
                                        .addComponent(priceSelect2)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelWrapperLayout.setVerticalGroup(
            panelWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelWrapperLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(close)
                .addGap(7, 7, 7)
                .addComponent(textWelcom1)
                .addGap(74, 74, 74)
                .addGroup(panelWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12)
                    .addComponent(roomType))
                .addGap(18, 18, 18)
                .addGroup(panelWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(panelWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(goodFor)))
                .addGap(18, 18, 18)
                .addGroup(panelWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addGroup(panelWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(today)))
                .addGap(18, 18, 18)
                .addGroup(panelWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(schedule, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(jLabel14)))
                .addGap(18, 18, 18)
                .addGroup(panelWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(panelWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(goodFor1)
                    .addComponent(price1)
                    .addComponent(priceSelect1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(goodFor2)
                    .addComponent(price2)
                    .addComponent(priceSelect2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                .addComponent(booknow, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95))
        );

        javax.swing.GroupLayout panelWrapper1Layout = new javax.swing.GroupLayout(panelWrapper1);
        panelWrapper1.setLayout(panelWrapper1Layout);
        panelWrapper1Layout.setHorizontalGroup(
            panelWrapper1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelWrapper1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelWrapper, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelWrapper1Layout.setVerticalGroup(
            panelWrapper1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelWrapper1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelWrapper, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelWrapper1, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelWrapper1, javax.swing.GroupLayout.PREFERRED_SIZE, 781, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_closeFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_closeFocusGained

    private void closeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_closeFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_closeFocusLost

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        this.dispose();
    }//GEN-LAST:event_closeActionPerformed

    private void priceSelect1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceSelect1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceSelect1ActionPerformed

    private void booknowMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booknowMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_booknowMouseEntered

    private void booknowMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booknowMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_booknowMouseExited

    private void booknowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_booknowActionPerformed
        bookNow();
    }//GEN-LAST:event_booknowActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton booknow;
    public javax.swing.JButton close;
    private javax.swing.JLabel goodFor;
    private javax.swing.JLabel goodFor1;
    private javax.swing.JLabel goodFor2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel panelWrapper;
    private javax.swing.JPanel panelWrapper1;
    private javax.swing.JLabel price1;
    private javax.swing.JLabel price2;
    private javax.swing.ButtonGroup priceSelect;
    private javax.swing.JRadioButton priceSelect1;
    private javax.swing.JRadioButton priceSelect2;
    private javax.swing.JLabel roomType;
    private com.toedter.calendar.JDateChooser schedule;
    private javax.swing.JLabel textWelcom1;
    private javax.swing.JLabel today;
    private com.toedter.calendar.JCalendar todayCalendar;
    // End of variables declaration//GEN-END:variables
}
