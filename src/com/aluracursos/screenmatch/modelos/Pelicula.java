package com.aluracursos.screenmatch.modelos;

import com.aluracursos.screenmatch.calculos.StarClasification;

public class Pelicula extends Titulo implements StarClasification {
    private String director;

    // Constructor heredado de la clase Titulo
    public Pelicula(String nombre, int fechaLanzamiento) {
        super(nombre, fechaLanzamiento);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int getStarClasificacion() {
        return (int) mediaDeEvaluaciones() / 2;
    }

    @Override
    public String toString() {
        return "Pelicula: " + this.getNombreDePelicula() + " (" + getFechaLanzamiento() + ")";
    }
}
