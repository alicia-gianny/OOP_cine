import java.time.LocalTime;
import java.util.ArrayList;

public class Cine {

    // ATTRIBUTES
    private String nombre;
    private String ubicacion;
    private ArrayList<Sala> salas;
    private ArrayList<Sesion> sesiones;

    // CONSTRUCTOR
    public Cine(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.salas = new ArrayList<>();
        this.sesiones = new ArrayList<>();
    }

    // METHODS
    public void agregarSala(Sala sala){
        this.salas.add(sala);
    }

    public void agregarPelicula(Pelicula pelicula, String numeroSala) {
        // agrega la pelicula a la sala cuyo numero de sala se pase como paramentro
        boolean salaEncontrada = false;

        for (Sala sala : salas) {
            if (sala.getNumero().equals(numeroSala)) { // Buscar la sala por su número
                sala.setPelicula(pelicula); // Asignar la película a la sala
                salaEncontrada = true;
                System.out.println("La película '" + pelicula.getTitulo() + "' fue asignada a la sala " + numeroSala);
                break;
            }
        }
        if (!salaEncontrada) {
            System.out.println("Error: No se encontró la sala con el número " + numeroSala);
        }
    }

    public void eliminarPelicula(Pelicula pelicula, String numeroSala) {
        // elimina la pelicula a la sala cuyo numero de sala se pase como paramentro
        boolean salaEncontrada = false;

        for (Sala sala : salas) {
            if (sala.getNumero().equals(numeroSala)) { // Buscar la sala por su número
                sala.eliminarPelicula(); // elimina la película de la sala
                salaEncontrada = true;
                System.out.println("La película '" + pelicula.getTitulo() + "' fue eliminada da la sala " + numeroSala);
                break;
            }
        }
        if (!salaEncontrada) {
            System.out.println("Error: No se encontró la sala con el número " + numeroSala);
        }
    }

    public void crearSesion(float precio, LocalTime hora, String numeroSala){
        // crea una nueva sesion en cine

        boolean salaEncontrada = false;

        for (Sala sala : salas) {
            if (sala.getNumero().equals(numeroSala)) { // Buscar la sala por su número
                Sesion nuevaSesion = new Sesion(precio, hora, sala);
                sesiones.add(nuevaSesion);
                salaEncontrada = true;
                System.out.println("Sesion creada en la sala "+sala.getNumero());
                break;
            }
        }
        if (!salaEncontrada) {
            System.out.println("Error: No se encontró la sala con el número " + numeroSala);
        }
    }


    public String verEstadoSesion(String idSesion){
        // devuelve un texto formateado con el estado de la sesion, incluyendo representacion grafica
        // de cada butaca, num de butacas disponibles y porcentage de ocupacion de la sala

        for (Sesion sesion : this.sesiones) {
            if (sesion.getId().equals(idSesion)) { // Buscar la sesion por su id
                System.out.println(sesion.obtenerEstadoSesion());
                System.out.println("Total de asientos libres: " + sesion.obtenerAsientosLibres());
                System.out.println("Porcentage de ocupación: " + sesion.obtenerPorcentajeOcupacion() +"%");
                break;
            }
        }

        return null;
    }

    public float obtenerRecaudacion(){
        float recaudacionTotal = 0;
        for (Sesion sesion : sesiones) {
            recaudacionTotal = recaudacionTotal + sesion.getRecaudacion();
        }

        System.out.println("Recaudación total: " + recaudacionTotal + " euros");

        return 0;
    }

    // MODIFIERS METHODS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public ArrayList<Sala> getSalas() {
        return salas;
    }

    public void setSalas(ArrayList<Sala> salas) {
        this.salas = salas;
    }

    public ArrayList<Sesion> getSesiones() {
        return sesiones;
    }

    public void setSesiones(ArrayList<Sesion> sesiones) {
        this.sesiones = sesiones;
    }
}
