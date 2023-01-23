/*
 * disparo(Revolver r): el método, recibe el revolver de agua y llama a los métodos de
mojar() y siguienteChorro() de Revolver. El jugador se apunta, aprieta el gatillo y si el
revolver tira el agua, el jugador se moja. El atributo mojado pasa a false y el método
devuelve true, sino false.
 */
package Servicios;

import Entidades.Jugador;
import Entidades.RevolverDeAgua;
import java.util.Scanner;
/**
 *
 * @author ClaudioDuran
 */
public class ServiciosJugador {
        ServiciosRevolver Sr = new ServiciosRevolver();
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        boolean disparo;
        
        public boolean disparo(RevolverDeAgua r, Jugador j) {
            System.out.println("Disparo de "+j.getNombre()+"....");
            System.out.println("Cuando estés listo, prediona una tecla...");
            String opc = leer.nextLine();
            if (Sr.mojar(r)==false) {
                System.out.println("Pfffff..... Disparo vacio. "+j.getNombre()+" sigue en juego.");
               disparo = false;
                System.out.println("¿Continuamos? Presione una tecla para seguir el juego.");
               opc = leer.nextLine();
              }else{
                System.out.println("Splash!!!!!!! "+j.getNombre()+" ha sido empapado. Perdió el juego.");
               disparo = true;
            }
            return disparo;
    }
}
