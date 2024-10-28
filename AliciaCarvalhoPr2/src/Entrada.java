public class Entrada {

    // ATTRIBUTES
    private int fila;
    private int butacaEnFila;
    private float precio;
    private String numeroSala;
    private String tituloPelicula;

    // CONSTRUCTOR
    public Entrada(){
        // chama funcion obtenerInfo
    }

    // METHODS
    public String obtenerInfo() {
        // devulver el texto formateado con la informacion de la entrada
        return tituloPelicula; // variable provisoria, aun sin retorno
    }

    // MODIFIERS METHODS GETTERS AND SETTERS
    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getButacaEnFila() {
        return butacaEnFila;
    }

    public void setButacaEnFila(int butacaEnFila) {
        this.butacaEnFila = butacaEnFila;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(String numeroSala) {
        this.numeroSala = numeroSala;
    }

    public String getTituloPelicula() {
        return tituloPelicula;
    }

    public void setTituloPelicula(String tituloPelicula) {
        this.tituloPelicula = tituloPelicula;
    }
}
