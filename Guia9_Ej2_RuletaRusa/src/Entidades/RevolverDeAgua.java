package Entidades;

public class RevolverDeAgua {

    private int PosActual;
    private int PosAgua;

    public RevolverDeAgua() {
    }

    public RevolverDeAgua(int PosActual, int PosAgua) {
        this.PosActual = PosActual;
        this.PosAgua = PosAgua;
    }

    public int getPosActual() {
        return PosActual;
    }

    public void setPosActual(int PosActual) {
        this.PosActual = PosActual;
    }

    public int getPosAgua() {
        return PosAgua;
    }

    public void setPosAgua(int PosAgua) {
        this.PosAgua = PosAgua;
    }

    
    
}
