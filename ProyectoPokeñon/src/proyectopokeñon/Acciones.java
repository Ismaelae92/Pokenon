/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectopoke�on;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 *
 * @author Ismael
 */
public class Acciones extends JFrame{
    
    Poke�on poke�on;
    
    public void atacar(Ataques ataque, Poke�on otroPoke�on) {
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
        if (poke�on.getTipo() == ataque.getTipo()){
            efectividad *= 2.0;
        }
        if(poke�on.getFuerza()>=otroPoke�on.getFuerza()){
            efectividad = efectividad * 1.3;
        } else {
            efectividad = efectividad * 0.75;
        }

        efectividad = (int) Math.round((efectividad * ataque.getFuerza() * poke�on.getSalud() * 0.4) / 5.0);
        otroPoke�on.setSalud(otroPoke�on.getSalud() - efectividad);
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
}
