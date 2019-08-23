import Datos.Categoria;
import Datos.Juego;
import Sistema.Encuentro;
import Sistema.Participante;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Test_Sistema {

    // Todos los juegos
    static private Juego monstruoFinal_1 = new Juego("Monstruo Final", "Galán", 4, Categoria.NORMAL);
    static private Juego monstruoFinal_3 = new Juego("Monstruo Final: Ascenso de los mini-monstruos finales", "Galán", 4, Categoria.NORMAL);
    static private Juego isaac = new Juego("The Binding of Isaac: Four Souls", "Javi", 10, Categoria.LARGO);
    static private Juego doom = new Juego("DOOM", "Javi", 5, Categoria.LARGO);
    static private Juego risk = new Juego("Risk", "Luis", 6, Categoria.LARGO);
    static private Juego fluxx = new Juego("FLUXX", "Galán", 6, Categoria.ESPECIAL);
    static private Juego blackStories = new Juego("Blackstories (edición normal)", "Galán", 10, Categoria.ESPECIAL);
    static private Juego jenga_uno = new Juego("UNO Stacko", "Galán", 6, Categoria.NORMAL);
    static private Juego dos = new Juego("DOS", "Galán", 6, Categoria.CORTO);
    static private Juego taki = new Juego("Taki", "Galán", 6, Categoria.CORTO);
    static private Juego munchkins = new Juego("Munchkins", "Javi", 6, Categoria.NORMAL);
    static private Juego munchkins_espacio = new Juego("Munchinks (edición espacial)", "Fran", 6, Categoria.NORMAL);
    static private Juego fluxx_mp = new Juego("FLUXX (edición Monty Piton)", "Fran", 6, Categoria.ESPECIAL);

    public static void main(String[] args) {

        // Lista de TODOS los juegos
        List<Juego> juegos_GLOBAL = new LinkedList<>();

        juegos_GLOBAL.add(monstruoFinal_1);
        juegos_GLOBAL.add(monstruoFinal_3);
        juegos_GLOBAL.add(isaac);
        juegos_GLOBAL.add(doom);
        juegos_GLOBAL.add(risk);
        juegos_GLOBAL.add(fluxx);
        juegos_GLOBAL.add(blackStories);
        juegos_GLOBAL.add(jenga_uno);
        juegos_GLOBAL.add(dos);
        juegos_GLOBAL.add(taki);
        juegos_GLOBAL.add(munchkins);
        juegos_GLOBAL.add(munchkins_espacio);
        juegos_GLOBAL.add(fluxx_mp);


        // Listas de JUEGOS/PERSONA
        List<Juego> juegos_Galan = new LinkedList<>();

        juegos_Galan.add(monstruoFinal_1);
        juegos_Galan.add(monstruoFinal_3);
        juegos_Galan.add(fluxx);
        juegos_Galan.add(blackStories);
        juegos_Galan.add(jenga_uno);
        juegos_Galan.add(dos);
        juegos_Galan.add(taki);


        List<Juego> juegos_Javi = new LinkedList<>();

        juegos_Javi.add(isaac);
        juegos_Javi.add(doom);
        juegos_Javi.add(munchkins);


        List<Juego> juegos_Luis = new LinkedList<>();

        juegos_Luis.add(risk);


        List<Juego> juegos_Fran = new LinkedList<>();

        juegos_Fran.add(munchkins_espacio);
        juegos_Fran.add(fluxx_mp);


        // Los JUGADORES
        Participante galan = new Participante("Galán", juegos_Galan);
        Participante javi = new Participante("Javi", juegos_Javi);
        Participante luis = new Participante("Luis", juegos_Luis);
        Participante fran = new Participante("Fran", juegos_Fran);
        Participante alberto = new Participante("Velasco");


        List<Participante> participantes = new LinkedList<>();

        participantes.add(galan);
        participantes.add(javi);
        participantes.add(luis);
        participantes.add(fran);
        participantes.add(alberto);


        System.out.println("Lista de participantes:\n" + participantes + "\n");


        // Lista con juegos CORTOS
        List<Juego> juegos_C = new LinkedList<>();

        juegos_C.add(dos);
        juegos_C.add(taki);


        // Lista con juegos NORMALES
        List<Juego> juegos_N = new LinkedList<>();

        juegos_N.add(jenga_uno);
        juegos_N.add(munchkins);
        juegos_N.add(monstruoFinal_3);


        // Lista con juegos LARGOS
        List<Juego> juegos_L = new LinkedList<>();

        juegos_L.add(monstruoFinal_1);
        juegos_L.add(isaac);
        juegos_L.add(risk);
        juegos_L.add(doom);


        // Lista con juegos ESPECIALES
        List<Juego> juegos_X = new LinkedList<>();

        juegos_X.add(monstruoFinal_3);
        juegos_X.add(fluxx);
        juegos_X.add(blackStories);

        // ENCUENTROS
        // Primero
        List<Participante> participantes1 = new LinkedList<>();

        participantes1.add(galan);
        participantes1.add(javi);

        Encuentro encuentro1 = new Encuentro(new Date(), participantes1, juegos_C);

        encuentro1.setGanador(participantes1.get(0));

        // Segundo
        List<Participante> participantes2 = new LinkedList<>();

        participantes2.add(galan);
        participantes2.add(javi);
        participantes2.add(luis);

        Encuentro encuentro2 = new Encuentro(new Date(), participantes2, juegos_L);

        encuentro2.setGanador(participantes2.get(1));

        // Tercero
        List<Participante> participantes3 = new LinkedList<>();

        participantes3.add(galan);
        participantes3.add(javi);
        participantes3.add(fran);

        Encuentro encuentro3 = new Encuentro(new Date(), participantes3, juegos_X);

        encuentro3.setGanador(fran);

        // Cuarto
        List<Participante> participantes4 = new LinkedList<>();

        participantes4.add(galan);
        participantes4.add(javi);
        participantes4.add(luis);
        participantes4.add(alberto);

        Encuentro encuentro4 = new Encuentro(new Date(), participantes4, juegos_X);

        encuentro4.setGanador(alberto);


        System.out.println(encuentro1 + "\n\n" + encuentro2 + "\n\n" + encuentro3 + "\n\n" + encuentro4);
    }
}
