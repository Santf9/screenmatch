package com.main;

import com.formacionalura.screenmatch.modelos.Titulo;
import com.formacionalura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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

        // Permite decirle a JSON que los nombres que vamos a recibir van a ser todos en UpperCamelCase
        // Esto permite no tener que serializar los atributos de la clase Titulo
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();
        // Deserializando el JSON a un objeto del Record TituloOmdb
        TituloOmdb miTituloOmdb = gson.fromJson(json, TituloOmdb.class);
        System.out.println(miTituloOmdb);

        // Instanciando un objeto de la clase Titulo y pasando como parámetro el Record TituloOmdb
        Titulo miTitulo = new Titulo(miTituloOmdb);
        System.out.println(miTitulo);
    }
}
