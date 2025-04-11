import com.formacionalura.screenmatch.modulo.Pelicula;

public class Principal {
    public static void main(String[] args) {
        //Instanciando un objeto de la clase Pelicula
        Pelicula miPelicula = new Pelicula();
        //Es a través del objeto que podemos representar en este caso, llenar sus atributos y llamar a sus métodos
        miPelicula.setNombreDePelicula("Salvando al Soldado Ryan");//Declarando valores de atributos
        miPelicula.setFechaLanzamiento(1998);
        miPelicula.setDuracionEnMinutos(169);
        miPelicula.setEstaIncluido(true);

        //Llamando a metodo que imprime valores de atributos de la Pelicula
        miPelicula.mostrarFichaTecnica();
        System.out.println("---------------------");
        System.out.println(miPelicula.getNombreDePelicula());
        System.out.println(miPelicula.getFechaLanzamiento());
        System.out.println(miPelicula.getDuracionEnMinutos());
        System.out.println(miPelicula.isEstaIncluido());

        miPelicula.evalua(9.8);
        miPelicula.evalua(8.9);
        miPelicula.evalua(7.5);

        System.out.println("La suma de las evaluaciones es: " + miPelicula.getTotalDeEvaluaciones());
        System.out.println("La media de las evaluaciones es: " + miPelicula.mediaDeEvaluaciones());

        System.out.println("---------------------");


        /*
        //Instanciando otra Pelicula
        Pelicula otraPelicula = new.Pelicula();
        otraPelicula.nombreDePelicula = "El Señor de los Anillos: La Comunidad del Anillo"; //Declarando valores de atributos
        otraPelicula.fechaLanzamiento = 2001;
        otraPelicula.duracionEnMinutos = 178;
        otraPelicula.estaIncluido = false;

        //Llamando a metodo que imprime los valores de la otra pelicula
        //Forma de reutilizacion de código
        otraPelicula.mostrarFichaTecnica();
         */
    }
}
