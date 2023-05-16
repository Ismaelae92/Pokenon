/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package proyectopokeñon;

import java.util.Comparator;

/**
 *
 * @author Ismael
 */
public enum Objetos implements Comparator<Objetos>{
    POKEBALL("Pokeball", "Captura a un Pokémon",""),
    SUPERBALL("Superball", "Captura a un Pokémon más fácilmente",""),
    ULTRABALL("Ultraball", "Captura a un Pokémon con mayor facilidad",""),
    POCION("Poción", "Restaura 20 puntos de salud de un Pokémon",""),
    SUPERPOCION("Superpoción", "Restaura 50 puntos de salud de un Pokémon",""),
    MAXPOCION("Maxpoción", "Restaura todo los puntos de salud de un Pokémon",""),
    ATQ_PLUS("Potenciador de ataque", "Aumenta el ataque de un Pokémon en un 50%",""),
    DEF_PLUS("Potenciador de defensa", "Aumenta la defensa de un Pokémon en un 50%",""),
    TICKET_ENFERMERIA("Ticket de enfermería", "Restaura todos los puntos de salud de todos los Pokémon del equipo","");

    private String nombre;
    private String descripcion;
    private String url;

    Objetos(String nombre, String descripcion, String url) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public int compare(Objetos o1, Objetos o2) {
        return o1.getNombre().compareTo(o2.getNombre());
    }  
}
