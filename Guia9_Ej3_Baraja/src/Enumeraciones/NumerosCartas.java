package Enumeraciones;

/**
 * @author ClaudioDuran
 */
public enum NumerosCartas {

    UNO("Uno", 1, 1.0), DOS("Dos", 2, 2.0), TRES("Tres", 3, 3.0), CUATRO("Cuatro", 4, 4.0), CINCO("Cinco", 5, 5.0), SEIS("Seis", 6, 6.0), SIETE("Siete", 7, 7.0), SOTA("Sota", 10, 0.5), CABALLO("Caballo", 11, 0.5), REY("Rey", 12, 0.5);
    private String nombreCartak;
    private int numeroCarta;
    private double valorCarta;

    private NumerosCartas() {
    }

    private NumerosCartas(String nombreCartak, int numeroCarta, double valorCarta) {
        this.nombreCartak = nombreCartak;
        this.numeroCarta = numeroCarta;
        this.valorCarta = valorCarta;
    }

    public String getNombreCartak() {
        return nombreCartak;
    }


    public int getNumeroCarta() {
        return numeroCarta;
    }

    public double getValorCarta() {
        return valorCarta;
    }

}
