import java.util.Scanner;

public class main {
  public static void main(String[] args) {
    BalançoDeVendas balanco = new BalançoDeVendas();
    Scanner sc = new Scanner(System.in);
    int lerNovamente;

    do {
      // Decisão da classe a se utilizar
      System.out.println("\nQual o destino da venda?");
      System.out.println("1: SP");
      System.out.println("2: Demais estados brasileiros");
      System.out.println("3: Exterior");

      // Input de informações gerais sobre a venda
      int destino = sc.nextInt();
      System.out.print("\nDigite o código da venda: ");
      String codigo = sc.next();
      System.out.print("Digite o nome da venda: ");
      String nome = sc.next();
      System.out.print("Digite o valor da venda: ");
      float valor = sc.nextFloat();

      // Criação das classes
      switch (destino) {
        case 1: {
          VendaSãoPaulo venda = new VendaSãoPaulo(codigo, nome, valor);
          System.out.println("");
          balanco.adicionaVenda(venda);
          System.out.println(venda);
          break;
        }
        case 2: {
          VendaBrasil venda = new VendaBrasil(codigo, nome, valor);
          System.out.println("");
          balanco.adicionaVenda(venda);
          System.out.println(venda);
          break;
        }
        case 3: {
          VendaExterior venda = new VendaExterior(codigo, nome, valor);
          System.out.println("");
          balanco.adicionaVenda(venda);
          System.out.println(venda);
          break;
        }
        default:
          System.out.println("Insira um valor válido");
          break;
      }

      System.out.println("\nDeseja continuar? 0-Não, 1-Sim");
      lerNovamente = sc.nextInt();
    } while (lerNovamente == 1);

    // Prints finais: lista de vendas, imposto e receita totais
    System.out.println("\nRegistro de vendas: ");
    System.out.println(balanco);

    System.out.println("Total de imposto: " + balanco.calculaImposto());
    System.out.println("Total de receita: " + balanco.calculaReceita());
  }

}
