/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package proyectopoke�on;

import java.util.Comparator;

/**
 *
 * @author Ismael
 */
public enum Objetos implements Comparator<Objetos>{
    POKEBALL("Pokeball", "Captura a un Pok�mon","src\\imagenes\\squirtle.png"),
    SUPERBALL("Superball", "Captura a un Pok�mon m�s f�cilmente","src\\imagenes\\squirtle.png"),
    ULTRABALL("Ultraball", "Captura a un Pok�mon con mayor facilidad","src\\imagenes\\squirtle.png"),
    POCION("Poci�n", "Restaura 20 puntos de salud de un Pok�mon","src\\imagenes\\squirtle.png"),
    SUPERPOCION("Superpoci�n", "Restaura 50 puntos de salud de un Pok�mon","src\\imagenes\\squirtle.png"),
    MAXPOCION("Maxpoci�n", "Restaura todo los puntos de salud de un Pok�mon","\\src\\imagenes\\squirtle.png"),
    POTENCIADOR_ATQ("Potenciador de ataque", "Aumenta el ataque de un Pok�mon en un 50%","src\\imagenes\\squirtle.png"),
    POTECIADOR_DEF("Potenciador de defensa", "Aumenta la defensa de un Pok�mon en un 50%","src\\imagenes\\squirtle.png"),
    TICKET_ENFERMERIA("Ticket de enfermer�a", "Restaura todos los puntos de salud de todos los Pok�mon del equipo","src\\imagenes\\squirtle.png");

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
