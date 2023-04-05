package Principal;

import Servicios.ServiciosArmadura;
import java.util.Scanner;

/**
 * @author ClaudioDuran
 */
public class MainJarvis {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        ServiciosArmadura Sa = new ServiciosArmadura();
        Sa.jarvisMenu();
    }
}
