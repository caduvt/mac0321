
public class ConversorCelsiusParaFarenheit implements Conversor {
    private static final ConversorCelsiusParaFarenheit instance = new ConversorCelsiusParaFarenheit();
    
    // Construtor inativado -> singleton
    private ConversorCelsiusParaFarenheit() {}

    public static ConversorCelsiusParaFarenheit getInstance() {
        return instance;
    }

    @Override
    public double converte(double temperatura) {
        return 9*temperatura/5 + 32;
    }
   
}
