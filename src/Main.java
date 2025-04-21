import com.aluracursos.screenmatch.calculos.CalculoDeTiempo;
import com.aluracursos.screenmatch.calculos.FiltroRecomendacion;
import com.formacionalura.screenmatch.modulo.Episodio;
import com.formacionalura.screenmatch.modulo.Pelicula;
import com.formacionalura.screenmatch.modulo.Serie;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Instanciando un objeto de la clase Pelicula
        // Es a través del objeto que podemos representar en este caso, llenar sus atributos y llamar a sus métodos
        Pelicula miPelicula = new Pelicula("Salvando al Soldado Ryan");
        miPelicula.setFechaLanzamiento(1998); // Declarando valores de atributos
        miPelicula.setDuracionEnMinutos(169);
        miPelicula.setEstaIncluido(true);

        // Llamando a metodo que imprime valores de atributos de la Pelicula
        miPelicula.mostrarFichaTecnica();

        System.out.println("--------------------------------");

        miPelicula.evalua(9.8);
        miPelicula.evalua(8.9);
        miPelicula.evalua(7.5);

        System.out.println("La suma de las evaluaciones es: " + miPelicula.getTotalDeEvaluaciones());
        System.out.println("La media de las evaluaciones es: " + miPelicula.mediaDeEvaluaciones());

        System.out.println("--------------------------------");

        // Instanciando otro objeto de una nueva serie
        Serie casaDePapel = new Serie();
        casaDePapel.setNombreDePelicula("La Casa de Papel");
        casaDePapel.setFechaLanzamiento(2017);
        casaDePapel.setTemporadas(5);
        casaDePapel.setEpisodiosPorTemporada(8);
        casaDePapel.setMinutosPorEpisodio(50);
        casaDePapel.mostrarFichaTecnica();

        System.out.println(casaDePapel.getDuracionEnMinutos());

        // Instanciando otra Pelicula
        Pelicula otraPelicula = new Pelicula("El Señor de los Anillos: La Comunidad del Anillo");
        otraPelicula.setFechaLanzamiento(2001);
        otraPelicula.setDuracionEnMinutos(178);
        // Llamando a metodo que imprime los valores de la otra pelicula
        // Forma de reutilizacion de código
        otraPelicula.mostrarFichaTecnica();

        CalculoDeTiempo calculadora = new CalculoDeTiempo();
        calculadora.incluye(miPelicula);
        calculadora.incluye(casaDePapel);
        calculadora.incluye(otraPelicula);
        System.out.println("El tiempo necesario para ver este título es de: "
                + calculadora.getTiempoTotal() + " minutos");

        System.out.println("--------------------------------");

        Episodio episodio = new Episodio();
        episodio.setNumeroEpisodio(2);
        episodio.setNombreEpisodio("Tokyo y el profesor");
        episodio.setSerie(casaDePapel);
        episodio.setTotalVisualizaciones(60);

        FiltroRecomendacion filtroRecomendacion = new FiltroRecomendacion();
        filtroRecomendacion.filtra(miPelicula);
        filtroRecomendacion.filtra(otraPelicula);
        filtroRecomendacion.filtra(episodio);

        var peliculaDeSanti = new Pelicula("El transportador");
        peliculaDeSanti.setFechaLanzamiento(2002);
        peliculaDeSanti.setDuracionEnMinutos(110);

        ArrayList<Pelicula> listaDePeliculas = new ArrayList<>();
        listaDePeliculas.add(peliculaDeSanti);
        listaDePeliculas.add(miPelicula);
        listaDePeliculas.add(otraPelicula);

        System.out.println("Tamaño de la Lista de películas: " + listaDePeliculas.size());
        System.out.println("Primer película de la lista: " + listaDePeliculas.get(0));

        System.out.println(listaDePeliculas);

        System.out.println("toString de la película: " + listaDePeliculas.get(1));



    }
}
