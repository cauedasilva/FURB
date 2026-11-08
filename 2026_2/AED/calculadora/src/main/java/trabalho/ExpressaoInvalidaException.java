package trabalho;

public class ExpressaoInvalidaException extends RuntimeException {
    public ExpressaoInvalidaException() {
        super("Expressão inválida");
    }

    public ExpressaoInvalidaException(String message) {
        super(message);
    }
}
