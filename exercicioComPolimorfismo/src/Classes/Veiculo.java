package Classes;

public class Veiculo {

    private double velocidadeMax;
    private double preco;

    public Veiculo() {

    }

    public Veiculo(double velocidadeMax, double preco) {
        this.velocidadeMax = velocidadeMax;
        this.preco = preco;
    }

    public void imprimeInfos() {
        System.out.println("-- Informacoes do veiculo --");
        System.out.printf("Velocidade Maxima: %.1f", this.velocidadeMax, "\n");
        System.out.println();
        System.out.printf("Preço: %.2f", this.preco, "\n");
        System.out.println();
    }

    public double getVelocidadeMax() {
        return velocidadeMax;
    }

    public void setVelocidadeMax(double velocidadeMax) {
        this.velocidadeMax = velocidadeMax;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
