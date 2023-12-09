package Aplicacao;

public class QuickSort {

    void sort(Produto vetor[], int inicio, int fim) {
        if (inicio < fim) {
            int pi = particiona(vetor, inicio, fim); //Calcula a posição do pivô
            //Chama o sort duas vezes
            sort(vetor, inicio, pi - 1); //Ordena os elementos antes do pivô
            sort(vetor, pi + 1, fim); //Do elemento seguinte ao pivô até o fim do vetor
        }
    }

    int particiona(Produto vetor[], int inicio, int fim) {
        int esquerda = inicio;
        int direita = fim;
        Produto pivo = vetor[inicio]; //pivô é a posição de inicio do vetor

        while (esquerda < direita) {
            while (esquerda <= fim && vetor[esquerda].getPreco() <= pivo.getPreco()) { //Enquanto o elemento for menor que o pivô
                esquerda++; //Incrementa a posição
            }

            while (direita >= 0 && vetor[direita].getPreco() > pivo.getPreco()) { //Enquanto o elemento for maior que o pivô
                direita--; //Decrementa a posição
            }

            if (esquerda < direita) { //Se a posição da esquerda for menor que a da direita
                Produto aux = vetor[esquerda]; //Troca os elementos
                vetor[esquerda] = vetor[direita];
                vetor[direita] = aux;
            }
        }

        vetor[inicio] = vetor[direita];
        vetor[direita] = pivo;
        return direita;
    }

}