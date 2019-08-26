import Datos.Expansion;
import Datos.Juego;

import java.util.*;

public class Test_Datos {

    public static void main(String[] args) {

        List<Juego> juegos = new LinkedList<>();
        juegos.add(new Juego("Monstruo Final", "Galán", 4, 60));
        juegos.add(new Juego("Monstruo Final: Ascenso de los mini-monstruos finales", "Galán", 4, 60));
        juegos.add(new Juego("The Binding of Isaac: Four Souls", "Javi", 4, 90));
        juegos.add(new Juego("Risk", "Luis", 6, 120));

        List<Expansion> expansiones = new LinkedList<>();
        expansiones.add(new Expansion("Aterrizaje forzoso", "Galán", 2));
        expansiones.add(new Expansion("Herramientas Heróicas", "Galán", 0));

        juegos.get(0).addExpansiones(expansiones);
        juegos.get(1).addExpansiones(expansiones);

        for(Juego juego : juegos) {
            System.out.println(juego);
        }
    }
}
