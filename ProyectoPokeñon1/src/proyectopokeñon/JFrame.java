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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
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
    int limiteX;
    int limiteY;
    private static Personaje personaje;
    private Pokeñon pokeñon;
    public List<Objetos> objetosRandom;
    public List<Pokeñon> pokeñonRandom;
    private Pokeñon aliado;
    private Pokeñon pokeñonAleatorioRival;
    ImageIcon der = new ImageIcon("src\\imagenes\\der.png");
    ImageIcon izq = new ImageIcon("src\\imagenes\\izq.png");
    ImageIcon arr = new ImageIcon("src\\imagenes\\adelante.png");
    ImageIcon abj = new ImageIcon("src\\imagenes\\atras.png");

    public JFrame() {
        initComponents();
        //Bloquea todas las pestañas
        contenedor.setEnabledAt(0, false);
        contenedor.setEnabledAt(1, false);
        contenedor.setEnabledAt(2, false);
        contenedor.setEnabledAt(3, false);
        contenedor.setEnabledAt(4, false);
        contenedor.setEnabledAt(5, false);
        //Para que habra la aplicacion a pantalla completa y maximizada
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        
        //Inicia accion de temporizador e indica que cambie de pantalla cuando termine el progreso
        if (inicio.isEnabled()) {
            accion = new Action();
            temporizador = new Timer(10, accion);
            temporizador.start();
            if (barra.getValue() == 100) {
                contenedor.setSelectedIndex(1);
            }
        }
        cargarArchivo.setVisible(false);
        personaje = new Personaje();
        objetosRandom = new ArrayList();
        pokeñonRandom = new ArrayList();
        //Rellena listas random iniciales
        for (Objetos objeto : Objetos.values()) {
            objetosRandom.add(objeto);
        }
        
        for (Pokeñon objeto : Pokeñon.values()) {
            pokeñonRandom.add(objeto);
        }
        
        dialogGuardar.setSize(800, 400);
        dialogGuardar.setLocationRelativeTo(this);
        error.setLocationRelativeTo(this);
        error.setSize(400, 200);
        soltarPokeñon.setEnabled(false);
        soltarObjeto.setEnabled(false);
        combateTerminado.setVisible(false);
        combateTerminado.setLocationRelativeTo(this);
        combateTerminado.setSize(600, 600);
        personaje.getObjetos().add(Objetos.MAXPOCION);
    }

    private void introducirAudio() {
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
                if (!EncuentraObjeto.isVisible()) { // Verificar si la ventana EncuentraObjeto no está visible
                    moveButton(dx * moveAmount, dy * moveAmount);
                }
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
        IconoEntrenador.setLocation(x, y);
        encuentraObjeto();
        encuentraPokeñon();
    }

    public void encuentraObjeto() {
        // Detectar si el botón está cerca de una coordenada
        double posicionObjetos = Math.sqrt(Math.pow(x - (int) (Math.random() * (1516)), 2) + Math.pow(y - (int) (Math.random() * (764)), 2));
        if (posicionObjetos < 30) { // Si la distancia es menor que 100, mostrar el diálogo EncuentraObjeto
            stopMoving();
            EncuentraObjeto.setVisible(true);
            Objetos objetoAleatorio = objetosRandom.get((int) (Math.random() * objetosRandom.size())); // Obtener el objeto correspondiente al índice aleatorio
            personaje.getObjetos().add(objetoAleatorio);
            ImageIcon icono = new ImageIcon(objetoAleatorio.getUrl()); // Crear el ImageIcon a partir de la URL
            objetoEncontrado.setIcon(icono); // Establecer el ImageIcon en el objeto encontrado
            timer();
        }
    }

    public void encuentraPokeñon() {
        // Detectar si el botón está cerca de una coordenada
        double posicionPokeñon = Math.sqrt(Math.pow(x - (int) (Math.random() * (1516)), 2) + Math.pow(y - (int) (Math.random() * (764)), 2));
        if (posicionPokeñon < 30) { // Si la distancia es menor que 100, mostrar el diálogo EncuentraObjeto
            stopMoving();
            contenedor.setSelectedIndex(5);
            combate();
        }
    }

    public void timer(){
        int delay = 2000; 
        Timer timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EncuentraObjeto.dispose();
                startMoving(0, 0); 
            }
        });
        timer.setRepeats(false); // No se repetirá
        // Iniciar el temporizador
        timer.start();
    }
    
    public void timerCombate() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public void combate(){
        pokeñonAleatorioRival = pokeñonRandom.get((int) (Math.random() * pokeñonRandom.size()));
        aliado = personaje.getPokeñons().get((int)Math.round(Math.random() * (personaje.getPokeñons().size()-1)));
        ImageIcon iconoRival = new ImageIcon(pokeñonAleatorioRival.getUrl()); 
        ImageIcon iconoAliado = new ImageIcon(aliado.getUrlAliado());
        rival.setIcon(iconoRival); 
        miPokeñon.setIcon(iconoAliado);
        miSalud.setText(" " + aliado.getSalud());
        saludRival.setText(" " + pokeñonAleatorioRival.getSalud());
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
        EncuentraObjeto = new javax.swing.JDialog();
        objetoEncontrado = new javax.swing.JLabel();
        combateTerminado = new javax.swing.JDialog();
        mensajeCombate = new javax.swing.JLabel();
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
        IconoEntrenador = new javax.swing.JButton();
        irInventario = new javax.swing.JButton();
        mapa = new javax.swing.JLabel();
        pInventario = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        usar = new javax.swing.JButton();
        soltarObjeto = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        guardarPartida = new javax.swing.JButton();
        imagenPokeñon = new javax.swing.JLabel();
        imagenMochila = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaMochila = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        Filtro = new javax.swing.JComboBox<>();
        AscDesc = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        listaPoke = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        soltarPokeñon = new javax.swing.JButton();
        combate = new javax.swing.JPanel();
        miPokeñon = new javax.swing.JLabel();
        rival = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        hidrobomba = new javax.swing.JButton();
        latigocepa = new javax.swing.JButton();
        impactrueno = new javax.swing.JButton();
        placaje = new javax.swing.JButton();
        lanzallamas = new javax.swing.JButton();
        saludRival = new javax.swing.JLabel();
        miSalud = new javax.swing.JLabel();
        muestraAtaqueAliado = new javax.swing.JLabel();
        muestraAtaque = new javax.swing.JLabel();
        bPokeball = new javax.swing.JButton();
        bSuperball = new javax.swing.JButton();
        bUltraball = new javax.swing.JButton();

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

        javax.swing.GroupLayout EncuentraObjetoLayout = new javax.swing.GroupLayout(EncuentraObjeto.getContentPane());
        EncuentraObjeto.getContentPane().setLayout(EncuentraObjetoLayout);
        EncuentraObjetoLayout.setHorizontalGroup(
            EncuentraObjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EncuentraObjetoLayout.createSequentialGroup()
                .addGap(344, 344, 344)
                .addComponent(objetoEncontrado, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(368, Short.MAX_VALUE))
        );
        EncuentraObjetoLayout.setVerticalGroup(
            EncuentraObjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EncuentraObjetoLayout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(objetoEncontrado, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(167, Short.MAX_VALUE))
        );

        mensajeCombate.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        mensajeCombate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mensajeCombate.setText("Has perdido");
        mensajeCombate.setToolTipText("");

        javax.swing.GroupLayout combateTerminadoLayout = new javax.swing.GroupLayout(combateTerminado.getContentPane());
        combateTerminado.getContentPane().setLayout(combateTerminadoLayout);
        combateTerminadoLayout.setHorizontalGroup(
            combateTerminadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(combateTerminadoLayout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(mensajeCombate, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(157, Short.MAX_VALUE))
        );
        combateTerminadoLayout.setVerticalGroup(
            combateTerminadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(combateTerminadoLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(mensajeCombate, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(126, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pokeñon");
        setMinimumSize(new java.awt.Dimension(1080, 831));

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

        contenedor.addTab("Menú", pMenu);

        pSeleccion.setBackground(new java.awt.Color(255, 255, 255));
        pSeleccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pSeleccionMouseEntered(evt);
            }
        });
        pSeleccion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        pSeleccion.add(pikachu, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 191, -1, -1));

        volverAlMenu3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        volverAlMenu3.setText("VOLVER AL MENU");
        volverAlMenu3.setPreferredSize(new java.awt.Dimension(96, 23));
        volverAlMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverAlMenu3ActionPerformed(evt);
            }
        });
        pSeleccion.add(volverAlMenu3, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 646, 244, 66));

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
        pSeleccion.add(bulbasaur, new org.netbeans.lib.awtextra.AbsoluteConstraints(544, 191, 125, 131));

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
        pSeleccion.add(charmander, new org.netbeans.lib.awtextra.AbsoluteConstraints(774, 191, 125, 131));

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
        pSeleccion.add(squirtle, new org.netbeans.lib.awtextra.AbsoluteConstraints(994, 191, 125, 131));

        nPikachu.setBackground(new java.awt.Color(255, 255, 255));
        nPikachu.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        nPikachu.setText("PIKACHU");
        pSeleccion.add(nPikachu, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 349, -1, -1));

        nBulbasur.setBackground(new java.awt.Color(255, 255, 255));
        nBulbasur.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        nBulbasur.setText("BULBASAUR");
        pSeleccion.add(nBulbasur, new org.netbeans.lib.awtextra.AbsoluteConstraints(543, 349, -1, -1));

        nSquirtle.setBackground(new java.awt.Color(255, 255, 255));
        nSquirtle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        nSquirtle.setText("SQUIRTLE");
        nSquirtle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nSquirtleMouseClicked(evt);
            }
        });
        pSeleccion.add(nSquirtle, new org.netbeans.lib.awtextra.AbsoluteConstraints(1016, 349, -1, -1));

        nCharmander.setBackground(new java.awt.Color(255, 255, 255));
        nCharmander.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        nCharmander.setText("CHARMANDER");
        pSeleccion.add(nCharmander, new org.netbeans.lib.awtextra.AbsoluteConstraints(774, 349, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setText("Elige un Pokeñon");
        pSeleccion.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(633, 84, -1, 66));

        irJuego.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        irJuego.setText("CONTINUAR");
        irJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                irJuegoActionPerformed(evt);
            }
        });
        pSeleccion.add(irJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 640, 244, 66));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Nombre entrenador:");
        pSeleccion.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(591, 404, -1, -1));

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
        pSeleccion.add(insertarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(591, 437, 295, 58));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pSeleccion.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1506, 39, -1, -1));

        contenedor.addTab("Seleccionar", pSeleccion);

        pJuego.setPreferredSize(new java.awt.Dimension(2199, 860));
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

        irInventario.setBackground(new java.awt.Color(102, 102, 255));
        irInventario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        irInventario.setForeground(new java.awt.Color(255, 255, 255));
        irInventario.setText("INVENTARIO");
        irInventario.setFocusable(false);
        irInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                irInventarioActionPerformed(evt);
            }
        });

        mapa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mapa.jpg"))); // NOI18N
        mapa.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        mapa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mapaMouseClicked(evt);
            }
        });

        contenedorMapa.setLayer(IconoEntrenador, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contenedorMapa.setLayer(irInventario, javax.swing.JLayeredPane.DEFAULT_LAYER);
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

        usar.setText("Usar");
        usar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usarActionPerformed(evt);
            }
        });
        jPanel2.add(usar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 670, 80, -1));

        soltarObjeto.setText("Soltar");
        soltarObjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soltarObjetoActionPerformed(evt);
            }
        });
        jPanel2.add(soltarObjeto, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 670, 80, -1));

        jButton42.setText("Volver al juego");
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

        imagenPokeñon.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(imagenPokeñon, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 300, 150, 140));

        imagenMochila.setBackground(new java.awt.Color(255, 255, 255));
        imagenMochila.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/charmander.png"))); // NOI18N
        jPanel2.add(imagenMochila, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 300, 140, 140));

        listaMochila.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        listaMochila.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaMochila.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                listaMochilaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                listaMochilaFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(listaMochila);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 410, 490));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Pokeñon");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 50, 194, 60));

        Filtro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Filtro", "Nombre", "Tipo", "Fuerza asc", "Fuerza desc", "Salud asc", "Salud desc" }));
        Filtro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                FiltroFocusGained(evt);
            }
        });
        Filtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FiltroActionPerformed(evt);
            }
        });
        jPanel2.add(Filtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 90, -1, -1));

        AscDesc.setText("Ascendente");
        AscDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AscDescActionPerformed(evt);
            }
        });
        jPanel2.add(AscDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, -1, -1));

        listaPoke.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        listaPoke.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaPoke.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                listaPokeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                listaPokeFocusLost(evt);
            }
        });
        jScrollPane4.setViewportView(listaPoke);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 140, 410, 480));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nombre");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 120, 90, 20));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Tipo");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 120, 90, 20));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Fuerza");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 120, 90, 20));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Salud");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 120, 90, 20));

        soltarPokeñon.setText("Soltar");
        soltarPokeñon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soltarPokeñonActionPerformed(evt);
            }
        });
        jPanel2.add(soltarPokeñon, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 670, -1, -1));

        pInventario.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1490, 800));

        contenedor.addTab("Inventario", pInventario);

        combate.setBackground(new java.awt.Color(255, 255, 255));
        combate.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        combate.add(miPokeñon, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 610, 150, 90));
        combate.add(rival, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 110, 160, 133));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 70)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("VS");
        combate.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 390, 190, 62));

        hidrobomba.setBackground(new java.awt.Color(0, 204, 255));
        hidrobomba.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        hidrobomba.setText("HIDROBOMBA");
        hidrobomba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hidrobombaActionPerformed(evt);
            }
        });
        combate.add(hidrobomba, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 680, -1, -1));

        latigocepa.setBackground(new java.awt.Color(0, 204, 102));
        latigocepa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        latigocepa.setText("LATIGO CEPA");
        latigocepa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                latigocepaActionPerformed(evt);
            }
        });
        combate.add(latigocepa, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 680, -1, -1));

        impactrueno.setBackground(new java.awt.Color(255, 255, 0));
        impactrueno.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        impactrueno.setText("IMPACTRUENO");
        impactrueno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                impactruenoActionPerformed(evt);
            }
        });
        combate.add(impactrueno, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 680, -1, -1));

        placaje.setBackground(new java.awt.Color(204, 204, 204));
        placaje.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        placaje.setText("PLACAJE");
        placaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                placajeActionPerformed(evt);
            }
        });
        combate.add(placaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 680, 110, -1));

        lanzallamas.setBackground(new java.awt.Color(255, 51, 51));
        lanzallamas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lanzallamas.setText("LANZALLAMAS");
        lanzallamas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lanzallamasActionPerformed(evt);
            }
        });
        combate.add(lanzallamas, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 680, 122, -1));

        saludRival.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        saludRival.setText("vida rival");
        combate.add(saludRival, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 330, 105, 50));

        miSalud.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        miSalud.setText("mi vida");
        combate.add(miSalud, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 460, 105, 50));

        muestraAtaqueAliado.setBackground(new java.awt.Color(255, 255, 255));
        muestraAtaqueAliado.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        combate.add(muestraAtaqueAliado, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 580, 763, 37));

        muestraAtaque.setBackground(new java.awt.Color(255, 255, 255));
        muestraAtaque.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        combate.add(muestraAtaque, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 763, 37));

        bPokeball.setText("Pokeball");
        bPokeball.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPokeballActionPerformed(evt);
            }
        });
        combate.add(bPokeball, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, -1));

        bSuperball.setText("Superball");
        combate.add(bSuperball, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, -1, -1));

        bUltraball.setText("Ultraball");
        combate.add(bUltraball, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, -1, -1));

        contenedor.addTab("Pelea", combate);

        getContentPane().add(contenedor, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void urlDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urlDestinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_urlDestinoActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        try {
            Acciones.guardar(personaje, urlDestino.getText());
        } catch (IOException e) {
            dialogGuardar.dispose();
            error.setVisible(true);
            mensajeError.setText(e.getMessage());
            e.printStackTrace();
        }
        dialogGuardar.setVisible(false);
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
                IconoEntrenador.setIcon(arr);
                break;
            case KeyEvent.VK_DOWN:
                startMoving(0, 1);
                IconoEntrenador.setIcon(abj);
                break;
            case KeyEvent.VK_LEFT:
                startMoving(-1, 0);
                IconoEntrenador.setIcon(izq);
                break;
            case KeyEvent.VK_RIGHT:
                startMoving(1, 0);
                IconoEntrenador.setIcon(der);
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
        Acciones.AñadirPokemon(personaje, pokeñon.SQUIRTLE);
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
        Acciones.AñadirPokemon(personaje, pokeñon.CHARMANDER);
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
        Acciones.AñadirPokemon(personaje, pokeñon.BULBASAUR);
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
        Acciones.AñadirPokemon(personaje, pokeñon.PIKACHU);
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
        try {
            personaje = Acciones.cargar(cargarArchivo.getSelectedFile());
            cargarArchivo.setVisible(false);
            contenedor.setSelectedIndex(3);
            for (Pokeñon pokeñon1 : personaje.getPokeñons()) {
                System.out.println(pokeñon1);
            }
        } catch (IOException e) {
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
        } else if (!clip.isRunning()) {
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
        if (!insertarUsuario.getText().isBlank()) {
            personaje.setNombreUsuario(insertarUsuario.getText());
            contenedor.setSelectedIndex(3);
        }
    }//GEN-LAST:event_irJuegoActionPerformed

    private void irInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_irInventarioActionPerformed
        DefaultListModel modelMochila = new DefaultListModel();
        modelMochila.addAll(personaje.getObjetos());
        listaMochila.setModel(modelMochila);
        DefaultListModel modelPoke = new DefaultListModel();
        modelPoke.addAll(personaje.getPokeñons());
        listaPoke.setModel(modelPoke);
        contenedor.setSelectedIndex(4);
    }//GEN-LAST:event_irInventarioActionPerformed

    private void barraStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_barraStateChanged
        if (barra.getValue() == 99) {
            introducirAudio();
        }
    }//GEN-LAST:event_barraStateChanged

    private void guardarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarPartidaActionPerformed
        dialogGuardar.setVisible(true);
    }//GEN-LAST:event_guardarPartidaActionPerformed

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
        contenedor.setSelectedIndex(3);
    }//GEN-LAST:event_jButton42ActionPerformed

    private void soltarObjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soltarObjetoActionPerformed
        DefaultListModel listaObjetos = new DefaultListModel();
        if (listaMochila.getSelectedIndex() != -1) {
            personaje.getObjetos().remove(listaMochila.getSelectedIndex());
        }
        listaObjetos.addAll(personaje.getObjetos());
        listaMochila.setModel(listaObjetos);
        soltarObjeto.setEnabled(false);
    }//GEN-LAST:event_soltarObjetoActionPerformed

    private void usarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usarActionPerformed
        if(listaMochila.getSelectedIndex()!=-1){
            Objetos o = personaje.getObjetos().get(listaMochila.getSelectedIndex());
            soltarObjetoActionPerformed(null);
            if (o.getNombre() == "Poción") {
                if (listaPoke.getSelectedIndex() != -1) {
                    personaje.getPokeñons().get(listaPoke.getSelectedIndex())
                            .setSalud((personaje.getPokeñons().get(listaPoke.getSelectedIndex()).getSalud() + 20));
                    soltarObjetoActionPerformed(null);
                } else {
                    System.out.println("Introducir una ventana para mostrara error");
                }
            } else if (o.getNombre() == "Superpoción") {
                if (listaPoke.getSelectedIndex() != -1) {
                    personaje.getPokeñons().get(listaPoke.getSelectedIndex())
                            .setSalud((personaje.getPokeñons().get(listaPoke.getSelectedIndex()).getSalud() + 50));
                    soltarObjetoActionPerformed(null);
                } else {
                    System.out.println("Introducir una ventana para mostrara error");
                }
            } else if (o.getNombre() == "Maxpoción") {
                if (listaPoke.getSelectedIndex() != -1) {
                    personaje.getPokeñons().get(listaPoke.getSelectedIndex())
                            .setSalud(200);
                    soltarObjetoActionPerformed(null);
                } else {
                    System.out.println("Introducir una ventana para mostrara error");
                }
            } else if (o.getNombre() == "Potenciador de ataque") {
                if (listaPoke.getSelectedIndex() != -1) {
                    personaje.getPokeñons().get(listaPoke.getSelectedIndex())
                            .setFuerza((personaje.getPokeñons().get(listaPoke.getSelectedIndex()).getFuerza() * 1.5));
                    soltarObjetoActionPerformed(null);
                } else {
                    System.out.println("Introducir una ventana para mostrara error");
                }
            } else if (o.getNombre() == "Ticket de enfermería") {
                System.out.println("Va a la enfermería");
                soltarObjetoActionPerformed(null);
            }
        }
        
        DefaultListModel modelPoke = new DefaultListModel();
        modelPoke.addAll(personaje.getPokeñons());
        listaPoke.repaint();
    }//GEN-LAST:event_usarActionPerformed

    private void listaMochilaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_listaMochilaFocusGained
        ImageIcon icono = new ImageIcon(personaje.getObjetos().get(listaMochila.getSelectedIndex()).getUrl());
        imagenMochila.setIcon(icono);
        soltarObjeto.setEnabled(true);
    }//GEN-LAST:event_listaMochilaFocusGained

    private void listaMochilaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_listaMochilaFocusLost
        imagenMochila.setIcon(null);
    }//GEN-LAST:event_listaMochilaFocusLost

    private void FiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiltroActionPerformed
        if (Filtro.getSelectedIndex() == 1) {
            Collections.sort(personaje.getPokeñons(), Comparator.comparing(Pokeñon::getNombre));
        } else if (Filtro.getSelectedIndex() == 2) {
            Collections.sort(personaje.getPokeñons(), Comparator.comparing(Pokeñon::getTipo));
        } else if (Filtro.getSelectedIndex() == 3) {
            Collections.sort(personaje.getPokeñons(), Comparator.comparing(Pokeñon::getFuerza));
        } else if (Filtro.getSelectedIndex() == 4) {
            Collections.sort(personaje.getPokeñons(), Comparator.comparing(Pokeñon::getFuerza, Collections.reverseOrder()));
        } else if (Filtro.getSelectedIndex() == 5) {
            Collections.sort(personaje.getPokeñons(), Comparator.comparing(Pokeñon::getSalud));
        } else if (Filtro.getSelectedIndex() == 6) {
            Collections.sort(personaje.getPokeñons(), Comparator.comparing(Pokeñon::getSalud, Collections.reverseOrder()));
        }
        DefaultListModel modelPoke = new DefaultListModel();
        modelPoke.addAll(personaje.getPokeñons());
        listaPoke.setModel(modelPoke);
    }//GEN-LAST:event_FiltroActionPerformed

    private void AscDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AscDescActionPerformed
        if (AscDesc.getText() == "Ascendente") {
            Collections.sort(personaje.getObjetos(), Comparator.comparing(Objetos::getNombre));
            AscDesc.setText("Descendente");
            DefaultListModel modelMochila = new DefaultListModel();
            modelMochila.addAll(personaje.getObjetos());
            listaMochila.setModel(modelMochila);
        } else {
            Collections.sort(personaje.getObjetos(), Comparator.comparing(Objetos::getNombre, Collections.reverseOrder()));
            AscDesc.setText("Ascendente");
            DefaultListModel modelMochila = new DefaultListModel();
            modelMochila.addAll(personaje.getObjetos());
            listaMochila.setModel(modelMochila);
        }
    }//GEN-LAST:event_AscDescActionPerformed

    private void FiltroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FiltroFocusGained

    }//GEN-LAST:event_FiltroFocusGained

    private void listaPokeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_listaPokeFocusGained
        ImageIcon icono = new ImageIcon(personaje.getPokeñons().get(listaPoke.getSelectedIndex()).getUrl());
        imagenPokeñon.setIcon(icono);
        soltarPokeñon.setEnabled(true);
    }//GEN-LAST:event_listaPokeFocusGained

    private void listaPokeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_listaPokeFocusLost
        imagenPokeñon.setIcon(null);
    }//GEN-LAST:event_listaPokeFocusLost

    private void soltarPokeñonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soltarPokeñonActionPerformed
        DefaultListModel listaP = new DefaultListModel();
        if (listaPoke.getSelectedIndex() != -1) {
            personaje.getPokeñons().remove(listaPoke.getSelectedIndex());
        }
        listaP.addAll(personaje.getPokeñons());
        listaPoke.setModel(listaP);
        soltarPokeñon.setEnabled(false);
    }//GEN-LAST:event_soltarPokeñonActionPerformed

    private void placajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_placajeActionPerformed
        if(ataqueAliado(Ataques.GOLPE_NORMAL))return; 
        ataqueRival();
    }//GEN-LAST:event_placajeActionPerformed

    private void hidrobombaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hidrobombaActionPerformed
        if(ataqueAliado(Ataques.HIDROBOMBA))return; 
        ataqueRival();
    }//GEN-LAST:event_hidrobombaActionPerformed

    private void lanzallamasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lanzallamasActionPerformed
        if(ataqueAliado(Ataques.LANZALLAMAS))return; 
        ataqueRival();
    }//GEN-LAST:event_lanzallamasActionPerformed

    private void impactruenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_impactruenoActionPerformed
        if(ataqueAliado(Ataques.IMPACTRUENO))return; 
        ataqueRival();
    }//GEN-LAST:event_impactruenoActionPerformed

    private void latigocepaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_latigocepaActionPerformed
        if(ataqueAliado(Ataques.LATIGO_CEPA))return; 
        ataqueRival();
    }//GEN-LAST:event_latigocepaActionPerformed

    private void bPokeballActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPokeballActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bPokeballActionPerformed

    private boolean ataqueAliado(Ataques ataque) {
        muestraAtaqueAliado.setText("Has usado "+ ataque);
        disableButton();
        Acciones.atacar(ataque, pokeñonAleatorioRival, aliado);
        saludRival.setText("" + pokeñonAleatorioRival.getSalud());
        if (pokeñonAleatorioRival.getSalud()==0) {
            personaje.getPokeñons().add(pokeñonAleatorioRival);
            saludIsZero();
            pokeñonAleatorioRival.setSalud(70);
            return true;
        }
        return false;
    }
    public void ataqueRival(){
        timerCombate();
        List<Ataques> listaAtaque = new ArrayList();
        for (Ataques value : Ataques.values()) {
            listaAtaque.add(value);
        }
        int numeroAleatorio = (int)Math.round(Math.random()*(listaAtaque.size()-1));
        Acciones.atacar(listaAtaque.get(numeroAleatorio), aliado, pokeñonAleatorioRival);
        miSalud.setText("" + aliado.getSalud());
        if(aliado.getSalud()==0){
            saludIsZero();
            return;
        }
        muestraAtaque.setText(pokeñonAleatorioRival.getNombre() + " ha usado " + listaAtaque.get(numeroAleatorio));
        enableButton();    
    }

    public void enableButton() {
        placaje.setEnabled(true);
        hidrobomba.setEnabled(true);
        impactrueno.setEnabled(true);
        lanzallamas.setEnabled(true);
        latigocepa.setEnabled(true);
    }

    private void disableButton() {
        placaje.setEnabled(false);
        hidrobomba.setEnabled(false);
        impactrueno.setEnabled(false);
        lanzallamas.setEnabled(false);
        latigocepa.setEnabled(false);
    }

    private void saludIsZero() {
        muestraAtaqueAliado.setText("");
        if (aliado.getSalud()==0) {
            combateTerminado.setVisible(true);
            mensajeCombate.setText(pokeñonAleatorioRival.getNombre() + " te ha vencido");
        } else {
            muestraAtaque.setText("Has ganado");
            muestraAtaqueAliado.setText("Elige una Pokeball para capturar al Pokeñon");
            bPokeball.setVisible(true);
            bSuperball.setVisible(true);
            bUltraball.setVisible(true);
        }
        contenedor.setSelectedIndex(3);
        muestraAtaque.setText("");
        enableButton();
        aliado.setSalud(70);
        
    }
    
    public class Action implements ActionListener {

        int i = 0;

        public void actionPerformed(ActionEvent e) {
            barra.setValue(i);
            if (i < 100) {
                i++;
                porcentajeBarra.setText(i + "%");
            } else {
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
    public javax.swing.JButton AscDesc;
    public javax.swing.JDialog EncuentraObjeto;
    public javax.swing.JComboBox<String> Filtro;
    public javax.swing.JButton IconoEntrenador;
    public javax.swing.JButton bPokeball;
    public javax.swing.JButton bSuperball;
    public javax.swing.JButton bUltraball;
    public javax.swing.JProgressBar barra;
    public javax.swing.JButton bulbasaur;
    public javax.swing.JFileChooser cargarArchivo;
    public javax.swing.JButton cargarPartida;
    public javax.swing.JButton charmander;
    public javax.swing.JPanel combate;
    public javax.swing.JDialog combateTerminado;
    public javax.swing.JTabbedPane contenedor;
    public javax.swing.JLayeredPane contenedorMapa;
    public javax.swing.JDialog dialogGuardar;
    public javax.swing.JDialog error;
    public javax.swing.JButton guardarPartida;
    public javax.swing.JButton hidrobomba;
    public javax.swing.JLabel imagenMochila;
    public javax.swing.JLabel imagenPokeñon;
    public javax.swing.JButton impactrueno;
    public javax.swing.JPanel inicio;
    public javax.swing.JTextField insertarUsuario;
    public javax.swing.JButton irInventario;
    public javax.swing.JButton irJuego;
    public javax.swing.JButton jButton42;
    public javax.swing.JButton jButton9;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel11;
    public javax.swing.JLabel jLabel12;
    public javax.swing.JLabel jLabel14;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel7;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JSlider jSlider1;
    public javax.swing.JButton lanzallamas;
    public javax.swing.JButton latigocepa;
    public javax.swing.JList<String> listaMochila;
    public javax.swing.JList<String> listaPoke;
    public javax.swing.JLabel mapa;
    public javax.swing.JLabel mensajeCombate;
    public javax.swing.JLabel mensajeError;
    public javax.swing.JLabel miPokeñon;
    public javax.swing.JLabel miSalud;
    public javax.swing.JLabel muestraAtaque;
    public javax.swing.JLabel muestraAtaqueAliado;
    public javax.swing.JLabel nBulbasur;
    public javax.swing.JLabel nCharmander;
    public javax.swing.JLabel nPikachu;
    public javax.swing.JLabel nSquirtle;
    public javax.swing.JButton nuevaPartida;
    public javax.swing.JLabel objetoEncontrado;
    public javax.swing.JPanel pInventario;
    public javax.swing.JPanel pJuego;
    public javax.swing.JPanel pMenu;
    public javax.swing.JPanel pSeleccion;
    public javax.swing.JButton pikachu;
    public javax.swing.JButton placaje;
    public javax.swing.JLabel porcentajeBarra;
    public javax.swing.JLabel rival;
    public javax.swing.JLabel saludRival;
    public javax.swing.JButton save;
    public javax.swing.JButton soltarObjeto;
    public javax.swing.JButton soltarPokeñon;
    public javax.swing.JButton squirtle;
    public javax.swing.JTextField urlDestino;
    public javax.swing.JButton usar;
    public javax.swing.JButton volverAlMenu3;
    // End of variables declaration//GEN-END:variables
}
