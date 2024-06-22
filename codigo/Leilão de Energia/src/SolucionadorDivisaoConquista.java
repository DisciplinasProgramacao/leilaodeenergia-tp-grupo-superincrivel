import java.util.ArrayList;
import java.util.List;

public class SolucionadorDivisaoConquista {
    private int quantidadeEnergia;
    private List<Lance> lances;

    public SolucionadorDivisaoConquista(int quantidadeEnergia, List<Lance> lances) {
        this.quantidadeEnergia = quantidadeEnergia;
        this.lances = lances;
    }

    public void resolver() {
        long inicio = System.currentTimeMillis();

        List<Lance> solucao = resolverDivisaoConquista(lances);
        int valorTotal = solucao.stream().mapToInt(Lance::getValor).sum();

        long fim = System.currentTimeMillis();
        long tempoExecucao = fim - inicio;

        System.out.println("Tempo de execução da Divisão e Conquista: " + tempoExecucao + " ms");
        System.out.println("Valor total obtido: " + valorTotal);
        System.out.println("Lances escolhidos:");
        for (Lance lance : solucao) {
            System.out.println(lance);
        }
    }

    private List<Lance> resolverDivisaoConquista(List<Lance> lances) {
        if (lances.isEmpty()) {
            return new ArrayList<>();
        }

        if (lances.size() == 1) {
            Lance lance = lances.get(0);
            if (lance.getQuantidadeEnergia() <= quantidadeEnergia) {
                return List.of(lance);
            } else {
                return new ArrayList<>();
            }
        }

        int meio = lances.size() / 2;
        List<Lance> esquerda = lances.subList(0, meio);
        List<Lance> direita = lances.subList(meio, lances.size());

        List<Lance> solucaoEsquerda = resolverDivisaoConquista(esquerda);
        List<Lance> solucaoDireita = resolverDivisaoConquista(direita);

        int valorEsquerda = solucaoEsquerda.stream().mapToInt(Lance::getValor).sum();
        int valorDireita = solucaoDireita.stream().mapToInt(Lance::getValor).sum();

        return valorEsquerda > valorDireita ? solucaoEsquerda : solucaoDireita;
    }
}