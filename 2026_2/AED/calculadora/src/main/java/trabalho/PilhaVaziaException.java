package trabalho;

public class PilhaVaziaException extends RuntimeException {
    public PilhaVaziaException() {
        super("Pilha está vazia");
    }

    public PilhaVaziaException(String message) {
        super(message);
    }
}