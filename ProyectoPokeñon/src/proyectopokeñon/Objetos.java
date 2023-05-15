/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package proyectopoke�on;

/**
 *
 * @author Ismael
 */
public enum Objetos {
    POKEBALL("Pokeball", "Captura a un Pok�mon"),
    SUPERBALL("Superball", "Captura a un Pok�mon m�s f�cilmente"),
    ULTRABALL("Ultraball", "Captura a un Pok�mon con mayor facilidad"),
    POCION("Poci�n", "Restaura 20 puntos de salud de un Pok�mon"),
    SUPERPOCION("Superpoci�n", "Restaura 50 puntos de salud de un Pok�mon"),
    MAXPOCION("Maxpoci�n", "Restaura todo los puntos de salud de un Pok�mon"),
    ATQ_PLUS("Potenciador de ataque", "Aumenta el ataque de un Pok�mon en un 50%"),
    DEF_PLUS("Potenciador de defensa", "Aumenta la defensa de un Pok�mon en un 50%"),
    TICKET_ENFERMERIA("Ticket de enfermer�a", "Restaura todos los puntos de salud de todos los Pok�mon del equipo");

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
