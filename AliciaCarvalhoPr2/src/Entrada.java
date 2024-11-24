public class Entrada {

    // ATTRIBUTES
    private int fila;
    private int butacaEnFila;
    private float precio;
    private String numeroSala;
    private String tituloPelicula;

    // CONSTRUCTOR

    public Entrada(int fila, int butacaEnFila, float precio, String numeroSala, String tituloPelicula) {
        this.fila = fila;
        this.butacaEnFila = butacaEnFila;
        this.precio = precio;
        this.numeroSala = numeroSala;
        this.tituloPelicula = tituloPelicula;
    }


    // METHODS
    public String obtenerInfo() {
        char letraFila = (char) ('A' + fila); // Convertiendo el índice de la fila para una letra (A, B, C...)
        return String.format(
                "Título Película: %s | Fila: %s | Asiento: %d | Sala: %s | Precio: %.2f €",
                tituloPelicula, letraFila, butacaEnFila + 1, numeroSala, precio
        );
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
