public abstract class Venda {
  private String codigo;
  private String nome;
  private double valor;
  private double imposto;
  private double frete;

  public Venda(String c, String n, double v) {
    codigo = c;
    nome = n;
    valor = v;
  }

  public double getImposto() {
    return imposto;
  }

  public void setImposto(double i) {
    imposto = i;
  }

  public double getFrete() {
    return frete;
  }

  public void setFrete(double f) {
    frete = f;
  }

  public double getValor() {
    return valor;
  }

  public void setValor(double v) {
    valor = v;
  }

  public String getNome() {
    return nome;
  }

  public String toString() {
    return "Nome: " + nome + "\nCodigo: " + codigo + "\nValor: R$" + valor + "\nImposto: " + imposto + "\nFrete: "
        + frete + "\n----";
  }
}