package Sistema;

import Datos.Juego;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Encuentro {

    private String titulo;
    private Date fecha;
    private String[] participantes;
    private List<Juego> seleccion;
    private String ganador;


    public Encuentro(String titulo, Date fecha, String[] jugadores, List<Juego> juegos) {

        this.titulo = titulo;
        this.fecha = fecha;
        participantes = jugadores;
        seleccion = juegos;
    }

    public Encuentro(Date fecha, String[] jugadores, List<Juego> juegos) {
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

    public String[] getParticipantes() {
        return participantes;
    }

    public void setParticipantes(String[] participantes) {
        this.participantes = participantes;
    }

    public List<Juego> getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(List<Juego> seleccion) {
        this.seleccion = seleccion;
    }

    public String getGanador() {
        return ganador;
    }

    public void setGanador(String ganador) {
        this.ganador = ganador;
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

        mensaje.append(titulo.toUpperCase() + " - ");
        mensaje.append(new SimpleDateFormat("(dd-MM-yyyy) (HH:mm)").format(fecha) + " - ");     // Formato simple
        mensaje.append(Arrays.toString(participantes) + "\n");                                          // Formato normal

        Iterator<Juego> it = seleccion.iterator();

        while(it.hasNext()) {                               // Formato especial
            Juego juego = it.next();

            if(it.hasNext()) {
                lista.append(juego.getNombre() + ", ");

            } else {
                lista.append(juego.getNombre() + "]");
            }
        }

        mensaje.append(lista.toString() + "\n");
        mensaje.append("Ganador: " + ganador);

        return mensaje.toString();
    }
}
