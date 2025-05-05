package com.main;

import com.formacionalura.screenmatch.exception.ErrorEnConversionDeDuracionException;
import com.formacionalura.screenmatch.modelos.Titulo;
import com.formacionalura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import io.github.cdimascio.dotenv.Dotenv;

public class MainConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner text = new Scanner(System.in);
        // Lista donde se van a guardar los titulos para persistirlos
        List<Titulo> titulos = new ArrayList<>();

        // Permite decirle a JSON que los nombres que vamos a recibir van a ser todos en UpperCamelCase
        // Esto permite no tener que serializar los atributos de la clase Titulo
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (true) {
            System.out.println("Escribe el nombre de la película que deseas buscar:");
            var nombrePelicula = text.nextLine();

            if (nombrePelicula.equalsIgnoreCase("salir")) {
                break;
            }

            // Cargamos el archivo .env
            Dotenv dotenv = Dotenv.load();
            String apiKey = dotenv.get("API_KEY");
            String direccion = "https://www.omdbapi.com/?apikey=".concat(apiKey).concat("&t=") + nombrePelicula.replace(" ", "+");

            try {
                // Clase HttpClient para realizar la petición
                HttpClient client = HttpClient.newHttpClient();
                // Clase HttpRequest para construir la petición
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(direccion))
                        .build();
                // Clase HttpResponse para manejar la respuesta
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                // Guardando la respuesta en una variable String
                String json = response.body();
                System.out.println(json);

                // Deserializando el JSON a un objeto del Record TituloOmdb
                TituloOmdb miTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println(miTituloOmdb);

                // Instanciando un objeto de la clase Titulo y pasando como parámetro el Record TituloOmdb
                Titulo miTitulo = new Titulo(miTituloOmdb);
                System.out.println("Titulo ya convertido: " + miTitulo);

                titulos.add(miTitulo);

            } catch (NumberFormatException e) {
                System.out.println("Ocurrio un error: " + e.getMessage());

            } catch (IllegalArgumentException e) {
                System.out.println("Error en la URI, verifique la dirección.");

            } catch (ErrorEnConversionDeDuracionException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(titulos);

        // Escribiendo y persistiendo la lista de títulos a un archivo JSON
        FileWriter escritura = new FileWriter("titulos.json");
        escritura.write(gson.toJson(titulos));
        escritura.close();

        // Se ejecuta igualmente si no se lanza ninguna excepción, es igual que el finally
        System.out.println("Finalizó la ejecución del programa!");
    }
}
