import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Sesion{

    // ATTRIBUTES
    private int id; // genera de forma automatica
    private float precio; // unico y fijo
    private LocalTime horaInicio;
    private float recaudacion;
    private boolean [][] asientos; // almaciena si cada uno de los asientos ya o no vendido para la sesion
    private Cine cine;

    // CONSTRUCTOR
    public Sesion(float precio) {
        this.id = (int)(Math.random()*100);
    }

    // METHODS
    public Entrada reservarEntrada(int fila, int butaca){

        Entrada entrada = new Entrada(fila, butaca); // caso butaca esteja libre
        // verifica si la butaca esta libre y altera la recaudacion
        return new Entrada(fila, butaca); // con la info de la entrada reservada
    }

    public ArrayList<Entrada> reservarEntradas(int cantidad){
        ArrayList<Entrada> entradas = new ArrayList<>();
        // reserva automatica la cantidad de entradas especificada
        // debe priorizar que las entradas sean correlativas y que se asignen en la fila mas central
        return null;
    }

    public String obtenerEstadoSesion(){

        // devuelve un texto formateado con informacion grafica del estado actual
        // de los asientos para la sesion
        return null;
    }

    public int obtenerAsientosLibres(){

        // devuelve el numero total de asientos libres para la sesion
        return 0;
    }

    public float obtenerPorcentajeOcupacion(){

        // devuelve el percetagen de ocupacion de asientos para la sesion
        return 0;
    }

    // modifiers methods GETTERS AND SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalDate horaInicio) {
        this.horaInicio = LocalTime.from(horaInicio);
    }

    public float getRecaudacion() {
        return recaudacion;
    }

    public void setRecaudacion(float recaudacion) {
        this.recaudacion = recaudacion;
    }

    public boolean[][] getAsientos() {
        return asientos;
    }

    public void setAsientos(boolean[][] asientos) {
        this.asientos = asientos;
    }
}
