
public class ConversorFarenheitParaCelsius implements Conversor {
    private static final ConversorFarenheitParaCelsius instance = new ConversorFarenheitParaCelsius();

    private ConversorFarenheitParaCelsius() {}

    public static ConversorFarenheitParaCelsius getInstance() {
        return instance;
    }

    @Override
    public double converte(double temperatura) {
        return 5*(temperatura-32)/9;    
    }
    
}
