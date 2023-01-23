package Servicios;

import Entidades.Carta;
import Enumeraciones.NumerosCartas;
import Enumeraciones.PalosCartas;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * @author ClaudioDuran
 */
public class ServiciosCartas {

    public ArrayList<Carta> crearBaraja() {
        ArrayList<Carta> nuevaBaraja = new ArrayList();

        for (PalosCartas palo : PalosCartas.values()) {
            for (NumerosCartas numero : NumerosCartas.values()) {
                Carta nuevaCarta = new Carta(numero, palo);
                nuevaBaraja.add(nuevaCarta);
            }
        }
        System.out.println("Baraja creada con éxito.");
        return nuevaBaraja;
    }

    public ArrayList<Carta> barajar(ArrayList<Carta> baraja) {
        if (baraja.isEmpty()) {
            System.out.println("No hay cartas para barajar. Debe crear una baraja primero.");
        } else {
            Collections.shuffle(baraja);
            System.out.println("Baraja mezclada con éxito.");
        }
        return baraja;
    }

    public void cartasDisponibles(ArrayList<Carta> baraja) {
        int num = baraja.size();
        System.out.println("Hay " + num + " cartas en la baraja.");
    }

    public void mostrarBaraja(ArrayList<Carta> baraja) {
        if (baraja.isEmpty()) {
            System.out.println("No hay cartas para mostrar.");
        } else {
            Iterator<Carta> it = baraja.iterator();
            int totalCartas = baraja.size();
            int cont = 0;
            while (it.hasNext()) {
                Carta c = it.next();
                System.out.print("[" + c.getNumero().getNumeroCarta() + "" + c.getPalo().getSimbolo() + "]");
                cont++;
                if (cont >= (int) (totalCartas / 4)) {
                    System.out.println("");
                    cont = 0;
                }
            }
        }
    }

    public void mostrarBarajaNombre(ArrayList<Carta> baraja) {
        if (baraja.isEmpty()) {
            System.out.println("No hay cartas para mostrar.");
        } else {
            Iterator<Carta> it = baraja.iterator();
            int totalCartas = baraja.size();
            int cont = 0;
            while (it.hasNext()) {
                Carta c = it.next();
                System.out.print("[" + c.getNumero().getNombreCartak() + " de " + c.getPalo().getNombreOK() + "]");
                cont++;
                if (cont >= (int) (totalCartas / 4)) {
                    System.out.println("");
                    cont = 0;
                }
            }
        }
    }

    public Carta darCarta(ArrayList<Carta> baraja) {
        Carta c = new Carta();
        if (baraja.isEmpty()) {
            System.out.println("No hay cartas para mostrar.");
        } else {
            for (Carta carta : baraja) {
                c = baraja.get(0);
            }
        }
        return c;
    }

    public Carta sgteCarta(ArrayList<Carta> baraja) {
        Carta c = this.darCarta(baraja);
        System.out.println("Carta dada: [" + c.getNumero().getNumeroCarta() + " " + c.getPalo().getSimbolo() + "]");
        return c;
    }

    public ArrayList<Carta> removerCarta(ArrayList<Carta> baraja) {
        if (baraja.isEmpty()) {

        } else {
            baraja.remove(0);
        }
        return baraja;
    }

    public ArrayList<Carta> agregarCarta(ArrayList<Carta> monton, Carta c) {

        monton.add(c);
        return monton;
    }
}
