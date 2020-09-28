package Classes;

public class Filme extends Produto {

    private String roteirista;

    public Filme(String tituloProduto, String genero, double valor, String roteirista) {
        super(tituloProduto, genero, valor);
        this.roteirista = roteirista;
    }

    public Filme(String tituloProduto, String genero, double valor, String roteirista, int id) {
        super(tituloProduto, genero, valor, id);
        this.roteirista = roteirista;
    }


    public String getRoteirista() {
        return roteirista;
    }

    public void setRoteirista(String roteirista) {
        this.roteirista = roteirista;
    }

    @Override
    public String defineTipo() {
        return "Filme";
    }
}
