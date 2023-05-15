/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package proyectopokeñon;

/**
 *
 * @author Ismael
 */
public enum Objetos {
    POKEBALL("Pokeball", "Captura a un Pokémon"),
    SUPERBALL("Superball", "Captura a un Pokémon más fácilmente"),
    ULTRABALL("Ultraball", "Captura a un Pokémon con mayor facilidad"),
    POCION("Poción", "Restaura 20 puntos de salud de un Pokémon"),
    SUPERPOCION("Superpoción", "Restaura 50 puntos de salud de un Pokémon"),
    MAXPOCION("Maxpoción", "Restaura todo los puntos de salud de un Pokémon"),
    ATQ_PLUS("Potenciador de ataque", "Aumenta el ataque de un Pokémon en un 50%"),
    DEF_PLUS("Potenciador de defensa", "Aumenta la defensa de un Pokémon en un 50%"),
    TICKET_ENFERMERIA("Ticket de enfermería", "Restaura todos los puntos de salud de todos los Pokémon del equipo");

    private String nombre;
    private String descripcion;
    private int valor;

    Objetos(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getValor() {
        return valor;
    }
    
    
}
