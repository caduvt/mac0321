public class VendaSãoPaulo extends Venda {

    public VendaSãoPaulo(String c, String n, double v) {
        super(c, n, v);
        setImposto(0.12);
        setFrete(10);
    }
}
