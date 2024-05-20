/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loggedin;

import AkatsukiHotel.Login;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Ivan Adcan
 */
public class Home extends javax.swing.JFrame {

    String oldUser;
    int count = 1;

    /**
     * Creates new form Login
     */
    public Home() {
        initComponents();
        oldUserCheck();
        slideshow();
    }
    
    public void slideshow() {
        new Thread() {
            @Override
            public void run() {
                String SUrl, SUser, SPass;
                    SUrl = "jdbc:MySQL://localhost:3306/akatsukihotel_user_database";
                    SUser = "root";
                    SPass = "";
                for (int i = 0; i >= 0; i++) {
                    try (Connection con = DriverManager.getConnection(SUrl, SUser, SPass)) {
                        Statement st = con.createStatement();
                        String query = "SELECT * FROM rooms WHERE id = " + count;
                        ResultSet rs = st.executeQuery(query);
                        rs.next();

                        Blob imageBlob = rs.getBlob("Img1");
                        byte[] bytes = imageBlob.getBytes(1, (int) imageBlob.length());
                        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
                        BufferedImage image = ImageIO.read(bis);

                        switch (count) {
                            case 1:
                                showPicMid.setIcon(new ImageIcon(image));
                                Thread.sleep(2000);
                                count = 2;
                                break;
                            case 2:
                                showPicMid.setIcon(new ImageIcon(image));
                                Thread.sleep(2000);
                                count = 3;
                                break;
                            case 3:
                                showPicMid.setIcon(new ImageIcon(image));
                                Thread.sleep(2000);
                                count = 4;
                                break;
                            case 4:
                                showPicMid.setIcon(new ImageIcon(image));
                                Thread.sleep(2000);
                                count = 5;
                                break;
                            case 5:
                                showPicMid.setIcon(new ImageIcon(image));
                                Thread.sleep(2000);
                                count = 6;
                                break;
                            case 6:
                                showPicMid.setIcon(new ImageIcon(image));
                                Thread.sleep(2000);
                                count = 7;
                                break;
                            case 7:
                                showPicMid.setIcon(new ImageIcon(image));
                                Thread.sleep(2000);
                                count = 8;
                                break;
                            case 8:
                                showPicMid.setIcon(new ImageIcon(image));
                                Thread.sleep(2000);
                                count = 1;
                                break;
                        }
                    } catch (Exception e) {
                        System.err.println("Error: " + e.getMessage());
                    }
                }
            }
        }.start();
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
        panelHome = new javax.swing.JPanel();
        showPicMid = new javax.swing.JLabel();
        pic1 = new javax.swing.JButton();
        pic2 = new javax.swing.JButton();
        pic3 = new javax.swing.JButton();
        pic4 = new javax.swing.JButton();
        pic5 = new javax.swing.JButton();
        pic6 = new javax.swing.JButton();
        pic7 = new javax.swing.JButton();
        pic8 = new javax.swing.JButton();
        textWelcom2 = new javax.swing.JLabel();
        textWelcom3 = new javax.swing.JLabel();
        textWelcom4 = new javax.swing.JLabel();
        book = new javax.swing.JButton();
        gtGallery = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

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
        gallery1.setFocusable(false);
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
        sidepanel.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 803, 170, -1));

        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sidepanel-bg-gold.png"))); // NOI18N
        sidepanel.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, 26, 260, 60));

        insidepanel.setBackground(new java.awt.Color(255, 255, 255));
        insidepanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelHome.setBackground(new java.awt.Color(255, 255, 255));
        panelHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        showPicMid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        showPicMid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        showPicMid.setMaximumSize(new java.awt.Dimension(380, 380));
        showPicMid.setMinimumSize(new java.awt.Dimension(380, 380));
        showPicMid.setPreferredSize(new java.awt.Dimension(380, 380));
        panelHome.add(showPicMid, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 200, -1, -1));

        pic1.setBackground(new java.awt.Color(255, 255, 255));
        pic1.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        pic1.setForeground(new java.awt.Color(0, 104, 104));
        pic1.setText("1");
        pic1.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        pic1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pic1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                pic1FocusLost(evt);
            }
        });
        pic1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pic1ActionPerformed(evt);
            }
        });
        panelHome.add(pic1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 640, -1, -1));

        pic2.setBackground(new java.awt.Color(255, 255, 255));
        pic2.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        pic2.setForeground(new java.awt.Color(0, 104, 104));
        pic2.setText("2");
        pic2.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        pic2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pic2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                pic2FocusLost(evt);
            }
        });
        pic2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pic2ActionPerformed(evt);
            }
        });
        panelHome.add(pic2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 640, -1, -1));

        pic3.setBackground(new java.awt.Color(255, 255, 255));
        pic3.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        pic3.setForeground(new java.awt.Color(0, 104, 104));
        pic3.setText("3");
        pic3.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        pic3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pic3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                pic3FocusLost(evt);
            }
        });
        pic3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pic3ActionPerformed(evt);
            }
        });
        panelHome.add(pic3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 640, -1, -1));

        pic4.setBackground(new java.awt.Color(255, 255, 255));
        pic4.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        pic4.setForeground(new java.awt.Color(0, 104, 104));
        pic4.setText("4");
        pic4.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        pic4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pic4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                pic4FocusLost(evt);
            }
        });
        pic4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pic4ActionPerformed(evt);
            }
        });
        panelHome.add(pic4, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 640, -1, -1));

        pic5.setBackground(new java.awt.Color(255, 255, 255));
        pic5.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        pic5.setForeground(new java.awt.Color(0, 104, 104));
        pic5.setText("5");
        pic5.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        pic5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pic5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                pic5FocusLost(evt);
            }
        });
        pic5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pic5ActionPerformed(evt);
            }
        });
        panelHome.add(pic5, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 640, -1, -1));

        pic6.setBackground(new java.awt.Color(255, 255, 255));
        pic6.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        pic6.setForeground(new java.awt.Color(0, 104, 104));
        pic6.setText("6");
        pic6.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        pic6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pic6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                pic6FocusLost(evt);
            }
        });
        pic6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pic6ActionPerformed(evt);
            }
        });
        panelHome.add(pic6, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 640, -1, -1));

        pic7.setBackground(new java.awt.Color(255, 255, 255));
        pic7.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        pic7.setForeground(new java.awt.Color(0, 104, 104));
        pic7.setText("7");
        pic7.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        pic7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pic7FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                pic7FocusLost(evt);
            }
        });
        pic7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pic7ActionPerformed(evt);
            }
        });
        panelHome.add(pic7, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 640, -1, -1));

        pic8.setBackground(new java.awt.Color(255, 255, 255));
        pic8.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        pic8.setForeground(new java.awt.Color(0, 104, 104));
        pic8.setText("8");
        pic8.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        pic8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pic8FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                pic8FocusLost(evt);
            }
        });
        pic8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pic8ActionPerformed(evt);
            }
        });
        panelHome.add(pic8, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 640, -1, -1));

        textWelcom2.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        textWelcom2.setText("Check out the Gallery!");
        panelHome.add(textWelcom2, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 670, -1, 50));

        textWelcom3.setFont(new java.awt.Font("Baskerville Old Face", 1, 100)); // NOI18N
        textWelcom3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textWelcom3.setText("Welcome to Akatsuki Hotel!");
        panelHome.add(textWelcom3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1700, -1));

        textWelcom4.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        textWelcom4.setText("Wanna take a break and go on a vacation?");
        panelHome.add(textWelcom4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 670, -1, 50));

        book.setBackground(new java.awt.Color(255, 255, 255));
        book.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        book.setForeground(new java.awt.Color(230, 192, 104));
        book.setText("Book Now!");
        book.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        book.setFocusable(false);
        book.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bookMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bookMouseExited(evt);
            }
        });
        book.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookActionPerformed(evt);
            }
        });
        panelHome.add(book, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 730, 223, 52));

        gtGallery.setBackground(new java.awt.Color(255, 255, 255));
        gtGallery.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        gtGallery.setForeground(new java.awt.Color(230, 192, 104));
        gtGallery.setText("Gallery");
        gtGallery.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        gtGallery.setFocusable(false);
        gtGallery.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                gtGalleryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                gtGalleryMouseExited(evt);
            }
        });
        gtGallery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gtGalleryActionPerformed(evt);
            }
        });
        panelHome.add(gtGallery, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 730, 223, 52));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/aboutbg.png"))); // NOI18N
        panelHome.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1700, 880));

        insidepanel.add(panelHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1700, 880));

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
        Login login = new Login();
        int out = JOptionPane.showConfirmDialog(null, "Do you really want to logout?", "Select", JOptionPane.YES_NO_OPTION);
        if (out == 0) {
            this.setVisible(false);
            login.setVisible(true);
            login.setLocationRelativeTo(null);
        }
        this.dispose();
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

    }//GEN-LAST:event_homeMouseEntered

    private void homeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseExited

    }//GEN-LAST:event_homeMouseExited

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed

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

    private void pic1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pic1FocusGained
        
    }//GEN-LAST:event_pic1FocusGained

    private void pic1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pic1FocusLost
        
    }//GEN-LAST:event_pic1FocusLost

    private void pic1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pic1ActionPerformed
        count = 1;
        slideshow();
    }//GEN-LAST:event_pic1ActionPerformed

    private void pic2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pic2FocusGained
        
    }//GEN-LAST:event_pic2FocusGained

    private void pic2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pic2FocusLost
        
    }//GEN-LAST:event_pic2FocusLost

    private void pic2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pic2ActionPerformed
        count = 2;
        slideshow();
    }//GEN-LAST:event_pic2ActionPerformed

    private void pic3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pic3FocusGained
        
    }//GEN-LAST:event_pic3FocusGained

    private void pic3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pic3FocusLost
        
    }//GEN-LAST:event_pic3FocusLost

    private void pic3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pic3ActionPerformed
        count = 3;
        slideshow();
    }//GEN-LAST:event_pic3ActionPerformed

    private void pic5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pic5FocusGained
        
    }//GEN-LAST:event_pic5FocusGained

    private void pic5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pic5FocusLost
        
    }//GEN-LAST:event_pic5FocusLost

    private void pic5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pic5ActionPerformed
        count = 5;
        slideshow();
    }//GEN-LAST:event_pic5ActionPerformed

    private void pic4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pic4FocusGained
        
    }//GEN-LAST:event_pic4FocusGained

    private void pic4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pic4FocusLost
        
    }//GEN-LAST:event_pic4FocusLost

    private void pic4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pic4ActionPerformed
        count = 4;
        slideshow();
    }//GEN-LAST:event_pic4ActionPerformed

    private void bookMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookMouseEntered
        Color gold;
        gold = new Color(230,192,104);
        book.setBackground(gold);
        book.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_bookMouseEntered

    private void bookMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookMouseExited
        Color gold;
        gold = new Color(230,192,104);
        book.setBackground(new Color(255,255,255));
        book.setForeground(gold);
    }//GEN-LAST:event_bookMouseExited

    private void bookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookActionPerformed
        this.sidepanelChoice(1);
    }//GEN-LAST:event_bookActionPerformed

    private void pic6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pic6FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_pic6FocusGained

    private void pic6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pic6FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_pic6FocusLost

    private void pic6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pic6ActionPerformed
        count = 6;
        slideshow();
    }//GEN-LAST:event_pic6ActionPerformed

    private void pic7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pic7FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_pic7FocusGained

    private void pic7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pic7FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_pic7FocusLost

    private void pic7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pic7ActionPerformed
        count = 7;
        slideshow();
    }//GEN-LAST:event_pic7ActionPerformed

    private void pic8FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pic8FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_pic8FocusGained

    private void pic8FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pic8FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_pic8FocusLost

    private void pic8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pic8ActionPerformed
        count = 8;
        slideshow();
    }//GEN-LAST:event_pic8ActionPerformed

    private void gtGalleryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gtGalleryMouseEntered
        Color gold;
        gold = new Color(230,192,104);
        gtGallery.setBackground(gold);
        gtGallery.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_gtGalleryMouseEntered

    private void gtGalleryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gtGalleryMouseExited
        Color gold;
        gold = new Color(230,192,104);
        gtGallery.setBackground(new Color(255,255,255));
        gtGallery.setForeground(gold);
    }//GEN-LAST:event_gtGalleryMouseExited

    private void gtGalleryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gtGalleryActionPerformed
        this.sidepanelChoice(2);
    }//GEN-LAST:event_gtGalleryActionPerformed

    /**
     * @param args the command line arguments
     */

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton about;
    public javax.swing.JButton book;
    public javax.swing.JButton contact;
    public javax.swing.JButton gallery;
    public javax.swing.JButton gallery1;
    public javax.swing.JButton gtGallery;
    public javax.swing.JButton home;
    private javax.swing.JPanel insidepanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel logo;
    public javax.swing.JButton logout;
    private javax.swing.JPanel panelHome;
    private javax.swing.JPanel panelWrapper;
    public javax.swing.JButton pic1;
    public javax.swing.JButton pic2;
    public javax.swing.JButton pic3;
    public javax.swing.JButton pic4;
    public javax.swing.JButton pic5;
    public javax.swing.JButton pic6;
    public javax.swing.JButton pic7;
    public javax.swing.JButton pic8;
    public javax.swing.JButton reserve;
    private javax.swing.JLabel showPicMid;
    private javax.swing.JPanel sidepanel;
    private javax.swing.JLabel textQuote;
    private javax.swing.JLabel textWelcom;
    private javax.swing.JLabel textWelcom2;
    private javax.swing.JLabel textWelcom3;
    private javax.swing.JLabel textWelcom4;
    private javax.swing.JPanel toppanel;
    // End of variables declaration//GEN-END:variables
}
