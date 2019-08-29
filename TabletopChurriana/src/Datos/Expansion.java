package Datos;

import Sistema.Participante;

public class Expansion {
    // Variables de la expansión
    private String nombre;
    private int jugadoresEXTRA;     // Cantidad de jugadoresEXTRA que añade al juego base

    // Variables del sistema
    private Juego juego;            // Juego al que se asocia la expansión
    private Participante dueno;
    private int porcentaje;


    public Expansion(String nombre, Participante dueno, int jugadoresEXTRA) {
        this.nombre = nombre;
        this.dueno = dueno;
        this.jugadoresEXTRA = jugadoresEXTRA;

        porcentaje = 100;
    }


    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
        juego.addExpansion(this);
    }

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

    public int getJugadoresEXTRA() {
        return jugadoresEXTRA;
    }

    public void setJugadoresEXTRA(int jugadores) {
        this.jugadoresEXTRA = jugadores;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }


    @Override
    public String toString() {
        return nombre + ", " + dueno.getNombre() + ", +" + jugadoresEXTRA + " jugadores";
    }
}
