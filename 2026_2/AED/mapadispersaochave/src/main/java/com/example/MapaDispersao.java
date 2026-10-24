public class MapaDispersao<K, T> {
    private ListaEncadeada<NoMapa<K, T>>[] info;
    private int quantidade;

    @SuppressWarnings("unchecked")
    public MapaDispersao(int tamanho) {
        if (tamanho <= 0) throw new IllegalArgumentException("Tamanho deve ser > 0");
        info = new ListaEncadeada[tamanho];
        for (int i = 0; i < tamanho; i++) {
            info[i] = new ListaEncadeada<>();
        }
    }

    private int calcularHash(K chave) {
        int h;
        if (chave instanceof Integer) {
            h = (Integer) chave;
        } else if (chave instanceof String) {
            h = gerarCodigo((String) chave);
        } else {
            h = chave.hashCode();
        }
        return (h & 0x7FFFFFFF) % info.length;
    }

    private int gerarCodigo(String texto) {
        final long MAX = Integer.MAX_VALUE;
        int n = texto.length() - 1;
        long h = 0;
        long potencia = 1;

        for (int c = n; c >= 0; c--) { 
            char caractere = texto.charAt(c);
            int codigo = mapear(caractere);
            h = (h + codigo * potencia) % MAX;
            potencia = (potencia * 26) % MAX;
        }
        return (int) h;
    }

    private int mapear(char caractere) {
        char c = Character.toUpperCase(caractere);
        if (c >= 'A' && c <= 'Z') {
            return c - 'A' + 1;
        }
        return c;
    }

    public void inserir(K chave, T valor) {
        int indice = calcularHash(chave);
        NoMapa<K, T> novo = new NoMapa<>(chave, valor);
        NoLista<NoMapa<K, T>> existente = info[indice].buscar(novo);
        if (existente != null) {
            existente.getInfo().setValor(valor);
        } else {
            info[indice].inserir(novo);
            quantidade++;
        }
    }

    public void remover(K chave) {
        int indice = calcularHash(chave);
        if (info[indice].retirar(new NoMapa<>(chave, null))) {
            quantidade--;
        }
    }

    public T buscar(K chave) {
        int indice = calcularHash(chave);
        NoLista<NoMapa<K, T>> no = info[indice].buscar(new NoMapa<>(chave, null));
        return (no == null) ? null : no.getInfo().getValor();
    }

    public double calcularFatorCarga() {
        return (double) quantidade / info.length;
    }
}