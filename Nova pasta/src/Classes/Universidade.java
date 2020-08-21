package Classes;

public class Universidade {
    private String nome;
    private String endereco;
    private int quantidadeAlunos;
    private int quantidadeProfessores;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getQuantidadeAlunos() {
        return quantidadeAlunos;
    }

    public void setQuantidadeAlunos(int quantidadeAlunos) {
        this.quantidadeAlunos = quantidadeAlunos;
    }

    public int getQuantidadeProfessores() {
        return quantidadeProfessores;
    }

    public void setQuantidadeProfessores(int quantidadeProfessores) {
        this.quantidadeProfessores = quantidadeProfessores;
    }

    public void print(){
        System.out.println("-- Informacoes da Universidade --");
        System.out.println("Nome: " + this.nome);
        System.out.println("Endereco: " + this.endereco);
        System.out.println("Quantidade de alunos: " + this.quantidadeAlunos);
        System.out.println("Quantidade de professores: " + this.quantidadeProfessores);
    }
}
