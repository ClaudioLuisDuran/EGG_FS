package Servicios;

import Entidades.Cine;
import Entidades.Espectador;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ClaudioDuran
 */
public class ServicioEspectador {

    Scanner leer;

    public ArrayList<Espectador> espectadoresAutomaticos(Cine c) {

        ArrayList<Espectador> espectadores = new ArrayList();

// Crear automaticamente 25 espectadores
        for (int i = 1; i < 26; i++) {
            switch (i) {
                case 1:
                    Espectador e = new Espectador("Claudio", 55, 500);
                    espectadores.add(e);
                    break;
                case 2:
                    e = new Espectador("Carina", 54, 500);
                    espectadores.add(e);
                    break;
                case 3:
                    e = new Espectador("Francisco", 29, 500);
                    espectadores.add(e);
                    break;
                case 4:
                    e = new Espectador("Clara", 28, 500);
                    espectadores.add(e);
                    break;
                case 5:
                    e = new Espectador("Belen", 16, 500);
                    espectadores.add(e);
                    break;
                case 6:
                    e = new Espectador("Mateo", 2, 500);
                    espectadores.add(e);
                    break;
                case 7:
                    e = new Espectador("Rocio", 27, 500);
                    espectadores.add(e);
                    break;
                case 8:
                    e = new Espectador("Daniel", 30, 500);
                    espectadores.add(e);
                    break;
                case 9:
                    e = new Espectador("Pedro", 20, 500);
                    espectadores.add(e);
                    break;
                case 10:
                    e = new Espectador("Jose", 43, 500);
                    espectadores.add(e);
                    break;
                case 11:
                    e = new Espectador("Matias", 12, 500);
                    espectadores.add(e);
                    break;
                case 12:
                    e = new Espectador("Damian", 10, 500);
                    espectadores.add(e);
                    break;
                case 13:
                    e = new Espectador("Carlos", 43, 500);
                    espectadores.add(e);
                    break;
                case 14:
                    e = new Espectador("Mariano", 39, 500);
                    espectadores.add(e);
                    break;
                case 15:
                    e = new Espectador("Herminia", 80, 500);
                    espectadores.add(e);
                    break;
                case 16:
                    e = new Espectador("Vanina", 41, 500);
                    espectadores.add(e);
                    break;
                case 17:
                    e = new Espectador("Josesito", 8, 500);
                    espectadores.add(e);
                    break;
                case 18:
                    e = new Espectador("Emiliano", 6, 500);
                    espectadores.add(e);
                    break;
                case 19:
                    e = new Espectador("Roxana", 47, 500);
                    espectadores.add(e);
                    break;
                case 20:
                    e = new Espectador("Marcelo", 32, 500);
                    espectadores.add(e);
                    break;
                case 21:
                    e = new Espectador("Juan", 30, 500);
                    espectadores.add(e);
                    break;
                case 22:
                    e = new Espectador("Julia", 11, 500);
                    espectadores.add(e);
                    break;
                case 23:
                    e = new Espectador("Dolores", 12, 500);
                    espectadores.add(e);
                    break;
                case 24:
                    e = new Espectador("Sandro", 15, 500);
                    espectadores.add(e);
                    break;
                case 25:
                    e = new Espectador("Ceferino", 18, 500);
                    espectadores.add(e);
                    break;
                default:
                    throw new AssertionError();
            }

        }

        return espectadores;
    }

    public Espectador nuevoEspectador(int precio) {
        leer = new Scanner(System.in).useDelimiter("\n");
        Espectador esp = new Espectador();
        System.out.println("Nombre del cliente: ");
        esp.setNombre(leer.next());
        System.out.println("Edad del cliente: ");
        esp.setEdad(leer.nextInt());
        System.out.println("Crédito?:");
        esp.setDinero(leer.nextInt());
        if (esp.getDinero() < precio) {
            System.out.println("Su crédito no alcanza para pagar la entrada ($" + precio + "). "
                    + "¿Que desea hacer?\n"
                    + "1. Ingresar mas dinero.\n"
                    + "2. Gracias, vuelvo otro dia....");
            int opc = leer.nextInt();
            if (opc == 1) {
                System.out.print("Ingresar $");
                esp.setDinero(esp.getDinero() + leer.nextInt());
            } else {
                System.out.println("Lo sentimos. Te esperamos pronto!!");
            }
        }

        return esp;
    }

    public void verClientes(ArrayList<Espectador> e) {
        System.out.println("Espectadores que están en la sala:");
        for (Espectador espectador : e) {
            System.out.println(espectador.getNombre() + ", " + espectador.getEdad() + ". (Crédito: $" + espectador.getDinero() + ".");
        }
    }

    public boolean calificaEspectador(Espectador e, Cine c) {
        boolean califica;
        if (e.getEdad() >= c.getPeliActual().getEdadMinima()) {
            califica = true;
        } else {
            califica = false;
        }
        return califica;
    }
}
