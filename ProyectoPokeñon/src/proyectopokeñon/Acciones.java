/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectopokeñon;

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
    Pokeñon pokeñon;
    
    public void atacar(Ataques ataque, Pokeñon otroPokeñon) {
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
        if (pokeñon.getTipo() == ataque.getTipo()){
            efectividad *= 2.0;
        }
        if(pokeñon.getFuerza()>=otroPokeñon.getFuerza()){
            efectividad = efectividad * 1.3;
        } else {
            efectividad = efectividad * 0.75;
        }

        efectividad = (int) Math.round((efectividad * ataque.getFuerza() * pokeñon.getSalud() * 0.4) / 5.0);
        otroPokeñon.setSalud(otroPokeñon.getSalud() - efectividad);
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
}
