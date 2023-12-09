package Aplicacao;

public class QuickSort {

    void sort(int vetor[], int inicio, int fim) {
        if (inicio < fim) {
            int pi = particiona(vetor, inicio, fim); //Calcula a posição do pivô
            //Chama o sort duas vezes
            sort(vetor, inicio, pi - 1); //Ordena os elementos antes do pivô
            sort(vetor, pi + 1, fim); //Do elemento seguinte ao pivô até o fim do vetor
        }
    }

    int particiona(int vetor[], int inicio, int fim) {
        int esq = inicio;
        int dir = fim;
        int pivo = vetor[inicio];

        while (esq < dir) {
            while (esq <= fim && vetor[esq] <= pivo) {
                esq++;
            }

            while (dir >= 0 && vetor[dir] > pivo) {
                dir--;
            }

            if (esq < dir) {
                int aux = vetor[esq];
                vetor[esq] = vetor[dir];
                vetor[dir] = aux;
            }
        }

        vetor[inicio] = vetor[dir];
        vetor[dir] = pivo;
        return dir;
    }

}


