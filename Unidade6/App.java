import java.util.Arrays;

public class App {
    public App() {
        int vetor[] = new int[5];
        vetor[0] = 1;
        String vetorString[] = new String[10];
        for (int i = 0; i < vetorString.length; i++) {
            vetorString[i] = "" + i;
        }
        System.out.println(vetor[0]);
        System.out.println(Arrays.toString(vetor));
        System.out.println(Arrays.toString(vetorString));
    }

    public static void main(String[] args) {
        new App();    
    }
}
