package Entidades;

/**
 * @author ClaudioDuran
 */
public class Guante {

    private final int consumo;
    private boolean danio;
    private boolean repulsor;
    private boolean salud;

    public Guante() {
        this.consumo = 200;//el doble para volar
        this.danio = false;
        this.repulsor = true;
        this.salud = true;
    }

    public Guante(int consumo, boolean danio, boolean repulsor, boolean salud) {
        this.consumo = consumo;
        this.danio = danio;
        this.repulsor = repulsor;
        this.salud = salud;

    }

    public boolean isSalud() {
        return salud;
    }

    public void setSalud(boolean salud) {
        this.salud = salud;
    }

    public int getConsumo() {
        return consumo;
    }

    public boolean isDanio() {
        return danio;
    }

    public boolean isRepulsor() {
        return repulsor;
    }

    public void setDanio(boolean danio) {
        this.danio = danio;
    }

    public void setRepulsorr(boolean repulsor) {
        this.repulsor = repulsor;
    }
}
