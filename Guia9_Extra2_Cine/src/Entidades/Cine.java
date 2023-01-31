package Entidades;

/**
 * @author ClaudioDuran
 */
public class Cine {

    private Pelicula peliActual;
    private Asiento[][] sala = new Asiento[8][6];
    private int precio;

    public Cine() {
    }

    public Cine(Pelicula peliActual, int precio, Asiento[][] sala) {
        this.peliActual = peliActual;
        this.precio = precio;
        this.sala = sala;
    }

    public Pelicula getPeliActual() {
        return peliActual;
    }

    public void setPeliActual(Pelicula peliActual) {
        this.peliActual = peliActual;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Asiento[][] getSala() {
        return sala;
    }

    public void setSala(Asiento[][] sala) {
        this.sala = sala;
    }

}
