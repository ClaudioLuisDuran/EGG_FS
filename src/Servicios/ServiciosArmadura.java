package Servicios;

import Entidades.Armadura;
import Entidades.Bota;
import Entidades.Casco;
import Entidades.Guante;
import Entidades.Objetos;
import java.util.Random;
import java.util.Scanner;

/**
 * @author ClaudioDuran
 */
public class ServiciosArmadura {

    Armadura IronMan = new Armadura();
    Objetos[][][] radar = new Objetos[30][30][30];

    //Creo Armadura completa e inicializo radar
    public void crearArmadura() {
        Bota b1 = new Bota();
        Bota b2 = new Bota();
        Guante g1 = new Guante();
        Guante g2 = new Guante();
        Casco c = new Casco();

        IronMan.setG1(g1);
        IronMan.setG2(g2);
        IronMan.setB1(b1);
        IronMan.setB2(b2);
        IronMan.setC(c);

        // Inicializo radar
        this.radar();
    }
    Scanner leer;
    //Mostrar informe de Armadura

    public void jarvisMenu() {
        // Resta consumo por uso de Consola
        leer = new Scanner(System.in).useDelimiter("\n");
        char opc;
        int kms;
        String seguir;
        // Arma armadura
        this.crearArmadura();
        this.restarConsumoEnergia(IronMan.getC().getConsumoConsola());
        System.out.println("Armadura creada y operativa...");
        System.out.println("Radar operativo...");
        System.out.println("Sistemas on line...");
        System.out.println("Bienvenido y a tu servicio.");
        System.out.println("");
        System.out.println("Presiona ENTER para desplegar Menú principal.");
        try {
            seguir = leer.nextLine();
        } catch (Exception e) {
        }

        // Despliega Menú
        do {

            System.out.println("-----------------------   J.A.R.V.I.S.  -----------------------");
            System.out.println("                         Menú principal");
            System.out.println("----------------------------------------------------------------");
            System.out.println("        1. Estado de la armadura.\n"
                    + "        2. Revisar Armadura y reparar daños.\n"
                    + "        3. Mostrar Radar.\n"
                    + "        4. Atacar.\n"
                    + "        5. Caminar hacia objetivo.\n"
                    + "        6. Correr hacia objetivo.\n"
                    + "        7. Volar hacia objetivo.\n"
                    + "        8. Propulsar hacia objetivo.\n"
                    + "        9. Reescanar Radar.\n"
                    + "        X. Desarmar y salir.");
            opc = leer.next().charAt(0);

            switch (opc) {
                case '1':
                    this.jarvis();
                    break;
                case '2':
                    this.revisarDispositivos();
                    break;
                case '3':
                    this.mostrarRadar();
                    break;
                case '4':
                    System.out.println("Enemigo a la vista.");
                    this.ataque(opc);
                    break;
                case '5':
                    System.out.println("Caminar hacia objetivo.");
                    System.out.println("¿A cuantos kms. se encuentra el objetivo?:");
                    kms = leer.nextInt();
                    this.caminar(kms);
                    break;
                case '6':
                    System.out.println("Correr hacia objetivo.");
                    System.out.println("¿A cuantos kms. se encuentra el objetivo?:");
                    kms = leer.nextInt();
                    this.correr(kms);
                    break;
                case '7':
                    System.out.println("Volar hacia objetivo.");
                    System.out.println("¿A cuantos kms. se encuentra el objetivo?:");
                    kms = leer.nextInt();
                    this.volar(kms);
                    break;
                case '8':
                    System.out.println("Propulsar hacia objetivo.");
                    System.out.println("¿A cuantos kms. se encuentra el objetivo?:");
                    kms = leer.nextInt();
                    this.correr(kms);
                    break;
                case '9':
                    this.radar();
                    System.out.println("Scanner en proceso...");
                    System.out.println("Detección:");
                    this.mostrarRadar();
                    break;
                case 'x':
                case 'X':
                    System.out.println("Hibernando sistemas....");
                    System.out.println("Sistemas hibernados...");
                    System.out.println("Desarmando armadura...");
                    System.out.println("El sistema se ha desconectado satisfactoriamente. ");
                    System.out.println("Hasta la próxima aventura!");
                    break;
                default:
                    System.out.println("La opción ingresada no existe.");
            }
            seguir = null;
        } while (opc != 'X' && opc != 'x');

    }

    public void jarvis() {
        leer = new Scanner(System.in).useDelimiter("\n");
        // Resta consumo por uso de Consola
        this.restarConsumoEnergia(IronMan.getC().getConsumoConsola());
        // Probabilidad de daño por uso del casco
        IronMan.getC().setDanio(this.probabilidadDanio());

        // Mostrar datos actualizados
        System.out.println("-----------------------   J.A.R.V.I.S.  -----------------------");
        System.out.println("            Informe de estado de la Armadura");
        System.out.println("----------------------------------------------------------------");
        System.out.println("     Energía total: " + IronMan.getEnergiaTotal() + "\n"
                + "     Resistencia: " + IronMan.getResistencia() + "\n"
                + "     Salud: " + IronMan.getSalud() + ".");
        IronMan.bateria();

        // Datos Guante 1
        System.out.println("     ------------\n"
                + "     Guante 1\n"
                + "     ------------\n"
                + "            Consumo x km.: " + IronMan.getG1().getConsumo());
        if (IronMan.getG1().isDanio() == false && IronMan.getG1().isSalud() == true) {
            System.out.println("            Estado del Guante 1: Operativo. ");
        } else if (IronMan.getG1().isDanio() == true && IronMan.getG1().isSalud() == true) {
            System.out.println("            Estado del Guante 1: Dañado. Debe ser reparado..");
        } else {
            System.out.println("            Estado del Guante 1: Destruido.");
        }
        if (IronMan.getG1().isRepulsor() == true) {
            System.out.println("            Estado del Repulsor: Operativo. ");
        } else {
            System.out.println("            Estado del Repulsor: Dañado. Debe ser reparado.. ");
        }

        // Datos Guante 2
        System.out.println("     ------------\n"
                + "     Guante 2\n"
                + "     ------------\n"
                + "            Consumo x km.: " + IronMan.getG2().getConsumo());
        if (IronMan.getG2().isDanio() == false && IronMan.getG2().isSalud() == true) {
            System.out.println("            Estado del Guante 2: Operativo. ");
        } else if (IronMan.getG2().isDanio() == true && IronMan.getG2().isSalud() == true) {
            System.out.println("            Estado del Guante 2: Dañado. Debe ser reparado..");
        } else {
            System.out.println("            Estado del Guante 2: Destruido.");
        }
        if (IronMan.getG2().isRepulsor() == true) {
            System.out.println("            Estado del Repulsor: Operativo. ");
        } else {
            System.out.println("            Estado del Repulsor: Dañado. Debe ser reparado.. ");
        }

        // Datos Bota 1
        System.out.println("     ------------\n"
                + "     Bota 1\n"
                + "     ------------\n"
                + "            Consumo x km.: " + IronMan.getB1().getConsumo());
        if (IronMan.getB1().isDanio() == false && IronMan.getB1().isSalud() == true) {
            System.out.println("            Estado de Bota 1: Operativo. ");
        } else if (IronMan.getB1().isDanio() == true && IronMan.getB1().isSalud() == true) {
            System.out.println("            Estado de Bota 1: Dañado. Debe ser reparado..");
        } else {
            System.out.println("            Estado de Bota 1: Destruido.");
        }
        if (IronMan.getB1().isPropulsor() == true) {
            System.out.println("            Estado del Propulsor: Operativo. ");
        } else {
            System.out.println("            Estado del Propulsor: Dañado. Debe ser reparado.. ");
        }

        // Datos Bota 2
        System.out.println("     ------------\n"
                + "     Bota 2\n"
                + "     ------------\n"
                + "            Consumo x km.: " + IronMan.getB2().getConsumo());
        if (IronMan.getB2().isDanio() == false && IronMan.getB2().isSalud() == true) {
            System.out.println("            Estado de Bota 2: Operativo. ");
        } else if (IronMan.getB2().isDanio() == true && IronMan.getB2().isSalud() == true) {
            System.out.println("            Estado del Bota 2: Dañado. Debe ser reparado..");
        } else {
            System.out.println("            Estado del Bota 2: Destruido.");
        }
        if (IronMan.getB2().isPropulsor() == true) {
            System.out.println("            Estado del Propulsor: Operativo. ");
        } else {
            System.out.println("            Estado del Propulsor: Dañado. Debe ser reparado.. ");
        }

        // Datos Casco
        System.out.println("     ------------\n"
                + "     Casco\n"
                + "     ------------\n"
                + "            Consumo por uso: " + IronMan.getC().getConsumo());
        if (IronMan.getC().isDanio() == false && IronMan.getC().isSalud() == true) {
            System.out.println("            Estado de Casco: Operativo. ");
        } else if (IronMan.getC().isDanio() == true && IronMan.getC().isSalud() == true) {
            System.out.println("            Estado del Casco: Dañado. Debe ser reparado..");
        } else {
            System.out.println("            Estado del Casco: Destruido.");
        }
        System.out.println("            Consumo x uso de Consola: " + IronMan.getC().getConsumoConsola() + "\n"
                + "            Consumo x uso de Sintetizador: " + IronMan.getC().getConsumoSintetizador() + ".");

        System.out.println("Presiona ENTER para volver al Menú Principal de J.A.R.V.I.S.");
        String espera = leer.nextLine();
    }

    public void restarConsumoEnergia(int consumo) {
        IronMan.setEnergiaTotal(IronMan.getEnergiaTotal() - consumo);
    }

    public void caminar(int distancia) {
        int consumo = IronMan.getB1().getConsumo() * distancia * 2;
        IronMan.getB1().setDanio(this.probabilidadDanio());
        IronMan.getB2().setDanio(this.probabilidadDanio());
        this.restarConsumoEnergia(consumo);
        System.out.println("Caminar: Objetivo alcanzado...");
    }

    public void correr(int distancia) {
        //doble de la energia gastada al caminar
        int consumo = IronMan.getB1().getConsumo() * distancia * 4;
        IronMan.getB1().setDanio(this.probabilidadDanio());
        IronMan.getB2().setDanio(this.probabilidadDanio());
        this.restarConsumoEnergia(consumo);
        System.out.println("Correr: Objetivo alcanzado...");
    }

    public void propulsar(int distancia) {
        //triple de la energia gastada al caminar
        int consumo = IronMan.getB1().getConsumo() * distancia * 6;
        IronMan.getB1().setDanio(this.probabilidadDanio());
        IronMan.getB2().setDanio(this.probabilidadDanio());
        IronMan.getB1().setPropulsor(this.probabilidadDanio());
        IronMan.getB2().setPropulsor(this.probabilidadDanio());
        this.restarConsumoEnergia(consumo);
        System.out.println("Propulsar: Objetivo alcanzado...");
    }

    public void volar(int distancia) {
        //triple de la energia gastada al caminar con botas + doble de energia guantes
        int consumo = (IronMan.getB1().getConsumo() * distancia * 6) + (IronMan.getG1().getConsumo() * 4);
        IronMan.getB1().setDanio(this.probabilidadDanio());
        IronMan.getB2().setDanio(this.probabilidadDanio());
        IronMan.getG1().setDanio(this.probabilidadDanio());
        IronMan.getG2().setDanio(this.probabilidadDanio());
        IronMan.getG1().setRepulsorr(this.probabilidadDanio());
        IronMan.getG2().setRepulsorr(this.probabilidadDanio());
        this.restarConsumoEnergia(consumo);
        System.out.println("Volar: Objetivo alcanzado...");
    }

    public void ataque(int tpo) {
        leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Presionar ENTER para iniciar secuencia de ataque.");
        String espera = leer.nextLine();

        System.out.println("Ingrese las coordenadas de ataque:");
        System.out.print("Coordenada X: ");
        int x = leer.nextInt();
        System.out.print("Coordenada Y: ");
        int y = leer.nextInt();
        System.out.print("Coordenada Z: ");
        int z = leer.nextInt();

        if (radar[x][y][z].isHostil() == true) {
            //calculo mayor distancia
            int distancia = x;
            if (distancia < y) {
                distancia = y;
            }
            if (distancia < z) {
                distancia = z;
            }
            int danio;
            if (distancia > 10) {
                danio = 10;
            } else if (distancia <= 10 && distancia > 5) {
                danio = 20;
            } else {
                danio = 30;
            }
            System.out.println("Enemigo en la mira! Comienza el ataque!");
            System.out.println("Distancia de ataque: " + distancia + " Kms.");
            int ataques =0;
            do {
                // Movimientos pre ataque para disminuir energia
                this.correr(5); // kms
                this.propulsar(3); // kms
                this.volar(4); // kms
                int consumo;
                // ataque con dos guantes
                if (IronMan.getG1().isSalud() == true && IronMan.getG2().isSalud() == true) {
                    // triple consumo energia de los guantes
                    consumo = IronMan.getG1().getConsumo() * 6;
                    consumo = consumo * tpo; // Tiempo en minutos
                    System.out.println("Ataque con ambos Guantes!!!");
                    radar[x][y][z].setResistencia(radar[x][y][z].getResistencia() - danio);
                    this.restarConsumoEnergia(consumo);
                    IronMan.getG1().setDanio(this.probabilidadDanio());
                    IronMan.getG2().setDanio(this.probabilidadDanio());
                    ataques++;
                } 
                // ataque con solo un guante
                else if (IronMan.getG1().isSalud() == true || IronMan.getG2().isSalud() == true) {
                    // triple consumo energia del guante usado
                    consumo = IronMan.getG1().getConsumo() * 3;
                    consumo = consumo * tpo; // Tiempo en minutos
                    System.out.println("Ataque con un solo Guante!");
                    radar[x][y][z].setResistencia(radar[x][y][z].getResistencia() - (danio/2));
                    this.restarConsumoEnergia(consumo);
                    if (IronMan.getG1().isDanio()==true) {
                        IronMan.getG1().setDanio(this.probabilidadDanio());
                    }
                    if (IronMan.getG2().isDanio()==true) {
                        IronMan.getG2().setDanio(this.probabilidadDanio());
                    }
                    ataques++;
                } else {
                    System.out.println("Lamentablemente no puedes iniciar ningún ataque pues tienes destruido ambos guantes.");
                    System.out.println("Jubilate....");
                    break;
                }
            } while (radar[x][y][z].getResistencia() > 0); // vuelve a atacar hasta destruirlo
            radar[x][y][z].setHostil(false);
            System.out.println("Excelente! Enemigo destruido en "+ataques+" ataques!");
        } else {
            System.out.println("En esa coordenada no hay ningún enemigo. ");

        }
    }

    public boolean probabilidadDanio() {
        boolean danio;
        Random aleatorio = new Random();
        int num1 = aleatorio.nextInt(10);
        danio = num1 < 4; // 30% de posibilidades
        return danio;
    }

    public void revisarDispositivos() {
        // Orden de revision: 1 casco, 2 Guante1, 3 Guante 2, 4 Bota 1,, 5 Bota 2
        int intentos = 1; // cantidad de intentos de arreglo antes de declarar destruido
        for (int i = 1; i < 6; i++) {
            switch (i) {

                // Revisión de Casco        
                case 1:
                    if (IronMan.getC().isDanio() == true && IronMan.getC().isSalud() == true) {
                        do {
                            System.out.println("Intento de reparación de Casco: " + intentos);
                            IronMan.getC().setDanio(this.reparar());
                            intentos++;
                            if (intentos > 3) {
                                IronMan.getC().setSalud(false);
                                System.out.println("El dispositivo Casco está destruido. Ya no hay posibilidad de reparación.");
                                IronMan.setSalud(IronMan.getSalud() - 20);
                                break;
                            }
                        } while (IronMan.getC().isDanio() == true && intentos <= 3);
                    } else if (IronMan.getC().isSalud() == false) {
                        System.out.println("El dispositivo Casco está destruido. Ya no hay posibilidad de reparación.");
                    }
                    break;

                // Revisión de Guante 1 y su Repulsor                    
                case 2:
                    if (IronMan.getG1().isDanio() == true && IronMan.getG1().isSalud() == true) {
                        do {
                            System.out.println("Intento de reparación de Guante 1: " + intentos);
                            IronMan.getG1().setDanio(this.reparar());
                            intentos++;
                            if (intentos > 3) {
                                IronMan.getG1().setSalud(false);
                                System.out.println("El dispositivo Guante 1 está destruido. Ya no hay posibilidad de reparación.");
                                IronMan.setSalud(IronMan.getSalud() - 20);
                                break;
                            }
                        } while (IronMan.getG1().isDanio() == true && intentos <= 3);
                    } else if (IronMan.getG1().isSalud() == false) {
                        System.out.println("El dispositivo Guante 1 está destruido. Ya no hay posibilidad de reparación.");
                    }

                    // Revision de repulsor de Guante 2
                    if (IronMan.getG1().isRepulsor() == false) {
                        // Intentar reparar
                        int inte = 1;
                        do {
                            System.out.println("Intento de reparación de Repulsor de Guante 1: " + intentos);
                            IronMan.getG1().setRepulsorr(this.reparar());
                            inte++;
                            if (inte > 3 && IronMan.getG1().isRepulsor() == false) {
                                System.out.println("El dispositivo Repulsor del Guante 1 no pudo ser reparado.");
                                IronMan.setSalud(IronMan.getSalud() - 20);
                                break;
                            }
                        } while (IronMan.getG1().isRepulsor() == false && intentos <= 3);
                    }
                    break;

                // Revisión de Guante 2 y su Repulsor                  
                case 3:
                    if (IronMan.getG2().isDanio() == true && IronMan.getG2().isSalud() == true) {
                        do {
                            System.out.println("Intento de reparación de Guante 2: " + intentos);
                            IronMan.getG2().setDanio(this.reparar());
                            intentos++;
                            if (intentos > 3) {
                                IronMan.getG2().setSalud(false);
                                System.out.println("El dispositivo Guante 2 está destruido. Ya no hay posibilidad de reparación.");
                                IronMan.setSalud(IronMan.getSalud() - 20);
                                break;
                            }
                        } while (IronMan.getG2().isDanio() == true && intentos <= 3);
                    } else if (IronMan.getG2().isSalud() == false) {
                        System.out.println("El dispositivo Guante 2 está destruido. Ya no hay posibilidad de reparación.");
                    }

                    // Revision de repulsor de Guante 2
                    if (IronMan.getG2().isRepulsor() == false) {
                        // Intentar reparar
                        int inte = 1;
                        do {
                            System.out.println("Intento de reparación de Repulsor de Guante 1: " + intentos);
                            IronMan.getG2().setRepulsorr(this.reparar());
                            inte++;
                            if (inte > 3 && IronMan.getG2().isRepulsor() == false) {
                                System.out.println("El dispositivo Repulsor del Guante 1 no pudo ser reparado.");
                                IronMan.setSalud(IronMan.getSalud() - 20);
                                break;
                            }
                        } while (IronMan.getG2().isRepulsor() == false && intentos <= 3);
                    }
                    break;

// Revisión de Bota 1 y su Propulsor     
                case 4:
                    if (IronMan.getB1().isDanio() == true && IronMan.getB1().isSalud() == true) {
                        do {
                            System.out.println("Intento de reparación de Bota 1: " + intentos);
                            IronMan.getB1().setDanio(this.reparar());
                            intentos++;
                            if (intentos > 3) {
                                IronMan.getB1().setSalud(false);
                                System.out.println("El dispositivo Bota 1 está destruido. Ya no hay posibilidad de reparación.");
                                IronMan.setSalud(IronMan.getSalud() - 20);
                                break;
                            }
                        } while (IronMan.getB1().isDanio() == true && intentos <= 3);
                    } else if (IronMan.getB1().isSalud() == false) {
                        System.out.println("El dispositivo Bota 1 está destruido. Ya no hay posibilidad de reparación.");
                    }

                    // Revision de Propulsor de Bota 1
                    if (IronMan.getB1().isPropulsor() == false) {
                        // Intentar reparar
                        int inte = 1;
                        do {
                            System.out.println("Intento de reparación de de Propulsor de Bota 1: " + intentos);
                            IronMan.getB1().setPropulsor(this.reparar());
                            inte++;
                            if (inte > 3 && IronMan.getB1().isPropulsor() == false) {
                                System.out.println("El dispositivo de Propulsor de Bota 1 no pudo ser reparado.");
                                IronMan.setSalud(IronMan.getSalud() - 20);
                                break;
                            }
                        } while (IronMan.getB1().isPropulsor() == false && intentos <= 3);
                    }

                    break;

                // Revisión de Bota 2 y su Propulsor   
                case 5:
                    if (IronMan.getB2().isDanio() == true && IronMan.getB2().isSalud() == true) {
                        do {
                            System.out.println("Intento de reparación de Bota 2: " + intentos);
                            IronMan.getB2().setDanio(this.reparar());
                            intentos++;
                            if (intentos > 3) {
                                IronMan.getB2().setSalud(false);
                                System.out.println("El dispositivo Bota 2 está destruido. Ya no hay posibilidad de reparación.");
                                IronMan.setSalud(IronMan.getSalud() - 20);
                                break;
                            }
                        } while (IronMan.getB2().isDanio() == true && intentos <= 3);
                    } else if (IronMan.getB2().isSalud() == false) {
                        System.out.println("El dispositivo Bota 2 está destruido. Ya no hay posibilidad de reparación.");
                    }

                    // Revision de Propulsor de Bota 2
                    if (IronMan.getB2().isPropulsor() == false) {
                        // Intentar reparar
                        int inte = 1;
                        do {
                            System.out.println("Intento de reparación de Propulsor de Bota 2: " + intentos);
                            IronMan.getB2().setPropulsor(this.reparar());
                            inte++;
                            if (inte > 3 && IronMan.getB2().isPropulsor() == false) {
                                System.out.println("El dispositivo Propulsor de Bota 2 no pudo ser reparado.");
                                IronMan.setSalud(IronMan.getSalud() - 20);
                                break;
                            }
                        } while (IronMan.getB2().isPropulsor() == false && intentos <= 3);
                    }

                    break;
            }
        }

    }

    public boolean reparar() {

        boolean reparacion;
        Random aleatorio = new Random();
        int num1;
        // disminuye 50 de energia n cada intento de reparacion
        IronMan.setEnergiaTotal(IronMan.getEnergiaTotal() - 50);
        num1 = aleatorio.nextInt(10);
        reparacion = num1 < 5;
        return reparacion;
    }

    // Inicializar radar y objetos
    public void radar() {

        Objetos obVacio = new Objetos();
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                for (int k = 0; k < 30; k++) {
                    obVacio.setX(i);
                    obVacio.setY(j);
                    obVacio.setZ(k);
                    obVacio.setHostil(false);
                    radar[i][j][k] = obVacio;
                }
            }
        }
        // crear 10 objetos y colocarlos al azar.
        for (int i = 1; i < 11; i++) {
            Objetos ob = new Objetos();
            Random r = new Random();
            int x = r.nextInt(10);
            int y = r.nextInt(10);
            int z = r.nextInt(10);
            int hostil = r.nextInt(3);
            ob.setX(x);
            ob.setY(y);
            ob.setZ(z);
            if (hostil <= 1 || (x == 15 && y == 15 && z == 15)) {
                ob.setHostil(false);
            } else {
                ob.setHostil(true);
            }
            radar[x][y][z] = ob;
//            System.out.println("x:" + x + ", y: " + y + ", z: " + z + " >> " + radar[x][y][z].isHostil());
        }
    }

    public void mostrarRadar() {

        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                for (int k = 0; k < 30; k++) {
                    if (radar[i][j][k].isHostil() == true) {
                        System.out.print("Posición [" + i + "][" + j + "][" + k + "]: Enemigo detectado!");
                        System.out.println("");
                    }
                }
            }
        }
        System.out.println("Presiona ENTER para volver al menú Principal.");
        String espera = leer.nextLine();
    }
}
