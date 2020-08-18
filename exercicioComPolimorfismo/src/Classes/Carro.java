package Classes;

public class Carro extends Veiculo {

    private int anoFabricacao;

    public Carro(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Carro(double velocidadeMax, double preco, int anoFabricacao) {
        super(velocidadeMax, preco);
        this.anoFabricacao = anoFabricacao;
    }

    @Override
    public void imprimeInfos() {
        super.imprimeInfos();
        System.out.println("Ano de fabricacao: " + this.anoFabricacao);
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }
}
