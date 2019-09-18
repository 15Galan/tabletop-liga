package Sistema;

import Datos.Juego;

import java.text.SimpleDateFormat;
import java.util.*;

public class Encuentro {

    private String titulo;                      // Título decorativo para el encuentro (en función de los juegos)
    private Date fecha;                         // TODO: Revisar cómo definir la fecha y cuándo (en la ejecución)
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


    public void generarSeleccion() {
        int tiempo = 0, jugadores = participantes.size();
        double pTotal = 0, random;
        boolean posible = true;         // Indica si aún es posible seleccionar algún juego

        List<Juego> auxiliar = new LinkedList<>();

        for(Juego juego : juegos) {
            if(juego.getJugadoresMAX() >= jugadores) {
                auxiliar.add(juego);
            }
        }

        // Escoger los juegos según el azar ponderado (en función de su % y del tiempo restante)
        while(posible && tiempo < duracion) {
            for (Juego juego : auxiliar) {
                pTotal += juego.getPorcentaje();        // Obtener el peso total (%) de los juegos
            }

            random = Math.random() * pTotal;

            posible = false;    // Si no se añade un juego en el for(), ya no hay posibilidades

            for(Juego elegido : auxiliar) {
                int tiempo_aux = tiempo + elegido.getDuracion();

                if(tiempo_aux < duracion) {
                    random -= elegido.getPorcentaje();

                    if(random <= 0) {
                        seleccion.add(elegido);
                        tiempo += elegido.getDuracion();
                        auxiliar.remove(elegido);           // La lista de juegos original debe quedar intacta
                        pTotal = 0;                         // Se formatea porque arriba se usa el operador (+=)

                        posible = true;

                        break;
                    }
                }
            }
        }

        variarPorcentajes();

        if(titulo == null) {
            generarTitulo();
        }
    }

    private void variarPorcentajes() {
        int escogidos = seleccion.size(), total = juegos.size(), no_escogidos = total - escogidos;

        for(Juego juego : juegos) {
            double porcentaje = juego.getPorcentaje();

            if(seleccion.contains(juego)) {         // Si antes se almacenara la copia, juego != copia, entonces false,
                seleccion.add(juego.copiar());      // esto mantiene el porcentaje del juego antes de cambiarlo
                seleccion.remove(juego);            // Los juegos no deben estar repetidos (ya está la copia)
                juego.restarPorcentaje((porcentaje/total) / escogidos);     // Afecta al juego original

            } else {
                juego.sumarPorcentaje((porcentaje/total) / no_escogidos);
            }
        }
    }

    private void generarTitulo() {
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

        titulo = mensaje;
    }


    @Override
    public String toString() {
        StringBuilder mensaje = new StringBuilder();

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

        for (int i = 0; i < seleccion.size(); i++) {
            tiempo += seleccion.get(i).getDuracion();

            if (i < 9) {
                mensaje.append("0");
            }

            mensaje.append(i+1).append(" - ").append(seleccion.get(i)).append("\n");
        }

        mensaje.append(tiempo).append(" / ").append(duracion).append(" minutos (");
        mensaje.append((double) tiempo*100/duracion).append(" %)\n");

        return mensaje.toString();
    }
}
