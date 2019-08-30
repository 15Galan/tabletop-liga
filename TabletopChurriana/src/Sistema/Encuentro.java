package Sistema;

import Datos.Juego;

import java.text.SimpleDateFormat;
import java.util.*;

public class Encuentro {

    private String titulo;                      // Título decorativo para el encuentro (en función de los juegos)
    private Date fecha;                         // TODO: Revisar cómo definir la fecha y cuándo
    private List<Participante> participantes;   // Jugadores registrado para el encuentro
    private List<Juego> juegos;                 // Todos los juegos de todos los participantes del encuentro
    private List<Juego> seleccion;              // Juegos escogidos con azar ponderado para el encuentro
    private int duracion;                       // Tiempo que se especifica para el encuentro (en minutos)


    public Encuentro(String titulo, Date fecha, int duracion, List<Participante> jugadores) {
        this.titulo = titulo;
        this.fecha = fecha;
        participantes = jugadores;
        juegos = new LinkedList<>();
        seleccion = new LinkedList<>();
        this.duracion = duracion;

        for(Participante participante : jugadores) {    // Suponiendo que la lista de juegos no es nula
            juegos.addAll(participante.getJuegos());
        }

        generarSeleccion();
    }

    public Encuentro(String titulo, Date fecha, int duracion, Participante[] jugadores) {
        this(titulo, fecha, duracion, Arrays.asList(jugadores));
    }

    public Encuentro(Date fecha, int duracion, List<Participante> jugadores) {
        juegos = new LinkedList<>();
        seleccion = new LinkedList<>();

        for(Participante participante : jugadores) {    // Suponiendo que la lista de juegos no es nula
            juegos.addAll(participante.getJuegos());
        }

        this.fecha = fecha;
        participantes = jugadores;
        this.duracion = duracion;

        generarSeleccion();
        titulo = generarTitulo();
    }

    public Encuentro(Date fecha, int duracion, Participante[] jugadores) {
        this(fecha, duracion, Arrays.asList(jugadores));
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    public List<Juego> getJuegos() {
        return juegos;
    }

    public void setJuegos(List<Juego> juegos) {
        this.juegos = juegos;
    }

    public List<Juego> getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(List<Juego> seleccion) {
        this.seleccion = seleccion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }


    private String generarTitulo() {
        double media = 0;
        String mensaje;

        for(Juego juego : seleccion) {
            switch(juego.getCategoria()) {
                case CORTO:
                    media += 1;
                    break;

                case NORMAL:
                    media += 2;
                    break;

                case LARGO:
                    media += 3;
                    break;

                case ESPECIAL:
                    media += 4;
                    break;
            }
        }

        media /= seleccion.size();

        if(media <= 1) {
            mensaje = "Rápidos y Furiosos";

        } else if(media <= 2) {
            mensaje = "Noche casual";

        } else if(media <= 3) {
            mensaje = "Pesos pesados";

        } else {
            mensaje = "Caos Games";
        }

        return mensaje;
    }

    private void generarSeleccion() {
        double porcentaje_total = 0, porcentaje_seleccion = 0;
        int tiempo_acumulado = 0;

        // Obtener el peso total de los juegos (% total)
        for (Juego juego : juegos) {
            porcentaje_total += juego.getPorcentaje();
        }

        List<Juego> auxiliar = new LinkedList<>(juegos);

        // Aleatorizar los juegos y escogerlos en función de su % y del tiempo restante
        while(porcentaje_seleccion < 100 && tiempo_acumulado < duracion-30) {
            double random = Math.random() * porcentaje_total;

            for(int i = 0; i < auxiliar.size(); i++) {
                Juego elegido = auxiliar.get(i);

                random -= elegido.getPorcentaje();

                int tiempo_aux = tiempo_acumulado + elegido.getDuracion();

                if(random <= 0 && tiempo_aux < duracion) {
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


    @Override
    public String toString() {
        StringBuilder mensaje = new StringBuilder();
        StringBuilder lista = new StringBuilder("[");

        mensaje.append(titulo.toUpperCase()).append(" - ");
        mensaje.append(new SimpleDateFormat("(dd-MM-yyyy) (HH:mm)").format(fecha)).append("\n");
        mensaje.append("[");

        for(Participante participante : participantes) {
            mensaje.append(participante.getNombre());
            mensaje.append(" (").append(participante.getPuntos()).append(")");

            if(participantes.lastIndexOf(participante) != participantes.size()-1) {
                mensaje.append(", ");
            }
        }

        mensaje.append("]\n");

        int tiempo = 0;

        for (Juego juego : seleccion) {
            tiempo += juego.getDuracion();

            if(seleccion.lastIndexOf(juego) != seleccion.size()-1) {
                lista.append(juego.getNombre()).append(", ");

            } else {
                lista.append(juego.getNombre()).append("]");
            }
        }

        mensaje.append(lista.toString()).append("\n");
        mensaje.append(tiempo).append(" / ").append(duracion).append(" minutos\n");

        return mensaje.toString();
    }
}
