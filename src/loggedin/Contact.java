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
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Ivan Adcan
 */
public class Contact extends javax.swing.JFrame {

    String oldUser;

    /**
     * Creates new form Login
     */
    public Contact() {
        initComponents();
        oldUserCheck();
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
    
    public String oldUserCheck() {
        try {
            List<String> lines = Files.readAllLines(Paths.get("old.txt"));
            for (String line : lines) {
                System.out.println(line);
                oldUser = line;
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
        return oldUser;
    }
    
    public void sidepanelChoice(int choice) {
        Home home = new Home();
        ReserveOld reserveOld = new ReserveOld();
        ReserveNew reserveNew = new ReserveNew();
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
            if ("0".equals(oldUser)) {
                reserveNew.setVisible(true);
                reserveNew.setLocationRelativeTo(null);
            } else {
                reserveOld.setVisible(true);
                reserveOld.setLocationRelativeTo(null);
            }
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
        sidepanel = new javax.swing.JPanel();
        home = new javax.swing.JButton();
        reserve = new javax.swing.JButton();
        gallery = new javax.swing.JButton();
        contact = new javax.swing.JButton();
        about = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        jLabel61 = new javax.swing.JLabel();
        insidepanel = new javax.swing.JPanel();
        panelContact = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        textWelcom5 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();

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
                .addComponent(gallery1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        toppanelLayout.setVerticalGroup(
            toppanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toppanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(textWelcom)
                .addGap(4, 4, 4)
                .addComponent(textQuote))
            .addGroup(toppanelLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(toppanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(toppanelLayout.createSequentialGroup()
                        .addComponent(gallery1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

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
        home.setFocusable(false);
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
        reserve.setFocusable(false);
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
        gallery.setFocusable(false);
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
        contact.setFocusable(false);
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
        about.setFocusable(false);
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
        logout.setFocusable(false);
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        sidepanel.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 803, 171, -1));

        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sidepanel-bg-gold.png"))); // NOI18N
        sidepanel.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, 631, 260, 60));

        insidepanel.setBackground(new java.awt.Color(255, 255, 255));
        insidepanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelContact.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Century Gothic", 0, 48)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("feedback@akatsukihotel.com");
        panelContact.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 370, 700, -1));

        jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 48)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("support@akatsukihotel.com");
        panelContact.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 310, 700, -1));

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Email:");
        panelContact.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 250, 320, -1));

        jLabel18.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Phone No.:");
        panelContact.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 450, 320, -1));

        jLabel22.setFont(new java.awt.Font("Century Gothic", 0, 48)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("+63 964-370-1420");
        panelContact.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 510, 700, -1));

        jLabel19.setFont(new java.awt.Font("Century Gothic", 0, 48)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("+63 990-373-1769");
        panelContact.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 570, 700, -1));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255, 130));

        textWelcom5.setFont(new java.awt.Font("Baskerville Old Face", 1, 100)); // NOI18N
        textWelcom5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textWelcom5.setText("Contact Us");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(textWelcom5, javax.swing.GroupLayout.PREFERRED_SIZE, 1700, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(textWelcom5)
                .addContainerGap(726, Short.MAX_VALUE))
        );

        panelContact.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1700, 880));

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/aboutbg.png"))); // NOI18N
        panelContact.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1700, 880));

        insidepanel.add(panelContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1700, 880));

        javax.swing.GroupLayout panelWrapperLayout = new javax.swing.GroupLayout(panelWrapper);
        panelWrapper.setLayout(panelWrapperLayout);
        panelWrapperLayout.setHorizontalGroup(
            panelWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toppanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelWrapperLayout.createSequentialGroup()
                .addComponent(sidepanel, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(insidepanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    
    }//GEN-LAST:event_contactActionPerformed

    private void contactMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contactMouseExited
        
    }//GEN-LAST:event_contactMouseExited

    private void contactMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contactMouseEntered
        
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
        this.sidepanelChoice(5);
    }//GEN-LAST:event_gallery1ActionPerformed

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
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel logo;
    public javax.swing.JButton logout;
    private javax.swing.JPanel panelContact;
    private javax.swing.JPanel panelWrapper;
    public javax.swing.JButton reserve;
    private javax.swing.JPanel sidepanel;
    private javax.swing.JLabel textQuote;
    private javax.swing.JLabel textWelcom;
    private javax.swing.JLabel textWelcom5;
    private javax.swing.JPanel toppanel;
    // End of variables declaration//GEN-END:variables
}
