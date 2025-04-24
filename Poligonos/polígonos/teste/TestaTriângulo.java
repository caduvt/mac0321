package polígonos.teste;

import polígonos.Triângulo;

public class TestaTriângulo {
    static boolean testaValidade() {
        Triângulo t1 = new Triângulo(1, 2, 3, "inválido");
        Triângulo t2 = new Triângulo(1, 1, 3, "inválido");
        Triângulo t3 = new Triângulo(1, 2, 3, "válido");
        return (!t1.validar() && !t2.validar() && t3.validar());
    }

    public static boolean testaArea() {
        Triângulo[] testes = {
            new Triângulo(1, 2, 3, "amarelo"),
            new Triângulo(5, 4, 3, "azul")
        };
        double[] esperado = {
            3.0,
            6.0
        };
        for (int i = 0; i < testes.length; i++) 
            if (!testaCasoArea(testes[i], esperado[i])) return false;
        return true;
    }

    public static boolean testaCasoArea(Triângulo t, double valorEsperado) {
        double area = t.calculaÁrea();
        return Math.abs(area - valorEsperado) < 1E-6;
    }
    
    static boolean testaPerimetro() {
        Triângulo t1 = new Triângulo(1, 2, 3, "rosa");
        Triângulo t2 = new Triângulo(5, 4, 3, "verde");
        return (t1.calculaÁrea() == 6 && t2.calculaÁrea() == 12);
    }

    public static void main(String[] args) {
        System.out.println("------------ TESTE -------------");
        if (!testaValidade()) System.out.println("Erro na validação dos triângulos!");
        if (!testaArea()) System.out.println("Erro no cálculo das áreas dos triângulos!");
        if (!testaPerimetro()) System.out.println("Erro no cálculo dos perímetros!");
        System.out.println("Todos os testes foram concluídos.");
    }
}
