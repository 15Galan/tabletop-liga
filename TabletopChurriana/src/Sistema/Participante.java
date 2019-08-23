package Sistema;

import Datos.Juego;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Participante {

    private String nombre;
    private int puntos;
    private int victorias;
    private List<Juego> juegos;
    private String favorito;

    public Participante(String alias, List<Juego> juegos) {
        nombre = alias;
        puntos = 0;
        victorias = 0;
        this.juegos = juegos;

        if(juegos.size() == 1) {
            favorito = juegos.get(0).getNombre();

        } else {
            favorito = "¿¿¿???";
        }
    }

    public Participante(String alias) {
        this(alias, new LinkedList<>());
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

    public int getVictorias() {
        return victorias;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    public List<Juego> getJuegos() {
        return juegos;
    }

    public void setJuegos(List<Juego> juegos) {
        this.juegos = juegos;
    }

    public String getFavorito() {
        return favorito;
    }

    public void setFavorito(String nombre) {
        favorito = nombre;
    }


    @Override
    public String toString() {
        StringBuilder mensaje = new StringBuilder();
        StringBuilder lista = new StringBuilder();

        Iterator<Juego> it = juegos.iterator();

        while(it.hasNext()) {
            Juego juego = it.next();

            if(it.hasNext()) {
                lista.append(juego.getNombre() + ", ");

            } else {
                lista.append(juego.getNombre() + "]");
            }
        }

        mensaje.append(nombre).append(" ").append(lista.toString());

        return nombre;
    }
}
