/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loggedin;

import AkatsukiHotel.Login;
import java.awt.Color;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ivan Adcan
 */
public class Profile extends javax.swing.JFrame {
    
    String textFileRead;

    /**
     * Creates new form Login
     */
    public Profile() {
        initComponents();
        tableDataLoad();
        userData();
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
    
    public String readData() {
        try {
            List<String> lines = Files.readAllLines(Paths.get("emailCheck.txt"));
            for (String line : lines) {
                System.out.println(line);
                textFileRead = line;
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
        return textFileRead;
    }
    
    public void tableDataLoad() {
        String SUrl, SUser, SPass;
            SUrl = "jdbc:MySQL://localhost:3306/akatsukihotel_user_database";
            SUser = "root";
            SPass = "";

        try {
            readData();
            
            DefaultTableModel dt = (DefaultTableModel) userData.getModel();
            Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
            dt.setRowCount(0);
            Statement st = con.createStatement();
            String query = "SELECT * FROM u" + textFileRead;
            
            ResultSet rs = st.executeQuery(query);
                
            while (rs.next()) {
                Vector v = new Vector();
                
                v.add(rs.getString(2)); //DateBooked
                v.add(rs.getString(3)); //RoomType
                v.add(rs.getString(4)); //Price
                v.add(rs.getString(5)); //RoomSchedule
                
                dt.addRow(v);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(), "Something wrong with getting the user database.", "Error", JOptionPane.ERROR_MESSAGE);
            System.err.println("Error: Something wrong with getting the user database.");
            System.err.println("Error Message: " + e.getMessage());
        }
    }
    
    public void userData() {
        String SUrl, SUser, SPass;
            SUrl = "jdbc:MySQL://localhost:3306/akatsukihotel_user_database";
            SUser = "root";
            SPass = "";
            
        try {
            readData();
            
            Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
            Statement s = con.createStatement();
            String query = "SELECT * FROM user WHERE id = " + textFileRead;
            ResultSet rs = s.executeQuery(query);
            
            while (rs.next()) {
                String name, username, email, phone, gender, birthday, address;
                    name = rs.getString("first_name") + " " + rs.getString("last_name");
                    username = rs.getString("username");
                    email = rs.getString("email");
                    phone =  rs.getString("phone");
                    gender = rs.getString("gender");
                    birthday = rs.getString("birthday");
                    address = rs.getString("address");
                
                textName.setText(name);
                textUsername.setText(username);
                textEmail.setText(email);
                textPhone.setText(phone);
                textGender.setText(gender);
                textBirthday.setText(birthday);
                textAddress.setText(address);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    public void sidepanelChoice(int choice) {
        Home home = new Home();
        ReserveOld reserve = new ReserveOld();
        Gallery gallery = new Gallery();
        Contact contact = new Contact();
        About about = new About();
        Profile profile = new Profile();
        
        int c = choice;
        if (c == 0) {
            home.setVisible(true);
            home.setLocationRelativeTo(null);
        }
        if (c == 1) {
            reserve.setVisible(true);
            reserve.setLocationRelativeTo(null);
        }
        if (c == 2) {
            gallery.setVisible(true);
            gallery.setLocationRelativeTo(null);
        }
        if (c == 3) {
            contact.setVisible(true);
            contact.setLocationRelativeTo(null);
        }
        if (c == 4) {
            about.setVisible(true);
            about.setLocationRelativeTo(null);
        }
        if (c == 5) {
            profile.setVisible(true);
            profile.setLocationRelativeTo(null);
        }
        this.dispose();
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
        jLabel1 = new javax.swing.JLabel();
        sidepanel = new javax.swing.JPanel();
        home = new javax.swing.JButton();
        reserve = new javax.swing.JButton();
        gallery = new javax.swing.JButton();
        contact = new javax.swing.JButton();
        about = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        insidepanel = new javax.swing.JPanel();
        panelProfile = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        textUsername = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        textName = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        textEmail = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        textGender = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        textBirthday = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        textAddress = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        textPhone = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel13 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        userData = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Akatsuki Hotel Inc.");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        panelWrapper.setBackground(new java.awt.Color(255, 255, 255));
        panelWrapper.setMinimumSize(new java.awt.Dimension(1300, 870));
        panelWrapper.setPreferredSize(new java.awt.Dimension(1900, 980));

        toppanel.setBackground(new java.awt.Color(28, 42, 57));
        toppanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textQuote.setFont(new java.awt.Font("Freestyle Script", 0, 30)); // NOI18N
        textQuote.setForeground(new java.awt.Color(255, 255, 255));
        textQuote.setText("Your home away from home");
        toppanel.add(textQuote, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, -1, -1));

        textWelcom.setFont(new java.awt.Font("Baskerville Old Face", 1, 36)); // NOI18N
        textWelcom.setForeground(new java.awt.Color(255, 255, 255));
        textWelcom.setText("Akatsuki Hotel Inc.");
        toppanel.add(textWelcom, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, -1));

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logoMini.png"))); // NOI18N
        toppanel.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 13, 99, 101));

        gallery1.setBackground(new java.awt.Color(255, 255, 255));
        gallery1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        gallery1.setForeground(new java.awt.Color(255, 255, 255));
        gallery1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/profile.png"))); // NOI18N
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
        toppanel.add(gallery1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1809, 13, -1, 88));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pfp-gold-bg.png"))); // NOI18N
        toppanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1809, -6, -1, -1));

        sidepanel.setBackground(new java.awt.Color(28, 42, 57));
        sidepanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        home.setBackground(new java.awt.Color(255, 255, 255));
        home.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        home.setForeground(new java.awt.Color(255, 255, 255));
        home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/home.png"))); // NOI18N
        home.setText("Home");
        home.setBorderPainted(false);
        home.setContentAreaFilled(false);
        home.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        home.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        home.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                homeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                homeFocusLost(evt);
            }
        });
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                homeMouseExited(evt);
            }
        });
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });
        sidepanel.add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 35, 171, -1));

        reserve.setBackground(new java.awt.Color(255, 255, 255));
        reserve.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        reserve.setForeground(new java.awt.Color(255, 255, 255));
        reserve.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/reserve.png"))); // NOI18N
        reserve.setText("Reserve");
        reserve.setBorderPainted(false);
        reserve.setContentAreaFilled(false);
        reserve.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        reserve.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        reserve.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                reserveFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                reserveFocusLost(evt);
            }
        });
        reserve.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                reserveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reserveMouseExited(evt);
            }
        });
        reserve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reserveActionPerformed(evt);
            }
        });
        sidepanel.add(reserve, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 111, 171, -1));

        gallery.setBackground(new java.awt.Color(255, 255, 255));
        gallery.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        gallery.setForeground(new java.awt.Color(255, 255, 255));
        gallery.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/gallery.png"))); // NOI18N
        gallery.setText("Gallery");
        gallery.setBorderPainted(false);
        gallery.setContentAreaFilled(false);
        gallery.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        gallery.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        gallery.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                galleryFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                galleryFocusLost(evt);
            }
        });
        gallery.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                galleryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                galleryMouseExited(evt);
            }
        });
        gallery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                galleryActionPerformed(evt);
            }
        });
        sidepanel.add(gallery, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 187, 171, -1));

        contact.setBackground(new java.awt.Color(255, 255, 255));
        contact.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        contact.setForeground(new java.awt.Color(255, 255, 255));
        contact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/contact.png"))); // NOI18N
        contact.setText("Contact");
        contact.setBorderPainted(false);
        contact.setContentAreaFilled(false);
        contact.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        contact.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        contact.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                contactMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                contactMouseExited(evt);
            }
        });
        contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactActionPerformed(evt);
            }
        });
        sidepanel.add(contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 641, 171, -1));

        about.setBackground(new java.awt.Color(255, 255, 255));
        about.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        about.setForeground(new java.awt.Color(255, 255, 255));
        about.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/about.png"))); // NOI18N
        about.setText("About");
        about.setBorderPainted(false);
        about.setContentAreaFilled(false);
        about.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        about.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        about.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                aboutFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                aboutFocusLost(evt);
            }
        });
        about.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                aboutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                aboutMouseExited(evt);
            }
        });
        about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutActionPerformed(evt);
            }
        });
        sidepanel.add(about, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 722, -1, -1));

        logout.setBackground(new java.awt.Color(255, 0, 0));
        logout.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        logout.setForeground(new java.awt.Color(255, 255, 255));
        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logout.png"))); // NOI18N
        logout.setText("Log Out");
        logout.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        sidepanel.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 803, 171, -1));

        insidepanel.setBackground(new java.awt.Color(255, 255, 255));
        insidepanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelProfile.setBackground(new java.awt.Color(255, 255, 255));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255, 175));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/profileBlack.png"))); // NOI18N
        jPanel10.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 30, 715, -1));

        textUsername.setFont(new java.awt.Font("Century Gothic", 0, 48)); // NOI18N
        textUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textUsername.setText("Username");
        jPanel10.add(textUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 161, 715, -1));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255,100));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel36.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel36.setText("Descriptions:");
        jPanel11.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 14, -1, -1));

        jLabel47.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel47.setText("Name:");
        jPanel11.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        textName.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        textName.setText("Null");
        jPanel11.add(textName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 470, -1));

        jLabel49.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel49.setText("Email:");
        jPanel11.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 59, -1));

        textEmail.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        textEmail.setText("Null");
        jPanel11.add(textEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 470, -1));

        jLabel51.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel51.setText("Gender:");
        jPanel11.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 89, -1));

        textGender.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        textGender.setText("Null");
        jPanel11.add(textGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 440, -1));

        jLabel53.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel53.setText("Birthday:");
        jPanel11.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 89, -1));

        textBirthday.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        textBirthday.setText("Null");
        jPanel11.add(textBirthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 440, -1));

        jLabel55.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel55.setText("Address:");
        jPanel11.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 89, -1));

        textAddress.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        textAddress.setText("Null");
        jPanel11.add(textAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 440, -1));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel2.setText("Change Password");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel11.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, -1, -1));

        jLabel58.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel58.setText("Phone:");
        jPanel11.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 90, -1));

        textPhone.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        textPhone.setText("Null");
        jPanel11.add(textPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 450, -1));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        jLabel57.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setText("Reservations");

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));

        userData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Date", "Room Type", "Price", "Schedule"
            }
        ));
        userData.setEnabled(false);
        jScrollPane3.setViewportView(userData);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel57, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addGap(0, 11, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel57)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel13);

        jPanel11.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 510, 250));

        jPanel10.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 251, 590, 550));

        javax.swing.GroupLayout panelProfileLayout = new javax.swing.GroupLayout(panelProfile);
        panelProfile.setLayout(panelProfileLayout);
        panelProfileLayout.setHorizontalGroup(
            panelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProfileLayout.createSequentialGroup()
                .addGap(478, 478, 478)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(494, Short.MAX_VALUE))
        );
        panelProfileLayout.setVerticalGroup(
            panelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProfileLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        insidepanel.add(panelProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1700, 880));

        javax.swing.GroupLayout panelWrapperLayout = new javax.swing.GroupLayout(panelWrapper);
        panelWrapper.setLayout(panelWrapperLayout);
        panelWrapperLayout.setHorizontalGroup(
            panelWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toppanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelWrapperLayout.createSequentialGroup()
                .addComponent(sidepanel, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(insidepanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1705, Short.MAX_VALUE))
        );
        panelWrapperLayout.setVerticalGroup(
            panelWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelWrapperLayout.createSequentialGroup()
                .addComponent(toppanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(insidepanel, javax.swing.GroupLayout.PREFERRED_SIZE, 874, Short.MAX_VALUE)
                    .addComponent(sidepanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        int out = JOptionPane.showConfirmDialog(null, "Do you really want to logout?", "Select", JOptionPane.YES_NO_OPTION);
        if (out == 0) {
            Login login = new Login();
            this.setVisible(false);
            login.setVisible(true);
            login.setLocationRelativeTo(null);
            this.dispose();
        }
    }//GEN-LAST:event_logoutActionPerformed

    private void aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutActionPerformed
        this.sidepanelChoice(4);
    }//GEN-LAST:event_aboutActionPerformed

    private void aboutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutMouseExited
        Color white;
        white = new Color(255,255,255);
        about.setForeground(white);
    }//GEN-LAST:event_aboutMouseExited

    private void aboutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutMouseEntered
        Color gold;
        gold = new Color(230,192,104);
        about.setForeground(gold);
    }//GEN-LAST:event_aboutMouseEntered

    private void contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactActionPerformed
        this.sidepanelChoice(3);
    }//GEN-LAST:event_contactActionPerformed

    private void contactMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contactMouseExited
        Color white;
        white = new Color(255,255,255);
        contact.setForeground(white);
    }//GEN-LAST:event_contactMouseExited

    private void contactMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contactMouseEntered
        Color gold;
        gold = new Color(230,192,104);
        contact.setForeground(gold);
    }//GEN-LAST:event_contactMouseEntered

    private void galleryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_galleryActionPerformed
        this.sidepanelChoice(2);
    }//GEN-LAST:event_galleryActionPerformed

    private void galleryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_galleryMouseExited
        Color white;
        white = new Color(255,255,255);
        gallery.setForeground(white);
    }//GEN-LAST:event_galleryMouseExited

    private void galleryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_galleryMouseEntered
        Color gold;
        gold = new Color(230,192,104);
        gallery.setForeground(gold);
    }//GEN-LAST:event_galleryMouseEntered

    private void reserveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reserveActionPerformed
        this.sidepanelChoice(1);
    }//GEN-LAST:event_reserveActionPerformed

    private void reserveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reserveMouseExited
        // TODO add your handling code here:
        Color white = new Color(255,255,255);
        reserve.setForeground(white);
    }//GEN-LAST:event_reserveMouseExited

    private void reserveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reserveMouseEntered
        Color gold;
        gold = new Color(230,192,104);
        reserve.setForeground(gold);
    }//GEN-LAST:event_reserveMouseEntered

    private void homeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseEntered
        Color gold;
        gold = new Color(230,192,104);
        home.setForeground(gold);
    }//GEN-LAST:event_homeMouseEntered

    private void homeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseExited
        Color white = new Color(255,255,255);
        home.setForeground(white);
    }//GEN-LAST:event_homeMouseExited

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
        this.sidepanelChoice(0);
    }//GEN-LAST:event_homeActionPerformed

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked

    }//GEN-LAST:event_homeMouseClicked

    private void homeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_homeFocusGained
     
    }//GEN-LAST:event_homeFocusGained

    private void homeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_homeFocusLost
       
    }//GEN-LAST:event_homeFocusLost

    private void reserveFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_reserveFocusGained
       
    }//GEN-LAST:event_reserveFocusGained

    private void reserveFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_reserveFocusLost
      
    }//GEN-LAST:event_reserveFocusLost

    private void galleryFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_galleryFocusGained
     
    }//GEN-LAST:event_galleryFocusGained

    private void galleryFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_galleryFocusLost
       
    }//GEN-LAST:event_galleryFocusLost

    private void aboutFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_aboutFocusGained
        
    }//GEN-LAST:event_aboutFocusGained

    private void aboutFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_aboutFocusLost
    
    }//GEN-LAST:event_aboutFocusLost

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

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        PWForgot pwforgot = new PWForgot();
        pwforgot.setVisible(true);
        pwforgot.pack();
        pwforgot.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    /**
     * @param args the command line arguments
     */

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton about;
    public javax.swing.JButton contact;
    public javax.swing.JButton gallery;
    public javax.swing.JButton gallery1;
    public javax.swing.JButton home;
    private javax.swing.JPanel insidepanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel logo;
    public javax.swing.JButton logout;
    private javax.swing.JPanel panelProfile;
    private javax.swing.JPanel panelWrapper;
    public javax.swing.JButton reserve;
    private javax.swing.JPanel sidepanel;
    private javax.swing.JLabel textAddress;
    private javax.swing.JLabel textBirthday;
    private javax.swing.JLabel textEmail;
    private javax.swing.JLabel textGender;
    private javax.swing.JLabel textName;
    private javax.swing.JLabel textPhone;
    private javax.swing.JLabel textQuote;
    private javax.swing.JLabel textUsername;
    private javax.swing.JLabel textWelcom;
    private javax.swing.JPanel toppanel;
    private javax.swing.JTable userData;
    // End of variables declaration//GEN-END:variables
}
