import java.util.ArrayList;
import java.util.List;

public class Teste {

    public static void main(String[] args) {
        int tamanhoInicial = 10;
        int tamanhoMaximo = 100; // Tamanho máximo dos conjuntos (10 vezes o tamanho inicial)
        int incremento = 10; // Incremento de tamanho

        for (int tamanho = tamanhoInicial; tamanho <= tamanhoMaximo; tamanho += incremento) {
            System.out.println("Executando testes para conjuntos de tamanho: " + tamanho);

            // Gerar conjuntos de teste
            List<List<Lance>> conjuntosDeTeste = gerarConjuntosDeTeste(tamanho);

            // Testar Backtracking
            testarBacktracking(conjuntosDeTeste);

            // Testar Algoritmo Guloso
            testarAlgoritmoGuloso(conjuntosDeTeste);

            // Testar Programação Dinâmica
            testarProgramacaoDinamica(conjuntosDeTeste);

            // Testar Divisão e Conquista
            testarDivisaoConquista(conjuntosDeTeste);
        }
    }

    private static List<List<Lance>> gerarConjuntosDeTeste(int tamanho) {
        List<List<Lance>> conjuntosDeTeste = new ArrayList<>();
        for (int i = 0; i < 10; i++) { // Gerar 10 conjuntos de teste para cada tamanho
            List<Lance> lances = new ArrayList<>();
            // Exemplo simples: gerar lances com valores e quantidades de energia aleatórios
            for (int j = 0; j < tamanho; j++) {
                String nomeEmpresa = "Empresa" + j; // Exemplo de nome de empresa
                int valor = (int) (Math.random() * 100) + 1; // Valor entre 1 e 100
                int energia = (int) (Math.random() * 50) + 1; // Energia entre 1 e 50
                lances.add(new Lance(nomeEmpresa, energia, valor));
            }
            conjuntosDeTeste.add(lances);
        }
        return conjuntosDeTeste;
    }

    private static void testarBacktracking(List<List<Lance>> conjuntosDeTeste) {
        long tempoTotal = 0;
        int totalConjuntos = conjuntosDeTeste.size();

        for (List<Lance> lances : conjuntosDeTeste) {
            SolucionadorBacktracking solucionador = new SolucionadorBacktracking(100, lances);
            long inicio = System.currentTimeMillis();
            solucionador.resolver();
            long fim = System.currentTimeMillis();
            tempoTotal += fim - inicio;
        }

        long media = tempoTotal / totalConjuntos;
        System.out.println("Média de tempo de execução do Backtracking: " + media + " ms");
    }

    private static void testarAlgoritmoGuloso(List<List<Lance>> conjuntosDeTeste) {
        long tempoTotal = 0;
        int totalConjuntos = conjuntosDeTeste.size();

        for (List<Lance> lances : conjuntosDeTeste) {
            SolucionadorGuloso solucionador = new SolucionadorGuloso(100, lances);
            long inicio = System.currentTimeMillis();
            solucionador.resolverPorValor();
            long fim = System.currentTimeMillis();
            tempoTotal += fim - inicio;
        }

        long media = tempoTotal / totalConjuntos;
        System.out.println("Média de tempo de execução do Algoritmo Guloso: " + media + " ms");
    }

    private static void testarProgramacaoDinamica(List<List<Lance>> conjuntosDeTeste) {
        long tempoTotal = 0;
        int totalConjuntos = conjuntosDeTeste.size();

        for (List<Lance> lances : conjuntosDeTeste) {
            SolucionadorProgramacaoDinamica solucionador = new SolucionadorProgramacaoDinamica(100, lances);
            long inicio = System.currentTimeMillis();
            solucionador.resolver();
            long fim = System.currentTimeMillis();
            tempoTotal += fim - inicio;
        }

        long media = tempoTotal / totalConjuntos;
        System.out.println("Média de tempo de execução da Programação Dinâmica: " + media + " ms");
    }

    private static void testarDivisaoConquista(List<List<Lance>> conjuntosDeTeste) {
        long tempoTotal = 0;
        int totalConjuntos = conjuntosDeTeste.size();

        for (List<Lance> lances : conjuntosDeTeste) {
            SolucionadorDivisaoConquista solucionador = new SolucionadorDivisaoConquista(100, lances);
            long inicio = System.currentTimeMillis();
            solucionador.resolver();
            long fim = System.currentTimeMillis();
            tempoTotal += fim - inicio;
        }

        long media = tempoTotal / totalConjuntos;
        System.out.println("Média de tempo de execução da Divisão e Conquista: " + media + " ms");
    }
}