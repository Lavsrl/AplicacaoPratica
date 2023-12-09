package Aplicacao;

public class MainComparacao {
    public static void main(String[] args) {
        int[] vetor = Arquivos.lerArquivo("L:\\Trabalho\\Trabalho\\src\\ArquivoDados\\dados100_mil.txt");
        int n = vetor.length;

        ArvoreBinaria tree = new ArvoreBinaria();

        for (int i = 0; i < n; i++) {
            tree.Insere(tree, vetor[i]);
        }

        double tempoInicial = System.currentTimeMillis();
        tree.Imp_Ordem(tree);


        double tempoFinal = System.currentTimeMillis();
        double tempoTotal = tempoFinal - tempoInicial;
        //Tempo marcado
        double segundos = tempoTotal / 1000.0;
        double miliSeg = segundos * 1000;

        int hr = (int) Math.floor(segundos / 3600);
        int min = (int) Math.floor((segundos % 3600) / 60);
        int seg = (int) Math.floor((segundos % 60));

        System.out.println("Tempo de execução: ");
        System.out.printf("%02d:%02d:%02d:%03d%n", hr, min, seg, (int) miliSeg);

    }
}
