package Aplicacao;

import java.util.List;

public class Loja {
    private List<Produto> produtos;

    public Loja(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public void mostrarProdutos() {
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println((i + 1) + ") " + produtos.get(i).getNome() + ": $" + produtos.get(i).getPreco());
        }
    }

    public Produto getProduto(int index) {
        return produtos.get(index);
    }
}