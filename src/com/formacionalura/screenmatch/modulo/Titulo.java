package com.formacionalura.screenmatch.modulo;

public class Titulo {
    //Atributos de la Clase Título
    private String nombreDePelicula;
    private int fechaLanzamiento; // Modificador de acceso private
    private int duracionEnMinutos;
    private boolean estaIncluido;
    private double sumaEvaluaciones;
    private int totalDeEvaluaciones;

    // Constructor
    public Titulo(String nombreDePelicula, int fechaLanzamiento) {
        this.nombreDePelicula = nombreDePelicula;
        this.fechaLanzamiento = fechaLanzamiento;
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

    // Métodos de la clase Pelicula
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
}
