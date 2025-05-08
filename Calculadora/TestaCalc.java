public import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TestaCalc {

private final Calculadora calc = new Calculadora();
    @Test
    void soma() {
        assertEquals(2, calc.soma(1, 1));
    }

    @Test
    void testFatorial() {
        assertEquals(6, calc.fatorial(3));
    }
}
