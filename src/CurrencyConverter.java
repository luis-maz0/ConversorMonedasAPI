import java.util.Map;

public class CurrencyConverter {
    private final Map<String,Double> converionRates;

    public CurrencyConverter(Map<String, Double> converionRates) {
        this.converionRates = converionRates;
    }
    public double convertirMonto(String monedaOrigen, String monedaDestino, Double montoOriginal){
        double valorMonedaOrigen = converionRates.get(monedaOrigen);
        double valorMonedaDestino = converionRates.get(monedaDestino);

        return (montoOriginal / valorMonedaOrigen) * valorMonedaDestino;
    }
}
