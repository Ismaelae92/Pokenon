package proyectopoke�on;

import java.io.Serializable;
import java.util.List;

public class Personaje implements Serializable {
    private List<Objeto> objetos;
    private List<Poke�on> poke�ons;
    private String nombreUsuario;
    

    public Personaje(List<Objeto> objetos, List<Poke�on> poke�ons,String nombre) {
        this.objetos = objetos;
        this.poke�ons = poke�ons;
    }
    
    public Personaje() {
        
    }

    public List<Objeto> getObjetos() {
        return objetos;
    }


    public List<Poke�on> getPoke�ons() {
        return poke�ons;
    }

    public void setPoke�ons(List<Poke�on> poke�ons) {
        this.poke�ons = poke�ons;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    
    
}
