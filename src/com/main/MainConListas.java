package com.main;

import com.formacionalura.screenmatch.modulo.Pelicula;
import com.formacionalura.screenmatch.modulo.Serie;
import com.formacionalura.screenmatch.modulo.Titulo;

import java.util.ArrayList;

public class MainConListas {
    public static void main(String[] args) {

        Pelicula miPelicula = new Pelicula("Salvando al Soldado Ryan", 1998);
        miPelicula.evalua(9.8);
        Pelicula otraPelicula = new Pelicula("El Señor de los Anillos: La Comunidad del Anillo", 2001);
        otraPelicula.evalua(8);
        Serie casaDePapel = new Serie("La Casa de Papel", 2017);
        casaDePapel.evalua(8);
        var peliculaDeSanti = new Pelicula("El transportador", 2002);
        peliculaDeSanti.evalua(7.5);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(miPelicula);
        lista.add(otraPelicula);
        lista.add(peliculaDeSanti);
        lista.add(casaDePapel);

        for (Titulo item: lista) {
            System.out.println(item.getNombreDePelicula());
            // Verificando si el item es una instancia de Pelicula | No es la mejor forma de hacerlo
            if (item instanceof Pelicula pelicula && pelicula.getStarClasificacion() > 2) {
                // Usando el operador instanceof y casteo de pelicula con variable pelicula y condicional
                System.out.println("Estrellas: " + pelicula.getStarClasificacion());
            }
        }









    }
}
