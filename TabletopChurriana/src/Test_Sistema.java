import Datos.Categoria;
import Datos.Expansion;
import Datos.Juego;
import Sistema.Encuentro;
import Sistema.Participante;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Test_Sistema {
    // Todos los participantes
    static private Participante galan = new Participante("Galán");
    static private Participante javi = new Participante("Javi");
    static private Participante luis = new Participante("Luis");
    static private Participante alberto = new Participante("Velasco");
    static private Participante fran = new Participante("Fran");

    // Todos los juegos
    static private Juego monstruoFinal_1 = new Juego("Monstruo Final", galan, 4, 60);
    static private Juego monstruoFinal_3 = new Juego("Monstruo Final: Ascenso de los mini-monstruos finales", galan, 4, 60);
    static private Juego isaac = new Juego("The Binding of Isaac: Four Souls", javi, 10, 90);
    static private Juego doom = new Juego("DOOM", javi, 5, 120);
    static private Juego risk = new Juego("Risk", luis, 6, 120);
    static private Juego fluxx = new Juego("FLUXX", galan, 6, 60, Categoria.ESPECIAL);
    static private Juego blackStories = new Juego("Blackstories", galan, 10, 60, Categoria.ESPECIAL);
    static private Juego jenga_uno = new Juego("UNO Stacko", galan, 6, 60);
    static private Juego dos = new Juego("DOS", galan, 6, 15);
    static private Juego taki = new Juego("Taki", galan, 6, 30);
    static private Juego munchkins = new Juego("Munchkins", javi, 6, 45);
    static private Juego munchkins_espacio = new Juego("Munchinks (edición espacial)", fran, 6, 45);
    static private Juego fluxx_mp = new Juego("FLUXX (edición Monty Piton)", fran, 6, 60, Categoria.ESPECIAL);

    // Todas las expansiones
    static private Expansion aterrizaje_forzoso = new Expansion("Aterrizaje Forzoso", galan, 2);

    public static void main(String[] args) {
        // Lista de TODOS los juegos
        List<Juego> juegos_GLOBAL = Arrays.asList(monstruoFinal_1, monstruoFinal_3, isaac,doom, risk, fluxx,
                                        blackStories, jenga_uno, dos, taki, munchkins, munchkins_espacio, fluxx_mp);

        for(Juego juego : juegos_GLOBAL) {
            juego.setPorcentaje(Math.round(100 * 100d/juegos_GLOBAL.size()) / 100d);    // Colocar el % inicial correcto
        }

        System.out.println("LISTA DE JUEGOS:\n" + mostrarJuegos(juegos_GLOBAL) + "\n");


        // Lista de EXPANSIONES
        List<Expansion> expansiones = new LinkedList<>();

        expansiones.add(aterrizaje_forzoso);

        System.out.println("LISTA DE EXPANSIONES:\n" + mostrarJuegos(expansiones));


        // Listas de JUEGOS/PERSONA
        List<Juego> juegos_Galan = Arrays.asList(monstruoFinal_1, monstruoFinal_3, fluxx,
                                                blackStories, jenga_uno, dos, taki);

        monstruoFinal_1.addExpansion(aterrizaje_forzoso);
        monstruoFinal_3.addExpansion(aterrizaje_forzoso);


        List<Juego> juegos_Javi = Arrays.asList(isaac, doom, munchkins);

        List<Juego> juegos_Luis = Arrays.asList(risk);

        List<Juego> juegos_Fran = Arrays.asList(munchkins_espacio, fluxx_mp);


        // Lista de PARTICIPANTES
        galan.setJuegos(juegos_Galan);
        galan.setFavorito(monstruoFinal_1);

        javi.setJuegos(juegos_Javi);
        javi.setFavorito(isaac);

        luis.setJuegos(juegos_Luis);
        fran.setJuegos(juegos_Fran);

        List<Participante> participantes = Arrays.asList(galan, javi, luis, fran, alberto);

        System.out.println("\nLISTA DE PARTICIPANTES:\n" + mostrarParticipantes(participantes));


        // Lista de ENCUENTROS
        System.out.println("LISTA DE ENCUENTROS:");

            // Primero
        Encuentro encuentro1 = new Encuentro(new Date(), 300, new Participante[]{galan, javi});
        galan.ganar(2);

        System.out.println(encuentro1);
        System.out.println("LISTA DE JUEGOS (actualizada):\n" + mostrarJuegos(juegos_GLOBAL));

            // Segundo
        Encuentro encuentro2 = new Encuentro(new Date(), 240, new Participante[]{galan, javi, luis});
        galan.ganar(2);
        javi.ganar(4);

        System.out.println(encuentro2);
        System.out.println("LISTA DE JUEGOS (actualizada):\n" + mostrarJuegos(juegos_GLOBAL));

            // Tercero
        Encuentro encuentro3 = new Encuentro(new Date(), 240, new Participante[]{galan, javi,fran});
        galan.ganar(6);
        fran.ganar(3);

        System.out.println(encuentro3);
        System.out.println("LISTA DE JUEGOS (actualizada):\n" + mostrarJuegos(juegos_GLOBAL));

            // Cuarto
        Encuentro encuentro4 = new Encuentro(new Date(), 240, new Participante[]{galan, javi, luis, alberto});
        javi.ganar(4);
        alberto.ganar(8);

        System.out.println(encuentro4);
        System.out.println("LISTA DE JUEGOS (actualizada):\n" + mostrarJuegos(juegos_GLOBAL));

            // Quinto (caso especial)
        Encuentro encuentro5 = new Encuentro("Halloween", new Date(), 240, new Participante[]{galan, javi, luis, alberto, fran});

        List<Juego> halloween = Arrays.asList(monstruoFinal_1, monstruoFinal_3, isaac, doom, blackStories);
        encuentro5.setJuegos(halloween);

        galan.ganar(4);
        javi.ganar(3);
        luis.ganar(3);
        alberto.ganar(4);

        System.out.println(encuentro5);
        System.out.println("LISTA DE JUEGOS (actualizada):\n" + mostrarJuegos(juegos_GLOBAL));


        // Listas de juegos SELECCIONADOS
        System.out.println("\nSELECCIÓN DE JUEGOS:");

        for(Encuentro encuentro : new Encuentro[]{encuentro1, encuentro2, encuentro3, encuentro4, encuentro5}) {
            System.out.println(mostrarJuegos(encuentro.getSeleccion()));
        }

        System.out.println("\nLISTA DE PARTICIPANTES (actualizada):\n" + mostrarParticipantes(participantes));

        System.out.println("LISTA DE JUEGOS (actualizada):\n" + mostrarJuegos(juegos_GLOBAL));
    }


    private static <E> String mostrarJuegos(List<E> lista) {
        StringBuilder mensaje = new StringBuilder();

        if (lista != null && lista.size() != 0) {
            for (int i = 0; i < lista.size(); i++) {
                if (i < 9) {
                    mensaje.append("0");
                }

                mensaje.append(i+1).append(" - ").append(lista.get(i)).append("\n");
            }

        } else {
            mensaje.append("Lista vacía").append("\n");
        }

        return mensaje.toString();
    }

    private static String mostrarParticipantes(List<Participante> lista) {
        StringBuilder mensaje = new StringBuilder();

        if (lista != null && lista.size() != 0) {
            for (Participante participante : lista) {
                mensaje.append(participante).append("\n\n");
            }

        } else {
            mensaje.append("Lista vacía").append("\n");
        }

        return mensaje.toString();
    }
}
