package trabalho;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CalculadoraTest {
    private final Calculadora c = new Calculadora();

    private String juntar(Fila<String> fila) {
        String texto = "";
        while (!fila.estaVazia()) {
            texto += fila.retirar() + " ";
        }
        return texto.trim();
    }

    private String posfixada(String expressao) {
        return juntar(c.gerarExprPosfixada(c.extrairTermos(expressao)));
    }

    private double calcular(String expressao) {
        return c.calcularExprPosfixada(c.gerarExprPosfixada(c.extrairTermos(expressao)));
    }

    @Test
    public void extrairTermosDoEnunciado() {
        assertEquals("( 25 + 10 ) / 3,5", juntar(c.extrairTermos("(25 + 10) / 3,5")));
    }

    @Test
    public void extrairTermosComOuSemEspacos() {
        assertEquals("15 / 3", juntar(c.extrairTermos("15/3")));
        assertEquals("15 / 3", juntar(c.extrairTermos("15 / 3")));
        assertEquals("15 / 3", juntar(c.extrairTermos("15 /3")));
        assertEquals("15 / 3", juntar(c.extrairTermos(" 15 /3")));
    }

    @Test
    public void extrairTermosComNegativos() {
        assertEquals("-5 + -3", juntar(c.extrairTermos("-5 + -3")));
        assertEquals("5 - 3", juntar(c.extrairTermos("5-3")));
        assertEquals("( -2 ) * 4", juntar(c.extrairTermos("(-2)*4")));
    }

    @Test
    public void gerarPosfixadaDoEnunciado() {
        assertEquals("15 5 + 3 /", posfixada("(15 + 5) / 3"));
        assertEquals("147 12 +", posfixada("147 + 12"));
        assertEquals("15 5 3 / +", posfixada("15 + 5 / 3"));
        assertEquals("20 5 + 8 2 - / 3 *", posfixada("(20 + 5) / (8 - 2) * 3"));
        assertEquals("2 1 10 2 / + *", posfixada("2 * (1 + (10 / 2))"));
    }

    @Test
    public void calcularExpressoes() {
        assertEquals(10.0, calcular("(25 + 10) / 3,5"), 1e-9);
        assertEquals(2.5, calcular("5 / 2"), 1e-9);
        assertEquals(5.0, calcular("15/3"), 1e-9);
        assertEquals(15 + 5.0 / 3, calcular("15 + 5 / 3"), 1e-9);
        assertEquals(12.5, calcular("(20 + 5) / (8 - 2) * 3"), 1e-9);
        assertEquals(12.0, calcular("2 * (1 + (10 / 2))"), 1e-9);
        assertEquals(1.0, calcular("10 - 4 - 5"), 1e-9);
        assertEquals(2.0, calcular("16 / 4 / 2"), 1e-9);
    }

    @Test
    public void calcularComNegativosEDecimais() {
        assertEquals(-8.0, calcular("-5 + -3"), 1e-9);
        assertEquals(8.0, calcular("5 - -3"), 1e-9);
        assertEquals(-7.5, calcular("-2,5 * 3"), 1e-9);
        assertEquals(0.75, calcular("1,5 / 2"), 1e-9);
    }

    private void assertInvalida(String expressao) {
        boolean lancou = false;
        try {
            calcular(expressao);
        } catch (ExpressaoInvalidaException | ArithmeticException e) {
            lancou = true;
        }
        assertTrue("Deveria rejeitar: " + expressao, lancou);
    }

    @Test
    public void expressoesInvalidas() {
        assertInvalida("");
        assertInvalida("(1 + 2");
        assertInvalida("1 + 2)");
        assertInvalida("1 +");
        assertInvalida("1 2");
        assertInvalida("2 $ 3");
        assertInvalida("3,");
        assertInvalida("1,2,3");
        assertInvalida("5 / 0");
        assertInvalida("()");
    }
}
