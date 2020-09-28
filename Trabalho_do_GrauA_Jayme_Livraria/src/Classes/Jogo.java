package Classes;

public class Jogo extends Produto {

    private int numeroDeFases;


    public Jogo(String tituloProduto, String genero, double valor, int numeroDeFases) {
        super(tituloProduto, genero, valor);
        this.numeroDeFases = numeroDeFases;
    }

    public Jogo(String tituloProduto, String genero, double valor, int numeroDeFases, int id) {
        super(tituloProduto, genero, valor, id);
        this.numeroDeFases = numeroDeFases;
    }

    @Override
    public String defineTipo() {
        return "Jogo";
    }

    public int getNumeroDeFases() {
        return numeroDeFases;
    }

    public void setNumeroDeFases(int numeroDeFases) {
        this.numeroDeFases = numeroDeFases;
    }
}
