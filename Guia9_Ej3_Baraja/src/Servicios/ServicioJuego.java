package Servicios;

import Entidades.Carta;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ClaudioDuran
 */
public class ServicioJuego {

    public void juego() {
        // Inicializo variables
        ServiciosCartas Sc = new ServiciosCartas();
        Servicio7yMedio S7 = new Servicio7yMedio();
        ServicioSolitario Ss = new ServicioSolitario();
        ArrayList<Carta> baraja = new ArrayList();
        ArrayList<Carta> monton = new ArrayList();
        Scanner leer;
        int opc;

        // Despliego Menú
        do {
            System.out.println("MENU BARAJA");
            leer = new Scanner(System.in).useDelimiter("\n");
            System.out.println("    Opciones de métodos");
            System.out.println("1. Crear Baraja.\n"
                    + "2. Mostrar contenido de la Baraja (x simbolos).\n"
                    + "3. Mostrar contenido de la Baraja (x nombres).\n"
                    + "4. Mezclar contenido de la Baraja.\n"
                    + "5. Dar una carta de la Baraja.\n"
                    + "6. Dar mas de una carta de la Baraja.\n"
                    + "7. Mostrar contenido del montón (x simbolos).\n"
                    + "8. Mostrar contenido del montón (x nombres)\n"
                    + "9. Mezclar contenido de Montón.\n"
                    + "----------------------------------------------\n"
                    + "       Juegos\n"
                    + "10. Jugar al 7 y medio.\n"
                    + "11. Jugar Solitario.\n"
                    + "----------------------------------------------\n"
                    + "12. Terminar.\n"
                    + "Su opción:");
            opc = leer.nextInt();
            Carta cartaDada;
            switch (opc) {
                case 1:
                    this.clearScreen();
                    baraja = Sc.crearBaraja();
                    break;
                case 2:
                    this.clearScreen();
                    Sc.mostrarBaraja(baraja);
                    break;
                case 3:
                    this.clearScreen();
                    Sc.mostrarBarajaNombre(baraja);
                    break;
                case 4:
                    this.clearScreen();
                    baraja = Sc.barajar(baraja);
                    break;
                case 5:
                    this.clearScreen();
                    if (baraja.isEmpty()) {
                        System.out.println("No hay cartas. Debe crear la baraja primero");
                    } else {
                        cartaDada = Sc.sgteCarta(baraja);
                        baraja = Sc.removerCarta(baraja);
                        monton = Sc.agregarCarta(monton, cartaDada);
                    }
                    break;
                case 6:
                    this.clearScreen();
                    if (baraja.isEmpty()) {
                        System.out.println("No hay cartas. Debe crear la baraja primero");
                    } else {
                        System.out.println("¿Cuantas cartas desea?");
                        int cant = leer.nextInt();
                        for (int i = 0; i < cant; i++) {
                            cartaDada = Sc.sgteCarta(baraja);
                            baraja = Sc.removerCarta(baraja);
                            monton = Sc.agregarCarta(monton, cartaDada);
                        }
                    }
                    break;
                case 7:
                    this.clearScreen();
                    Sc.mostrarBaraja(monton);
                    break;
                case 8:
                    this.clearScreen();
                    Sc.mostrarBarajaNombre(monton);
                    break;
                case 9:
                    this.clearScreen();
                    if (monton.isEmpty()) {
                        System.out.println("No hay cartas en el montón.");
                    } else {
                        Sc.barajar(monton);
                    }
                    break;
                case 10:
                    this.clearScreen();
                    S7.jugar7yMedio(baraja);
                    break;
                case 11:
                    this.clearScreen();
                    Ss.Solitario();
                    break;
                case 12:
                    this.clearScreen();
                    System.out.println("Sesión terminada.");
                    break;
                default:
                    System.out.println("La opción introducida no existe.");
            }
        } while (opc != 12);
    }

    // Metodo para "borrar" pantalla
    public void clearScreen() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    public boolean compararArrays(ArrayList<Carta> list1, ArrayList<Carta> list2) {
        boolean areEqual = true;
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                areEqual = false;
                break;
            }
        }
        return areEqual;
    }

    public int cartasCorrectas(ArrayList<Carta> list1, ArrayList<Carta> list2) {
        int c = 0;
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).correctas(list2.get(i)) == true) {
                c++;
            }
        }
        return c;
    }

    public boolean unaCartaCorrecta(Carta c1, Carta c2) {
        boolean c = false;

        if (c1.equals(c2) == true) {
            c = true;
        }

        return c;
    }
}
