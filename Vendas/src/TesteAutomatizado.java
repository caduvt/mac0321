public class TesteAutomatizado {
  BalançoDeVendas balanco = new BalançoDeVendas();

  VendaSãoPaulo vendasSãoPaulo[] = {
      new VendaSãoPaulo("Codigo1SP", "Nome1SP", 20),
      new VendaSãoPaulo("Codigo2SP", "Nome2SP", 10)
  };
  VendaBrasil vendasBrasil[] = {
      new VendaBrasil("Codigo1Outros", "Nome1Outros", 30),
      new VendaBrasil("Codigo2Outros", "Nome2Outros", 40)
  };
  VendaExterior vendasExterior[] = {
      new VendaExterior("Codigo1Exterior", "Nome1Exterior", 50),
      new VendaExterior("Codigo2Exterior", "Nome2Exterior", 60)
  };

  public TesteAutomatizado() {
    for (Venda venda : vendasSãoPaulo)
      balanco.adicionaVenda(venda);
    for (Venda venda : vendasBrasil)
      balanco.adicionaVenda(venda);
    for (Venda venda : vendasExterior)
      balanco.adicionaVenda(venda);
  }

  public void testarImposto() {
    double resultado = balanco.calculaImposto();
    double esperado = 0.12 * 30 + 0.08 * 70 + 0;
    if (Math.abs(resultado - esperado) < 0.001) {
      System.out.println("Teste do Imposto: correto! Obtido: " + resultado);
    } else {
      System.out.println("Teste do Imposto: deu ruim! Esperado: " + esperado + ", Obtido: " + resultado);
    }
  }

  public void testarReceita() {
    double resultado = balanco.calculaReceita();
    double esperado = ((10 + 20 + 30 + 40 + 50 + 60) - balanco.calculaImposto() - 280);
    if (Math.abs(resultado - esperado) < 0.001) {
      System.out.println("Teste do Imposto: correto! Obtido: " + resultado);
    } else {
      System.out.println("testCalculaReceita: deu ruim! Esperado: " + esperado + ", Obtido: " + resultado);
    }
  }

  public static void main(String[] args) {
    TesteAutomatizado tester = new TesteAutomatizado();
    tester.testarImposto();
    tester.testarReceita();
  }
}
