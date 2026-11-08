package trabalho;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculadora c = new Calculadora();

        System.out.println("=== Resolvedor de expressões aritméticas ===");
        System.out.println("Operadores: + - * /   Parênteses: ( )   Decimais com vírgula (ex.: 3,5)");
        System.out.println("Deixe em branco ou digite 'sair' para encerrar.");

        while (true) {
            System.out.println();
            System.out.print("Expressão: ");

            if (!scanner.hasNextLine()) {
                break;
            }
            String expressao = scanner.nextLine();

            if (expressao.isBlank() || expressao.trim().equalsIgnoreCase("sair")) {
                break;
            }

            try {
                Fila<String> termosInfixada = c.extrairTermos(expressao);
                System.out.println("Termos:     " + descrever(termosInfixada));

                Fila<String> termosPosfixada = c.gerarExprPosfixada(termosInfixada);
                System.out.println("Pós-fixada: " + descrever(termosPosfixada));

                double resultado = c.calcularExprPosfixada(termosPosfixada);
                System.out.println("Resultado:  " + formatar(resultado));
            } catch (ExpressaoInvalidaException | ArithmeticException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        System.out.println("Encerrado.");
        scanner.close();
    }

    private static String descrever(Fila<String> fila) {
        Fila<String> auxiliar = new FilaLista<>();
        String texto = "";

        while (!fila.estaVazia()) {
            String termo = fila.retirar();
            texto += termo + " ";
            auxiliar.inserir(termo);
        }

        while (!auxiliar.estaVazia()) {
            fila.inserir(auxiliar.retirar());
        }

        return texto.trim();
    }

    private static String formatar(double valor) {
        DecimalFormat formato = new DecimalFormat("0.##########",
                DecimalFormatSymbols.getInstance(Locale.of("pt", "BR")));
        return formato.format(valor);
    }
}
