
package Servicios;

import Entidades.Asiento;
import Entidades.Cine;
import Entidades.Espectador;
import Entidades.Pelicula;
import static java.lang.Character.getNumericValue;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ClaudioDuran
 */
public class ServiciosCine {

    ServicioAsiento Sa = new ServicioAsiento();
    ServicioEspectador Se = new ServicioEspectador();
    ArrayList<Espectador> espectadores = new ArrayList();
    Cine cine = new Cine();
    Scanner leer;

    public void MenuCine() {
        leer = new Scanner(System.in).useDelimiter("\n");
        int opc;
        do {
            System.out.println("------- CINE GRAN SUR -------\n"
                    + "1. Crear Sala de cine.\n"
                    + "2. Mostrar Sala.\n"
                    + "3. Acomodar clientes (aut.)\n"
                    + "4. Vender una entrada.\n"
                    + "5. Vender varias entradas. \n"
                    + "6. Ver base de datos de clientes.\n"
                    + "7. Ver Datos de película exhibida.\n"
                    + "8. Cargar película en exhibición.\n"
                    + "9. Salir del menú.\n"
                    + "Elija su opción: ");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    this.crearSala();
                    break;
                case 2:
                    this.mostrarCine();
                    break;
                case 3:
                    this.acomodarAutomaticos();
                    break;
                case 4:
                    this.venderEntrada();
                    break;
                case 5:
                    this.venderVarias();
                    break;
                case 6:
                    Se.verClientes(espectadores);
                    break;
                case 7:
                    this.verPelicula();
                    break;
                case 8:
                    this.cargarPelicula();
                    break;
                case 9:
                    System.out.println("Adios. Lo esperamos!");
                    break;
                default:
                    System.out.println("La opción ingresada no es correcta.");
            }
        } while (opc != 9);
    }

    public void crearSala() {
        Asiento[][] nuevaSala = new Asiento[8][6];
        char columna = ' ';
        for (int i = 0; i < cine.getSala().length; i++) {
            for (int j = 0; j < cine.getSala()[0].length; j++) {
                switch (j) {
                    case 0:
                        columna = 'A';
                        break;
                    case 1:
                        columna = 'B';
                        break;
                    case 2:
                        columna = 'C';
                        break;
                    case 3:
                        columna = 'D';
                        break;
                    case 4:
                        columna = 'E';
                        break;
                    case 5:
                        columna = 'F';
                        break;
                }
                nuevaSala[i][j] = Sa.crearAsiento((8 - i), columna);
            }
        }
        cine.setSala(nuevaSala);
    }

    public void mostrarCine() {
        System.out.println("------- Cine Gran Sur -------");
        for (int i = 0; i < cine.getSala().length; i++) {
            for (int j = 0; j < cine.getSala()[0].length; j++) {
                System.out.print("|" + cine.getSala()[i][j].getFila() + cine.getSala()[i][j].getColumna() + cine.getSala()[i][j].getOcupado() + "|");
            }
            System.out.println("");
        }

    }

    public void acomodarAutomaticos() {
        boolean vacio;

        if (espectadores.isEmpty()) {
            espectadores = Se.espectadoresAutomaticos(cine);
            
            for (Espectador e : espectadores) {
                // Si espectador tiene dinero y edad suficiente
                if(e.getDinero()>=cine.getPrecio()||e.getEdad()>=cine.getPeliActual().getEdadMinima()){
                // elijo asiento aleatorio y veo si esta vacio, sino lo elijo de nuevo
                do {
                    int lugarFila = (int) (Math.random() * 8);
                    int lugarColumna = (int) (Math.random() * 6);
                    if (cine.getSala()[lugarFila][lugarColumna].getOcupado() == ' ') {
                        vacio = true;
                        cine.getSala()[lugarFila][lugarColumna].setOcupado('X');
                    } else {
                        vacio = false;
                    }
                } while (vacio == false);
                }
                
            }
        } else {
            System.out.println("El proceso de llenado automático ya se realizó.");
        }
        // muestro sala con asientos ocupados
        this.mostrarCine();
    }

    public void venderVarias() {
        int cant;
        System.out.println("¿Cuantas entradas comprarán?");
        cant = leer.nextInt();
        for (int i = 0; i < cant; i++) {
            this.venderEntrada();
        }
    }

    public void venderEntrada() {
        int vacios = 0;
        for (int i = 0; i < cine.getSala().length; i++) {
            for (int j = 0; j < cine.getSala()[0].length; j++) {
                if (cine.getSala()[i][j].getOcupado() == ' ') {
                    vacios++;
                }
            }
        }
        if (vacios > 0) {
            System.out.println("Quedan " + vacios + " asientos vacios. Le pediremos algunos datos.");
            //Cargo cliente
            Espectador nuevoEsp = Se.nuevoEspectador(cine.getPrecio());
            // chequeo si tiene dinero para el cine y si tiene edad
            if (nuevoEsp.getDinero() > cine.getPrecio()&&nuevoEsp.getEdad()>=cine.getPeliActual().getEdadMinima()) {

                //vendo ubicación
                System.out.println("Excelente! Ahora elija su ubicación.");
                boolean ocupado;
                this.mostrarCine();
                String ub;
                System.out.println("Ubicacion:");
                do {
                    ocupado = false;
                    ub = leer.next();
                    int fil = getNumericValue(ub.charAt(0));
                    int fila = 0;
                    switch (fil) {
                        case 8:
                            fila = 0;
                            break;
                        case 7:
                            fila = 1;
                            break;
                        case 6:
                            fila = 2;
                            break;
                        case 5:
                            fila = 3;
                            break;
                        case 4:
                            fila = 4;
                            break;
                        case 3:
                            fila = 5;
                            break;
                        case 2:
                            fila = 6;
                            break;
                        case 1:
                            fila = 7;
                            break;
                    }
                    char col = (char) (ub.charAt(1));
                    System.out.println("col: " + col);
                    int columna = 0;
                    //ver columna:
                    switch (col) {
                        case ('A'):
                        case ('a'):
                            columna = 0;
                            break;
                        case 'B':
                        case ('b'):
                            columna = 1;
                            break;
                        case 'C':
                        case ('c'):
                            columna = 2;
                            break;
                        case 'D':
                        case ('d'):
                            columna = 3;
                            break;
                        case 'E':
                        case ('e'):
                            columna = 4;
                            break;
                        case 'F':
                        case ('f'):
                            columna = 5;
                            break;
                    }
                    if (cine.getSala()[fila][columna].getOcupado() == ' ') {
                        cine.getSala()[fila][columna].setOcupado('X');
                        System.out.println("Fila:" + fila + " Columna: " + columna);
                        System.out.println("El asiento " + cine.getSala()[fila][columna].getFila() + cine.getSala()[fila][columna].getColumna() + " es suyo. Que disfrute la pelicula!");
                    } else {
                        System.out.println("Fila:" + fila + " Columna: " + columna);
                        System.out.println("El asiento " + cine.getSala()[fila][columna].getFila() + cine.getSala()[fila][columna].getColumna() + " está ocupado. Elija otro.");
                        ocupado = true;
                    }

                } while (ocupado == true);

                // cobro entrada
                nuevoEsp.setDinero(nuevoEsp.getDinero() - cine.getPrecio());
            } else{
                System.out.println("Lo siento. La película en exhibición es para personas desde "+cine.getPeliActual().getEdadMinima()+" años.\n"
                        + "Nos vemos en Disney ;)");
            }
            }else {
                System.out.println("Lamentablemente no quedan lugares disponibles.");
        }
    }

    public void cargarPelicula() {
        Pelicula pelicula = new Pelicula();
        leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingreso de pelicula para exhibición");
        System.out.println("Título:");
        pelicula.setTitulo(leer.next());
        System.out.println("Director:");
        pelicula.setDirector(leer.next());
        System.out.println("Duración (minutos)");
        pelicula.setDuracion(leer.nextInt());
        System.out.println("Edad mínima del espectador:");
        pelicula.setEdadMinima(leer.nextInt());
        cine.setPeliActual(pelicula);
        System.out.println("Precio de la entrada: $");
        cine.setPrecio(leer.nextInt());
    }
    
    
    public void verPelicula(){

        System.out.println("------ CINE GRAN SUR -------");
        System.out.println("     *** Esta semana ***");
        System.out.println("**   "+cine.getPeliActual().getTitulo()+"   **");
        System.out.println(" Dirigida por "+cine.getPeliActual().getDirector()+".");
        System.out.println("    (Calificación: + "+cine.getPeliActual().getEdadMinima()+" años)");
     
    }
}
