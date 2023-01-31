package Entidades;

/**
 * @author ClaudioDuran
 */
public class Asiento {

    private int fila;
    private char columna;
    private char ocupado;

    public Asiento() {
    }

    public Asiento(int fila, char columna, char ocupado) {
        this.fila = fila;
        this.columna = columna;
        this.ocupado = ocupado;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public char getColumna() {
        return columna;
    }

    public void setColumna(char columna) {
        this.columna = columna;
    }

    public char getOcupado() {
        return ocupado;
    }

    public void setOcupado(char ocupado) {
        this.ocupado = ocupado;
    }

}
