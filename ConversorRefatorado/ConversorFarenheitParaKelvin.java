
public class ConversorFarenheitParaKelvin implements Conversor {
    private static final ConversorFarenheitParaKelvin instance = new ConversorFarenheitParaKelvin();

    private ConversorFarenheitParaKelvin() {}

    public static ConversorFarenheitParaKelvin getInstance() {
        return instance;
    }

    @Override
    public double converte(double temperatura) {
        return 5*(temperatura-32)/9 + 237.15;    
    }
    
}
