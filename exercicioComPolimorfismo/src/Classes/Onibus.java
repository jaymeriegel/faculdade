package Classes;

public class Onibus extends Veiculo {
    private int capacidadePassageiros;

    public Onibus(int capacidadePassageiros) {
        this.capacidadePassageiros = capacidadePassageiros;
    }

    public Onibus(double velocidadeMax, double preco, int capacidadePassageiros) {
        super(velocidadeMax, preco);
        this.capacidadePassageiros = capacidadePassageiros;
    }

    @Override
    public void imprimeInfos() {
        super.imprimeInfos();
        System.out.println("Capacidade de passageiros: "+ this.capacidadePassageiros);
    }

    public int getCapacidadePassageiros() {
        return capacidadePassageiros;
    }

    public void setCapacidadePassageiros(int capacidadePassageiros) {
        this.capacidadePassageiros = capacidadePassageiros;
    }
}
