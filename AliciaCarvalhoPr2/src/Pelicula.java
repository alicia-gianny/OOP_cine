public class Pelicula {

    // ATTRIBUTES
    private String titulo;
    private int duracion;
    private String genero;

    // CONSTRUCTOR
    public Pelicula(String titulo) {
        this.titulo = titulo;
    }

    //this.duracion = duracion; // duracion de la pelicula en MINUTOS
    //this.genero = genero; // puede ser SOLAMENTE "Drama", "Terror", "Comedia", "Ciencia Ficcion"



    // MODIFIES METHODS GETTERS AND SETTERS
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
