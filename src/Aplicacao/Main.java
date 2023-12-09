package Aplicacao;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Carrinho carrinho = new Carrinho(100);
        Loja loja = new Loja(List.of(
                new Produto("Frutas", 5),
                new Produto("Cereais", 20),
                new Produto("Leite", 2),
                new Produto("Pão", 3),
                new Produto("Ovos", 4),
                new Produto("Queijo", 10),
                new Produto("Congelados", 15),
                new Produto("Carne", 20),
                new Produto("Presunto", 18),
                new Produto("Peixe", 12),
                new Produto("Arroz", 5),
                new Produto("Macarrão", 4)
        ));

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Bem vindo à lojinha, o que você deseja fazer?");
            System.out.println("1) Fazer a compra de um produto");
            System.out.println("2) Finalizar compra");
            System.out.print("Digite uma opção: ");
            int opcao = sc.nextInt();

            if (opcao == 1) {
                loja.mostrarProdutos();
                System.out.print("Digite o número referente ao produto que deseja comprar: ");
                int numeroProduto = sc.nextInt();
                Produto product = loja.getProduto(numeroProduto - 1); // -1 because the list is 0-indexed
                carrinho.addProduto(product);
            } else if (opcao == 2) {
                carrinho.mostrarCarrinho();
                break;
            }
        }

        sc.close();
    }
}