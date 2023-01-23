
package Enumeraciones;

import Entidades.Carta;
import Servicios.ServiciosCartas;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ClaudioDuran
 */

public class ServicioJuego {
    
    public void juego(){
      ServiciosCartas Sc = new ServiciosCartas();
        ArrayList<Carta> baraja = new ArrayList();
        ArrayList<Carta> monton = new ArrayList();
        Scanner leer;
        int opc;
        
        do {
             System.out.println("MENU BARAJA");
            leer = new Scanner(System.in).useDelimiter("\n");
            System.out.println("1. Crear Baraja.\n"
                    + "2. Mostrar contenido de la Baraja (x simbolos).\n"
                    + "3. Mostrar contenido de la Baraja (x nombres).\n"
                    + "4. Mezclar contenido de la Baraja.\n"
                    + "5. Dar una carta de la Baraja.\n"
                    + "6. Dar mas de una carta de la Baraja.\n"
                    + "7. Mostrar contenido del montón (x simbolos).\n"
                    + "8. Mostrar contenido del montón (x nombres)\n"
                    + "9. Mezclar contenido de Montón.\n"
                    + "10. Terminar.\n"
                    + "Su opción:");
            opc = leer.nextInt();
            Carta cartaDada;
            switch (opc) {
                case 1:
                    baraja = Sc.crearBaraja();
                    break;
                case 2:
                    Sc.mostrarBaraja(baraja);
                    break;
                case 3:
                    Sc.mostrarBarajaNombre(baraja);
                    break;
                case 4:
                    baraja = Sc.barajar(baraja);
                    break;
                case 5:
                    cartaDada = Sc.sgteCarta(baraja);
                    baraja = Sc.removerCarta(baraja);
                    monton = Sc.agregarCarta(monton, cartaDada);
                    break;
                case 6:
                    System.out.println("¿Cuantas cartas desea?");
                    int cant = leer.nextInt();
                    for (int i = 0; i < cant; i++) {
                        cartaDada = Sc.sgteCarta(baraja);
                        baraja = Sc.removerCarta(baraja);
                        monton = Sc.agregarCarta(monton, cartaDada);
                    }
                    break;
                case 7:
                    Sc.mostrarBaraja(monton);
                    break;
                case 8:
                    Sc.mostrarBarajaNombre(monton);
                    break;
                case 9:
                    Sc.barajar(monton);
                    break;
                case 10:
                    System.out.println("Sesión terminada.");
                    break;
                default:
                    System.out.println("La opción introducida no existe.");
            }
        } while (opc != 10);
    }

   }