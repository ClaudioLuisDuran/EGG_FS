package Enumeraciones;

/**
 * @author ClaudioDuran
 */
public enum Nombres {

    Nom1("Melisa", 1),
    Nom2("Lupita", 2),
    Nom3("Maricela", 3),
    Nom4("Herberto", 4),
    Nom5("Glauco", 5),
    Nom6("Eva", 6),
    Nom7("Juan Francisco", 7),
    Nom8("Reyna", 8),
    Nom9("Jacinto Anastasio", 9),
    Nom10("Ema", 10),
    Nom11("Godofredo", 11),
    Nom12("Flavio", 12),
    Nom13("Nicanor", 13),
    Nom14("Esmeralda", 14),
    Nom15("Reina Flavia", 15),
    Nom16("Milagros", 16),
    Nom17("Bernabé Esteban", 17),
    Nom18("Amada", 18),
    Nom19("Ana Carina", 19),
    Nom20("Abril", 20),
    Nom21("Felisa", 21),
    Nom22("Florencio", 22),
    Nom23("Basilio", 23),
    Nom24("Blanca", 24),
    Nom25("Aureliano", 25),
    Nom26("Carmela", 26),
    Nom27("Segismundo", 27),
    Nom28("Tomás", 28),
    Nom29("Lupita", 29),
    Nom30("Imelda", 30),
    Nom31("Corona", 31),
    Nom32("Macario", 32),
    Nom33("Narcisa", 33),
    Nom34("Azahar", 34),
    Nom35("María Belén", 35),
    Nom36("Olalla", 36),
    Nom37("Cosme", 37),
    Nom38("Eufemia", 38),
    Nom39("Anastasio", 39),
    Nom40("Matías", 40);

    private String nombre;
    private int numeroNombre;

    private Nombres() {
    }

    private Nombres(String nombre, int numeroNombre) {
        this.nombre = nombre;
        this.numeroNombre = numeroNombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroNombre() {
        return numeroNombre;
    }

}
