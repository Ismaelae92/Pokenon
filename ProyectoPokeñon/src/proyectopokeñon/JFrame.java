/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyectopokeñon;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Ismael
 */
public class JFrame extends javax.swing.JFrame {
    
    private Clip clip;
    private AudioInputStream audioInputStream;
    JComponent listas;
    
    public JFrame(){
        initComponents();
        contenedor.setEnabledAt(1, false);
        contenedor.setEnabledAt(2, false);
        contenedor.setEnabledAt(3, false);
        contenedor.setEnabledAt(4, false);
        ultimasPartidas.setVisible(false);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null); 
        
        File soundFile = new File("src\\intro.wav");
        try {
            audioInputStream = AudioSystem.getAudioInputStream(soundFile);
        } catch (UnsupportedAudioFileException ue) {
            System.out.println("Archivo incorrecto");
        } catch (IOException e) {
            System.out.println("Error inesperado");
        }
        try {
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            float dB = (float) (Math.log10(0.5) * 35.0);
            gainControl.setValue(dB);
        } catch (LineUnavailableException l) {
            System.out.println("Error en el audio");
        } catch (IOException e) {
            System.out.println("err");
        }
        
        
   }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedor = new javax.swing.JTabbedPane();
        pMenu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ultimasPartidas = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        nuevaPartida = new javax.swing.JButton();
        cargarPartida = new javax.swing.JButton();
        guardarPartida = new javax.swing.JButton();
        jSlider1 = new javax.swing.JSlider();
        jButton9 = new javax.swing.JButton();
        pSeleccionPersonaje = new javax.swing.JPanel();
        Brook = new javax.swing.JButton();
        volverAlMenu2 = new javax.swing.JButton();
        Misty = new javax.swing.JButton();
        Ash = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pSeleccionarPokeñon = new javax.swing.JPanel();
        pikachu = new javax.swing.JButton();
        volverAlMenu3 = new javax.swing.JButton();
        vulvasur = new javax.swing.JButton();
        charmander = new javax.swing.JButton();
        Squirtle = new javax.swing.JButton();
        atras = new javax.swing.JButton();
        eleccion = new javax.swing.JLabel();
        pJuego = new javax.swing.JPanel();
        volverAlMenu4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        pInventario = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pokeñon");

        contenedor.setBackground(new java.awt.Color(255, 255, 255));
        contenedor.setAlignmentX(1.0F);
        contenedor.setAlignmentY(1.0F);
        contenedor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        contenedor.setFocusable(false);

        pMenu.setBackground(new java.awt.Color(255, 153, 153));
        pMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pMenu.setFocusCycleRoot(true);
        pMenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pMenuMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setToolTipText("");

        ultimasPartidas.setBackground(new java.awt.Color(255, 255, 255));
        ultimasPartidas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jCheckBox1.setText("      Partida 1");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel2.setText("Ultimas partidas:");

        javax.swing.GroupLayout ultimasPartidasLayout = new javax.swing.GroupLayout(ultimasPartidas);
        ultimasPartidas.setLayout(ultimasPartidasLayout);
        ultimasPartidasLayout.setHorizontalGroup(
            ultimasPartidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ultimasPartidasLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(ultimasPartidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(280, Short.MAX_VALUE))
        );
        ultimasPartidasLayout.setVerticalGroup(
            ultimasPartidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ultimasPartidasLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox1)
                .addContainerGap(398, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 153, 153));

        nuevaPartida.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        nuevaPartida.setText("Nueva partida");
        nuevaPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevaPartidaActionPerformed(evt);
            }
        });

        cargarPartida.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        cargarPartida.setText("Cargar partida");
        cargarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarPartidaActionPerformed(evt);
            }
        });

        guardarPartida.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        guardarPartida.setText("Guardar partida");
        guardarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarPartidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(guardarPartida)
                    .addComponent(cargarPartida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nuevaPartida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(214, Short.MAX_VALUE))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cargarPartida, guardarPartida, nuevaPartida});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(nuevaPartida)
                .addGap(60, 60, 60)
                .addComponent(cargarPartida)
                .addGap(55, 55, 55)
                .addComponent(guardarPartida)
                .addContainerGap(142, Short.MAX_VALUE))
        );

        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });
        jSlider1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jSlider1PropertyChange(evt);
            }
        });

        jButton9.setText("Detener");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pMenuLayout = new javax.swing.GroupLayout(pMenu);
        pMenu.setLayout(pMenuLayout);
        pMenuLayout.setHorizontalGroup(
            pMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMenuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(703, 703, 703))
            .addGroup(pMenuLayout.createSequentialGroup()
                .addGroup(pMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pMenuLayout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94)
                        .addComponent(ultimasPartidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pMenuLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jButton9)
                        .addGap(18, 18, 18)
                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        pMenuLayout.setVerticalGroup(
            pMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pMenuLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(pMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ultimasPartidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addGroup(pMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9)
                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        contenedor.addTab("Menú", pMenu);

        pSeleccionPersonaje.setBackground(new java.awt.Color(255, 153, 153));
        pSeleccionPersonaje.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N

        Brook.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Brook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pj2.png"))); // NOI18N
        Brook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrookActionPerformed(evt);
            }
        });

        volverAlMenu2.setText("Volver al menú");
        volverAlMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverAlMenu2ActionPerformed(evt);
            }
        });

        Misty.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Misty.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pj3.png"))); // NOI18N
        Misty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MistyActionPerformed(evt);
            }
        });

        Ash.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Ash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pj1.png"))); // NOI18N
        Ash.setBorderPainted(false);
        Ash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AshActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Selecciona tu entrador Pokeñon");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("ASH");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("BROCK");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("MISTY");

        javax.swing.GroupLayout pSeleccionPersonajeLayout = new javax.swing.GroupLayout(pSeleccionPersonaje);
        pSeleccionPersonaje.setLayout(pSeleccionPersonajeLayout);
        pSeleccionPersonajeLayout.setHorizontalGroup(
            pSeleccionPersonajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSeleccionPersonajeLayout.createSequentialGroup()
                .addGroup(pSeleccionPersonajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pSeleccionPersonajeLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(volverAlMenu2)
                        .addGap(333, 333, 333)
                        .addComponent(jLabel6)
                        .addGap(232, 232, 232)
                        .addComponent(jLabel7)
                        .addGap(200, 200, 200)
                        .addComponent(jLabel8))
                    .addGroup(pSeleccionPersonajeLayout.createSequentialGroup()
                        .addGap(691, 691, 691)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pSeleccionPersonajeLayout.createSequentialGroup()
                        .addGap(388, 388, 388)
                        .addGroup(pSeleccionPersonajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pSeleccionPersonajeLayout.createSequentialGroup()
                                .addComponent(Ash, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(Brook, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(Misty, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pSeleccionPersonajeLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Ash, Brook, Misty});

        pSeleccionPersonajeLayout.setVerticalGroup(
            pSeleccionPersonajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pSeleccionPersonajeLayout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pSeleccionPersonajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pSeleccionPersonajeLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 635, Short.MAX_VALUE)
                        .addComponent(volverAlMenu2))
                    .addGroup(pSeleccionPersonajeLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                        .addGroup(pSeleccionPersonajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Brook, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Misty, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Ash, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pSeleccionPersonajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6))))
                .addGap(26, 26, 26))
        );

        pSeleccionPersonajeLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Ash, Brook, Misty});

        contenedor.addTab("Seleccionar Personaje", pSeleccionPersonaje);

        pSeleccionarPokeñon.setBackground(new java.awt.Color(255, 255, 255));

        pikachu.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        pikachu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pikachu.png"))); // NOI18N
        pikachu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pikachuActionPerformed(evt);
            }
        });

        volverAlMenu3.setText("Volver al menú");
        volverAlMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverAlMenu3ActionPerformed(evt);
            }
        });

        vulvasur.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bulbasur.png"))); // NOI18N
        vulvasur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vulvasurActionPerformed(evt);
            }
        });

        charmander.setIcon(new javax.swing.ImageIcon(getClass().getResource("/charmander.png"))); // NOI18N
        charmander.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                charmanderActionPerformed(evt);
            }
        });

        Squirtle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/squirtle.png"))); // NOI18N
        Squirtle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SquirtleActionPerformed(evt);
            }
        });

        atras.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        atras.setText("Atrás");
        atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasActionPerformed(evt);
            }
        });

        eleccion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        eleccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pSeleccionarPokeñonLayout = new javax.swing.GroupLayout(pSeleccionarPokeñon);
        pSeleccionarPokeñon.setLayout(pSeleccionarPokeñonLayout);
        pSeleccionarPokeñonLayout.setHorizontalGroup(
            pSeleccionarPokeñonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSeleccionarPokeñonLayout.createSequentialGroup()
                .addGroup(pSeleccionarPokeñonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pSeleccionarPokeñonLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(volverAlMenu3))
                    .addGroup(pSeleccionarPokeñonLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(pSeleccionarPokeñonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(atras, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pSeleccionarPokeñonLayout.createSequentialGroup()
                                .addComponent(pikachu)
                                .addGap(73, 73, 73)
                                .addGroup(pSeleccionarPokeñonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pSeleccionarPokeñonLayout.createSequentialGroup()
                                        .addComponent(vulvasur)
                                        .addGap(71, 71, 71)
                                        .addComponent(charmander))
                                    .addComponent(eleccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(81, 81, 81)
                                .addComponent(Squirtle)))))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        pSeleccionarPokeñonLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Squirtle, charmander, pikachu, vulvasur});

        pSeleccionarPokeñonLayout.setVerticalGroup(
            pSeleccionarPokeñonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pSeleccionarPokeñonLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(atras)
                .addGap(56, 56, 56)
                .addGroup(pSeleccionarPokeñonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vulvasur, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pikachu, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(charmander, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Squirtle, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78)
                .addComponent(eleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addComponent(volverAlMenu3)
                .addGap(24, 24, 24))
        );

        contenedor.addTab("Seleccionar Pokeñon", pSeleccionarPokeñon);

        volverAlMenu4.setText("Volver al menú");
        volverAlMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverAlMenu4ActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mapa.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jLabel3.setMaximumSize(new java.awt.Dimension(1000, 600));

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pJuegoLayout = new javax.swing.GroupLayout(pJuego);
        pJuego.setLayout(pJuegoLayout);
        pJuegoLayout.setHorizontalGroup(
            pJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pJuegoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(volverAlMenu4)
                .addGap(72, 72, 72))
        );
        pJuegoLayout.setVerticalGroup(
            pJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pJuegoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addGroup(pJuegoLayout.createSequentialGroup()
                .addGroup(pJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pJuegoLayout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(volverAlMenu4))
                    .addGroup(pJuegoLayout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 560, Short.MAX_VALUE))
        );

        contenedor.addTab("Juego", pJuego);

        pInventario.setOpaque(false);

        jButton2.setText("Volver al menú");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pInventarioLayout = new javax.swing.GroupLayout(pInventario);
        pInventario.setLayout(pInventarioLayout);
        pInventarioLayout.setHorizontalGroup(
            pInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pInventarioLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jButton2)
                .addContainerGap(1325, Short.MAX_VALUE))
        );
        pInventarioLayout.setVerticalGroup(
            pInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pInventarioLayout.createSequentialGroup()
                .addContainerGap(712, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(20, 20, 20))
        );

        contenedor.addTab("Inventario", pInventario);

        getContentPane().add(contenedor, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        contenedor.setSelectedIndex(0);
        contenedor.setEnabledAt(0, true);
        contenedor.setEnabledAt(1, false);
        contenedor.setEnabledAt(2, false);
        contenedor.setEnabledAt(3, false);
        contenedor.setEnabledAt(4, false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void volverAlMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverAlMenu4ActionPerformed
        contenedor.setSelectedIndex(0);
        contenedor.setEnabledAt(0, true);
        contenedor.setEnabledAt(1, false);
        contenedor.setEnabledAt(2, false);
        contenedor.setEnabledAt(3, false);
        contenedor.setEnabledAt(4, false);
    }//GEN-LAST:event_volverAlMenu4ActionPerformed

    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasActionPerformed
        contenedor.setSelectedIndex(1);
        contenedor.setEnabledAt(0, false);
        contenedor.setEnabledAt(1, true);
        contenedor.setEnabledAt(2, false);
        contenedor.setEnabledAt(3, false);
        contenedor.setEnabledAt(4, false);
    }//GEN-LAST:event_atrasActionPerformed

    private void SquirtleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SquirtleActionPerformed
        contenedor.setSelectedIndex(3);
        contenedor.setEnabledAt(0, false);
        contenedor.setEnabledAt(1, false);
        contenedor.setEnabledAt(2, false);
        contenedor.setEnabledAt(3, true);
        contenedor.setEnabledAt(4, false);
    }//GEN-LAST:event_SquirtleActionPerformed

    private void charmanderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_charmanderActionPerformed
        contenedor.setSelectedIndex(3);
        contenedor.setEnabledAt(0, false);
        contenedor.setEnabledAt(1, false);
        contenedor.setEnabledAt(2, false);
        contenedor.setEnabledAt(3, true);
        contenedor.setEnabledAt(4, false);
    }//GEN-LAST:event_charmanderActionPerformed

    private void vulvasurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vulvasurActionPerformed
        contenedor.setSelectedIndex(3);
        contenedor.setEnabledAt(0, false);
        contenedor.setEnabledAt(1, false);
        contenedor.setEnabledAt(2, false);
        contenedor.setEnabledAt(3, true);
        contenedor.setEnabledAt(4, false);
    }//GEN-LAST:event_vulvasurActionPerformed

    private void volverAlMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverAlMenu3ActionPerformed
        contenedor.setSelectedIndex(0);
        contenedor.setEnabledAt(0, true);
        contenedor.setEnabledAt(1, false);
        contenedor.setEnabledAt(2, false);
        contenedor.setEnabledAt(3, false);
        contenedor.setEnabledAt(4, false);
    }//GEN-LAST:event_volverAlMenu3ActionPerformed

    private void pikachuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pikachuActionPerformed
        contenedor.setSelectedIndex(3);
        contenedor.setEnabledAt(0, false);
        contenedor.setEnabledAt(1, false);
        contenedor.setEnabledAt(2, false);
        contenedor.setEnabledAt(3, true);
        contenedor.setEnabledAt(4, false);

    }//GEN-LAST:event_pikachuActionPerformed

    private void AshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AshActionPerformed
        contenedor.setSelectedIndex(2);
        contenedor.setEnabledAt(0, false);
        contenedor.setEnabledAt(1, false);
        contenedor.setEnabledAt(2, true);
        contenedor.setEnabledAt(3, false);
        contenedor.setEnabledAt(4, false);
        pikachu.setVisible(true);
    }//GEN-LAST:event_AshActionPerformed

    private void MistyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MistyActionPerformed
        contenedor.setSelectedIndex(2);
        contenedor.setEnabledAt(0, false);
        contenedor.setEnabledAt(1, false);
        contenedor.setEnabledAt(2, true);
        contenedor.setEnabledAt(3, false);
        contenedor.setEnabledAt(4, false);
        pikachu.setVisible(false);
    }//GEN-LAST:event_MistyActionPerformed

    private void volverAlMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverAlMenu2ActionPerformed
        contenedor.setSelectedIndex(0);
        contenedor.setEnabledAt(0, true);
        contenedor.setEnabledAt(1, false);
        contenedor.setEnabledAt(2, false);
        contenedor.setEnabledAt(3, false);
        contenedor.setEnabledAt(4, false);
    }//GEN-LAST:event_volverAlMenu2ActionPerformed

    private void BrookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BrookActionPerformed
        contenedor.setSelectedIndex(2);
        contenedor.setEnabledAt(0, false);
        contenedor.setEnabledAt(1, false);
        contenedor.setEnabledAt(2, true);
        contenedor.setEnabledAt(3, false);
        contenedor.setEnabledAt(4, false);
        pikachu.setVisible(false);
    }//GEN-LAST:event_BrookActionPerformed

    private void pMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pMenuMouseClicked

    }//GEN-LAST:event_pMenuMouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if (clip.isRunning()) {
            clip.stop();
            jSlider1.setVisible(false);
            jButton9.setText("Reproducir");
        }else if(!clip.isRunning()){
            clip.start();
            jSlider1.setVisible(true);
            jButton9.setText("Detener");
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jSlider1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jSlider1PropertyChange

    }//GEN-LAST:event_jSlider1PropertyChange

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        float volume = (float) jSlider1.getValue() / 100.0f;
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        float dB = (float) (Math.log10(volume) * 35.0);
        gainControl.setValue(dB);
    }//GEN-LAST:event_jSlider1StateChanged

    private void guardarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarPartidaActionPerformed
        jLabel1.setText("Tu partida ha sido guardada");
        ultimasPartidas.setVisible(false);
        Timer timer = new Timer(4000, (e) -> {
            jLabel1.setText("");
        });
        timer.setRepeats(false);
        timer.start();
    }//GEN-LAST:event_guardarPartidaActionPerformed

    private void cargarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarPartidaActionPerformed
        ultimasPartidas.setVisible(true);
    }//GEN-LAST:event_cargarPartidaActionPerformed

    private void nuevaPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevaPartidaActionPerformed
        contenedor.setSelectedIndex(1);
        contenedor.setEnabledAt(0, false);
        contenedor.setEnabledAt(1, true);
        ultimasPartidas.setVisible(false);
    }//GEN-LAST:event_nuevaPartidaActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        //Metodo cargar partida
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Ash;
    private javax.swing.JButton Brook;
    private javax.swing.JButton Misty;
    private javax.swing.JButton Squirtle;
    private javax.swing.JButton atras;
    private javax.swing.JButton cargarPartida;
    private javax.swing.JButton charmander;
    private javax.swing.JTabbedPane contenedor;
    private javax.swing.JLabel eleccion;
    private javax.swing.JButton guardarPartida;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JButton nuevaPartida;
    private javax.swing.JPanel pInventario;
    private javax.swing.JPanel pJuego;
    private javax.swing.JPanel pMenu;
    private javax.swing.JPanel pSeleccionPersonaje;
    private javax.swing.JPanel pSeleccionarPokeñon;
    private javax.swing.JButton pikachu;
    private javax.swing.JPanel ultimasPartidas;
    private javax.swing.JButton volverAlMenu2;
    private javax.swing.JButton volverAlMenu3;
    private javax.swing.JButton volverAlMenu4;
    private javax.swing.JButton vulvasur;
    // End of variables declaration//GEN-END:variables
}
