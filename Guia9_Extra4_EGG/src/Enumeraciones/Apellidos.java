
package Enumeraciones;

/**
 * @author ClaudioDuran
 */
public enum Apellidos {
    
    Ap1("Planas", 1), 
Ap2("Espada-Rocha", 2), 
Ap3("Colomer Cabello", 3), 
Ap4("Segovia", 4), 
Ap5("Alba Blasco", 5), 
Ap6("Paniagua Múñiz", 6), 
Ap7("Salva Castilla", 7), 
Ap8("Arteaga Belda", 8), 
Ap9("Benavides Salas", 9), 
Ap10("Valera Martorell", 10), 
Ap11("Varela Velázquez", 11), 
Ap12("Pereira Prada", 12), 
Ap13("Riba Mercader", 13), 
Ap14("Alba Berenguer", 14), 
Ap15("Mendizábal Alonso", 15), 
Ap16("Escudero Ávila", 16), 
Ap17("Cepeda", 17), 
Ap18("Manjón", 18), 
Ap19("Corbacho", 19), 
Ap20("Lorenzo Lago", 20), 
Ap21("Mora Requena", 21), 
Ap22("Mir Casas", 22), 
Ap23("de Saez", 23), 
Ap24("Otero Marin", 24), 
Ap25("Garrido Gallego", 25), 
Ap26("Mendoza Hervia", 26), 
Ap27("Patiño Pou", 27), 
Ap28("del Roura", 28), 
Ap29("Duran Torres", 29), 
Ap30("Nuñez-Robles", 30), 
Ap31("Duran Matrero", 31), 
Ap32("Ballesteros-Bonilla", 32), 
Ap33("Lledó-Bermúdez", 33), 
Ap34("Villena", 34), 
Ap35("Escribano", 35), 
Ap36("Pons", 36), 
Ap37("Pedraza", 37), 
Ap38("Múñiz Lladó", 38), 
Ap39("Quevedo Rebollo", 39), 
Ap40("Hervia Pi", 40);

private String nombre;
private int numeroApellido;

    private Apellidos() {
    }

    private Apellidos(String nombre, int numeroApellido) {
        this.nombre = nombre;
        this.numeroApellido = numeroApellido;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroApellido() {
        return numeroApellido;
    }
 
}
