// O conversor identidade é usado tanto para temperaturas quanto para distâncias
public class ConversorIdentidade implements Conversor {
    private static final ConversorIdentidade instance = new ConversorIdentidade();
    
    // Construtor inativado -> singleton
    private ConversorIdentidade() {}

    public static ConversorIdentidade getInstance() {
        return instance;
    }

    @Override
    public double converte(double valor) {
        return valor;
    }
    
}
