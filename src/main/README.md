README

*Integrantes del Grupo*
-

-Luis Contreras (cuenta Git: "lui5swev", git del repositorio) (Encargado de Validaciones y Unit Testing)


-José Matus(cuenta Git: "elheknous") (Encargado de refactorizar el código y Orden de Métodos )

Ambos analizamos la problemática e identificación de errores.



*Errores en el código:*
-
-Todo el código en el Main (malas prácticas)

-Tipos incompatibles en la creación de arrays

    ej: String [][] registro = new double[50][3];
-Mala implementación del Scanner

    edad = new Scanner(System.in).nextLine();
-Arrays usados sin haberlos creado, ()

    for (double [] persona : registro) {
        if (persona[2] >= 18) mayoresDeEdad++;
    }

-Variables poco descriptivas ("a" podría haber sido contador)

    int a = -1;

-Variables implementadas mal o usadas varias veces en distintos contextos

    int a = -1 //va en el bucle general no el señalado abajo donde se usa "a"
    do {
        try {
            a = new Scanner(System.in).nextInt();
        } catch (InputMismatchException e) {   
            System.err.println("Opción inválida");
        }
    }while (a > 0 || a < 6);

-