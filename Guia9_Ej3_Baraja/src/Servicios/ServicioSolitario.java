package Servicios;

import Entidades.Carta;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author ClaudioDuran
 */
public class ServicioSolitario {

    Scanner leer;
    boolean cartaOk = false;
    public ArrayList<Carta> barajaIdeal = new ArrayList();
    public ArrayList<Carta> barajaSolitario = new ArrayList();
    public ArrayList<Carta> pozo = new ArrayList();
    public ArrayList<Boolean> control = new ArrayList();
    public Carta cartaAuxiliar = new Carta();
    ServiciosJugador Sj = new ServiciosJugador();
    ServiciosCartas Sc = new ServiciosCartas();
    ServicioJuego Sjuego = new ServicioJuego();
    String nombre;

    public void Solitario() {
        leer = new Scanner(System.in).useDelimiter("\n");

        // Generar baraja ideal.
        barajaIdeal = Sc.crearBaraja();

        // Generar barajaSolitario
        barajaSolitario = Sc.crearBaraja();
        Collections.shuffle(barajaSolitario);

        // Genero Pozo a partir de la Baraja de Solitario
        Iterator<Carta> itP = barajaSolitario.iterator();
        int contP = 0;
        while (itP.hasNext()) {
            Carta p = itP.next();
            if (contP == 9 || contP == 19 || contP == 29 || contP == 39) {
                pozo.add(p);
            }
            contP++;
        }

        //Inicializo ArrayList de control, todo a falso.
        for (int i = 0; i < 40; i++) {
            control.add(false);
        }

        // Iniciar juego
        // Dar instrucciones y pedir nombre de jugador por única vez.
        System.out.printf("---------------------------------------------------------------------%n");
        System.out.printf("                        SOLITARIO      %n");
        System.out.printf("                         (EN JAVA)      %n");
        System.out.printf("---------------------------------------------------------------------%n");
        System.out.println("");

        System.out.println("Consigna: Reordenar la baraja por fila de menor a mayor (1 a 11)\n"
                + "y por palo: Oro, Copa, Espada y Basto. Debe intercambiar la carta disponible\n"
                + "en el pozo hasta que aparezca un REY (12), el cual será descartado.\n"
                + "En ese momento, se pasa a la siguiente carta del pozo hasta agotar todas las \n"
                + "posibilidades. Gana si logra ordenar toda la baraja completa. Si queda una o \n"
                + "mas cartas desordenadas, pierde. Suerte!!!");

        System.out.println("¿Estás preparado? Ingresa tu nombre:");
        nombre = leer.next();
        System.out.println("Perfecto " + nombre + ", presiona una tecla para comenzar.");
        leer.next();

        //Desplegar baraja de Solitario y jugar
        jugar(barajaSolitario);

        // Cuando termina el juego, freno para que no vuelva al Menú principal directamente.
        leer.next();
    }

    // Mostrar tablero de juego y debajo el pozo disponible para cambiar
    public void mostrarBaraja(ArrayList<Carta> baraja) {
        int cont = 0;
        if (baraja.isEmpty()) {
            System.out.println("No hay cartas para mostrar.");
        } else {
            // Inicializo primera linea del tablero
            System.out.printf("--------------------------------SOLITARIO de " + nombre + "--------------------------------------------%n");
            System.out.printf("|  %-2s |   %-3s |   %-2s |   %-2s |   %-2s |   %-2s |   %-2s |   %-2s |   %-2s |   %-2s |%n", "  ", "1", "2", "3", "4", "5", "6", "7", "8", "9");
            System.out.printf("---------------------------------------------------------------------------------------------------%n");
            // Inicializo cartas del tablero   
            System.out.print(" ☼ > 1|");
            Iterator<Carta> it = baraja.iterator();
            while (it.hasNext()) {
                Carta c = it.next();
                String espacio;
                if (c.getNumero().getNumeroCarta() > 9) {
                    espacio = " |";
                } else {
                    espacio = "  |";
                }
                if (cont != 9 && cont != 19 && cont != 29 && cont != 39) {
                    System.out.format("%2s", "");
                    if (Sjuego.unaCartaCorrecta(c, barajaIdeal.get(cont)) == true) {
                        System.out.print("" + c.getNumero().getNumeroCarta() + c.getPalo().getSimbolo() + espacio + "");
                    } else {
                        System.out.print(" ?  |");
                    }
                } else {
                    switch (cont) {
                        case 9:
                            System.out.println("");
                            System.out.print(" ♀ > 2|");
                            break;
                        case 19:
                            System.out.println("");
                            System.out.print(" ♂ > 3|");
                            break;
                        case 29:
                            System.out.println("");
                            System.out.print(" ‼ ´> 4|");
                            break;
                        default:
                    }
                }
                cont++;
            }

            //muestro cartas del pozo
            System.out.println("");
            System.out.println("");
            Iterator<Carta> it2 = pozo.iterator();
            System.out.print("         Cartas del pozo (Se juegan en orden):   ");
            while (it2.hasNext()) {
                Carta c2 = it2.next();
                if (c2.getNumero().getNumeroCarta() == 12) {
                    System.out.print(" [" + c2.getNumero().getNumeroCarta() + "" + c2.getPalo().getSimbolo() + "]");
                } else {
                    System.out.print(" [ ? ]");
                }
            }
        }
    }

    // Control del juego
    public void jugar(ArrayList<Carta> baraja) {
        int cont = 0;
        String carta = "";
        int pos = 0;
        int reyes = 0;
        // veo si hay cartas colocadas donde deben ir
        int correctas = Sjuego.cartasCorrectas(barajaIdeal, barajaSolitario);

        // Muestro la baraja
        do {
            Sjuego.clearScreen();
            System.out.println("          Cartas ordenadas: " + correctas + "                Reyes: " + reyes);
            this.mostrarBaraja(baraja);
            System.out.println("");

            // Muestro carta en mano y pido posición en donde colocarla
            if (!pozo.get(cont).getNumero().getNombreCartak().equalsIgnoreCase("Rey")) {
                System.out.println("                       Tiene en mano la carta: [" + pozo.get(cont).getNumero().getNumeroCarta() + pozo.get(cont).getPalo().getSimbolo() + "].");
                boolean bien = false;
                do {
                    System.out.print("   Elija posición para cambiar (fila+columna):");
                   
            // Si no entra un numero entero, captura el error y lo pide nuevo
                    boolean deNuevo;
                    do {
                        deNuevo = true;
                        try {
                            System.out.print("Ingrese un número entero: ");
                            pos = leer.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Ingreso inválido, por favor ingrese un número entero.");
                            deNuevo = false;
                            leer.next();
                        }
                    } while (deNuevo == false);

                    if ((pos < 11 || pos > 49) || (pos == 20 || pos == 30 || pos == 40)) {
                        System.out.println("Esa posición no existe.");
                    } else {
                        bien = true;
                    }
                } while (bien == false);

                // Hago el intercambio de carta         
                cartaAuxiliar = baraja.get(pos - 11);
                baraja.set(pos - 11, pozo.get(cont));
                pozo.set(cont, cartaAuxiliar);
                cartaOk = baraja.get(pos - 11).correctas(barajaIdeal.get(pos - 11));

                // Si la carta esta colocada en el lugar correcto y es distinta de 12, la cuenta y marca la posición en el Control como true..     
                if (cartaOk == true && baraja.get(pos - 11).getNumero().getNumeroCarta() != 12) {
                    correctas++;
                    control.set(pos - 11, true);
                } else {
                    // Si la carta se colocó en una posición incorrecta que ya era correcta,
                    // se pasa a false el control y se resta el contador de Correctas.
                    if (control.get(pos - 11) == true) {
                        control.set(pos - 11, false);
                        correctas--;
                    }
                }
                if (cartaAuxiliar.getNumero().getNombreCartak().equalsIgnoreCase("Rey")) {
                    reyes++;
                    cont++;
                    if (reyes < 4) {
                        cartaAuxiliar = pozo.get(cont);
                    }
                }

            } else {
                reyes++;
                cont++;
                if (reyes < 4) {
                    cartaAuxiliar = pozo.get(cont);
                }
            }

            // Compruebo las rondas y reyes antes de volver
        } while (cont <= 4 && reyes < 4);

        //Juego terminado > último despliegue de baraja.
        Sjuego.clearScreen();
        System.out.println("          Cartas ordenadas: " + correctas + "                Reyes: " + reyes);
        this.mostrarBaraja(baraja);
        System.out.println("");

        // verifico si completó el solitario y lo imprimo
        if (correctas == 36) {
            System.out.println("Felicitaciones " + nombre + "!!! Completó el solitario. ");
        } else {
            System.out.println(nombre + ", lamentablemente encontró los 4 Reyes y faltaron ordenar " + (36 - correctas) + ".");
            System.out.println("Sigue intentándolo!");
        }

        // Borro todas las variables.
        pozo.clear();
        barajaIdeal.clear();
        barajaSolitario.clear();
        control.clear();
        cartaAuxiliar = null;
        nombre = null;

        // Fin del juego.
    }
}
