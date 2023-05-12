package proyectopokeñon;

public class Ataque {
    // Atributos
    private tipo type;
    private double danno;
    private String name;
    
    // Métodos y constructores

    public Ataque(tipo type, double danno, String name) {
        this.type = type;
        this.danno = danno;
        this.name = name;
    }
    public Ataque(tipo type, double danno) {
        this(type,danno,"Ataque Desconocido");
    }
    public tipo getType() {
        return type;
    }

    public void setType(tipo type) {
        this.type = type;
    }

    public double getDanno() {
        return danno;
    }

    public void setDanno(double danno) {
        if(danno<=0){
            danno=1;
        }
        this.danno = danno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        
        this.name = name;
    }
    
    
}
