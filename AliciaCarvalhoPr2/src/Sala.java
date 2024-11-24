public class Sala {

    // ATTRIBUTES
    private String numero; // NUMERO DE LA SALA: UNICO
    private int filas; // NUMERO  DE ASIENTOS EN CADA FILA
    private int butacasEnFila; // NUMERO DE BUTACAS POR FILA
    private Pelicula pelicula;

    // CONSTRUCTOR
    public Sala(String numero, int filas, int butacasEnFila) {
        this.numero = numero;
        this.filas = filas;
        this.butacasEnFila = butacasEnFila;
        this.pelicula = null; // sala vacia por defecto
    }


    // METHODS
    public boolean estaVacia(){
        if(getPelicula() == null){
            return true; // sala vacia
        }else{
            return false; // sala ocupada
        }
    }

    public void eliminarPelicula(){
        setPelicula(null);
        if(getPelicula() != null){
            System.out.println("Error al eliminar pelicula.");
        }
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

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }
}
