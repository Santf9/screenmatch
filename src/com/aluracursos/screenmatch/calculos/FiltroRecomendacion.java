package com.aluracursos.screenmatch.calculos;

public class FiltroRecomendacion {
    public void filtra(StarClasification clasification) {
        if (clasification.getStarClasificacion() >= 5) {
            System.out.println("Recomendado");
        } else if (clasification.getStarClasificacion() >= 3) {
            System.out.println("Popular en el momento");
        } else {
            System.out.println("Recomendado para ti, agrega a tu lista");
        }
    }
}
