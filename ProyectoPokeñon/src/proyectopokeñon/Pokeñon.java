package proyectopokeñon;

import java.io.Serializable;

public class Pokeñon implements Serializable{
    
    private Ataque[] ataques;
    private String nombre;
    private Tipo tipo;
    private double salud;
    private double fuerza;
    private String url;

    public Pokeñon(int salud, String nombre, Tipo tipo, double fuerza) {
        this.salud=salud;
        this.nombre = nombre;
        this.tipo = tipo;
        this.fuerza = fuerza;
    }
    
    public Pokeñon() {
        
    }
    
    public Pokeñon(String nombre,Tipo tipo,String url) {
        this.tipo = tipo;
        this.nombre = nombre;
        salud=100;
        //Calcular fuerza y salud
        salud+=Math.random()*100;
        fuerza=Math.random()*100;
        this.url = url;
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

    public double getSalud() {
        return salud;
    }

    public void setSalud(double salud) {
        if (salud<0){
            salud=0;
        }
        this.salud = salud;
    }

    public double getFuerza() {
        return fuerza;
    }

    public void setFuerza(double fuerza) {
        this.fuerza = fuerza;
    }
    
    
    
    public void ataque(Pokeñon p,int n_ataque) {
        double damage = ataques[n_ataque].getDaño();
        if (ataques[n_ataque].getTipo()==tipo) {
            damage = damage * 1.5;
        }
        if (tipo==Tipo.AGUA && p.getTipo()==Tipo.FUEGO){
            damage = damage * 1.5;
        }
        if (tipo==Tipo.ELECTRICO && p.getTipo()==Tipo.AGUA){
            damage = damage * 1.5;
        }
        if (tipo==Tipo.FUEGO && p.getTipo()==Tipo.PLANTA){
            damage = damage * 1.5;
        }
        if (tipo==Tipo.PLANTA && p.getTipo()==Tipo.ELECTRICO){
            damage = damage * 1.5;
        }
        if(tipo==Tipo.AGUA && p.getTipo()==Tipo.PLANTA){
            damage = damage * 0.5;
        }
        if(tipo==Tipo.ELECTRICO && p.getTipo()==Tipo.PLANTA){
            damage = damage * 0.5;
        }
        if(tipo==Tipo.FUEGO && p.getTipo()==Tipo.AGUA){
            damage = damage * 0.5;
        }
        if(tipo==Tipo.PLANTA && p.getTipo()==Tipo.FUEGO){
            damage = damage * 0.5;
        }
        //ATAQUE
        if (ataques[n_ataque].getTipo()==Tipo.AGUA && p.getTipo()==Tipo.FUEGO){
            damage = damage * 2;
        }
        if (ataques[n_ataque].getTipo()==Tipo.ELECTRICO && p.getTipo()==Tipo.AGUA){
            damage = damage * 2;
        }
        if (ataques[n_ataque].getTipo()==Tipo.FUEGO && p.getTipo()==Tipo.PLANTA){
            damage = damage * 2;
        }
        if (ataques[n_ataque].getTipo()==Tipo.PLANTA && p.getTipo()==Tipo.ELECTRICO){
            damage = damage * 2;
        }
        if(ataques[n_ataque].getTipo()==Tipo.AGUA && p.getTipo()==Tipo.PLANTA){
            damage = damage * 0.5;
        }
        if(ataques[n_ataque].getTipo()==Tipo.ELECTRICO && p.getTipo()==Tipo.PLANTA){
            damage = damage * 0.5;
        }
        if(ataques[n_ataque].getTipo()==Tipo.FUEGO && p.getTipo()==Tipo.AGUA){
            damage = damage * 0.5;
        }
        if(ataques[n_ataque].getTipo()==Tipo.PLANTA && p.getTipo()==Tipo.FUEGO){
            damage = damage * 0.5;
        }
        if(fuerza>=p.getFuerza()){
            damage = damage * 1.3;
        } else {
            damage = damage * 0.75;
        }
        int critico = (int)Math.round(Math.random()*100);
        if(critico<=20){
            damage= damage * 1.5;
        }
        p.setSalud(p.getSalud()-damage);
    }

    @Override
    public String toString() {
        return nombre+" es de tipo " + tipo.toString();
    }
    
}
