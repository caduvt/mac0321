import org.junit.jupiter.api.Test;
import java.util.ArrayList;

// Eu tentei rodar esses testes mas não consegui instalar o JUnit no PC

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BalançoDeVendasTest {

  @Test
  public void testAdicionaVenda() {
    BalançoDeVendas balanco = new BalançoDeVendas();
    Venda venda = new VendaBrasil("001", "Produto A", 100.0);
    balanco.adicionaVenda(venda);

    assertEquals(1, balanco.vendas.size());
    assertEquals("Produto A", balanco.vendas.get(0).getNome());
    assertEquals(100.0, balanco.vendas.get(0).getValor());
  }

  @Test
  public void testVendaBrasilImpostoEFrete() {
    VendaBrasil venda = new VendaBrasil("002", "Produto B", 200.0);

    assertEquals(0.08, venda.getImposto());
    assertEquals(30.0, venda.getFrete());
    assertEquals(200.0, venda.getValor());
    assertEquals("Produto B", venda.getNome());
  }

  @Test
  public void testVendaSaoPauloImpostoEFrete() {
    VendaSãoPaulo venda = new VendaSãoPaulo("003", "Produto C", 150.0);

    assertEquals(0.12, venda.getImposto());
    assertEquals(10.0, venda.getFrete());
    assertEquals(150.0, venda.getValor());
    assertEquals("Produto C", venda.getNome());
  }

  @Test
  public void testVendaExteriorImpostoEFrete() {
    VendaExterior venda = new VendaExterior("004", "Produto D", 300.0);

    assertEquals(0.0, venda.getImposto());
    assertEquals(100.0, venda.getFrete());
    assertEquals(300.0, venda.getValor());
    assertEquals("Produto D", venda.getNome());
  }

  @Test
  public void testCalculoDeImpostoTotal() {
    BalançoDeVendas balanco = new BalançoDeVendas();
    balanco.adicionaVenda(new VendaSãoPaulo("001", "Produto A", 100.0)); // imposto: 12
    balanco.adicionaVenda(new VendaBrasil("002", "Produto B", 200.0)); // imposto: 16
    balanco.adicionaVenda(new VendaExterior("003", "Produto C", 300.0)); // imposto: 0

    assertEquals(28.0, balanco.calculaImposto());
  }

  @Test
  public void testCalculoReceitaLiquida() {
    BalançoDeVendas balanco = new BalançoDeVendas();

    // São Paulo: 100 - 10 - 12 = 78
    balanco.adicionaVenda(new VendaSãoPaulo("001", "Produto A", 100.0));

    // Brasil: 200 - 30 - 16 = 154
    balanco.adicionaVenda(new VendaBrasil("002", "Produto B", 200.0));

    // Exterior: 300 - 100 - 0 = 200
    balanco.adicionaVenda(new VendaExterior("003", "Produto C", 300.0));

    assertEquals(432.0, balanco.calculaReceita());
  }

  @Test
  public void testToStringConteudoEsperado() {
    BalançoDeVendas balanco = new BalançoDeVendas();
    balanco.adicionaVenda(new VendaBrasil("005", "Produto X", 100.0));
    String esperado = "----\nVENDA: OUTROS ESTADOS DO BRASIL\n" +
        "Código: 005\n" +
        "Nome: Produto X\n" +
        "Valor: 100.0\n" +
        "Imposto: 0.08\n" +
        "Frete: 30.0\n\n";

    assertEquals(esperado, balanco.toString());
  }

  @Test
  public void testListaDeVendasEmOrdem() {
    BalançoDeVendas balanco = new BalançoDeVendas();

    balanco.adicionaVenda(new VendaBrasil("001", "Produto A", 100.0));
    balanco.adicionaVenda(new VendaSãoPaulo("002", "Produto B", 200.0));
    balanco.adicionaVenda(new VendaExterior("003", "Produto C", 300.0));

    ArrayList<Venda> vendas = balanco.vendas;

    assertEquals("Produto A", vendas.get(0).getNome());
    assertEquals("Produto B", vendas.get(1).getNome());
    assertEquals("Produto C", vendas.get(2).getNome());
  }
}
