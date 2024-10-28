public class Sala {

    // ATTRIBUTES
    private String numero; // NUMERO DE LA SALA: UNICO
    private int filas; // NUMERO  DE ASIENTOS EN CADA FILA
    private int butacasEnFila; // NUMERO DE BUTACAS POR FILA

    // CONSTRUCTOR
    public Sala(String numero, int filas, int butacasEnFila) {
        this.numero = numero;
        this.filas = filas;
        this.butacasEnFila = butacasEnFila;
    }

    // METHODS
    public boolean estaVacia(){

        // retorna true si no tiene adignada ninguna peli
        return this.filas == 0;

    }

    public void eliminarPelicula(){
        // desasigna la pelicula que tiene asignada actualmente
    }


    // MODIFIERS METHODS GETTERS AND SETTERS
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getButacasEnFila() {
        return butacasEnFila;
    }

    public void setButacasEnFila(int butacasEnFila) {
        this.butacasEnFila = butacasEnFila;
    }
}
