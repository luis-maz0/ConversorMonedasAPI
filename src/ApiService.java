import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ApiService {

    private static String API_KEY = "a2dd538d12791e34f3495421";
    private static String BASE_URL = "https://v6.exchangerate-api.com/v6/"+API_KEY+"/latest/USD";

    public static Map<String, Double> getConversionRates() throws IOException, InterruptedException {
        //1. Crear cliente
        HttpClient client = HttpClient.newHttpClient();

        //2. Crear petición
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .GET()
                .build();
        //3. Enviar solicitud y recibir respuesta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());

        //4. Verifico respuesta
        if( response.statusCode() != 200){
            throw new RuntimeException("Error al consumir API. Status:" + response.statusCode());
        }
        //5. Parsear data a JSON
        JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();
        JsonObject conversionRates = jsonResponse.getAsJsonObject("conversion_rates");
        System.out.println("Data: " + conversionRates);

        //6. Extraer USD, ARS y BRL
        return Map.of(
                "USD", conversionRates.get("USD").getAsDouble(),
                "ARS", conversionRates.get("ARS").getAsDouble(),
                "BRL", conversionRates.get("BRL").getAsDouble()
        );
    }
}
