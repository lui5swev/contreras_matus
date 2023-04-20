import java.util.InputMismatchException;
import java.util.Scanner;

public class Registro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [][] matrizRegistro = new String[50][3]; ///error
        int opcion = -1; // variables con nombre poco identificativo

        do {
            System.out.println("""
                Menú
                1) Agregar persona.
                2) Mostrar la cantidad de personas mayores de edad.
                3) Mostrar la cantidad de personas menores de edad.
                4) Mostrar la cantidad de personas de tercera edad.
                5) Mostrar la cantidad de personas según estado civil (Soltero/opcion - Casado/opcion).
                6)Salir.
                """);




            do {
                try {
                    opcion = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.err.println("Opción inválida");
                }
            }while (opcion < 0 || opcion > 6); // mal codigo




            if(opcion == 1) {
                if(hayCupo(matrizRegistro)) {
                    int indiceDisponible = obtenerUltimoEspacio(matrizRegistro);
                    String nombre;
                    String Estadocivil;
                    String edad;




                    while(true) {
                        try {
                            nombre = new Scanner(System.in).nextLine();
                        } catch (InputMismatchException e) {
                            System.err.println("Opción inválida");
                            continue;
                        }
                        break;
                    }




                    while(true) {
                        try {
                            Estadocivil = sc.nextLine();
                        } catch (InputMismatchException e) {
                            System.err.println("Opción inválida");
                            continue;
                        }
                        break;
                    }




                    while(true) {
                        try {
                            edad = sc.nextLine();
                        } catch (InputMismatchException e) {
                            System.err.println("Opción inválida");
                            continue;
                        }
                        break;
                    }




                    matrizRegistro[indiceDisponible][0] = nombre;
                    matrizRegistro[indiceDisponible][1] = Estadocivil;
                    matrizRegistro[indiceDisponible][2] = edad;
                    System.out.println("Persona agregada.");
                } else {
                    System.out.println("No hay cupo.");
                }
            } else if(opcion == 2) {
                int mayoresDeEdad = 0;


                for (int i = 0; i < matrizRegistro.length; i++) {
                    if (matrizRegistro[i][2] >= 18){

                    }
                }




                System.out.println("Hay " + mayoresDeEdad + " mayores de edad.");
            } else if(opcion == 3) {
                int menoresDeEdad = 0;
                int queSera = obtenerUltimoEspacio(matrizRegistro);




                for (int i = 0; i < queSera; i++) {
                    if (matrizRegistro[i][2] < 18) menoresDeEdad++;
                }




                System.out.println("Hay " + menoresDeEdad + " menores de edad.");
            } else if(opcion == 4) {
                int mmmm = 0;




                for (double [] persona : matrizRegistro) {
                    if (persona[2] >= 60 && persona[1].equals("casado/opcion")) {
                        mmmm++;
                    } else if(persona[2] >= 65 && persona[1].equals("soltero/opcion")) {
                        mmmm++;
                    }
                }
                System.out.println("Hay " + mmmm + " personas de tercera edad");
            } else if(opcion == 5) {
                int c = 0;
                int d = 0;
                for(double[] persona : matrizRegistro) {
                    if(persona[1].equals("casado/opcion")) {
                        c++;
                    } else if(persona[1].equals("soltero/opcion")) {
                        d++;
                    }
                }




                System.out.println("Hay " + d + " casados/as.");
                System.out.println("Hay " + c + " solteros/as.");
            } else if(opcion == 6) {
                System.out.println("Programa finalizado");
            }
        }while (opcion == 6);
    }




    public static int obtenerUltimoEspacio(String [][] registro) {
        return registro.length - opa(registro);
    }




    public static boolean hayCupo(String [][] registro) {
        return opa(registro) != 0;
    }




    public static int opa(String [][] registro) {
        for(int i = 0; i < registro.length; i++) {
            if(registro[i][0].equals("")){
                return registro.length - i;
            }
        }




        return 0;
    }
}