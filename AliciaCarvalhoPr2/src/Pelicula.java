public class Pelicula {

    // ATTRIBUTES
    private String titulo;
    private int duracion;
    private String genero;

    // CONSTRUCTOR
    public Pelicula(String titulo, int duracion, String genero) {
        setTitulo(titulo);
        setDuracion(duracion); // validación dentro del metodo setDuracion
        setGenero(genero);     // validación dentro del metodo setGenero
    }

    // MODIFIES METHODS SETTERS

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDuracion(int duracion) {
        if (duracion > 0) {
            this.duracion = duracion;
        } else {
            System.out.println("\nERROR: La duración debe ser un valor positivo y mayor que cero.");
            this.duracion = 0;
        }
    }

    public void setGenero(String genero) {
        // Validar que el género esté entre las opciones permitidas
        if (genero.equalsIgnoreCase("Drama") ||
                genero.equalsIgnoreCase("Terror") ||
                genero.equalsIgnoreCase("Comedia") ||
                genero.equalsIgnoreCase("Ciencia Ficción")) {
            this.genero = genero;
        } else {
            System.out.println("\nERROR: El género debe ser 'Drama', 'Terror', 'Comedia' o 'Ciencia Ficción'.");
            this.genero = "error";
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getGenero() {
        return genero;
    }

    //method toString para representar la película
    @Override
    public String toString() {
        return "Titulo: " + titulo + " | Duración: " + duracion + " minutos | Género: " + genero;
    }
}
