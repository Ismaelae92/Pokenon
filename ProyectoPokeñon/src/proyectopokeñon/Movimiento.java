/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectopokeñon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.swing.Timer;

/**
 *
 * @author Ismael
 */
public class Movimiento  extends JFrame{
    
    JFrame jframe;
    private int x, y;
    private Timer timer;
    private int moveAmount = 5;
    int limiteX ;
    int limiteY;
    
     public void setVisible(boolean b) {
        super.setVisible(b);
        if (b) {
            limiteX = jframe.jLabel9.getWidth() - jframe.IconoEntrenador.getWidth();
            limiteY = jframe.jLabel9.getHeight() - jframe.IconoEntrenador.getHeight();
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
        x = jframe.IconoEntrenador.getX() + dx;
        y = jframe.IconoEntrenador.getY() + dy;
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
        jframe.contenedor.setSelectedIndex(6);

    }
        jframe.IconoEntrenador.setLocation(x, y);
    }
}
