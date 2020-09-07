package Classes;

public class Candidato {
    private String nome;
    private String partido;
    private int intencoesDeVoto;

    public Candidato(){

    }

    public Candidato(String nome, String partido, int intencoesDeVoto) {
        this.nome = nome;
        this.partido = partido;
        this.intencoesDeVoto = intencoesDeVoto;
    }

    public void somaPonto(){
        this.intencoesDeVoto ++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public void setIntencoesDeVoto(int intencoesDeVoto) {
        this.intencoesDeVoto = intencoesDeVoto;
    }

    public int getIntencoesDeVoto() {
        return intencoesDeVoto;
    }
}
