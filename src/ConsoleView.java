import java.util.Scanner;

public class ConsoleView {
    private final Scanner scanner = new Scanner(System.in);

    public int mostrarMenu(){
        System.out.println("SELECCIONAR OPCIÓN: ");
        System.out.println("1). Convertir DÓLAR (USD) a PESO (ARS).");
        System.out.println("2). Convertir PESO (ARS) a DÓLAR (USD).");
        System.out.println("3). Convertir REAL (BRL) a DÓLAR (USD).");
        System.out.println("4). Convertir DÓLAR (USD) a REAL (BRL).");
        System.out.println("5). SALIR.");
        return scanner.nextInt();
    }
    public double leerMonto(){
        System.out.println("Ingrese monto: ");
        return scanner.nextDouble();
    }
    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }

    public void mostrarResultado(double resultado, String denominacion) {
        System.out.printf("Resultado: %.2f " + denominacion + "\n", resultado);
    }
}
