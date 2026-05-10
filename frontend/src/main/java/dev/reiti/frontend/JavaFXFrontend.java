package dev.reiti.frontend;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.function.Consumer;

public class JavaFXFrontend {

    private final HttpClient client = HttpClient.newHttpClient();
    private final String BASE_URL = "http://localhost:8080/api/cars";

    public void loadCars(Consumer<String> callback) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .GET()
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(callback)
                .exceptionally(ex -> {
                    callback.accept("Error: " + ex.getMessage());
                    return null;
                });
    }

    public void addCar(String brand, String model) {
        String json = String.format("{\"brand\":\"%s\", \"model\":\"%s\"}", brand, model);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenAccept(res -> System.out.println("Sent successfully: " + res.statusCode()))
                .exceptionally(ex -> { System.err.println("Error: " + ex.getMessage()); return null; });
    }
}