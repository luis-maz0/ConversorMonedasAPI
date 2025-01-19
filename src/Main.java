import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        //Menu conversor moneda
        int opcion;
        double monto;
        Scanner sc = new Scanner(System.in);

        do{
            mostrarMenu();
            opcion = sc.nextInt();

            switch (opcion){
                case 0:
                    System.out.println("Test consumo API");
                    System.out.println(ApiService.getConversionRates());
                case 1:
                    System.out.println("Ingresar Monto:");
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
        System.out.println("0). Testear API");
        System.out.println("1). Convertir DOLAR(USD) a PESO(ARS).");
        System.out.println("2). Convertir PESO(ARS) a DOLAR(USD).");
        System.out.println("3). Convertir REAL(BRL) a DOLAR(USD).");
        System.out.println("4). Convertir DOLAR(USD) a REAL(BRL).");
        System.out.println("5). SALIR.");
    }
}
