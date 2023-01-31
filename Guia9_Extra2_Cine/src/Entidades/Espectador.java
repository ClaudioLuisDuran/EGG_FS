package Entidades;

/**
 * @author ClaudioDuran
 */
public class Espectador {

    private String nombre;
    private int edad;
    private int dinero;

    public Espectador() {
        this.dinero = 1000; // al crearlo se le pone dinero por defecto
    }

    public Espectador(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public Espectador(String nombre, int edad, int dinero) {
        this.nombre = nombre;
        this.edad = edad;
        this.dinero = dinero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

}
