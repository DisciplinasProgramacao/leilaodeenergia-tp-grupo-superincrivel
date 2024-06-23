import java.util.List;

public class VendedorDeEnergia {
    private int quantidadeEnergia;
    private List<Lance> lances;

    public VendedorDeEnergia(int quantidadeEnergia, List<Lance> lances) {
        this.quantidadeEnergia = quantidadeEnergia;
        this.lances = lances;
    }

    public void resolverBacktracking() {
        SolucionadorBacktracking sb = new SolucionadorBacktracking(quantidadeEnergia, lances);
        sb.resolver();
    }

    public void resolverGuloso(int estrategia) {
        SolucionadorGuloso sg = new SolucionadorGuloso(quantidadeEnergia, lances);
        if (estrategia == 1) {
            sg.resolverPorValor();
        } else {
            sg.resolverPorValorPorMegawatt();
        }
    }

    public void resolverDivisaoConquista() {
        SolucionadorDivisaoConquista sdc = new SolucionadorDivisaoConquista(quantidadeEnergia, lances);
        sdc.resolver();
    }

    public void resolverProgramacaoDinamica() {
        SolucionadorProgramacaoDinamica spd = new SolucionadorProgramacaoDinamica(quantidadeEnergia, lances);
        spd.resolver();
    }
}