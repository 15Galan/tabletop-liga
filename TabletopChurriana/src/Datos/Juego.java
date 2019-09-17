package Datos;

import Sistema.Participante;

import java.util.LinkedList;
import java.util.List;

public class Juego {
    // Variables del juego
    private String nombre;
    private int jugadoresMAX;
    private int duracion;

    // Variables para el sistema
    private Participante dueno;
    private Categoria categoria;
    private double porcentaje;
    private List<Expansion> expansiones;

    // Constructores
    public Juego(String nombre, Participante dueno, int jugadoresMAX, int minutos, Categoria categoria, double porcentaje, List<Expansion> expansiones) {
        this(nombre, dueno, jugadoresMAX, minutos, categoria, porcentaje);
        this.expansiones = expansiones;
    }

    public Juego(String nombre, Participante dueno, int jugadoresMAX, int minutos, Categoria categoria, double porcentaje) {
        this(nombre, dueno, jugadoresMAX, minutos, categoria);
        this.porcentaje = porcentaje;
    }

    public Juego(String nombre, Participante dueno, int jugadoresMAX, int minutos, Categoria categoria) {
        this(nombre, dueno, jugadoresMAX, minutos);
        this.categoria = categoria;
    }

    public Juego(String nombre, Participante dueno, int jugadoresMAX, int minutos) {
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

    public Juego(String nombre, int jugadoresMAX, int minutos) {
        this(nombre, null, jugadoresMAX, minutos);
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Participante getDueno() {
        return dueno;
    }

    public void setDueno(Participante dueno) {
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

    public List<Expansion> getExpansiones() {
        return expansiones;
    }

    public void setExpansiones(List<Expansion> expansiones) {
        this.expansiones = expansiones;
    }

    // Métodos especiales
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

    public void addExpansion(Expansion expansion) {
        if(!expansiones.contains(expansion)) {
            expansiones.add(expansion);
            expansion.setJuego(this);
        }
    }

    public void addExpansiones(List<Expansion> lista) {
        for(Expansion expansion : lista) {
            addExpansion(expansion);
        }
    }

    public Juego copiar() {
        return new Juego(nombre, dueno, jugadoresMAX, duracion, categoria, porcentaje, expansiones);
    }


    @Override
    public boolean equals(Object o) {
        boolean res = o instanceof Juego;

        Juego juego = res ? (Juego) o : null;

        return res && nombre.equalsIgnoreCase(juego.nombre)
                   && jugadoresMAX == juego.jugadoresMAX
                   && duracion == juego.duracion;
    }

    @Override
    public int hashCode() {
        return nombre.hashCode() + jugadoresMAX + duracion;
    }


    @Override
    public String toString() {
        StringBuilder mensaje = new StringBuilder(nombre);
        mensaje.append(" |").append(porcentaje).append("%|, ");
//        mensaje.append(dueno.getNombre()).append(", ");
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