package com.aluracursos.screenmatch.modelos;

import com.aluracursos.screenmatch.calculos.StarClasification;

public class Episodio implements StarClasification {
    private int numeroEpisodio;
    private String nombreEpisodio;
    private Serie serie;
    private int totalVisualizaciones;

    public int getTotalVisualizaciones() {
        return totalVisualizaciones;
    }

    public void setTotalVisualizaciones(int totalVisualizaciones) {
        this.totalVisualizaciones = totalVisualizaciones;
    }

    public int getNumeroEpisodio() {
        return numeroEpisodio;
    }

    public void setNumeroEpisodio(int numeroEpisodio) {
        this.numeroEpisodio = numeroEpisodio;
    }

    public String getNombreEpisodio() {
        return nombreEpisodio;
    }

    public void setNombreEpisodio(String nombreEpisodio) {
        this.nombreEpisodio = nombreEpisodio;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    @Override
    public int getStarClasificacion() {
        if (totalVisualizaciones > 100) {
            return 5;
        } else {
            return 2;
        }
    }
}
