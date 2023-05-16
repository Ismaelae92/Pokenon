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
public enum Pokeñon {
    PIKACHU("Pikachu", Tipo.ELECTRICO, 50, 100, "src\\imagenes\\bulbasur.png"),
    CHARIZARD("Charizard", Tipo.FUEGO, 80, 120, "src\\imagenes\\bulbasur.png"),
    BLASTOISE("Blastoise", Tipo.AGUA, 90, 150, "src\\imagenes\\bulbasur.png"),
    VENUSAUR("Venusaur", Tipo.PLANTA, 85, 130, "src\\imagenes\\bulbasur.png"),
    SQUIRTLE("Squirtle", Tipo.AGUA, 44, 48, "src\\imagenes\\bulbasur.png"),
    BULBASAUR("Bulbasaur", Tipo.PLANTA, 45, 49, "src\\imagenes\\bulbasur.png"),
    CHARMANDER("Charmander", Tipo.FUEGO, 39, 52, "src\\imagenes\\bulbasur.png"),
    GYARADOS("Gyarados", Tipo.AGUA, 95, 125, "src\\imagenes\\bulbasur.png"),
    JOLTEON("Jolteon", Tipo.ELECTRICO, 65, 110, "src\\imagenes\\bulbasur.png"),
    ARCANINE("Arcanine", Tipo.FUEGO, 90, 110, "src\\imagenes\\bulbasur.png"),
    LANTURN("Lanturn", Tipo.AGUA, 125, 85, "src\\imagenes\\bulbasur.png"),
    PIDGEOT("Pidgeot", Tipo.VOLADOR, 83, 95, "src\\imagenes\\bulbasur.png"),
    AMPHAROS("Ampharos", Tipo.ELECTRICO, 90, 110, "src\\imagenes\\bulbasur.png"),
    FEAROW("Fearow", Tipo.VOLADOR, 65, 90, "src\\imagenes\\bulbasur.png"),
    LUDICOLO("Ludicolo", Tipo.PLANTA, 80, 100, "src\\imagenes\\bulbasur.png"),
    SNORLAX("Snorlax", Tipo.NORMAL, 160, 110, "src\\imagenes\\bulbasur.png"),
    TOGEKISS("Togekiss", Tipo.VOLADOR, 85, 80, "src\\imagenes\\bulbasur.png"),
    JOLTIK("Joltik", Tipo.ELECTRICO, 50, 47, "src\\imagenes\\bulbasur.png"),
    EXEGGUTOR("Exeggutor", Tipo.PLANTA, 95, 125, "src\\imagenes\\bulbasur.png"),
    PYROAR("Pyroar", Tipo.FUEGO, 86, 68, "src\\imagenes\\bulbasur.png"),
    STARAPTOR("Staraptor", Tipo.VOLADOR, 85, 120, "src\\imagenes\\bulbasur.png"),
    SWELLOW("Swellow", Tipo.VOLADOR, 60, 85, "src\\imagenes\\bulbasur.png"),
    TALONFLAME("Talonflame", Tipo.VOLADOR, 78, 81, "src\\imagenes\\bulbasur.png");
    
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

    public String getUrl() {
        return url;
    } 

    @Override
    public String toString() {
        return  nombre + ":         " + tipo + ":         " + fuerza + ":         " + salud;
    }
    
    
}
