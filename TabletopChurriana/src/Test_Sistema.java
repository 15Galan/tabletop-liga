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
    static private Participante mini = new Participante("Mini Luis");
    static private Participante salas = new Participante("Salas");
    static private Participante enrique = new Participante("Enrique");

    // Todos los juegos
    static private Juego monstruoFinal_1 = new Juego("Monstruo Final", galan, 4, 60);
    static private Juego monstruoFinal_3 = new Juego("Monstruo Final: Ascenso de los mini-monstruos finales", galan, 4, 60);
    static private Juego isaac = new Juego("The Binding of Isaac: Four Souls", javi, 10, 90);
    static private Juego doom = new Juego("DOOM", javi, 5, 120, Categoria.ESPECIAL);
    static private Juego risk = new Juego("Risk", luis, 6, 120);
    static private Juego fluxx = new Juego("FLUXX", galan, 6, 60, Categoria.ESPECIAL);
    static private Juego blackStories = new Juego("Blackstories", galan, 10, 60, Categoria.ESPECIAL);
    static private Juego jenga_uno = new Juego("UNO Stacko", galan, 6, 60);
    static private Juego dos = new Juego("DOS", galan, 6, 15);
    static private Juego taki = new Juego("Taki", galan, 6, 30);
    static private Juego munchkins = new Juego("Munchkin", javi, 6, 45);
    static private Juego munchkins_espacio = new Juego("Munchkin (edición espacial)", fran, 6, 45);
    static private Juego fluxx_mp = new Juego("FLUXX (edición Monty Piton)", fran, 6, 60, Categoria.ESPECIAL);
    static private Juego uno = new Juego("UNO", alberto, 6, 30);
    static private Juego chinchon = new Juego("Chinchón", null, 6, 15);
    static private Juego jungle_speed = new Juego("Jungle Speed", mini, 4, 15);
    static private Juego dungeons_dragons = new Juego("Dragones y Mazmorras", enrique, 5, 240, Categoria.ESPECIAL);
    static private Juego trolley = new Juego("Trial by Trolley", galan, 13, 60, Categoria.ESPECIAL);
    static private Juego shovel = new Juego("Shovel Knight: Dungeon Duels", 4, 60);
    static private Juego muffin = new Juego("It's Muffin Time!", 6, 45);

    // Todas las expansiones
    static private Expansion aterrizaje_forzoso = new Expansion("Aterrizaje Forzoso", galan, 2);
    static private Expansion herramientas_heroicas = new Expansion("Herramientas Heróicas", galan, 0);
    static private Expansion isaac_gold = new Expansion("Golden Pack", javi, 4);

    public static void main(String[] args) {
        // Lista de TODOS los juegos
        List<Juego> juegos_GLOBAL = Arrays.asList(monstruoFinal_1, monstruoFinal_3, isaac,doom, risk, fluxx,
                                        blackStories, jenga_uno, dos, taki, munchkins, munchkins_espacio, fluxx_mp,
                                        uno, chinchon, jungle_speed, dungeons_dragons, trolley, shovel, muffin);

        monstruoFinal_1.addExpansiones(Arrays.asList(aterrizaje_forzoso, herramientas_heroicas));
        monstruoFinal_3.addExpansiones(Arrays.asList(aterrizaje_forzoso, herramientas_heroicas));
        isaac.addExpansion(isaac_gold);

        for(Juego juego : juegos_GLOBAL) {
            juego.setPorcentaje(Math.round(100 * 100d/juegos_GLOBAL.size()) / 100d);    // Colocar el % inicial correcto
        }

        System.out.println("LISTA DE JUEGOS:\n" + mostrarJuegos(juegos_GLOBAL) + "\n");


        // Lista de EXPANSIONES
        List<Expansion> expansiones = new LinkedList<>(Arrays.asList(aterrizaje_forzoso, herramientas_heroicas, isaac_gold));

        System.out.println("LISTA DE EXPANSIONES:\n" + mostrarJuegos(expansiones));


        // Listas de JUEGOS/PERSONA
        List<Juego> juegos_Galan = Arrays.asList(monstruoFinal_1, monstruoFinal_3, fluxx,
                                                blackStories, jenga_uno, dos, taki, trolley, shovel, muffin);
        List<Juego> juegos_Javi = Arrays.asList(isaac, doom, munchkins, muffin);
        List<Juego> juegos_Luis = Arrays.asList(risk);
        List<Juego> juegos_Fran = Arrays.asList(munchkins_espacio, fluxx_mp, muffin);
        List<Juego> juegos_Alberto = Arrays.asList(uno);
        List<Juego> juegos_Mini = Arrays.asList(jungle_speed);
        List<Juego> juegos_Enrique = Arrays.asList(dungeons_dragons);


        // Lista de PARTICIPANTES
        galan.setJuegos(juegos_Galan);
        galan.setFavorito(monstruoFinal_1);

        javi.setJuegos(juegos_Javi);
        javi.setFavorito(isaac);

        luis.setJuegos(juegos_Luis);
        fran.setJuegos(juegos_Fran);

        alberto.setJuegos(juegos_Alberto);

        mini.setJuegos(juegos_Mini);

        enrique.setJuegos(juegos_Enrique);

        List<Participante> participantes = Arrays.asList(galan, javi, luis, fran, alberto, mini, salas, enrique);

        System.out.println("\nLISTA DE PARTICIPANTES:\n" + mostrarParticipantes(participantes));


        // Lista de ENCUENTROS
        System.out.println("LISTA DE ENCUENTROS:");

            // Primero
        Encuentro encuentro1 = new Encuentro(new Date(), 300, new Participante[]{galan, javi});
        encuentro1.generarSeleccion();
        galan.ganar(2);

        System.out.println(encuentro1);

            // Segundo
        Encuentro encuentro2 = new Encuentro(new Date(), 240, new Participante[]{galan, javi, luis});
        encuentro2.generarSeleccion();
        galan.ganar(2);
        javi.ganar(4);

        System.out.println(encuentro2);

            // Tercero
        Encuentro encuentro3 = new Encuentro(new Date(), 240, new Participante[]{galan, javi,fran});
        encuentro3.generarSeleccion();
        galan.ganar(3);
        fran.ganar(6);

        System.out.println(encuentro3);

            // Cuarto
        Encuentro encuentro4 = new Encuentro(new Date(), 240, new Participante[]{galan, javi, luis, alberto});
        encuentro4.generarSeleccion();
        javi.ganar(4);
        alberto.ganar(8);

        System.out.println(encuentro4);

            // Quinto (caso especial)
        List<Juego> halloween = Arrays.asList(monstruoFinal_1, monstruoFinal_3, isaac, doom, blackStories);

        Encuentro encuentro5 = new Encuentro("Halloween", new Date(), 240, new Participante[]{galan, javi, luis, alberto, fran});
        encuentro5.setJuegos(halloween);
        encuentro5.generarSeleccion();

        galan.ganar(4);
        javi.ganar(4);
        luis.ganar(3);
        alberto.ganar(3);

        System.out.println(encuentro5);

            // Sexto
        Encuentro encuentro6 = new Encuentro("Everyone is here", new Date(), 240, new Participante[]{galan, javi, luis, alberto, fran, mini, salas, enrique});
        encuentro6.generarSeleccion();

        galan.ganar(4);
        luis.ganar(8);
        fran.ganar(4);

        System.out.println(encuentro6);


        // Listas ACTUALIZADAS
        System.out.println("\nLISTA DE PARTICIPANTES (actualizada):");

        for(Participante participante : participantes) {
            System.out.println(participante.getPuntuacion());
        }

        System.out.println("\n\nLISTA DE JUEGOS (actualizada):\n" + mostrarJuegos(juegos_GLOBAL));
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
