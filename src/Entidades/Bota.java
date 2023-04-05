package Entidades;

/**
 * @author ClaudioDuran
 */
public class Bota {

    private final int consumo;
    private boolean danio;
    private boolean propulsor;
    private boolean salud;

    public Bota() {
        this.consumo = 200; //por Km caminado, el doble para correr, el triple para volar
        this.danio = false;
        this.propulsor = true;
        this.salud = true;
    }

    public boolean isSalud() {
        return salud;
    }

    public void setSalud(boolean salud) {
        this.salud = salud;
    }

    public Bota(int consumo, boolean danio, boolean propulsor) {
        this.consumo = consumo;
        this.danio = danio;
        this.propulsor = propulsor;
    }

    public int getConsumo() {
        return consumo;
    }

    public boolean isDanio() {
        return danio;
    }

    public boolean isPropulsor() {
        return propulsor;
    }

    public void setDanio(boolean danio) {
        this.danio = danio;
    }

    public void setPropulsor(boolean propulsor) {
        this.propulsor = propulsor;
    }
}
