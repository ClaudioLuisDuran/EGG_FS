package Servicios;

import Entidades.RevolverDeAgua;

/**
 * @author ClaudioDuran
 */
public class ServiciosRevolver {

    public RevolverDeAgua llenarRevolver(RevolverDeAgua r) {
        r.setPosActual((int) ((Math.random()*6)+1));
        System.out.println("Posicion actual: "+r.getPosActual());
        r.setPosAgua((int) ((Math.random()*6))+1);
        System.out.println("Posición agua: "+r.getPosAgua());
        return r;
    }

    public boolean mojar(RevolverDeAgua r) {
        boolean coincide;
        if (r.getPosAgua() == r.getPosActual()) {
            coincide = true;
        }else{
           coincide = false;
        }
        return coincide;
    }

    public RevolverDeAgua sgteChorro(RevolverDeAgua r) {
        int actual = r.getPosActual();
        if (actual == 6) {
            r.setPosActual(1);
        } else {
            r.setPosActual(actual + 1);
        }
        return r;
    }

    public void mostrarRevolver(RevolverDeAgua r) {
        System.out.println("Datos del revolver de agua:");
        System.out.println("Posición actual: " + r.getPosActual() + ".");
        System.out.println("Posición del agua: " + r.getPosAgua() + ".");
    }

}
