/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyectopokeñon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.stream.IntStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Timer;

/**
 *
 * @author Ismael
 */
public class JFrame extends javax.swing.JFrame {
    
    private Clip clip;
    private AudioInputStream audioInputStream;
    private Timer temporizador;
    private Timer timer;
    private int moveAmount = 5;
    private Action accion;
    int limiteX, limiteY;
    private int x, y;
    
    public JFrame(){
        initComponents();
        
        // Bloquear todas las pestañas
        IntStream.range(0, contenedor.getTabCount()).forEach(i -> contenedor.setEnabledAt(i, false));
        
        // Ocultar el panel de últimas partidas inicialmente
        ultimasPartidas.setVisible(false);
        
        // Configurar tamaño y posición de la ventana
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null); 
        
        // Introducir audio
        try {
            File soundFile = new File("src\\audio\\intro.wav");
            audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            float dB = (float) (Math.log10(0.5) * 35.0);
            gainControl.setValue(dB);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException("Error al cargar el audio");
        }
    
        // Iniciar acción de temporizador para cambiar de pantalla cuando termine el progreso
        if (inicio.isEnabled()){
            accion = new Action();
            temporizador = new Timer(30, accion);
            temporizador.start();
        }
    }
    
    // Inicializar límites del movimiento del botón cuando el JFrame es visible
    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        if (b) {
            limiteX = jLabel9.getWidth() - IconoEntrenador.getWidth();
            limiteY = jLabel9.getHeight() - IconoEntrenador.getHeight();
        }
    }
    
    private void startMoving(int dx, int dy) {
        stopMoving(); // Detener el movimiento actual si hay alguno en curso
        timer = new Timer(10, e -> moveButton(dx * moveAmount, dy * moveAmount));
        timer.start();
    }

    private void stopMoving() {
        if (timer != null) {
            timer.stop();
            timer = null;
        }
    }

    private void moveButton(int dx, int dy) {
        x = IconoEntrenador.getX() + dx;
        y = IconoEntrenador.getY() + dy;
        if (x < 0) {
            x = 0;
        } else if (x > limiteX) {
            x = limiteX;
        }
        if (y < 0) {
            y = 0;
        } else if (y > limiteY) {
            y = limiteY;
        }
        // Detecta si el boton esta cerca de una coordenada
        double distancia = Math.sqrt(Math.pow(x - 420, 2) + Math.pow(y - 672, 2));

        // Si la distancia es menor que 50, mostrar el JTabbedPane
        if (distancia < 100) {
        contenedor.setSelectedIndex(6);
    }
        IconoEntrenador.setLocation(x, y);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedor = new javax.swing.JTabbedPane();
        inicio = new javax.swing.JPanel();
        barra = new javax.swing.JProgressBar();
        porcentajeBarra = new javax.swing.JLabel();
        pMenu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        nuevaPartida = new javax.swing.JButton();
        cargarPartida = new javax.swing.JButton();
        guardarPartida = new javax.swing.JButton();
        jSlider1 = new javax.swing.JSlider();
        jButton9 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ultimasPartidas = new javax.swing.JList<>();
        pSeleccionPersonaje = new javax.swing.JPanel();
        Brook = new javax.swing.JButton();
        volverAlMenu2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Misty = new javax.swing.JButton();
        Ash = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pSeleccionarPokeñon = new javax.swing.JPanel();
        pikachu = new javax.swing.JButton();
        volverAlMenu3 = new javax.swing.JButton();
        bulvasur = new javax.swing.JButton();
        charmander = new javax.swing.JButton();
        squirtle = new javax.swing.JButton();
        atras = new javax.swing.JButton();
        eleccion = new javax.swing.JLabel();
        nPikachu = new javax.swing.JLabel();
        nBulbasur = new javax.swing.JLabel();
        nSquirtle = new javax.swing.JLabel();
        nCharmander = new javax.swing.JLabel();
        pJuego = new javax.swing.JPanel();
        IconoEntrenador = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        pInventario = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        Enfermeria = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pokeñon");

        contenedor.setBackground(new java.awt.Color(255, 255, 255));
        contenedor.setAlignmentX(1.0F);
        contenedor.setAlignmentY(1.0F);
        contenedor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        contenedor.setFocusable(false);

        inicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barra.setBackground(new java.awt.Color(255, 255, 255));
        barra.setToolTipText("");
        barra.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                barraComponentShown(evt);
            }
        });
        inicio.add(barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 230, 554, 49));

        porcentajeBarra.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        inicio.add(porcentajeBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 320, 89, 53));

        contenedor.addTab("Inicio", inicio);

        pMenu.setBackground(new java.awt.Color(255, 255, 255));
        pMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pMenu.setFocusCycleRoot(true);
        pMenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pMenuMouseClicked(evt);
            }
        });
        pMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setToolTipText("");
        pMenu.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(606, 608, 420, 57));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

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

        pMenu.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 83, -1, -1));

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
        pMenu.add(jSlider1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 610, -1, -1));

        jButton9.setText("Detener");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        pMenu.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 610, -1, -1));

        ultimasPartidas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        ultimasPartidas.setOpaque(false);
        ultimasPartidas.setSelectionBackground(new java.awt.Color(255, 153, 153));
        jScrollPane1.setViewportView(ultimasPartidas);

        pMenu.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 120, 280, 400));

        contenedor.addTab("Menú", pMenu);

        pSeleccionPersonaje.setBackground(new java.awt.Color(255, 255, 255));
        pSeleccionPersonaje.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        pSeleccionPersonaje.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Brook.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Brook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pj2.png"))); // NOI18N
        Brook.setContentAreaFilled(false);
        Brook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrookActionPerformed(evt);
            }
        });
        pSeleccionPersonaje.add(Brook, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 250, 260, 440));

        volverAlMenu2.setText("Volver al menú");
        volverAlMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverAlMenu2ActionPerformed(evt);
            }
        });
        pSeleccionPersonaje.add(volverAlMenu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 706, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Selecciona tu entrador Pokeñon");
        pSeleccionPersonaje.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 119, 743, 71));

        Misty.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Misty.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pj3.png"))); // NOI18N
        Misty.setContentAreaFilled(false);
        Misty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MistyActionPerformed(evt);
            }
        });
        pSeleccionPersonaje.add(Misty, new org.netbeans.lib.awtextra.AbsoluteConstraints(924, 263, 207, 429));

        Ash.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Ash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pj1.png"))); // NOI18N
        Ash.setBorderPainted(false);
        Ash.setContentAreaFilled(false);
        Ash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AshActionPerformed(evt);
            }
        });
        pSeleccionPersonaje.add(Ash, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 263, 207, 429));
        pSeleccionPersonaje.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(691, 0, 743, 71));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("ASH");
        pSeleccionPersonaje.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 704, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("BROCK");
        pSeleccionPersonaje.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(741, 704, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("MISTY");
        pSeleccionPersonaje.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1002, 704, -1, -1));

        contenedor.addTab("Seleccionar Personaje", pSeleccionPersonaje);

        pSeleccionarPokeñon.setBackground(new java.awt.Color(255, 255, 255));
        pSeleccionarPokeñon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pSeleccionarPokeñonMouseEntered(evt);
            }
        });
        pSeleccionarPokeñon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pikachu.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        pikachu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pikachu.png"))); // NOI18N
        pikachu.setContentAreaFilled(false);
        pikachu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pikachuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pikachuMouseExited(evt);
            }
        });
        pikachu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pikachuActionPerformed(evt);
            }
        });
        pSeleccionarPokeñon.add(pikachu, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, -1, -1));

        volverAlMenu3.setText("VOLVER AL MENU");
        volverAlMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverAlMenu3ActionPerformed(evt);
            }
        });
        pSeleccionarPokeñon.add(volverAlMenu3, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 471, -1, -1));

        bulvasur.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bulbasur.png"))); // NOI18N
        bulvasur.setContentAreaFilled(false);
        bulvasur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bulvasurMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bulvasurMouseExited(evt);
            }
        });
        bulvasur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bulvasurActionPerformed(evt);
            }
        });
        pSeleccionarPokeñon.add(bulvasur, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 150, 125, 131));

        charmander.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/charmander.png"))); // NOI18N
        charmander.setContentAreaFilled(false);
        charmander.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                charmanderMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                charmanderMouseExited(evt);
            }
        });
        charmander.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                charmanderActionPerformed(evt);
            }
        });
        pSeleccionarPokeñon.add(charmander, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 150, 125, 131));

        squirtle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/squirtle.png"))); // NOI18N
        squirtle.setContentAreaFilled(false);
        squirtle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                squirtleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                squirtleMouseExited(evt);
            }
        });
        squirtle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                squirtleActionPerformed(evt);
            }
        });
        pSeleccionarPokeñon.add(squirtle, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 160, 125, 131));

        atras.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        atras.setText("Atrás");
        atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasActionPerformed(evt);
            }
        });
        pSeleccionarPokeñon.add(atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 29, 82, -1));

        eleccion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        eleccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pSeleccionarPokeñon.add(eleccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 190, 310, 54));

        nPikachu.setBackground(new java.awt.Color(255, 255, 255));
        nPikachu.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        nPikachu.setText("PIKACHU");
        pSeleccionarPokeñon.add(nPikachu, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, -1, -1));

        nBulbasur.setBackground(new java.awt.Color(255, 255, 255));
        nBulbasur.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        nBulbasur.setText("BULBASUR");
        pSeleccionarPokeñon.add(nBulbasur, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 310, -1, -1));

        nSquirtle.setBackground(new java.awt.Color(255, 255, 255));
        nSquirtle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        nSquirtle.setText("SQUIRTLE");
        nSquirtle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nSquirtleMouseClicked(evt);
            }
        });
        pSeleccionarPokeñon.add(nSquirtle, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 320, -1, -1));

        nCharmander.setBackground(new java.awt.Color(255, 255, 255));
        nCharmander.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        nCharmander.setText("CHARMANDER");
        pSeleccionarPokeñon.add(nCharmander, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 320, -1, -1));

        contenedor.addTab("Seleccionar Pokeñon", pSeleccionarPokeñon);

        pJuego.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pJuegoKeyPressed(evt);
            }
        });
        pJuego.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        IconoEntrenador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pikachu.png"))); // NOI18N
        IconoEntrenador.setContentAreaFilled(false);
        IconoEntrenador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IconoEntrenadorActionPerformed(evt);
            }
        });
        IconoEntrenador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                IconoEntrenadorKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                IconoEntrenadorKeyReleased(evt);
            }
        });
        pJuego.add(IconoEntrenador, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mapa.jpg"))); // NOI18N
        jLabel9.setMaximumSize(new java.awt.Dimension(1000, 500));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        pJuego.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1540, 770));

        contenedor.addTab("Juego", pJuego);

        pInventario.setBackground(new java.awt.Color(255, 255, 255));
        pInventario.setOpaque(false);
        pInventario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton10.setText("Vacio");
        jPanel2.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 133, 105, 99));

        jButton11.setText("Vacio");
        jPanel2.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 133, 105, 99));

        jButton12.setText("Vacio");
        jPanel2.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 133, 105, 99));

        jButton13.setText("Vacio");
        jPanel2.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 133, 105, 99));

        jButton14.setText("Vacio");
        jPanel2.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 250, 105, 99));

        jButton15.setText("Vacio");
        jPanel2.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 250, 105, 99));

        jButton16.setText("Vacio");
        jPanel2.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 250, 105, 99));

        jButton17.setText("Vacio");
        jPanel2.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 250, 105, 99));

        jButton18.setText("Vacio");
        jPanel2.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 367, 105, 99));

        jButton19.setText("Vacio");
        jPanel2.add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 367, 105, 99));

        jButton20.setText("Vacio");
        jPanel2.add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 367, 105, 99));

        jButton21.setText("Vacio");
        jPanel2.add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 367, 105, 99));

        jButton22.setText("Vacio");
        jPanel2.add(jButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 484, 105, 99));

        jButton23.setText("Vacio");
        jPanel2.add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 484, 105, 99));

        jButton24.setText("Vacio");
        jPanel2.add(jButton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 484, 105, 99));

        jButton25.setText("Vacio");
        jPanel2.add(jButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 484, 105, 99));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Mochila");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 36, 194, 60));

        jButton4.setText("Usar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 670, 80, -1));

        jButton5.setText("Soltar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 670, 80, -1));

        jButton42.setText("Volver al menú");
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton42, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 60, -1, -1));

        pInventario.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 770));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton26.setText("Vacio");
        jPanel3.add(jButton26, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 133, 105, 99));

        jButton27.setText("Vacio");
        jPanel3.add(jButton27, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 133, 105, 99));

        jButton28.setText("Vacio");
        jPanel3.add(jButton28, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 133, 105, 99));

        jButton29.setText("Vacio");
        jPanel3.add(jButton29, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 133, 105, 99));

        jButton30.setText("Vacio");
        jPanel3.add(jButton30, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 250, 105, 99));

        jButton31.setText("Vacio");
        jPanel3.add(jButton31, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 250, 105, 99));

        jButton32.setText("Vacio");
        jPanel3.add(jButton32, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 250, 105, 99));

        jButton33.setText("Vacio");
        jPanel3.add(jButton33, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 250, 105, 99));

        jButton34.setText("Vacio");
        jPanel3.add(jButton34, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 367, 105, 99));

        jButton35.setText("Vacio");
        jPanel3.add(jButton35, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 367, 105, 99));

        jButton36.setText("Vacio");
        jPanel3.add(jButton36, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 367, 105, 99));

        jButton37.setText("Vacio");
        jPanel3.add(jButton37, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 367, 105, 99));

        jButton38.setText("Vacio");
        jPanel3.add(jButton38, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 484, 105, 99));

        jButton39.setText("Vacio");
        jPanel3.add(jButton39, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 484, 105, 99));

        jButton40.setText("Vacio");
        jPanel3.add(jButton40, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 484, 105, 99));

        jButton41.setText("Vacio");
        jPanel3.add(jButton41, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 484, 105, 99));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Pokeñon");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 36, 194, 60));

        jButton7.setText("Usar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(373, 672, -1, -1));

        jButton8.setText("Soltar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 672, -1, -1));

        pInventario.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(808, 0, 730, 770));

        contenedor.addTab("Inventario", pInventario);

        javax.swing.GroupLayout EnfermeriaLayout = new javax.swing.GroupLayout(Enfermeria);
        Enfermeria.setLayout(EnfermeriaLayout);
        EnfermeriaLayout.setHorizontalGroup(
            EnfermeriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1540, Short.MAX_VALUE)
        );
        EnfermeriaLayout.setVerticalGroup(
            EnfermeriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
        );

        contenedor.addTab("tab7", Enfermeria);

        getContentPane().add(contenedor, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void AshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AshActionPerformed
        contenedor.setSelectedIndex(3);
        pikachu.setVisible(true);
    }//GEN-LAST:event_AshActionPerformed

    private void MistyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MistyActionPerformed
        contenedor.setSelectedIndex(3);
        pikachu.setVisible(false);
    }//GEN-LAST:event_MistyActionPerformed

    private void volverAlMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverAlMenu2ActionPerformed
        contenedor.setSelectedIndex(0);
    }//GEN-LAST:event_volverAlMenu2ActionPerformed

    private void BrookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BrookActionPerformed
        contenedor.setSelectedIndex(3);
        pikachu.setVisible(false);
    }//GEN-LAST:event_BrookActionPerformed

    private void pMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pMenuMouseClicked

    }//GEN-LAST:event_pMenuMouseClicked
//Controla el boton de audio
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
//Controla el slider de audio
    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        float volume = (float) jSlider1.getValue() / 100.0f;
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        float dB = (float) (Math.log10(volume) * 35.0);
        gainControl.setValue(dB);
    }//GEN-LAST:event_jSlider1StateChanged
//Guarda la partida y muestra que se ha guardado correctamente
    private void guardarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarPartidaActionPerformed
        jLabel1.setText("Tu partida ha sido guardada");
        ultimasPartidas.setVisible(false);
        Timer timer = new Timer(4000, (e) -> {
            jLabel1.setText("");
        });
        timer.setRepeats(false);
        timer.start();
    }//GEN-LAST:event_guardarPartidaActionPerformed
//Carga los datos desde un fichero todos los datos actuales 
    private void cargarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarPartidaActionPerformed
        ultimasPartidas.setVisible(true);
    }//GEN-LAST:event_cargarPartidaActionPerformed

    private void nuevaPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevaPartidaActionPerformed
        contenedor.setSelectedIndex(2);
        ultimasPartidas.setVisible(false);
    }//GEN-LAST:event_nuevaPartidaActionPerformed

    private void pJuegoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pJuegoKeyPressed
         
    }//GEN-LAST:event_pJuegoKeyPressed

    private void pSeleccionarPokeñonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pSeleccionarPokeñonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_pSeleccionarPokeñonMouseEntered

    private void nSquirtleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nSquirtleMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_nSquirtleMouseClicked

    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasActionPerformed
        contenedor.setSelectedIndex(1);
    }//GEN-LAST:event_atrasActionPerformed

    private void squirtleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_squirtleActionPerformed
        contenedor.setSelectedIndex(4);
    }//GEN-LAST:event_squirtleActionPerformed

    private void squirtleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_squirtleMouseExited
        nSquirtle.setForeground(Color.BLACK);
    }//GEN-LAST:event_squirtleMouseExited

    private void squirtleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_squirtleMouseEntered
        nSquirtle.setForeground(Color.CYAN);
    }//GEN-LAST:event_squirtleMouseEntered

    private void charmanderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_charmanderActionPerformed
        contenedor.setSelectedIndex(4);
    }//GEN-LAST:event_charmanderActionPerformed

    private void charmanderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_charmanderMouseExited
        nCharmander.setForeground(Color.BLACK);
    }//GEN-LAST:event_charmanderMouseExited

    private void charmanderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_charmanderMouseEntered
        nCharmander.setForeground(Color.RED);
    }//GEN-LAST:event_charmanderMouseEntered

    private void bulvasurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bulvasurActionPerformed
        contenedor.setSelectedIndex(4);
    }//GEN-LAST:event_bulvasurActionPerformed

    private void bulvasurMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bulvasurMouseExited
        nBulbasur.setForeground(Color.BLACK);
    }//GEN-LAST:event_bulvasurMouseExited

    private void bulvasurMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bulvasurMouseEntered
        nBulbasur.setForeground(Color.GREEN);
    }//GEN-LAST:event_bulvasurMouseEntered

    private void volverAlMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverAlMenu3ActionPerformed
        contenedor.setSelectedIndex(0);
    }//GEN-LAST:event_volverAlMenu3ActionPerformed

    private void pikachuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pikachuActionPerformed
        contenedor.setSelectedIndex(4);
    }//GEN-LAST:event_pikachuActionPerformed

    private void pikachuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pikachuMouseExited
        nPikachu.setForeground(Color.BLACK);
    }//GEN-LAST:event_pikachuMouseExited

    private void pikachuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pikachuMouseEntered
        nPikachu.setForeground(Color.YELLOW);
    }//GEN-LAST:event_pikachuMouseEntered

    private void barraComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_barraComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_barraComponentShown

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        System.out.println("X " + evt.getX());
        System.out.println("Y " + evt.getY());
        
    }//GEN-LAST:event_jLabel9MouseClicked

    private void IconoEntrenadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IconoEntrenadorKeyReleased
        stopMoving();
    }//GEN-LAST:event_IconoEntrenadorKeyReleased

    private void IconoEntrenadorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IconoEntrenadorKeyPressed
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_UP:
                startMoving(0, -1); 
                break;
            case KeyEvent.VK_DOWN:
                startMoving(0, 1); 
                break;
            case KeyEvent.VK_LEFT:
                startMoving(-1, 0);
                break;
            case KeyEvent.VK_RIGHT:
                startMoving(1, 0);
                break;
            default:
                break;
        }
    }//GEN-LAST:event_IconoEntrenadorKeyPressed

    private void IconoEntrenadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IconoEntrenadorActionPerformed
        Pokeñon pokeñon = new Pokeñon();
        pokeñon.getTipo()
    }//GEN-LAST:event_IconoEntrenadorActionPerformed

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton42ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed
//Clase interna de Action que contiene un metodo que aumenta el valor de la barra
    public class Action implements ActionListener{
        int i = 0;
        public void actionPerformed(ActionEvent e) {
            barra.setValue(i);
            if(i < 100){
                i++;
                porcentajeBarra.setText(i + "%");
            }else{
                contenedor.setSelectedIndex(1);
                temporizador.stop();
            }           
        }
    }
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
    private javax.swing.JPanel Enfermeria;
    private javax.swing.JButton IconoEntrenador;
    private javax.swing.JButton Misty;
    private javax.swing.JButton atras;
    private javax.swing.JProgressBar barra;
    private javax.swing.JButton bulvasur;
    private javax.swing.JButton cargarPartida;
    private javax.swing.JButton charmander;
    private javax.swing.JTabbedPane contenedor;
    private javax.swing.JLabel eleccion;
    private javax.swing.JButton guardarPartida;
    private javax.swing.JPanel inicio;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JLabel nBulbasur;
    private javax.swing.JLabel nCharmander;
    private javax.swing.JLabel nPikachu;
    private javax.swing.JLabel nSquirtle;
    private javax.swing.JButton nuevaPartida;
    private javax.swing.JPanel pInventario;
    private javax.swing.JPanel pJuego;
    private javax.swing.JPanel pMenu;
    private javax.swing.JPanel pSeleccionPersonaje;
    private javax.swing.JPanel pSeleccionarPokeñon;
    private javax.swing.JButton pikachu;
    private javax.swing.JLabel porcentajeBarra;
    private javax.swing.JButton squirtle;
    private javax.swing.JList<String> ultimasPartidas;
    private javax.swing.JButton volverAlMenu2;
    private javax.swing.JButton volverAlMenu3;
    // End of variables declaration//GEN-END:variables
}
