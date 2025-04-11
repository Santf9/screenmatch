package com.formacionalura.screenmatch.modulo;

public class Pelicula {
    //Atributos de la Clase Pelicula
    private String nombreDePelicula;
    private int fechaLanzamiento;
    private int duracionEnMinutos;
    private boolean estaIncluido;
    private double sumaEvaluaciones; //Modificador de acceso private
    private int totalDeEvaluaciones;
    //Modificador de acceso default - Solo se accede desde la misma clase o paquete

    //Encapsulamiento - Getters y Setters
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

    //Métodos de la clase Pelicula
    public void mostrarFichaTecnica() {
        System.out.println("El nombre de la película: " + nombreDePelicula);
        System.out.println("La fecha de lanzamiento: " + fechaLanzamiento);
        System.out.println("Su duración en minutos: " + duracionEnMinutos);
        System.out.println("¿Está incluido en el plan? " + estaIncluido);
    }

    public void evalua(double nota) {
        sumaEvaluaciones += nota;
        totalDeEvaluaciones++;
    }

    public double mediaDeEvaluaciones() {
        return sumaEvaluaciones / totalDeEvaluaciones;
    }

}
