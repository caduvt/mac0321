import java.util.Scanner;

public class AppConversor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Conversor conv;

        System.out.print("Escolha o conversor: 1 - temperaturas, 2 - distancias: ");
        char tipoConversor = sc.next().charAt(0);

        if (tipoConversor == '1') {
            TemperatureFactory tempFactory = TemperatureFactory.getInstance();
            
            System.out.print("Digite a unidade da temperatura a ser convertida [F, K ou C]: ");
            char unidadeEntrada = sc.next().charAt(0);
            System.out.print("Digite para qual unidade da temperatura convertê-la [F, K ou C]: ");
            char unidadeSaída = sc.next().charAt(0);
            System.out.print("Digite a temperatura de entrada (em " + unidadeEntrada + "): ");
            double entrada = sc.nextDouble();

            conv = tempFactory.newConversor(unidadeEntrada + "2" + unidadeSaída);
            double saida = conv.converte(entrada);
    
            System.out.printf("%.2f%c -> %.2f%c\n", entrada, unidadeEntrada, saida, unidadeSaída);
        }

        else if (tipoConversor == '2') {
            DistanceFactory distFactory = DistanceFactory.getInstance();

            System.out.print("Digite a unidade da distancia a ser convertida [km ou mi]: ");
            String unidadeEntrada = sc.next();
            System.out.print("Digite para qual unidade da distancia convertê-la [km ou mi]: ");
            String unidadeSaída = sc.next();
            System.out.print("Digite a temperatura de entrada (em " + unidadeEntrada + "): ");
            double entrada = sc.nextDouble();

            conv = distFactory.newConversor(unidadeEntrada + "2" + unidadeSaída);
            double saida = conv.converte(entrada);

            System.out.printf("%.2f%s -> %.2f%s\n", entrada, unidadeEntrada, saida, unidadeSaída);
        }
        sc.close();        
    }
}
