package trabalho;

public class FilaVaziaException extends RuntimeException {
    public FilaVaziaException() {
        super("Fila está vazia");
    }

    public FilaVaziaException(String message) {
        super(message);
    }
}