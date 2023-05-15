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
    BLASTOISE("Blastoise", Tipo.AGUA, 90, 150, ""),
    VENUSAUR("Venusaur", Tipo.PLANTA, 85, 130, ""),
    SQUIRTLE("Squirtle", Tipo.AGUA, 44, 48, ""),
    BULBASAUR("Bulbasaur", Tipo.PLANTA, 45, 49, "src\\imagenes\\bulbasur.png"),
    CHARMANDER("Charmander", Tipo.FUEGO, 39, 52, ""),
    GYARADOS("Gyarados", Tipo.AGUA, 95, 125, ""),
    JOLTEON("Jolteon", Tipo.ELECTRICO, 65, 110, ""),
    ARCANINE("Arcanine", Tipo.FUEGO, 90, 110, ""),
    LANTURN("Lanturn", Tipo.AGUA, 125, 85, ""),
    PIDGEOT("Pidgeot", Tipo.VOLADOR, 83, 95, ""),
    AMPHAROS("Ampharos", Tipo.ELECTRICO, 90, 110, ""),
    FEAROW("Fearow", Tipo.VOLADOR, 65, 90, ""),
    LUDICOLO("Ludicolo", Tipo.PLANTA, 80, 100, ""),
    SNORLAX("Snorlax", Tipo.NORMAL, 160, 110, ""),
    TOGEKISS("Togekiss", Tipo.VOLADOR, 85, 80, ""),
    JOLTIK("Joltik", Tipo.ELECTRICO, 50, 47, ""),
    EXEGGUTOR("Exeggutor", Tipo.PLANTA, 95, 125, ""),
    PYROAR("Pyroar", Tipo.FUEGO, 86, 68, ""),
    STARAPTOR("Staraptor", Tipo.VOLADOR, 85, 120, ""),
    SWELLOW("Swellow", Tipo.VOLADOR, 60, 85, ""),
    TALONFLAME("Talonflame", Tipo.VOLADOR, 78, 81, "");
    
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
    
    
    
}
