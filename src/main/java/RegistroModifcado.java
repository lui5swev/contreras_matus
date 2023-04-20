import java.util.InputMismatchException;
import java.util.Scanner;

public class RegistroModifcado {
    public static void main(String[] args) {
        String[][] matrizRegistro = new String[50][3]; ///error
        menu(matrizRegistro);
    }

    private static void menu(String[][] matrizRegistro) {
        int opcion = 0;

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
            } while (opcion < 1 || opcion > 6);// mal codigo
            acciones(matrizRegistro, opcion);


        } while (opcion >= 1 && opcion < 6);
    }

    private static void acciones(String[][] matrizRegistro, int opcion) {
        if(opcion == 1) {
            matrizRegistro = agregarPersonas(matrizRegistro, opcion);
        }else if(opcion == 2) {
            int mayoresEdad = calculaMayores(matrizRegistro,opcion);
            System.out.println("hay: "+mayoresEdad+ " Mayores de edad");
        }else if(opcion == 3) {
            menoresEdad(matrizRegistro,opcion);
        }else if(opcion == 4) {
            terceraEdad(matrizRegistro,opcion);

        }else if(opcion == 5) {
            estaCivil(matrizRegistro,opcion);
        } else if(opcion == 6) {
            System.out.println("Programa finalizado");
        }


    }

    private static void estaCivil(String[][] matrizRegistro, int opcion) {
            int casado = 0;
            int soltero = 0;
            boolean vacio3 = false;
            for (int i = 0; i < matrizRegistro.length; i++) {
                vacio3 = revisarEspacio(i, matrizRegistro);
                if (!vacio3){
                    if (matrizRegistro[i][1].equals(casado / opcion)) {
                        casado++;

                    } else {
                        soltero++;
                    }
                }
            }



            System.out.println("Hay " + casado + " casados/as.");
            System.out.println("Hay " + soltero + " solteros/as.");

    }

    private static void terceraEdad(String[][] matrizRegistro, int opcion) {
            int cantidadTerceraEdad = 0;
            boolean vacio2 = false;

            for (int i = 0; i < matrizRegistro.length; i++) {
                vacio2 = revisarEspacio(i,matrizRegistro);
                if (!vacio2) {
                    if (Integer.parseInt(matrizRegistro[i][2]) >= 65) {
                        cantidadTerceraEdad++;
                    }
                }else {
                    break;
                }
            }



            System.out.println("Hay " + cantidadTerceraEdad + " personas de tercera edad");



    }

    private static void menoresEdad(String[][] matrizRegistro, int opcion) {
            int menoresDeEdad = 0;
            boolean vacio1 = false;
            for (int i = 0; i < matrizRegistro.length; i++) {
                vacio1 = revisarEspacio(i,matrizRegistro);
                if (!vacio1) {

                    if (Integer.parseInt(matrizRegistro[i][2]) < 18) {
                        menoresDeEdad++;
                    }
                }else {
                    break;
                }
            }



            System.out.println("Hay " + menoresDeEdad + " menores de edad.");
    }

    private static int calculaMayores(String[][] matrizRegistro, int opcion) {
            int mayoresDeEdad = 0;

            boolean vacio = false;
            for (int i = 0; i < matrizRegistro.length; i++) {
                vacio = revisarEspacio(i,matrizRegistro);
                if (!vacio){
                    if (Integer.parseInt(matrizRegistro[i][2]) >= 18){
                        mayoresDeEdad++;
                    }
                }else {
                    break;
                }

            }
            return mayoresDeEdad;
        }

    private static String[][] agregarPersonas(String[][] matrizRegistro, int opcion) {
        if(hayCupo(matrizRegistro)) {
            int indiceDisponible = obtenerUltimoEspacio(matrizRegistro);
            String nombre;
            String Estadocivil;
            String edad;
            while(true) {
                try {
                    System.out.println("Agregue el nombre: ");
                    nombre = new Scanner(System.in).nextLine();
                } catch (InputMismatchException e) {
                    System.err.println("Opción inválida");
                    continue;
                }
                break;
            }
            while(true) {
                try {
                    System.out.println("Estado civil: ");
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
                    System.out.println("Edad: ");
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
        return matrizRegistro;
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
            if(registro[i][0]==null){
                return registro.length - i;
            }
        }
        return 0;
    }

    public static int obtenerUltimoEspacio(String [][] registro) {
        return registro.length - opa(registro);
    }

    private static boolean revisarEspacio(int i, String[][] matrizRegistro) {
        if (matrizRegistro[i][0] == null){
            return true;
        }else {
            return false;
        }
    }
}

