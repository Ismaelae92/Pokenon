/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectopoke�on;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.Timer;


/**
 *
 * @author Ismael
 */
public class Acciones extends JFrame {
    
    Poke�on poke�on;
    Personaje personaje;
    int x;
    int y;
    
    public static void atacar(Ataques ataque, Poke�on otroPoke�on,Poke�on miPoke�on) {
        double efectividad = 1.0;
        Tipo tipoAtaque = ataque.getTipo();
        Tipo tipoObjetivo = otroPoke�on.getTipo();

        if (tipoAtaque == Tipo.FUEGO && tipoObjetivo == Tipo.PLANTA) {
            efectividad = 2.0;
        } else if (tipoAtaque == Tipo.AGUA && tipoObjetivo == Tipo.FUEGO) {
            efectividad = 2.0;
        } else if (tipoAtaque == Tipo.PLANTA && tipoObjetivo == Tipo.AGUA) {
            efectividad = 2.0;
        } else if (tipoAtaque == Tipo.ELECTRICO && tipoObjetivo == Tipo.AGUA) {
            efectividad = 2.0;
        } else if (tipoAtaque == Tipo.ELECTRICO && tipoObjetivo == Tipo.VOLADOR) {
            efectividad = 2.0;
        } else if (tipoAtaque == Tipo.NORMAL) {
            efectividad = 1.0;
        } else {
            efectividad = 0.5;
        }
        if (miPoke�on.getTipo() == ataque.getTipo()){
            efectividad *= 1.5;
        }
        if(miPoke�on.getFuerza()>=otroPoke�on.getFuerza()){
            efectividad = efectividad * 1.3;
        } else {
            efectividad = efectividad * 0.75;
        }

        efectividad = (int) Math.round(ataque.getFuerza()*efectividad);
        otroPoke�on.setSalud(otroPoke�on.getSalud() - efectividad / 2);
    }
    
    // Guarda la informaci�n del personaje en un archivo binario
    public static void guardar(Personaje personaje, String url) throws IOException {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(url));
            out.writeObject(personaje);
            out.close();
    }

    // Carga la informaci�n del personaje desde un archivo binario
    public static Personaje cargar(File archivo) throws FileNotFoundException, IOException, ClassNotFoundException {
        Personaje partida = null;
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo));
        partida = (Personaje) in.readObject();
        in.close();
        return partida;
    }
    
    public static void A�adirPokemon(Personaje personaje, Poke�on poke�on){
        if(personaje.getPoke�ons().size() < 16){
            personaje.getPoke�ons().add(poke�on);    
        }
    }
    
    public static void SoltarPokemon(Personaje personaje, int indice){
        personaje.getPoke�ons().remove(indice);
    }
    
    public static void A�adirObjetos(Personaje personaje, Objetos objeto){
        if(personaje.getObjetos().size() < 16){
            personaje.getObjetos().add(objeto);    
        }
    }
    
    public static void SoltarObjetos(Personaje personaje, int indice){
        personaje.getObjetos().remove(indice);
    }
    
    public static Personaje cargar(String archivo) throws FileNotFoundException, IOException, ClassNotFoundException {
        Personaje partida = null;
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo));
        partida = (Personaje) in.readObject();
        in.close();
        return partida;
    }
}
