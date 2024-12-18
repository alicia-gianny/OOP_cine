import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;

public class Sesion{

    // ATTRIBUTES
    private String id; // genera de forma automatica
    private float precio; // unico y fijo
    private LocalTime horaInicio;
    private float recaudacion;
    private boolean [][] asientos; // almaciena si cada uno de los asientos ya o no vendido para la sesion
    private Sala sala;

    // CONSTRUCTOR
    public Sesion(float precio, LocalTime horaInicio, Sala sala) {
        this.id = sala.getNumero();
        this.precio = precio;
        this.horaInicio = horaInicio;
        this.sala = sala;
        this.asientos = new boolean[sala.getFilas()][sala.getButacasEnFila()];

    }

    // METHODS
    public ArrayList<Entrada> reservarEntradas(int cantidad, String tituloPelicula) {
        ArrayList<Entrada> entradas = new ArrayList<>(); // Lista de entradas
        int filas = asientos.length; // toma las filas como el tamaño del array de asientos
        int columnas = asientos[0].length; // dimension de los asientos = columnas

        // Generar lista de filas en ordem de prioridad (las mas centrales primero)
        ArrayList<Integer> ordenFilas = new ArrayList<>();
        for (int i = 0; i < filas; i++) {
            ordenFilas.add(i);
        }
        ordenFilas.sort(Comparator.comparingInt(fila -> Math.abs(fila - filas / 2))); // toma la fila más central

        // Tentar atribuir los asientos
        for (int fila : ordenFilas) {
            int consecutivos = 0;
            ArrayList<int[]> asientosTemporales = new ArrayList<>();

            for (int columna = 0; columna < columnas; columna++) {
                if (!asientos[fila][columna]) { // si asiento libre
                    asientosTemporales.add(new int[]{fila, columna});
                    consecutivos++;
                    if (consecutivos == cantidad) {
                        // si consecutivos igual a la cantidad de entradas a comprar
                        for (int[] asiento : asientosTemporales) {
                            int filaAsignada = asiento[0];
                            int columnaAsignada = asiento[1];
                            // cria y adiciona la entrada
                            Entrada entrada = new Entrada(filaAsignada, columnaAsignada, precio, sala.getNumero(), tituloPelicula);
                            entradas.add(entrada);

                            // marca asiento como ocupado
                            asientos[filaAsignada][columnaAsignada] = true;
                        }
                        recaudacion += precio * cantidad;
                        return entradas; // Retorna as entradas atribuídas
                    }
                } else {
                    // Reinicia se não houver continuidade
                    consecutivos = 0;
                    asientosTemporales.clear();
                }
            }
        }

        // Caso no sea posible atribuir las entradas, devuelve una lista vacia
        return entradas;
    }

    public String obtenerEstadoSesion(){

        StringBuilder estado = new StringBuilder();

        // Encabezado de la matriz (numeración de las columnas)
        estado.append("  ");
        for (int j = 0; j < asientos[0].length; j++) {
            estado.append(String.format("%2d", j + 1)).append(" "); // etiqueta de las columnas
        }
        estado.append("\n");

        // Representar cada fila de la sala
        for (int i = 0; i < asientos.length; i++) {
            estado.append((char) ('A' + i)).append(" "); // Etiqueta de la fila (A, B, C, etc.)
            for (int j = 0; j < asientos[i].length; j++) {
                if (asientos[i][j]) {
                    estado.append(" X "); // Asiento ocupado
                } else {
                    estado.append(" . "); // Asiento disponible
                }
            }
            estado.append("\n");
        }

        return estado.toString();
    }

    public int obtenerAsientosLibres(){
        // devuelve el numero total de asientos libres para la sesion
        int libre = 0;
        for(int i = 0; i < asientos.length; i++){
            for(int j = 0; j < asientos[i].length; j++){
                if (!asientos[i][j]) {
                    libre++;
                }
            }
        }
        return libre;
    }

    public float obtenerPorcentajeOcupacion(){
        // devuelve el percetagen de ocupacion de asientos para la sesion
        int ocupados = 0;
        int total = 0;
        float porcentage = 0;
        for (boolean[] asiento : asientos) {
            for (int j = 0; j < asiento.length; j++) {
                total++;
                if (asiento[j]) { // asiento = false --> libre
                    ocupados++;
                }
            }
        }

        porcentage = 100 * ((float) ocupados / total);
        return porcentage;
    }

    // modifiers methods GETTERS AND SETTERS

    public String getId() {
        return id;
    }

    public void setId(String id) {
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


    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
}
