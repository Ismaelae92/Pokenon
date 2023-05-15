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
    private Acciones acciones;
    private Personaje personaje;
    
    public JFrame(){
        initComponents();
    //Bloquea todas las pestañas
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
    //Introduce un audio
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
        pNombreUsuario.setVisible(false);
    }
 
    //Inicializar límites del movimiento del botón cuando el JFrame es visible
    public void setVisible(boolean b) {
        super.setVisible(b);
        if (b) {
            limiteX = jLabel9.getWidth() - IconoEntrenador.getWidth();
            limiteY = jLabel9.getHeight() - IconoEntrenador.getHeight();
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
        contenedor.setSelectedIndex(6);

    }
        IconoEntrenador.setLocation(x, y);
    }
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogGuardar = new javax.swing.JDialog();
        jLabel10 = new javax.swing.JLabel();
        urlDestino = new javax.swing.JTextField();
        guardar = new javax.swing.JButton();
        error = new javax.swing.JDialog();
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
        bulvasur = new javax.swing.JButton();
        charmander = new javax.swing.JButton();
        squirtle = new javax.swing.JButton();
        nPikachu = new javax.swing.JLabel();
        nBulbasur = new javax.swing.JLabel();
        nSquirtle = new javax.swing.JLabel();
        nCharmander = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        pNombreUsuario = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        pJuego = new javax.swing.JPanel();
        IconoEntrenador = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        pInventario = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        vacio = new javax.swing.JButton();
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
        guardarPartida = new javax.swing.JButton();
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

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Ruta de guardado");

        urlDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urlDestinoActionPerformed(evt);
            }
        });

        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogGuardarLayout = new javax.swing.GroupLayout(dialogGuardar.getContentPane());
        dialogGuardar.getContentPane().setLayout(dialogGuardarLayout);
        dialogGuardarLayout.setHorizontalGroup(
            dialogGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogGuardarLayout.createSequentialGroup()
                .addGroup(dialogGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogGuardarLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dialogGuardarLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(urlDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dialogGuardarLayout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(guardar)))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        dialogGuardarLayout.setVerticalGroup(
            dialogGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogGuardarLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(urlDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(guardar)
                .addContainerGap(147, Short.MAX_VALUE))
        );

        mensajeError.setText("jLabel11");

        javax.swing.GroupLayout errorLayout = new javax.swing.GroupLayout(error.getContentPane());
        error.getContentPane().setLayout(errorLayout);
        errorLayout.setHorizontalGroup(
            errorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(errorLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(mensajeError, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );
        errorLayout.setVerticalGroup(
            errorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(errorLayout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(mensajeError, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
        );

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

        contenedor.addTab("Menú", pMenu);

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

        volverAlMenu3.setText("VOLVER AL MENU");
        volverAlMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverAlMenu3ActionPerformed(evt);
            }
        });

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
        nBulbasur.setText("BULBASUR");

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
        jLabel12.setText("Elige un Pokeñon");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Nombre entrenador:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pNombreUsuarioLayout = new javax.swing.GroupLayout(pNombreUsuario);
        pNombreUsuario.setLayout(pNombreUsuarioLayout);
        pNombreUsuarioLayout.setHorizontalGroup(
            pNombreUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pNombreUsuarioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(pNombreUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pNombreUsuarioLayout.setVerticalGroup(
            pNombreUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pNombreUsuarioLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pSeleccionLayout = new javax.swing.GroupLayout(pSeleccion);
        pSeleccion.setLayout(pSeleccionLayout);
        pSeleccionLayout.setHorizontalGroup(
            pSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSeleccionLayout.createSequentialGroup()
                .addGroup(pSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pSeleccionLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(volverAlMenu3))
                    .addGroup(pSeleccionLayout.createSequentialGroup()
                        .addGap(301, 301, 301)
                        .addGroup(pSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pSeleccionLayout.createSequentialGroup()
                                .addGroup(pSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nPikachu)
                                    .addComponent(pikachu))
                                .addGroup(pSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pSeleccionLayout.createSequentialGroup()
                                        .addGap(85, 85, 85)
                                        .addComponent(bulvasur, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 284, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pSeleccionLayout.createSequentialGroup()
                        .addGap(570, 570, 570)
                        .addComponent(pNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(659, Short.MAX_VALUE))
        );
        pSeleccionLayout.setVerticalGroup(
            pSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSeleccionLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(pSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pSeleccionLayout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(pSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pikachu)
                            .addComponent(bulvasur, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(charmander, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(squirtle, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(pSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nPikachu)
                            .addComponent(nBulbasur)
                            .addComponent(nCharmander)
                            .addComponent(nSquirtle))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(pNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(149, 149, 149)
                .addComponent(volverAlMenu3)
                .addGap(186, 186, 186))
        );

        contenedor.addTab("Seleccionar", pSeleccion);

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

        vacio.setText("Vacio");
        jPanel2.add(vacio, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 133, 105, 99));

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

        guardarPartida.setText("guardarPartida");
        guardarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarPartidaActionPerformed(evt);
            }
        });
        jPanel2.add(guardarPartida, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 180, -1, -1));

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

        getContentPane().add(contenedor, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents



    private void urlDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urlDestinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_urlDestinoActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        try{
            Acciones acciones = new Acciones();
            acciones.guardar(personaje,urlDestino.getText());    
        }catch(IOException e){
           error.setVisible(true);
           mensajeError.setText(e.getMessage());
        }
        
        
        dialogGuardar.setVisible(false);
    }//GEN-LAST:event_guardarActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

    }//GEN-LAST:event_jButton7ActionPerformed

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

    private void pJuegoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pJuegoKeyPressed

    }//GEN-LAST:event_pJuegoKeyPressed

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
        // TODO add your handling code here:
    }//GEN-LAST:event_IconoEntrenadorActionPerformed

    private void pSeleccionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pSeleccionMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_pSeleccionMouseEntered

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void nSquirtleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nSquirtleMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_nSquirtleMouseClicked

    private void squirtleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_squirtleActionPerformed
        pNombreUsuario.setVisible(true);
    }//GEN-LAST:event_squirtleActionPerformed

    private void squirtleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_squirtleMouseExited
        nSquirtle.setForeground(Color.BLACK);
    }//GEN-LAST:event_squirtleMouseExited

    private void squirtleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_squirtleMouseEntered
        nSquirtle.setForeground(Color.CYAN);
    }//GEN-LAST:event_squirtleMouseEntered

    private void charmanderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_charmanderActionPerformed
        pNombreUsuario.setVisible(true);
    }//GEN-LAST:event_charmanderActionPerformed

    private void charmanderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_charmanderMouseExited
        nCharmander.setForeground(Color.BLACK);
    }//GEN-LAST:event_charmanderMouseExited

    private void charmanderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_charmanderMouseEntered
        nCharmander.setForeground(Color.RED);
    }//GEN-LAST:event_charmanderMouseEntered

    private void bulvasurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bulvasurActionPerformed
        pNombreUsuario.setVisible(true);
    }//GEN-LAST:event_bulvasurActionPerformed

    private void bulvasurMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bulvasurMouseExited
        nBulbasur.setForeground(Color.BLACK);
    }//GEN-LAST:event_bulvasurMouseExited

    private void bulvasurMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bulvasurMouseEntered
        nBulbasur.setForeground(Color.GREEN);
    }//GEN-LAST:event_bulvasurMouseEntered

    private void volverAlMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverAlMenu3ActionPerformed
        contenedor.setSelectedIndex(1);
    }//GEN-LAST:event_volverAlMenu3ActionPerformed

    private void pikachuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pikachuActionPerformed
        pNombreUsuario.setVisible(true);
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
    public javax.swing.JButton bulvasur;
    public javax.swing.JFileChooser cargarArchivo;
    public javax.swing.JButton cargarPartida;
    public javax.swing.JButton charmander;
    public javax.swing.JTabbedPane contenedor;
    public javax.swing.JDialog dialogGuardar;
    public javax.swing.JDialog error;
    public javax.swing.JButton guardar;
    public javax.swing.JButton guardarPartida;
    public javax.swing.JPanel inicio;
    public javax.swing.JButton jButton11;
    public javax.swing.JButton jButton12;
    public javax.swing.JButton jButton13;
    public javax.swing.JButton jButton14;
    public javax.swing.JButton jButton15;
    public javax.swing.JButton jButton16;
    public javax.swing.JButton jButton17;
    public javax.swing.JButton jButton18;
    public javax.swing.JButton jButton19;
    public javax.swing.JButton jButton20;
    public javax.swing.JButton jButton21;
    public javax.swing.JButton jButton22;
    public javax.swing.JButton jButton23;
    public javax.swing.JButton jButton24;
    public javax.swing.JButton jButton25;
    public javax.swing.JButton jButton26;
    public javax.swing.JButton jButton27;
    public javax.swing.JButton jButton28;
    public javax.swing.JButton jButton29;
    public javax.swing.JButton jButton30;
    public javax.swing.JButton jButton31;
    public javax.swing.JButton jButton32;
    public javax.swing.JButton jButton33;
    public javax.swing.JButton jButton34;
    public javax.swing.JButton jButton35;
    public javax.swing.JButton jButton36;
    public javax.swing.JButton jButton37;
    public javax.swing.JButton jButton38;
    public javax.swing.JButton jButton39;
    public javax.swing.JButton jButton4;
    public javax.swing.JButton jButton40;
    public javax.swing.JButton jButton41;
    public javax.swing.JButton jButton42;
    public javax.swing.JButton jButton5;
    public javax.swing.JButton jButton7;
    public javax.swing.JButton jButton8;
    public javax.swing.JButton jButton9;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel11;
    public javax.swing.JLabel jLabel12;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel9;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanel7;
    public javax.swing.JSlider jSlider1;
    public javax.swing.JTextField jTextField1;
    public javax.swing.JLabel mensajeError;
    public javax.swing.JLabel nBulbasur;
    public javax.swing.JLabel nCharmander;
    public javax.swing.JLabel nPikachu;
    public javax.swing.JLabel nSquirtle;
    public javax.swing.JButton nuevaPartida;
    public javax.swing.JPanel pInventario;
    public javax.swing.JPanel pJuego;
    public javax.swing.JPanel pMenu;
    public javax.swing.JPanel pNombreUsuario;
    public javax.swing.JPanel pSeleccion;
    public javax.swing.JButton pikachu;
    public javax.swing.JLabel porcentajeBarra;
    public javax.swing.JButton squirtle;
    public javax.swing.JTextField urlDestino;
    public javax.swing.JButton vacio;
    public javax.swing.JButton volverAlMenu3;
    // End of variables declaration//GEN-END:variables
}
