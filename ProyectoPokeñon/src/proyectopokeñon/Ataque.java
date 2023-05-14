
package proyectopokeñon;

public class Ataque {
    private double daño;
    private Tipo tipo;
    private String nombre;

    public Ataque(double daño, Tipo tipo, String nombre) {
        this.daño = daño;
        this.tipo = tipo;
        this.nombre = nombre;
    }
    
    public Ataque() {
        
    }

    public double getDaño() {
        return daño;
    }

    public void setDaño(double daño) {
        this.daño = daño;
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