package proyectopoke�on;

import java.io.Serializable;

public class Poke�on implements Serializable{
    
    private Ataque[] ataques;
    private String nombre;
    private Tipo tipo;
    private int salud;

    public Poke�on(Ataque[] ataques, String nombre, Tipo tipo, int salud) {
        this.ataques = ataques;
        this.nombre = nombre;
        this.tipo = tipo;
        this.salud = salud;
    }
    
    public Poke�on() {
        
    }

    public Ataque[] getAtaques() {
        return ataques;
    }

    public void setAtaques(Ataque[] ataques) {
        this.ataques = ataques;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }
    
    
    public double ataque(Poke�on p,int n_ataque){
        double damage = ataques[n_ataque].getDa�o();
        if (ataques[n_ataque].getTipo()==tipo) {
            damage = damage * 2;
        }
        if (tipo==Tipo.AGUA && p.getTipo()==Tipo.FUEGO){
            if(n_ataque == 1){
                p.setSalud(p.getSalud() - 20); 
            }else if(n_ataque == 2){
                p.setSalud(salud -= 30);
            }
            p.setSalud(salud -= 20); 
        }
        if (tipo==Tipo.ELECTRICO && p.getTipo()==Tipo.AGUA){
            damage = damage * 2;
        }
        if (tipo==Tipo.FUEGO && p.getTipo()==Tipo.PLANTA){
            damage = damage * 2;
        }
        if (tipo==Tipo.PLANTA && p.getTipo()==Tipo.ELECTRICO){
            damage = damage * 2;
        }
        if(tipo==Tipo.AGUA && p.getTipo()==Tipo.PLANTA){
            damage = 0;
        }
        if(tipo==Tipo.ELECTRICO && p.getTipo()==Tipo.PLANTA){
            damage = 0;
        }
        if(tipo==Tipo.FUEGO && p.getTipo()==Tipo.AGUA){
            damage = 0;
        }
        if(tipo==Tipo.PLANTA && p.getTipo()==Tipo.FUEGO){
            damage = 0;
        }
        return damage;
    }
}
