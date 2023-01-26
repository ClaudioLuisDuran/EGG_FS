package Servicios;

import Entidades.Carta;
import Entidades.Jugador;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ClaudioDuran
 */
public class ServicioMayorMenor {

    ServicioJuego Sj = new ServicioJuego();
    ServiciosCartas Sc = new ServiciosCartas();
    Scanner leer;
    protected ArrayList<Jugador> jugadores = new ArrayList();
    private int cantidadCartas;
    ArrayList<Carta> cartasJuego = new ArrayList();
    private int cantJugadores;
    ArrayList<Carta> barajaCompleta = new ArrayList();

    public void Mm() {
        leer = new Scanner(System.in).useDelimiter("\n");

        // Pido datos de juego
        System.out.println("------- ¿Mayor, menor o igual? -------\n"
                + "¿Cuantos jugadores participarán?:");
        cantJugadores = leer.nextInt();
        System.out.println("¿Con cuantas cartas jugarán?(7 o 14)");
        do {
            cantidadCartas = leer.nextInt();
            if (cantidadCartas != 7 && cantidadCartas != 14) {
                System.out.println("Solo se admiten 7 o 14 cartas. Ingresa tu opción nuevamente.");
            }
        } while (cantidadCartas != 7 && cantidadCartas != 14);
        System.out.println("A continuación ingrese los nombres de los jugadores:");
        for (int i = 0; i < cantJugadores; i++) {
            Jugador j = new Jugador(leer.next(), 0);
            jugadores.add(j);
        }
        System.out.println("Excelente!  Recuerden:");
        switch (cantidadCartas) {
            case 7:
                System.out.println("Para ganar el máximo puntaje de la ronda, debe descubiri hasta el final si la carta siguiente\n"
                        + "es mayor, menor o igual a la que la precede. Pero cada paso que das tiene puntaje, incluso iniciar la ronda\n"
                        + "ya te da 0,5 puntos. Los puntajes van de 0,5 a 3,5 puntos. Total de la ronda: 14 puntos en juego."
                        + "Gana el participante que más puntos gane.");
                break;
            case 14:
                System.out.println("Para ganar el máximo puntaje de la ronda, debe descubiri hasta el final si la carta siguiente\n"
                        + "es mayor, menor o igual a la que la precede. Pero cada paso que das tiene puntaje, incluso iniciar la ronda\n"
                        + "ya te da 0,5 puntos. Los puntajes van de 0,5 a 7,5 puntos. Total de la ronda: 53 puntos en juego."
                        + "Gana el participante que más puntos gane.");
                break;
        }
        System.out.println("Presiona una tecla para dar inicio al juego. Suerte!!!!");
        leer.next();
        //
        // llamar a la ronda
        for (Jugador jugador : jugadores) {
            jugador.setPuntaje(rondaJugador(jugador, cantidadCartas));
        }
        // Muestro resultados
        Sj.clearScreen(); // borro pantalla
        System.out.println("Resultados finales");
        double puntajeMayor = 0;
        String ganador = "";
        for (Jugador jugador : jugadores) {
            System.out.println("Jugador " + jugador.getNombre() + ": " + jugador.getPuntaje() + " ps.");
            if (puntajeMayor < jugador.getPuntaje()) {
                puntajeMayor = jugador.getPuntaje();
                ganador = jugador.getNombre();
            }
        }
        System.out.println("Ganador: " + ganador + "!!!!");
        System.out.println("");
        System.out.println("Presione una tecla para volver al Menú principal.");
        leer.next();
    }

    public double rondaJugador(Jugador j, int cartas) {

        //genero baraja.. Luego para cada jugador, mezclo y tomo las primeras 7 o 14..
        barajaCompleta = Sc.crearBaraja();

        // variables necesarias
        double puntajeObtenido = 0.5; // por cada Jugador
        int bucle; // Contador de bucles de juego
        boolean resultado; // Variable para que el bucle continue si las elecciones son correctos
        int cont; // Contador 
        int cartaNum;
        Carta cartaAnt;
        Carta cartaActual = new Carta();

        //Genero y muestro cartas de juego aleatoriamente para cada jugador.
        barajaCompleta = Sc.barajar(barajaCompleta);
        for (int i = 0; i < cartas; i++) {
            cartasJuego.add(barajaCompleta.get(i));
        }

        // Decido la cantidad máxima de bucles según numero de cartas en juego
        if (cartas == 7) {
            bucle = 6;
        } else {
            bucle = 13;
        }

        // Carta 0. Mostrar
        Sj.clearScreen(); // borro pantalla
        System.out.println("Juego de " + j.getNombre() + ":");
        cont = 0;
        // Primera captura primera carta en Carta Actual
        if (cont == 0) {
            cartaActual = cartasJuego.get(cont);
            // Muestro cartas. Cont++ / no juego.
            cartaNum = 0;
            for (Carta carta : cartasJuego) {
                if (cartaNum <= cont) {
                    System.out.print("[ " + carta.getNumero().getNumeroCarta() + carta.getPalo().getSimbolo() + " ]  ");
                } else {
                    System.out.print("[ ?? ]  ");
                }
                if (cartaNum == 6) {
                    System.out.println("");
                }
                cartaNum++;
            }
            cont++;
        }

        // Comienza bucle de jugador desde Carta 1
        do {
            // Cambio Carta Actual a CartaAnterior.
            cartaAnt = cartaActual;
            // Captura Carta Actual.
            cartaActual = cartasJuego.get(cont);

            // Pregunta del juego a partir de segunda carta
            System.out.println("La carta que sigue.... ¿Es mayor (1), menor (2) o igual (3)?");
            int opc = leer.nextInt();
            resultado = true;
            switch (opc) {
                case 1:
                    if (cartaActual.getNumero().getNumeroCarta() <= cartaAnt.getNumero().getNumeroCarta()) {
                        resultado = false;
                    } else {
                        puntajeObtenido = puntajeObtenido + puntajePuntual(cont);
                    }
                    break;
                case 2:
                    if (cartaActual.getNumero().getNumeroCarta() >= cartaAnt.getNumero().getNumeroCarta()) {
                        resultado = false;
                    } else {
                        puntajeObtenido = puntajeObtenido + puntajePuntual(cont);
                    }
                    break;
                case 3:
                    if (cartaActual.getNumero().getNumeroCarta() != cartaAnt.getNumero().getNumeroCarta()) {
                        resultado = false;
                    } else {
                        puntajeObtenido = puntajeObtenido + puntajePuntual(cont);
                    }
                    break;
            }
            if (resultado == false) {
                cont = bucle;
                System.out.println("Lo siento. No ha llegado al final. Su puntaje fue de " + puntajeObtenido + " ps.");
            } else {

                //Muestra  cartas de nuevo
                Sj.clearScreen(); // borro pantalla
                System.out.println("Juego de " + j.getNombre() + ":");
                cartaNum = 0;
                for (Carta carta : cartasJuego) {
                    if (cartaNum <= cont) {
                        System.out.print("[ " + carta.getNumero().getNumeroCarta() + carta.getPalo().getSimbolo() + " ]  ");
                    } else {
                        System.out.print("[ ?? ]  ");
                    }
                    if (cartaNum == 6) {
                        System.out.println("");
                    }
                    cartaNum++;
                }
                cont++;
            }
        } while (cont <= bucle && resultado == true);

        if (resultado == true) {
            System.out.println("Felicitaciones! Obtuvo " + puntajeObtenido + " ps.");
        }
        cartasJuego.clear();
        System.out.println("Presione una tecla para seguir.");
        leer.next();
        return puntajeObtenido;
    }

    public double puntajePuntual(int numCarta) {
        double p = 0;
        switch (numCarta) {
            case 0:
                p = 0.5;
                break;
            case 1:
                p = 1;
                break;
            case 2:
                p = 1.5;
                break;
            case 3:
                p = 2;
                break;
            case 4:
                p = 2.5;
                break;
            case 5:
                p = 3;
                break;
            case 6:
                p = 3.5;
                break;
            case 7:
                p = 04;
                break;
            case 8:
                p = 4.5;
                break;
            case 9:
                p = 5;
                break;
            case 10:
                p = 5.5;
                break;
            case 11:
                p = 6;
                break;
            case 12:
                p = 6.5;
                break;
            case 13:
                p = 7.5;
                break;

        }
        return p;
    }

}
