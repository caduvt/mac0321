import java.util.ArrayList;

public class BalançoDeVendas {
  // O VSCode deu flag e pediu para remover o tipo Venda do segundo par de <>
  public ArrayList<Venda> vendas = new ArrayList<>();

  public String toString() {
    String resultado = "";

    // Análogo a um "venda in vendas" de python
    for (Venda venda : vendas) {
      resultado += (venda.toString() + "\n\n");
    }

    return resultado;
  }

  public double calculaImposto() {
    double imposto = 0;
    for (Venda venda : vendas) {
      imposto += (venda.getValor() * venda.getImposto());
    }
    return imposto;
  }

  public double calculaReceita() {
    double receita = 0;
    for (Venda venda : vendas) {
      receita += (venda.getValor() - venda.getFrete());
    }
    receita -= calculaImposto();
    return receita;
  }

  public void adicionaVenda(Venda novaVenda) {
    vendas.add(novaVenda);
  }
}
