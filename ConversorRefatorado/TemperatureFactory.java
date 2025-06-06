import java.util.HashMap;

public class TemperatureFactory {
    private static TemperatureFactory instance = null;
    private static final HashMap<String, Conversor> conversores = new HashMap<>();
    
    private TemperatureFactory() {
        conversores.put("C2F", ConversorCelsiusParaFarenheit.getInstance());
        conversores.put("F2C", ConversorFarenheitParaCelsius.getInstance());
        conversores.put("Identidade", ConversorIdentidade.getInstance());
        conversores.put("K2F", ConversorKelvinParaFarenheit.getInstance());
        conversores.put("K2C", ConversorKelvinParaCelsius.getInstance());
        conversores.put("F2K", ConversorFarenheitParaKelvin.getInstance());
        conversores.put("C2K", ConversorCelsiusParaKelvin.getInstance());
    }

    static public TemperatureFactory getInstance() {
        if (instance == null) {
            instance = new TemperatureFactory();
        }
        return instance;
    }
    
    // implementação de fábrica com singleton -> retorna o próprio objeto ao invés de clonar
    public Conversor newConversor(String tipo) {
        return conversores.get(tipo);
    }
}
