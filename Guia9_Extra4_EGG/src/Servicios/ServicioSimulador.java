package Servicios;

import Entidades.Alumno;
import Entidades.Voto;
import Enumeraciones.Apellidos;
import Enumeraciones.Nombres;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

/**
 * @author ClaudioDuran
 */
public class ServicioSimulador implements Cloneable {

    ArrayList<Voto> votacion = new ArrayList(); // Array para guardar todos los votos.
    Scanner leer;

    public void menu(ArrayList<Alumno> listado, int cant) {
        leer = new Scanner(System.in).useDelimiter("\n");
        int opc;
        do {
            System.out.println("Menu Alumnos\n"
                    + "1. Generar listado de alumnos\n"
                    + "2. Generar DNIs de alumnos\n"
                    + "3. Generar 3 votos por alumno\n"
                    + "4. Mostrar datos alumnos\n"
                    + "5. Mostrar última votación\n"
                    + "8. Salir.");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    listado = this.generarAlumnos(cant);
                    break;
                case 2:
                    listado = this.generarDNI(listado);
                    break;
                case 3:

                    try {
                        listado = this.votarAutOK(listado);
                    } catch (CloneNotSupportedException e) {
                        // maneja la excepción aquí, pero no hace falta mientras sea automático
                    }
                    break;
                case 4:
                    this.mostrarAlumnos(listado);
                    break;
                case 5:
                    this.mostrarVotos();
                    break;
                case 8:
                    System.out.println("Salió del sistema.");
                    break;
                default:
                    System.out.println("Esa opcion no existe. No sea nabo....");
            }
        } while (opc != 8);
    }

    // Generar alumnos con nombres y apellidos aleatorios
    public ArrayList<Alumno> generarAlumnos(int cant) {
        ArrayList<Alumno> listado = new ArrayList();

        for (int i = 0; i < cant; i++) {
            Alumno nuevoAlumno = new Alumno();
            Random ran = new Random();
            Random ran2 = new Random();

            int x = ran.nextInt(39) + 1;
            int y = ran.nextInt(39) + 1;

            nuevoAlumno.setId(i);
            String nombreOK;
            String apellidoOK;
            for (Nombres nom : Nombres.values()) {
                if (nom.getNumeroNombre() == x) {
                    nombreOK = nom.getNombre();
                    nuevoAlumno.setNombre(nombreOK);
                }
            }
            for (Apellidos ap : Apellidos.values()) {
                if (ap.getNumeroApellido() == y) {
                    apellidoOK = ap.getNombre();
                    nuevoAlumno.setApellido(apellidoOK);
                }
            }
            listado.add(nuevoAlumno);
        }
        System.out.println("Los alumnos fueron generados de manera automática.");
        return listado;
    }

    // Generar DNIs aleatorios para el listado de alumnos previamente generado
    public ArrayList<Alumno> generarDNI(ArrayList<Alumno> lista) {
        for (Alumno alumno : lista) {
            long DNI = (long) (Math.random() * 40000000 + 10000000);
            alumno.setDni(DNI);
        }
        System.out.println("Se generó un DNI aleatorio para cada alumno.");
        return lista;
    }

    public ArrayList<Alumno> votarAutOK(ArrayList<Alumno> lista) throws CloneNotSupportedException {

        for (Alumno alumno : lista) {
            Voto voto = new Voto();
            HashSet<Alumno> alumnosVotados = new HashSet();
            for (int i = 0; i < 3; i++) {
                int x = (int) (Math.random() * (lista.size()));
                while (x == alumno.getId() || alumnosVotados.contains(lista.get(x))) {
                    x = (int) (Math.random() * (lista.size()));
                }
                Alumno alumnoVotado = lista.get(x);
                alumnoVotado.setVotosRecibidos(alumnoVotado.getVotosRecibidos() + 1);
                alumnosVotados.add(alumnoVotado);
            }
            voto.setAlumno(alumno);
            voto.setVotados(alumnosVotados);
            votacion.add((Voto) voto.clone());
        }
        System.out.println("Los votos fueron generados");
        return lista;
    }

    public void mostrarVotos() {
        System.out.println("Hay " + votacion.size() + " votos.");
        Iterator<Voto> it1 = votacion.iterator();
        while (it1.hasNext()) {
            Voto votoAux = it1.next();
            System.out.println("Alumno " + votoAux.getAlumno().getApellido() + " " + votoAux.getAlumno().getNombre() + ",");
            System.out.println("Ha votado por:");
            Iterator<Alumno> it2 = votoAux.getVotados().iterator();
            while (it2.hasNext()) {
                Alumno alumnAux = it2.next();
                System.out.println(alumnAux.getApellido() + " " + alumnAux.getNombre() + ", ");
            }
            System.out.println("");
        }
    }

    public void mostrarAlumnos(ArrayList<Alumno> listado) {
        for (Alumno alumno : listado) {
            System.out.println(alumno.getId() + ".- " + alumno.getNombre() + " " + alumno.getApellido() + ", DNI " + alumno.getDni() + ", " + alumno.getVotosRecibidos() + " votos recibidos.");
        }
    }

}
