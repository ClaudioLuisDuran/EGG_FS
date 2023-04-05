
package Entidades;

/**
 * @author ClaudioDuran
 */
public class Objetos {
    
    private int x,y,z; // Coordenadas
    private int resistencia;
    private boolean hostil;

    public Objetos() {
        this.resistencia = 50;
    }

    public Objetos(int x, int y, int z, int resistencia, boolean hostil) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.resistencia = resistencia;
        this.hostil = hostil;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public boolean isHostil() {
        return hostil;
    }

    public void setHostil(boolean hostil) {
        this.hostil = hostil;
    }
    
    
    
}
