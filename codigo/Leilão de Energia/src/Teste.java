import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Teste {

    private static final int MAX_TEMPO_EXECUCAO_SEGUNDOS = 30;

    public static void main(String[] args) {
        // Gerar conjuntos de teste de tamanho crescente e executar cada algoritmo
        executarTestes();
    }

    private static void executarTestes() {
        // Definir o ponto de início (tamanho inicial dos conjuntos)
        int tamanhoInicial = 10;
        int tamanhoIncremento = 1;

        // Conjuntos para Backtracking
        List<List<Lance>> conjuntosBacktracking = gerarConjuntosCrescentes(tamanhoInicial, tamanhoIncremento, MAX_TEMPO_EXECUCAO_SEGUNDOS, new SolucionadorBacktracking(0, null));

        // Conjuntos para Algoritmo Guloso
        List<List<Lance>> conjuntosGuloso = aumentarConjuntos(conjuntosBacktracking, 10);

        // Conjuntos para Divisão e Conquista
        List<List<Lance>> conjuntosDivisaoConquista = conjuntosBacktracking;

        // Conjuntos para Programação Dinâmica
        List<List<Lance>> conjuntosProgramacaoDinamica = conjuntosGuloso;

        // Executar testes
        testarAlgoritmo("Backtracking", conjuntosBacktracking, (quantidadeEnergia, lances) -> new SolucionadorBacktracking(quantidadeEnergia, lances).resolver());
        testarAlgoritmo("Guloso por Valor Total", conjuntosGuloso, (quantidadeEnergia, lances) -> new SolucionadorGuloso(quantidadeEnergia, lances).resolverPorValor());
        testarAlgoritmo("Guloso por Valor por Megawatt", conjuntosGuloso, (quantidadeEnergia, lances) -> new SolucionadorGuloso(quantidadeEnergia, lances).resolverPorValorPorMegawatt());
        testarAlgoritmo("Divisão e Conquista", conjuntosDivisaoConquista, (quantidadeEnergia, lances) -> new SolucionadorDivisaoConquista(quantidadeEnergia, lances).resolver());
        testarAlgoritmo("Programação Dinâmica", conjuntosProgramacaoDinamica, (quantidadeEnergia, lances) -> new SolucionadorProgramacaoDinamica(quantidadeEnergia, lances).resolver());
    }

    private static List<List<Lance>> gerarConjuntosCrescentes(int tamanhoInicial, int incremento, int maxTempoSegundos, SolucionadorBacktracking backtracking) {
        List<List<Lance>> conjuntos = new ArrayList<>();
        Random random = new Random();

        int tamanho = tamanhoInicial;
        boolean dentroDoTempo = true;

        while (dentroDoTempo) {
            List<Lance> conjunto = gerarConjuntoLances(tamanho, random);
            long tempoInicio = System.currentTimeMillis();
            backtracking = new SolucionadorBacktracking(100, conjunto);
            backtracking.resolver();
            long tempoFim = System.currentTimeMillis();

            long tempoExecucao = (tempoFim - tempoInicio) / 1000; // Tempo em segundos

            if (tempoExecucao < maxTempoSegundos) {
                conjuntos.add(conjunto);
                tamanho += incremento;
            } else {
                dentroDoTempo = false;
            }
        }

        return conjuntos;
    }

    private static List<Lance> gerarConjuntoLances(int tamanho, Random random) {
        List<Lance> lances = new ArrayList<>();
        for (int i = 0; i < tamanho; i++) {
            int quantidadeEnergia = random.nextInt(50) + 1;
            int valor = random.nextInt(100) + 1;
            lances.add(new Lance("Empresa" + i, quantidadeEnergia, valor));
        }
        return lances;
    }

    private static List<List<Lance>> aumentarConjuntos(List<List<Lance>> conjuntosBase, int fatorAumento) {
        List<List<Lance>> conjuntosAumentados = new ArrayList<>();
        for (List<Lance> conjunto : conjuntosBase) {
            for (int i = 1; i <= fatorAumento; i++) {
                List<Lance> novoConjunto = new ArrayList<>(conjunto);
                conjuntosAumentados.add(novoConjunto);
            }
        }
        return conjuntosAumentados;
    }

    private static void testarAlgoritmo(String nomeAlgoritmo, List<List<Lance>> conjuntos, Algoritmo algoritmo) {
        System.out.println("Testando o algoritmo: " + nomeAlgoritmo);

        for (List<Lance> conjunto : conjuntos) {
            long tempoInicio = System.currentTimeMillis();
            algoritmo.executar(100, conjunto);
            long tempoFim = System.currentTimeMillis();
            long tempoExecucao = tempoFim - tempoInicio;

            System.out.println("Tempo de execução do " + nomeAlgoritmo + ": " + tempoExecucao + " ms");
        }

        System.out.println("==========================================");
    }

    @FunctionalInterface
    interface Algoritmo {
        void executar(int quantidadeEnergia, List<Lance> lances);
    }
}
