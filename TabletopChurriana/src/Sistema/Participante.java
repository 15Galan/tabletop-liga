package Sistema;

import Datos.Juego;

import java.util.LinkedList;
import java.util.List;

public class Participante {

    private String nombre;
    private int puntos;
    private List<Juego> juegos;
    private Juego favorito;


    public Participante(String alias, List<Juego> juegos, Juego favorito) {
        this(alias, juegos);
        this.favorito = favorito;
    }

    public Participante(String alias, List<Juego> juegos) {
        this(alias);
        this.juegos = juegos;
    }

    public Participante(String alias) {
        nombre = alias;
        puntos = 0;
        juegos = new LinkedList<>();
        favorito = null;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void ganar(int puntos) {
        this.puntos += puntos;
    }

    public List<Juego> getJuegos() {
        return juegos;
    }

    public void setJuegos(List<Juego> juegos) {
        this.juegos = juegos;

        if(juegos.size() == 1) {
            this.favorito = juegos.get(0);
        }
    }

    public void addJuego(Juego juego) {
        juegos.add(juego);

        if(juegos.size() == 1) {
            this.favorito = juegos.get(0);
        }
    }

    public Juego getFavorito() {
        return favorito;
    }

    public void setFavorito(Juego favorito) {
        this.favorito = favorito;
    }

    @Override
    public String toString() {
        StringBuilder ficha = new StringBuilder();

        ficha.append(nombre).append(" - ").append(puntos).append(" puntos\n");

        if (juegos.size() != 0) {
            for (Juego juego : juegos) {
                ficha.append("\t").append(juego);

                if(juegos.lastIndexOf(juego) != juegos.size()-1) {
                    ficha.append("\n");
                }
            }

            if(favorito != null) {
                ficha.append("Favorito:\t").append(favorito.getNombre());
            }

        } else {
            ficha.append("\tSin juegos en la liga");
        }

        return ficha.toString();
    }
}
