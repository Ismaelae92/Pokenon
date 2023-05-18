/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectopokeñon;

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
    
    Pokeñon pokeñon;
    Personaje personaje;
    int x;
    int y;
    
    public static void atacar(Ataques ataque, Pokeñon otroPokeñon,Pokeñon miPokeñon) {
        double efectividad = 1.0;
        Tipo tipoAtaque = ataque.getTipo();
        Tipo tipoObjetivo = otroPokeñon.getTipo();

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
        if (miPokeñon.getTipo() == ataque.getTipo()){
            efectividad *= 1.5;
        }
        if(miPokeñon.getFuerza()>=otroPokeñon.getFuerza()){
            efectividad = efectividad * 1.3;
        } else {
            efectividad = efectividad * 0.75;
        }

        efectividad = (int) Math.round(ataque.getFuerza()*efectividad);
        otroPokeñon.setSalud(otroPokeñon.getSalud() - efectividad / 2);
    }
    
    // Guarda la información del personaje en un archivo binario
    public static void guardar(Personaje personaje, String url) throws IOException {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(url));
            out.writeObject(personaje);
            out.close();
    }

    // Carga la información del personaje desde un archivo binario
    public static Personaje cargar(File archivo) throws FileNotFoundException, IOException, ClassNotFoundException {
        Personaje partida = null;
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo));
        partida = (Personaje) in.readObject();
        in.close();
        return partida;
    }
    
    public static void AñadirPokemon(Personaje personaje, Pokeñon pokeñon){
        if(personaje.getPokeñons().size() < 16){
            personaje.getPokeñons().add(pokeñon);    
        }
    }
    
    public static void SoltarPokemon(Personaje personaje, int indice){
        personaje.getPokeñons().remove(indice);
    }
    
    public static void AñadirObjetos(Personaje personaje, Objetos objeto){
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
