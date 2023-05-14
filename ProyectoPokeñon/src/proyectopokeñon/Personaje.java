package proyectopokeñon;

import java.io.Serializable;
import java.util.List;

public class Personaje implements Serializable {
    private List<Objeto> objetos;
    private List<Pokeñon> pokeñons;
    private String nombreUsuario;
    

    public Personaje(List<Objeto> objetos, List<Pokeñon> pokeñons,String nombre) {
        this.objetos = objetos;
        this.pokeñons = pokeñons;
    }
    
    public Personaje() {
        
    }

    public List<Objeto> getObjetos() {
        return objetos;
    }


    public List<Pokeñon> getPokeñons() {
        return pokeñons;
    }

    public void setPokeñons(List<Pokeñon> pokeñons) {
        this.pokeñons = pokeñons;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    
    
}
