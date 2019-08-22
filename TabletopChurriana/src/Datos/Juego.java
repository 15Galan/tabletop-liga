package Datos;

import java.util.LinkedList;
import java.util.List;

public class Juego {
    // Variables del juego
    private String nombre;
    private String dueno;
    private int jugadoresMAX;

    // Variables para el sistema
    private Categoria categoria;
    private double porcentaje;
    private List<Expansion> expansiones;


    public Juego(String nombre, String dueno, int jugadoresMAX, Categoria categoria, List<Expansion> expansiones) {
        this(nombre, dueno, jugadoresMAX, categoria);
        this.expansiones = expansiones;
    }

    public Juego(String nombre, String dueno, int jugadoresMAX, Categoria categoria) {
        this.nombre = nombre;
        this.dueno = dueno;
        this.jugadoresMAX = jugadoresMAX;

        this.categoria = categoria;
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
        this.porcentaje = porcentaje;
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


    @Override
    public String toString() {
        return nombre + ", " + dueno + ", " + jugadoresMAX + ", " + expansiones;
    }
}