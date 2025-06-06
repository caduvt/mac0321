import java.util.HashMap;

public class DistanceFactory {
    private static DistanceFactory instance = null;
    private static final HashMap<String, Conversor> conversores = new HashMap<>();
    
    private DistanceFactory() {
        conversores.put("km2mi", ConversorKmParaMilhas.getInstance());
        conversores.put("mi2km", ConversorMilhasParaKm.getInstance());
        conversores.put("km2km", ConversorIdentidade.getInstance());
        conversores.put("mi2mi", ConversorIdentidade.getInstance());
    }

    static public DistanceFactory getInstance() {
        if (instance == null) {
            instance = new DistanceFactory();
        }
        return instance;
    }
    
    // implementação de fábrica com singleton -> retorna o próprio objeto ao invés de clonar
    public Conversor newConversor(String tipo) {
        return conversores.get(tipo);
    }
}
