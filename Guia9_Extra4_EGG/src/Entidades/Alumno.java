package Entidades;

/**
 * @author ClaudioDuran
 */
public class Alumno {

    private int id;
    private String nombre;
    private String apellido;
    private long dni;
    private int votosRecibidos;

    public Alumno() {
    }

    public Alumno(int id, String nombre, String apellido, long dni, int votosRecibidos) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.votosRecibidos = votosRecibidos;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public int getVotosRecibidos() {
        return votosRecibidos;
    }

    public void setVotosRecibidos(int votosRecibidos) {
        this.votosRecibidos = votosRecibidos;
    }

}
