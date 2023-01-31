package Servicios;

import Entidades.Asiento;

/**
 * @author ClaudioDuran
 */
public class ServicioAsiento {

    public Asiento crearAsiento(int fila, char columna) {
        Asiento a = new Asiento(fila, columna, ' ');
        return a;
    }

    public boolean ocuparAsiento(Asiento a) {
        boolean realizado;
        if (a.getOcupado() == 'X') {
            System.out.println("El asiento ya esta ocupado. Elija otro");
            realizado = false;
        } else {
            a.setOcupado('X');
            realizado = true;
        }
        return realizado;
    }

    public boolean desocuparAsiento(Asiento a) {
        boolean realizado = true;
        if (a.getOcupado() == 'X') {
            a.setOcupado(' ');
        } else {
            System.out.println("El asiento ya estaba desocupado");
        }
        return realizado;
    }
}
