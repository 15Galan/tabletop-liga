package Datos;

import java.util.LinkedList;
import java.util.List;

public class Juego {
    // Variables del juego
    private String nombre;
    private String dueno;
    private int jugadoresMAX;
    private int duracion;

    // Variables para el sistema
    private Categoria categoria;
    private double porcentaje;
    private List<Expansion> expansiones;


    public Juego(String nombre, String dueno, int jugadoresMAX, int minutos, Categoria categoria, double porcentaje, List<Expansion> expansiones) {
        this(nombre, dueno, jugadoresMAX, minutos, categoria, porcentaje);
        this.expansiones = expansiones;
    }

    public Juego(String nombre, String dueno, int jugadoresMAX, int minutos, Categoria categoria, double porcentaje) {
        this(nombre, dueno, jugadoresMAX, minutos, categoria);
        this.porcentaje = porcentaje;
    }

    public Juego(String nombre, String dueno, int jugadoresMAX, int minutos, Categoria categoria) {
        this(nombre, dueno, jugadoresMAX, minutos);
        this.categoria = categoria;
    }

    public Juego(String nombre, String dueno, int jugadoresMAX, int minutos) {
        this.nombre = nombre;
        this.dueno = dueno;
        this.jugadoresMAX = jugadoresMAX;
        duracion = minutos;

        if(minutos <= 30) {
            categoria = Categoria.CORTO;

        } else if(minutos <= 60) {
            categoria = Categoria.NORMAL;

        } else {
            categoria = Categoria.LARGO;
        }

        porcentaje = 100;
        expansiones = new LinkedList<>();
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDueno() {
        return dueno;
    }

    public void setDueno(String dueno) {
        this.dueno = dueno;
    }

    public int getJugadoresMAX() {
        return jugadoresMAX;
    }

    public void setJugadoresMAX(int jugadoresMAX) {
        this.jugadoresMAX = jugadoresMAX;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = Math.round(100 * porcentaje) / 100d;
    }

    public void sumarPorcentaje(double variacion) {
        porcentaje += variacion;
        setPorcentaje(porcentaje);  // Para redondear a 2 decimales
    }

    public void restarPorcentaje(double variacion) {
        porcentaje -= variacion;

        if(porcentaje < 0) {
            porcentaje = 0;
        }

        setPorcentaje(porcentaje);  // Para redondear a 2 decimales
    }

    public List<Expansion> getExpansiones() {
        return expansiones;
    }

    public void addExpansiones(List<Expansion> lista) {
        boolean repetido = false;

        for(Expansion exp_actual : lista) {
            for(Expansion exp_lista : expansiones) {
                if(exp_actual.equals(exp_lista)) {
                    repetido = true;
                    break;
                }
            }

            if(!repetido) {
                expansiones.add(exp_actual);

            } else {
                repetido = false;
            }
        }
    }

    public Juego copiar() {
        return new Juego(nombre, dueno, jugadoresMAX, duracion, categoria, porcentaje, expansiones);
    }


    @Override
    public String toString() {
        StringBuilder mensaje = new StringBuilder(nombre);
        mensaje.append(" |").append(porcentaje).append("%|, ");
        mensaje.append(dueno).append(", ");
        mensaje.append(jugadoresMAX).append(" jugadores, ");
        mensaje.append(duracion).append(" min");

        if(expansiones.size() != 0) {
            mensaje.append(" [");

            for(Expansion expansion : expansiones) {
                mensaje.append(expansion.getNombre());

                if(expansiones.lastIndexOf(expansion) != expansiones.size()-1) {
                    mensaje.append(", ");
                }
            }
            mensaje.append("]");
        }

        return mensaje.toString();
    }
}