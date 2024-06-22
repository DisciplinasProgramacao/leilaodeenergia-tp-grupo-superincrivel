import java.util.ArrayList;
import java.util.List;

public class SolucionadorBacktracking {
    private int quantidadeEnergia;
    private List<Lance> lances;
    private List<Lance> melhorSolucao;
    private int melhorValor;

    public SolucionadorBacktracking(int quantidadeEnergia, List<Lance> lances) {
        this.quantidadeEnergia = quantidadeEnergia;
        this.lances = lances;
        this.melhorSolucao = new ArrayList<>();
        this.melhorValor = 0;
    }

    public void resolver() {
        long inicio = System.currentTimeMillis();

        resolverBacktracking(new ArrayList<>(), 0, 0, 0);

        long fim = System.currentTimeMillis();
        long tempoExecucao = fim - inicio;

        System.out.println("Tempo de execução do Backtracking: " + tempoExecucao + " ms");
        System.out.println("Melhor valor obtido: " + melhorValor);
        System.out.println("Melhor combinação de lances:");
        for (Lance lance : melhorSolucao) {
            System.out.println(lance);
        }
    }

    private void resolverBacktracking(List<Lance> solucaoAtual, int valorAtual, int energiaAtual, int index) {
        if (energiaAtual > quantidadeEnergia) {
            return;
        }

        if (valorAtual > melhorValor) {
            melhorValor = valorAtual;
            melhorSolucao = new ArrayList<>(solucaoAtual);
        }

        for (int i = index; i < lances.size(); i++) {
            Lance lance = lances.get(i);
            solucaoAtual.add(lance);
            resolverBacktracking(solucaoAtual, valorAtual + lance.getValor(), energiaAtual + lance.getQuantidadeEnergia(), i + 1);
            solucaoAtual.remove(solucaoAtual.size() - 1);
        }
    }
}