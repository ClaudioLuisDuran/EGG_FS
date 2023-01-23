
package Servicios;

import Entidades.Jugador;
import java.util.Scanner;

/**
 * @author ClaudioDuran
 */
public class ServiciosJugador {
    Scanner leer;
    public Jugador crearJugador(int i){
        
          leer = new Scanner(System.in).useDelimiter("\n");
        Jugador j = new Jugador();
        System.out.print("Nombre del Jugador "+i+": ");
        j.setNombre(leer.next());
        return j;
    }
    
}
