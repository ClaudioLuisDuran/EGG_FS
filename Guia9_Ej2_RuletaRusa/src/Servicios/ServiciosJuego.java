package Servicios;

import Entidades.Jugador;
import Entidades.RevolverDeAgua;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author ClaudioDuran
 */
public class ServiciosJuego {

    public void llenarJuego(ArrayList<Jugador> js, RevolverDeAgua r) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        ServiciosRevolver Sr = new ServiciosRevolver();
        
        System.out.println("RULETA RUSA DE AGUA");
        System.out.println("Carga de jugadores:");
        
        for (int i = 1; i < 7; i++) {
            Jugador j = new Jugador();
            System.out.println("Jugador " + i + ":");
            j.setNombre(leer.next());
            j.setId(i);
            j.setMojado(false);
            js.add(j);
        }
        System.out.println("");
        System.out.println("Carga automática del revolver...");
        r = Sr.llenarRevolver(r);
        System.out.println("El revolver esta listo para ser usado.");
        
        // Comienza el juego?
        System.out.println("¿Estan preparados? (S/N)");
        String ok = leer.next();
        if (ok.equalsIgnoreCase("s")) {
            this.ronda(js, r);
        } else {
            System.out.println("Cobardes! Tienen 1 min para desaparecer!");
        }
    }

    public void ronda(ArrayList<Jugador> js, RevolverDeAgua r) {
        ServiciosJugador Sj = new ServiciosJugador();
        ServiciosRevolver Sr = new ServiciosRevolver();
        Jugador jugadorActual;
        Iterator<Jugador> it = js.iterator();
        boolean sigue = true;
        while (it.hasNext() && sigue == true) {
            jugadorActual = it.next();
            if (jugadorActual.isMojado()==false) {
               System.out.println("Juega Jugador " + jugadorActual.getId() + ": " + jugadorActual.getNombre() + ". Suerte!");
            if (Sj.disparo(r, jugadorActual) == true) {
                sigue = false;
                jugadorActual.setMojado(true);
                System.out.println("El juego ha terminado. Hay un amigo menos en el mundo....");
            } else {
                jugadorActual.setMojado(false);
                 r=Sr.sgteChorro(r);
                System.out.println("El juego continúa...");
            } 
            }
        }
       
    }
}
