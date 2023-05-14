
package proyectopoke�on;

public class Ataque {
    private double da�o;
    private Tipo tipo;
    private String nombre;

    public Ataque(double da�o, Tipo tipo, String nombre) {
        this.da�o = da�o;
        this.tipo = tipo;
        this.nombre = nombre;
    }
    
    public Ataque() {
        
    }

    public double getDa�o() {
        return da�o;
    }

    public void setDa�o(double da�o) {
        this.da�o = da�o;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}