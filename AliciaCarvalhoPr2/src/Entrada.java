public class Entrada {

    // ATTRIBUTES
    private static int fila;
    private static int butacaEnFila;
    private float precio;
    private String numeroSala;
    private String tituloPelicula;

    // CONSTRUCTOR
    public Entrada(int fila, int butacaEnFila){
        this.fila = fila;
        this.butacaEnFila = butacaEnFila;

        // chama funcion obtenerInfo
    }

    // METHODS
    public static String obtenerInfo() {
        // devulver el texto formateado con la informacion de la entrada
        String s = "Titulo Pelicula: " + tituloPelicula + " | Fila: " + fila + " | Butaca: " + butacaEnFila;
        return s;
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
