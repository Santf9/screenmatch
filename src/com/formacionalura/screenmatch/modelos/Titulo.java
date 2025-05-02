package com.formacionalura.screenmatch.modelos;

import com.formacionalura.screenmatch.exception.ErrorEnConversionDeDuracionException;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo> {
    //Atributos de la Clase Título
    private String nombreDePelicula;
    private int fechaLanzamiento;
    private int duracionEnMinutos;
    private boolean estaIncluido;
    private double sumaEvaluaciones;
    private int totalDeEvaluaciones;

    // Constructor
    public Titulo(String nombreDePelicula, int fechaLanzamiento) {
        this.nombreDePelicula = nombreDePelicula;
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public Titulo(TituloOmdb miTituloOmdb) {
        this.nombreDePelicula = miTituloOmdb.title();
        this.fechaLanzamiento = Integer.valueOf(miTituloOmdb.year());
        this.duracionEnMinutos = Integer.valueOf(miTituloOmdb.runtime().substring(0, 3).replace(" ",""));

        if (miTituloOmdb.runtime().contains("N/A")) {
            throw new ErrorEnConversionDeDuracionException("No puede convertir la duración," +
                    " porque contiene un N/A");
        }
    }

    // Modificador de acceso default - Solo se accede desde la misma clase o paquete
    // Encapsulamiento - Getters y Setters
    public String getNombreDePelicula() {
        return nombreDePelicula;
    }
    public int getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public boolean isEstaIncluido() {
        return estaIncluido;
    }

    public int getTotalDeEvaluaciones() {
        return totalDeEvaluaciones;
    }

    public void setNombreDePelicula(String nombre) {
        this.nombreDePelicula = nombre;
    }

    public void setFechaLanzamiento(int fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public void setDuracionEnMinutos(int duracionEnMinutos) {
        this.duracionEnMinutos = duracionEnMinutos;
    }

    public void setEstaIncluido(boolean estaIncluido) {
        this.estaIncluido = estaIncluido;
    }

    public void mostrarFichaTecnica() {
        System.out.println("El nombre del título: " + nombreDePelicula);
        System.out.println("La fecha de lanzamiento: " + fechaLanzamiento);
        System.out.println("Su duración en minutos: " + getDuracionEnMinutos());
        System.out.println("¿Está incluido en el plan? " + estaIncluido);
    }

    public void evalua(double nota) {
        sumaEvaluaciones += nota;
        totalDeEvaluaciones++;
    }

    public double mediaDeEvaluaciones() {
        return sumaEvaluaciones / totalDeEvaluaciones;
    }

    // Metodo sobreescrito de la interfaz Comparable para comparar y ordenar Lista de tipo Título
    @Override
    public int compareTo(Titulo otroTitulo) {
        return this.getNombreDePelicula().compareTo(otroTitulo.getNombreDePelicula());
    }

    @Override
    public String toString() {
        return  "(Nombre= " + nombreDePelicula +
                ", Fecha de lanzamiento= " + fechaLanzamiento +
                ", Duracion en minutos= " + duracionEnMinutos + ")";
    }
}
