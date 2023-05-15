/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package proyectopokeñon;

/**
 *
 * @author Ismael
 */
public enum Pokeñon {
    PIKACHU("Pikachu", Tipo.ELECTRICO, 50, 100, "dddd"),
    CHARIZARD("Charizard", Tipo.FUEGO, 80, 120, ""),
    BLASTOISE("Blastoise", Tipo.AGUA, 90, 150,""),
    VENUSAUR("Venusaur", Tipo.PLANTA, 85, 130,"");

    private String nombre;
    private Tipo tipo;
    private double fuerza;
    private double salud;
    private String url;

    Pokeñon(String nombre, Tipo tipo, int fuerza, int salud, String url) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.fuerza = fuerza;
        this.salud = 100;
        this.url = url;
    }

    public String getNombre() {
        return nombre;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public double getFuerza() {
        return fuerza;
    }

    public double getSalud() {
        return salud;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public void setSalud(double salud) {
        this.salud = salud;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
}
