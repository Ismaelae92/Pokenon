/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectopokeñon;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 *
 * @author Ismael
 */
public class Juego {
    
    public static void guardar(List<Pokeñon> listaPokeñon, String archivo) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo));
            out.writeObject(listaPokeñon);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Pokeñon> cargar(String archivo) {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo));
            List<Pokeñon> pokemonList = (List<Pokeñon>) in.readObject();
            in.close();
            return pokemonList;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
