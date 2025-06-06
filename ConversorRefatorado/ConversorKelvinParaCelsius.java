
public class ConversorKelvinParaCelsius implements Conversor {
    private static final ConversorKelvinParaCelsius instance = new ConversorKelvinParaCelsius();
    
    // Construtor inativado -> singleton
    private ConversorKelvinParaCelsius() {}

    public static ConversorKelvinParaCelsius getInstance() {
        return instance;
    }

    @Override
    public double converte(double temperatura) {
        return temperatura - 273.15;
    }
   
}
