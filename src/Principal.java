import com.formacionalura.screenmatch.modulo.Pelicula;
import com.formacionalura.screenmatch.modulo.Serie;

public class Principal {
    public static void main(String[] args) {
        //Instanciando un objeto de la clase Pelicula
        //Es a través del objeto que podemos representar en este caso, llenar sus atributos y llamar a sus métodos
        Pelicula miPelicula = new Pelicula();
        miPelicula.setNombreDePelicula("Salvando al Soldado Ryan");//Declarando valores de atributos
        miPelicula.setFechaLanzamiento(1998);
        miPelicula.setDuracionEnMinutos(169);
        miPelicula.setEstaIncluido(true);

        //Llamando a metodo que imprime valores de atributos de la Pelicula
        miPelicula.mostrarFichaTecnica();

        System.out.println("--------------------------------");

        miPelicula.evalua(9.8);
        miPelicula.evalua(8.9);
        miPelicula.evalua(7.5);

        System.out.println("La suma de las evaluaciones es: " + miPelicula.getTotalDeEvaluaciones());
        System.out.println("La media de las evaluaciones es: " + miPelicula.mediaDeEvaluaciones());

        System.out.println("--------------------------------");

        //Instanciando otro objeto de una nueva serie
        Serie casaDePapel = new Serie();
        casaDePapel.setNombreDePelicula("La Casa de Papel");
        casaDePapel.setFechaLanzamiento(2017);
        casaDePapel.setTemporadas(5);
        casaDePapel.setEpisodiosPorTemporada(8);
        casaDePapel.setMinutosPorEpisodio(50);
        casaDePapel.mostrarFichaTecnica();

        System.out.println(casaDePapel.getDuracionEnMinutos());


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
