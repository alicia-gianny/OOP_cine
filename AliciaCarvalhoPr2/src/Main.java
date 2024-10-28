import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // crear un cine
        // crear dos salas y añadelas al cine
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

        switch (opcion) {
            case 1: // AÑADIR PELICULA
                // solicita por consola el titulo, genero y duracion para crear la pelicula
                // muestra las salas vacias disponibles y solocita en que sala proyectar la pelicula
                break;
                case 2: // ELIMINAR PELICULA
                    // muestras las peliculas que actualmente se encuentran enlas distintas salas
                    // pergunta al usuario que peli eliminar
                    break;
                    case 3: // CREAR SESION
                        // muestra las salas que tienen actualmente asignadas peliculas y solicita una sala,
                        // precio y hora
                        // crea la sesion en el cine
                        break;
                        case 4: // MOSTRAR ESTADO DE UNA SESION
                            // muestra las distintas sesiones disponibles en el cine y pide al usuario que selecione una
                            // muestra graficamente por consola el estado actual de ocupacion
                            break;
                            case 5: // COMPRAR ENTRADAS
                                break;
                                case 6: // VER RECAUDACION
                                    break;
                                    case 7: // SALIR
                                        break;
                                default:
        }

    }
}