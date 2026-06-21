package com.caue;

import java.util.ArrayList;

public interface LancamentoRepositorio {
    ArrayList<Lancamento> carregarTodos();

    void salvarTodos(ArrayList<Lancamento> lancamentos);
}
