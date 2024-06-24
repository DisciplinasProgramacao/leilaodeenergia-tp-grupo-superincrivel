import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Teste {

    public static void main(String[] args) {
        int[] tamanhos = {10, 20, 30, 40, 50}; // Tamanhos dos conjuntos de teste
        int numeroDeExecucoes = 10; // Número de vezes que cada teste será executado

        for (int tamanho : tamanhos) {
            System.out.println("Testando para tamanho: " + tamanho);

            List<Lance> lances = gerarLancesAleatorios(tamanho);
            VendedorDeEnergia vendedor = new VendedorDeEnergia(1000, lances);

            // Teste de Backtracking
            testarBacktracking(vendedor, numeroDeExecucoes);

            // Teste de Algoritmo Guloso (duas estratégias)
            testarGuloso(vendedor, numeroDeExecucoes, 1);
            testarGuloso(vendedor, numeroDeExecucoes, 2);

            // Teste de Divisão e Conquista
            testarDivisaoConquista(vendedor, numeroDeExecucoes);

            // Teste de Programação Dinâmica
            testarProgramacaoDinamica(vendedor, numeroDeExecucoes);

            System.out.println();
        }
    }

    private static List<Lance> gerarLancesAleatorios(int tamanho) {
        Random random = new Random();
        List<Lance> lances = new ArrayList<>();
        for (int i = 1; i <= tamanho; i++) {
            int quantidade = random.nextInt(500) + 100; // Quantidade entre 100 e 599 MW
            int valor = random.nextInt(1000) + 100; // Valor entre 100 e 1099 dinheiros
            lances.add(new Lance("Empresa " + i, quantidade, valor));
        }
        return lances;
    }

    private static void testarBacktracking(VendedorDeEnergia vendedor, int numeroDeExecucoes) {
        long tempoTotal = 0;

        for (int i = 0; i < numeroDeExecucoes; i++) {
            long inicio = System.currentTimeMillis();
            vendedor.resolverBacktracking();
            long fim = System.currentTimeMillis();
            tempoTotal += (fim - inicio);
        }

        System.out.println("Média de tempo do Backtracking: " + (tempoTotal / numeroDeExecucoes) + " ms");
    }

    private static void testarGuloso(VendedorDeEnergia vendedor, int numeroDeExecucoes, int estrategia) {
        long tempoTotal = 0;

        for (int i = 0; i < numeroDeExecucoes; i++) {
            long inicio = System.currentTimeMillis();
            vendedor.resolverGuloso(estrategia);
            long fim = System.currentTimeMillis();
            tempoTotal += (fim - inicio);
        }

        String nomeEstrategia = (estrategia == 1) ? "Por valor" : "Por valor por MW";
        System.out.println("Média de tempo do Algoritmo Guloso (" + nomeEstrategia + "): " + (tempoTotal / numeroDeExecucoes) + " ms");
    }

    private static void testarDivisaoConquista(VendedorDeEnergia vendedor, int numeroDeExecucoes) {
        long tempoTotal = 0;

        for (int i = 0; i < numeroDeExecucoes; i++) {
            long inicio = System.currentTimeMillis();
            vendedor.resolverDivisaoConquista();
            long fim = System.currentTimeMillis();
            tempoTotal += (fim - inicio);
        }

        System.out.println("Média de tempo da Divisão e Conquista: " + (tempoTotal / numeroDeExecucoes) + " ms");
    }

    private static void testarProgramacaoDinamica(VendedorDeEnergia vendedor, int numeroDeExecucoes) {
        long tempoTotal = 0;

        for (int i = 0; i < numeroDeExecucoes; i++) {
            long inicio = System.currentTimeMillis();
            vendedor.resolverProgramacaoDinamica();
            long fim = System.currentTimeMillis();
            tempoTotal += (fim - inicio);
        }

        System.out.println("Média de tempo da Programação Dinâmica: " + (tempoTotal / numeroDeExecucoes) + " ms");
    }
}