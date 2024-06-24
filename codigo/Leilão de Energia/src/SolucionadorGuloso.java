import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SolucionadorGuloso {
    private int quantidadeEnergia;
    private List<Lance> lances;

    public SolucionadorGuloso(int quantidadeEnergia, List<Lance> lances) {
        this.quantidadeEnergia = quantidadeEnergia;
        this.lances = lances;
    }

    public void resolverPorValor() {
        long startTime = System.currentTimeMillis(); 

        List<Lance> lancesOrdenados = new ArrayList<>(lances);
        Collections.sort(lancesOrdenados, new Comparator<Lance>() {
            @Override
            public int compare(Lance l1, Lance l2) {
                return Integer.compare(l2.getValor(), l1.getValor());
            }
        });

        int energiaRestante = quantidadeEnergia;
        int valorTotal = 0;
        List<Lance> solucao = new ArrayList<>();

        for (Lance lance : lancesOrdenados) {
            if (energiaRestante >= lance.getQuantidadeEnergia()) {
                energiaRestante -= lance.getQuantidadeEnergia();
                valorTotal += lance.getValor();
                solucao.add(lance);
            }
        }

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime; 

        System.out.println("Tempo de execução do Algoritmo guloso: " + totalTime + " ms");
        System.out.println("Valor total obtido: " + valorTotal);
        System.out.println("Lances escolhidos:");
        for (Lance lance : solucao) {
            System.out.println(lance);
        }
    }

    public void resolverPorValorPorMegawatt() {
        long startTime = System.currentTimeMillis(); 

        List<Lance> lancesOrdenados = new ArrayList<>(lances);
        Collections.sort(lancesOrdenados, new Comparator<Lance>() {
            @Override
            public int compare(Lance l1, Lance l2) {
                double valorPorMegawatt1 = (double) l1.getValor() / l1.getQuantidadeEnergia();
                double valorPorMegawatt2 = (double) l2.getValor() / l2.getQuantidadeEnergia();
                return Double.compare(valorPorMegawatt2, valorPorMegawatt1);
            }
        });

        int energiaRestante = quantidadeEnergia;
        int valorTotal = 0;
        List<Lance> solucao = new ArrayList<>();

        for (Lance lance : lancesOrdenados) {
            if (energiaRestante >= lance.getQuantidadeEnergia()) {
                energiaRestante -= lance.getQuantidadeEnergia();
                valorTotal += lance.getValor();
                solucao.add(lance);
            }
        }

        long endTime = System.currentTimeMillis(); 
        long totalTime = endTime - startTime;

        System.out.println("Tempo de execução do Algoritmo guloso: " + totalTime + " ms");
        System.out.println("Valor total obtido: " + valorTotal);
        System.out.println("Lances escolhidos:");
        for (Lance lance : solucao) {
            System.out.println(lance);
        }
    }
}