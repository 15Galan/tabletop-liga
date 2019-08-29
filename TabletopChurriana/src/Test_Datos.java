import Datos.Expansion;
import Datos.Juego;
import Sistema.Participante;

import java.util.*;

public class Test_Datos {

    public static void main(String[] args) {

        Participante galan = new Participante("Galán");
        Participante javi = new Participante("Javi");
        Participante luis = new Participante("Luis");

        List<Juego> juegos = new LinkedList<>();
        juegos.add(new Juego("Monstruo Final", galan, 4, 60));
        juegos.add(new Juego("Monstruo Final: Ascenso de los mini-monstruos finales", galan, 4, 60));
        juegos.add(new Juego("The Binding of Isaac: Four Souls", javi, 4, 90));
        juegos.add(new Juego("Risk", luis, 6, 120));

        System.out.println("LISTA DE JUEGOS:");

        for(Juego juego : juegos) {
            juego.setPorcentaje(Math.round(100 * 100d/juegos.size()) / 100d);
            System.out.println(juego);
        }


        List<Expansion> expansiones = new LinkedList<>();
        expansiones.add(new Expansion("Aterrizaje forzoso", galan, 2));
        expansiones.add(new Expansion("Herramientas Heróicas", galan, 0));


        System.out.println("\nLISTA DE EXPANSIONES:");
        for(Expansion expansion : expansiones) {
            System.out.println(expansion);
        }


        juegos.get(0).addExpansiones(expansiones);
        juegos.get(1).addExpansiones(expansiones);

        System.out.println("\nLISTA DE JUEGOS + EXPANSIONES:");
        for(Juego juego : juegos) {
            System.out.println(juego);
        }
    }
}
