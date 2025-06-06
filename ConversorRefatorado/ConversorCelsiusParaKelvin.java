
public class ConversorCelsiusParaKelvin implements Conversor {
    private static final ConversorCelsiusParaKelvin instance = new ConversorCelsiusParaKelvin();
    
    // Construtor inativado -> singleton
    private ConversorCelsiusParaKelvin() {}

    public static ConversorCelsiusParaKelvin getInstance() {
        return instance;
    }

    @Override
    public double converte(double temperatura) {
        return temperatura + 273.15;
    }
   
}
