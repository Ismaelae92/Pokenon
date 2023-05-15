/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package proyectopokeñon;

/**
 *
 * @author Ismael
 */
public enum Ataques {
    LANZALLAMAS("Lanzallamas", 90, Tipo.FUEGO),
    HIDROBOMBA("Hidrobomba", 95, Tipo.AGUA),
    LATIGO_CEPA("Látigo Cepa", 80, Tipo.PLANTA),
    IMPACTRUENO("Impactrueno", 100, Tipo.ELECTRICO),
    GOLPE_NORMAL("Golpe Normal", 70, Tipo.NORMAL);

    private String nombre;
    private int fuerza;
    private Tipo tipo;

    Ataques(String nombre, int fuerza, Tipo tipo) {
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