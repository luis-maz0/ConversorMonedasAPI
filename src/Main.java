import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        //Menu conversor moneda
        String APIkey = "a2dd538d12791e34f3495421";
        String baseUrl = "https://v6.exchangerate-api.com/v6/"+APIkey+"/latest/USD";
        int opcion;
        double monto;
        Scanner sc = new Scanner(System.in);

        do{
            mostrarMenu();
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("Ingresar Monto:");
                    monto = sc.nextDouble();
                    System.out.println(monto);

                    //1. Crear cliente
                    HttpClient client = HttpClient.newHttpClient();

                    //2. Crear petición
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create(baseUrl))
                            .GET()
                            .build();
                    //3. Enviar solicitud y recibir respuesta
                    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                    System.out.println(response.statusCode());
                    System.out.println(response.body());
                    break;
                case 2:
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opción invalida.");
            }



        }while (opcion != 5);


    }
    public static void mostrarMenu(){
        System.out.println("SELECCIONAR OPCION: ");
        System.out.println("1). Convertir DOLAR(USD) a PESO(ARS).");
        System.out.println("2). Convertir PESO(ARS) a DOLAR(USD).");
        System.out.println("3). Convertir REAL(BRL) a DOLAR(USD).");
        System.out.println("4). Convertir DOLAR(USD) a REAL(BRL).");
        System.out.println("5). SALIR.");
    }

}
