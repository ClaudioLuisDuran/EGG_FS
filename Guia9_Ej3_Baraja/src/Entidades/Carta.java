package Entidades;

import Enumeraciones.NumerosCartas;
import Enumeraciones.PalosCartas;

/**
 * @author ClaudioDuran
 */
public class Carta {

    private NumerosCartas numero;
    private PalosCartas palo;

    public Carta() {
    }

    public Carta(NumerosCartas numero, PalosCartas palo) {
        this.numero = numero;
        this.palo = palo;
    }

    public NumerosCartas getNumero() {
        return numero;
    }

    public void setNumero(NumerosCartas numero) {
        this.numero = numero;
    }

    public PalosCartas getPalo() {
        return palo;
    }

    public void setPalo(PalosCartas palo) {
        this.palo = palo;
    }

    @Override
    public String toString() {
        return "Carta{" + "numero=" + numero + ", palo=" + palo + '}';
    }

    public boolean equals(Carta other) {
        int correctas = 0;
        return this.getNumero() == other.getNumero() && this.getPalo() == other.getPalo();
    }

    public boolean correctas(Carta other) {
        boolean c = false;
        if (this.getNumero() == other.getNumero() && this.getPalo() == other.getPalo()) {
            c = true;
        }
        return c;
    }
}
