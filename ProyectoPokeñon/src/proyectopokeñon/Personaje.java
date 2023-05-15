package proyectopoke�on;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Personaje implements Serializable {
    private List<Objetos> objetos;
    private List<Poke�on> poke�on;
    private String nombreUsuario;
    

    public Personaje(List<Objetos> objetos, List<Poke�on> poke�ons,String nombre) {
        this.objetos = new ArrayList<Objetos>(16);
        this.poke�on = new ArrayList<Poke�on>(16);
        this.nombreUsuario = nombreUsuario;
    }
    
    public Personaje(List<Poke�on> poke�ons,String nombre) {
        this.poke�on = new ArrayList<Poke�on>(16);
        this.nombreUsuario = nombre;
    }
    
    
    public Personaje() {
        
    }

    public List<Objetos> getObjetos() {
        return objetos;
    }


    public List<Poke�on> getPoke�ons() {
        return poke�on;
    }

    public void setPoke�ons(List<Poke�on> poke�ons) {
        this.poke�on = poke�ons;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    
    
}
