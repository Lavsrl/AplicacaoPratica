package Aplicacao;

public class Carrinho {
    private Produto[] produtos;
    private ArvoreBinaria arvoreProduto;
    private QuickSort quickSort;

    private int contagemProduto;
    public Carrinho(int capacidade) {
        this.produtos = new Produto[capacidade];
        this.contagemProduto = 0;
        this.arvoreProduto = new ArvoreBinaria();
        this.quickSort = new QuickSort();
    }

    public void addProduto(Produto produto) {
        if (contagemProduto < produtos.length) {//Se o carrinho não estiver cheio
            this.produtos[contagemProduto++] = produto;

            quickSort.sort(produtos, 0, contagemProduto - 1); //Ordena o vetor de produtos

            this.arvoreProduto = new ArvoreBinaria();
            for (int i = 0; i < contagemProduto; i++) {
                this.arvoreProduto.Insere(produtos[i]); //Insere o vetor ordenado na árvore
            }
        }
    }

    public void mostrarCarrinho() {
        this.arvoreProduto.Imp_Ordem();
    }
}