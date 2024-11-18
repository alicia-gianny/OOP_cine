import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // VARIABLES DE ESTADO
        final int ANADIR_PELI = 1;
        final int ELIMINAR_PELI = 2;
        final int CREAR_SESION = 3;
        final int ESTADO_SESION = 4;
        final int COMPRAR_ENTRADAS = 5;
        final int RECAUDACION = 6;
        final int SALIR = 7;

        // crear un cine
        Cine cine  = new Cine("Cine Alicia", "Universidad de Jaen");

        // crear dos salas y añadelas al cine
        Sala sala1 = new Sala("1",10,10);
        Sala sala2 = new Sala("2",10,10);

        // crea un menu que permita ejecutar las funciones:
        System.out.println("-------------------------------");
        System.out.println("   BIENVENIDO AL CINE ALICIA   ");
        System.out.println("-------------------------------");
        System.out.println("Elija la opcion que desea hacer:");
        System.out.println("(1)  Añadir peliculas");
        System.out.println("(2)  Eliminar peliculas");
        System.out.println("(3)  Crear una sesion");
        System.out.println("(4)  Mostrar estado de sesion");
        System.out.println("(5)  Comprar entradas");
        System.out.println("(6)  Ver Recaudacion");
        System.out.println("(7)  Salir");
        System.out.println("--------------------------------");
        System.out.print("Opcion: ");
        int opcion = sc.nextInt();

        // MAQUINA DE ESTADO

        do {
            switch (opcion) {
                case ANADIR_PELI: // AÑADIR PELICULA

                    // solicita por consola el titulo, genero y duracion para crear la pelicula
                    // muestra las salas vacias disponibles y solicita en que sala proyectar la pelicula

                    System.out.println("\n------- OPCION: añadir peliculas -------\n");
                    System.out.println("\nTitulo: ");
                    String nombrePeli = sc.next();
                    System.out.println("\nDuracion (horas): ");
                    int duracion = sc.nextInt();
                    System.out.println("\nGenero: "); // puede ser SOLAMENTE "Drama", "Terror", "Comedia", "Ciencia Ficcion"
                    String genero = sc.next();
                    Pelicula pelicula = new Pelicula(nombrePeli, duracion, genero);

                    break;

                case ELIMINAR_PELI: // ELIMINAR PELICULA
                    // muestras las peliculas que actualmente se encuentran enlas distintas salas
                    // pergunta al usuario que peli eliminar
                    System.out.println("\neliminar peliculas\n");
                    break;

                case CREAR_SESION: // CREAR SESION
                    // muestra las salas que tienen actualmente asignadas peliculas y solicita una sala,
                    // precio y hora
                    // crea la sesion en el cine
                    System.out.println("\ncrear sesion\n");
                    break;

                case ESTADO_SESION: // MOSTRAR ESTADO DE UNA SESION
                    // muestra las distintas sesiones disponibles en el cine y pide al usuario que selecione una
                    // muestra graficamente por consola el estado actual de ocupacion
                    System.out.println("\nestado de sesion\n");
                    break;

                case COMPRAR_ENTRADAS: // COMPRAR ENTRADAS
                    System.out.println("\ncomprar entradas\n");
                    break;

                case RECAUDACION: // VER RECAUDACION
                    System.out.println("\nrecaudacion\n");
                    break;

                case SALIR: // SALIR
                    System.out.println("\nsaliendo\n");
                    break;

                default:
            }

            System.out.println("------------");
            System.out.println("\nOpción: ");
            opcion = sc.nextInt();
            System.out.println("------------");

        }while(opcion !=SALIR);

        System.out.println("Saliendo...");

    }
}