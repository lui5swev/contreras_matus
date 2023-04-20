import java.util.InputMismatchException;
import java.util.Scanner;

public class Registro {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
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
                    Scanner sc = new Scanner(System.in);
                    opcion = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.err.println("Opción inválida");
                }
            }while (opcion < 1 || opcion > 6); // mal codigo




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
                            Scanner sc = new Scanner(System.in);

                            Estadocivil = sc.nextLine();
                        } catch (InputMismatchException e) {
                            System.err.println("Opción inválida");
                            continue;
                        }
                        break;
                    }




                    while(true) {
                        try {
                            Scanner sc = new Scanner(System.in);

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
                    if (Integer.parseInt(matrizRegistro[i][2]) >= 18){
                        mayoresDeEdad++;
                    }
                }




                System.out.println("Hay " + mayoresDeEdad + " mayores de edad.");
            } else if(opcion == 3) {
                int menoresDeEdad = 0;
                int queSera = obtenerUltimoEspacio(matrizRegistro);




                for (int i = 0; i < matrizRegistro.length; i++) {
                    if (Integer.parseInt(matrizRegistro[i][2]) < 18){
                        menoresDeEdad++;
                    }
                }




                System.out.println("Hay " + menoresDeEdad + " menores de edad.");
            } else if(opcion == 4) {
                int cantidadTerceraEdad = 0;

                for (int i = 0; i < matrizRegistro.length; i++) {
                    if (Integer.parseInt(matrizRegistro[i][2]) >= 65){
                        cantidadTerceraEdad++;
                    }
                }




                System.out.println("Hay " + cantidadTerceraEdad + " personas de tercera edad");


            } else if(opcion == 5) {
                int casado = 0;
                int soltero = 0;
                for (int i = 0; i < matrizRegistro.length; i++) {
                    if (matrizRegistro[i][1].equals(casado/opcion)){
                        casado++;

                    }else {
                        soltero++;
                    }
                }




                System.out.println("Hay " + casado + " casados/as.");
                System.out.println("Hay " + soltero + " solteros/as.");
            } else if(opcion == 6) {
                System.out.println("Programa finalizado");
            }
        }while (opcion == 6);
    }




    public static int obtenerUltimoEspacio(String [][] registro) {
        return registro.length - opa(registro);
    }




    public static boolean hayCupo(String [][] registro) {
        if (opa(registro) != 0){
            return true;
        }else {
            return false;
        }

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