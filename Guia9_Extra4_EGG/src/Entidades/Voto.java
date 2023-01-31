package Entidades;

import java.util.HashSet;

/**
 * @author ClaudioDuran
 */
public class Voto implements Cloneable {

    private Alumno alumno;
    private HashSet<Alumno> votados;

    public Voto() {
    }

    public Voto(Alumno alumno, HashSet<Alumno> votados) {
        this.alumno = alumno;
        this.votados = votados;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public HashSet<Alumno> getVotados() {
        return votados;
    }

    public void setVotados(HashSet<Alumno> votados) {
        this.votados = votados;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Voto voto = (Voto) super.clone();
        voto.alumno = alumno;
        voto.votados = (HashSet<Alumno>) votados.clone();
        return voto;
    }

}
