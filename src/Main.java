import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Map<String, Double> tasaCambioData = ApiService.getConversionRates();

        //Iniciar componentes
        ConsoleView view = new ConsoleView();
        CurrencyConverter converter = new CurrencyConverter(tasaCambioData);
        CurrencyController controller = new CurrencyController(view, converter);

        controller.iniciarApp();

    }
}
