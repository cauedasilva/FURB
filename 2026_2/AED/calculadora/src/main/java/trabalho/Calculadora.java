package trabalho;

public class Calculadora {

    public Fila<String> extrairTermos(String expressao) {
        if (expressao == null) {
            throw new ExpressaoInvalidaException("Expressão não informada");
        }

        Fila<String> termos = new FilaLista<>();
        String ultimoTermo = null;
        int i = 0;

        while (i < expressao.length()) {
            char c = expressao.charAt(i);

            if (Character.isWhitespace(c)) {
                i++;
                continue;
            }

            boolean numeroNegativo = c == '-'
                    && i + 1 < expressao.length()
                    && Character.isDigit(expressao.charAt(i + 1))
                    && esperaOperando(ultimoTermo);

            if (Character.isDigit(c) || numeroNegativo) {
                int inicio = i;
                if (numeroNegativo) {
                    i++;
                }
                i = lerNumero(expressao, i);
                ultimoTermo = expressao.substring(inicio, i);
            } else if (ehOperador(String.valueOf(c)) || c == '(' || c == ')') {
                ultimoTermo = String.valueOf(c);
                i++;
            } else {
                throw new ExpressaoInvalidaException(
                        "Caractere inválido '" + c + "' na posição " + (i + 1));
            }

            termos.inserir(ultimoTermo);
        }

        if (termos.estaVazia()) {
            throw new ExpressaoInvalidaException("Expressão vazia");
        }

        return termos;
    }

    public Fila<String> gerarExprPosfixada(Fila<String> exprInfixada) {
        Pilha<String> pilha = new PilhaLista<>(); // pilha "B"
        Fila<String> posfixada = new FilaLista<>(); // fila "C"

        while (!exprInfixada.estaVazia()) {
            String termo = exprInfixada.retirar();

            if (termo.equals("(")) {
                pilha.push(termo);
            } else if (termo.equals(")")) {
                boolean achouAbertura = false;

                while (!pilha.estaVazia()) {
                    String topo = pilha.pop();
                    if (topo.equals("(")) {
                        achouAbertura = true;
                        break;
                    }
                    posfixada.inserir(topo);
                }

                if (!achouAbertura) {
                    throw new ExpressaoInvalidaException("Parêntese de fechamento sem abertura correspondente");
                }
            } else if (ehOperador(termo)) {
                while (!pilha.estaVazia()
                        && ehOperador(pilha.peek())
                        && precedencia(pilha.peek()) >= precedencia(termo)) {
                    posfixada.inserir(pilha.pop());
                }
                pilha.push(termo);
            } else {
                posfixada.inserir(termo);
            }
        }

        while (!pilha.estaVazia()) {
            String topo = pilha.pop();
            if (topo.equals("(")) {
                throw new ExpressaoInvalidaException("Parêntese de abertura sem fechamento correspondente");
            }
            posfixada.inserir(topo);
        }

        return posfixada;
    }

    public double calcularExprPosfixada(Fila<String> exprPosfixada) {
        Pilha<Double> pilha = new PilhaLista<>();

        while (!exprPosfixada.estaVazia()) {
            String termo = exprPosfixada.retirar();

            if (ehOperador(termo)) {
                if (pilha.estaVazia()) {
                    throw new ExpressaoInvalidaException("Faltam operandos para o operador " + termo);
                }
                double b = pilha.pop();

                if (pilha.estaVazia()) {
                    throw new ExpressaoInvalidaException("Faltam operandos para o operador " + termo);
                }
                double a = pilha.pop();

                pilha.push(aplicar(a, b, termo));
            } else {
                pilha.push(converterNumero(termo));
            }
        }

        if (pilha.estaVazia()) {
            throw new ExpressaoInvalidaException("Expressão sem operandos");
        }

        double resultado = pilha.pop();

        if (!pilha.estaVazia()) {
            throw new ExpressaoInvalidaException("Faltam operadores na expressão");
        }

        return resultado;
    }

    private int lerNumero(String expressao, int i) {
        while (i < expressao.length() && Character.isDigit(expressao.charAt(i))) {
            i++;
        }

        if (i < expressao.length() && expressao.charAt(i) == ',') {
            i++;
            if (i >= expressao.length() || !Character.isDigit(expressao.charAt(i))) {
                throw new ExpressaoInvalidaException("Número decimal mal formado na posição " + i);
            }
            while (i < expressao.length() && Character.isDigit(expressao.charAt(i))) {
                i++;
            }
        }

        if (i < expressao.length() && expressao.charAt(i) == ',') {
            throw new ExpressaoInvalidaException("Número com mais de uma vírgula na posição " + (i + 1));
        }

        return i;
    }

    private boolean esperaOperando(String ultimoTermo) {
        return ultimoTermo == null || ultimoTermo.equals("(") || ehOperador(ultimoTermo);
    }

    private boolean ehOperador(String termo) {
        return termo.equals("+") || termo.equals("-") || termo.equals("*") || termo.equals("/");
    }

    private int precedencia(String operador) {
        if (operador.equals("*") || operador.equals("/")) {
            return 2;
        }
        return 1; // + e -
    }

    private double converterNumero(String termo) {
        try {
            return Double.parseDouble(termo.replace(',', '.'));
        } catch (NumberFormatException e) {
            throw new ExpressaoInvalidaException("Operando inválido: " + termo);
        }
    }

    private double aplicar(double a, double b, String operador) {
        switch (operador) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            default:
                if (b == 0) {
                    throw new ArithmeticException("Divisão por zero");
                }
                return a / b;
        }
    }
}
