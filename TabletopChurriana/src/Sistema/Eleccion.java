package Sistema;

import Datos.Juego;

import java.util.*;

public class Eleccion {

    private List<Juego> juegos;         // Total de juegos disponibles cuando se creó la elección
    private List<Juego> seleccion;      // Sub-lista de juegos donde la suma de todos ellos es de 100 % aproximadamente
    private int tiempo;                 // Duración de un encuentro (por defecto 4 h) y que deben ocupar los juegos


    public Eleccion(List<Juego> juegos, int minutos) {
        this(juegos);
        tiempo = minutos;
    }

    public Eleccion(List<Juego> juegos) {
        this.juegos = juegos;
        seleccion = new LinkedList<>();
        tiempo = 240;
    }

    public void generarSeleccion() {
        double porcentaje_total = 0, porcentaje_seleccion = 0;
        int tiempo_acumulado = 0;

        // Obtener el peso total de los juegos (% total)
        for (Juego juego : juegos) {
            porcentaje_total += juego.getPorcentaje();
        }

        List<Juego> auxiliar = new LinkedList<>(juegos);

        // Aleatorizar los juegos y escogerlos en función de su % y del tiempo restante
        while(porcentaje_seleccion < 100 && tiempo_acumulado < tiempo-30) {
            double random = Math.random() * porcentaje_total;

            for(int i = 0; i < auxiliar.size(); i++) {
                Juego elegido = auxiliar.get(i);

                random -= elegido.getPorcentaje();

                int tiempo_aux = tiempo_acumulado + elegido.getDuracion();

                if(random <= 0 && tiempo_aux < tiempo) {
                    seleccion.add(elegido);
                    porcentaje_seleccion += elegido.getPorcentaje();
                    tiempo_acumulado += elegido.getDuracion();
                    auxiliar.remove(elegido);
                    break;
                }
            }
        }

        variarPorcentajes();
    }

    private void variarPorcentajes() {
        int escogidos = seleccion.size(), total = juegos.size(), no_escogidos = total - escogidos;

        for(Juego juego : juegos) {
            double porcentaje = juego.getPorcentaje();

            if(seleccion.contains(juego)) {         // Si se almacenara la copia antes: juego != copia, entonces false
                seleccion.add(juego.copiar());      // Esto mantiene el porcentaje del juego antes de cambiarlo
                seleccion.remove(juego);            // Los juegos no deben estar repetidos (ya está la copia)
                juego.restarPorcentaje((porcentaje/total) / escogidos);     // Afecta al juego original

            } else {
                juego.sumarPorcentaje((porcentaje/total) / no_escogidos);
            }
        }
    }

    public List<Juego> getSeleccion() {
        return seleccion;
    }


    @Override
    public String toString() {
        StringBuilder mensaje = new StringBuilder("[");

        for(Juego juego : seleccion) {
            mensaje.append(juego.getNombre());

            if(seleccion.lastIndexOf(juego) != seleccion.size()-1) {
                mensaje.append(", ");
            }
        }

        return mensaje.append("]").toString();
    }
}
