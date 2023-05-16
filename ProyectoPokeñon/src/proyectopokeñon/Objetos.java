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
    POKEBALL("Pokeball", "Captura a un Pokémon","src\\imagenes\\squirtle.png"),
    SUPERBALL("Superball", "Captura a un Pokémon más fácilmente","src\\imagenes\\squirtle.png"),
    ULTRABALL("Ultraball", "Captura a un Pokémon con mayor facilidad","src\\imagenes\\squirtle.png"),
    POCION("Poción", "Restaura 20 puntos de salud de un Pokémon","src\\imagenes\\squirtle.png"),
    SUPERPOCION("Superpoción", "Restaura 50 puntos de salud de un Pokémon","src\\imagenes\\squirtle.png"),
    MAXPOCION("Maxpoción", "Restaura todo los puntos de salud de un Pokémon","\\src\\imagenes\\squirtle.png"),
    POTENCIADOR_ATQ("Potenciador de ataque", "Aumenta el ataque de un Pokémon en un 50%","src\\imagenes\\squirtle.png"),
    POTECIADOR_DEF("Potenciador de defensa", "Aumenta la defensa de un Pokémon en un 50%","src\\imagenes\\squirtle.png"),
    TICKET_ENFERMERIA("Ticket de enfermería", "Restaura todos los puntos de salud de todos los Pokémon del equipo","src\\imagenes\\squirtle.png");

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
       return o1.getNombre().compareToIgnoreCase(o2.getNombre());
    }

    

}
