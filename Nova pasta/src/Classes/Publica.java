package Classes;

public class Publica extends Universidade {
    private int quantConcursados;

    public void maisUmConcursado(){
        quantConcursados ++;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Quantidade de concursados: " + this.quantConcursados);
    }

    public int getQuantConcursados() {
        return quantConcursados;
    }

    public void setQuantConcursados(int quantConcursados) {
        this.quantConcursados = quantConcursados;
    }

}
