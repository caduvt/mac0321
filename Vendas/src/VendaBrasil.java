public class VendaBrasil extends Venda {

  public VendaBrasil(String c, String n, double v) {
    super(c, n, v);
    setImposto(0.08);
    setFrete(30);
  }

  public String toString() {
    return "----\nVENDA: OUTROS ESTADOS DO BRASIL\n" + super.toString();
  }

}
