package polígonos;

public class Triângulo extends Polígono {
    private String _cor;

    // Construtor para triângulos genéricos
    public Triângulo(int lado1, int lado2, int lado3) {
        super(new int[3], "triângulo");
        validar();
    }

    // Construtor para triângulo equilátero
    public Triângulo(int lado) {
        super(3, lado, "Triângulo Equilátero");
        validar();
    }

    // Construtor para triângulo isóceles
    public Triângulo(int ladoDiferente, int ladoRepetido) {
        super(new int[3], "Triângulo Isóceles");
        _lados[0] = _lados[1] = ladoRepetido;
        _lados[2] = ladoDiferente;
        validar();
    };

    // Indica se os lados do triângulo são válidos
    private boolean validar() {
        int a = _lados[0];
        int b = _lados[1];
        int c = _lados[2];

        if (a <= 0 || b <= 0 || c <= 0) {
            System.out.println("Todos os lados do triângulo devem ser positivos!");
            return false;
        }
        
        if ((a > b + c) || (b > a + c) || (c > a + b)) {
            System.out.println("Seus lados não obedecem à desigualdade triangular!");
            return false;
        }

        return true;
    }

    public double calculaÁrea() {
        int a = _lados[0];
        int b = _lados[1];
        int c = _lados[2];
        double p = (a + b + c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }

    // Getter e Setter do atributo privado cor
    public void setCor(String cor) {
        _cor = cor;
    }

    public String getCor() {
        return _cor;
    }
}