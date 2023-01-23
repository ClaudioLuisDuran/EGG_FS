package Enumeraciones;

/**
 * @author ClaudioDuran
 */
public enum PalosCartas {

    ORO('☼', "Oro"), COPA('♀', "Copa"), ESPADA('♂', "Espada"), BASTO('‼', "Basto");

    private char simbolo;
    private String nombreOK;

    private PalosCartas(char simbolo, String nombreOK) {
        this.simbolo = simbolo;
        this.nombreOK = nombreOK;
    }

    private PalosCartas() {
    }

    public char getSimbolo() {
        return simbolo;
    }

    public String getNombreOK() {
        return nombreOK;
    }

}
