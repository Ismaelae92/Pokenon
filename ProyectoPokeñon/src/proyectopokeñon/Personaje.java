package proyectopokeñon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Personaje implements Serializable {
    private List<Objetos> objetos;
    private List<Pokeñon> pokeñon;
    private String nombreUsuario;
    

    public Personaje(List<Objetos> objetos, List<Pokeñon> pokeñons,String nombre) {
        this.objetos = new ArrayList<Objetos>(16);
        this.pokeñon = new ArrayList<Pokeñon>(16);
        this.nombreUsuario = nombreUsuario;
    }
    
    public Personaje(List<Pokeñon> pokeñons,String nombre) {
        this.pokeñon = new ArrayList<Pokeñon>(16);
        this.nombreUsuario = nombre;
    }
    
    
    public Personaje() {
        
    }

    public List<Objetos> getObjetos() {
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
