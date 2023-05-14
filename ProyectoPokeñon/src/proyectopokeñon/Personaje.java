/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectopoke�on;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Ismael
 */
public class Personaje implements Serializable{
    private List<Objetos> objetos;
    private List<Poke�on> poke�ons;
    private String nombreUsuario;

    public Personaje() {
        this.objetos = objetos;
        this.poke�ons = poke�ons;
        this.nombreUsuario = nombreUsuario;
    }

    public List<Objetos> getObjetos() {
        return objetos;
    }

    public void setObjetos(List<Objetos> objetos) {
        this.objetos = objetos;
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
