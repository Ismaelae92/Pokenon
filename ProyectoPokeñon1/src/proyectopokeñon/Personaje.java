package proyectopokeñon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Personaje implements Serializable {
    private List<Objeto> objetos;
    private List<Pokeñon> pokeñon;
    private String nombreUsuario;
    

    public Personaje(List<Objeto> objetos, List<Pokeñon> pokeñons,String nombre) {
        this.objetos = new ArrayList<Objeto>();
        this.pokeñon = new ArrayList<Pokeñon>();
        this.nombreUsuario = nombreUsuario;
    }
    
    public Personaje(List<Pokeñon> pokeñons) {
        this.pokeñon = new ArrayList<Pokeñon>(16);
    }
    
    public Personaje(String nombre) {
        this.nombreUsuario = nombre;
    }
    
    public Personaje() {
        objetos = new ArrayList<Objeto>();
        pokeñon = new ArrayList<Pokeñon>();
    }

    public List<Objeto> getObjetos() {
        return objetos;
    }


    public List<Pokeñon> getPokeñons() {
        return pokeñon;
    }

    public void setPokeñons(List<Pokeñon> pokeñons) {
        this.pokeñon = pokeñons;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    
    
}
