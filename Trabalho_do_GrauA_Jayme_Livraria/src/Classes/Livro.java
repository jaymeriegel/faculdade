package Classes;

public class Livro extends Produto {

    private int numeroDePaginas;


    public Livro(String tituloProduto, String genero, double valor, int numeroDePaginas) {
        super(tituloProduto, genero, valor);
        this.numeroDePaginas = numeroDePaginas;
    }

    public Livro(String tituloProduto, String genero, double valor, int numeroDePaginas, int id) {
        super(tituloProduto, genero, valor, id);
        this.numeroDePaginas = numeroDePaginas;
    }

    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public String defineTipo() {
        return "Livro";
    }

    public void setNumeroDePaginas(int numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }
}
