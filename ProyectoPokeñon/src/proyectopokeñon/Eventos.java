/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectopokeñon;

import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.Timer;

/**
 *
 * @author Ismael
 */
public class Eventos extends Movimiento{
    
    private Clip clip;
    
    private void AshActionPerformed(java.awt.event.ActionEvent evt) {                                    
        contenedor.setSelectedIndex(3);
        pikachu.setVisible(true);
    }                                   

    private void MistyActionPerformed(java.awt.event.ActionEvent evt) {                                      
        contenedor.setSelectedIndex(3);
        pikachu.setVisible(false);
    }                                     

    private void volverAlMenu2ActionPerformed(java.awt.event.ActionEvent evt) {                                              
       contenedor.setSelectedIndex(0);
    }                                             

    private void BrookActionPerformed(java.awt.event.ActionEvent evt) {                                      
        contenedor.setSelectedIndex(3);
        pikachu.setVisible(false);
    }                                     

    private void pMenuMouseClicked(java.awt.event.MouseEvent evt) {                                   

    }                                  
//Controla el boton de audio
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if (clip.isRunning()) {
            clip.stop();
            jSlider1.setVisible(false);
            jButton9.setText("Reproducir");
        }else if(!clip.isRunning()){
            clip.start();
            jSlider1.setVisible(true);
            jButton9.setText("Detener");
        }
    }                                        

    private void jSlider1PropertyChange(java.beans.PropertyChangeEvent evt) {                                        

    }                                       
//Controla el slider de audio
    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {                                      
        float volume = (float) jSlider1.getValue() / 100.0f;
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        float dB = (float) (Math.log10(volume) * 35.0);
        gainControl.setValue(dB);
    }                                                                     

    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {                                      
        contenedor.setSelectedIndex(1);
    }                                     

    private void squirtleActionPerformed(java.awt.event.ActionEvent evt) {                                         
        contenedor.setSelectedIndex(4);
    }                                        

    private void squirtleMouseExited(java.awt.event.MouseEvent evt) {                                     
        nSquirtle.setForeground(Color.BLACK);
    }                                    

    private void squirtleMouseEntered(java.awt.event.MouseEvent evt) {                                      
        nSquirtle.setForeground(Color.CYAN);
    }                                     

    private void charmanderActionPerformed(java.awt.event.ActionEvent evt) {                                           
        contenedor.setSelectedIndex(4);
    }                                          

    private void charmanderMouseExited(java.awt.event.MouseEvent evt) {                                       
        nCharmander.setForeground(Color.BLACK);
    }                                      

    private void charmanderMouseEntered(java.awt.event.MouseEvent evt) {                                        
        nCharmander.setForeground(Color.RED);
    }                                       

    private void bulvasurActionPerformed(java.awt.event.ActionEvent evt) {                                         
        contenedor.setSelectedIndex(4);
    }                                        

    public void bulvasurMouseExited(java.awt.event.MouseEvent evt) {                                     
        nBulbasur.setForeground(Color.BLACK);
    }                                    

    public void bulvasurMouseEntered(java.awt.event.MouseEvent evt) {                                      
        nBulbasur.setForeground(Color.GREEN);
    }                                     

    public void volverAlMenu3ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        contenedor.setSelectedIndex(0);
    }                                             

    public void pikachuActionPerformed(java.awt.event.ActionEvent evt) {                                        
        contenedor.setSelectedIndex(4);
    }                                       

    public void pikachuMouseExited(java.awt.event.MouseEvent evt) {                                    
        nPikachu.setForeground(Color.BLACK);
    }                                   

    public void pikachuMouseEntered(java.awt.event.MouseEvent evt) {                                     
        nPikachu.setForeground(Color.YELLOW);
    }                                    

    public void barraComponentShown(java.awt.event.ComponentEvent evt) {                                     
        // TODO add your handling code here:
    }                                    

    public void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {                                     
        System.out.println("X " + evt.getX());
        System.out.println("Y " + evt.getY());
        
    }                                    

    public void IconoEntrenadorKeyPressed(java.awt.event.KeyEvent evt) {                                           
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
    }                                                   
}
