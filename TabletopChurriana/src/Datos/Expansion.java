package Datos;

public class Expansion {

    private Juego juego;            // Datos.Juego al que se asocia la expansión
    private String nombre;
    private String dueno;
    private int jugadoresEXTRA;     // Cantidad de jugadoresEXTRA que añade al juego base
    private int porcentaje;


    public Expansion(String nombre, String dueno, int jugadoresEXTRA) {
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
        return nombre + ", " + dueno + ", +" + jugadoresEXTRA + " jugadores";
    }
}
