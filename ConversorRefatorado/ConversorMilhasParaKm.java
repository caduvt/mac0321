
public class ConversorMilhasParaKm implements Conversor {
    private static final ConversorMilhasParaKm instance = new ConversorMilhasParaKm();
    
    // Construtor inativado -> singleton
    private ConversorMilhasParaKm() {}

    public static ConversorMilhasParaKm getInstance() {
        return instance;
    }

    @Override
    public double converte(double distancia) {
        return distancia * 1.609;
    }
   
}
