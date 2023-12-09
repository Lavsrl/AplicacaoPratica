package Aplicacao;

public class ArvoreBinaria {
    private Produto produto;
    private ArvoreBinaria esquerda;
    private ArvoreBinaria direita;

    public void Insere(Produto produto) {
        if (this.produto == null) {
            this.produto = produto; // Insere na raiz
        } else if (produto.getPreco() <= this.produto.getPreco()) { // Insere na esquerda
            if (this.esquerda == null) {
                this.esquerda = new ArvoreBinaria();
            }
            this.esquerda.Insere(produto);
        } else {
            if (this.direita == null) {
                this.direita = new ArvoreBinaria();
            }
            this.direita.Insere(produto);
        }
    }

    public void Imp_Ordem() {
        if (this.esquerda != null) {
            this.esquerda.Imp_Ordem();
        }
        if (this.produto != null) {
            System.out.println(this.produto.getNome() + ": $" + this.produto.getPreco());
        }
        if (this.direita != null) {
            this.direita.Imp_Ordem();
        }
    }
}