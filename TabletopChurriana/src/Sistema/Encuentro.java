package Sistema;

import Datos.Juego;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Encuentro {

    private String titulo;
    private Date fecha;
    private List<Participante> participantes;
    private List<Juego> seleccion;


    public Encuentro(String titulo, Date fecha, List<Participante> jugadores, List<Juego> juegos) {
        this.titulo = titulo;
        this.fecha = fecha;
        participantes = jugadores;
        seleccion = juegos;
    }

    public Encuentro(Date fecha, List<Participante> jugadores, List<Juego> juegos) {
        this.titulo = generarTitulo(juegos);
        this.fecha = fecha;
        participantes = jugadores;
        seleccion = juegos;
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

    public List<Juego> getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(List<Juego> seleccion) {
        this.seleccion = seleccion;
    }

    public String generarTitulo(List<Juego> juegos) {
        double media = 0;
        String mensaje;

        for(Juego juego : juegos) {
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

        media /= juegos.size();

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


    @Override
    public String toString() {
        StringBuilder mensaje = new StringBuilder();
        StringBuilder lista = new StringBuilder("[");

        mensaje.append(titulo.toUpperCase()).append(" - ");
        mensaje.append(new SimpleDateFormat("(dd-MM-yyyy) (HH:mm)").format(fecha)).append(" - ");
        mensaje.append(participantes).append("\n");

        Iterator<Juego> it = seleccion.iterator();

        while(it.hasNext()) {
            Juego juego = it.next();

            if(it.hasNext()) {
                lista.append(juego.getNombre()).append(", ");

            } else {
                lista.append(juego.getNombre()).append("]");
            }
        }

        mensaje.append(lista.toString()).append("\n");

        return mensaje.toString();
    }
}
