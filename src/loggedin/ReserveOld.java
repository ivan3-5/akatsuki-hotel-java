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
import java.io.FileWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


/**
 *
 * @author Ivan Adcan
 */
public class ReserveOld extends javax.swing.JFrame {

    String roomChosen;
    
    /**
     * Creates new form Login
     */
    public ReserveOld() {
        initComponents();
        getRoomDetails();
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
    
    public void getRoomDetails() {
        String SUrl, SUser, SPass;
            SUrl = "jdbc:MySQL://localhost:3306/akatsukihotel_user_database";
            SUser = "root";
            SPass = "";
        
        try (Connection con = DriverManager.getConnection(SUrl, SUser, SPass)) {
            Statement st = con.createStatement();
            int i;
            
            for (i = 1; i <=8; i++) {
                String query = "SELECT * FROM rooms WHERE id = " + i;
                ResultSet rs = st.executeQuery(query);
                rs.next();
                String roomtype, price;
                    roomtype = rs.getString("RoomType");
                    price = rs.getString("Price1");
                    
                Blob imageBlob = rs.getBlob("Img1");
                byte[] bytes = imageBlob.getBytes(1, (int) imageBlob.length());
                ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
                BufferedImage image = ImageIO.read(bis);
                    
                double dPrice;
                    dPrice = Double.parseDouble(price);
                switch (i) {
                    case 1:
                        room1.setText(roomtype);
                        roomPic1.setIcon(new ImageIcon(image));
                        roomPrice1.setText("P " + dPrice + " per night");
                        break;
                    case 2:
                        room2.setText(roomtype);
                        roomPic2.setIcon(new ImageIcon(image));
                        roomPrice2.setText("P " + dPrice + " per night");
                        break;
                    case 3:
                        room3.setText(roomtype);
                        roomPic3.setIcon(new ImageIcon(image));
                        roomPrice3.setText("P " + dPrice + " per night");
                        break;
                    case 4:
                        room4.setText(roomtype);
                        roomPic4.setIcon(new ImageIcon(image));
                        roomPrice4.setText("P " + dPrice + " per night");
                        break;
                    case 5:
                        room5.setText(roomtype);
                        roomPic5.setIcon(new ImageIcon(image));
                        roomPrice5.setText("P " + dPrice + " per night");
                        break;
                    case 6:
                        room6.setText(roomtype);
                        roomPic6.setIcon(new ImageIcon(image));
                        roomPrice6.setText("P " + dPrice + " per night");
                        break;
                    case 7:
                        room7.setText(roomtype);
                        roomPic7.setIcon(new ImageIcon(image));
                        roomPrice7.setText("P " + dPrice + " per night");
                        break;
                    case 8:
                        room8.setText(roomtype);
                        roomPic8.setIcon(new ImageIcon(image));
                        roomPrice8.setText("P " + dPrice + " per night");
                        break;
                    default:
                        break;
                }
            }
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    public void roomChoiceDetails() {
        String SUrl, SUser, SPass;
            SUrl = "jdbc:MySQL://localhost:3306/akatsukihotel_user_database";
            SUser = "root";
            SPass = "";
        
        try (Connection con = DriverManager.getConnection(SUrl, SUser, SPass)) {
            Statement st = con.createStatement();
            String query = "SELECT * FROM rooms WHERE id = " + roomChosen;
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
                
            } if ("1".equals(roomChosen)) {
                try (FileWriter fw = new FileWriter("room.txt")) {
                    fw.write(roomChosen);
                } catch (Exception e) {
                    System.err.println("Error: " + e.getMessage());
                }
                RoomDetailsOld rd = new RoomDetailsOld();
                rd.setVisible(true);
                rd.setLocationRelativeTo(null);
            } else if ("2".equals(roomChosen)) {
                try (FileWriter fw = new FileWriter("room.txt")) {
                    fw.write(roomChosen);
                } catch (Exception e) {
                    System.err.println("Error: " + e.getMessage());
                }
                RoomDetailsOld rd = new RoomDetailsOld();
                rd.setVisible(true);
                rd.setLocationRelativeTo(null);
            } else if ("3".equals(roomChosen)) {
                try (FileWriter fw = new FileWriter("room.txt")) {
                    fw.write(roomChosen);
                } catch (Exception e) {
                    System.err.println("Error: " + e.getMessage());
                }
                RoomDetailsOld rd = new RoomDetailsOld();
                rd.setVisible(true);
                rd.setLocationRelativeTo(null);
            } else if ("4".equals(roomChosen)) {
                try (FileWriter fw = new FileWriter("room.txt")) {
                    fw.write(roomChosen);
                } catch (Exception e) {
                    System.err.println("Error: " + e.getMessage());
                }
                RoomDetailsOld rd = new RoomDetailsOld();
                rd.setVisible(true);
                rd.setLocationRelativeTo(null);
            } else if ("5".equals(roomChosen)) {
                try (FileWriter fw = new FileWriter("room.txt")) {
                    fw.write(roomChosen);
                } catch (Exception e) {
                    System.err.println("Error: " + e.getMessage());
                }
                RoomDetailsOld rd = new RoomDetailsOld();
                rd.setVisible(true);
                rd.setLocationRelativeTo(null);
            } else if ("6".equals(roomChosen)) {
                try (FileWriter fw = new FileWriter("room.txt")) {
                    fw.write(roomChosen);
                } catch (Exception e) {
                    System.err.println("Error: " + e.getMessage());
                }
                RoomDetailsOld rd = new RoomDetailsOld();
                rd.setVisible(true);
                rd.setLocationRelativeTo(null);
            } else if ("7".equals(roomChosen)) {
                try (FileWriter fw = new FileWriter("room.txt")) {
                    fw.write(roomChosen);
                } catch (Exception e) {
                    System.err.println("Error: " + e.getMessage());
                }
                RoomDetailsOld rd = new RoomDetailsOld();
                rd.setVisible(true);
                rd.setLocationRelativeTo(null);
            } else if ("8".equals(roomChosen)) {
                try (FileWriter fw = new FileWriter("room.txt")) {
                    fw.write(roomChosen);
                } catch (Exception e) {
                    System.err.println("Error: " + e.getMessage());
                }
                RoomDetailsOld rd = new RoomDetailsOld();
                rd.setVisible(true);
                rd.setLocationRelativeTo(null);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    public void bookRoom() {
        String SUrl, SUser, SPass;
            SUrl = "jdbc:MySQL://localhost:3306/akatsukihotel_user_database";
            SUser = "root";
            SPass = "";
        
        try (Connection con = DriverManager.getConnection(SUrl, SUser, SPass)) {
            Statement st = con.createStatement();
            String query = "SELECT * FROM rooms WHERE id = " + roomChosen;
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
                
            } if ("1".equals(roomChosen)) {
                try (FileWriter fw = new FileWriter("room.txt")) {
                    fw.write(roomChosen);
                } catch (Exception e) {
                    System.err.println("Error: " + e.getMessage());
                }
                BookOld br = new BookOld();
                br.setVisible(true);
                br.setLocationRelativeTo(null);
            } else if ("2".equals(roomChosen)) {
                try (FileWriter fw = new FileWriter("room.txt")) {
                    fw.write(roomChosen);
                } catch (Exception e) {
                    System.err.println("Error: " + e.getMessage());
                }
                BookOld br = new BookOld();
                br.setVisible(true);
                br.setLocationRelativeTo(null);
            } else if ("3".equals(roomChosen)) {
                try (FileWriter fw = new FileWriter("room.txt")) {
                    fw.write(roomChosen);
                } catch (Exception e) {
                    System.err.println("Error: " + e.getMessage());
                }
                BookOld br = new BookOld();
                br.setVisible(true);
                br.setLocationRelativeTo(null);
            } else if ("4".equals(roomChosen)) {
                try (FileWriter fw = new FileWriter("room.txt")) {
                    fw.write(roomChosen);
                } catch (Exception e) {
                    System.err.println("Error: " + e.getMessage());
                }
                BookOld br = new BookOld();
                br.setVisible(true);
                br.setLocationRelativeTo(null);
            } else if ("5".equals(roomChosen)) {
                try (FileWriter fw = new FileWriter("room.txt")) {
                    fw.write(roomChosen);
                } catch (Exception e) {
                    System.err.println("Error: " + e.getMessage());
                }
                BookOld br = new BookOld();
                br.setVisible(true);
                br.setLocationRelativeTo(null);
            } else if ("6".equals(roomChosen)) {
                try (FileWriter fw = new FileWriter("room.txt")) {
                    fw.write(roomChosen);
                } catch (Exception e) {
                    System.err.println("Error: " + e.getMessage());
                }
                BookOld br = new BookOld();
                br.setVisible(true);
                br.setLocationRelativeTo(null);
            } else if ("7".equals(roomChosen)) {
                try (FileWriter fw = new FileWriter("room.txt")) {
                    fw.write(roomChosen);
                } catch (Exception e) {
                    System.err.println("Error: " + e.getMessage());
                }
                BookOld br = new BookOld();
                br.setVisible(true);
                br.setLocationRelativeTo(null);
            } else if ("8".equals(roomChosen)) {
                try (FileWriter fw = new FileWriter("room.txt")) {
                    fw.write(roomChosen);
                } catch (Exception e) {
                    System.err.println("Error: " + e.getMessage());
                }
                BookOld br = new BookOld();
                br.setVisible(true);
                br.setLocationRelativeTo(null);
            }
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
        sidepanel = new javax.swing.JPanel();
        home = new javax.swing.JButton();
        reserve = new javax.swing.JButton();
        gallery = new javax.swing.JButton();
        contact = new javax.swing.JButton();
        about = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        jLabel61 = new javax.swing.JLabel();
        insidepanel = new javax.swing.JPanel();
        panelReserve = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        textWelcom4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        room4 = new javax.swing.JLabel();
        roomPrice4 = new javax.swing.JLabel();
        details4 = new javax.swing.JButton();
        book4 = new javax.swing.JButton();
        roomPic4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        room1 = new javax.swing.JLabel();
        roomPrice1 = new javax.swing.JLabel();
        details1 = new javax.swing.JButton();
        book1 = new javax.swing.JButton();
        roomPic1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        room2 = new javax.swing.JLabel();
        roomPrice2 = new javax.swing.JLabel();
        details2 = new javax.swing.JButton();
        book2 = new javax.swing.JButton();
        roomPic2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        room3 = new javax.swing.JLabel();
        roomPrice3 = new javax.swing.JLabel();
        details3 = new javax.swing.JButton();
        book3 = new javax.swing.JButton();
        roomPic3 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        room6 = new javax.swing.JLabel();
        roomPrice6 = new javax.swing.JLabel();
        details6 = new javax.swing.JButton();
        book6 = new javax.swing.JButton();
        roomPic6 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        room7 = new javax.swing.JLabel();
        roomPrice7 = new javax.swing.JLabel();
        details7 = new javax.swing.JButton();
        book7 = new javax.swing.JButton();
        roomPic7 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        room8 = new javax.swing.JLabel();
        roomPrice8 = new javax.swing.JLabel();
        details8 = new javax.swing.JButton();
        book8 = new javax.swing.JButton();
        roomPic8 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        room5 = new javax.swing.JLabel();
        roomPrice5 = new javax.swing.JLabel();
        details5 = new javax.swing.JButton();
        book5 = new javax.swing.JButton();
        roomPic5 = new javax.swing.JLabel();

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
                .addGap(13, 13, 13)
                .addGroup(toppanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(toppanelLayout.createSequentialGroup()
                        .addComponent(gallery1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(toppanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(textWelcom)
                .addGap(4, 4, 4)
                .addComponent(textQuote))
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

        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sidepanel-bg-gold.png"))); // NOI18N
        sidepanel.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, 96, 260, 70));

        insidepanel.setBackground(new java.awt.Color(255, 255, 255));
        insidepanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelReserve.setBackground(new java.awt.Color(255, 255, 255));
        panelReserve.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMinimumSize(new java.awt.Dimension(1700, 1400));
        jPanel3.setPreferredSize(new java.awt.Dimension(1700, 1400));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textWelcom4.setFont(new java.awt.Font("Baskerville Old Face", 1, 100)); // NOI18N
        textWelcom4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textWelcom4.setText("Reserve a Hotel");
        jPanel3.add(textWelcom4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1700, -1));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        room4.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        room4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        room4.setText("null");
        jPanel4.add(room4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 400, -1));

        roomPrice4.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        roomPrice4.setText("null");
        jPanel4.add(roomPrice4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 180, 20));

        details4.setBackground(new java.awt.Color(255, 255, 255));
        details4.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        details4.setForeground(new java.awt.Color(230, 192, 104));
        details4.setText("Details");
        details4.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        details4.setFocusable(false);
        details4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                details4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                details4MouseExited(evt);
            }
        });
        details4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                details4ActionPerformed(evt);
            }
        });
        jPanel4.add(details4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 510, 100, 40));

        book4.setBackground(new java.awt.Color(255, 255, 255));
        book4.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        book4.setForeground(new java.awt.Color(230, 192, 104));
        book4.setText("Book");
        book4.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        book4.setFocusable(false);
        book4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                book4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                book4MouseExited(evt);
            }
        });
        book4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book4ActionPerformed(evt);
            }
        });
        jPanel4.add(book4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 510, 90, 40));

        roomPic4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        roomPic4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        roomPic4.setMaximumSize(new java.awt.Dimension(380, 380));
        roomPic4.setMinimumSize(new java.awt.Dimension(380, 380));
        roomPic4.setPreferredSize(new java.awt.Dimension(380, 380));
        jPanel4.add(roomPic4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 170, 400, 570));

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        room1.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        room1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        room1.setText("null");
        jPanel5.add(room1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 400, -1));

        roomPrice1.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        roomPrice1.setText("null");
        jPanel5.add(roomPrice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 180, 20));

        details1.setBackground(new java.awt.Color(255, 255, 255));
        details1.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        details1.setForeground(new java.awt.Color(230, 192, 104));
        details1.setText("Details");
        details1.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        details1.setFocusable(false);
        details1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                details1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                details1MouseExited(evt);
            }
        });
        details1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                details1ActionPerformed(evt);
            }
        });
        jPanel5.add(details1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 510, 100, 40));

        book1.setBackground(new java.awt.Color(255, 255, 255));
        book1.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        book1.setForeground(new java.awt.Color(230, 192, 104));
        book1.setText("Book");
        book1.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        book1.setFocusable(false);
        book1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                book1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                book1MouseExited(evt);
            }
        });
        book1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book1ActionPerformed(evt);
            }
        });
        jPanel5.add(book1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 510, 90, 40));

        roomPic1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        roomPic1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        roomPic1.setMaximumSize(new java.awt.Dimension(380, 380));
        roomPic1.setMinimumSize(new java.awt.Dimension(380, 380));
        roomPic1.setPreferredSize(new java.awt.Dimension(380, 380));
        jPanel5.add(roomPic1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 400, 570));

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        room2.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        room2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        room2.setText("null");
        jPanel6.add(room2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 400, -1));

        roomPrice2.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        roomPrice2.setText("null");
        jPanel6.add(roomPrice2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 180, 20));

        details2.setBackground(new java.awt.Color(255, 255, 255));
        details2.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        details2.setForeground(new java.awt.Color(230, 192, 104));
        details2.setText("Details");
        details2.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        details2.setFocusable(false);
        details2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                details2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                details2MouseExited(evt);
            }
        });
        details2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                details2ActionPerformed(evt);
            }
        });
        jPanel6.add(details2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 510, 100, 40));

        book2.setBackground(new java.awt.Color(255, 255, 255));
        book2.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        book2.setForeground(new java.awt.Color(230, 192, 104));
        book2.setText("Book");
        book2.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        book2.setFocusable(false);
        book2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                book2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                book2MouseExited(evt);
            }
        });
        book2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book2ActionPerformed(evt);
            }
        });
        jPanel6.add(book2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 510, 90, 40));

        roomPic2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        roomPic2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        roomPic2.setMaximumSize(new java.awt.Dimension(380, 380));
        roomPic2.setMinimumSize(new java.awt.Dimension(380, 380));
        roomPic2.setPreferredSize(new java.awt.Dimension(380, 380));
        jPanel6.add(roomPic2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, 400, 570));

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        room3.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        room3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        room3.setText("null");
        jPanel7.add(room3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 400, -1));

        roomPrice3.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        roomPrice3.setText("null");
        jPanel7.add(roomPrice3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 180, 20));

        details3.setBackground(new java.awt.Color(255, 255, 255));
        details3.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        details3.setForeground(new java.awt.Color(230, 192, 104));
        details3.setText("Details");
        details3.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        details3.setFocusable(false);
        details3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                details3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                details3MouseExited(evt);
            }
        });
        details3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                details3ActionPerformed(evt);
            }
        });
        jPanel7.add(details3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 510, 100, 40));

        book3.setBackground(new java.awt.Color(255, 255, 255));
        book3.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        book3.setForeground(new java.awt.Color(230, 192, 104));
        book3.setText("Book");
        book3.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        book3.setFocusable(false);
        book3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                book3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                book3MouseExited(evt);
            }
        });
        book3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book3ActionPerformed(evt);
            }
        });
        jPanel7.add(book3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 510, 90, 40));

        roomPic3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        roomPic3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        roomPic3.setMaximumSize(new java.awt.Dimension(380, 380));
        roomPic3.setMinimumSize(new java.awt.Dimension(380, 380));
        roomPic3.setPreferredSize(new java.awt.Dimension(380, 380));
        jPanel7.add(roomPic3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 170, 400, 570));

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        room6.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        room6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        room6.setText("null");
        jPanel9.add(room6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 400, -1));

        roomPrice6.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        roomPrice6.setText("null");
        jPanel9.add(roomPrice6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 180, 20));

        details6.setBackground(new java.awt.Color(255, 255, 255));
        details6.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        details6.setForeground(new java.awt.Color(230, 192, 104));
        details6.setText("Details");
        details6.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        details6.setFocusable(false);
        details6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                details6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                details6MouseExited(evt);
            }
        });
        details6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                details6ActionPerformed(evt);
            }
        });
        jPanel9.add(details6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 510, 100, 40));

        book6.setBackground(new java.awt.Color(255, 255, 255));
        book6.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        book6.setForeground(new java.awt.Color(230, 192, 104));
        book6.setText("Book");
        book6.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        book6.setFocusable(false);
        book6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                book6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                book6MouseExited(evt);
            }
        });
        book6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book6ActionPerformed(evt);
            }
        });
        jPanel9.add(book6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 510, 90, 40));

        roomPic6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        roomPic6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        roomPic6.setMaximumSize(new java.awt.Dimension(380, 380));
        roomPic6.setMinimumSize(new java.awt.Dimension(380, 380));
        roomPic6.setPreferredSize(new java.awt.Dimension(380, 380));
        jPanel9.add(roomPic6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 770, -1, 570));

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        room7.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        room7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        room7.setText("null");
        jPanel10.add(room7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 400, -1));

        roomPrice7.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        roomPrice7.setText("null");
        jPanel10.add(roomPrice7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 180, 20));

        details7.setBackground(new java.awt.Color(255, 255, 255));
        details7.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        details7.setForeground(new java.awt.Color(230, 192, 104));
        details7.setText("Details");
        details7.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        details7.setFocusable(false);
        details7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                details7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                details7MouseExited(evt);
            }
        });
        details7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                details7ActionPerformed(evt);
            }
        });
        jPanel10.add(details7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 510, 100, 40));

        book7.setBackground(new java.awt.Color(255, 255, 255));
        book7.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        book7.setForeground(new java.awt.Color(230, 192, 104));
        book7.setText("Book");
        book7.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        book7.setFocusable(false);
        book7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                book7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                book7MouseExited(evt);
            }
        });
        book7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book7ActionPerformed(evt);
            }
        });
        jPanel10.add(book7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 510, 90, 40));

        roomPic7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        roomPic7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        roomPic7.setMaximumSize(new java.awt.Dimension(380, 380));
        roomPic7.setMinimumSize(new java.awt.Dimension(380, 380));
        roomPic7.setPreferredSize(new java.awt.Dimension(380, 380));
        jPanel10.add(roomPic7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jPanel3.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 770, -1, 570));

        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        room8.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        room8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        room8.setText("null");
        jPanel11.add(room8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 400, -1));

        roomPrice8.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        roomPrice8.setText("null");
        jPanel11.add(roomPrice8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 180, 20));

        details8.setBackground(new java.awt.Color(255, 255, 255));
        details8.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        details8.setForeground(new java.awt.Color(230, 192, 104));
        details8.setText("Details");
        details8.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        details8.setFocusable(false);
        details8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                details8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                details8MouseExited(evt);
            }
        });
        details8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                details8ActionPerformed(evt);
            }
        });
        jPanel11.add(details8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 510, 100, 40));

        book8.setBackground(new java.awt.Color(255, 255, 255));
        book8.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        book8.setForeground(new java.awt.Color(230, 192, 104));
        book8.setText("Book");
        book8.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        book8.setFocusable(false);
        book8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                book8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                book8MouseExited(evt);
            }
        });
        book8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book8ActionPerformed(evt);
            }
        });
        jPanel11.add(book8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 510, 90, 40));

        roomPic8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        roomPic8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        roomPic8.setMaximumSize(new java.awt.Dimension(380, 380));
        roomPic8.setMinimumSize(new java.awt.Dimension(380, 380));
        roomPic8.setPreferredSize(new java.awt.Dimension(380, 380));
        jPanel11.add(roomPic8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jPanel3.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 770, -1, 570));

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        room5.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        room5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        room5.setText("null");
        jPanel8.add(room5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 400, -1));

        roomPrice5.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        roomPrice5.setText("null");
        jPanel8.add(roomPrice5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 180, 20));

        details5.setBackground(new java.awt.Color(255, 255, 255));
        details5.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        details5.setForeground(new java.awt.Color(230, 192, 104));
        details5.setText("Details");
        details5.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        details5.setFocusable(false);
        details5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                details5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                details5MouseExited(evt);
            }
        });
        details5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                details5ActionPerformed(evt);
            }
        });
        jPanel8.add(details5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 510, 100, 40));

        book5.setBackground(new java.awt.Color(255, 255, 255));
        book5.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        book5.setForeground(new java.awt.Color(230, 192, 104));
        book5.setText("Book");
        book5.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        book5.setFocusable(false);
        book5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                book5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                book5MouseExited(evt);
            }
        });
        book5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book5ActionPerformed(evt);
            }
        });
        jPanel8.add(book5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 510, 90, 40));

        roomPic5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        roomPic5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        roomPic5.setMaximumSize(new java.awt.Dimension(380, 380));
        roomPic5.setMinimumSize(new java.awt.Dimension(380, 380));
        roomPic5.setPreferredSize(new java.awt.Dimension(380, 380));
        jPanel8.add(roomPic5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 770, 400, 570));

        jScrollPane1.setViewportView(jPanel3);

        panelReserve.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1700, 880));

        insidepanel.add(panelReserve, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1700, 880));

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
       
    }//GEN-LAST:event_reserveActionPerformed

    private void reserveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reserveMouseExited
        
    }//GEN-LAST:event_reserveMouseExited

    private void reserveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reserveMouseEntered

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

    private void details4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_details4MouseEntered
        
    }//GEN-LAST:event_details4MouseEntered

    private void details4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_details4MouseExited
        
    }//GEN-LAST:event_details4MouseExited

    private void details4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_details4ActionPerformed
        roomChosen = "4";
        roomChoiceDetails();
    }//GEN-LAST:event_details4ActionPerformed

    private void book4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_book4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_book4MouseEntered

    private void book4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_book4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_book4MouseExited

    private void book4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book4ActionPerformed
        roomChosen = "4";
        bookRoom();
    }//GEN-LAST:event_book4ActionPerformed

    private void details1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_details1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_details1MouseEntered

    private void details1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_details1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_details1MouseExited

    private void details1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_details1ActionPerformed
        roomChosen = "1";
        roomChoiceDetails();
    }//GEN-LAST:event_details1ActionPerformed

    private void book1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_book1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_book1MouseEntered

    private void book1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_book1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_book1MouseExited

    private void book1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book1ActionPerformed
        roomChosen = "1";
        bookRoom();
    }//GEN-LAST:event_book1ActionPerformed

    private void details2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_details2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_details2MouseEntered

    private void details2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_details2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_details2MouseExited

    private void details2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_details2ActionPerformed
        roomChosen = "2";
        roomChoiceDetails();
    }//GEN-LAST:event_details2ActionPerformed

    private void book2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_book2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_book2MouseEntered

    private void book2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_book2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_book2MouseExited

    private void book2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book2ActionPerformed
        roomChosen = "2";
        bookRoom();
    }//GEN-LAST:event_book2ActionPerformed

    private void details3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_details3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_details3MouseEntered

    private void details3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_details3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_details3MouseExited

    private void details3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_details3ActionPerformed
        roomChosen = "3";
        roomChoiceDetails();
    }//GEN-LAST:event_details3ActionPerformed

    private void book3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_book3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_book3MouseEntered

    private void book3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_book3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_book3MouseExited

    private void book3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book3ActionPerformed
        roomChosen = "3";
        bookRoom();
    }//GEN-LAST:event_book3ActionPerformed

    private void details5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_details5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_details5MouseEntered

    private void details5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_details5MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_details5MouseExited

    private void details5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_details5ActionPerformed
        roomChosen = "5";
        roomChoiceDetails();
    }//GEN-LAST:event_details5ActionPerformed

    private void book5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_book5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_book5MouseEntered

    private void book5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_book5MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_book5MouseExited

    private void book5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book5ActionPerformed
        roomChosen = "5";
        bookRoom();
    }//GEN-LAST:event_book5ActionPerformed

    private void details6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_details6MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_details6MouseEntered

    private void details6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_details6MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_details6MouseExited

    private void details6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_details6ActionPerformed
        roomChosen = "6";
        roomChoiceDetails();
    }//GEN-LAST:event_details6ActionPerformed

    private void book6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_book6MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_book6MouseEntered

    private void book6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_book6MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_book6MouseExited

    private void book6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book6ActionPerformed
        roomChosen = "6";
        bookRoom();
    }//GEN-LAST:event_book6ActionPerformed

    private void details7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_details7MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_details7MouseEntered

    private void details7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_details7MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_details7MouseExited

    private void details7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_details7ActionPerformed
        roomChosen = "7";
        roomChoiceDetails();
    }//GEN-LAST:event_details7ActionPerformed

    private void book7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_book7MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_book7MouseEntered

    private void book7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_book7MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_book7MouseExited

    private void book7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book7ActionPerformed
        roomChosen = "7";
        bookRoom();
    }//GEN-LAST:event_book7ActionPerformed

    private void details8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_details8MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_details8MouseEntered

    private void details8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_details8MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_details8MouseExited

    private void details8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_details8ActionPerformed
        roomChosen = "8";
        roomChoiceDetails();
    }//GEN-LAST:event_details8ActionPerformed

    private void book8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_book8MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_book8MouseEntered

    private void book8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_book8MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_book8MouseExited

    private void book8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book8ActionPerformed
        roomChosen = "8";
        bookRoom();
    }//GEN-LAST:event_book8ActionPerformed

    /**
     * @param args the command line arguments
     */

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton about;
    public javax.swing.JButton book1;
    public javax.swing.JButton book2;
    public javax.swing.JButton book3;
    public javax.swing.JButton book4;
    public javax.swing.JButton book5;
    public javax.swing.JButton book6;
    public javax.swing.JButton book7;
    public javax.swing.JButton book8;
    public javax.swing.JButton contact;
    public javax.swing.JButton details1;
    public javax.swing.JButton details2;
    public javax.swing.JButton details3;
    public javax.swing.JButton details4;
    public javax.swing.JButton details5;
    public javax.swing.JButton details6;
    public javax.swing.JButton details7;
    public javax.swing.JButton details8;
    public javax.swing.JButton gallery;
    public javax.swing.JButton gallery1;
    public javax.swing.JButton home;
    private javax.swing.JPanel insidepanel;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logo;
    public javax.swing.JButton logout;
    private javax.swing.JPanel panelReserve;
    private javax.swing.JPanel panelWrapper;
    public javax.swing.JButton reserve;
    private javax.swing.JLabel room1;
    private javax.swing.JLabel room2;
    private javax.swing.JLabel room3;
    private javax.swing.JLabel room4;
    private javax.swing.JLabel room5;
    private javax.swing.JLabel room6;
    private javax.swing.JLabel room7;
    private javax.swing.JLabel room8;
    private javax.swing.JLabel roomPic1;
    private javax.swing.JLabel roomPic2;
    private javax.swing.JLabel roomPic3;
    private javax.swing.JLabel roomPic4;
    private javax.swing.JLabel roomPic5;
    private javax.swing.JLabel roomPic6;
    private javax.swing.JLabel roomPic7;
    private javax.swing.JLabel roomPic8;
    private javax.swing.JLabel roomPrice1;
    private javax.swing.JLabel roomPrice2;
    private javax.swing.JLabel roomPrice3;
    private javax.swing.JLabel roomPrice4;
    private javax.swing.JLabel roomPrice5;
    private javax.swing.JLabel roomPrice6;
    private javax.swing.JLabel roomPrice7;
    private javax.swing.JLabel roomPrice8;
    private javax.swing.JPanel sidepanel;
    private javax.swing.JLabel textQuote;
    private javax.swing.JLabel textWelcom;
    private javax.swing.JLabel textWelcom4;
    private javax.swing.JPanel toppanel;
    // End of variables declaration//GEN-END:variables
}
