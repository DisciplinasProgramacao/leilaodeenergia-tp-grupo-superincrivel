import java.util.ArrayList;
import java.util.List;

public class SolucionadorDivisaoConquista {
    private int quantidadeEnergia;
    private List<Lance> lances;
    private List<Lance> melhorSolucao;
    private int melhorValor;

    public SolucionadorDivisaoConquista(int quantidadeEnergia, List<Lance> lances) {
        this.quantidadeEnergia = quantidadeEnergia;
        this.lances = lances;
        this.melhorSolucao = new ArrayList<>();
        this.melhorValor = 0;
    }

    public void resolver() {
        long inicio = System.currentTimeMillis();

        melhorSolucao = resolverDivisaoConquista(lances, quantidadeEnergia);
        melhorValor = melhorSolucao.stream().mapToInt(Lance::getValor).sum();

        long fim = System.currentTimeMillis();
        long tempoExecucao = fim - inicio;

        System.out.println("Tempo de execução da Divisão e Conquista: " + tempoExecucao + " ms");
        System.out.println("Valor total obtido: " + melhorValor);
        System.out.println("Melhor combinação de lances:");
        for (Lance lance : melhorSolucao) {
            System.out.println(lance);
        }
    }

    private List<Lance> resolverDivisaoConquista(List<Lance> lances, int energiaDisponivel) {
        // Base case: if no lances or no energy available, return an empty list
        if (energiaDisponivel <= 0 || lances.isEmpty()) {
            return new ArrayList<>();
        }

        // Base case: if only one lance, check if it fits within the available energy
        if (lances.size() == 1) {
            Lance lance = lances.get(0);
            if (lance.getQuantidadeEnergia() <= energiaDisponivel) {
                return List.of(lance);
            } else {
                return new ArrayList<>();
            }
        }

        // Divide: split the list into two halves
        int meio = lances.size() / 2;
        List<Lance> esquerda = lances.subList(0, meio);
        List<Lance> direita = lances.subList(meio, lances.size());

        // Conquer: solve each half recursively
        List<Lance> melhorSolucaoEsquerda = resolverDivisaoConquista(esquerda, energiaDisponivel);
        int energiaRestante = energiaDisponivel - melhorSolucaoEsquerda.stream().mapToInt(Lance::getQuantidadeEnergia).sum();
        List<Lance> melhorSolucaoDireita = resolverDivisaoConquista(direita, energiaRestante);

        // Combine: merge the solutions from both halves
        List<Lance> melhorSolucaoCombinada = new ArrayList<>(melhorSolucaoEsquerda);
        melhorSolucaoCombinada.addAll(melhorSolucaoDireita);

        return melhorSolucaoCombinada;
    }
}