import java.util.ArrayList;
import java.util.List;

public class SolucionadorProgramacaoDinamica {
    private int quantidadeEnergia;
    private List<Lance> lances;

    public SolucionadorProgramacaoDinamica(int quantidadeEnergia, List<Lance> lances) {
        this.quantidadeEnergia = quantidadeEnergia;
        this.lances = lances;
    }

    public void resolver() {
        long startTime = System.currentTimeMillis(); // Captura o tempo de início da execução

        int n = lances.size();
        int[] dp = new int[quantidadeEnergia + 1];
        int[][] solucao = new int[n + 1][quantidadeEnergia + 1];

        for (int i = 1; i <= n; i++) {
            Lance lance = lances.get(i - 1);
            for (int j = quantidadeEnergia; j >= lance.getQuantidadeEnergia(); j--) {
                int valor = lance.getValor();
                if (dp[j] < dp[j - lance.getQuantidadeEnergia()] + valor) {
                    dp[j] = dp[j - lance.getQuantidadeEnergia()] + valor;
                    solucao[i][j] = 1;
                }
            }
        }

        List<Lance> lancesEscolhidos = new ArrayList<>();
        int w = quantidadeEnergia;
        for (int i = n; i > 0 && w > 0; i--) {
            if (solucao[i][w] == 1) {
                Lance lance = lances.get(i - 1);
                lancesEscolhidos.add(lance);
                w -= lance.getQuantidadeEnergia();
            }
        }

        int valorTotal = dp[quantidadeEnergia];
        long endTime = System.currentTimeMillis(); // Captura o tempo de fim da execução
        long tempoExecucao = endTime - startTime; // Calcula o tempo total de execução em milissegundos

        System.out.println("Tempo de execução da Programação Dinâmica: " + tempoExecucao + " ms");
        System.out.println("Valor total obtido: " + valorTotal);
        System.out.println("Lances escolhidos:");
        for (Lance lance : lancesEscolhidos) {
            System.out.println(lance);
        }
    }
}