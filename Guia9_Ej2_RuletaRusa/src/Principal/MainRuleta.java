package Principal;

import Entidades.Jugador;
import Entidades.RevolverDeAgua;
import Servicios.ServiciosJuego;
import java.util.ArrayList;

/**
 *
 * @author ClaudioDuran
 */
public class MainRuleta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ServiciosJuego Sj = new ServiciosJuego();
        ArrayList<Jugador> jugadores = new ArrayList();
        Jugador eliminado = new Jugador();
        RevolverDeAgua revolver = new RevolverDeAgua();

        // Desarrollo del juego
        Sj.llenarJuego(jugadores, revolver);
    }
}
