public class CurrencyController {
    private final ConsoleView view;
    private final CurrencyConverter converter;

    public CurrencyController(ConsoleView view, CurrencyConverter converter) {
        this.view = view;
        this.converter = converter;
    }
    public void iniciarApp(){
        int opcion;
        do{
            opcion = view.mostrarMenu();

            switch (opcion){
                case 1:
                    convertir("USD","ARS");
                    break;
                case 2:
                    convertir("ARS","USD");
                    break;
                case 3:
                    convertir("BRL","USD");
                    break;
                case 4:
                    convertir("USD","BRL");
                    break;
                case 5:
                    view.mostrarMensaje("Muchas gracias!\nSaliendo...");
                    break;
                default:
                    view.mostrarMensaje("Opción inválida");
            }
        }while (opcion != 5);
    }
    private void convertir(String tasaOrigen, String tasaDestino){
        double monto = view.leerMonto();
        double resultado = converter.convertirMonto(tasaOrigen, tasaDestino, monto);
        view.mostrarResultado(resultado, tasaDestino);
    }

}
