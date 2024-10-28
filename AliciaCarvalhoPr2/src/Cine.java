import java.time.LocalTime;
import java.util.ArrayList;

public class Cine {

    // ATTRIBUTES
    private String nombre;
    private String ubicacion;

    // CONSTRUCTOR
    public Cine(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    // METHODS
    public void agregarSala(Sala sala){
        int filas = 0; int butacasEnFila = 0; String numero;

        numero = Integer.toString((int)(Math.random()*100));
        // agrega una nueva sala al cine
        Sala sala1 = new Sala(numero, filas, butacasEnFila);
    }

    public void agregarPelicula(Pelicula pelicula, String numeroSala) {
        // agrega la pelicula a la sala cuyo numero se pase como paramentro
    }

    public void eliminarPelicula(Pelicula pelicula, String numeroSala) {
        // desasigna la pelicula actual a la sala cuyo numero se pasa como parametro
    }

    public void crearSesion(float Precio, LocalTime hora, String numeroSala){
        // crea una nueva sesion en cine
    }

    public Entrada comprarEntrada(int fila, int butaca, int idSesion){
        //  reserva la entrada en la fila y butaca especificasda para la sesion cuyo id se passa como parametro
        // utilizar metodos de la clase sesion
        return null;
    }

    public ArrayList<Entrada> comprarEntradas(int cantidad, int idSesion){
        // se hace uso del metodo de la clase sesion
        return null;
    }

    public String verEstadoSesion(int idSesion){
        // devuelve un texto formateado con el estado de la sesion, incluyendo representacion grafica
        // de cada butaca, num de butacas disponibles y porcentage de ocupacion de la sala
        return null;
    }

    public float obtenerRecaudacion(){
        // devuelve el total recaudado por todas las sesiones en el cine
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
}
