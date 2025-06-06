
public class ConversorKmParaMilhas implements Conversor {
    private static final ConversorKmParaMilhas instance = new ConversorKmParaMilhas();
    
    // Construtor inativado -> singleton
    private ConversorKmParaMilhas() {}

    public static ConversorKmParaMilhas getInstance() {
        return instance;
    }

    @Override
    public double converte(double distancia) {
        return distancia / 1.609;
    }
   
}
