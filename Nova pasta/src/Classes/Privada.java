package Classes;

public class Privada extends Universidade {

    private double mensalidade;

    public double getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(double mensalidade) {
        this.mensalidade = mensalidade;
    }

    public void adicionaValor(double valor) {
        mensalidade += valor;
    }

    @Override
    public void print() {
        super.print();
        System.out.printf("Valor da mensalidade: %.2f" , this.mensalidade);
    }
}
