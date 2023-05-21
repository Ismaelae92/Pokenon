/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package proyectopokeñon;

/**
 *
 * @author Ismael
 */
public enum Ataque {
    LANZALLAMAS("Lanzallamas", 35, Tipo.FUEGO),
    HIDROBOMBA("Hidrobomba", 45, Tipo.AGUA),
    LATIGO_CEPA("Látigo Cepa", 35, Tipo.PLANTA),
    IMPACTRUENO("Impactrueno", 50, Tipo.ELECTRICO),
    GOLPE_NORMAL("Golpe Normal", 25, Tipo.NORMAL);

    private String nombre;
    private int fuerza;
    private Tipo tipo;

    Ataque(String nombre, int fuerza, Tipo tipo) {
        this.nombre = nombre;
        this.fuerza = fuerza;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getFuerza() {
        return fuerza;
    }

    public Tipo getTipo() {
        return tipo;
    }
}