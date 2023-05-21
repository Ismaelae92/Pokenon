/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package proyectopokeñon;

import java.io.Serializable;
import java.util.Comparator;

/**
 *
 * @author Ismael
 */
public enum Pokeñon implements Serializable {
    PIKACHU("Pikachu", Tipo.ELECTRICO, 50, 100, "src\\imagenes\\bulbasur.png", "src\\imagenes\\bulbasur2.png"),
    CHARIZARD("Charizard", Tipo.FUEGO, 80, 120, "src\\imagenes\\bulbasur.png", "src\\imagenes\\bulbasur2.png"),
    BLASTOISE("Blastoise", Tipo.AGUA, 90, 150, "src\\imagenes\\bulbasur.png", "src\\imagenes\\bulbasur2.png"),
    VENUSAUR("Venusaur", Tipo.PLANTA, 85, 130, "src\\imagenes\\bulbasur.png", "src\\imagenes\\bulbasur2.png"),
    SQUIRTLE("Squirtle", Tipo.AGUA, 44, 48, "src\\imagenes\\bulbasur.png", "src\\imagenes\\bulbasur2.png"),
    BULBASAUR("Bulbasaur", Tipo.PLANTA, 45, 49, "src\\imagenes\\bulbasur.png", "src\\imagenes\\bulbasur2.png"),
    CHARMANDER("Charmander", Tipo.FUEGO, 39, 52, "src\\imagenes\\bulbasur.png", "src\\imagenes\\bulbasur2.png"),
    GYARADOS("Gyarados", Tipo.AGUA, 95, 125, "src\\imagenes\\bulbasur.png", "src\\imagenes\\bulbasur2.png"),
    JOLTEON("Jolteon", Tipo.ELECTRICO, 65, 110, "src\\imagenes\\bulbasur.png", "src\\imagenes\\bulbasur2.png"),
    ARCANINE("Arcanine", Tipo.FUEGO, 90, 110, "src\\imagenes\\bulbasur.png", "src\\imagenes\\bulbasur2.png"),
    LANTURN("Lanturn", Tipo.AGUA, 125, 85, "src\\imagenes\\bulbasur.png", "src\\imagenes\\bulbasur2.png"),
    PIDGEOT("Pidgeot", Tipo.VOLADOR, 83, 95, "src\\imagenes\\bulbasur.png", "src\\imagenes\\bulbasur2.png");
    
    private static final int saludMax = 200; 
    private String nombre;
    private Tipo tipo;
    private double fuerza;
    private double salud;
    private String url;
    private String urlAliado;

    Pokeñon(String nombre, Tipo tipo, int fuerza, int salud, String url, String urlAliado) {
        if(salud>saludMax){
            salud=saludMax;
        } else if (salud<0){
            salud=0;
        } 
        this.nombre = nombre;
        this.tipo = tipo;
        this.fuerza = fuerza;
        this.salud = salud;
        this.url = url;
        this.urlAliado = urlAliado;
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

    public void setFuerza(double fuerza) {
        if(fuerza<=0){
            fuerza=1;
        }
        this.fuerza = fuerza;
    }

    public void setSalud(double salud) {
        if(salud>saludMax){
            salud=saludMax;
        } else if (salud<0){
            salud=0;
        } 
        this.salud = salud;
    }

    public String getUrl() {
        return url;
    } 

    public String getUrlAliado() {
        return urlAliado;
    }

    @Override
    public String toString() {
        return  nombre + "; Tipo: " + tipo + "; Fuerza: " + fuerza + "; Salud: " + salud;
    }
    
    
}
