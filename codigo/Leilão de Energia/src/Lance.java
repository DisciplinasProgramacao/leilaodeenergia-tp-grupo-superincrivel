public class Lance {
	private String nomeEmpresa;
    private int quantidadeEnergia;
    private int valor;

    public Lance(String nomeEmpresa, int quantidadeEnergia, int valor) {
        this.nomeEmpresa = nomeEmpresa;
        this.quantidadeEnergia = quantidadeEnergia;
        this.valor = valor;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public int getQuantidadeEnergia() {
        return quantidadeEnergia;
    }

    public int getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return nomeEmpresa + ": " + quantidadeEnergia + " MW, " + valor + " dinheiros";
    }
}