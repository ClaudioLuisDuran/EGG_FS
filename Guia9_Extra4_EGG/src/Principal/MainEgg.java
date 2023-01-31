package Principal;

import Entidades.Alumno;
import Servicios.ServicioSimulador;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ClaudioDuran20
 *
 * // Simulador de votacion entre alumnos de EGG
 */
public class MainEgg {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        ServicioSimulador Ss = new ServicioSimulador();
        System.out.println("¿Cuantos alumnos desea generar aleatoriamente?");
        int opc = leer.nextInt();
        ArrayList<Alumno> listadoAlumnos = new ArrayList();
        Ss.menu(listadoAlumnos, opc);

    }

}
