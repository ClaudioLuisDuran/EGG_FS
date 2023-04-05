package Entidades;

/**
 * @author ClaudioDuran
 */
public class Casco {

    private final int consumo;
    private boolean danio;
    private int consumoConsola;
    private int consumoSintetizador;
    private boolean salud;

    public Casco() {
        this.consumo = 200;
        this.danio = false;
        this.consumoConsola = 20;
        this.consumoSintetizador = 20;
        this.salud = true;
    }

    public Casco(int consumo, boolean danio, int consumoConsola, int consumoSintetizador, boolean salud) {
        this.consumo = consumo;
        this.danio = danio;
        this.consumoConsola = consumoConsola;
        this.consumoSintetizador = consumoSintetizador;
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

    public void setDanio(boolean danio) {
        this.danio = danio;
    }

    public int getConsumoConsola() {
        return consumoConsola;
    }

    public void setConsumoConsola(int consumoConsola) {
        this.consumoConsola = consumoConsola;
    }

    public int getConsumoSintetizador() {
        return consumoSintetizador;
    }

    public void setConsumoSintetizador(int consumoSintetizador) {
        this.consumoSintetizador = consumoSintetizador;
    }
}
