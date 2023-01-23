package Servicios;

import Entidades.Carta;
import Entidades.Jugador;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ClaudioDuran
 */
public class Servicio7yMedio {

    Scanner leer;
    ServiciosJugador Sj = new ServiciosJugador();
    ArrayList<Jugador> jugadores = new ArrayList();
    ServiciosCartas Sc = new ServiciosCartas();

    public void jugar7yMedio(ArrayList<Carta> baraja) {
        //declaraciones iniciales
        ArrayList<Carta> monton = new ArrayList();
        leer = new Scanner(System.in).useDelimiter("\n");
        String opc;
        //Ingreso de jugadores
        System.out.println("*** 7 y medio ***");
        System.out.println("_____________");
        System.out.println("Ingresar jugadores. ¿Cuantos jugarán?");
        int cant = leer.nextInt();
        for (int i = 1; i <= cant; i++) {
            jugadores.add(Sj.crearJugador(i));
        }
        // Chequeo si la baraja fue inicializada
        if (baraja.isEmpty()) {
            System.out.println("No hay baraja. Presione una tecla para crearla.");
            String ok = leer.next();
            baraja = Sc.crearBaraja();
        }
        // iniciar ronda de juego mezclando la baraja.
        baraja = Sc.barajar(baraja);
        for (Jugador jugador : jugadores) {
            System.out.println(jugador.getNombre() + ", comienza su juego. Presione una tecla para recibir la primera carta.");
            leer.next();
            double puntajeJugador = jugador.getPuntaje();
            boolean otra = true;
            do {
                Carta cartaDada = Sc.sgteCarta(baraja);
                baraja = Sc.removerCarta(baraja);
                monton = Sc.agregarCarta(monton, cartaDada);
                puntajeJugador = puntajeJugador + cartaDada.getNumero().getValorCarta();

                // ver si la opcion S o N son validas
                boolean sigue = false;
                do {
                    System.out.println("Desea otra carta? (S/N)");
                    opc = leer.next();
                    if (!opc.equalsIgnoreCase("s") && !opc.equalsIgnoreCase("n")) {
                        System.out.println("La opción ingresada no es válida.");
                    } else {
                        sigue = true;
                    }
                } while (sigue == false);
                if (opc.equalsIgnoreCase("n")) {
                    otra = false;
                }
            } while (otra == true);
            jugador.setPuntaje(puntajeJugador);
            System.out.println("");
        }
        // Terminada la ronda, chequeo los puntajes y determino el ganador
        System.out.println("Puntajes finales");
        double mayorPuntaje = 0;
        String ganador = "";
        for (Jugador jugador : jugadores) {
            System.out.print("Jugador " + jugador.getNombre() + ", " + jugador.getPuntaje() + " puntos. ");
            if (jugador.getPuntaje() > 7.5) {
                System.out.print(" Descalificado.");
            } else {
                if (jugador.getPuntaje() > mayorPuntaje) {
                    mayorPuntaje = jugador.getPuntaje();
                    ganador = jugador.getNombre();
                    if (jugador.getPuntaje() == 7.5) {
                        System.out.print(" Puntaje perfecto!");
                    }
                }
            }
            System.out.println("");
        }
        // Imprimo resultados finales
        System.out.println("GANADOR.... " + ganador + ", con " + mayorPuntaje + " ps.!!!!! Felicitaciones!");
        System.out.println("");
        System.out.println("Presione una tecla para volver al Menú principal.");
        leer.next();
    }
}
