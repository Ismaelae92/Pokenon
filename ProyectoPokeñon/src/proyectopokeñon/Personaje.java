/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectopokeñon;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Ismael
 */
public class Personaje implements Serializable{
    private List<Objetos> objetos;
    private List<Pokeñon> pokeñons;
    private String nombreUsuario;

    public Personaje() {
        this.objetos = objetos;
        this.pokeñons = pokeñons;
        this.nombreUsuario = nombreUsuario;
    }

    public List<Objetos> getObjetos() {
        return objetos;
    }

    public void setObjetos(List<Objetos> objetos) {
        this.objetos = objetos;
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
