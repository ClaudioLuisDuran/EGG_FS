package Entidades;

/**
 * @author ClaudioDuran
 */
public class Armadura {

    public final String colorPrimario;
    public final String colorSecundario;
    public int energiaTotal;
    public int resistencia;
    public int salud;
    public Guante g1, g2;
    public Bota b1, b2;
    public Casco c;

    public Armadura() {
        this.colorPrimario = "Amarillo";
        this.colorSecundario = "Rojo";
        this.energiaTotal = 1000000;
        this.resistencia = 100;
        this.salud = 100;
    }

    public Guante getG1() {
        return g1;
    }

    public void setG1(Guante g1) {
        this.g1 = g1;
    }

    public Guante getG2() {
        return g2;
    }

    public void setG2(Guante g2) {
        this.g2 = g2;
    }

    public Bota getB1() {
        return b1;
    }

    public void setB1(Bota b1) {
        this.b1 = b1;
    }

    public Bota getB2() {
        return b2;
    }

    public void setB2(Bota b2) {
        this.b2 = b2;
    }

    public Casco getC() {
        return c;
    }

    public void setC(Casco c) {
        this.c = c;
    }

    public String getColorPrimario() {
        return colorPrimario;
    }

    public String getColorSecundario() {
        return colorSecundario;
    }

    public int getEnergiaTotal() {
        return energiaTotal;
    }

    public void setEnergiaTotal(int energiaTotal) {
        this.energiaTotal = energiaTotal;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public void bateria() {
        if (this.getEnergiaTotal() == 1000000) {
            System.out.println("     Batería: 100%");
        } else {
            System.out.println("     Batería: " + (this.getEnergiaTotal() * 100 / 1000000) + "%");
        }
    }

}
