
public class ConversorKelvinParaFarenheit implements Conversor {
    private static final ConversorKelvinParaFarenheit instance = new ConversorKelvinParaFarenheit();
    
    // Construtor inativado -> singleton
    private ConversorKelvinParaFarenheit() {}

    public static ConversorKelvinParaFarenheit getInstance() {
        return instance;
    }

    @Override
    public double converte(double temperatura) {
        return 9*(temperatura-237.15)/5 + 32;
    }
   
}
