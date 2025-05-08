import java.util.ArrayList;

public class BalançoDeVendas {
    // O VSCode deu flag e pediu para remover o tipo Venda do segundo par de <>
    public ArrayList<Venda> vendas = new ArrayList<>();
    
    public void imprimeVendas() {
        // Análogo a um "venda in vendas" de python
        for (Venda venda : vendas) {
            venda.toString();
        }
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

    public void adicionaVendaSãoPaulo(String c, String n, double v) {
        vendas.add(new VendaSãoPaulo(c, n, v));
    }

    public void adicionaVendaBrasil(String c, String n, double v) {
        vendas.add(new VendaBrasil(c, n, v));
    }

    public void adicionaVendaExterior(String c, String n, double v) {
        vendas.add(new VendaExterior(c, n, v));
    }
}
