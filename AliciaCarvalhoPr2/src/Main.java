import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void menu(){
        // menu que permite ejecutar las funciones:
        System.out.println("----------------------------------------------------");
        System.out.println("   BIENVENIDO AL CINE ALICIA   ");
        System.out.println("----------------------------------------------------");
        System.out.println("Elija la opcion que desea hacer:");
        System.out.println("(1)  Añadir peliculas");
        System.out.println("(2)  Eliminar peliculas");
        System.out.println("(3)  Crear una sesion");
        System.out.println("(4)  Mostrar estado de sesion");
        System.out.println("(5)  Comprar entradas");
        System.out.println("(6)  Ver Recaudacion");
        System.out.println("(7)  Salir");
        System.out.println("----------------------------------------------------");
    }

    public static void main(String[] args) {

        // --------------------------------------------
        // INICIALIZACIÓN DE LAS VARIABLES
        // --------------------------------------------

        Scanner sc = new Scanner(System.in); // para leer datos desde teclado

        // VARIABLES DE ESTADO
        final int ANADIR_PELI = 1;
        final int ELIMINAR_PELI = 2;
        final int CREAR_SESION = 3;
        final int ESTADO_SESION = 4;
        final int COMPRAR_ENTRADAS = 5;
        final int RECAUDACION = 6;
        final int SALIR = 7;

        // creando un cine
        Cine cine  = new Cine("Cine Alicia", "Universidad de Jaen");

        // crear dos salas y añadelas al cine
        Sala sala1 = new Sala("1", 10, 10);
        Sala sala2 = new Sala("2", 15, 15);
        cine.agregarSala(sala1);
        cine.agregarSala(sala2);
        // --------------------------------------------

        menu();
        System.out.print(">> OPCIÓN: ");
        int opcion = sc.nextInt();

        // MAQUINA DE ESTADO
        do {
            String id_sesion;

            switch (opcion) {
                case ANADIR_PELI: // AÑADIR PELICULA

                    System.out.println("\n----------- OPCIÓN 1: ANÃDIR PELICULA -----------\n");
                    // inicialización de variables
                    String tituloPeli;
                    int duracion;
                    String genero;
                    Pelicula pelicula;
                    String numeroSala;
                    int ocupadas = 0;

                    // bucle que repite hasta crear una pelicula de datos validos
                    do {
                        System.out.println("Insira los datos de la pelicula:\n");
                        System.out.print(">> Introduce el titulo: ");
                        sc.nextLine(); // Limpia el buffer antes de leer la próxima linea.
                        tituloPeli = sc.nextLine();
                        System.out.print(">> Duracion (minutos): ");
                        duracion = sc.nextInt();
                        System.out.print(">> Introduce el género (Drama, Terror, Comedia, Ciencia Ficción): "); // puede ser SOLAMENTE "Drama", "Terror", "Comedia", "Ciencia Ficcion"
                        sc.nextLine();
                        genero = sc.nextLine();
                        pelicula = new Pelicula(tituloPeli, duracion, genero);

                    } while (pelicula.getDuracion() == 0 || pelicula.getGenero().equals("error"));

                    System.out.println("----------------------------------------------------");
                    System.out.println("Pelicula creada:");
                    System.out.println(pelicula);
                    System.out.println("----------------------------------------------------");

                    System.out.println("\nSALAS VACIAS:");
                    for (Sala sala : cine.getSalas()) {
                        if (sala.estaVacia()) {
                            System.out.println("----------------------------------------------------");

                            System.out.println("- Número de la sala " + sala.getNumero());
                            System.out.println("- Filas: " + sala.getFilas());
                            System.out.println("- Butacas en fila: " + sala.getButacasEnFila());
                        }else{
                            ocupadas ++;
                        }
                    }

                    System.out.println("----------------------------------------------------");
                    if(ocupadas == 2){
                        System.out.println("Sin salas vacias para proyectar la pelicula!\n " +
                                "Libere una sala eliminando pelicula!");
                    }else{
                        System.out.println("\n>> Numero de la sala para proyectar la pelicula: ");
                        numeroSala = sc.next();
                        cine.agregarPelicula(pelicula, numeroSala);
                    }

                    break;

                case ELIMINAR_PELI: // ELIMINAR PELICULA

                    // muestras las peliculas que actualmente se encuentran en las distintas salas
                    // pergunta al usuario que peli eliminar
                    System.out.println("\n----------- OPCIÓN 2: ELIMINAR PELICULAS -----------\n");

                    System.out.println("Peliculas creadas para proyección:");

                    if(sala1.estaVacia()){
                        System.out.println("\nSala 1: \nSin pelicula para proyección.");
                    }else{
                        System.out.println("\nSala 1: ");
                        System.out.println("Pelicula para proyección: \n" + sala1.getPelicula().toString());
                    }
                    System.out.println("---------------------------------------------------------");

                    if(sala2.estaVacia()){
                        System.out.println("\nSala 2: \nSin pelicula para proyección.");
                    }else{
                        System.out.println("\nSala 2: ");
                        System.out.println("Pelicula para proyección: \n" + sala2.getPelicula().toString());
                    }

                    System.out.println("----------------------------------------------------");
                    if(sala1.estaVacia() && sala2.estaVacia()){
                        System.out.println("\nNo se puede eliminar peliculas porque aún no ha añadido nuevas peliculas para proyección.");
                    }else{
                        System.out.print("\n>> Informe el numero de la sala que desea eliminar pelicula:");
                        numeroSala = sc.next();
                        if(numeroSala.equals("1")){
                            cine.eliminarPelicula(sala1.getPelicula(), numeroSala);
                        } else if (numeroSala.equals("2")) {
                            cine.eliminarPelicula(sala2.getPelicula(), numeroSala);
                        }
                    }
                    break;

                case CREAR_SESION: // CREAR SESION
                    // muestra las salas que tienen actualmente asignadas peliculas y solicita una sala
                    System.out.println("\n------------ OPCIÓN 3: CREAR SESIÓN ------------\n");

                    int libre = 0;

                    System.out.println("Salas con peliculas asignadas: ");
                    for (Sala sala : cine.getSalas()) {
                        if (!sala.estaVacia()) {
                            System.out.println("----------------------------------------------------");

                            System.out.println("\nNumero sala:" + sala.getNumero());
                            System.out.println("Pelicula para proyección: \n" + sala1.getPelicula().toString());
                        }else{
                            libre++;
                        }
                    }
                    if(libre == 2){
                        System.out.println("No se puede asignar nueva sesion!\n " +
                                "Añada una nueva pelicula para asignar nueva seseión.");
                    }else{
                        System.out.println("----------------------------------------------------");
                        System.out.print(">> Inserte el numero de la sala para crear nueva sesión: ");
                        numeroSala = sc.next();
                        System.out.print(">> Introduce el precio de la sesion (euro): ");
                        float precio = sc.nextFloat();
                        sc.nextLine(); // limpia el buffer
                        System.out.print(">> Introduce la hora de inicio de la sesión (formato HH:MM): ");
                        String hora = sc.nextLine();
                        LocalTime horaInicio;

                        try {
                            horaInicio = LocalTime.parse(hora);
                        } catch (Exception e) {
                            System.out.println("Error: Formato de hora inválido.");
                            return;
                        }

                        cine.crearSesion(precio, horaInicio, numeroSala);
                    }

                    break;

                case ESTADO_SESION: // MOSTRAR ESTADO DE UNA SESION
                    // muestra las distintas sesiones disponibles en el cine y pide al usuario que selecione una

                    System.out.println("\n----------- OPCIÓN 4:ESTADO DE SESIÓN -----------\n");
                    // muestra graficamente por consola el estado actual de ocupacion

                    System.out.println("----------------------------------------------------");
                    System.out.println("Sesiones disponibles: ");

                    for(Sesion sesion: cine.getSesiones()){
                        System.out.println("----------------------------------------------------");
                        System.out.println("Id Sesion: " + sesion.getId());
                        System.out.println("Numero de la sala: " + sesion.getSala().getNumero());
                        System.out.println("Pelicula: " + sesion.getSala().getPelicula());
                        System.out.println("Horario de inicio (hh:mm): " + sesion.getHoraInicio());
                        System.out.println("Precio: " + sesion.getPrecio() + " euros.");
                    }

                    System.out.println("----------------------------------------------------");
                    System.out.print(">> Informe el Id de la sesion que desea consultar su estado: ");
                    id_sesion = sc.next();

                    for(Sesion sesion: cine.getSesiones()){
                        if(id_sesion.equals(sesion.getId())){
                            System.out.println("Estado para la sesión de id " + sesion.getId() + ":\n");
                            System.out.println("'X' si el assiento está ocupado.");
                            System.out.println("'.' si el assiento está libre.\n");
                            cine.verEstadoSesion(sesion.getId());
                        }else{
                            System.out.println("No fue posible encontrar la sesión con el id informado.");
                        }
                    }

                    break;

                case COMPRAR_ENTRADAS: // COMPRAR ENTRADAS
                    System.out.println("\n----------- OPCIÓN 5: COMPRAR ENTRADAS -----------\n");

                    System.out.println("----------------------------------------------------");
                    System.out.println("Sesiones disponibles: ");

                    for(Sesion sesion: cine.getSesiones()){
                        System.out.println("----------------------------------------------------");
                        System.out.println("Id Sesion: " + sesion.getId());
                        System.out.println("Numero de la sala: " + sesion.getSala().getNumero());
                        System.out.println("Pelicula: " + sesion.getSala().getPelicula());
                        System.out.println("Horario de inicio (hh:mm): " + sesion.getHoraInicio());
                        System.out.println("Precio: " + sesion.getPrecio() + " €.");
                    }

                    System.out.println("----------------------------------------------------");
                    System.out.print(">> Informe el Id de la sesion que desea comprar entrada: ");
                    id_sesion = sc.next();

                    for(Sesion sesion: cine.getSesiones()){
                        if(id_sesion.equals(sesion.getId())){
                            System.out.println("Estado de ocupación para la sesión de id "+ sesion.getId() +": "+ sesion.obtenerPorcentajeOcupacion() + "%\n");
                        }else{
                            System.out.println("No fue posible encontrar la sesión con el id informado.");
                        }
                    }

                    System.out.println(">> Informe la cantidad de entradas que desea comprar (máximo 5): ");
                    int cantidad = sc.nextInt();

                    if (cantidad > 0 && cantidad <= 5) {
                        // Buscar a sessão correspondente pelo ID
                        Sesion sesionSelecionada = null;
                        for (Sesion sesion : cine.getSesiones()) {
                            if (sesion.getId().equals(id_sesion)) {
                                sesionSelecionada = sesion;
                                break;
                            }
                        }

                        if (sesionSelecionada != null) {
                            ArrayList<Entrada> entradasCompradas = sesionSelecionada.reservarEntradas(cantidad, sesionSelecionada.getSala().getPelicula().getTitulo());

                            if (!entradasCompradas.isEmpty()) {
                                System.out.println("Compra realizada com sucesso!");
                                for (Entrada entrada : entradasCompradas) {
                                    System.out.println(entrada.obtenerInfo());
                                }
                            } else {
                                System.out.println("Não foi possível reservar os assentos solicitados.");
                            }
                        } else {
                            System.out.println("Erro: Sessão não encontrada.");
                        }
                    } else {
                        System.out.println("Erro: Quantidade inválida ou nula!");
                    }
                    break;

                case RECAUDACION: // VER RECAUDACION
                    // MUESTRA LA RECAUDACION TOTAL
                    System.out.println("\n----------- OPCIÓN 6: OBTENER RECAUDACIÓN -----------\n");
                    cine.obtenerRecaudacion();

                    break;

                case SALIR: // SALIR
                    System.out.println("\nSaliendo...\n");
                    break;

                default:
                    System.out.println("Opción invalida.");
            }

            System.out.println("----------------------------------------------------");
            menu();
            System.out.print(">> NUEVA OPCIÓN: ");
            opcion = sc.nextInt();

        }while(opcion !=SALIR);

        System.out.println("Saliendo...");

    }
}