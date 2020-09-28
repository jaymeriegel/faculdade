package Classes;

import java.util.Random;

public abstract class Produto {

    private int id;
    private String tipoProduto;
    private String tituloProduto;
    private String genero;
    private double valor;

    public Produto(){

    }

    public Produto(String tituloProduto, String genero, double valor) {
        this.tipoProduto = defineTipo();
        this.id = sorteiaID();
        this.tituloProduto = tituloProduto;
        this.genero = genero;
        this.valor = valor;
    }

    public Produto(String tituloProduto, String genero, double valor, int id) {
        this.tipoProduto = defineTipo();
        this.id = id;
        this.tituloProduto = tituloProduto;
        this.genero = genero;
        this.valor = valor;
    }



    private int sorteiaID(){
        Random sorteio = new Random();
        return sorteio.nextInt(1000000);
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public String getTituloProduto() {
        return tituloProduto;
    }

    public void setTituloProduto(String tituloProduto) {
        this.tituloProduto = tituloProduto;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public String defineTipo(){
        return "Generico";
    }


}
