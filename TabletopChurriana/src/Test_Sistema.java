import Datos.Categoria;
import Datos.Juego;
import Sistema.Encuentro;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Test_Sistema {

    public static void main(String[] args) {

        List<Juego> juegos_C = new LinkedList<>();
        juegos_C.add(new Juego("UNO Stacko", "Galán", 6, Categoria.NORMAL));
        juegos_C.add(new Juego("DOS", "Galán", 6, Categoria.CORTO));
        juegos_C.add(new Juego("Taki", "Galán", 6, Categoria.CORTO));

        List<Juego> juegos_L = new LinkedList<>();
        juegos_L.add(new Juego("Monstruo Final", "Galán", 4, Categoria.NORMAL));
        juegos_L.add(new Juego("Monstruo Final: Ascenso de los mini-monstruos finales", "Galán", 4, Categoria.NORMAL));
        juegos_L.add(new Juego("The Binding of Isaac: Four Souls", "Javi", 4, Categoria.LARGO));
        juegos_L.add(new Juego("Risk", "Luis", 6, Categoria.LARGO));

        List<Juego> juegos_X = new LinkedList<>();
        juegos_X.add(new Juego("Monstruo Final: Ascenso de los mini-monstruos finales", "Galán", 4, Categoria.NORMAL));
        juegos_X.add(new Juego("FLUXX", "Galán", 6, Categoria.ESPECIAL));
        juegos_X.add(new Juego("Blackstories (edición normal)", "Galán", 10, Categoria.ESPECIAL));

        Encuentro encuentro1 = new Encuentro(new Date(), new String[]{"Javi", "Galán"}, juegos_C);
        Encuentro encuentro2 = new Encuentro(new Date(), new String[]{"Javi", "Galán", "Luis"}, juegos_L);
        Encuentro encuentro3 = new Encuentro(new Date(), new String[]{"Javi", "Galán", "Fran"}, juegos_X);

        encuentro1.setGanador("Galán");
        encuentro2.setGanador("Javi");
        encuentro3.setGanador("Fran");



        System.out.println(encuentro1 + "\n\n" + encuentro2 + "\n\n" + encuentro3);
    }
}
