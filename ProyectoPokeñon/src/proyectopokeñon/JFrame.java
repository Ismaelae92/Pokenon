/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyectopoke�on;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.Timer;

/**
 *
 * @author Ismael
 */
public class JFrame extends javax.swing.JFrame {
    
    private Clip clip;
    private AudioInputStream audioInputStream;
    private int x, y;
    private Timer temporizador;
    private Timer timer;
    private int moveAmount = 5;
    private Action accion;
    int limiteX ;
    int limiteY;
    private Personaje personaje;
    private Poke�on poke�on;
    
    public JFrame(){
        initComponents();
    //Bloquea todas las pesta�as
        contenedor.setEnabledAt(0, false);
        contenedor.setEnabledAt(1, false);
        contenedor.setEnabledAt(2, false);
        contenedor.setEnabledAt(3, false);
        contenedor.setEnabledAt(4, false);
    //Para que habra la aplicacion a pantalla completa y maximizada
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null); 
    
    //Inicia accion de temporizador e indica que cambie de pantalla cuando termine el progreso
        if(inicio.isEnabled()){
            accion = new Action();
            temporizador = new Timer(30,accion);
            temporizador.start();
            if(barra.getValue() == 100){
                contenedor.setSelectedIndex(1);
            }
        }  
        cargarArchivo.setVisible(false);
        personaje = new Personaje();
        
        dialogGuardar.setSize(800, 400);
        dialogGuardar.setLocationRelativeTo(this);
        error.setLocationRelativeTo(this);
        error.setSize(400, 200);;  
    }
 
    //Inicializar l�mites del movimiento del bot�n cuando el JFrame es visible
    public void setVisible(boolean b) {
        super.setVisible(b);
        if (b) {
            limiteX = mapa.getWidth() - IconoEntrenador.getWidth();
            limiteY = mapa.getHeight() - IconoEntrenador.getHeight();
        }
    }
    
    public void startMoving(int dx, int dy) {
        stopMoving(); // Detener el movimiento actual si hay alguno en curso
        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveButton(dx * moveAmount, dy * moveAmount);
            }
        });
        timer.start();
    }

    public void stopMoving() {
        if (timer != null) {
            timer.stop();
            timer = null;
        }
    }

    public void moveButton(int dx, int dy) {
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
        double distancia = Math.sqrt(Math.pow(x - 430, 2) + Math.pow(y - 700, 2));

        // Si la distancia es menor que 50, mostrar el JTabbedPane
        if (distancia < 100) {

    }
        IconoEntrenador.setLocation(x, y);
    }
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogGuardar = new javax.swing.JDialog();
        jLabel10 = new javax.swing.JLabel();
        urlDestino = new javax.swing.JTextField();
        save = new javax.swing.JButton();
        error = new javax.swing.JDialog();
        jLabel4 = new javax.swing.JLabel();
        mensajeError = new javax.swing.JLabel();
        contenedor = new javax.swing.JTabbedPane();
        inicio = new javax.swing.JPanel();
        barra = new javax.swing.JProgressBar();
        porcentajeBarra = new javax.swing.JLabel();
        pMenu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        nuevaPartida = new javax.swing.JButton();
        cargarPartida = new javax.swing.JButton();
        jSlider1 = new javax.swing.JSlider();
        jButton9 = new javax.swing.JButton();
        cargarArchivo = new javax.swing.JFileChooser();
        pSeleccion = new javax.swing.JPanel();
        pikachu = new javax.swing.JButton();
        volverAlMenu3 = new javax.swing.JButton();
        bulbasaur = new javax.swing.JButton();
        charmander = new javax.swing.JButton();
        squirtle = new javax.swing.JButton();
        nPikachu = new javax.swing.JLabel();
        nBulbasur = new javax.swing.JLabel();
        nSquirtle = new javax.swing.JLabel();
        nCharmander = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        irJuego = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        insertarUsuario = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        pJuego = new javax.swing.JPanel();
        contenedorMapa = new javax.swing.JLayeredPane();
        irInventario = new javax.swing.JButton();
        IconoEntrenador = new javax.swing.JButton();
        mapa = new javax.swing.JLabel();
        pInventario = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        guardarPartida = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaMochila = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaPoke = new javax.swing.JList<>();
        imagenes = new javax.swing.JLabel();

        dialogGuardar.setModal(true);
        dialogGuardar.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Ruta de guardado");
        dialogGuardar.getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 190, 38));

        urlDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urlDestinoActionPerformed(evt);
            }
        });
        dialogGuardar.getContentPane().add(urlDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 268, -1));

        save.setText("Guardar");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        dialogGuardar.getContentPane().add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, -1, -1));

        jLabel4.setText("Mensaje de error:");

        javax.swing.GroupLayout errorLayout = new javax.swing.GroupLayout(error.getContentPane());
        error.getContentPane().setLayout(errorLayout);
        errorLayout.setHorizontalGroup(
            errorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(errorLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(errorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(mensajeError, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        errorLayout.setVerticalGroup(
            errorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(errorLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mensajeError, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(168, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Poke�on");

        contenedor.setBackground(new java.awt.Color(255, 255, 255));
        contenedor.setAlignmentX(1.0F);
        contenedor.setAlignmentY(1.0F);
        contenedor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        contenedor.setFocusable(false);

        inicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barra.setBackground(new java.awt.Color(255, 255, 255));
        barra.setToolTipText("");
        barra.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                barraStateChanged(evt);
            }
        });
        barra.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                barraComponentShown(evt);
            }
        });
        inicio.add(barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, 554, 49));

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
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nuevaPartida.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        nuevaPartida.setText("Nueva partida");
        nuevaPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevaPartidaActionPerformed(evt);
            }
        });
        jPanel7.add(nuevaPartida, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 67, 213, -1));

        cargarPartida.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        cargarPartida.setText("Cargar partida");
        cargarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarPartidaActionPerformed(evt);
            }
        });
        jPanel7.add(cargarPartida, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 177, -1, -1));

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

        cargarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarArchivoActionPerformed(evt);
            }
        });
        pMenu.add(cargarArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 70, -1, -1));

        contenedor.addTab("Men�", pMenu);

        pSeleccion.setBackground(new java.awt.Color(255, 255, 255));
        pSeleccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pSeleccionMouseEntered(evt);
            }
        });

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

        volverAlMenu3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        volverAlMenu3.setText("VOLVER AL MENU");
        volverAlMenu3.setPreferredSize(new java.awt.Dimension(96, 23));
        volverAlMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverAlMenu3ActionPerformed(evt);
            }
        });

        bulbasaur.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bulbasur.png"))); // NOI18N
        bulbasaur.setContentAreaFilled(false);
        bulbasaur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bulbasaurMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bulbasaurMouseExited(evt);
            }
        });
        bulbasaur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bulbasaurActionPerformed(evt);
            }
        });

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

        nPikachu.setBackground(new java.awt.Color(255, 255, 255));
        nPikachu.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        nPikachu.setText("PIKACHU");

        nBulbasur.setBackground(new java.awt.Color(255, 255, 255));
        nBulbasur.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        nBulbasur.setText("BULBASAUR");

        nSquirtle.setBackground(new java.awt.Color(255, 255, 255));
        nSquirtle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        nSquirtle.setText("SQUIRTLE");
        nSquirtle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nSquirtleMouseClicked(evt);
            }
        });

        nCharmander.setBackground(new java.awt.Color(255, 255, 255));
        nCharmander.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        nCharmander.setText("CHARMANDER");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setText("Elige un Poke�on");

        irJuego.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        irJuego.setText("CONTINUAR");
        irJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                irJuegoActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Nombre entrenador:");

        insertarUsuario.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        insertarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertarUsuarioActionPerformed(evt);
            }
        });
        insertarUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                insertarUsuarioKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 687, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pSeleccionLayout = new javax.swing.GroupLayout(pSeleccion);
        pSeleccion.setLayout(pSeleccionLayout);
        pSeleccionLayout.setHorizontalGroup(
            pSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSeleccionLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(volverAlMenu3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(irJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(793, 793, 793))
            .addGroup(pSeleccionLayout.createSequentialGroup()
                .addGap(334, 334, 334)
                .addGroup(pSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pSeleccionLayout.createSequentialGroup()
                            .addGroup(pSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nPikachu)
                                .addComponent(pikachu))
                            .addGroup(pSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pSeleccionLayout.createSequentialGroup()
                                    .addGap(85, 85, 85)
                                    .addComponent(bulbasaur, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(105, 105, 105))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pSeleccionLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(nBulbasur)
                                    .addGap(113, 113, 113)))
                            .addGroup(pSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pSeleccionLayout.createSequentialGroup()
                                    .addComponent(charmander, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(95, 95, 95)
                                    .addComponent(squirtle, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pSeleccionLayout.createSequentialGroup()
                                    .addComponent(nCharmander)
                                    .addGap(106, 106, 106)
                                    .addComponent(nSquirtle))))
                        .addGroup(pSeleccionLayout.createSequentialGroup()
                            .addGap(299, 299, 299)
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pSeleccionLayout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addGroup(pSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(insertarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(387, 387, 387)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pSeleccionLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {irJuego, volverAlMenu3});

        pSeleccionLayout.setVerticalGroup(
            pSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSeleccionLayout.createSequentialGroup()
                .addGroup(pSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pSeleccionLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pSeleccionLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(pSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pSeleccionLayout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addGroup(pSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pikachu)
                                    .addComponent(bulbasaur, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(charmander, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(squirtle, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(pSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(nPikachu)
                                    .addComponent(nBulbasur)
                                    .addComponent(nCharmander)
                                    .addComponent(nSquirtle))))
                        .addGap(33, 33, 33)
                        .addComponent(jLabel11)
                        .addGap(8, 8, 8)
                        .addComponent(insertarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                .addGroup(pSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volverAlMenu3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(irJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69))
        );

        pSeleccionLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {irJuego, volverAlMenu3});

        contenedor.addTab("Seleccionar", pSeleccion);

        pJuego.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pJuegoKeyPressed(evt);
            }
        });
        pJuego.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        irInventario.setBackground(new java.awt.Color(102, 102, 255));
        irInventario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        irInventario.setForeground(new java.awt.Color(255, 255, 255));
        irInventario.setText("INVENTARIO");
        irInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                irInventarioActionPerformed(evt);
            }
        });

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

        mapa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mapa.jpg"))); // NOI18N
        mapa.setMaximumSize(new java.awt.Dimension(1000, 500));
        mapa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mapaMouseClicked(evt);
            }
        });

        contenedorMapa.setLayer(irInventario, javax.swing.JLayeredPane.PALETTE_LAYER);
        contenedorMapa.setLayer(IconoEntrenador, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contenedorMapa.setLayer(mapa, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout contenedorMapaLayout = new javax.swing.GroupLayout(contenedorMapa);
        contenedorMapa.setLayout(contenedorMapaLayout);
        contenedorMapaLayout.setHorizontalGroup(
            contenedorMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorMapaLayout.createSequentialGroup()
                .addGroup(contenedorMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenedorMapaLayout.createSequentialGroup()
                        .addGap(490, 490, 490)
                        .addComponent(IconoEntrenador))
                    .addGroup(contenedorMapaLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(irInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1114, Short.MAX_VALUE))
            .addGroup(contenedorMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(contenedorMapaLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(mapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        contenedorMapaLayout.setVerticalGroup(
            contenedorMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorMapaLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(irInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(IconoEntrenador)
                .addContainerGap(581, Short.MAX_VALUE))
            .addGroup(contenedorMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(contenedorMapaLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(mapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pJuego.add(contenedorMapa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        contenedor.addTab("Juego", pJuego);

        pInventario.setBackground(new java.awt.Color(255, 255, 255));
        pInventario.setOpaque(false);
        pInventario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jButton42.setText("Volver al men�");
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton42, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 80, -1, -1));

        guardarPartida.setText("guardarPartida");
        guardarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarPartidaActionPerformed(evt);
            }
        });
        jPanel2.add(guardarPartida, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 130, -1, -1));

        listaMochila.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaMochila.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                listaMochilaFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(listaMochila);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 410, 490));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Poke�on");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 50, 194, 60));

        listaPoke.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaPoke.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                listaPokeFocusGained(evt);
            }
        });
        jScrollPane2.setViewportView(listaPoke);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 130, 410, 490));
        jPanel2.add(imagenes, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 320, 160, 140));

        pInventario.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1490, 810));

        contenedor.addTab("Inventario", pInventario);

        getContentPane().add(contenedor, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents



    private void urlDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urlDestinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_urlDestinoActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        try{
            if(!urlDestino.getText().isEmpty()){
                Acciones.guardar(personaje,urlDestino.getText());
                dialogGuardar.setVisible(false);      
            }else{
                dialogGuardar.dispose();
                error.setVisible(true);
                mensajeError.setText("La URL no puede estar vac�a");
            }
        }catch(IOException e){ 
           dialogGuardar.dispose();
           error.setVisible(true);
           mensajeError.setText(e.getMessage());
        }
        
    }//GEN-LAST:event_saveActionPerformed

    private void pJuegoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pJuegoKeyPressed

    }//GEN-LAST:event_pJuegoKeyPressed

    private void mapaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mapaMouseClicked
        System.out.println("X " + evt.getX());
        System.out.println("Y " + evt.getY());
    }//GEN-LAST:event_mapaMouseClicked

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
        // TODO add your handling code here:
    }//GEN-LAST:event_IconoEntrenadorActionPerformed

    private void pSeleccionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pSeleccionMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_pSeleccionMouseEntered

    private void insertarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertarUsuarioActionPerformed
        
    }//GEN-LAST:event_insertarUsuarioActionPerformed

    private void nSquirtleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nSquirtleMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_nSquirtleMouseClicked

    private void squirtleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_squirtleActionPerformed
        Acciones.A�adirPokemon(personaje, poke�on.SQUIRTLE);
        bulbasaur.setEnabled(false);
        pikachu.setEnabled(false);
        charmander.setEnabled(false);
    }//GEN-LAST:event_squirtleActionPerformed

    private void squirtleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_squirtleMouseExited
        nSquirtle.setForeground(Color.BLACK);
    }//GEN-LAST:event_squirtleMouseExited

    private void squirtleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_squirtleMouseEntered
        nSquirtle.setForeground(Color.CYAN);
    }//GEN-LAST:event_squirtleMouseEntered

    private void charmanderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_charmanderActionPerformed
        Acciones.A�adirPokemon(personaje, poke�on.CHARMANDER);
        bulbasaur.setEnabled(false);
        squirtle.setEnabled(false);
        pikachu.setEnabled(false);
    }//GEN-LAST:event_charmanderActionPerformed

    private void charmanderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_charmanderMouseExited
        nCharmander.setForeground(Color.BLACK);
    }//GEN-LAST:event_charmanderMouseExited

    private void charmanderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_charmanderMouseEntered
        nCharmander.setForeground(Color.RED);
    }//GEN-LAST:event_charmanderMouseEntered

    private void bulbasaurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bulbasaurActionPerformed
        Acciones.A�adirPokemon(personaje, poke�on.BULBASAUR);
        pikachu.setEnabled(false);
        squirtle.setEnabled(false);
        charmander.setEnabled(false);
    }//GEN-LAST:event_bulbasaurActionPerformed

    private void bulbasaurMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bulbasaurMouseExited
        nBulbasur.setForeground(Color.BLACK);
    }//GEN-LAST:event_bulbasaurMouseExited

    private void bulbasaurMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bulbasaurMouseEntered
        nBulbasur.setForeground(Color.GREEN);
    }//GEN-LAST:event_bulbasaurMouseEntered

    private void volverAlMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverAlMenu3ActionPerformed
        contenedor.setSelectedIndex(1);
    }//GEN-LAST:event_volverAlMenu3ActionPerformed

    private void pikachuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pikachuActionPerformed
        Acciones.A�adirPokemon(personaje, poke�on.PIKACHU);
        bulbasaur.setEnabled(false);
        squirtle.setEnabled(false);
        charmander.setEnabled(false);
    }//GEN-LAST:event_pikachuActionPerformed

    private void pikachuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pikachuMouseExited
        nPikachu.setForeground(Color.BLACK);
    }//GEN-LAST:event_pikachuMouseExited

    private void pikachuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pikachuMouseEntered
        nPikachu.setForeground(Color.YELLOW);
    }//GEN-LAST:event_pikachuMouseEntered

    private void pMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pMenuMouseClicked

    }//GEN-LAST:event_pMenuMouseClicked

    private void cargarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarArchivoActionPerformed
        try{
            personaje = Acciones.cargar(cargarArchivo.getSelectedFile());
            cargarArchivo.setVisible(false);
            contenedor.setSelectedIndex(3);
        }catch(IOException e){
            error.setVisible(true);
            mensajeError.setText(e.getMessage());
        } catch (ClassNotFoundException ex) {
            error.setVisible(true);
            mensajeError.setText(ex.getMessage());
        }

    }//GEN-LAST:event_cargarArchivoActionPerformed

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

    private void cargarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarPartidaActionPerformed
        cargarArchivo.setVisible(true);
    }//GEN-LAST:event_cargarPartidaActionPerformed

    private void nuevaPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevaPartidaActionPerformed
        contenedor.setSelectedIndex(2);
    }//GEN-LAST:event_nuevaPartidaActionPerformed

    private void barraComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_barraComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_barraComponentShown

    private void insertarUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_insertarUsuarioKeyPressed

    }//GEN-LAST:event_insertarUsuarioKeyPressed

    private void irJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_irJuegoActionPerformed
        if(!insertarUsuario.getText().isBlank()){
            personaje.setNombreUsuario(insertarUsuario.getText());
            contenedor.setSelectedIndex(3);
        }
    }//GEN-LAST:event_irJuegoActionPerformed

    private void irInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_irInventarioActionPerformed
        contenedor.setSelectedIndex(4);
        DefaultListModel listaPoke�on = new DefaultListModel();
        DefaultListModel listaObjetos = new DefaultListModel();
        listaPoke�on.addAll(personaje.getPoke�ons());
        listaObjetos.addAll(personaje.getObjetos());
        listaPoke.setModel(listaPoke�on);
        listaMochila.setModel(listaObjetos);
    }//GEN-LAST:event_irInventarioActionPerformed

    private void barraStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_barraStateChanged
        if(barra.getValue()==99){
            File soundFile = new File("src\\audio\\intro.wav");
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
                clip.loop(Clip.LOOP_CONTINUOUSLY); //Para el el audio se ejecute en bucle
                FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                float dB = (float) (Math.log10(0.5) * 35.0);
                gainControl.setValue(dB);
            } catch (LineUnavailableException l) {
                System.out.println("Error en el audio");
            } catch (IOException e) {
                System.out.println("err");
            }
        }
    }//GEN-LAST:event_barraStateChanged

    private void guardarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarPartidaActionPerformed
        dialogGuardar.setVisible(true);
    }//GEN-LAST:event_guardarPartidaActionPerformed

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton42ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

    }//GEN-LAST:event_jButton4ActionPerformed

    private void listaPokeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_listaPokeFocusGained
        ImageIcon icono = new ImageIcon(personaje.getPoke�ons().get(listaPoke.getSelectedIndex()).getUrl());
        imagenes.setIcon(icono);
    }//GEN-LAST:event_listaPokeFocusGained

    private void listaMochilaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_listaMochilaFocusGained
        ImageIcon icono = new ImageIcon(personaje.getObjetos().get(listaPoke.getSelectedIndex()).getUrl());
        imagenes.setIcon(icono);
    }//GEN-LAST:event_listaMochilaFocusGained
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
    public javax.swing.JButton IconoEntrenador;
    public javax.swing.JProgressBar barra;
    public javax.swing.JButton bulbasaur;
    public javax.swing.JFileChooser cargarArchivo;
    public javax.swing.JButton cargarPartida;
    public javax.swing.JButton charmander;
    public javax.swing.JTabbedPane contenedor;
    public javax.swing.JLayeredPane contenedorMapa;
    public javax.swing.JDialog dialogGuardar;
    public javax.swing.JDialog error;
    public javax.swing.JButton guardarPartida;
    public javax.swing.JLabel imagenes;
    public javax.swing.JPanel inicio;
    public javax.swing.JTextField insertarUsuario;
    public javax.swing.JButton irInventario;
    public javax.swing.JButton irJuego;
    public javax.swing.JButton jButton4;
    public javax.swing.JButton jButton42;
    public javax.swing.JButton jButton5;
    public javax.swing.JButton jButton9;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel11;
    public javax.swing.JLabel jLabel12;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel7;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JSlider jSlider1;
    public javax.swing.JList<String> listaMochila;
    public javax.swing.JList<String> listaPoke;
    public javax.swing.JLabel mapa;
    public javax.swing.JLabel mensajeError;
    public javax.swing.JLabel nBulbasur;
    public javax.swing.JLabel nCharmander;
    public javax.swing.JLabel nPikachu;
    public javax.swing.JLabel nSquirtle;
    public javax.swing.JButton nuevaPartida;
    public javax.swing.JPanel pInventario;
    public javax.swing.JPanel pJuego;
    public javax.swing.JPanel pMenu;
    public javax.swing.JPanel pSeleccion;
    public javax.swing.JButton pikachu;
    public javax.swing.JLabel porcentajeBarra;
    public javax.swing.JButton save;
    public javax.swing.JButton squirtle;
    public javax.swing.JTextField urlDestino;
    public javax.swing.JButton volverAlMenu3;
    // End of variables declaration//GEN-END:variables
}
