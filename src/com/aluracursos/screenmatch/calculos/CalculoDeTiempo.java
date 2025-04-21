package com.aluracursos.screenmatch.calculos;
import com.formacionalura.screenmatch.modulo.Titulo;

public class CalculoDeTiempo {
    private int tiempoTotal;

    // Getter
    public int getTiempoTotal() {
        return tiempoTotal;
    }

    // Polomofrismo porque el metodo incluye es el mismo pero se comporta diferente. Un Título puede ser una Película o una Serie
    public void incluye(Titulo titulo) {
        System.out.println("Agregando duración en minutos de " + titulo );
        this.tiempoTotal += titulo.getDuracionEnMinutos();

    }
}
