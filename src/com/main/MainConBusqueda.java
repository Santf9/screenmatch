package com.main;

import com.formacionalura.screenmatch.modulo.Titulo;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class MainConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner text = new Scanner(System.in);
        System.out.println("Escribe el nombre de la película que deseas buscar:");
        var nombrePelicula = text.nextLine();

        String direccion = "https://www.omdbapi.com/?apikey=89a91ad0&t="+ nombrePelicula;

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

        // Instanciando un objeto de la dependencia Gson para mostrar el JSON serializado de Titulo
        Gson gson = new Gson();
        Titulo miTitulo = gson.fromJson(json, Titulo.class);
        System.out.println(miTitulo);
    }
}
